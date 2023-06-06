/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import MondayUserComponent from '@/entities/monday-user/monday-user.vue';
import MondayUserClass from '@/entities/monday-user/monday-user.component';
import MondayUserService from '@/entities/monday-user/monday-user.service';
import AlertService from '@/shared/alert/alert.service';

const localVue = createLocalVue();
localVue.use(ToastPlugin);

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('b-badge', {});
localVue.directive('b-modal', {});
localVue.component('b-button', {});
localVue.component('router-link', {});

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {},
  },
};

describe('Component Tests', () => {
  describe('MondayUser Management Component', () => {
    let wrapper: Wrapper<MondayUserClass>;
    let comp: MondayUserClass;
    let mondayUserServiceStub: SinonStubbedInstance<MondayUserService>;

    beforeEach(() => {
      mondayUserServiceStub = sinon.createStubInstance<MondayUserService>(MondayUserService);
      mondayUserServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<MondayUserClass>(MondayUserComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          mondayUserService: () => mondayUserServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      mondayUserServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllMondayUsers();
      await comp.$nextTick();

      // THEN
      expect(mondayUserServiceStub.retrieve.called).toBeTruthy();
      expect(comp.mondayUsers[0]).toEqual(expect.objectContaining({ id: 123 }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      mondayUserServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      expect(mondayUserServiceStub.retrieve.callCount).toEqual(1);

      comp.removeMondayUser();
      await comp.$nextTick();

      // THEN
      expect(mondayUserServiceStub.delete.called).toBeTruthy();
      expect(mondayUserServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
