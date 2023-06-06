import { Component, Vue, Inject } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';

import { ICommercialInvoice, CommercialInvoice } from '@/shared/model/commercial-invoice.model';
import CommercialInvoiceService from './commercial-invoice.service';

const validations: any = {
  commercialInvoice: {
    itemName: {},
    itemId: {},
    boardId: {},
    kingdeeId: {},
    date: {},
    client: {},
    cateGory: {},
    totalPrice: {},
    currency: {},
    remarks: {},
  },
};

@Component({
  validations,
})
export default class CommercialInvoiceUpdate extends Vue {
  @Inject('commercialInvoiceService') private commercialInvoiceService: () => CommercialInvoiceService;
  @Inject('alertService') private alertService: () => AlertService;

  public commercialInvoice: ICommercialInvoice = new CommercialInvoice();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.commercialInvoiceId) {
        vm.retrieveCommercialInvoice(to.params.commercialInvoiceId);
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
    if (this.commercialInvoice.id) {
      this.commercialInvoiceService()
        .update(this.commercialInvoice)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterSampleApplicationApp.commercialInvoice.updated', { param: param.id });
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
      this.commercialInvoiceService()
        .create(this.commercialInvoice)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterSampleApplicationApp.commercialInvoice.created', { param: param.id });
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

  public retrieveCommercialInvoice(commercialInvoiceId): void {
    this.commercialInvoiceService()
      .find(commercialInvoiceId)
      .then(res => {
        this.commercialInvoice = res;
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
