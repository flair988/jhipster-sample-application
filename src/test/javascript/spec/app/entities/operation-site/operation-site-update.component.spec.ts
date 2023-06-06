/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import OperationSiteUpdateComponent from '@/entities/operation-site/operation-site-update.vue';
import OperationSiteClass from '@/entities/operation-site/operation-site-update.component';
import OperationSiteService from '@/entities/operation-site/operation-site.service';

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
  describe('OperationSite Management Update Component', () => {
    let wrapper: Wrapper<OperationSiteClass>;
    let comp: OperationSiteClass;
    let operationSiteServiceStub: SinonStubbedInstance<OperationSiteService>;

    beforeEach(() => {
      operationSiteServiceStub = sinon.createStubInstance<OperationSiteService>(OperationSiteService);

      wrapper = shallowMount<OperationSiteClass>(OperationSiteUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          operationSiteService: () => operationSiteServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.operationSite = entity;
        operationSiteServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(operationSiteServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.operationSite = entity;
        operationSiteServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(operationSiteServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundOperationSite = { id: 123 };
        operationSiteServiceStub.find.resolves(foundOperationSite);
        operationSiteServiceStub.retrieve.resolves([foundOperationSite]);

        // WHEN
        comp.beforeRouteEnter({ params: { operationSiteId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.operationSite).toBe(foundOperationSite);
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
