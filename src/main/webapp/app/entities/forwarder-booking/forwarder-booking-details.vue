<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="forwarderBooking">
        <h2 class="jh-entity-heading" data-cy="forwarderBookingDetailsHeading">
          <span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.detail.title')">ForwarderBooking</span> {{ forwarderBooking.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.itemName')">Item Name</span>
          </dt>
          <dd>
            <span>{{ forwarderBooking.itemName }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.itemId')">Item Id</span>
          </dt>
          <dd>
            <span>{{ forwarderBooking.itemId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.boardId')">Board Id</span>
          </dt>
          <dd>
            <span>{{ forwarderBooking.boardId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.kingdeeId')">Kingdee Id</span>
          </dt>
          <dd>
            <span>{{ forwarderBooking.kingdeeId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.customer')">Customer</span>
          </dt>
          <dd>
            <span>{{ forwarderBooking.customer }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.orderDate')">Order Date</span>
          </dt>
          <dd>
            <span>{{ forwarderBooking.orderDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.forwarder')">Forwarder</span>
          </dt>
          <dd>
            <span>{{ forwarderBooking.forwarder }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.totalQty')">Total Qty</span>
          </dt>
          <dd>
            <span>{{ forwarderBooking.totalQty }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.loadingPort')">Loading Port</span>
          </dt>
          <dd>
            <span>{{ forwarderBooking.loadingPort }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.dischargePort')">Discharge Port</span>
          </dt>
          <dd>
            <span>{{ forwarderBooking.dischargePort }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.containerType')">Container Type</span>
          </dt>
          <dd>
            <span>{{ forwarderBooking.containerType }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.containerSize')">Container Size</span>
          </dt>
          <dd>
            <span>{{ forwarderBooking.containerSize }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.containerNumber')">Container Number</span>
          </dt>
          <dd>
            <span>{{ forwarderBooking.containerNumber }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.supplier')">Supplier</span>
          </dt>
          <dd>
            <span>{{ forwarderBooking.supplier }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.supplierEmail')">Supplier Email</span>
          </dt>
          <dd>
            <span>{{ forwarderBooking.supplierEmail }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.eta')">Eta</span>
          </dt>
          <dd>
            <span>{{ forwarderBooking.eta }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.etd')">Etd</span>
          </dt>
          <dd>
            <span>{{ forwarderBooking.etd }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.transportMode')">Transport Mode</span>
          </dt>
          <dd>
            <span>{{ forwarderBooking.transportMode }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.numberOfCartons')">Number Of Cartons</span>
          </dt>
          <dd>
            <span>{{ forwarderBooking.numberOfCartons }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.numberOfRef')">Number Of Ref</span>
          </dt>
          <dd>
            <span>{{ forwarderBooking.numberOfRef }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.totalVolume')">Total Volume</span>
          </dt>
          <dd>
            <span>{{ forwarderBooking.totalVolume }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.totalWeight')">Total Weight</span>
          </dt>
          <dd>
            <span>{{ forwarderBooking.totalWeight }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.remark')">Remark</span>
          </dt>
          <dd>
            <span>{{ forwarderBooking.remark }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.client')">Client</span>
          </dt>
          <dd>
            <span>{{ forwarderBooking.client }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.kingdeeUniqueId')">Kingdee Unique Id</span>
          </dt>
          <dd>
            <span>{{ forwarderBooking.kingdeeUniqueId }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="forwarderBooking.id"
          :to="{ name: 'ForwarderBookingEdit', params: { forwarderBookingId: forwarderBooking.id } }"
          custom
          v-slot="{ navigate }"
        >
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./forwarder-booking-details.component.ts"></script>
