<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="pI">
        <h2 class="jh-entity-heading" data-cy="pIDetailsHeading">
          <span v-text="$t('jhipsterSampleApplicationApp.pI.detail.title')">PI</span> {{ pI.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.pI.itemName')">Item Name</span>
          </dt>
          <dd>
            <span>{{ pI.itemName }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.pI.itemCode')">Item Code</span>
          </dt>
          <dd>
            <span>{{ pI.itemCode }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.pI.poNumber')">Po Number</span>
          </dt>
          <dd>
            <span>{{ pI.poNumber }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.pI.isNewItem')">Is New Item</span>
          </dt>
          <dd>
            <span>{{ pI.isNewItem }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.pI.category')">Category</span>
          </dt>
          <dd>
            <span>{{ pI.category }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.pI.client')">Client</span>
          </dt>
          <dd>
            <span>{{ pI.client }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.pI.supplier')">Supplier</span>
          </dt>
          <dd>
            <span>{{ pI.supplier }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.pI.supplierCode')">Supplier Code</span>
          </dt>
          <dd>
            <span>{{ pI.supplierCode }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.pI.orderDate')">Order Date</span>
          </dt>
          <dd>
            <span>{{ pI.orderDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.pI.port')">Port</span>
          </dt>
          <dd>
            <span>{{ pI.port }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.pI.requestedEndOfProdDate')">Requested End Of Prod Date</span>
          </dt>
          <dd>
            <span>{{ pI.requestedEndOfProdDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.pI.itemQuantity')">Item Quantity</span>
          </dt>
          <dd>
            <span>{{ pI.itemQuantity }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.pI.countryOfOrigin')">Country Of Origin</span>
          </dt>
          <dd>
            <span>{{ pI.countryOfOrigin }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.pI.countryOfFinalDestination')">Country Of Final Destination</span>
          </dt>
          <dd>
            <span>{{ pI.countryOfFinalDestination }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.pI.productionLeadTimeCommitment')">Production Lead Time Commitment</span>
          </dt>
          <dd>
            <span>{{ pI.productionLeadTimeCommitment }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.pI.consignee')">Consignee</span>
          </dt>
          <dd>
            <span>{{ pI.consignee }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.pI.carriageBy')">Carriage By</span>
          </dt>
          <dd>
            <span>{{ pI.carriageBy }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.pI.termsOfDelivery')">Terms Of Delivery</span>
          </dt>
          <dd>
            <span>{{ pI.termsOfDelivery }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.pI.termsOfPayment')">Terms Of Payment</span>
          </dt>
          <dd>
            <span>{{ pI.termsOfPayment }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.pI.itemUnit')">Item Unit</span>
          </dt>
          <dd>
            <span>{{ pI.itemUnit }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.pI.rate')">Rate</span>
          </dt>
          <dd>
            <span>{{ pI.rate }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.pI.amount')">Amount</span>
          </dt>
          <dd>
            <span>{{ pI.amount }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.pI.totalAmount')">Total Amount</span>
          </dt>
          <dd>
            <span>{{ pI.totalAmount }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.pI.discountRate')">Discount Rate</span>
          </dt>
          <dd>
            <span>{{ pI.discountRate }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.pI.currency')">Currency</span>
          </dt>
          <dd>
            <span>{{ pI.currency }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.pI.piStatus')">Pi Status</span>
          </dt>
          <dd>
            <span>{{ pI.piStatus }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.pI.remarks')">Remarks</span>
          </dt>
          <dd>
            <span>{{ pI.remarks }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.pI.itemId')">Item Id</span>
          </dt>
          <dd>
            <span>{{ pI.itemId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.pI.boardId')">Board Id</span>
          </dt>
          <dd>
            <span>{{ pI.boardId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.pI.kingdeeId')">Kingdee Id</span>
          </dt>
          <dd>
            <span>{{ pI.kingdeeId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.pI.portOfDischarge')">Port Of Discharge</span>
          </dt>
          <dd>
            <span>{{ pI.portOfDischarge }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.pI.portOfLoading')">Port Of Loading</span>
          </dt>
          <dd>
            <span>{{ pI.portOfLoading }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link v-if="pI.id" :to="{ name: 'PIEdit', params: { pIId: pI.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./pi-details.component.ts"></script>
