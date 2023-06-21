<template>
  <div>
    <h2 id="page-heading" data-cy="ForwarderBookingHeading">
      <span v-text="t$('jhipsterSampleApplicationApp.forwarderBooking.home.title')" id="forwarder-booking-heading"></span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="t$('jhipsterSampleApplicationApp.forwarderBooking.home.refreshListLabel')"></span>
        </button>
        <router-link :to="{ name: 'ForwarderBookingCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-forwarder-booking"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="t$('jhipsterSampleApplicationApp.forwarderBooking.home.createLabel')"></span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && forwarderBookings && forwarderBookings.length === 0">
      <span v-text="t$('jhipsterSampleApplicationApp.forwarderBooking.home.notFound')"></span>
    </div>
    <div class="table-responsive" v-if="forwarderBookings && forwarderBookings.length > 0">
      <table class="table table-striped" aria-describedby="forwarderBookings">
        <thead>
          <tr>
            <th scope="row"><span v-text="t$('global.field.id')"></span></th>
            <th scope="row"><span v-text="t$('jhipsterSampleApplicationApp.forwarderBooking.itemName')"></span></th>
            <th scope="row"><span v-text="t$('jhipsterSampleApplicationApp.forwarderBooking.kingdeeId')"></span></th>
            <th scope="row"><span v-text="t$('jhipsterSampleApplicationApp.forwarderBooking.customer')"></span></th>
            <th scope="row"><span v-text="t$('jhipsterSampleApplicationApp.forwarderBooking.orderDate')"></span></th>
            <th scope="row"><span v-text="t$('jhipsterSampleApplicationApp.forwarderBooking.forwarder')"></span></th>
            <th scope="row"><span v-text="t$('jhipsterSampleApplicationApp.forwarderBooking.totalQty')"></span></th>
            <th scope="row"><span v-text="t$('jhipsterSampleApplicationApp.forwarderBooking.loadingPort')"></span></th>
            <th scope="row"><span v-text="t$('jhipsterSampleApplicationApp.forwarderBooking.dischargePort')"></span></th>
            <th scope="row"><span v-text="t$('jhipsterSampleApplicationApp.forwarderBooking.containerType')"></span></th>
            <th scope="row"><span v-text="t$('jhipsterSampleApplicationApp.forwarderBooking.containerSize')"></span></th>
            <th scope="row"><span v-text="t$('jhipsterSampleApplicationApp.forwarderBooking.containerNumber')"></span></th>
            <th scope="row"><span v-text="t$('jhipsterSampleApplicationApp.forwarderBooking.supplier')"></span></th>
            <th scope="row"><span v-text="t$('jhipsterSampleApplicationApp.forwarderBooking.supplierEmail')"></span></th>
            <th scope="row"><span v-text="t$('jhipsterSampleApplicationApp.forwarderBooking.eta')"></span></th>
            <th scope="row"><span v-text="t$('jhipsterSampleApplicationApp.forwarderBooking.etd')"></span></th>
            <th scope="row"><span v-text="t$('jhipsterSampleApplicationApp.forwarderBooking.transportMode')"></span></th>
            <th scope="row"><span v-text="t$('jhipsterSampleApplicationApp.forwarderBooking.numberOfCartons')"></span></th>
            <th scope="row"><span v-text="t$('jhipsterSampleApplicationApp.forwarderBooking.numberOfRef')"></span></th>
            <th scope="row"><span v-text="t$('jhipsterSampleApplicationApp.forwarderBooking.totalVolume')"></span></th>
            <th scope="row"><span v-text="t$('jhipsterSampleApplicationApp.forwarderBooking.totalWeight')"></span></th>
            <th scope="row"><span v-text="t$('jhipsterSampleApplicationApp.forwarderBooking.remark')"></span></th>
            <th scope="row"><span v-text="t$('jhipsterSampleApplicationApp.forwarderBooking.client')"></span></th>
            <th scope="row"><span v-text="t$('jhipsterSampleApplicationApp.forwarderBooking.kingdeeUniqueId')"></span></th>
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
                    <span class="d-none d-md-inline" v-text="t$('entity.action.view')"></span>
                  </button>
                </router-link>
                <router-link
                  :to="{ name: 'ForwarderBookingEdit', params: { forwarderBookingId: forwarderBooking.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="t$('entity.action.edit')"></span>
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
                  <span class="d-none d-md-inline" v-text="t$('entity.action.delete')"></span>
                </b-button>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <template #modal-title>
        <span
          id="jhipsterSampleApplicationApp.forwarderBooking.delete.question"
          data-cy="forwarderBookingDeleteDialogHeading"
          v-text="t$('entity.delete.title')"
        ></span>
      </template>
      <div class="modal-body">
        <p
          id="jhi-delete-forwarderBooking-heading"
          v-text="t$('jhipsterSampleApplicationApp.forwarderBooking.delete.question', { id: removeId })"
        ></p>
      </div>
      <template #modal-footer>
        <div>
          <button type="button" class="btn btn-secondary" v-text="t$('entity.action.cancel')" v-on:click="closeDialog()"></button>
          <button
            type="button"
            class="btn btn-primary"
            id="jhi-confirm-delete-forwarderBooking"
            data-cy="entityConfirmDeleteButton"
            v-text="t$('entity.action.delete')"
            v-on:click="removeForwarderBooking()"
          ></button>
        </div>
      </template>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./forwarder-booking.component.ts"></script>
