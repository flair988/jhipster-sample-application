/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import ProductTaxmonomyUpdateComponent from '@/entities/product-taxmonomy/product-taxmonomy-update.vue';
import ProductTaxmonomyClass from '@/entities/product-taxmonomy/product-taxmonomy-update.component';
import ProductTaxmonomyService from '@/entities/product-taxmonomy/product-taxmonomy.service';

import AlertService from '@/shared/alert/alert.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.use(ToastPlugin);
localVue.component('font-awesome-icon', {});
localVue.component('b-input-group', {});
localVue.component('b-input-group-prepend', {});
localVue.component('b-form-datepicker', {});
localVue.component('b-form-input', {});

describe('Component Tests', () => {
  describe('ProductTaxmonomy Management Update Component', () => {
    let wrapper: Wrapper<ProductTaxmonomyClass>;
    let comp: ProductTaxmonomyClass;
    let productTaxmonomyServiceStub: SinonStubbedInstance<ProductTaxmonomyService>;

    beforeEach(() => {
      productTaxmonomyServiceStub = sinon.createStubInstance<ProductTaxmonomyService>(ProductTaxmonomyService);

      wrapper = shallowMount<ProductTaxmonomyClass>(ProductTaxmonomyUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          productTaxmonomyService: () => productTaxmonomyServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.productTaxmonomy = entity;
        productTaxmonomyServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(productTaxmonomyServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.productTaxmonomy = entity;
        productTaxmonomyServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(productTaxmonomyServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundProductTaxmonomy = { id: 123 };
        productTaxmonomyServiceStub.find.resolves(foundProductTaxmonomy);
        productTaxmonomyServiceStub.retrieve.resolves([foundProductTaxmonomy]);

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
