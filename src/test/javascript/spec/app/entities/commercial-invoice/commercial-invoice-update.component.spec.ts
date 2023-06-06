/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import CommercialInvoiceUpdateComponent from '@/entities/commercial-invoice/commercial-invoice-update.vue';
import CommercialInvoiceClass from '@/entities/commercial-invoice/commercial-invoice-update.component';
import CommercialInvoiceService from '@/entities/commercial-invoice/commercial-invoice.service';

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
  describe('CommercialInvoice Management Update Component', () => {
    let wrapper: Wrapper<CommercialInvoiceClass>;
    let comp: CommercialInvoiceClass;
    let commercialInvoiceServiceStub: SinonStubbedInstance<CommercialInvoiceService>;

    beforeEach(() => {
      commercialInvoiceServiceStub = sinon.createStubInstance<CommercialInvoiceService>(CommercialInvoiceService);

      wrapper = shallowMount<CommercialInvoiceClass>(CommercialInvoiceUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          commercialInvoiceService: () => commercialInvoiceServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.commercialInvoice = entity;
        commercialInvoiceServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(commercialInvoiceServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.commercialInvoice = entity;
        commercialInvoiceServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(commercialInvoiceServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundCommercialInvoice = { id: 123 };
        commercialInvoiceServiceStub.find.resolves(foundCommercialInvoice);
        commercialInvoiceServiceStub.retrieve.resolves([foundCommercialInvoice]);

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
