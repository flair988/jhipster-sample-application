import { Component, Vue, Inject } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';

import { IPI, PI } from '@/shared/model/pi.model';
import PIService from './pi.service';

const validations: any = {
  pI: {
    itemName: {},
    itemCode: {},
    poNumber: {},
    isNewItem: {},
    category: {},
    client: {},
    supplier: {},
    supplierCode: {},
    orderDate: {},
    port: {},
    requestedEndOfProdDate: {},
    itemQuantity: {},
    countryOfOrigin: {},
    countryOfFinalDestination: {},
    productionLeadTimeCommitment: {},
    consignee: {},
    carriageBy: {},
    termsOfDelivery: {},
    termsOfPayment: {},
    itemUnit: {},
    rate: {},
    amount: {},
    totalAmount: {},
    discountRate: {},
    currency: {},
    piStatus: {},
    remarks: {},
    itemId: {},
    boardId: {},
    kingdeeId: {},
    portOfDischarge: {},
    portOfLoading: {},
  },
};

@Component({
  validations,
})
export default class PIUpdate extends Vue {
  @Inject('pIService') private pIService: () => PIService;
  @Inject('alertService') private alertService: () => AlertService;

  public pI: IPI = new PI();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.pIId) {
        vm.retrievePI(to.params.pIId);
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
    if (this.pI.id) {
      this.pIService()
        .update(this.pI)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterSampleApplicationApp.pI.updated', { param: param.id });
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
      this.pIService()
        .create(this.pI)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterSampleApplicationApp.pI.created', { param: param.id });
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

  public retrievePI(pIId): void {
    this.pIService()
      .find(pIId)
      .then(res => {
        this.pI = res;
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
