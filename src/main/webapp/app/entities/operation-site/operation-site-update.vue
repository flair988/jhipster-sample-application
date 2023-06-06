<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterSampleApplicationApp.operationSite.home.createOrEditLabel"
          data-cy="OperationSiteCreateUpdateHeading"
          v-text="$t('jhipsterSampleApplicationApp.operationSite.home.createOrEditLabel')"
        >
          Create or edit a OperationSite
        </h2>
        <div>
          <div class="form-group" v-if="operationSite.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="operationSite.id" readonly />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.operationSite.itemName')"
              for="operation-site-itemName"
              >Item Name</label
            >
            <input
              type="text"
              class="form-control"
              name="itemName"
              id="operation-site-itemName"
              data-cy="itemName"
              :class="{ valid: !$v.operationSite.itemName.$invalid, invalid: $v.operationSite.itemName.$invalid }"
              v-model="$v.operationSite.itemName.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.operationSite.linkSupplierFactory')"
              for="operation-site-linkSupplierFactory"
              >Link Supplier Factory</label
            >
            <input
              type="text"
              class="form-control"
              name="linkSupplierFactory"
              id="operation-site-linkSupplierFactory"
              data-cy="linkSupplierFactory"
              :class="{ valid: !$v.operationSite.linkSupplierFactory.$invalid, invalid: $v.operationSite.linkSupplierFactory.$invalid }"
              v-model="$v.operationSite.linkSupplierFactory.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.operationSite.typeOfSite')"
              for="operation-site-typeOfSite"
              >Type Of Site</label
            >
            <input
              type="text"
              class="form-control"
              name="typeOfSite"
              id="operation-site-typeOfSite"
              data-cy="typeOfSite"
              :class="{ valid: !$v.operationSite.typeOfSite.$invalid, invalid: $v.operationSite.typeOfSite.$invalid }"
              v-model="$v.operationSite.typeOfSite.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.operationSite.contact')" for="operation-site-contact"
              >Contact</label
            >
            <input
              type="text"
              class="form-control"
              name="contact"
              id="operation-site-contact"
              data-cy="contact"
              :class="{ valid: !$v.operationSite.contact.$invalid, invalid: $v.operationSite.contact.$invalid }"
              v-model="$v.operationSite.contact.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.operationSite.siteAddress')"
              for="operation-site-siteAddress"
              >Site Address</label
            >
            <input
              type="text"
              class="form-control"
              name="siteAddress"
              id="operation-site-siteAddress"
              data-cy="siteAddress"
              :class="{ valid: !$v.operationSite.siteAddress.$invalid, invalid: $v.operationSite.siteAddress.$invalid }"
              v-model="$v.operationSite.siteAddress.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.operationSite.cateGory')"
              for="operation-site-cateGory"
              >Cate Gory</label
            >
            <input
              type="text"
              class="form-control"
              name="cateGory"
              id="operation-site-cateGory"
              data-cy="cateGory"
              :class="{ valid: !$v.operationSite.cateGory.$invalid, invalid: $v.operationSite.cateGory.$invalid }"
              v-model="$v.operationSite.cateGory.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.operationSite.country')" for="operation-site-country"
              >Country</label
            >
            <input
              type="text"
              class="form-control"
              name="country"
              id="operation-site-country"
              data-cy="country"
              :class="{ valid: !$v.operationSite.country.$invalid, invalid: $v.operationSite.country.$invalid }"
              v-model="$v.operationSite.country.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.operationSite.boardId')" for="operation-site-boardId"
              >Board Id</label
            >
            <input
              type="text"
              class="form-control"
              name="boardId"
              id="operation-site-boardId"
              data-cy="boardId"
              :class="{ valid: !$v.operationSite.boardId.$invalid, invalid: $v.operationSite.boardId.$invalid }"
              v-model="$v.operationSite.boardId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.operationSite.kingdeeId')"
              for="operation-site-kingdeeId"
              >Kingdee Id</label
            >
            <input
              type="text"
              class="form-control"
              name="kingdeeId"
              id="operation-site-kingdeeId"
              data-cy="kingdeeId"
              :class="{ valid: !$v.operationSite.kingdeeId.$invalid, invalid: $v.operationSite.kingdeeId.$invalid }"
              v-model="$v.operationSite.kingdeeId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.operationSite.itemId')" for="operation-site-itemId"
              >Item Id</label
            >
            <input
              type="text"
              class="form-control"
              name="itemId"
              id="operation-site-itemId"
              data-cy="itemId"
              :class="{ valid: !$v.operationSite.itemId.$invalid, invalid: $v.operationSite.itemId.$invalid }"
              v-model="$v.operationSite.itemId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.operationSite.businessLicense')"
              for="operation-site-businessLicense"
              >Business License</label
            >
            <input
              type="text"
              class="form-control"
              name="businessLicense"
              id="operation-site-businessLicense"
              data-cy="businessLicense"
              :class="{ valid: !$v.operationSite.businessLicense.$invalid, invalid: $v.operationSite.businessLicense.$invalid }"
              v-model="$v.operationSite.businessLicense.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.operationSite.sasDate')" for="operation-site-sasDate"
              >Sas Date</label
            >
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="operation-site-sasDate"
                  v-model="$v.operationSite.sasDate.$model"
                  name="sasDate"
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
                id="operation-site-sasDate"
                data-cy="sasDate"
                type="text"
                class="form-control"
                name="sasDate"
                :class="{ valid: !$v.operationSite.sasDate.$invalid, invalid: $v.operationSite.sasDate.$invalid }"
                v-model="$v.operationSite.sasDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.operationSite.iso900ValidUtil')"
              for="operation-site-iso900ValidUtil"
              >Iso 900 Valid Util</label
            >
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="operation-site-iso900ValidUtil"
                  v-model="$v.operationSite.iso900ValidUtil.$model"
                  name="iso900ValidUtil"
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
                id="operation-site-iso900ValidUtil"
                data-cy="iso900ValidUtil"
                type="text"
                class="form-control"
                name="iso900ValidUtil"
                :class="{ valid: !$v.operationSite.iso900ValidUtil.$invalid, invalid: $v.operationSite.iso900ValidUtil.$invalid }"
                v-model="$v.operationSite.iso900ValidUtil.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.operationSite.iso14001ValidUtil')"
              for="operation-site-iso14001ValidUtil"
              >Iso 14001 Valid Util</label
            >
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="operation-site-iso14001ValidUtil"
                  v-model="$v.operationSite.iso14001ValidUtil.$model"
                  name="iso14001ValidUtil"
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
                id="operation-site-iso14001ValidUtil"
                data-cy="iso14001ValidUtil"
                type="text"
                class="form-control"
                name="iso14001ValidUtil"
                :class="{ valid: !$v.operationSite.iso14001ValidUtil.$invalid, invalid: $v.operationSite.iso14001ValidUtil.$invalid }"
                v-model="$v.operationSite.iso14001ValidUtil.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.operationSite.attributeLor')"
              for="operation-site-attributeLor"
              >Attribute Lor</label
            >
            <input
              type="text"
              class="form-control"
              name="attributeLor"
              id="operation-site-attributeLor"
              data-cy="attributeLor"
              :class="{ valid: !$v.operationSite.attributeLor.$invalid, invalid: $v.operationSite.attributeLor.$invalid }"
              v-model="$v.operationSite.attributeLor.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.operationSite.siteQualification')"
              for="operation-site-siteQualification"
              >Site Qualification</label
            >
            <input
              type="text"
              class="form-control"
              name="siteQualification"
              id="operation-site-siteQualification"
              data-cy="siteQualification"
              :class="{ valid: !$v.operationSite.siteQualification.$invalid, invalid: $v.operationSite.siteQualification.$invalid }"
              v-model="$v.operationSite.siteQualification.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.operationSite.qualificationScore')"
              for="operation-site-qualificationScore"
              >Qualification Score</label
            >
            <input
              type="text"
              class="form-control"
              name="qualificationScore"
              id="operation-site-qualificationScore"
              data-cy="qualificationScore"
              :class="{ valid: !$v.operationSite.qualificationScore.$invalid, invalid: $v.operationSite.qualificationScore.$invalid }"
              v-model="$v.operationSite.qualificationScore.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.operationSite.pqvScore')"
              for="operation-site-pqvScore"
              >Pqv Score</label
            >
            <input
              type="text"
              class="form-control"
              name="pqvScore"
              id="operation-site-pqvScore"
              data-cy="pqvScore"
              :class="{ valid: !$v.operationSite.pqvScore.$invalid, invalid: $v.operationSite.pqvScore.$invalid }"
              v-model="$v.operationSite.pqvScore.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.operationSite.pqvDate')" for="operation-site-pqvDate"
              >Pqv Date</label
            >
            <input
              type="text"
              class="form-control"
              name="pqvDate"
              id="operation-site-pqvDate"
              data-cy="pqvDate"
              :class="{ valid: !$v.operationSite.pqvDate.$invalid, invalid: $v.operationSite.pqvDate.$invalid }"
              v-model="$v.operationSite.pqvDate.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.operationSite.pqvDecision')"
              for="operation-site-pqvDecision"
              >Pqv Decision</label
            >
            <input
              type="text"
              class="form-control"
              name="pqvDecision"
              id="operation-site-pqvDecision"
              data-cy="pqvDecision"
              :class="{ valid: !$v.operationSite.pqvDecision.$invalid, invalid: $v.operationSite.pqvDecision.$invalid }"
              v-model="$v.operationSite.pqvDecision.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.operationSite.technicalAuditDate')"
              for="operation-site-technicalAuditDate"
              >Technical Audit Date</label
            >
            <input
              type="text"
              class="form-control"
              name="technicalAuditDate"
              id="operation-site-technicalAuditDate"
              data-cy="technicalAuditDate"
              :class="{ valid: !$v.operationSite.technicalAuditDate.$invalid, invalid: $v.operationSite.technicalAuditDate.$invalid }"
              v-model="$v.operationSite.technicalAuditDate.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.operationSite.technicalAuditScore')"
              for="operation-site-technicalAuditScore"
              >Technical Audit Score</label
            >
            <input
              type="text"
              class="form-control"
              name="technicalAuditScore"
              id="operation-site-technicalAuditScore"
              data-cy="technicalAuditScore"
              :class="{ valid: !$v.operationSite.technicalAuditScore.$invalid, invalid: $v.operationSite.technicalAuditScore.$invalid }"
              v-model="$v.operationSite.technicalAuditScore.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.operationSite.thirdRdPartyDate')"
              for="operation-site-thirdRdPartyDate"
              >Third Rd Party Date</label
            >
            <input
              type="text"
              class="form-control"
              name="thirdRdPartyDate"
              id="operation-site-thirdRdPartyDate"
              data-cy="thirdRdPartyDate"
              :class="{ valid: !$v.operationSite.thirdRdPartyDate.$invalid, invalid: $v.operationSite.thirdRdPartyDate.$invalid }"
              v-model="$v.operationSite.thirdRdPartyDate.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.operationSite.thirdRdPartyScore')"
              for="operation-site-thirdRdPartyScore"
              >Third Rd Party Score</label
            >
            <input
              type="text"
              class="form-control"
              name="thirdRdPartyScore"
              id="operation-site-thirdRdPartyScore"
              data-cy="thirdRdPartyScore"
              :class="{ valid: !$v.operationSite.thirdRdPartyScore.$invalid, invalid: $v.operationSite.thirdRdPartyScore.$invalid }"
              v-model="$v.operationSite.thirdRdPartyScore.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.operationSite.bopeDate')"
              for="operation-site-bopeDate"
              >Bope Date</label
            >
            <input
              type="text"
              class="form-control"
              name="bopeDate"
              id="operation-site-bopeDate"
              data-cy="bopeDate"
              :class="{ valid: !$v.operationSite.bopeDate.$invalid, invalid: $v.operationSite.bopeDate.$invalid }"
              v-model="$v.operationSite.bopeDate.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.operationSite.bopeScore')"
              for="operation-site-bopeScore"
              >Bope Score</label
            >
            <input
              type="text"
              class="form-control"
              name="bopeScore"
              id="operation-site-bopeScore"
              data-cy="bopeScore"
              :class="{ valid: !$v.operationSite.bopeScore.$invalid, invalid: $v.operationSite.bopeScore.$invalid }"
              v-model="$v.operationSite.bopeScore.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.operationSite.capRequired')"
              for="operation-site-capRequired"
              >Cap Required</label
            >
            <input
              type="text"
              class="form-control"
              name="capRequired"
              id="operation-site-capRequired"
              data-cy="capRequired"
              :class="{ valid: !$v.operationSite.capRequired.$invalid, invalid: $v.operationSite.capRequired.$invalid }"
              v-model="$v.operationSite.capRequired.$model"
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
            :disabled="$v.operationSite.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./operation-site-update.component.ts"></script>
