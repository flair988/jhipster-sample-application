import { Component, Vue, Inject } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';

import { IForwarderBooking, ForwarderBooking } from '@/shared/model/forwarder-booking.model';
import ForwarderBookingService from './forwarder-booking.service';

const validations: any = {
  forwarderBooking: {
    itemName: {},
    itemId: {},
    boardId: {},
    kingdeeId: {},
    customer: {},
    orderDate: {},
    forwarder: {},
    totalQty: {},
    loadingPort: {},
    dischargePort: {},
    containerType: {},
    containerSize: {},
    containerNumber: {},
    supplier: {},
    supplierEmail: {},
    eta: {},
    etd: {},
    transportMode: {},
    numberOfCartons: {},
    numberOfRef: {},
    totalVolume: {},
    totalWeight: {},
    remark: {},
    client: {},
    kingdeeUniqueId: {},
  },
};

@Component({
  validations,
})
export default class ForwarderBookingUpdate extends Vue {
  @Inject('forwarderBookingService') private forwarderBookingService: () => ForwarderBookingService;
  @Inject('alertService') private alertService: () => AlertService;

  public forwarderBooking: IForwarderBooking = new ForwarderBooking();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.forwarderBookingId) {
        vm.retrieveForwarderBooking(to.params.forwarderBookingId);
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
    if (this.forwarderBooking.id) {
      this.forwarderBookingService()
        .update(this.forwarderBooking)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterSampleApplicationApp.forwarderBooking.updated', { param: param.id });
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
      this.forwarderBookingService()
        .create(this.forwarderBooking)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterSampleApplicationApp.forwarderBooking.created', { param: param.id });
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

  public retrieveForwarderBooking(forwarderBookingId): void {
    this.forwarderBookingService()
      .find(forwarderBookingId)
      .then(res => {
        this.forwarderBooking = res;
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
