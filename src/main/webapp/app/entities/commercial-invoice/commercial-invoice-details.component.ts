import { Component, Vue, Inject } from 'vue-property-decorator';

import { ICommercialInvoice } from '@/shared/model/commercial-invoice.model';
import CommercialInvoiceService from './commercial-invoice.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class CommercialInvoiceDetails extends Vue {
  @Inject('commercialInvoiceService') private commercialInvoiceService: () => CommercialInvoiceService;
  @Inject('alertService') private alertService: () => AlertService;

  public commercialInvoice: ICommercialInvoice = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.commercialInvoiceId) {
        vm.retrieveCommercialInvoice(to.params.commercialInvoiceId);
      }
    });
  }

  public retrieveCommercialInvoice(commercialInvoiceId) {
    this.commercialInvoiceService()
      .find(commercialInvoiceId)
      .then(res => {
        this.commercialInvoice = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
