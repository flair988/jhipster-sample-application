import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IProductFinished } from '@/shared/model/product-finished.model';

import ProductFinishedService from './product-finished.service';
import AlertService from '@/shared/alert/alert.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class ProductFinished extends Vue {
  @Inject('productFinishedService') private productFinishedService: () => ProductFinishedService;
  @Inject('alertService') private alertService: () => AlertService;

  private removeId: number = null;

  public productFinisheds: IProductFinished[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllProductFinisheds();
  }

  public clear(): void {
    this.retrieveAllProductFinisheds();
  }

  public retrieveAllProductFinisheds(): void {
    this.isFetching = true;
    this.productFinishedService()
      .retrieve()
      .then(
        res => {
          this.productFinisheds = res.data;
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

  public prepareRemove(instance: IProductFinished): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeProductFinished(): void {
    this.productFinishedService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('jhipsterSampleApplicationApp.productFinished.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllProductFinisheds();
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
