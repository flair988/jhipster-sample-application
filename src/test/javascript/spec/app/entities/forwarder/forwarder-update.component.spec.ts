/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import ForwarderUpdateComponent from '@/entities/forwarder/forwarder-update.vue';
import ForwarderClass from '@/entities/forwarder/forwarder-update.component';
import ForwarderService from '@/entities/forwarder/forwarder.service';

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
  describe('Forwarder Management Update Component', () => {
    let wrapper: Wrapper<ForwarderClass>;
    let comp: ForwarderClass;
    let forwarderServiceStub: SinonStubbedInstance<ForwarderService>;

    beforeEach(() => {
      forwarderServiceStub = sinon.createStubInstance<ForwarderService>(ForwarderService);

      wrapper = shallowMount<ForwarderClass>(ForwarderUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          forwarderService: () => forwarderServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.forwarder = entity;
        forwarderServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(forwarderServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.forwarder = entity;
        forwarderServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(forwarderServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundForwarder = { id: 123 };
        forwarderServiceStub.find.resolves(foundForwarder);
        forwarderServiceStub.retrieve.resolves([foundForwarder]);

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
