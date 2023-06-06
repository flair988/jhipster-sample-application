<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterSampleApplicationApp.supplier.home.createOrEditLabel"
          data-cy="SupplierCreateUpdateHeading"
          v-text="$t('jhipsterSampleApplicationApp.supplier.home.createOrEditLabel')"
        >
          Create or edit a Supplier
        </h2>
        <div>
          <div class="form-group" v-if="supplier.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="supplier.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.supplier.client')" for="supplier-client"
              >Client</label
            >
            <input
              type="text"
              class="form-control"
              name="client"
              id="supplier-client"
              data-cy="client"
              :class="{ valid: !$v.supplier.client.$invalid, invalid: $v.supplier.client.$invalid }"
              v-model="$v.supplier.client.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.supplier.parentItem')" for="supplier-parentItem"
              >Parent Item</label
            >
            <input
              type="text"
              class="form-control"
              name="parentItem"
              id="supplier-parentItem"
              data-cy="parentItem"
              :class="{ valid: !$v.supplier.parentItem.$invalid, invalid: $v.supplier.parentItem.$invalid }"
              v-model="$v.supplier.parentItem.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.supplier.itemId')" for="supplier-itemId"
              >Item Id</label
            >
            <input
              type="text"
              class="form-control"
              name="itemId"
              id="supplier-itemId"
              data-cy="itemId"
              :class="{ valid: !$v.supplier.itemId.$invalid, invalid: $v.supplier.itemId.$invalid }"
              v-model="$v.supplier.itemId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.supplier.boardId')" for="supplier-boardId"
              >Board Id</label
            >
            <input
              type="text"
              class="form-control"
              name="boardId"
              id="supplier-boardId"
              data-cy="boardId"
              :class="{ valid: !$v.supplier.boardId.$invalid, invalid: $v.supplier.boardId.$invalid }"
              v-model="$v.supplier.boardId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.supplier.person')" for="supplier-person"
              >Person</label
            >
            <input
              type="text"
              class="form-control"
              name="person"
              id="supplier-person"
              data-cy="person"
              :class="{ valid: !$v.supplier.person.$invalid, invalid: $v.supplier.person.$invalid }"
              v-model="$v.supplier.person.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.supplier.category')" for="supplier-category"
              >Category</label
            >
            <input
              type="text"
              class="form-control"
              name="category"
              id="supplier-category"
              data-cy="category"
              :class="{ valid: !$v.supplier.category.$invalid, invalid: $v.supplier.category.$invalid }"
              v-model="$v.supplier.category.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.supplier.subCategory')" for="supplier-subCategory"
              >Sub Category</label
            >
            <input
              type="text"
              class="form-control"
              name="subCategory"
              id="supplier-subCategory"
              data-cy="subCategory"
              :class="{ valid: !$v.supplier.subCategory.$invalid, invalid: $v.supplier.subCategory.$invalid }"
              v-model="$v.supplier.subCategory.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.supplier.supplierStatus')"
              for="supplier-supplierStatus"
              >Supplier Status</label
            >
            <input
              type="text"
              class="form-control"
              name="supplierStatus"
              id="supplier-supplierStatus"
              data-cy="supplierStatus"
              :class="{ valid: !$v.supplier.supplierStatus.$invalid, invalid: $v.supplier.supplierStatus.$invalid }"
              v-model="$v.supplier.supplierStatus.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.supplier.capStatus')" for="supplier-capStatus"
              >Cap Status</label
            >
            <input
              type="text"
              class="form-control"
              name="capStatus"
              id="supplier-capStatus"
              data-cy="capStatus"
              :class="{ valid: !$v.supplier.capStatus.$invalid, invalid: $v.supplier.capStatus.$invalid }"
              v-model="$v.supplier.capStatus.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.supplier.qualificationScore')"
              for="supplier-qualificationScore"
              >Qualification Score</label
            >
            <input
              type="text"
              class="form-control"
              name="qualificationScore"
              id="supplier-qualificationScore"
              data-cy="qualificationScore"
              :class="{ valid: !$v.supplier.qualificationScore.$invalid, invalid: $v.supplier.qualificationScore.$invalid }"
              v-model="$v.supplier.qualificationScore.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.supplier.bopeScore')" for="supplier-bopeScore"
              >Bope Score</label
            >
            <input
              type="text"
              class="form-control"
              name="bopeScore"
              id="supplier-bopeScore"
              data-cy="bopeScore"
              :class="{ valid: !$v.supplier.bopeScore.$invalid, invalid: $v.supplier.bopeScore.$invalid }"
              v-model="$v.supplier.bopeScore.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.supplier.internalSupplierId')"
              for="supplier-internalSupplierId"
              >Internal Supplier Id</label
            >
            <input
              type="text"
              class="form-control"
              name="internalSupplierId"
              id="supplier-internalSupplierId"
              data-cy="internalSupplierId"
              :class="{ valid: !$v.supplier.internalSupplierId.$invalid, invalid: $v.supplier.internalSupplierId.$invalid }"
              v-model="$v.supplier.internalSupplierId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.supplier.contact')" for="supplier-contact"
              >Contact</label
            >
            <input
              type="text"
              class="form-control"
              name="contact"
              id="supplier-contact"
              data-cy="contact"
              :class="{ valid: !$v.supplier.contact.$invalid, invalid: $v.supplier.contact.$invalid }"
              v-model="$v.supplier.contact.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.supplier.contactPhoneNumber')"
              for="supplier-contactPhoneNumber"
              >Contact Phone Number</label
            >
            <input
              type="text"
              class="form-control"
              name="contactPhoneNumber"
              id="supplier-contactPhoneNumber"
              data-cy="contactPhoneNumber"
              :class="{ valid: !$v.supplier.contactPhoneNumber.$invalid, invalid: $v.supplier.contactPhoneNumber.$invalid }"
              v-model="$v.supplier.contactPhoneNumber.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.supplier.contactEmailAddress')"
              for="supplier-contactEmailAddress"
              >Contact Email Address</label
            >
            <input
              type="text"
              class="form-control"
              name="contactEmailAddress"
              id="supplier-contactEmailAddress"
              data-cy="contactEmailAddress"
              :class="{ valid: !$v.supplier.contactEmailAddress.$invalid, invalid: $v.supplier.contactEmailAddress.$invalid }"
              v-model="$v.supplier.contactEmailAddress.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.supplier.country')" for="supplier-country"
              >Country</label
            >
            <input
              type="text"
              class="form-control"
              name="country"
              id="supplier-country"
              data-cy="country"
              :class="{ valid: !$v.supplier.country.$invalid, invalid: $v.supplier.country.$invalid }"
              v-model="$v.supplier.country.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.supplier.operationSite')"
              for="supplier-operationSite"
              >Operation Site</label
            >
            <input
              type="text"
              class="form-control"
              name="operationSite"
              id="supplier-operationSite"
              data-cy="operationSite"
              :class="{ valid: !$v.supplier.operationSite.$invalid, invalid: $v.supplier.operationSite.$invalid }"
              v-model="$v.supplier.operationSite.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.supplier.address')" for="supplier-address"
              >Address</label
            >
            <input
              type="text"
              class="form-control"
              name="address"
              id="supplier-address"
              data-cy="address"
              :class="{ valid: !$v.supplier.address.$invalid, invalid: $v.supplier.address.$invalid }"
              v-model="$v.supplier.address.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.supplier.website')" for="supplier-website"
              >Website</label
            >
            <input
              type="text"
              class="form-control"
              name="website"
              id="supplier-website"
              data-cy="website"
              :class="{ valid: !$v.supplier.website.$invalid, invalid: $v.supplier.website.$invalid }"
              v-model="$v.supplier.website.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.supplier.productTaxonomy')"
              for="supplier-productTaxonomy"
              >Product Taxonomy</label
            >
            <input
              type="text"
              class="form-control"
              name="productTaxonomy"
              id="supplier-productTaxonomy"
              data-cy="productTaxonomy"
              :class="{ valid: !$v.supplier.productTaxonomy.$invalid, invalid: $v.supplier.productTaxonomy.$invalid }"
              v-model="$v.supplier.productTaxonomy.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.supplier.relationStartingYear')"
              for="supplier-relationStartingYear"
              >Relation Starting Year</label
            >
            <input
              type="text"
              class="form-control"
              name="relationStartingYear"
              id="supplier-relationStartingYear"
              data-cy="relationStartingYear"
              :class="{ valid: !$v.supplier.relationStartingYear.$invalid, invalid: $v.supplier.relationStartingYear.$invalid }"
              v-model="$v.supplier.relationStartingYear.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.supplier.businessLicense')"
              for="supplier-businessLicense"
              >Business License</label
            >
            <input
              type="text"
              class="form-control"
              name="businessLicense"
              id="supplier-businessLicense"
              data-cy="businessLicense"
              :class="{ valid: !$v.supplier.businessLicense.$invalid, invalid: $v.supplier.businessLicense.$invalid }"
              v-model="$v.supplier.businessLicense.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.supplier.rexOriginStatus')"
              for="supplier-rexOriginStatus"
              >Rex Origin Status</label
            >
            <input
              type="text"
              class="form-control"
              name="rexOriginStatus"
              id="supplier-rexOriginStatus"
              data-cy="rexOriginStatus"
              :class="{ valid: !$v.supplier.rexOriginStatus.$invalid, invalid: $v.supplier.rexOriginStatus.$invalid }"
              v-model="$v.supplier.rexOriginStatus.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.supplier.createDate')" for="supplier-createDate"
              >Create Date</label
            >
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="supplier-createDate"
                  v-model="$v.supplier.createDate.$model"
                  name="createDate"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="supplier-createDate"
                data-cy="createDate"
                type="text"
                class="form-control"
                name="createDate"
                :class="{ valid: !$v.supplier.createDate.$invalid, invalid: $v.supplier.createDate.$invalid }"
                v-model="$v.supplier.createDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.supplier.updateDate')" for="supplier-updateDate"
              >Update Date</label
            >
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="supplier-updateDate"
                  v-model="$v.supplier.updateDate.$model"
                  name="updateDate"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="supplier-updateDate"
                data-cy="updateDate"
                type="text"
                class="form-control"
                name="updateDate"
                :class="{ valid: !$v.supplier.updateDate.$invalid, invalid: $v.supplier.updateDate.$invalid }"
                v-model="$v.supplier.updateDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.supplier.item')" for="supplier-item">Item</label>
            <input
              type="text"
              class="form-control"
              name="item"
              id="supplier-item"
              data-cy="item"
              :class="{ valid: !$v.supplier.item.$invalid, invalid: $v.supplier.item.$invalid }"
              v-model="$v.supplier.item.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.supplier.mirror')" for="supplier-mirror"
              >Mirror</label
            >
            <input
              type="text"
              class="form-control"
              name="mirror"
              id="supplier-mirror"
              data-cy="mirror"
              :class="{ valid: !$v.supplier.mirror.$invalid, invalid: $v.supplier.mirror.$invalid }"
              v-model="$v.supplier.mirror.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.supplier.subItems')" for="supplier-subItems"
              >Sub Items</label
            >
            <input
              type="text"
              class="form-control"
              name="subItems"
              id="supplier-subItems"
              data-cy="subItems"
              :class="{ valid: !$v.supplier.subItems.$invalid, invalid: $v.supplier.subItems.$invalid }"
              v-model="$v.supplier.subItems.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.supplier.owner')" for="supplier-owner">Owner</label>
            <input
              type="text"
              class="form-control"
              name="owner"
              id="supplier-owner"
              data-cy="owner"
              :class="{ valid: !$v.supplier.owner.$invalid, invalid: $v.supplier.owner.$invalid }"
              v-model="$v.supplier.owner.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.supplier.status')" for="supplier-status"
              >Status</label
            >
            <input
              type="text"
              class="form-control"
              name="status"
              id="supplier-status"
              data-cy="status"
              :class="{ valid: !$v.supplier.status.$invalid, invalid: $v.supplier.status.$invalid }"
              v-model="$v.supplier.status.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.supplier.date')" for="supplier-date">Date</label>
            <input
              type="text"
              class="form-control"
              name="date"
              id="supplier-date"
              data-cy="date"
              :class="{ valid: !$v.supplier.date.$invalid, invalid: $v.supplier.date.$invalid }"
              v-model="$v.supplier.date.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.supplier.formula')" for="supplier-formula"
              >Formula</label
            >
            <input
              type="text"
              class="form-control"
              name="formula"
              id="supplier-formula"
              data-cy="formula"
              :class="{ valid: !$v.supplier.formula.$invalid, invalid: $v.supplier.formula.$invalid }"
              v-model="$v.supplier.formula.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.supplier.kingdeeId')" for="supplier-kingdeeId"
              >Kingdee Id</label
            >
            <input
              type="text"
              class="form-control"
              name="kingdeeId"
              id="supplier-kingdeeId"
              data-cy="kingdeeId"
              :class="{ valid: !$v.supplier.kingdeeId.$invalid, invalid: $v.supplier.kingdeeId.$invalid }"
              v-model="$v.supplier.kingdeeId.$model"
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
            :disabled="$v.supplier.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./supplier-update.component.ts"></script>
