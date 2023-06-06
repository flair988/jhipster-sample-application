/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import MondayUserDetailComponent from '@/entities/monday-user/monday-user-details.vue';
import MondayUserClass from '@/entities/monday-user/monday-user-details.component';
import MondayUserService from '@/entities/monday-user/monday-user.service';
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
  describe('MondayUser Management Detail Component', () => {
    let wrapper: Wrapper<MondayUserClass>;
    let comp: MondayUserClass;
    let mondayUserServiceStub: SinonStubbedInstance<MondayUserService>;

    beforeEach(() => {
      mondayUserServiceStub = sinon.createStubInstance<MondayUserService>(MondayUserService);

      wrapper = shallowMount<MondayUserClass>(MondayUserDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { mondayUserService: () => mondayUserServiceStub, alertService: () => new AlertService() },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundMondayUser = { id: 123 };
        mondayUserServiceStub.find.resolves(foundMondayUser);

        // WHEN
        comp.retrieveMondayUser(123);
        await comp.$nextTick();

        // THEN
        expect(comp.mondayUser).toBe(foundMondayUser);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundMondayUser = { id: 123 };
        mondayUserServiceStub.find.resolves(foundMondayUser);

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
