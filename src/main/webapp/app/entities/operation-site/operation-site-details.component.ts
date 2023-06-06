import { Component, Vue, Inject } from 'vue-property-decorator';

import { IOperationSite } from '@/shared/model/operation-site.model';
import OperationSiteService from './operation-site.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class OperationSiteDetails extends Vue {
  @Inject('operationSiteService') private operationSiteService: () => OperationSiteService;
  @Inject('alertService') private alertService: () => AlertService;

  public operationSite: IOperationSite = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.operationSiteId) {
        vm.retrieveOperationSite(to.params.operationSiteId);
      }
    });
  }

  public retrieveOperationSite(operationSiteId) {
    this.operationSiteService()
      .find(operationSiteId)
      .then(res => {
        this.operationSite = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
