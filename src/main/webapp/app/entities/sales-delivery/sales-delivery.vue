<template>
  <div>
    <h2 id="page-heading" data-cy="SalesDeliveryHeading">
      <span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.home.title')" id="sales-delivery-heading">Sales Deliveries</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'SalesDeliveryCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-sales-delivery"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.home.createLabel')"> Create a new Sales Delivery </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && salesDeliveries && salesDeliveries.length === 0">
      <span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.home.notFound')">No salesDeliveries found</span>
    </div>
    <div class="table-responsive" v-if="salesDeliveries && salesDeliveries.length > 0">
      <table class="table table-striped" aria-describedby="salesDeliveries">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.itemName')">Item Name</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.itemId')">Item Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.boardId')">Board Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.kingdeeId')">Kingdee Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.customer')">Customer</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.orderDate')">Order Date</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.totalActualShipQty')">Total Actual Ship Qty</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.totalQtyDelivery')">Total Qty Delivery</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.loadingPort')">Loading Port</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.dischargePort')">Discharge Port</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.transportMode')">Transport Mode</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.incoterm')">Incoterm</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.forwarder')">Forwarder</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.eta')">Eta</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.etd')">Etd</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.containerType')">Container Type</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.containerSize')">Container Size</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.remark')">Remark</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.kingdeeUniqueId')">Kingdee Unique Id</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="salesDelivery in salesDeliveries" :key="salesDelivery.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'SalesDeliveryView', params: { salesDeliveryId: salesDelivery.id } }">{{
                salesDelivery.id
              }}</router-link>
            </td>
            <td>{{ salesDelivery.itemName }}</td>
            <td>{{ salesDelivery.itemId }}</td>
            <td>{{ salesDelivery.boardId }}</td>
            <td>{{ salesDelivery.kingdeeId }}</td>
            <td>{{ salesDelivery.customer }}</td>
            <td>{{ salesDelivery.orderDate }}</td>
            <td>{{ salesDelivery.totalActualShipQty }}</td>
            <td>{{ salesDelivery.totalQtyDelivery }}</td>
            <td>{{ salesDelivery.loadingPort }}</td>
            <td>{{ salesDelivery.dischargePort }}</td>
            <td>{{ salesDelivery.transportMode }}</td>
            <td>{{ salesDelivery.incoterm }}</td>
            <td>{{ salesDelivery.forwarder }}</td>
            <td>{{ salesDelivery.eta }}</td>
            <td>{{ salesDelivery.etd }}</td>
            <td>{{ salesDelivery.containerType }}</td>
            <td>{{ salesDelivery.containerSize }}</td>
            <td>{{ salesDelivery.remark }}</td>
            <td>{{ salesDelivery.kingdeeUniqueId }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'SalesDeliveryView', params: { salesDeliveryId: salesDelivery.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link
                  :to="{ name: 'SalesDeliveryEdit', params: { salesDeliveryId: salesDelivery.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(salesDelivery)"
                  variant="danger"
                  class="btn btn-sm"
                  data-cy="entityDeleteButton"
                  v-b-modal.removeEntity
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.delete')">Delete</span>
                </b-button>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span
          id="jhipsterSampleApplicationApp.salesDelivery.delete.question"
          data-cy="salesDeliveryDeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p
          id="jhi-delete-salesDelivery-heading"
          v-text="$t('jhipsterSampleApplicationApp.salesDelivery.delete.question', { id: removeId })"
        >
          Are you sure you want to delete this Sales Delivery?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-salesDelivery"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeSalesDelivery()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./sales-delivery.component.ts"></script>
