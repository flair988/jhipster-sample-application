/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import UomDetailComponent from '@/entities/uom/uom-details.vue';
import UomClass from '@/entities/uom/uom-details.component';
import UomService from '@/entities/uom/uom.service';
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
  describe('Uom Management Detail Component', () => {
    let wrapper: Wrapper<UomClass>;
    let comp: UomClass;
    let uomServiceStub: SinonStubbedInstance<UomService>;

    beforeEach(() => {
      uomServiceStub = sinon.createStubInstance<UomService>(UomService);

      wrapper = shallowMount<UomClass>(UomDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { uomService: () => uomServiceStub, alertService: () => new AlertService() },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundUom = { id: 123 };
        uomServiceStub.find.resolves(foundUom);

        // WHEN
        comp.retrieveUom(123);
        await comp.$nextTick();

        // THEN
        expect(comp.uom).toBe(foundUom);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundUom = { id: 123 };
        uomServiceStub.find.resolves(foundUom);

        // WHEN
        comp.beforeRouteEnter({ params: { uomId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.uom).toBe(foundUom);
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
