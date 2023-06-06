import { Component, Vue, Inject } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';

import { IInspection, Inspection } from '@/shared/model/inspection.model';
import InspectionService from './inspection.service';

const validations: any = {
  inspection: {
    itemName: {},
    itemId: {},
    boardId: {},
    kingdeeId: {},
    supplierName: {},
    email: {},
    inspectionDate: {},
    endOfProductionDate: {},
    cateGory: {},
    technicalFile: {},
    qCResult: {},
    docStatus: {},
    goodsReadyForPickUpDate: {},
    inspectionType: {},
    inspectionBookingStatus: {},
  },
};

@Component({
  validations,
})
export default class InspectionUpdate extends Vue {
  @Inject('inspectionService') private inspectionService: () => InspectionService;
  @Inject('alertService') private alertService: () => AlertService;

  public inspection: IInspection = new Inspection();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.inspectionId) {
        vm.retrieveInspection(to.params.inspectionId);
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
    if (this.inspection.id) {
      this.inspectionService()
        .update(this.inspection)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterSampleApplicationApp.inspection.updated', { param: param.id });
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
      this.inspectionService()
        .create(this.inspection)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterSampleApplicationApp.inspection.created', { param: param.id });
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

  public retrieveInspection(inspectionId): void {
    this.inspectionService()
      .find(inspectionId)
      .then(res => {
        this.inspection = res;
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
