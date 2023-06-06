import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IOrderFollowUp } from '@/shared/model/order-follow-up.model';

import OrderFollowUpService from './order-follow-up.service';
import AlertService from '@/shared/alert/alert.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class OrderFollowUp extends Vue {
  @Inject('orderFollowUpService') private orderFollowUpService: () => OrderFollowUpService;
  @Inject('alertService') private alertService: () => AlertService;

  private removeId: number = null;

  public orderFollowUps: IOrderFollowUp[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllOrderFollowUps();
  }

  public clear(): void {
    this.retrieveAllOrderFollowUps();
  }

  public retrieveAllOrderFollowUps(): void {
    this.isFetching = true;
    this.orderFollowUpService()
      .retrieve()
      .then(
        res => {
          this.orderFollowUps = res.data;
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

  public prepareRemove(instance: IOrderFollowUp): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeOrderFollowUp(): void {
    this.orderFollowUpService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('jhipsterSampleApplicationApp.orderFollowUp.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllOrderFollowUps();
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
