import { Authority } from '@/shared/security/authority';
/* tslint:disable */
// prettier-ignore
const Entities = () => import('@/entities/entities.vue');

// prettier-ignore
const Group = () => import('@/entities/group/group.vue');
// prettier-ignore
const GroupUpdate = () => import('@/entities/group/group-update.vue');
// prettier-ignore
const GroupDetails = () => import('@/entities/group/group-details.vue');
// prettier-ignore
const Item = () => import('@/entities/item/item.vue');
// prettier-ignore
const ItemUpdate = () => import('@/entities/item/item-update.vue');
// prettier-ignore
const ItemDetails = () => import('@/entities/item/item-details.vue');
// prettier-ignore
const MondayColumn = () => import('@/entities/monday-column/monday-column.vue');
// prettier-ignore
const MondayColumnUpdate = () => import('@/entities/monday-column/monday-column-update.vue');
// prettier-ignore
const MondayColumnDetails = () => import('@/entities/monday-column/monday-column-details.vue');
// prettier-ignore
const MondayUser = () => import('@/entities/monday-user/monday-user.vue');
// prettier-ignore
const MondayUserUpdate = () => import('@/entities/monday-user/monday-user-update.vue');
// prettier-ignore
const MondayUserDetails = () => import('@/entities/monday-user/monday-user-details.vue');
// prettier-ignore
const OperationSite = () => import('@/entities/operation-site/operation-site.vue');
// prettier-ignore
const OperationSiteUpdate = () => import('@/entities/operation-site/operation-site-update.vue');
// prettier-ignore
const OperationSiteDetails = () => import('@/entities/operation-site/operation-site-details.vue');
// prettier-ignore
const OrderFollowUp = () => import('@/entities/order-follow-up/order-follow-up.vue');
// prettier-ignore
const OrderFollowUpUpdate = () => import('@/entities/order-follow-up/order-follow-up-update.vue');
// prettier-ignore
const OrderFollowUpDetails = () => import('@/entities/order-follow-up/order-follow-up-details.vue');
// prettier-ignore
const PI = () => import('@/entities/pi/pi.vue');
// prettier-ignore
const PIUpdate = () => import('@/entities/pi/pi-update.vue');
// prettier-ignore
const PIDetails = () => import('@/entities/pi/pi-details.vue');
// prettier-ignore
const ProcessLog = () => import('@/entities/process-log/process-log.vue');
// prettier-ignore
const ProcessLogUpdate = () => import('@/entities/process-log/process-log-update.vue');
// prettier-ignore
const ProcessLogDetails = () => import('@/entities/process-log/process-log-details.vue');
// prettier-ignore
const ProductTaxmonomy = () => import('@/entities/product-taxmonomy/product-taxmonomy.vue');
// prettier-ignore
const ProductTaxmonomyUpdate = () => import('@/entities/product-taxmonomy/product-taxmonomy-update.vue');
// prettier-ignore
const ProductTaxmonomyDetails = () => import('@/entities/product-taxmonomy/product-taxmonomy-details.vue');
// prettier-ignore
const Supplier = () => import('@/entities/supplier/supplier.vue');
// prettier-ignore
const SupplierUpdate = () => import('@/entities/supplier/supplier-update.vue');
// prettier-ignore
const SupplierDetails = () => import('@/entities/supplier/supplier-details.vue');
// prettier-ignore
const Uom = () => import('@/entities/uom/uom.vue');
// prettier-ignore
const UomUpdate = () => import('@/entities/uom/uom-update.vue');
// prettier-ignore
const UomDetails = () => import('@/entities/uom/uom-details.vue');
// prettier-ignore
const Client = () => import('@/entities/client/client.vue');
// prettier-ignore
const ClientUpdate = () => import('@/entities/client/client-update.vue');
// prettier-ignore
const ClientDetails = () => import('@/entities/client/client-details.vue');
// prettier-ignore
const CommercialInvoice = () => import('@/entities/commercial-invoice/commercial-invoice.vue');
// prettier-ignore
const CommercialInvoiceUpdate = () => import('@/entities/commercial-invoice/commercial-invoice-update.vue');
// prettier-ignore
const CommercialInvoiceDetails = () => import('@/entities/commercial-invoice/commercial-invoice-details.vue');
// prettier-ignore
const Forwarder = () => import('@/entities/forwarder/forwarder.vue');
// prettier-ignore
const ForwarderUpdate = () => import('@/entities/forwarder/forwarder-update.vue');
// prettier-ignore
const ForwarderDetails = () => import('@/entities/forwarder/forwarder-details.vue');
// prettier-ignore
const ForwarderBooking = () => import('@/entities/forwarder-booking/forwarder-booking.vue');
// prettier-ignore
const ForwarderBookingUpdate = () => import('@/entities/forwarder-booking/forwarder-booking-update.vue');
// prettier-ignore
const ForwarderBookingDetails = () => import('@/entities/forwarder-booking/forwarder-booking-details.vue');
// prettier-ignore
const Inspection = () => import('@/entities/inspection/inspection.vue');
// prettier-ignore
const InspectionUpdate = () => import('@/entities/inspection/inspection-update.vue');
// prettier-ignore
const InspectionDetails = () => import('@/entities/inspection/inspection-details.vue');
// prettier-ignore
const ProductFinished = () => import('@/entities/product-finished/product-finished.vue');
// prettier-ignore
const ProductFinishedUpdate = () => import('@/entities/product-finished/product-finished-update.vue');
// prettier-ignore
const ProductFinishedDetails = () => import('@/entities/product-finished/product-finished-details.vue');
// prettier-ignore
const SalesDelivery = () => import('@/entities/sales-delivery/sales-delivery.vue');
// prettier-ignore
const SalesDeliveryUpdate = () => import('@/entities/sales-delivery/sales-delivery-update.vue');
// prettier-ignore
const SalesDeliveryDetails = () => import('@/entities/sales-delivery/sales-delivery-details.vue');
// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

export default {
  path: '/',
  component: Entities,
  children: [
    {
      path: 'group',
      name: 'Group',
      component: Group,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'group/new',
      name: 'GroupCreate',
      component: GroupUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'group/:groupId/edit',
      name: 'GroupEdit',
      component: GroupUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'group/:groupId/view',
      name: 'GroupView',
      component: GroupDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'item',
      name: 'Item',
      component: Item,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'item/new',
      name: 'ItemCreate',
      component: ItemUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'item/:itemId/edit',
      name: 'ItemEdit',
      component: ItemUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'item/:itemId/view',
      name: 'ItemView',
      component: ItemDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'monday-column',
      name: 'MondayColumn',
      component: MondayColumn,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'monday-column/new',
      name: 'MondayColumnCreate',
      component: MondayColumnUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'monday-column/:mondayColumnId/edit',
      name: 'MondayColumnEdit',
      component: MondayColumnUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'monday-column/:mondayColumnId/view',
      name: 'MondayColumnView',
      component: MondayColumnDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'monday-user',
      name: 'MondayUser',
      component: MondayUser,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'monday-user/new',
      name: 'MondayUserCreate',
      component: MondayUserUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'monday-user/:mondayUserId/edit',
      name: 'MondayUserEdit',
      component: MondayUserUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'monday-user/:mondayUserId/view',
      name: 'MondayUserView',
      component: MondayUserDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'operation-site',
      name: 'OperationSite',
      component: OperationSite,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'operation-site/new',
      name: 'OperationSiteCreate',
      component: OperationSiteUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'operation-site/:operationSiteId/edit',
      name: 'OperationSiteEdit',
      component: OperationSiteUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'operation-site/:operationSiteId/view',
      name: 'OperationSiteView',
      component: OperationSiteDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'order-follow-up',
      name: 'OrderFollowUp',
      component: OrderFollowUp,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'order-follow-up/new',
      name: 'OrderFollowUpCreate',
      component: OrderFollowUpUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'order-follow-up/:orderFollowUpId/edit',
      name: 'OrderFollowUpEdit',
      component: OrderFollowUpUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'order-follow-up/:orderFollowUpId/view',
      name: 'OrderFollowUpView',
      component: OrderFollowUpDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'pi',
      name: 'PI',
      component: PI,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'pi/new',
      name: 'PICreate',
      component: PIUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'pi/:pIId/edit',
      name: 'PIEdit',
      component: PIUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'pi/:pIId/view',
      name: 'PIView',
      component: PIDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'process-log',
      name: 'ProcessLog',
      component: ProcessLog,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'process-log/new',
      name: 'ProcessLogCreate',
      component: ProcessLogUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'process-log/:processLogId/edit',
      name: 'ProcessLogEdit',
      component: ProcessLogUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'process-log/:processLogId/view',
      name: 'ProcessLogView',
      component: ProcessLogDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'product-taxmonomy',
      name: 'ProductTaxmonomy',
      component: ProductTaxmonomy,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'product-taxmonomy/new',
      name: 'ProductTaxmonomyCreate',
      component: ProductTaxmonomyUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'product-taxmonomy/:productTaxmonomyId/edit',
      name: 'ProductTaxmonomyEdit',
      component: ProductTaxmonomyUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'product-taxmonomy/:productTaxmonomyId/view',
      name: 'ProductTaxmonomyView',
      component: ProductTaxmonomyDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'supplier',
      name: 'Supplier',
      component: Supplier,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'supplier/new',
      name: 'SupplierCreate',
      component: SupplierUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'supplier/:supplierId/edit',
      name: 'SupplierEdit',
      component: SupplierUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'supplier/:supplierId/view',
      name: 'SupplierView',
      component: SupplierDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'uom',
      name: 'Uom',
      component: Uom,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'uom/new',
      name: 'UomCreate',
      component: UomUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'uom/:uomId/edit',
      name: 'UomEdit',
      component: UomUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'uom/:uomId/view',
      name: 'UomView',
      component: UomDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'client',
      name: 'Client',
      component: Client,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'client/new',
      name: 'ClientCreate',
      component: ClientUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'client/:clientId/edit',
      name: 'ClientEdit',
      component: ClientUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'client/:clientId/view',
      name: 'ClientView',
      component: ClientDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'commercial-invoice',
      name: 'CommercialInvoice',
      component: CommercialInvoice,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'commercial-invoice/new',
      name: 'CommercialInvoiceCreate',
      component: CommercialInvoiceUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'commercial-invoice/:commercialInvoiceId/edit',
      name: 'CommercialInvoiceEdit',
      component: CommercialInvoiceUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'commercial-invoice/:commercialInvoiceId/view',
      name: 'CommercialInvoiceView',
      component: CommercialInvoiceDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'forwarder',
      name: 'Forwarder',
      component: Forwarder,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'forwarder/new',
      name: 'ForwarderCreate',
      component: ForwarderUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'forwarder/:forwarderId/edit',
      name: 'ForwarderEdit',
      component: ForwarderUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'forwarder/:forwarderId/view',
      name: 'ForwarderView',
      component: ForwarderDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'forwarder-booking',
      name: 'ForwarderBooking',
      component: ForwarderBooking,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'forwarder-booking/new',
      name: 'ForwarderBookingCreate',
      component: ForwarderBookingUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'forwarder-booking/:forwarderBookingId/edit',
      name: 'ForwarderBookingEdit',
      component: ForwarderBookingUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'forwarder-booking/:forwarderBookingId/view',
      name: 'ForwarderBookingView',
      component: ForwarderBookingDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'inspection',
      name: 'Inspection',
      component: Inspection,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'inspection/new',
      name: 'InspectionCreate',
      component: InspectionUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'inspection/:inspectionId/edit',
      name: 'InspectionEdit',
      component: InspectionUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'inspection/:inspectionId/view',
      name: 'InspectionView',
      component: InspectionDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'product-finished',
      name: 'ProductFinished',
      component: ProductFinished,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'product-finished/new',
      name: 'ProductFinishedCreate',
      component: ProductFinishedUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'product-finished/:productFinishedId/edit',
      name: 'ProductFinishedEdit',
      component: ProductFinishedUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'product-finished/:productFinishedId/view',
      name: 'ProductFinishedView',
      component: ProductFinishedDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'sales-delivery',
      name: 'SalesDelivery',
      component: SalesDelivery,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'sales-delivery/new',
      name: 'SalesDeliveryCreate',
      component: SalesDeliveryUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'sales-delivery/:salesDeliveryId/edit',
      name: 'SalesDeliveryEdit',
      component: SalesDeliveryUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'sales-delivery/:salesDeliveryId/view',
      name: 'SalesDeliveryView',
      component: SalesDeliveryDetails,
      meta: { authorities: [Authority.USER] },
    },
    // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
  ],
};
