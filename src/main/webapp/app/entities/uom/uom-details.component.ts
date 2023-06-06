import { Component, Vue, Inject } from 'vue-property-decorator';

import { IUom } from '@/shared/model/uom.model';
import UomService from './uom.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class UomDetails extends Vue {
  @Inject('uomService') private uomService: () => UomService;
  @Inject('alertService') private alertService: () => AlertService;

  public uom: IUom = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.uomId) {
        vm.retrieveUom(to.params.uomId);
      }
    });
  }

  public retrieveUom(uomId) {
    this.uomService()
      .find(uomId)
      .then(res => {
        this.uom = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
