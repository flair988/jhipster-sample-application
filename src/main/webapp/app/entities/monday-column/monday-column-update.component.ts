import { Component, Vue, Inject } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';

import { IMondayColumn, MondayColumn } from '@/shared/model/monday-column.model';
import MondayColumnService from './monday-column.service';

const validations: any = {
  mondayColumn: {
    boardId: {},
    columnId: {},
    title: {},
    type: {},
  },
};

@Component({
  validations,
})
export default class MondayColumnUpdate extends Vue {
  @Inject('mondayColumnService') private mondayColumnService: () => MondayColumnService;
  @Inject('alertService') private alertService: () => AlertService;

  public mondayColumn: IMondayColumn = new MondayColumn();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.mondayColumnId) {
        vm.retrieveMondayColumn(to.params.mondayColumnId);
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
    if (this.mondayColumn.id) {
      this.mondayColumnService()
        .update(this.mondayColumn)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterSampleApplicationApp.mondayColumn.updated', { param: param.id });
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
      this.mondayColumnService()
        .create(this.mondayColumn)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterSampleApplicationApp.mondayColumn.created', { param: param.id });
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

  public retrieveMondayColumn(mondayColumnId): void {
    this.mondayColumnService()
      .find(mondayColumnId)
      .then(res => {
        this.mondayColumn = res;
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
