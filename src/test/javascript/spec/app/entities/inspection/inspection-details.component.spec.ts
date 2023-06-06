/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import InspectionDetailComponent from '@/entities/inspection/inspection-details.vue';
import InspectionClass from '@/entities/inspection/inspection-details.component';
import InspectionService from '@/entities/inspection/inspection.service';
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
  describe('Inspection Management Detail Component', () => {
    let wrapper: Wrapper<InspectionClass>;
    let comp: InspectionClass;
    let inspectionServiceStub: SinonStubbedInstance<InspectionService>;

    beforeEach(() => {
      inspectionServiceStub = sinon.createStubInstance<InspectionService>(InspectionService);

      wrapper = shallowMount<InspectionClass>(InspectionDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { inspectionService: () => inspectionServiceStub, alertService: () => new AlertService() },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundInspection = { id: 123 };
        inspectionServiceStub.find.resolves(foundInspection);

        // WHEN
        comp.retrieveInspection(123);
        await comp.$nextTick();

        // THEN
        expect(comp.inspection).toBe(foundInspection);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundInspection = { id: 123 };
        inspectionServiceStub.find.resolves(foundInspection);

        // WHEN
        comp.beforeRouteEnter({ params: { inspectionId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.inspection).toBe(foundInspection);
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
