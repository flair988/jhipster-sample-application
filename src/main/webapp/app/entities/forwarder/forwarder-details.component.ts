import { Component, Vue, Inject } from 'vue-property-decorator';

import { IForwarder } from '@/shared/model/forwarder.model';
import ForwarderService from './forwarder.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class ForwarderDetails extends Vue {
  @Inject('forwarderService') private forwarderService: () => ForwarderService;
  @Inject('alertService') private alertService: () => AlertService;

  public forwarder: IForwarder = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.forwarderId) {
        vm.retrieveForwarder(to.params.forwarderId);
      }
    });
  }

  public retrieveForwarder(forwarderId) {
    this.forwarderService()
      .find(forwarderId)
      .then(res => {
        this.forwarder = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
