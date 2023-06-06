<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="salesDelivery">
        <h2 class="jh-entity-heading" data-cy="salesDeliveryDetailsHeading">
          <span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.detail.title')">SalesDelivery</span> {{ salesDelivery.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.itemName')">Item Name</span>
          </dt>
          <dd>
            <span>{{ salesDelivery.itemName }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.itemId')">Item Id</span>
          </dt>
          <dd>
            <span>{{ salesDelivery.itemId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.boardId')">Board Id</span>
          </dt>
          <dd>
            <span>{{ salesDelivery.boardId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.kingdeeId')">Kingdee Id</span>
          </dt>
          <dd>
            <span>{{ salesDelivery.kingdeeId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.customer')">Customer</span>
          </dt>
          <dd>
            <span>{{ salesDelivery.customer }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.orderDate')">Order Date</span>
          </dt>
          <dd>
            <span>{{ salesDelivery.orderDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.totalActualShipQty')">Total Actual Ship Qty</span>
          </dt>
          <dd>
            <span>{{ salesDelivery.totalActualShipQty }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.totalQtyDelivery')">Total Qty Delivery</span>
          </dt>
          <dd>
            <span>{{ salesDelivery.totalQtyDelivery }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.loadingPort')">Loading Port</span>
          </dt>
          <dd>
            <span>{{ salesDelivery.loadingPort }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.dischargePort')">Discharge Port</span>
          </dt>
          <dd>
            <span>{{ salesDelivery.dischargePort }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.transportMode')">Transport Mode</span>
          </dt>
          <dd>
            <span>{{ salesDelivery.transportMode }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.incoterm')">Incoterm</span>
          </dt>
          <dd>
            <span>{{ salesDelivery.incoterm }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.forwarder')">Forwarder</span>
          </dt>
          <dd>
            <span>{{ salesDelivery.forwarder }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.eta')">Eta</span>
          </dt>
          <dd>
            <span>{{ salesDelivery.eta }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.etd')">Etd</span>
          </dt>
          <dd>
            <span>{{ salesDelivery.etd }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.containerType')">Container Type</span>
          </dt>
          <dd>
            <span>{{ salesDelivery.containerType }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.containerSize')">Container Size</span>
          </dt>
          <dd>
            <span>{{ salesDelivery.containerSize }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.remark')">Remark</span>
          </dt>
          <dd>
            <span>{{ salesDelivery.remark }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.salesDelivery.kingdeeUniqueId')">Kingdee Unique Id</span>
          </dt>
          <dd>
            <span>{{ salesDelivery.kingdeeUniqueId }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="salesDelivery.id"
          :to="{ name: 'SalesDeliveryEdit', params: { salesDeliveryId: salesDelivery.id } }"
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

<script lang="ts" src="./sales-delivery-details.component.ts"></script>
