/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import SalesDeliveryComponent from '@/entities/sales-delivery/sales-delivery.vue';
import SalesDeliveryClass from '@/entities/sales-delivery/sales-delivery.component';
import SalesDeliveryService from '@/entities/sales-delivery/sales-delivery.service';
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
  describe('SalesDelivery Management Component', () => {
    let wrapper: Wrapper<SalesDeliveryClass>;
    let comp: SalesDeliveryClass;
    let salesDeliveryServiceStub: SinonStubbedInstance<SalesDeliveryService>;

    beforeEach(() => {
      salesDeliveryServiceStub = sinon.createStubInstance<SalesDeliveryService>(SalesDeliveryService);
      salesDeliveryServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<SalesDeliveryClass>(SalesDeliveryComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          salesDeliveryService: () => salesDeliveryServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      salesDeliveryServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllSalesDeliverys();
      await comp.$nextTick();

      // THEN
      expect(salesDeliveryServiceStub.retrieve.called).toBeTruthy();
      expect(comp.salesDeliveries[0]).toEqual(expect.objectContaining({ id: 123 }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      salesDeliveryServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      expect(salesDeliveryServiceStub.retrieve.callCount).toEqual(1);

      comp.removeSalesDelivery();
      await comp.$nextTick();

      // THEN
      expect(salesDeliveryServiceStub.delete.called).toBeTruthy();
      expect(salesDeliveryServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
