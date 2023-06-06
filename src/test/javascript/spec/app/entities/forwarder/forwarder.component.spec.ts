/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import ForwarderComponent from '@/entities/forwarder/forwarder.vue';
import ForwarderClass from '@/entities/forwarder/forwarder.component';
import ForwarderService from '@/entities/forwarder/forwarder.service';
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
  describe('Forwarder Management Component', () => {
    let wrapper: Wrapper<ForwarderClass>;
    let comp: ForwarderClass;
    let forwarderServiceStub: SinonStubbedInstance<ForwarderService>;

    beforeEach(() => {
      forwarderServiceStub = sinon.createStubInstance<ForwarderService>(ForwarderService);
      forwarderServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<ForwarderClass>(ForwarderComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          forwarderService: () => forwarderServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      forwarderServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllForwarders();
      await comp.$nextTick();

      // THEN
      expect(forwarderServiceStub.retrieve.called).toBeTruthy();
      expect(comp.forwarders[0]).toEqual(expect.objectContaining({ id: 123 }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      forwarderServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      expect(forwarderServiceStub.retrieve.callCount).toEqual(1);

      comp.removeForwarder();
      await comp.$nextTick();

      // THEN
      expect(forwarderServiceStub.delete.called).toBeTruthy();
      expect(forwarderServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
