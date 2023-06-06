import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IForwarderBooking } from '@/shared/model/forwarder-booking.model';

import ForwarderBookingService from './forwarder-booking.service';
import AlertService from '@/shared/alert/alert.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class ForwarderBooking extends Vue {
  @Inject('forwarderBookingService') private forwarderBookingService: () => ForwarderBookingService;
  @Inject('alertService') private alertService: () => AlertService;

  private removeId: number = null;

  public forwarderBookings: IForwarderBooking[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllForwarderBookings();
  }

  public clear(): void {
    this.retrieveAllForwarderBookings();
  }

  public retrieveAllForwarderBookings(): void {
    this.isFetching = true;
    this.forwarderBookingService()
      .retrieve()
      .then(
        res => {
          this.forwarderBookings = res.data;
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

  public prepareRemove(instance: IForwarderBooking): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeForwarderBooking(): void {
    this.forwarderBookingService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('jhipsterSampleApplicationApp.forwarderBooking.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllForwarderBookings();
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
