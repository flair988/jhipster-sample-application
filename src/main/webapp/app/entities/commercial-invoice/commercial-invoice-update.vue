<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterSampleApplicationApp.commercialInvoice.home.createOrEditLabel"
          data-cy="CommercialInvoiceCreateUpdateHeading"
          v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.home.createOrEditLabel')"
        >
          Create or edit a CommercialInvoice
        </h2>
        <div>
          <div class="form-group" v-if="commercialInvoice.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="commercialInvoice.id" readonly />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.itemName')"
              for="commercial-invoice-itemName"
              >Item Name</label
            >
            <input
              type="text"
              class="form-control"
              name="itemName"
              id="commercial-invoice-itemName"
              data-cy="itemName"
              :class="{ valid: !$v.commercialInvoice.itemName.$invalid, invalid: $v.commercialInvoice.itemName.$invalid }"
              v-model="$v.commercialInvoice.itemName.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.itemId')"
              for="commercial-invoice-itemId"
              >Item Id</label
            >
            <input
              type="text"
              class="form-control"
              name="itemId"
              id="commercial-invoice-itemId"
              data-cy="itemId"
              :class="{ valid: !$v.commercialInvoice.itemId.$invalid, invalid: $v.commercialInvoice.itemId.$invalid }"
              v-model="$v.commercialInvoice.itemId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.boardId')"
              for="commercial-invoice-boardId"
              >Board Id</label
            >
            <input
              type="text"
              class="form-control"
              name="boardId"
              id="commercial-invoice-boardId"
              data-cy="boardId"
              :class="{ valid: !$v.commercialInvoice.boardId.$invalid, invalid: $v.commercialInvoice.boardId.$invalid }"
              v-model="$v.commercialInvoice.boardId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.kingdeeId')"
              for="commercial-invoice-kingdeeId"
              >Kingdee Id</label
            >
            <input
              type="text"
              class="form-control"
              name="kingdeeId"
              id="commercial-invoice-kingdeeId"
              data-cy="kingdeeId"
              :class="{ valid: !$v.commercialInvoice.kingdeeId.$invalid, invalid: $v.commercialInvoice.kingdeeId.$invalid }"
              v-model="$v.commercialInvoice.kingdeeId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.date')"
              for="commercial-invoice-date"
              >Date</label
            >
            <input
              type="text"
              class="form-control"
              name="date"
              id="commercial-invoice-date"
              data-cy="date"
              :class="{ valid: !$v.commercialInvoice.date.$invalid, invalid: $v.commercialInvoice.date.$invalid }"
              v-model="$v.commercialInvoice.date.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.client')"
              for="commercial-invoice-client"
              >Client</label
            >
            <input
              type="text"
              class="form-control"
              name="client"
              id="commercial-invoice-client"
              data-cy="client"
              :class="{ valid: !$v.commercialInvoice.client.$invalid, invalid: $v.commercialInvoice.client.$invalid }"
              v-model="$v.commercialInvoice.client.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.cateGory')"
              for="commercial-invoice-cateGory"
              >Cate Gory</label
            >
            <input
              type="text"
              class="form-control"
              name="cateGory"
              id="commercial-invoice-cateGory"
              data-cy="cateGory"
              :class="{ valid: !$v.commercialInvoice.cateGory.$invalid, invalid: $v.commercialInvoice.cateGory.$invalid }"
              v-model="$v.commercialInvoice.cateGory.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.totalPrice')"
              for="commercial-invoice-totalPrice"
              >Total Price</label
            >
            <input
              type="text"
              class="form-control"
              name="totalPrice"
              id="commercial-invoice-totalPrice"
              data-cy="totalPrice"
              :class="{ valid: !$v.commercialInvoice.totalPrice.$invalid, invalid: $v.commercialInvoice.totalPrice.$invalid }"
              v-model="$v.commercialInvoice.totalPrice.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.currency')"
              for="commercial-invoice-currency"
              >Currency</label
            >
            <input
              type="text"
              class="form-control"
              name="currency"
              id="commercial-invoice-currency"
              data-cy="currency"
              :class="{ valid: !$v.commercialInvoice.currency.$invalid, invalid: $v.commercialInvoice.currency.$invalid }"
              v-model="$v.commercialInvoice.currency.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.remarks')"
              for="commercial-invoice-remarks"
              >Remarks</label
            >
            <input
              type="text"
              class="form-control"
              name="remarks"
              id="commercial-invoice-remarks"
              data-cy="remarks"
              :class="{ valid: !$v.commercialInvoice.remarks.$invalid, invalid: $v.commercialInvoice.remarks.$invalid }"
              v-model="$v.commercialInvoice.remarks.$model"
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
            :disabled="$v.commercialInvoice.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./commercial-invoice-update.component.ts"></script>
