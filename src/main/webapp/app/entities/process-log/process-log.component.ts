import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IProcessLog } from '@/shared/model/process-log.model';

import ProcessLogService from './process-log.service';
import AlertService from '@/shared/alert/alert.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class ProcessLog extends Vue {
  @Inject('processLogService') private processLogService: () => ProcessLogService;
  @Inject('alertService') private alertService: () => AlertService;

  private removeId: number = null;

  public processLogs: IProcessLog[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllProcessLogs();
  }

  public clear(): void {
    this.retrieveAllProcessLogs();
  }

  public retrieveAllProcessLogs(): void {
    this.isFetching = true;
    this.processLogService()
      .retrieve()
      .then(
        res => {
          this.processLogs = res.data;
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

  public prepareRemove(instance: IProcessLog): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeProcessLog(): void {
    this.processLogService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('jhipsterSampleApplicationApp.processLog.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllProcessLogs();
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
