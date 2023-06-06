/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import OperationSiteComponent from '@/entities/operation-site/operation-site.vue';
import OperationSiteClass from '@/entities/operation-site/operation-site.component';
import OperationSiteService from '@/entities/operation-site/operation-site.service';
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
  describe('OperationSite Management Component', () => {
    let wrapper: Wrapper<OperationSiteClass>;
    let comp: OperationSiteClass;
    let operationSiteServiceStub: SinonStubbedInstance<OperationSiteService>;

    beforeEach(() => {
      operationSiteServiceStub = sinon.createStubInstance<OperationSiteService>(OperationSiteService);
      operationSiteServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<OperationSiteClass>(OperationSiteComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          operationSiteService: () => operationSiteServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      operationSiteServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllOperationSites();
      await comp.$nextTick();

      // THEN
      expect(operationSiteServiceStub.retrieve.called).toBeTruthy();
      expect(comp.operationSites[0]).toEqual(expect.objectContaining({ id: 123 }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      operationSiteServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      expect(operationSiteServiceStub.retrieve.callCount).toEqual(1);

      comp.removeOperationSite();
      await comp.$nextTick();

      // THEN
      expect(operationSiteServiceStub.delete.called).toBeTruthy();
      expect(operationSiteServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
