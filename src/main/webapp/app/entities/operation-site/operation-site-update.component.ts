import { Component, Vue, Inject } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';

import { IOperationSite, OperationSite } from '@/shared/model/operation-site.model';
import OperationSiteService from './operation-site.service';

const validations: any = {
  operationSite: {
    itemName: {},
    linkSupplierFactory: {},
    typeOfSite: {},
    contact: {},
    siteAddress: {},
    cateGory: {},
    country: {},
    boardId: {},
    kingdeeId: {},
    itemId: {},
    businessLicense: {},
    sasDate: {},
    iso900ValidUtil: {},
    iso14001ValidUtil: {},
    attributeLor: {},
    siteQualification: {},
    qualificationScore: {},
    pqvScore: {},
    pqvDate: {},
    pqvDecision: {},
    technicalAuditDate: {},
    technicalAuditScore: {},
    thirdRdPartyDate: {},
    thirdRdPartyScore: {},
    bopeDate: {},
    bopeScore: {},
    capRequired: {},
  },
};

@Component({
  validations,
})
export default class OperationSiteUpdate extends Vue {
  @Inject('operationSiteService') private operationSiteService: () => OperationSiteService;
  @Inject('alertService') private alertService: () => AlertService;

  public operationSite: IOperationSite = new OperationSite();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.operationSiteId) {
        vm.retrieveOperationSite(to.params.operationSiteId);
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
    if (this.operationSite.id) {
      this.operationSiteService()
        .update(this.operationSite)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterSampleApplicationApp.operationSite.updated', { param: param.id });
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
      this.operationSiteService()
        .create(this.operationSite)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterSampleApplicationApp.operationSite.created', { param: param.id });
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

  public retrieveOperationSite(operationSiteId): void {
    this.operationSiteService()
      .find(operationSiteId)
      .then(res => {
        this.operationSite = res;
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
