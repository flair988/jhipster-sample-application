/* tslint:disable max-line-length */
import { vitest } from 'vitest';
import { shallowMount, MountingOptions } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import { RouteLocation } from 'vue-router';

import SupplierUpdate from '../../../../../../main/webapp/app/entities/supplier/supplier-update.vue';
import SupplierService from '../../../../../../main/webapp/app/entities/supplier/supplier.service';
import AlertService from '../../../../../../main/webapp/app/shared/alert/alert.service';

type SupplierUpdateComponentType = InstanceType<typeof SupplierUpdate>;

let route: Partial<RouteLocation>;
const routerGoMock = vitest.fn();

vitest.mock('vue-router', () => ({
  useRoute: () => route,
  useRouter: () => ({ go: routerGoMock }),
}));

const supplierSample = { id: 123 };

describe('Component Tests', () => {
  let mountOptions: MountingOptions<SupplierUpdateComponentType>['global'];
  let alertService: AlertService;

  describe('Supplier Management Update Component', () => {
    let comp: SupplierUpdateComponentType;
    let supplierServiceStub: SinonStubbedInstance<SupplierService>;

    beforeEach(() => {
      route = {};
      supplierServiceStub = sinon.createStubInstance<SupplierService>(SupplierService);

      alertService = new AlertService({
        i18n: { t: vitest.fn() } as any,
        bvToast: {
          toast: vitest.fn(),
        } as any,
      });

      mountOptions = {
        stubs: {
          'font-awesome-icon': true,
          'b-input-group': true,
          'b-input-group-prepend': true,
          'b-form-datepicker': true,
          'b-form-input': true,
        },
        provide: {
          alertService,
          supplierService: () => supplierServiceStub,
        },
      };
    });

    afterEach(() => {
      vitest.resetAllMocks();
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const wrapper = shallowMount(SupplierUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.supplier = supplierSample;
        supplierServiceStub.update.resolves(supplierSample);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(supplierServiceStub.update.calledWith(supplierSample)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        supplierServiceStub.create.resolves(entity);
        const wrapper = shallowMount(SupplierUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.supplier = entity;

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(supplierServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        supplierServiceStub.find.resolves(supplierSample);
        supplierServiceStub.retrieve.resolves([supplierSample]);

        // WHEN
        route = {
          params: {
            supplierId: '' + supplierSample.id,
          },
        };
        const wrapper = shallowMount(SupplierUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(comp.supplier).toMatchObject(supplierSample);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        supplierServiceStub.find.resolves(supplierSample);
        const wrapper = shallowMount(SupplierUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        comp.previousState();
        await comp.$nextTick();

        expect(routerGoMock).toHaveBeenCalledWith(-1);
      });
    });
  });
});
