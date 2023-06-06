import { Component, Vue, Inject } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';

import { IProductTaxmonomy, ProductTaxmonomy } from '@/shared/model/product-taxmonomy.model';
import ProductTaxmonomyService from './product-taxmonomy.service';

const validations: any = {
  productTaxmonomy: {
    itemId: {},
    kingdeeId: {},
    itemName: {},
    groupName: {},
    parentGroupName: {},
    subGroupName: {},
    description: {},
    boardId: {},
  },
};

@Component({
  validations,
})
export default class ProductTaxmonomyUpdate extends Vue {
  @Inject('productTaxmonomyService') private productTaxmonomyService: () => ProductTaxmonomyService;
  @Inject('alertService') private alertService: () => AlertService;

  public productTaxmonomy: IProductTaxmonomy = new ProductTaxmonomy();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.productTaxmonomyId) {
        vm.retrieveProductTaxmonomy(to.params.productTaxmonomyId);
      }
    });
  }

  created(): void {
    this.currentLanguage = this.$store.getters.currentLanguage;
    this.$store.watch(
      () => this.$store.getters.currentLanguage,
      () => {
        this.currentLanguage = this.$store.getters.currentLanguage;
      }
    );
  }

  public save(): void {
    this.isSaving = true;
    if (this.productTaxmonomy.id) {
      this.productTaxmonomyService()
        .update(this.productTaxmonomy)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterSampleApplicationApp.productTaxmonomy.updated', { param: param.id });
          return (this.$root as any).$bvToast.toast(message.toString(), {
            toaster: 'b-toaster-top-center',
            title: 'Info',
            variant: 'info',
            solid: true,
            autoHideDelay: 5000,
          });
        })
        .catch(error => {
          this.isSaving = false;
          this.alertService().showHttpError(this, error.response);
        });
    } else {
      this.productTaxmonomyService()
        .create(this.productTaxmonomy)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterSampleApplicationApp.productTaxmonomy.created', { param: param.id });
          (this.$root as any).$bvToast.toast(message.toString(), {
            toaster: 'b-toaster-top-center',
            title: 'Success',
            variant: 'success',
            solid: true,
            autoHideDelay: 5000,
          });
        })
        .catch(error => {
          this.isSaving = false;
          this.alertService().showHttpError(this, error.response);
        });
    }
  }

  public retrieveProductTaxmonomy(productTaxmonomyId): void {
    this.productTaxmonomyService()
      .find(productTaxmonomyId)
      .then(res => {
        this.productTaxmonomy = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
