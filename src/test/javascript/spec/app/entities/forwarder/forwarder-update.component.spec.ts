/* tslint:disable max-line-length */
import { vitest } from 'vitest';
import { shallowMount, MountingOptions } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import { RouteLocation } from 'vue-router';

import ForwarderUpdate from '../../../../../../main/webapp/app/entities/forwarder/forwarder-update.vue';
import ForwarderService from '../../../../../../main/webapp/app/entities/forwarder/forwarder.service';
import AlertService from '../../../../../../main/webapp/app/shared/alert/alert.service';

type ForwarderUpdateComponentType = InstanceType<typeof ForwarderUpdate>;

let route: Partial<RouteLocation>;
const routerGoMock = vitest.fn();

vitest.mock('vue-router', () => ({
  useRoute: () => route,
  useRouter: () => ({ go: routerGoMock }),
}));

const forwarderSample = { id: 123 };

describe('Component Tests', () => {
  let mountOptions: MountingOptions<ForwarderUpdateComponentType>['global'];
  let alertService: AlertService;

  describe('Forwarder Management Update Component', () => {
    let comp: ForwarderUpdateComponentType;
    let forwarderServiceStub: SinonStubbedInstance<ForwarderService>;

    beforeEach(() => {
      route = {};
      forwarderServiceStub = sinon.createStubInstance<ForwarderService>(ForwarderService);

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
          forwarderService: () => forwarderServiceStub,
        },
      };
    });

    afterEach(() => {
      vitest.resetAllMocks();
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const wrapper = shallowMount(ForwarderUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.forwarder = forwarderSample;
        forwarderServiceStub.update.resolves(forwarderSample);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(forwarderServiceStub.update.calledWith(forwarderSample)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        forwarderServiceStub.create.resolves(entity);
        const wrapper = shallowMount(ForwarderUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.forwarder = entity;

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
        forwarderServiceStub.find.resolves(forwarderSample);
        forwarderServiceStub.retrieve.resolves([forwarderSample]);

        // WHEN
        route = {
          params: {
            forwarderId: '' + forwarderSample.id,
          },
        };
        const wrapper = shallowMount(ForwarderUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(comp.forwarder).toMatchObject(forwarderSample);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        forwarderServiceStub.find.resolves(forwarderSample);
        const wrapper = shallowMount(ForwarderUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        comp.previousState();
        await comp.$nextTick();

        expect(routerGoMock).toHaveBeenCalledWith(-1);
      });
    });
  });
});
