/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import ProcessLogComponent from '@/entities/process-log/process-log.vue';
import ProcessLogClass from '@/entities/process-log/process-log.component';
import ProcessLogService from '@/entities/process-log/process-log.service';
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
  describe('ProcessLog Management Component', () => {
    let wrapper: Wrapper<ProcessLogClass>;
    let comp: ProcessLogClass;
    let processLogServiceStub: SinonStubbedInstance<ProcessLogService>;

    beforeEach(() => {
      processLogServiceStub = sinon.createStubInstance<ProcessLogService>(ProcessLogService);
      processLogServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<ProcessLogClass>(ProcessLogComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          processLogService: () => processLogServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      processLogServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllProcessLogs();
      await comp.$nextTick();

      // THEN
      expect(processLogServiceStub.retrieve.called).toBeTruthy();
      expect(comp.processLogs[0]).toEqual(expect.objectContaining({ id: 123 }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      processLogServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      expect(processLogServiceStub.retrieve.callCount).toEqual(1);

      comp.removeProcessLog();
      await comp.$nextTick();

      // THEN
      expect(processLogServiceStub.delete.called).toBeTruthy();
      expect(processLogServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
