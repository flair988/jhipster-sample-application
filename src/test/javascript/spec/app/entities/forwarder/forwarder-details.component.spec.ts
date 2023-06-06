/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import ForwarderDetailComponent from '@/entities/forwarder/forwarder-details.vue';
import ForwarderClass from '@/entities/forwarder/forwarder-details.component';
import ForwarderService from '@/entities/forwarder/forwarder.service';
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
  describe('Forwarder Management Detail Component', () => {
    let wrapper: Wrapper<ForwarderClass>;
    let comp: ForwarderClass;
    let forwarderServiceStub: SinonStubbedInstance<ForwarderService>;

    beforeEach(() => {
      forwarderServiceStub = sinon.createStubInstance<ForwarderService>(ForwarderService);

      wrapper = shallowMount<ForwarderClass>(ForwarderDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { forwarderService: () => forwarderServiceStub, alertService: () => new AlertService() },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundForwarder = { id: 123 };
        forwarderServiceStub.find.resolves(foundForwarder);

        // WHEN
        comp.retrieveForwarder(123);
        await comp.$nextTick();

        // THEN
        expect(comp.forwarder).toBe(foundForwarder);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundForwarder = { id: 123 };
        forwarderServiceStub.find.resolves(foundForwarder);

        // WHEN
        comp.beforeRouteEnter({ params: { forwarderId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.forwarder).toBe(foundForwarder);
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
