/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import PIComponent from '@/entities/pi/pi.vue';
import PIClass from '@/entities/pi/pi.component';
import PIService from '@/entities/pi/pi.service';
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
  describe('PI Management Component', () => {
    let wrapper: Wrapper<PIClass>;
    let comp: PIClass;
    let pIServiceStub: SinonStubbedInstance<PIService>;

    beforeEach(() => {
      pIServiceStub = sinon.createStubInstance<PIService>(PIService);
      pIServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<PIClass>(PIComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          pIService: () => pIServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      pIServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllPIs();
      await comp.$nextTick();

      // THEN
      expect(pIServiceStub.retrieve.called).toBeTruthy();
      expect(comp.pIS[0]).toEqual(expect.objectContaining({ id: 123 }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      pIServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      expect(pIServiceStub.retrieve.callCount).toEqual(1);

      comp.removePI();
      await comp.$nextTick();

      // THEN
      expect(pIServiceStub.delete.called).toBeTruthy();
      expect(pIServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
