/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import ProductTaxmonomyDetailComponent from '@/entities/product-taxmonomy/product-taxmonomy-details.vue';
import ProductTaxmonomyClass from '@/entities/product-taxmonomy/product-taxmonomy-details.component';
import ProductTaxmonomyService from '@/entities/product-taxmonomy/product-taxmonomy.service';
import router from '@/router';
import AlertService from '@/shared/alert/alert.service';

const localVue = createLocalVue();
localVue.use(VueRouter);

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('ProductTaxmonomy Management Detail Component', () => {
    let wrapper: Wrapper<ProductTaxmonomyClass>;
    let comp: ProductTaxmonomyClass;
    let productTaxmonomyServiceStub: SinonStubbedInstance<ProductTaxmonomyService>;

    beforeEach(() => {
      productTaxmonomyServiceStub = sinon.createStubInstance<ProductTaxmonomyService>(ProductTaxmonomyService);

      wrapper = shallowMount<ProductTaxmonomyClass>(ProductTaxmonomyDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { productTaxmonomyService: () => productTaxmonomyServiceStub, alertService: () => new AlertService() },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundProductTaxmonomy = { id: 123 };
        productTaxmonomyServiceStub.find.resolves(foundProductTaxmonomy);

        // WHEN
        comp.retrieveProductTaxmonomy(123);
        await comp.$nextTick();

        // THEN
        expect(comp.productTaxmonomy).toBe(foundProductTaxmonomy);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundProductTaxmonomy = { id: 123 };
        productTaxmonomyServiceStub.find.resolves(foundProductTaxmonomy);

        // WHEN
        comp.beforeRouteEnter({ params: { productTaxmonomyId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.productTaxmonomy).toBe(foundProductTaxmonomy);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        comp.previousState();
        await comp.$nextTick();

        expect(comp.$router.currentRoute.fullPath).toContain('/');
      });
    });
  });
});
