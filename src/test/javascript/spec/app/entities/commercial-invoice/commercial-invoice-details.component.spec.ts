/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import CommercialInvoiceDetailComponent from '@/entities/commercial-invoice/commercial-invoice-details.vue';
import CommercialInvoiceClass from '@/entities/commercial-invoice/commercial-invoice-details.component';
import CommercialInvoiceService from '@/entities/commercial-invoice/commercial-invoice.service';
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
  describe('CommercialInvoice Management Detail Component', () => {
    let wrapper: Wrapper<CommercialInvoiceClass>;
    let comp: CommercialInvoiceClass;
    let commercialInvoiceServiceStub: SinonStubbedInstance<CommercialInvoiceService>;

    beforeEach(() => {
      commercialInvoiceServiceStub = sinon.createStubInstance<CommercialInvoiceService>(CommercialInvoiceService);

      wrapper = shallowMount<CommercialInvoiceClass>(CommercialInvoiceDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { commercialInvoiceService: () => commercialInvoiceServiceStub, alertService: () => new AlertService() },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundCommercialInvoice = { id: 123 };
        commercialInvoiceServiceStub.find.resolves(foundCommercialInvoice);

        // WHEN
        comp.retrieveCommercialInvoice(123);
        await comp.$nextTick();

        // THEN
        expect(comp.commercialInvoice).toBe(foundCommercialInvoice);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundCommercialInvoice = { id: 123 };
        commercialInvoiceServiceStub.find.resolves(foundCommercialInvoice);

        // WHEN
        comp.beforeRouteEnter({ params: { commercialInvoiceId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.commercialInvoice).toBe(foundCommercialInvoice);
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
