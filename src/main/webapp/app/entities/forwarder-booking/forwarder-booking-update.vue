<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterSampleApplicationApp.forwarderBooking.home.createOrEditLabel"
          data-cy="ForwarderBookingCreateUpdateHeading"
          v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.home.createOrEditLabel')"
        >
          Create or edit a ForwarderBooking
        </h2>
        <div>
          <div class="form-group" v-if="forwarderBooking.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="forwarderBooking.id" readonly />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.itemName')"
              for="forwarder-booking-itemName"
              >Item Name</label
            >
            <input
              type="text"
              class="form-control"
              name="itemName"
              id="forwarder-booking-itemName"
              data-cy="itemName"
              :class="{ valid: !$v.forwarderBooking.itemName.$invalid, invalid: $v.forwarderBooking.itemName.$invalid }"
              v-model="$v.forwarderBooking.itemName.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.itemId')"
              for="forwarder-booking-itemId"
              >Item Id</label
            >
            <input
              type="text"
              class="form-control"
              name="itemId"
              id="forwarder-booking-itemId"
              data-cy="itemId"
              :class="{ valid: !$v.forwarderBooking.itemId.$invalid, invalid: $v.forwarderBooking.itemId.$invalid }"
              v-model="$v.forwarderBooking.itemId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.boardId')"
              for="forwarder-booking-boardId"
              >Board Id</label
            >
            <input
              type="text"
              class="form-control"
              name="boardId"
              id="forwarder-booking-boardId"
              data-cy="boardId"
              :class="{ valid: !$v.forwarderBooking.boardId.$invalid, invalid: $v.forwarderBooking.boardId.$invalid }"
              v-model="$v.forwarderBooking.boardId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.kingdeeId')"
              for="forwarder-booking-kingdeeId"
              >Kingdee Id</label
            >
            <input
              type="text"
              class="form-control"
              name="kingdeeId"
              id="forwarder-booking-kingdeeId"
              data-cy="kingdeeId"
              :class="{ valid: !$v.forwarderBooking.kingdeeId.$invalid, invalid: $v.forwarderBooking.kingdeeId.$invalid }"
              v-model="$v.forwarderBooking.kingdeeId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.customer')"
              for="forwarder-booking-customer"
              >Customer</label
            >
            <input
              type="text"
              class="form-control"
              name="customer"
              id="forwarder-booking-customer"
              data-cy="customer"
              :class="{ valid: !$v.forwarderBooking.customer.$invalid, invalid: $v.forwarderBooking.customer.$invalid }"
              v-model="$v.forwarderBooking.customer.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.orderDate')"
              for="forwarder-booking-orderDate"
              >Order Date</label
            >
            <input
              type="text"
              class="form-control"
              name="orderDate"
              id="forwarder-booking-orderDate"
              data-cy="orderDate"
              :class="{ valid: !$v.forwarderBooking.orderDate.$invalid, invalid: $v.forwarderBooking.orderDate.$invalid }"
              v-model="$v.forwarderBooking.orderDate.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.forwarder')"
              for="forwarder-booking-forwarder"
              >Forwarder</label
            >
            <input
              type="text"
              class="form-control"
              name="forwarder"
              id="forwarder-booking-forwarder"
              data-cy="forwarder"
              :class="{ valid: !$v.forwarderBooking.forwarder.$invalid, invalid: $v.forwarderBooking.forwarder.$invalid }"
              v-model="$v.forwarderBooking.forwarder.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.totalQty')"
              for="forwarder-booking-totalQty"
              >Total Qty</label
            >
            <input
              type="text"
              class="form-control"
              name="totalQty"
              id="forwarder-booking-totalQty"
              data-cy="totalQty"
              :class="{ valid: !$v.forwarderBooking.totalQty.$invalid, invalid: $v.forwarderBooking.totalQty.$invalid }"
              v-model="$v.forwarderBooking.totalQty.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.loadingPort')"
              for="forwarder-booking-loadingPort"
              >Loading Port</label
            >
            <input
              type="text"
              class="form-control"
              name="loadingPort"
              id="forwarder-booking-loadingPort"
              data-cy="loadingPort"
              :class="{ valid: !$v.forwarderBooking.loadingPort.$invalid, invalid: $v.forwarderBooking.loadingPort.$invalid }"
              v-model="$v.forwarderBooking.loadingPort.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.dischargePort')"
              for="forwarder-booking-dischargePort"
              >Discharge Port</label
            >
            <input
              type="text"
              class="form-control"
              name="dischargePort"
              id="forwarder-booking-dischargePort"
              data-cy="dischargePort"
              :class="{ valid: !$v.forwarderBooking.dischargePort.$invalid, invalid: $v.forwarderBooking.dischargePort.$invalid }"
              v-model="$v.forwarderBooking.dischargePort.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.containerType')"
              for="forwarder-booking-containerType"
              >Container Type</label
            >
            <input
              type="text"
              class="form-control"
              name="containerType"
              id="forwarder-booking-containerType"
              data-cy="containerType"
              :class="{ valid: !$v.forwarderBooking.containerType.$invalid, invalid: $v.forwarderBooking.containerType.$invalid }"
              v-model="$v.forwarderBooking.containerType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.containerSize')"
              for="forwarder-booking-containerSize"
              >Container Size</label
            >
            <input
              type="text"
              class="form-control"
              name="containerSize"
              id="forwarder-booking-containerSize"
              data-cy="containerSize"
              :class="{ valid: !$v.forwarderBooking.containerSize.$invalid, invalid: $v.forwarderBooking.containerSize.$invalid }"
              v-model="$v.forwarderBooking.containerSize.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.containerNumber')"
              for="forwarder-booking-containerNumber"
              >Container Number</label
            >
            <input
              type="text"
              class="form-control"
              name="containerNumber"
              id="forwarder-booking-containerNumber"
              data-cy="containerNumber"
              :class="{ valid: !$v.forwarderBooking.containerNumber.$invalid, invalid: $v.forwarderBooking.containerNumber.$invalid }"
              v-model="$v.forwarderBooking.containerNumber.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.supplier')"
              for="forwarder-booking-supplier"
              >Supplier</label
            >
            <input
              type="text"
              class="form-control"
              name="supplier"
              id="forwarder-booking-supplier"
              data-cy="supplier"
              :class="{ valid: !$v.forwarderBooking.supplier.$invalid, invalid: $v.forwarderBooking.supplier.$invalid }"
              v-model="$v.forwarderBooking.supplier.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.supplierEmail')"
              for="forwarder-booking-supplierEmail"
              >Supplier Email</label
            >
            <input
              type="text"
              class="form-control"
              name="supplierEmail"
              id="forwarder-booking-supplierEmail"
              data-cy="supplierEmail"
              :class="{ valid: !$v.forwarderBooking.supplierEmail.$invalid, invalid: $v.forwarderBooking.supplierEmail.$invalid }"
              v-model="$v.forwarderBooking.supplierEmail.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.eta')" for="forwarder-booking-eta"
              >Eta</label
            >
            <input
              type="text"
              class="form-control"
              name="eta"
              id="forwarder-booking-eta"
              data-cy="eta"
              :class="{ valid: !$v.forwarderBooking.eta.$invalid, invalid: $v.forwarderBooking.eta.$invalid }"
              v-model="$v.forwarderBooking.eta.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.etd')" for="forwarder-booking-etd"
              >Etd</label
            >
            <input
              type="text"
              class="form-control"
              name="etd"
              id="forwarder-booking-etd"
              data-cy="etd"
              :class="{ valid: !$v.forwarderBooking.etd.$invalid, invalid: $v.forwarderBooking.etd.$invalid }"
              v-model="$v.forwarderBooking.etd.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.transportMode')"
              for="forwarder-booking-transportMode"
              >Transport Mode</label
            >
            <input
              type="text"
              class="form-control"
              name="transportMode"
              id="forwarder-booking-transportMode"
              data-cy="transportMode"
              :class="{ valid: !$v.forwarderBooking.transportMode.$invalid, invalid: $v.forwarderBooking.transportMode.$invalid }"
              v-model="$v.forwarderBooking.transportMode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.numberOfCartons')"
              for="forwarder-booking-numberOfCartons"
              >Number Of Cartons</label
            >
            <input
              type="text"
              class="form-control"
              name="numberOfCartons"
              id="forwarder-booking-numberOfCartons"
              data-cy="numberOfCartons"
              :class="{ valid: !$v.forwarderBooking.numberOfCartons.$invalid, invalid: $v.forwarderBooking.numberOfCartons.$invalid }"
              v-model="$v.forwarderBooking.numberOfCartons.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.numberOfRef')"
              for="forwarder-booking-numberOfRef"
              >Number Of Ref</label
            >
            <input
              type="text"
              class="form-control"
              name="numberOfRef"
              id="forwarder-booking-numberOfRef"
              data-cy="numberOfRef"
              :class="{ valid: !$v.forwarderBooking.numberOfRef.$invalid, invalid: $v.forwarderBooking.numberOfRef.$invalid }"
              v-model="$v.forwarderBooking.numberOfRef.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.totalVolume')"
              for="forwarder-booking-totalVolume"
              >Total Volume</label
            >
            <input
              type="text"
              class="form-control"
              name="totalVolume"
              id="forwarder-booking-totalVolume"
              data-cy="totalVolume"
              :class="{ valid: !$v.forwarderBooking.totalVolume.$invalid, invalid: $v.forwarderBooking.totalVolume.$invalid }"
              v-model="$v.forwarderBooking.totalVolume.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.totalWeight')"
              for="forwarder-booking-totalWeight"
              >Total Weight</label
            >
            <input
              type="text"
              class="form-control"
              name="totalWeight"
              id="forwarder-booking-totalWeight"
              data-cy="totalWeight"
              :class="{ valid: !$v.forwarderBooking.totalWeight.$invalid, invalid: $v.forwarderBooking.totalWeight.$invalid }"
              v-model="$v.forwarderBooking.totalWeight.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.remark')"
              for="forwarder-booking-remark"
              >Remark</label
            >
            <input
              type="text"
              class="form-control"
              name="remark"
              id="forwarder-booking-remark"
              data-cy="remark"
              :class="{ valid: !$v.forwarderBooking.remark.$invalid, invalid: $v.forwarderBooking.remark.$invalid }"
              v-model="$v.forwarderBooking.remark.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.client')"
              for="forwarder-booking-client"
              >Client</label
            >
            <input
              type="text"
              class="form-control"
              name="client"
              id="forwarder-booking-client"
              data-cy="client"
              :class="{ valid: !$v.forwarderBooking.client.$invalid, invalid: $v.forwarderBooking.client.$invalid }"
              v-model="$v.forwarderBooking.client.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.forwarderBooking.kingdeeUniqueId')"
              for="forwarder-booking-kingdeeUniqueId"
              >Kingdee Unique Id</label
            >
            <input
              type="text"
              class="form-control"
              name="kingdeeUniqueId"
              id="forwarder-booking-kingdeeUniqueId"
              data-cy="kingdeeUniqueId"
              :class="{ valid: !$v.forwarderBooking.kingdeeUniqueId.$invalid, invalid: $v.forwarderBooking.kingdeeUniqueId.$invalid }"
              v-model="$v.forwarderBooking.kingdeeUniqueId.$model"
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
            :disabled="$v.forwarderBooking.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./forwarder-booking-update.component.ts"></script>
