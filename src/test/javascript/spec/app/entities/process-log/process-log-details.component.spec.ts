/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import ProcessLogDetailComponent from '@/entities/process-log/process-log-details.vue';
import ProcessLogClass from '@/entities/process-log/process-log-details.component';
import ProcessLogService from '@/entities/process-log/process-log.service';
import router from '@/router';
import AlertService from '@/shared/alert/alert.service';

const localVue = createLocalVue();
localVue.use(VueRouter);

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('ProcessLog Management Detail Component', () => {
    let wrapper: Wrapper<ProcessLogClass>;
    let comp: ProcessLogClass;
    let processLogServiceStub: SinonStubbedInstance<ProcessLogService>;

    beforeEach(() => {
      processLogServiceStub = sinon.createStubInstance<ProcessLogService>(ProcessLogService);

      wrapper = shallowMount<ProcessLogClass>(ProcessLogDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { processLogService: () => processLogServiceStub, alertService: () => new AlertService() },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundProcessLog = { id: 123 };
        processLogServiceStub.find.resolves(foundProcessLog);

        // WHEN
        comp.retrieveProcessLog(123);
        await comp.$nextTick();

        // THEN
        expect(comp.processLog).toBe(foundProcessLog);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundProcessLog = { id: 123 };
        processLogServiceStub.find.resolves(foundProcessLog);

        // WHEN
        comp.beforeRouteEnter({ params: { processLogId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.processLog).toBe(foundProcessLog);
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
