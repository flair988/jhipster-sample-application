import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { ICommercialInvoice } from '@/shared/model/commercial-invoice.model';

import CommercialInvoiceService from './commercial-invoice.service';
import AlertService from '@/shared/alert/alert.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class CommercialInvoice extends Vue {
  @Inject('commercialInvoiceService') private commercialInvoiceService: () => CommercialInvoiceService;
  @Inject('alertService') private alertService: () => AlertService;

  private removeId: number = null;

  public commercialInvoices: ICommercialInvoice[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllCommercialInvoices();
  }

  public clear(): void {
    this.retrieveAllCommercialInvoices();
  }

  public retrieveAllCommercialInvoices(): void {
    this.isFetching = true;
    this.commercialInvoiceService()
      .retrieve()
      .then(
        res => {
          this.commercialInvoices = res.data;
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

  public prepareRemove(instance: ICommercialInvoice): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeCommercialInvoice(): void {
    this.commercialInvoiceService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('jhipsterSampleApplicationApp.commercialInvoice.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllCommercialInvoices();
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
