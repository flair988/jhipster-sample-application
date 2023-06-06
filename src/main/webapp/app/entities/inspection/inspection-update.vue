<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterSampleApplicationApp.inspection.home.createOrEditLabel"
          data-cy="InspectionCreateUpdateHeading"
          v-text="$t('jhipsterSampleApplicationApp.inspection.home.createOrEditLabel')"
        >
          Create or edit a Inspection
        </h2>
        <div>
          <div class="form-group" v-if="inspection.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="inspection.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.inspection.itemName')" for="inspection-itemName"
              >Item Name</label
            >
            <input
              type="text"
              class="form-control"
              name="itemName"
              id="inspection-itemName"
              data-cy="itemName"
              :class="{ valid: !$v.inspection.itemName.$invalid, invalid: $v.inspection.itemName.$invalid }"
              v-model="$v.inspection.itemName.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.inspection.itemId')" for="inspection-itemId"
              >Item Id</label
            >
            <input
              type="text"
              class="form-control"
              name="itemId"
              id="inspection-itemId"
              data-cy="itemId"
              :class="{ valid: !$v.inspection.itemId.$invalid, invalid: $v.inspection.itemId.$invalid }"
              v-model="$v.inspection.itemId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.inspection.boardId')" for="inspection-boardId"
              >Board Id</label
            >
            <input
              type="text"
              class="form-control"
              name="boardId"
              id="inspection-boardId"
              data-cy="boardId"
              :class="{ valid: !$v.inspection.boardId.$invalid, invalid: $v.inspection.boardId.$invalid }"
              v-model="$v.inspection.boardId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.inspection.kingdeeId')" for="inspection-kingdeeId"
              >Kingdee Id</label
            >
            <input
              type="text"
              class="form-control"
              name="kingdeeId"
              id="inspection-kingdeeId"
              data-cy="kingdeeId"
              :class="{ valid: !$v.inspection.kingdeeId.$invalid, invalid: $v.inspection.kingdeeId.$invalid }"
              v-model="$v.inspection.kingdeeId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.inspection.supplierName')"
              for="inspection-supplierName"
              >Supplier Name</label
            >
            <input
              type="text"
              class="form-control"
              name="supplierName"
              id="inspection-supplierName"
              data-cy="supplierName"
              :class="{ valid: !$v.inspection.supplierName.$invalid, invalid: $v.inspection.supplierName.$invalid }"
              v-model="$v.inspection.supplierName.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.inspection.email')" for="inspection-email"
              >Email</label
            >
            <input
              type="text"
              class="form-control"
              name="email"
              id="inspection-email"
              data-cy="email"
              :class="{ valid: !$v.inspection.email.$invalid, invalid: $v.inspection.email.$invalid }"
              v-model="$v.inspection.email.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.inspection.inspectionDate')"
              for="inspection-inspectionDate"
              >Inspection Date</label
            >
            <input
              type="text"
              class="form-control"
              name="inspectionDate"
              id="inspection-inspectionDate"
              data-cy="inspectionDate"
              :class="{ valid: !$v.inspection.inspectionDate.$invalid, invalid: $v.inspection.inspectionDate.$invalid }"
              v-model="$v.inspection.inspectionDate.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.inspection.endOfProductionDate')"
              for="inspection-endOfProductionDate"
              >End Of Production Date</label
            >
            <input
              type="text"
              class="form-control"
              name="endOfProductionDate"
              id="inspection-endOfProductionDate"
              data-cy="endOfProductionDate"
              :class="{ valid: !$v.inspection.endOfProductionDate.$invalid, invalid: $v.inspection.endOfProductionDate.$invalid }"
              v-model="$v.inspection.endOfProductionDate.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.inspection.cateGory')" for="inspection-cateGory"
              >Cate Gory</label
            >
            <input
              type="text"
              class="form-control"
              name="cateGory"
              id="inspection-cateGory"
              data-cy="cateGory"
              :class="{ valid: !$v.inspection.cateGory.$invalid, invalid: $v.inspection.cateGory.$invalid }"
              v-model="$v.inspection.cateGory.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.inspection.technicalFile')"
              for="inspection-technicalFile"
              >Technical File</label
            >
            <input
              type="text"
              class="form-control"
              name="technicalFile"
              id="inspection-technicalFile"
              data-cy="technicalFile"
              :class="{ valid: !$v.inspection.technicalFile.$invalid, invalid: $v.inspection.technicalFile.$invalid }"
              v-model="$v.inspection.technicalFile.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.inspection.qCResult')" for="inspection-qCResult"
              >Q C Result</label
            >
            <input
              type="text"
              class="form-control"
              name="qCResult"
              id="inspection-qCResult"
              data-cy="qCResult"
              :class="{ valid: !$v.inspection.qCResult.$invalid, invalid: $v.inspection.qCResult.$invalid }"
              v-model="$v.inspection.qCResult.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.inspection.docStatus')" for="inspection-docStatus"
              >Doc Status</label
            >
            <input
              type="text"
              class="form-control"
              name="docStatus"
              id="inspection-docStatus"
              data-cy="docStatus"
              :class="{ valid: !$v.inspection.docStatus.$invalid, invalid: $v.inspection.docStatus.$invalid }"
              v-model="$v.inspection.docStatus.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.inspection.goodsReadyForPickUpDate')"
              for="inspection-goodsReadyForPickUpDate"
              >Goods Ready For Pick Up Date</label
            >
            <input
              type="text"
              class="form-control"
              name="goodsReadyForPickUpDate"
              id="inspection-goodsReadyForPickUpDate"
              data-cy="goodsReadyForPickUpDate"
              :class="{ valid: !$v.inspection.goodsReadyForPickUpDate.$invalid, invalid: $v.inspection.goodsReadyForPickUpDate.$invalid }"
              v-model="$v.inspection.goodsReadyForPickUpDate.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.inspection.inspectionType')"
              for="inspection-inspectionType"
              >Inspection Type</label
            >
            <input
              type="text"
              class="form-control"
              name="inspectionType"
              id="inspection-inspectionType"
              data-cy="inspectionType"
              :class="{ valid: !$v.inspection.inspectionType.$invalid, invalid: $v.inspection.inspectionType.$invalid }"
              v-model="$v.inspection.inspectionType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.inspection.inspectionBookingStatus')"
              for="inspection-inspectionBookingStatus"
              >Inspection Booking Status</label
            >
            <input
              type="text"
              class="form-control"
              name="inspectionBookingStatus"
              id="inspection-inspectionBookingStatus"
              data-cy="inspectionBookingStatus"
              :class="{ valid: !$v.inspection.inspectionBookingStatus.$invalid, invalid: $v.inspection.inspectionBookingStatus.$invalid }"
              v-model="$v.inspection.inspectionBookingStatus.$model"
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
            :disabled="$v.inspection.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./inspection-update.component.ts"></script>
