import { Component, Vue, Inject } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';

import { IForwarder, Forwarder } from '@/shared/model/forwarder.model';
import ForwarderService from './forwarder.service';

const validations: any = {
  forwarder: {
    itemName: {},
    itemId: {},
    boardId: {},
    kingdeeId: {},
    contact: {},
    email: {},
    telephone: {},
  },
};

@Component({
  validations,
})
export default class ForwarderUpdate extends Vue {
  @Inject('forwarderService') private forwarderService: () => ForwarderService;
  @Inject('alertService') private alertService: () => AlertService;

  public forwarder: IForwarder = new Forwarder();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.forwarderId) {
        vm.retrieveForwarder(to.params.forwarderId);
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
    if (this.forwarder.id) {
      this.forwarderService()
        .update(this.forwarder)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterSampleApplicationApp.forwarder.updated', { param: param.id });
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
      this.forwarderService()
        .create(this.forwarder)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterSampleApplicationApp.forwarder.created', { param: param.id });
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

  public retrieveForwarder(forwarderId): void {
    this.forwarderService()
      .find(forwarderId)
      .then(res => {
        this.forwarder = res;
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
