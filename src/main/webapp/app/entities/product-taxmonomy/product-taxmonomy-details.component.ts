import { Component, Vue, Inject } from 'vue-property-decorator';

import { IProductTaxmonomy } from '@/shared/model/product-taxmonomy.model';
import ProductTaxmonomyService from './product-taxmonomy.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class ProductTaxmonomyDetails extends Vue {
  @Inject('productTaxmonomyService') private productTaxmonomyService: () => ProductTaxmonomyService;
  @Inject('alertService') private alertService: () => AlertService;

  public productTaxmonomy: IProductTaxmonomy = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.productTaxmonomyId) {
        vm.retrieveProductTaxmonomy(to.params.productTaxmonomyId);
      }
    });
  }

  public retrieveProductTaxmonomy(productTaxmonomyId) {
    this.productTaxmonomyService()
      .find(productTaxmonomyId)
      .then(res => {
        this.productTaxmonomy = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
