import { Component, Provide, Vue } from 'vue-property-decorator';

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

@Component
export default class Entities extends Vue {
  @Provide('userService') private userService = () => new UserService();
  @Provide('groupService') private groupService = () => new GroupService();
  @Provide('itemService') private itemService = () => new ItemService();
  @Provide('mondayColumnService') private mondayColumnService = () => new MondayColumnService();
  @Provide('mondayUserService') private mondayUserService = () => new MondayUserService();
  @Provide('operationSiteService') private operationSiteService = () => new OperationSiteService();
  @Provide('orderFollowUpService') private orderFollowUpService = () => new OrderFollowUpService();
  @Provide('pIService') private pIService = () => new PIService();
  @Provide('processLogService') private processLogService = () => new ProcessLogService();
  @Provide('productTaxmonomyService') private productTaxmonomyService = () => new ProductTaxmonomyService();
  @Provide('supplierService') private supplierService = () => new SupplierService();
  @Provide('uomService') private uomService = () => new UomService();
  @Provide('clientService') private clientService = () => new ClientService();
  @Provide('commercialInvoiceService') private commercialInvoiceService = () => new CommercialInvoiceService();
  @Provide('forwarderService') private forwarderService = () => new ForwarderService();
  @Provide('forwarderBookingService') private forwarderBookingService = () => new ForwarderBookingService();
  @Provide('inspectionService') private inspectionService = () => new InspectionService();
  @Provide('productFinishedService') private productFinishedService = () => new ProductFinishedService();
  @Provide('salesDeliveryService') private salesDeliveryService = () => new SalesDeliveryService();
  // jhipster-needle-add-entity-service-to-entities-component - JHipster will import entities services here
}
