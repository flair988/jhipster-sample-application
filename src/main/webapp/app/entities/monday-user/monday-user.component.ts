import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IMondayUser } from '@/shared/model/monday-user.model';

import MondayUserService from './monday-user.service';
import AlertService from '@/shared/alert/alert.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class MondayUser extends Vue {
  @Inject('mondayUserService') private mondayUserService: () => MondayUserService;
  @Inject('alertService') private alertService: () => AlertService;

  private removeId: number = null;

  public mondayUsers: IMondayUser[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllMondayUsers();
  }

  public clear(): void {
    this.retrieveAllMondayUsers();
  }

  public retrieveAllMondayUsers(): void {
    this.isFetching = true;
    this.mondayUserService()
      .retrieve()
      .then(
        res => {
          this.mondayUsers = res.data;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
          this.alertService().showHttpError(this, err.response);
        }
      );
  }

  public handleSyncList(): void {
    this.clear();
  }

  public prepareRemove(instance: IMondayUser): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeMondayUser(): void {
    this.mondayUserService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('jhipsterSampleApplicationApp.mondayUser.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllMondayUsers();
        this.closeDialog();
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
