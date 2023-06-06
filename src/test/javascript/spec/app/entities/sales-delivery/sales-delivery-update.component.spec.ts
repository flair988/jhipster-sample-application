/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import SalesDeliveryUpdateComponent from '@/entities/sales-delivery/sales-delivery-update.vue';
import SalesDeliveryClass from '@/entities/sales-delivery/sales-delivery-update.component';
import SalesDeliveryService from '@/entities/sales-delivery/sales-delivery.service';

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
  describe('SalesDelivery Management Update Component', () => {
    let wrapper: Wrapper<SalesDeliveryClass>;
    let comp: SalesDeliveryClass;
    let salesDeliveryServiceStub: SinonStubbedInstance<SalesDeliveryService>;

    beforeEach(() => {
      salesDeliveryServiceStub = sinon.createStubInstance<SalesDeliveryService>(SalesDeliveryService);

      wrapper = shallowMount<SalesDeliveryClass>(SalesDeliveryUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          salesDeliveryService: () => salesDeliveryServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.salesDelivery = entity;
        salesDeliveryServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(salesDeliveryServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.salesDelivery = entity;
        salesDeliveryServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(salesDeliveryServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundSalesDelivery = { id: 123 };
        salesDeliveryServiceStub.find.resolves(foundSalesDelivery);
        salesDeliveryServiceStub.retrieve.resolves([foundSalesDelivery]);

        // WHEN
        comp.beforeRouteEnter({ params: { salesDeliveryId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.salesDelivery).toBe(foundSalesDelivery);
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
