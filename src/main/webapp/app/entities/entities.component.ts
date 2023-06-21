import { defineComponent, provide } from 'vue';

import UserService from '@/entities/user/user.service';
import GroupService from './group/group.service';
import ItemService from './item/item.service';
import MondayColumnService from './monday-column/monday-column.service';
import MondayUserService from './monday-user/monday-user.service';
import OperationSiteService from './operation-site/operation-site.service';
import OrderFollowUpService from './order-follow-up/order-follow-up.service';
import PIService from './pi/pi.service';
import ProcessLogService from './process-log/process-log.service';
import ProductTaxmonomyService from './product-taxmonomy/product-taxmonomy.service';
import SupplierService from './supplier/supplier.service';
import UomService from './uom/uom.service';
import ClientService from './client/client.service';
import CommercialInvoiceService from './commercial-invoice/commercial-invoice.service';
import ForwarderService from './forwarder/forwarder.service';
import ForwarderBookingService from './forwarder-booking/forwarder-booking.service';
import InspectionService from './inspection/inspection.service';
import ProductFinishedService from './product-finished/product-finished.service';
import SalesDeliveryService from './sales-delivery/sales-delivery.service';
// jhipster-needle-add-entity-service-to-entities-component-import - JHipster will import entities services here

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'Entities',
  setup() {
    provide('userService', () => new UserService());
    provide('groupService', () => new GroupService());
    provide('itemService', () => new ItemService());
    provide('mondayColumnService', () => new MondayColumnService());
    provide('mondayUserService', () => new MondayUserService());
    provide('operationSiteService', () => new OperationSiteService());
    provide('orderFollowUpService', () => new OrderFollowUpService());
    provide('pIService', () => new PIService());
    provide('processLogService', () => new ProcessLogService());
    provide('productTaxmonomyService', () => new ProductTaxmonomyService());
    provide('supplierService', () => new SupplierService());
    provide('uomService', () => new UomService());
    provide('clientService', () => new ClientService());
    provide('commercialInvoiceService', () => new CommercialInvoiceService());
    provide('forwarderService', () => new ForwarderService());
    provide('forwarderBookingService', () => new ForwarderBookingService());
    provide('inspectionService', () => new InspectionService());
    provide('productFinishedService', () => new ProductFinishedService());
    provide('salesDeliveryService', () => new SalesDeliveryService());
    // jhipster-needle-add-entity-service-to-entities-component - JHipster will import entities services here
  },
});
