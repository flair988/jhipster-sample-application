import { Component, Vue, Inject } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';

import { IProcessLog, ProcessLog } from '@/shared/model/process-log.model';
import ProcessLogService from './process-log.service';

const validations: any = {
  processLog: {
    type: {},
    request: {},
    response: {},
    status: {},
    reason: {},
    processStartTime: {},
    processEndTime: {},
  },
};

@Component({
  validations,
})
export default class ProcessLogUpdate extends Vue {
  @Inject('processLogService') private processLogService: () => ProcessLogService;
  @Inject('alertService') private alertService: () => AlertService;

  public processLog: IProcessLog = new ProcessLog();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.processLogId) {
        vm.retrieveProcessLog(to.params.processLogId);
      }
    });
  }

  created(): void {
    this.currentLanguage = this.$store.getters.currentLanguage;
    this.$store.watch(
      () => this.$store.getters.currentLanguage,
      () => {
        this.currentLanguage = this.$store.getters.currentLanguage;
      }
    );
  }

  public save(): void {
    this.isSaving = true;
    if (this.processLog.id) {
      this.processLogService()
        .update(this.processLog)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterSampleApplicationApp.processLog.updated', { param: param.id });
          return (this.$root as any).$bvToast.toast(message.toString(), {
            toaster: 'b-toaster-top-center',
            title: 'Info',
            variant: 'info',
            solid: true,
            autoHideDelay: 5000,
          });
        })
        .catch(error => {
          this.isSaving = false;
          this.alertService().showHttpError(this, error.response);
        });
    } else {
      this.processLogService()
        .create(this.processLog)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterSampleApplicationApp.processLog.created', { param: param.id });
          (this.$root as any).$bvToast.toast(message.toString(), {
            toaster: 'b-toaster-top-center',
            title: 'Success',
            variant: 'success',
            solid: true,
            autoHideDelay: 5000,
          });
        })
        .catch(error => {
          this.isSaving = false;
          this.alertService().showHttpError(this, error.response);
        });
    }
  }

  public retrieveProcessLog(processLogId): void {
    this.processLogService()
      .find(processLogId)
      .then(res => {
        this.processLog = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
