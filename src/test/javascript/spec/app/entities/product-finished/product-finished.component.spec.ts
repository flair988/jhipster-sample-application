/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import ProductFinishedComponent from '@/entities/product-finished/product-finished.vue';
import ProductFinishedClass from '@/entities/product-finished/product-finished.component';
import ProductFinishedService from '@/entities/product-finished/product-finished.service';
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
  describe('ProductFinished Management Component', () => {
    let wrapper: Wrapper<ProductFinishedClass>;
    let comp: ProductFinishedClass;
    let productFinishedServiceStub: SinonStubbedInstance<ProductFinishedService>;

    beforeEach(() => {
      productFinishedServiceStub = sinon.createStubInstance<ProductFinishedService>(ProductFinishedService);
      productFinishedServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<ProductFinishedClass>(ProductFinishedComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          productFinishedService: () => productFinishedServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      productFinishedServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllProductFinisheds();
      await comp.$nextTick();

      // THEN
      expect(productFinishedServiceStub.retrieve.called).toBeTruthy();
      expect(comp.productFinisheds[0]).toEqual(expect.objectContaining({ id: 123 }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      productFinishedServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      expect(productFinishedServiceStub.retrieve.callCount).toEqual(1);

      comp.removeProductFinished();
      await comp.$nextTick();

      // THEN
      expect(productFinishedServiceStub.delete.called).toBeTruthy();
      expect(productFinishedServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
