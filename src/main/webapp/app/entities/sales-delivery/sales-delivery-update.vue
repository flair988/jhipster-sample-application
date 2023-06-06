<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterSampleApplicationApp.salesDelivery.home.createOrEditLabel"
          data-cy="SalesDeliveryCreateUpdateHeading"
          v-text="$t('jhipsterSampleApplicationApp.salesDelivery.home.createOrEditLabel')"
        >
          Create or edit a SalesDelivery
        </h2>
        <div>
          <div class="form-group" v-if="salesDelivery.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="salesDelivery.id" readonly />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.salesDelivery.itemName')"
              for="sales-delivery-itemName"
              >Item Name</label
            >
            <input
              type="text"
              class="form-control"
              name="itemName"
              id="sales-delivery-itemName"
              data-cy="itemName"
              :class="{ valid: !$v.salesDelivery.itemName.$invalid, invalid: $v.salesDelivery.itemName.$invalid }"
              v-model="$v.salesDelivery.itemName.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.salesDelivery.itemId')" for="sales-delivery-itemId"
              >Item Id</label
            >
            <input
              type="text"
              class="form-control"
              name="itemId"
              id="sales-delivery-itemId"
              data-cy="itemId"
              :class="{ valid: !$v.salesDelivery.itemId.$invalid, invalid: $v.salesDelivery.itemId.$invalid }"
              v-model="$v.salesDelivery.itemId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.salesDelivery.boardId')" for="sales-delivery-boardId"
              >Board Id</label
            >
            <input
              type="text"
              class="form-control"
              name="boardId"
              id="sales-delivery-boardId"
              data-cy="boardId"
              :class="{ valid: !$v.salesDelivery.boardId.$invalid, invalid: $v.salesDelivery.boardId.$invalid }"
              v-model="$v.salesDelivery.boardId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.salesDelivery.kingdeeId')"
              for="sales-delivery-kingdeeId"
              >Kingdee Id</label
            >
            <input
              type="text"
              class="form-control"
              name="kingdeeId"
              id="sales-delivery-kingdeeId"
              data-cy="kingdeeId"
              :class="{ valid: !$v.salesDelivery.kingdeeId.$invalid, invalid: $v.salesDelivery.kingdeeId.$invalid }"
              v-model="$v.salesDelivery.kingdeeId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.salesDelivery.customer')"
              for="sales-delivery-customer"
              >Customer</label
            >
            <input
              type="text"
              class="form-control"
              name="customer"
              id="sales-delivery-customer"
              data-cy="customer"
              :class="{ valid: !$v.salesDelivery.customer.$invalid, invalid: $v.salesDelivery.customer.$invalid }"
              v-model="$v.salesDelivery.customer.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.salesDelivery.orderDate')"
              for="sales-delivery-orderDate"
              >Order Date</label
            >
            <input
              type="text"
              class="form-control"
              name="orderDate"
              id="sales-delivery-orderDate"
              data-cy="orderDate"
              :class="{ valid: !$v.salesDelivery.orderDate.$invalid, invalid: $v.salesDelivery.orderDate.$invalid }"
              v-model="$v.salesDelivery.orderDate.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.salesDelivery.totalActualShipQty')"
              for="sales-delivery-totalActualShipQty"
              >Total Actual Ship Qty</label
            >
            <input
              type="text"
              class="form-control"
              name="totalActualShipQty"
              id="sales-delivery-totalActualShipQty"
              data-cy="totalActualShipQty"
              :class="{ valid: !$v.salesDelivery.totalActualShipQty.$invalid, invalid: $v.salesDelivery.totalActualShipQty.$invalid }"
              v-model="$v.salesDelivery.totalActualShipQty.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.salesDelivery.totalQtyDelivery')"
              for="sales-delivery-totalQtyDelivery"
              >Total Qty Delivery</label
            >
            <input
              type="text"
              class="form-control"
              name="totalQtyDelivery"
              id="sales-delivery-totalQtyDelivery"
              data-cy="totalQtyDelivery"
              :class="{ valid: !$v.salesDelivery.totalQtyDelivery.$invalid, invalid: $v.salesDelivery.totalQtyDelivery.$invalid }"
              v-model="$v.salesDelivery.totalQtyDelivery.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.salesDelivery.loadingPort')"
              for="sales-delivery-loadingPort"
              >Loading Port</label
            >
            <input
              type="text"
              class="form-control"
              name="loadingPort"
              id="sales-delivery-loadingPort"
              data-cy="loadingPort"
              :class="{ valid: !$v.salesDelivery.loadingPort.$invalid, invalid: $v.salesDelivery.loadingPort.$invalid }"
              v-model="$v.salesDelivery.loadingPort.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.salesDelivery.dischargePort')"
              for="sales-delivery-dischargePort"
              >Discharge Port</label
            >
            <input
              type="text"
              class="form-control"
              name="dischargePort"
              id="sales-delivery-dischargePort"
              data-cy="dischargePort"
              :class="{ valid: !$v.salesDelivery.dischargePort.$invalid, invalid: $v.salesDelivery.dischargePort.$invalid }"
              v-model="$v.salesDelivery.dischargePort.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.salesDelivery.transportMode')"
              for="sales-delivery-transportMode"
              >Transport Mode</label
            >
            <input
              type="text"
              class="form-control"
              name="transportMode"
              id="sales-delivery-transportMode"
              data-cy="transportMode"
              :class="{ valid: !$v.salesDelivery.transportMode.$invalid, invalid: $v.salesDelivery.transportMode.$invalid }"
              v-model="$v.salesDelivery.transportMode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.salesDelivery.incoterm')"
              for="sales-delivery-incoterm"
              >Incoterm</label
            >
            <input
              type="text"
              class="form-control"
              name="incoterm"
              id="sales-delivery-incoterm"
              data-cy="incoterm"
              :class="{ valid: !$v.salesDelivery.incoterm.$invalid, invalid: $v.salesDelivery.incoterm.$invalid }"
              v-model="$v.salesDelivery.incoterm.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.salesDelivery.forwarder')"
              for="sales-delivery-forwarder"
              >Forwarder</label
            >
            <input
              type="text"
              class="form-control"
              name="forwarder"
              id="sales-delivery-forwarder"
              data-cy="forwarder"
              :class="{ valid: !$v.salesDelivery.forwarder.$invalid, invalid: $v.salesDelivery.forwarder.$invalid }"
              v-model="$v.salesDelivery.forwarder.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.salesDelivery.eta')" for="sales-delivery-eta"
              >Eta</label
            >
            <input
              type="text"
              class="form-control"
              name="eta"
              id="sales-delivery-eta"
              data-cy="eta"
              :class="{ valid: !$v.salesDelivery.eta.$invalid, invalid: $v.salesDelivery.eta.$invalid }"
              v-model="$v.salesDelivery.eta.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.salesDelivery.etd')" for="sales-delivery-etd"
              >Etd</label
            >
            <input
              type="text"
              class="form-control"
              name="etd"
              id="sales-delivery-etd"
              data-cy="etd"
              :class="{ valid: !$v.salesDelivery.etd.$invalid, invalid: $v.salesDelivery.etd.$invalid }"
              v-model="$v.salesDelivery.etd.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.salesDelivery.containerType')"
              for="sales-delivery-containerType"
              >Container Type</label
            >
            <input
              type="text"
              class="form-control"
              name="containerType"
              id="sales-delivery-containerType"
              data-cy="containerType"
              :class="{ valid: !$v.salesDelivery.containerType.$invalid, invalid: $v.salesDelivery.containerType.$invalid }"
              v-model="$v.salesDelivery.containerType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.salesDelivery.containerSize')"
              for="sales-delivery-containerSize"
              >Container Size</label
            >
            <input
              type="text"
              class="form-control"
              name="containerSize"
              id="sales-delivery-containerSize"
              data-cy="containerSize"
              :class="{ valid: !$v.salesDelivery.containerSize.$invalid, invalid: $v.salesDelivery.containerSize.$invalid }"
              v-model="$v.salesDelivery.containerSize.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.salesDelivery.remark')" for="sales-delivery-remark"
              >Remark</label
            >
            <input
              type="text"
              class="form-control"
              name="remark"
              id="sales-delivery-remark"
              data-cy="remark"
              :class="{ valid: !$v.salesDelivery.remark.$invalid, invalid: $v.salesDelivery.remark.$invalid }"
              v-model="$v.salesDelivery.remark.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.salesDelivery.kingdeeUniqueId')"
              for="sales-delivery-kingdeeUniqueId"
              >Kingdee Unique Id</label
            >
            <input
              type="text"
              class="form-control"
              name="kingdeeUniqueId"
              id="sales-delivery-kingdeeUniqueId"
              data-cy="kingdeeUniqueId"
              :class="{ valid: !$v.salesDelivery.kingdeeUniqueId.$invalid, invalid: $v.salesDelivery.kingdeeUniqueId.$invalid }"
              v-model="$v.salesDelivery.kingdeeUniqueId.$model"
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
            :disabled="$v.salesDelivery.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./sales-delivery-update.component.ts"></script>
