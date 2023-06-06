import { Component, Vue, Inject } from 'vue-property-decorator';

import { IForwarderBooking } from '@/shared/model/forwarder-booking.model';
import ForwarderBookingService from './forwarder-booking.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class ForwarderBookingDetails extends Vue {
  @Inject('forwarderBookingService') private forwarderBookingService: () => ForwarderBookingService;
  @Inject('alertService') private alertService: () => AlertService;

  public forwarderBooking: IForwarderBooking = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.forwarderBookingId) {
        vm.retrieveForwarderBooking(to.params.forwarderBookingId);
      }
    });
  }

  public retrieveForwarderBooking(forwarderBookingId) {
    this.forwarderBookingService()
      .find(forwarderBookingId)
      .then(res => {
        this.forwarderBooking = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
