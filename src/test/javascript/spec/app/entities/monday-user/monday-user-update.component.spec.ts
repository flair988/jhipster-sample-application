/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import MondayUserUpdateComponent from '@/entities/monday-user/monday-user-update.vue';
import MondayUserClass from '@/entities/monday-user/monday-user-update.component';
import MondayUserService from '@/entities/monday-user/monday-user.service';

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
  describe('MondayUser Management Update Component', () => {
    let wrapper: Wrapper<MondayUserClass>;
    let comp: MondayUserClass;
    let mondayUserServiceStub: SinonStubbedInstance<MondayUserService>;

    beforeEach(() => {
      mondayUserServiceStub = sinon.createStubInstance<MondayUserService>(MondayUserService);

      wrapper = shallowMount<MondayUserClass>(MondayUserUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          mondayUserService: () => mondayUserServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.mondayUser = entity;
        mondayUserServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(mondayUserServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.mondayUser = entity;
        mondayUserServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(mondayUserServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundMondayUser = { id: 123 };
        mondayUserServiceStub.find.resolves(foundMondayUser);
        mondayUserServiceStub.retrieve.resolves([foundMondayUser]);

        // WHEN
        comp.beforeRouteEnter({ params: { mondayUserId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.mondayUser).toBe(foundMondayUser);
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
