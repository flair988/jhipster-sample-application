/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import ProductFinishedDetailComponent from '@/entities/product-finished/product-finished-details.vue';
import ProductFinishedClass from '@/entities/product-finished/product-finished-details.component';
import ProductFinishedService from '@/entities/product-finished/product-finished.service';
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
  describe('ProductFinished Management Detail Component', () => {
    let wrapper: Wrapper<ProductFinishedClass>;
    let comp: ProductFinishedClass;
    let productFinishedServiceStub: SinonStubbedInstance<ProductFinishedService>;

    beforeEach(() => {
      productFinishedServiceStub = sinon.createStubInstance<ProductFinishedService>(ProductFinishedService);

      wrapper = shallowMount<ProductFinishedClass>(ProductFinishedDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { productFinishedService: () => productFinishedServiceStub, alertService: () => new AlertService() },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundProductFinished = { id: 123 };
        productFinishedServiceStub.find.resolves(foundProductFinished);

        // WHEN
        comp.retrieveProductFinished(123);
        await comp.$nextTick();

        // THEN
        expect(comp.productFinished).toBe(foundProductFinished);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundProductFinished = { id: 123 };
        productFinishedServiceStub.find.resolves(foundProductFinished);

        // WHEN
        comp.beforeRouteEnter({ params: { productFinishedId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.productFinished).toBe(foundProductFinished);
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
