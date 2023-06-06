/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import InspectionUpdateComponent from '@/entities/inspection/inspection-update.vue';
import InspectionClass from '@/entities/inspection/inspection-update.component';
import InspectionService from '@/entities/inspection/inspection.service';

import AlertService from '@/shared/alert/alert.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.use(ToastPlugin);
localVue.component('font-awesome-icon', {});
localVue.component('b-input-group', {});
localVue.component('b-input-group-prepend', {});
localVue.component('b-form-datepicker', {});
localVue.component('b-form-input', {});

describe('Component Tests', () => {
  describe('Inspection Management Update Component', () => {
    let wrapper: Wrapper<InspectionClass>;
    let comp: InspectionClass;
    let inspectionServiceStub: SinonStubbedInstance<InspectionService>;

    beforeEach(() => {
      inspectionServiceStub = sinon.createStubInstance<InspectionService>(InspectionService);

      wrapper = shallowMount<InspectionClass>(InspectionUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          inspectionService: () => inspectionServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.inspection = entity;
        inspectionServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(inspectionServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.inspection = entity;
        inspectionServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(inspectionServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundInspection = { id: 123 };
        inspectionServiceStub.find.resolves(foundInspection);
        inspectionServiceStub.retrieve.resolves([foundInspection]);

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
