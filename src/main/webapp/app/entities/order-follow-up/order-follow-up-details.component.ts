import { Component, Vue, Inject } from 'vue-property-decorator';

import { IOrderFollowUp } from '@/shared/model/order-follow-up.model';
import OrderFollowUpService from './order-follow-up.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class OrderFollowUpDetails extends Vue {
  @Inject('orderFollowUpService') private orderFollowUpService: () => OrderFollowUpService;
  @Inject('alertService') private alertService: () => AlertService;

  public orderFollowUp: IOrderFollowUp = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.orderFollowUpId) {
        vm.retrieveOrderFollowUp(to.params.orderFollowUpId);
      }
    });
  }

  public retrieveOrderFollowUp(orderFollowUpId) {
    this.orderFollowUpService()
      .find(orderFollowUpId)
      .then(res => {
        this.orderFollowUp = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
