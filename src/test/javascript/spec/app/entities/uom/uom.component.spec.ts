/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import UomComponent from '@/entities/uom/uom.vue';
import UomClass from '@/entities/uom/uom.component';
import UomService from '@/entities/uom/uom.service';
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
  describe('Uom Management Component', () => {
    let wrapper: Wrapper<UomClass>;
    let comp: UomClass;
    let uomServiceStub: SinonStubbedInstance<UomService>;

    beforeEach(() => {
      uomServiceStub = sinon.createStubInstance<UomService>(UomService);
      uomServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<UomClass>(UomComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          uomService: () => uomServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      uomServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllUoms();
      await comp.$nextTick();

      // THEN
      expect(uomServiceStub.retrieve.called).toBeTruthy();
      expect(comp.uoms[0]).toEqual(expect.objectContaining({ id: 123 }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      uomServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      expect(uomServiceStub.retrieve.callCount).toEqual(1);

      comp.removeUom();
      await comp.$nextTick();

      // THEN
      expect(uomServiceStub.delete.called).toBeTruthy();
      expect(uomServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
