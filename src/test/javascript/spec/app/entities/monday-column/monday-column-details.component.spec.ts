/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import MondayColumnDetailComponent from '@/entities/monday-column/monday-column-details.vue';
import MondayColumnClass from '@/entities/monday-column/monday-column-details.component';
import MondayColumnService from '@/entities/monday-column/monday-column.service';
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
  describe('MondayColumn Management Detail Component', () => {
    let wrapper: Wrapper<MondayColumnClass>;
    let comp: MondayColumnClass;
    let mondayColumnServiceStub: SinonStubbedInstance<MondayColumnService>;

    beforeEach(() => {
      mondayColumnServiceStub = sinon.createStubInstance<MondayColumnService>(MondayColumnService);

      wrapper = shallowMount<MondayColumnClass>(MondayColumnDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { mondayColumnService: () => mondayColumnServiceStub, alertService: () => new AlertService() },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundMondayColumn = { id: 123 };
        mondayColumnServiceStub.find.resolves(foundMondayColumn);

        // WHEN
        comp.retrieveMondayColumn(123);
        await comp.$nextTick();

        // THEN
        expect(comp.mondayColumn).toBe(foundMondayColumn);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundMondayColumn = { id: 123 };
        mondayColumnServiceStub.find.resolves(foundMondayColumn);

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
