/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import CommercialInvoiceComponent from '@/entities/commercial-invoice/commercial-invoice.vue';
import CommercialInvoiceClass from '@/entities/commercial-invoice/commercial-invoice.component';
import CommercialInvoiceService from '@/entities/commercial-invoice/commercial-invoice.service';
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
  describe('CommercialInvoice Management Component', () => {
    let wrapper: Wrapper<CommercialInvoiceClass>;
    let comp: CommercialInvoiceClass;
    let commercialInvoiceServiceStub: SinonStubbedInstance<CommercialInvoiceService>;

    beforeEach(() => {
      commercialInvoiceServiceStub = sinon.createStubInstance<CommercialInvoiceService>(CommercialInvoiceService);
      commercialInvoiceServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<CommercialInvoiceClass>(CommercialInvoiceComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          commercialInvoiceService: () => commercialInvoiceServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      commercialInvoiceServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllCommercialInvoices();
      await comp.$nextTick();

      // THEN
      expect(commercialInvoiceServiceStub.retrieve.called).toBeTruthy();
      expect(comp.commercialInvoices[0]).toEqual(expect.objectContaining({ id: 123 }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      commercialInvoiceServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      expect(commercialInvoiceServiceStub.retrieve.callCount).toEqual(1);

      comp.removeCommercialInvoice();
      await comp.$nextTick();

      // THEN
      expect(commercialInvoiceServiceStub.delete.called).toBeTruthy();
      expect(commercialInvoiceServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
