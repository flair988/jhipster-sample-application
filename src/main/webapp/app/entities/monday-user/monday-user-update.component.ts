import { Component, Vue, Inject } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';

import { IMondayUser, MondayUser } from '@/shared/model/monday-user.model';
import MondayUserService from './monday-user.service';

const validations: any = {
  mondayUser: {
    mondayId: {},
    name: {},
    email: {},
    url: {},
  },
};

@Component({
  validations,
})
export default class MondayUserUpdate extends Vue {
  @Inject('mondayUserService') private mondayUserService: () => MondayUserService;
  @Inject('alertService') private alertService: () => AlertService;

  public mondayUser: IMondayUser = new MondayUser();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.mondayUserId) {
        vm.retrieveMondayUser(to.params.mondayUserId);
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
    if (this.mondayUser.id) {
      this.mondayUserService()
        .update(this.mondayUser)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterSampleApplicationApp.mondayUser.updated', { param: param.id });
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
      this.mondayUserService()
        .create(this.mondayUser)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterSampleApplicationApp.mondayUser.created', { param: param.id });
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

  public retrieveMondayUser(mondayUserId): void {
    this.mondayUserService()
      .find(mondayUserId)
      .then(res => {
        this.mondayUser = res;
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
