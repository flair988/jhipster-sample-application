/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import PIDetailComponent from '@/entities/pi/pi-details.vue';
import PIClass from '@/entities/pi/pi-details.component';
import PIService from '@/entities/pi/pi.service';
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
  describe('PI Management Detail Component', () => {
    let wrapper: Wrapper<PIClass>;
    let comp: PIClass;
    let pIServiceStub: SinonStubbedInstance<PIService>;

    beforeEach(() => {
      pIServiceStub = sinon.createStubInstance<PIService>(PIService);

      wrapper = shallowMount<PIClass>(PIDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { pIService: () => pIServiceStub, alertService: () => new AlertService() },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundPI = { id: 123 };
        pIServiceStub.find.resolves(foundPI);

        // WHEN
        comp.retrievePI(123);
        await comp.$nextTick();

        // THEN
        expect(comp.pI).toBe(foundPI);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundPI = { id: 123 };
        pIServiceStub.find.resolves(foundPI);

        // WHEN
        comp.beforeRouteEnter({ params: { pIId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.pI).toBe(foundPI);
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
