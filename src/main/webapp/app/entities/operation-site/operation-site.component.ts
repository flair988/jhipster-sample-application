import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IOperationSite } from '@/shared/model/operation-site.model';

import OperationSiteService from './operation-site.service';
import AlertService from '@/shared/alert/alert.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class OperationSite extends Vue {
  @Inject('operationSiteService') private operationSiteService: () => OperationSiteService;
  @Inject('alertService') private alertService: () => AlertService;

  private removeId: number = null;

  public operationSites: IOperationSite[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllOperationSites();
  }

  public clear(): void {
    this.retrieveAllOperationSites();
  }

  public retrieveAllOperationSites(): void {
    this.isFetching = true;
    this.operationSiteService()
      .retrieve()
      .then(
        res => {
          this.operationSites = res.data;
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

  public prepareRemove(instance: IOperationSite): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeOperationSite(): void {
    this.operationSiteService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('jhipsterSampleApplicationApp.operationSite.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllOperationSites();
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
