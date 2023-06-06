import { Component, Vue, Inject } from 'vue-property-decorator';

import { IProductFinished } from '@/shared/model/product-finished.model';
import ProductFinishedService from './product-finished.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class ProductFinishedDetails extends Vue {
  @Inject('productFinishedService') private productFinishedService: () => ProductFinishedService;
  @Inject('alertService') private alertService: () => AlertService;

  public productFinished: IProductFinished = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.productFinishedId) {
        vm.retrieveProductFinished(to.params.productFinishedId);
      }
    });
  }

  public retrieveProductFinished(productFinishedId) {
    this.productFinishedService()
      .find(productFinishedId)
      .then(res => {
        this.productFinished = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
