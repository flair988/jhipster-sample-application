/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import OperationSiteDetailComponent from '@/entities/operation-site/operation-site-details.vue';
import OperationSiteClass from '@/entities/operation-site/operation-site-details.component';
import OperationSiteService from '@/entities/operation-site/operation-site.service';
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
  describe('OperationSite Management Detail Component', () => {
    let wrapper: Wrapper<OperationSiteClass>;
    let comp: OperationSiteClass;
    let operationSiteServiceStub: SinonStubbedInstance<OperationSiteService>;

    beforeEach(() => {
      operationSiteServiceStub = sinon.createStubInstance<OperationSiteService>(OperationSiteService);

      wrapper = shallowMount<OperationSiteClass>(OperationSiteDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { operationSiteService: () => operationSiteServiceStub, alertService: () => new AlertService() },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundOperationSite = { id: 123 };
        operationSiteServiceStub.find.resolves(foundOperationSite);

        // WHEN
        comp.retrieveOperationSite(123);
        await comp.$nextTick();

        // THEN
        expect(comp.operationSite).toBe(foundOperationSite);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundOperationSite = { id: 123 };
        operationSiteServiceStub.find.resolves(foundOperationSite);

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
