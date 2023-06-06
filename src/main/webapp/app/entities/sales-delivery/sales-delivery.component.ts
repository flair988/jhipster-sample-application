import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { ISalesDelivery } from '@/shared/model/sales-delivery.model';

import SalesDeliveryService from './sales-delivery.service';
import AlertService from '@/shared/alert/alert.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class SalesDelivery extends Vue {
  @Inject('salesDeliveryService') private salesDeliveryService: () => SalesDeliveryService;
  @Inject('alertService') private alertService: () => AlertService;

  private removeId: number = null;

  public salesDeliveries: ISalesDelivery[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllSalesDeliverys();
  }

  public clear(): void {
    this.retrieveAllSalesDeliverys();
  }

  public retrieveAllSalesDeliverys(): void {
    this.isFetching = true;
    this.salesDeliveryService()
      .retrieve()
      .then(
        res => {
          this.salesDeliveries = res.data;
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

  public prepareRemove(instance: ISalesDelivery): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeSalesDelivery(): void {
    this.salesDeliveryService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('jhipsterSampleApplicationApp.salesDelivery.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllSalesDeliverys();
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
