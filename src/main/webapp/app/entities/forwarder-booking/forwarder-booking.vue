<template>
  <div>
    <h2 id="page-heading" data-cy="ForwarderBookingHeading">
      <span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.home.title')" id="forwarder-booking-heading">Forwarder Bookings</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'ForwarderBookingCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-forwarder-booking"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.home.createLabel')"> Create a new Forwarder Booking </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && forwarderBookings && forwarderBookings.length === 0">
      <span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.home.notFound')">No forwarderBookings found</span>
    </div>
    <div class="table-responsive" v-if="forwarderBookings && forwarderBookings.length > 0">
      <table class="table table-striped" aria-describedby="forwarderBookings">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.itemName')">Item Name</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.itemId')">Item Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.boardId')">Board Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.kingdeeId')">Kingdee Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.customer')">Customer</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.orderDate')">Order Date</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.forwarder')">Forwarder</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.totalQty')">Total Qty</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.loadingPort')">Loading Port</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.dischargePort')">Discharge Port</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.containerType')">Container Type</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.containerSize')">Container Size</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.containerNumber')">Container Number</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.supplier')">Supplier</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.supplierEmail')">Supplier Email</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.eta')">Eta</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.etd')">Etd</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.transportMode')">Transport Mode</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.numberOfCartons')">Number Of Cartons</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.numberOfRef')">Number Of Ref</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.totalVolume')">Total Volume</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.totalWeight')">Total Weight</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.remark')">Remark</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.client')">Client</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.kingdeeUniqueId')">Kingdee Unique Id</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="forwarderBooking in forwarderBookings" :key="forwarderBooking.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'ForwarderBookingView', params: { forwarderBookingId: forwarderBooking.id } }">{{
                forwarderBooking.id
              }}</router-link>
            </td>
            <td>{{ forwarderBooking.itemName }}</td>
            <td>{{ forwarderBooking.itemId }}</td>
            <td>{{ forwarderBooking.boardId }}</td>
            <td>{{ forwarderBooking.kingdeeId }}</td>
            <td>{{ forwarderBooking.customer }}</td>
            <td>{{ forwarderBooking.orderDate }}</td>
            <td>{{ forwarderBooking.forwarder }}</td>
            <td>{{ forwarderBooking.totalQty }}</td>
            <td>{{ forwarderBooking.loadingPort }}</td>
            <td>{{ forwarderBooking.dischargePort }}</td>
            <td>{{ forwarderBooking.containerType }}</td>
            <td>{{ forwarderBooking.containerSize }}</td>
            <td>{{ forwarderBooking.containerNumber }}</td>
            <td>{{ forwarderBooking.supplier }}</td>
            <td>{{ forwarderBooking.supplierEmail }}</td>
            <td>{{ forwarderBooking.eta }}</td>
            <td>{{ forwarderBooking.etd }}</td>
            <td>{{ forwarderBooking.transportMode }}</td>
            <td>{{ forwarderBooking.numberOfCartons }}</td>
            <td>{{ forwarderBooking.numberOfRef }}</td>
            <td>{{ forwarderBooking.totalVolume }}</td>
            <td>{{ forwarderBooking.totalWeight }}</td>
            <td>{{ forwarderBooking.remark }}</td>
            <td>{{ forwarderBooking.client }}</td>
            <td>{{ forwarderBooking.kingdeeUniqueId }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'ForwarderBookingView', params: { forwarderBookingId: forwarderBooking.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link
                  :to="{ name: 'ForwarderBookingEdit', params: { forwarderBookingId: forwarderBooking.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(forwarderBooking)"
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
          id="jhipsterSampleApplicationApp.forwarderBooking.delete.question"
          data-cy="forwarderBookingDeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p
          id="jhi-delete-forwarderBooking-heading"
          v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.delete.question', { id: removeId })"
        >
          Are you sure you want to delete this Forwarder Booking?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-forwarderBooking"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeForwarderBooking()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./forwarder-booking.component.ts"></script>
