import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IProductTaxmonomy } from '@/shared/model/product-taxmonomy.model';

import ProductTaxmonomyService from './product-taxmonomy.service';
import AlertService from '@/shared/alert/alert.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class ProductTaxmonomy extends Vue {
  @Inject('productTaxmonomyService') private productTaxmonomyService: () => ProductTaxmonomyService;
  @Inject('alertService') private alertService: () => AlertService;

  private removeId: number = null;

  public productTaxmonomies: IProductTaxmonomy[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllProductTaxmonomys();
  }

  public clear(): void {
    this.retrieveAllProductTaxmonomys();
  }

  public retrieveAllProductTaxmonomys(): void {
    this.isFetching = true;
    this.productTaxmonomyService()
      .retrieve()
      .then(
        res => {
          this.productTaxmonomies = res.data;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
          this.alertService().showHttpError(this, err.response);
        }
      );
  }

  public handleSyncList(): void {
    this.clear();
  }

  public prepareRemove(instance: IProductTaxmonomy): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeProductTaxmonomy(): void {
    this.productTaxmonomyService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('jhipsterSampleApplicationApp.productTaxmonomy.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllProductTaxmonomys();
        this.closeDialog();
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
