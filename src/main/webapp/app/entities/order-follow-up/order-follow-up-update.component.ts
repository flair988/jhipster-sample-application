import { Component, Vue, Inject } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';

import { IOrderFollowUp, OrderFollowUp } from '@/shared/model/order-follow-up.model';
import OrderFollowUpService from './order-follow-up.service';

const validations: any = {
  orderFollowUp: {
    itemId: {},
    poNumber: {},
    customer: {},
    supplier: {},
    orderDate: {},
    cateGory: {},
    inspectionDate: {},
    requestEndOfProdDate: {},
    totalAmount: {},
    totalDiscount: {},
    disCountRate: {},
    regularCheck: {},
    etd: {},
    atd: {},
    eta: {},
    updatedEta: {},
    forwarder: {},
    documentStatus: {},
    customInstruction: {},
    customInspection: {},
    depositPaymentDate: {},
    balanceOfTotalPaymentDate: {},
    amountDepositPayment: {},
    amountPayment: {},
    dcMember: {},
    comment: {},
    itemName: {},
    boardId: {},
    kingdeeId: {},
    parentKingdeeId: {},
    parentMondayId: {},
    qty: {},
    itemCode: {},
    amount: {},
    discount: {},
    unit: {},
    contractEndOfProdDate: {},
  },
};

@Component({
  validations,
})
export default class OrderFollowUpUpdate extends Vue {
  @Inject('orderFollowUpService') private orderFollowUpService: () => OrderFollowUpService;
  @Inject('alertService') private alertService: () => AlertService;

  public orderFollowUp: IOrderFollowUp = new OrderFollowUp();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.orderFollowUpId) {
        vm.retrieveOrderFollowUp(to.params.orderFollowUpId);
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
    if (this.orderFollowUp.id) {
      this.orderFollowUpService()
        .update(this.orderFollowUp)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterSampleApplicationApp.orderFollowUp.updated', { param: param.id });
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
      this.orderFollowUpService()
        .create(this.orderFollowUp)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterSampleApplicationApp.orderFollowUp.created', { param: param.id });
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

  public retrieveOrderFollowUp(orderFollowUpId): void {
    this.orderFollowUpService()
      .find(orderFollowUpId)
      .then(res => {
        this.orderFollowUp = res;
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
