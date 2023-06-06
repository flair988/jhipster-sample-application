/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import ProductTaxmonomyComponent from '@/entities/product-taxmonomy/product-taxmonomy.vue';
import ProductTaxmonomyClass from '@/entities/product-taxmonomy/product-taxmonomy.component';
import ProductTaxmonomyService from '@/entities/product-taxmonomy/product-taxmonomy.service';
import AlertService from '@/shared/alert/alert.service';

const localVue = createLocalVue();
localVue.use(ToastPlugin);

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('b-badge', {});
localVue.directive('b-modal', {});
localVue.component('b-button', {});
localVue.component('router-link', {});

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {},
  },
};

describe('Component Tests', () => {
  describe('ProductTaxmonomy Management Component', () => {
    let wrapper: Wrapper<ProductTaxmonomyClass>;
    let comp: ProductTaxmonomyClass;
    let productTaxmonomyServiceStub: SinonStubbedInstance<ProductTaxmonomyService>;

    beforeEach(() => {
      productTaxmonomyServiceStub = sinon.createStubInstance<ProductTaxmonomyService>(ProductTaxmonomyService);
      productTaxmonomyServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<ProductTaxmonomyClass>(ProductTaxmonomyComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          productTaxmonomyService: () => productTaxmonomyServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      productTaxmonomyServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllProductTaxmonomys();
      await comp.$nextTick();

      // THEN
      expect(productTaxmonomyServiceStub.retrieve.called).toBeTruthy();
      expect(comp.productTaxmonomies[0]).toEqual(expect.objectContaining({ id: 123 }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      productTaxmonomyServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      expect(productTaxmonomyServiceStub.retrieve.callCount).toEqual(1);

      comp.removeProductTaxmonomy();
      await comp.$nextTick();

      // THEN
      expect(productTaxmonomyServiceStub.delete.called).toBeTruthy();
      expect(productTaxmonomyServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
