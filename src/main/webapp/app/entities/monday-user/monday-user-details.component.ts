import { Component, Vue, Inject } from 'vue-property-decorator';

import { IMondayUser } from '@/shared/model/monday-user.model';
import MondayUserService from './monday-user.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class MondayUserDetails extends Vue {
  @Inject('mondayUserService') private mondayUserService: () => MondayUserService;
  @Inject('alertService') private alertService: () => AlertService;

  public mondayUser: IMondayUser = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.mondayUserId) {
        vm.retrieveMondayUser(to.params.mondayUserId);
      }
    });
  }

  public retrieveMondayUser(mondayUserId) {
    this.mondayUserService()
      .find(mondayUserId)
      .then(res => {
        this.mondayUser = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
