/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import OrderFollowUpUpdateComponent from '@/entities/order-follow-up/order-follow-up-update.vue';
import OrderFollowUpClass from '@/entities/order-follow-up/order-follow-up-update.component';
import OrderFollowUpService from '@/entities/order-follow-up/order-follow-up.service';

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
  describe('OrderFollowUp Management Update Component', () => {
    let wrapper: Wrapper<OrderFollowUpClass>;
    let comp: OrderFollowUpClass;
    let orderFollowUpServiceStub: SinonStubbedInstance<OrderFollowUpService>;

    beforeEach(() => {
      orderFollowUpServiceStub = sinon.createStubInstance<OrderFollowUpService>(OrderFollowUpService);

      wrapper = shallowMount<OrderFollowUpClass>(OrderFollowUpUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          orderFollowUpService: () => orderFollowUpServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.orderFollowUp = entity;
        orderFollowUpServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(orderFollowUpServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.orderFollowUp = entity;
        orderFollowUpServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(orderFollowUpServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundOrderFollowUp = { id: 123 };
        orderFollowUpServiceStub.find.resolves(foundOrderFollowUp);
        orderFollowUpServiceStub.retrieve.resolves([foundOrderFollowUp]);

        // WHEN
        comp.beforeRouteEnter({ params: { orderFollowUpId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.orderFollowUp).toBe(foundOrderFollowUp);
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
