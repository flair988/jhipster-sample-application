import { Component, Vue, Inject } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';

import { ISalesDelivery, SalesDelivery } from '@/shared/model/sales-delivery.model';
import SalesDeliveryService from './sales-delivery.service';

const validations: any = {
  salesDelivery: {
    itemName: {},
    itemId: {},
    boardId: {},
    kingdeeId: {},
    customer: {},
    orderDate: {},
    totalActualShipQty: {},
    totalQtyDelivery: {},
    loadingPort: {},
    dischargePort: {},
    transportMode: {},
    incoterm: {},
    forwarder: {},
    eta: {},
    etd: {},
    containerType: {},
    containerSize: {},
    remark: {},
    kingdeeUniqueId: {},
  },
};

@Component({
  validations,
})
export default class SalesDeliveryUpdate extends Vue {
  @Inject('salesDeliveryService') private salesDeliveryService: () => SalesDeliveryService;
  @Inject('alertService') private alertService: () => AlertService;

  public salesDelivery: ISalesDelivery = new SalesDelivery();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.salesDeliveryId) {
        vm.retrieveSalesDelivery(to.params.salesDeliveryId);
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
    if (this.salesDelivery.id) {
      this.salesDeliveryService()
        .update(this.salesDelivery)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterSampleApplicationApp.salesDelivery.updated', { param: param.id });
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
      this.salesDeliveryService()
        .create(this.salesDelivery)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterSampleApplicationApp.salesDelivery.created', { param: param.id });
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

  public retrieveSalesDelivery(salesDeliveryId): void {
    this.salesDeliveryService()
      .find(salesDeliveryId)
      .then(res => {
        this.salesDelivery = res;
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
