<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterSampleApplicationApp.pI.home.createOrEditLabel"
          data-cy="PICreateUpdateHeading"
          v-text="$t('jhipsterSampleApplicationApp.pI.home.createOrEditLabel')"
        >
          Create or edit a PI
        </h2>
        <div>
          <div class="form-group" v-if="pI.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="pI.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.pI.itemName')" for="pi-itemName">Item Name</label>
            <input
              type="text"
              class="form-control"
              name="itemName"
              id="pi-itemName"
              data-cy="itemName"
              :class="{ valid: !$v.pI.itemName.$invalid, invalid: $v.pI.itemName.$invalid }"
              v-model="$v.pI.itemName.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.pI.itemCode')" for="pi-itemCode">Item Code</label>
            <input
              type="text"
              class="form-control"
              name="itemCode"
              id="pi-itemCode"
              data-cy="itemCode"
              :class="{ valid: !$v.pI.itemCode.$invalid, invalid: $v.pI.itemCode.$invalid }"
              v-model="$v.pI.itemCode.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.pI.poNumber')" for="pi-poNumber">Po Number</label>
            <input
              type="text"
              class="form-control"
              name="poNumber"
              id="pi-poNumber"
              data-cy="poNumber"
              :class="{ valid: !$v.pI.poNumber.$invalid, invalid: $v.pI.poNumber.$invalid }"
              v-model="$v.pI.poNumber.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.pI.isNewItem')" for="pi-isNewItem"
              >Is New Item</label
            >
            <input
              type="text"
              class="form-control"
              name="isNewItem"
              id="pi-isNewItem"
              data-cy="isNewItem"
              :class="{ valid: !$v.pI.isNewItem.$invalid, invalid: $v.pI.isNewItem.$invalid }"
              v-model="$v.pI.isNewItem.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.pI.category')" for="pi-category">Category</label>
            <input
              type="text"
              class="form-control"
              name="category"
              id="pi-category"
              data-cy="category"
              :class="{ valid: !$v.pI.category.$invalid, invalid: $v.pI.category.$invalid }"
              v-model="$v.pI.category.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.pI.client')" for="pi-client">Client</label>
            <input
              type="text"
              class="form-control"
              name="client"
              id="pi-client"
              data-cy="client"
              :class="{ valid: !$v.pI.client.$invalid, invalid: $v.pI.client.$invalid }"
              v-model="$v.pI.client.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.pI.supplier')" for="pi-supplier">Supplier</label>
            <input
              type="text"
              class="form-control"
              name="supplier"
              id="pi-supplier"
              data-cy="supplier"
              :class="{ valid: !$v.pI.supplier.$invalid, invalid: $v.pI.supplier.$invalid }"
              v-model="$v.pI.supplier.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.pI.supplierCode')" for="pi-supplierCode"
              >Supplier Code</label
            >
            <input
              type="text"
              class="form-control"
              name="supplierCode"
              id="pi-supplierCode"
              data-cy="supplierCode"
              :class="{ valid: !$v.pI.supplierCode.$invalid, invalid: $v.pI.supplierCode.$invalid }"
              v-model="$v.pI.supplierCode.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.pI.orderDate')" for="pi-orderDate">Order Date</label>
            <input
              type="text"
              class="form-control"
              name="orderDate"
              id="pi-orderDate"
              data-cy="orderDate"
              :class="{ valid: !$v.pI.orderDate.$invalid, invalid: $v.pI.orderDate.$invalid }"
              v-model="$v.pI.orderDate.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.pI.port')" for="pi-port">Port</label>
            <input
              type="text"
              class="form-control"
              name="port"
              id="pi-port"
              data-cy="port"
              :class="{ valid: !$v.pI.port.$invalid, invalid: $v.pI.port.$invalid }"
              v-model="$v.pI.port.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.pI.requestedEndOfProdDate')"
              for="pi-requestedEndOfProdDate"
              >Requested End Of Prod Date</label
            >
            <input
              type="text"
              class="form-control"
              name="requestedEndOfProdDate"
              id="pi-requestedEndOfProdDate"
              data-cy="requestedEndOfProdDate"
              :class="{ valid: !$v.pI.requestedEndOfProdDate.$invalid, invalid: $v.pI.requestedEndOfProdDate.$invalid }"
              v-model="$v.pI.requestedEndOfProdDate.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.pI.itemQuantity')" for="pi-itemQuantity"
              >Item Quantity</label
            >
            <input
              type="text"
              class="form-control"
              name="itemQuantity"
              id="pi-itemQuantity"
              data-cy="itemQuantity"
              :class="{ valid: !$v.pI.itemQuantity.$invalid, invalid: $v.pI.itemQuantity.$invalid }"
              v-model="$v.pI.itemQuantity.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.pI.countryOfOrigin')" for="pi-countryOfOrigin"
              >Country Of Origin</label
            >
            <input
              type="text"
              class="form-control"
              name="countryOfOrigin"
              id="pi-countryOfOrigin"
              data-cy="countryOfOrigin"
              :class="{ valid: !$v.pI.countryOfOrigin.$invalid, invalid: $v.pI.countryOfOrigin.$invalid }"
              v-model="$v.pI.countryOfOrigin.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.pI.countryOfFinalDestination')"
              for="pi-countryOfFinalDestination"
              >Country Of Final Destination</label
            >
            <input
              type="text"
              class="form-control"
              name="countryOfFinalDestination"
              id="pi-countryOfFinalDestination"
              data-cy="countryOfFinalDestination"
              :class="{ valid: !$v.pI.countryOfFinalDestination.$invalid, invalid: $v.pI.countryOfFinalDestination.$invalid }"
              v-model="$v.pI.countryOfFinalDestination.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.pI.productionLeadTimeCommitment')"
              for="pi-productionLeadTimeCommitment"
              >Production Lead Time Commitment</label
            >
            <input
              type="text"
              class="form-control"
              name="productionLeadTimeCommitment"
              id="pi-productionLeadTimeCommitment"
              data-cy="productionLeadTimeCommitment"
              :class="{ valid: !$v.pI.productionLeadTimeCommitment.$invalid, invalid: $v.pI.productionLeadTimeCommitment.$invalid }"
              v-model="$v.pI.productionLeadTimeCommitment.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.pI.consignee')" for="pi-consignee">Consignee</label>
            <input
              type="text"
              class="form-control"
              name="consignee"
              id="pi-consignee"
              data-cy="consignee"
              :class="{ valid: !$v.pI.consignee.$invalid, invalid: $v.pI.consignee.$invalid }"
              v-model="$v.pI.consignee.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.pI.carriageBy')" for="pi-carriageBy"
              >Carriage By</label
            >
            <input
              type="text"
              class="form-control"
              name="carriageBy"
              id="pi-carriageBy"
              data-cy="carriageBy"
              :class="{ valid: !$v.pI.carriageBy.$invalid, invalid: $v.pI.carriageBy.$invalid }"
              v-model="$v.pI.carriageBy.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.pI.termsOfDelivery')" for="pi-termsOfDelivery"
              >Terms Of Delivery</label
            >
            <input
              type="text"
              class="form-control"
              name="termsOfDelivery"
              id="pi-termsOfDelivery"
              data-cy="termsOfDelivery"
              :class="{ valid: !$v.pI.termsOfDelivery.$invalid, invalid: $v.pI.termsOfDelivery.$invalid }"
              v-model="$v.pI.termsOfDelivery.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.pI.termsOfPayment')" for="pi-termsOfPayment"
              >Terms Of Payment</label
            >
            <input
              type="text"
              class="form-control"
              name="termsOfPayment"
              id="pi-termsOfPayment"
              data-cy="termsOfPayment"
              :class="{ valid: !$v.pI.termsOfPayment.$invalid, invalid: $v.pI.termsOfPayment.$invalid }"
              v-model="$v.pI.termsOfPayment.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.pI.itemUnit')" for="pi-itemUnit">Item Unit</label>
            <input
              type="text"
              class="form-control"
              name="itemUnit"
              id="pi-itemUnit"
              data-cy="itemUnit"
              :class="{ valid: !$v.pI.itemUnit.$invalid, invalid: $v.pI.itemUnit.$invalid }"
              v-model="$v.pI.itemUnit.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.pI.rate')" for="pi-rate">Rate</label>
            <input
              type="text"
              class="form-control"
              name="rate"
              id="pi-rate"
              data-cy="rate"
              :class="{ valid: !$v.pI.rate.$invalid, invalid: $v.pI.rate.$invalid }"
              v-model="$v.pI.rate.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.pI.amount')" for="pi-amount">Amount</label>
            <input
              type="text"
              class="form-control"
              name="amount"
              id="pi-amount"
              data-cy="amount"
              :class="{ valid: !$v.pI.amount.$invalid, invalid: $v.pI.amount.$invalid }"
              v-model="$v.pI.amount.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.pI.totalAmount')" for="pi-totalAmount"
              >Total Amount</label
            >
            <input
              type="text"
              class="form-control"
              name="totalAmount"
              id="pi-totalAmount"
              data-cy="totalAmount"
              :class="{ valid: !$v.pI.totalAmount.$invalid, invalid: $v.pI.totalAmount.$invalid }"
              v-model="$v.pI.totalAmount.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.pI.discountRate')" for="pi-discountRate"
              >Discount Rate</label
            >
            <input
              type="text"
              class="form-control"
              name="discountRate"
              id="pi-discountRate"
              data-cy="discountRate"
              :class="{ valid: !$v.pI.discountRate.$invalid, invalid: $v.pI.discountRate.$invalid }"
              v-model="$v.pI.discountRate.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.pI.currency')" for="pi-currency">Currency</label>
            <input
              type="text"
              class="form-control"
              name="currency"
              id="pi-currency"
              data-cy="currency"
              :class="{ valid: !$v.pI.currency.$invalid, invalid: $v.pI.currency.$invalid }"
              v-model="$v.pI.currency.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.pI.piStatus')" for="pi-piStatus">Pi Status</label>
            <input
              type="text"
              class="form-control"
              name="piStatus"
              id="pi-piStatus"
              data-cy="piStatus"
              :class="{ valid: !$v.pI.piStatus.$invalid, invalid: $v.pI.piStatus.$invalid }"
              v-model="$v.pI.piStatus.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.pI.remarks')" for="pi-remarks">Remarks</label>
            <input
              type="text"
              class="form-control"
              name="remarks"
              id="pi-remarks"
              data-cy="remarks"
              :class="{ valid: !$v.pI.remarks.$invalid, invalid: $v.pI.remarks.$invalid }"
              v-model="$v.pI.remarks.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.pI.itemId')" for="pi-itemId">Item Id</label>
            <input
              type="text"
              class="form-control"
              name="itemId"
              id="pi-itemId"
              data-cy="itemId"
              :class="{ valid: !$v.pI.itemId.$invalid, invalid: $v.pI.itemId.$invalid }"
              v-model="$v.pI.itemId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.pI.boardId')" for="pi-boardId">Board Id</label>
            <input
              type="text"
              class="form-control"
              name="boardId"
              id="pi-boardId"
              data-cy="boardId"
              :class="{ valid: !$v.pI.boardId.$invalid, invalid: $v.pI.boardId.$invalid }"
              v-model="$v.pI.boardId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.pI.kingdeeId')" for="pi-kingdeeId">Kingdee Id</label>
            <input
              type="text"
              class="form-control"
              name="kingdeeId"
              id="pi-kingdeeId"
              data-cy="kingdeeId"
              :class="{ valid: !$v.pI.kingdeeId.$invalid, invalid: $v.pI.kingdeeId.$invalid }"
              v-model="$v.pI.kingdeeId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.pI.portOfDischarge')" for="pi-portOfDischarge"
              >Port Of Discharge</label
            >
            <input
              type="text"
              class="form-control"
              name="portOfDischarge"
              id="pi-portOfDischarge"
              data-cy="portOfDischarge"
              :class="{ valid: !$v.pI.portOfDischarge.$invalid, invalid: $v.pI.portOfDischarge.$invalid }"
              v-model="$v.pI.portOfDischarge.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.pI.portOfLoading')" for="pi-portOfLoading"
              >Port Of Loading</label
            >
            <input
              type="text"
              class="form-control"
              name="portOfLoading"
              id="pi-portOfLoading"
              data-cy="portOfLoading"
              :class="{ valid: !$v.pI.portOfLoading.$invalid, invalid: $v.pI.portOfLoading.$invalid }"
              v-model="$v.pI.portOfLoading.$model"
            />
          </div>
        </div>
        <div>
          <button type="button" id="cancel-save" data-cy="entityCreateCancelButton" class="btn btn-secondary" v-on:click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
          </button>
          <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="$v.pI.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./pi-update.component.ts"></script>
