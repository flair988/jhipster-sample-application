import { Component, Vue, Inject } from 'vue-property-decorator';

import { IProcessLog } from '@/shared/model/process-log.model';
import ProcessLogService from './process-log.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class ProcessLogDetails extends Vue {
  @Inject('processLogService') private processLogService: () => ProcessLogService;
  @Inject('alertService') private alertService: () => AlertService;

  public processLog: IProcessLog = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.processLogId) {
        vm.retrieveProcessLog(to.params.processLogId);
      }
    });
  }

  public retrieveProcessLog(processLogId) {
    this.processLogService()
      .find(processLogId)
      .then(res => {
        this.processLog = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
