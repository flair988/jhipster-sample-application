import { Component, Vue, Inject } from 'vue-property-decorator';

import { IPI } from '@/shared/model/pi.model';
import PIService from './pi.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class PIDetails extends Vue {
  @Inject('pIService') private pIService: () => PIService;
  @Inject('alertService') private alertService: () => AlertService;

  public pI: IPI = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.pIId) {
        vm.retrievePI(to.params.pIId);
      }
    });
  }

  public retrievePI(pIId) {
    this.pIService()
      .find(pIId)
      .then(res => {
        this.pI = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
