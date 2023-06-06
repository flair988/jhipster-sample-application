import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IForwarder } from '@/shared/model/forwarder.model';

import ForwarderService from './forwarder.service';
import AlertService from '@/shared/alert/alert.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class Forwarder extends Vue {
  @Inject('forwarderService') private forwarderService: () => ForwarderService;
  @Inject('alertService') private alertService: () => AlertService;

  private removeId: number = null;

  public forwarders: IForwarder[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllForwarders();
  }

  public clear(): void {
    this.retrieveAllForwarders();
  }

  public retrieveAllForwarders(): void {
    this.isFetching = true;
    this.forwarderService()
      .retrieve()
      .then(
        res => {
          this.forwarders = res.data;
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

  public prepareRemove(instance: IForwarder): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeForwarder(): void {
    this.forwarderService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('jhipsterSampleApplicationApp.forwarder.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllForwarders();
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
