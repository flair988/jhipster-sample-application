/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import MondayColumnUpdateComponent from '@/entities/monday-column/monday-column-update.vue';
import MondayColumnClass from '@/entities/monday-column/monday-column-update.component';
import MondayColumnService from '@/entities/monday-column/monday-column.service';

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
  describe('MondayColumn Management Update Component', () => {
    let wrapper: Wrapper<MondayColumnClass>;
    let comp: MondayColumnClass;
    let mondayColumnServiceStub: SinonStubbedInstance<MondayColumnService>;

    beforeEach(() => {
      mondayColumnServiceStub = sinon.createStubInstance<MondayColumnService>(MondayColumnService);

      wrapper = shallowMount<MondayColumnClass>(MondayColumnUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          mondayColumnService: () => mondayColumnServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.mondayColumn = entity;
        mondayColumnServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(mondayColumnServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.mondayColumn = entity;
        mondayColumnServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(mondayColumnServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundMondayColumn = { id: 123 };
        mondayColumnServiceStub.find.resolves(foundMondayColumn);
        mondayColumnServiceStub.retrieve.resolves([foundMondayColumn]);

        // WHEN
        comp.beforeRouteEnter({ params: { mondayColumnId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.mondayColumn).toBe(foundMondayColumn);
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
