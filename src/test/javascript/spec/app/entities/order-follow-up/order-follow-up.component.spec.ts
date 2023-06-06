/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import OrderFollowUpComponent from '@/entities/order-follow-up/order-follow-up.vue';
import OrderFollowUpClass from '@/entities/order-follow-up/order-follow-up.component';
import OrderFollowUpService from '@/entities/order-follow-up/order-follow-up.service';
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
  describe('OrderFollowUp Management Component', () => {
    let wrapper: Wrapper<OrderFollowUpClass>;
    let comp: OrderFollowUpClass;
    let orderFollowUpServiceStub: SinonStubbedInstance<OrderFollowUpService>;

    beforeEach(() => {
      orderFollowUpServiceStub = sinon.createStubInstance<OrderFollowUpService>(OrderFollowUpService);
      orderFollowUpServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<OrderFollowUpClass>(OrderFollowUpComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          orderFollowUpService: () => orderFollowUpServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      orderFollowUpServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllOrderFollowUps();
      await comp.$nextTick();

      // THEN
      expect(orderFollowUpServiceStub.retrieve.called).toBeTruthy();
      expect(comp.orderFollowUps[0]).toEqual(expect.objectContaining({ id: 123 }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      orderFollowUpServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      expect(orderFollowUpServiceStub.retrieve.callCount).toEqual(1);

      comp.removeOrderFollowUp();
      await comp.$nextTick();

      // THEN
      expect(orderFollowUpServiceStub.delete.called).toBeTruthy();
      expect(orderFollowUpServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
