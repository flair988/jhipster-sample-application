import { Component, Vue, Inject } from 'vue-property-decorator';

import { ISalesDelivery } from '@/shared/model/sales-delivery.model';
import SalesDeliveryService from './sales-delivery.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class SalesDeliveryDetails extends Vue {
  @Inject('salesDeliveryService') private salesDeliveryService: () => SalesDeliveryService;
  @Inject('alertService') private alertService: () => AlertService;

  public salesDelivery: ISalesDelivery = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.salesDeliveryId) {
        vm.retrieveSalesDelivery(to.params.salesDeliveryId);
      }
    });
  }

  public retrieveSalesDelivery(salesDeliveryId) {
    this.salesDeliveryService()
      .find(salesDeliveryId)
      .then(res => {
        this.salesDelivery = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
