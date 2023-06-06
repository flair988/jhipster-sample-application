import { Component, Vue, Inject } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';

import { IProductFinished, ProductFinished } from '@/shared/model/product-finished.model';
import ProductFinishedService from './product-finished.service';

const validations: any = {
  productFinished: {
    itemName: {},
    itemId: {},
    boardId: {},
    kingdeeId: {},
    supplier: {},
    supplierEmail: {},
    orderDate: {},
    cateGory: {},
    remark: {},
    materialReceiptDate: {},
  },
};

@Component({
  validations,
})
export default class ProductFinishedUpdate extends Vue {
  @Inject('productFinishedService') private productFinishedService: () => ProductFinishedService;
  @Inject('alertService') private alertService: () => AlertService;

  public productFinished: IProductFinished = new ProductFinished();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.productFinishedId) {
        vm.retrieveProductFinished(to.params.productFinishedId);
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
    if (this.productFinished.id) {
      this.productFinishedService()
        .update(this.productFinished)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterSampleApplicationApp.productFinished.updated', { param: param.id });
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
      this.productFinishedService()
        .create(this.productFinished)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterSampleApplicationApp.productFinished.created', { param: param.id });
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

  public retrieveProductFinished(productFinishedId): void {
    this.productFinishedService()
      .find(productFinishedId)
      .then(res => {
        this.productFinished = res;
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
