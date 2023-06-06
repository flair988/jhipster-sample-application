import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IPI } from '@/shared/model/pi.model';

import PIService from './pi.service';
import AlertService from '@/shared/alert/alert.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class PI extends Vue {
  @Inject('pIService') private pIService: () => PIService;
  @Inject('alertService') private alertService: () => AlertService;

  private removeId: number = null;

  public pIS: IPI[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllPIs();
  }

  public clear(): void {
    this.retrieveAllPIs();
  }

  public retrieveAllPIs(): void {
    this.isFetching = true;
    this.pIService()
      .retrieve()
      .then(
        res => {
          this.pIS = res.data;
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

  public prepareRemove(instance: IPI): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removePI(): void {
    this.pIService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('jhipsterSampleApplicationApp.pI.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllPIs();
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
