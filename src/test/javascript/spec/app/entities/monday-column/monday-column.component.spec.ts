/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import MondayColumnComponent from '@/entities/monday-column/monday-column.vue';
import MondayColumnClass from '@/entities/monday-column/monday-column.component';
import MondayColumnService from '@/entities/monday-column/monday-column.service';
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
  describe('MondayColumn Management Component', () => {
    let wrapper: Wrapper<MondayColumnClass>;
    let comp: MondayColumnClass;
    let mondayColumnServiceStub: SinonStubbedInstance<MondayColumnService>;

    beforeEach(() => {
      mondayColumnServiceStub = sinon.createStubInstance<MondayColumnService>(MondayColumnService);
      mondayColumnServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<MondayColumnClass>(MondayColumnComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          mondayColumnService: () => mondayColumnServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      mondayColumnServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllMondayColumns();
      await comp.$nextTick();

      // THEN
      expect(mondayColumnServiceStub.retrieve.called).toBeTruthy();
      expect(comp.mondayColumns[0]).toEqual(expect.objectContaining({ id: 123 }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      mondayColumnServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      expect(mondayColumnServiceStub.retrieve.callCount).toEqual(1);

      comp.removeMondayColumn();
      await comp.$nextTick();

      // THEN
      expect(mondayColumnServiceStub.delete.called).toBeTruthy();
      expect(mondayColumnServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
