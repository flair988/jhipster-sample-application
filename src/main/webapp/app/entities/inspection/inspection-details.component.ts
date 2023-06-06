import { Component, Vue, Inject } from 'vue-property-decorator';

import { IInspection } from '@/shared/model/inspection.model';
import InspectionService from './inspection.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class InspectionDetails extends Vue {
  @Inject('inspectionService') private inspectionService: () => InspectionService;
  @Inject('alertService') private alertService: () => AlertService;

  public inspection: IInspection = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.inspectionId) {
        vm.retrieveInspection(to.params.inspectionId);
      }
    });
  }

  public retrieveInspection(inspectionId) {
    this.inspectionService()
      .find(inspectionId)
      .then(res => {
        this.inspection = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
