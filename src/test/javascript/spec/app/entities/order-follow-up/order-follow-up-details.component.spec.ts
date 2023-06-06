/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import OrderFollowUpDetailComponent from '@/entities/order-follow-up/order-follow-up-details.vue';
import OrderFollowUpClass from '@/entities/order-follow-up/order-follow-up-details.component';
import OrderFollowUpService from '@/entities/order-follow-up/order-follow-up.service';
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
  describe('OrderFollowUp Management Detail Component', () => {
    let wrapper: Wrapper<OrderFollowUpClass>;
    let comp: OrderFollowUpClass;
    let orderFollowUpServiceStub: SinonStubbedInstance<OrderFollowUpService>;

    beforeEach(() => {
      orderFollowUpServiceStub = sinon.createStubInstance<OrderFollowUpService>(OrderFollowUpService);

      wrapper = shallowMount<OrderFollowUpClass>(OrderFollowUpDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { orderFollowUpService: () => orderFollowUpServiceStub, alertService: () => new AlertService() },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundOrderFollowUp = { id: 123 };
        orderFollowUpServiceStub.find.resolves(foundOrderFollowUp);

        // WHEN
        comp.retrieveOrderFollowUp(123);
        await comp.$nextTick();

        // THEN
        expect(comp.orderFollowUp).toBe(foundOrderFollowUp);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundOrderFollowUp = { id: 123 };
        orderFollowUpServiceStub.find.resolves(foundOrderFollowUp);

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
