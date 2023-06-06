import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IMondayColumn } from '@/shared/model/monday-column.model';

import MondayColumnService from './monday-column.service';
import AlertService from '@/shared/alert/alert.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class MondayColumn extends Vue {
  @Inject('mondayColumnService') private mondayColumnService: () => MondayColumnService;
  @Inject('alertService') private alertService: () => AlertService;

  private removeId: number = null;

  public mondayColumns: IMondayColumn[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllMondayColumns();
  }

  public clear(): void {
    this.retrieveAllMondayColumns();
  }

  public retrieveAllMondayColumns(): void {
    this.isFetching = true;
    this.mondayColumnService()
      .retrieve()
      .then(
        res => {
          this.mondayColumns = res.data;
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

  public prepareRemove(instance: IMondayColumn): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeMondayColumn(): void {
    this.mondayColumnService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('jhipsterSampleApplicationApp.mondayColumn.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllMondayColumns();
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
