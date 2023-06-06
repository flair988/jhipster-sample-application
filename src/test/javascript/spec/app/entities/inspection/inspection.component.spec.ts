/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import InspectionComponent from '@/entities/inspection/inspection.vue';
import InspectionClass from '@/entities/inspection/inspection.component';
import InspectionService from '@/entities/inspection/inspection.service';
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
  describe('Inspection Management Component', () => {
    let wrapper: Wrapper<InspectionClass>;
    let comp: InspectionClass;
    let inspectionServiceStub: SinonStubbedInstance<InspectionService>;

    beforeEach(() => {
      inspectionServiceStub = sinon.createStubInstance<InspectionService>(InspectionService);
      inspectionServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<InspectionClass>(InspectionComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          inspectionService: () => inspectionServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      inspectionServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllInspections();
      await comp.$nextTick();

      // THEN
      expect(inspectionServiceStub.retrieve.called).toBeTruthy();
      expect(comp.inspections[0]).toEqual(expect.objectContaining({ id: 123 }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      inspectionServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      expect(inspectionServiceStub.retrieve.callCount).toEqual(1);

      comp.removeInspection();
      await comp.$nextTick();

      // THEN
      expect(inspectionServiceStub.delete.called).toBeTruthy();
      expect(inspectionServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
