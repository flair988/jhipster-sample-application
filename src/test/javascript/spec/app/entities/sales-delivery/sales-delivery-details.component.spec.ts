/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import SalesDeliveryDetailComponent from '@/entities/sales-delivery/sales-delivery-details.vue';
import SalesDeliveryClass from '@/entities/sales-delivery/sales-delivery-details.component';
import SalesDeliveryService from '@/entities/sales-delivery/sales-delivery.service';
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
  describe('SalesDelivery Management Detail Component', () => {
    let wrapper: Wrapper<SalesDeliveryClass>;
    let comp: SalesDeliveryClass;
    let salesDeliveryServiceStub: SinonStubbedInstance<SalesDeliveryService>;

    beforeEach(() => {
      salesDeliveryServiceStub = sinon.createStubInstance<SalesDeliveryService>(SalesDeliveryService);

      wrapper = shallowMount<SalesDeliveryClass>(SalesDeliveryDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { salesDeliveryService: () => salesDeliveryServiceStub, alertService: () => new AlertService() },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundSalesDelivery = { id: 123 };
        salesDeliveryServiceStub.find.resolves(foundSalesDelivery);

        // WHEN
        comp.retrieveSalesDelivery(123);
        await comp.$nextTick();

        // THEN
        expect(comp.salesDelivery).toBe(foundSalesDelivery);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundSalesDelivery = { id: 123 };
        salesDeliveryServiceStub.find.resolves(foundSalesDelivery);

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
