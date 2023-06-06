import { Component, Vue, Inject } from 'vue-property-decorator';

import { IMondayColumn } from '@/shared/model/monday-column.model';
import MondayColumnService from './monday-column.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class MondayColumnDetails extends Vue {
  @Inject('mondayColumnService') private mondayColumnService: () => MondayColumnService;
  @Inject('alertService') private alertService: () => AlertService;

  public mondayColumn: IMondayColumn = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.mondayColumnId) {
        vm.retrieveMondayColumn(to.params.mondayColumnId);
      }
    });
  }

  public retrieveMondayColumn(mondayColumnId) {
    this.mondayColumnService()
      .find(mondayColumnId)
      .then(res => {
        this.mondayColumn = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
