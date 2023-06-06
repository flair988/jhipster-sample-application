import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IInspection } from '@/shared/model/inspection.model';

import InspectionService from './inspection.service';
import AlertService from '@/shared/alert/alert.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class Inspection extends Vue {
  @Inject('inspectionService') private inspectionService: () => InspectionService;
  @Inject('alertService') private alertService: () => AlertService;

  private removeId: number = null;

  public inspections: IInspection[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllInspections();
  }

  public clear(): void {
    this.retrieveAllInspections();
  }

  public retrieveAllInspections(): void {
    this.isFetching = true;
    this.inspectionService()
      .retrieve()
      .then(
        res => {
          this.inspections = res.data;
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

  public prepareRemove(instance: IInspection): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeInspection(): void {
    this.inspectionService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('jhipsterSampleApplicationApp.inspection.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllInspections();
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
