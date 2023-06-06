<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterSampleApplicationApp.item.home.createOrEditLabel"
          data-cy="ItemCreateUpdateHeading"
          v-text="$t('jhipsterSampleApplicationApp.item.home.createOrEditLabel')"
        >
          Create or edit a Item
        </h2>
        <div>
          <div class="form-group" v-if="item.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="item.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.people')" for="item-people">People</label>
            <input
              type="text"
              class="form-control"
              name="people"
              id="item-people"
              data-cy="people"
              :class="{ valid: !$v.item.people.$invalid, invalid: $v.item.people.$invalid }"
              v-model="$v.item.people.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.itemStatus')" for="item-itemStatus"
              >Item Status</label
            >
            <input
              type="text"
              class="form-control"
              name="itemStatus"
              id="item-itemStatus"
              data-cy="itemStatus"
              :class="{ valid: !$v.item.itemStatus.$invalid, invalid: $v.item.itemStatus.$invalid }"
              v-model="$v.item.itemStatus.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.itemFranceName')" for="item-itemFranceName"
              >Item France Name</label
            >
            <input
              type="text"
              class="form-control"
              name="itemFranceName"
              id="item-itemFranceName"
              data-cy="itemFranceName"
              :class="{ valid: !$v.item.itemFranceName.$invalid, invalid: $v.item.itemFranceName.$invalid }"
              v-model="$v.item.itemFranceName.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.itemId')" for="item-itemId">Item Id</label>
            <input
              type="text"
              class="form-control"
              name="itemId"
              id="item-itemId"
              data-cy="itemId"
              :class="{ valid: !$v.item.itemId.$invalid, invalid: $v.item.itemId.$invalid }"
              v-model="$v.item.itemId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.boardId')" for="item-boardId">Board Id</label>
            <input
              type="text"
              class="form-control"
              name="boardId"
              id="item-boardId"
              data-cy="boardId"
              :class="{ valid: !$v.item.boardId.$invalid, invalid: $v.item.boardId.$invalid }"
              v-model="$v.item.boardId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.kingdeeId')" for="item-kingdeeId"
              >Kingdee Id</label
            >
            <input
              type="text"
              class="form-control"
              name="kingdeeId"
              id="item-kingdeeId"
              data-cy="kingdeeId"
              :class="{ valid: !$v.item.kingdeeId.$invalid, invalid: $v.item.kingdeeId.$invalid }"
              v-model="$v.item.kingdeeId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.itemName')" for="item-itemName"
              >Item Name</label
            >
            <input
              type="text"
              class="form-control"
              name="itemName"
              id="item-itemName"
              data-cy="itemName"
              :class="{ valid: !$v.item.itemName.$invalid, invalid: $v.item.itemName.$invalid }"
              v-model="$v.item.itemName.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.parentItem')" for="item-parentItem"
              >Parent Item</label
            >
            <input
              type="text"
              class="form-control"
              name="parentItem"
              id="item-parentItem"
              data-cy="parentItem"
              :class="{ valid: !$v.item.parentItem.$invalid, invalid: $v.item.parentItem.$invalid }"
              v-model="$v.item.parentItem.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.codeP')" for="item-codeP">Code P</label>
            <input
              type="text"
              class="form-control"
              name="codeP"
              id="item-codeP"
              data-cy="codeP"
              :class="{ valid: !$v.item.codeP.$invalid, invalid: $v.item.codeP.$invalid }"
              v-model="$v.item.codeP.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.codeag')" for="item-codeag">Codeag</label>
            <input
              type="text"
              class="form-control"
              name="codeag"
              id="item-codeag"
              data-cy="codeag"
              :class="{ valid: !$v.item.codeag.$invalid, invalid: $v.item.codeag.$invalid }"
              v-model="$v.item.codeag.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.mondayId')" for="item-mondayId"
              >Monday Id</label
            >
            <input
              type="text"
              class="form-control"
              name="mondayId"
              id="item-mondayId"
              data-cy="mondayId"
              :class="{ valid: !$v.item.mondayId.$invalid, invalid: $v.item.mondayId.$invalid }"
              v-model="$v.item.mondayId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.dcsMerchandiser')" for="item-dcsMerchandiser"
              >Dcs Merchandiser</label
            >
            <input
              type="text"
              class="form-control"
              name="dcsMerchandiser"
              id="item-dcsMerchandiser"
              data-cy="dcsMerchandiser"
              :class="{ valid: !$v.item.dcsMerchandiser.$invalid, invalid: $v.item.dcsMerchandiser.$invalid }"
              v-model="$v.item.dcsMerchandiser.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.stockedInProdex')" for="item-stockedInProdex"
              >Stocked In Prodex</label
            >
            <input
              type="text"
              class="form-control"
              name="stockedInProdex"
              id="item-stockedInProdex"
              data-cy="stockedInProdex"
              :class="{ valid: !$v.item.stockedInProdex.$invalid, invalid: $v.item.stockedInProdex.$invalid }"
              v-model="$v.item.stockedInProdex.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.supplier')" for="item-supplier">Supplier</label>
            <input
              type="text"
              class="form-control"
              name="supplier"
              id="item-supplier"
              data-cy="supplier"
              :class="{ valid: !$v.item.supplier.$invalid, invalid: $v.item.supplier.$invalid }"
              v-model="$v.item.supplier.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.item.technicalDocuments')"
              for="item-technicalDocuments"
              >Technical Documents</label
            >
            <input
              type="text"
              class="form-control"
              name="technicalDocuments"
              id="item-technicalDocuments"
              data-cy="technicalDocuments"
              :class="{ valid: !$v.item.technicalDocuments.$invalid, invalid: $v.item.technicalDocuments.$invalid }"
              v-model="$v.item.technicalDocuments.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.certification')" for="item-certification"
              >Certification</label
            >
            <input
              type="text"
              class="form-control"
              name="certification"
              id="item-certification"
              data-cy="certification"
              :class="{ valid: !$v.item.certification.$invalid, invalid: $v.item.certification.$invalid }"
              v-model="$v.item.certification.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.opportunitySheet')" for="item-opportunitySheet"
              >Opportunity Sheet</label
            >
            <input
              type="text"
              class="form-control"
              name="opportunitySheet"
              id="item-opportunitySheet"
              data-cy="opportunitySheet"
              :class="{ valid: !$v.item.opportunitySheet.$invalid, invalid: $v.item.opportunitySheet.$invalid }"
              v-model="$v.item.opportunitySheet.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.packingType')" for="item-packingType"
              >Packing Type</label
            >
            <input
              type="text"
              class="form-control"
              name="packingType"
              id="item-packingType"
              data-cy="packingType"
              :class="{ valid: !$v.item.packingType.$invalid, invalid: $v.item.packingType.$invalid }"
              v-model="$v.item.packingType.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.salePackageImage')" for="item-salePackageImage"
              >Sale Package Image</label
            >
            <input
              type="text"
              class="form-control"
              name="salePackageImage"
              id="item-salePackageImage"
              data-cy="salePackageImage"
              :class="{ valid: !$v.item.salePackageImage.$invalid, invalid: $v.item.salePackageImage.$invalid }"
              v-model="$v.item.salePackageImage.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.item.cartonLengthMilimeter')"
              for="item-cartonLengthMilimeter"
              >Carton Length Milimeter</label
            >
            <input
              type="text"
              class="form-control"
              name="cartonLengthMilimeter"
              id="item-cartonLengthMilimeter"
              data-cy="cartonLengthMilimeter"
              :class="{ valid: !$v.item.cartonLengthMilimeter.$invalid, invalid: $v.item.cartonLengthMilimeter.$invalid }"
              v-model="$v.item.cartonLengthMilimeter.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.item.cartonHeightMilimeter')"
              for="item-cartonHeightMilimeter"
              >Carton Height Milimeter</label
            >
            <input
              type="text"
              class="form-control"
              name="cartonHeightMilimeter"
              id="item-cartonHeightMilimeter"
              data-cy="cartonHeightMilimeter"
              :class="{ valid: !$v.item.cartonHeightMilimeter.$invalid, invalid: $v.item.cartonHeightMilimeter.$invalid }"
              v-model="$v.item.cartonHeightMilimeter.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.portOfDeparture')" for="item-portOfDeparture"
              >Port Of Departure</label
            >
            <input
              type="text"
              class="form-control"
              name="portOfDeparture"
              id="item-portOfDeparture"
              data-cy="portOfDeparture"
              :class="{ valid: !$v.item.portOfDeparture.$invalid, invalid: $v.item.portOfDeparture.$invalid }"
              v-model="$v.item.portOfDeparture.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.barcode')" for="item-barcode">Barcode</label>
            <input
              type="text"
              class="form-control"
              name="barcode"
              id="item-barcode"
              data-cy="barcode"
              :class="{ valid: !$v.item.barcode.$invalid, invalid: $v.item.barcode.$invalid }"
              v-model="$v.item.barcode.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.cartonWeightKg')" for="item-cartonWeightKg"
              >Carton Weight Kg</label
            >
            <input
              type="text"
              class="form-control"
              name="cartonWeightKg"
              id="item-cartonWeightKg"
              data-cy="cartonWeightKg"
              :class="{ valid: !$v.item.cartonWeightKg.$invalid, invalid: $v.item.cartonWeightKg.$invalid }"
              v-model="$v.item.cartonWeightKg.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.cartonWeightGr')" for="item-cartonWeightGr"
              >Carton Weight Gr</label
            >
            <input
              type="text"
              class="form-control"
              name="cartonWeightGr"
              id="item-cartonWeightGr"
              data-cy="cartonWeightGr"
              :class="{ valid: !$v.item.cartonWeightGr.$invalid, invalid: $v.item.cartonWeightGr.$invalid }"
              v-model="$v.item.cartonWeightGr.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.item.cartonWidthMilimeter')"
              for="item-cartonWidthMilimeter"
              >Carton Width Milimeter</label
            >
            <input
              type="text"
              class="form-control"
              name="cartonWidthMilimeter"
              id="item-cartonWidthMilimeter"
              data-cy="cartonWidthMilimeter"
              :class="{ valid: !$v.item.cartonWidthMilimeter.$invalid, invalid: $v.item.cartonWidthMilimeter.$invalid }"
              v-model="$v.item.cartonWidthMilimeter.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.item.productionLeadtimeCommitmentsFromSuppliers')"
              for="item-productionLeadtimeCommitmentsFromSuppliers"
              >Production Leadtime Commitments From Suppliers</label
            >
            <input
              type="text"
              class="form-control"
              name="productionLeadtimeCommitmentsFromSuppliers"
              id="item-productionLeadtimeCommitmentsFromSuppliers"
              data-cy="productionLeadtimeCommitmentsFromSuppliers"
              :class="{
                valid: !$v.item.productionLeadtimeCommitmentsFromSuppliers.$invalid,
                invalid: $v.item.productionLeadtimeCommitmentsFromSuppliers.$invalid,
              }"
              v-model="$v.item.productionLeadtimeCommitmentsFromSuppliers.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.negotiatedPrice')" for="item-negotiatedPrice"
              >Negotiated Price</label
            >
            <input
              type="text"
              class="form-control"
              name="negotiatedPrice"
              id="item-negotiatedPrice"
              data-cy="negotiatedPrice"
              :class="{ valid: !$v.item.negotiatedPrice.$invalid, invalid: $v.item.negotiatedPrice.$invalid }"
              v-model="$v.item.negotiatedPrice.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.item.productDescriptionAndFonctionalities')"
              for="item-productDescriptionAndFonctionalities"
              >Product Description And Fonctionalities</label
            >
            <input
              type="text"
              class="form-control"
              name="productDescriptionAndFonctionalities"
              id="item-productDescriptionAndFonctionalities"
              data-cy="productDescriptionAndFonctionalities"
              :class="{
                valid: !$v.item.productDescriptionAndFonctionalities.$invalid,
                invalid: $v.item.productDescriptionAndFonctionalities.$invalid,
              }"
              v-model="$v.item.productDescriptionAndFonctionalities.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.drawing')" for="item-drawing">Drawing</label>
            <input
              type="text"
              class="form-control"
              name="drawing"
              id="item-drawing"
              data-cy="drawing"
              :class="{ valid: !$v.item.drawing.$invalid, invalid: $v.item.drawing.$invalid }"
              v-model="$v.item.drawing.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.userManual')" for="item-userManual"
              >User Manual</label
            >
            <input
              type="text"
              class="form-control"
              name="userManual"
              id="item-userManual"
              data-cy="userManual"
              :class="{ valid: !$v.item.userManual.$invalid, invalid: $v.item.userManual.$invalid }"
              v-model="$v.item.userManual.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.item.supplierMarketingService')"
              for="item-supplierMarketingService"
              >Supplier Marketing Service</label
            >
            <input
              type="text"
              class="form-control"
              name="supplierMarketingService"
              id="item-supplierMarketingService"
              data-cy="supplierMarketingService"
              :class="{ valid: !$v.item.supplierMarketingService.$invalid, invalid: $v.item.supplierMarketingService.$invalid }"
              v-model="$v.item.supplierMarketingService.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.palletSize')" for="item-palletSize"
              >Pallet Size</label
            >
            <input
              type="text"
              class="form-control"
              name="palletSize"
              id="item-palletSize"
              data-cy="palletSize"
              :class="{ valid: !$v.item.palletSize.$invalid, invalid: $v.item.palletSize.$invalid }"
              v-model="$v.item.palletSize.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.typeOfMarketing')" for="item-typeOfMarketing"
              >Type Of Marketing</label
            >
            <input
              type="text"
              class="form-control"
              name="typeOfMarketing"
              id="item-typeOfMarketing"
              data-cy="typeOfMarketing"
              :class="{ valid: !$v.item.typeOfMarketing.$invalid, invalid: $v.item.typeOfMarketing.$invalid }"
              v-model="$v.item.typeOfMarketing.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.productPic')" for="item-productPic"
              >Product Pic</label
            >
            <input
              type="text"
              class="form-control"
              name="productPic"
              id="item-productPic"
              data-cy="productPic"
              :class="{ valid: !$v.item.productPic.$invalid, invalid: $v.item.productPic.$invalid }"
              v-model="$v.item.productPic.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.updateDate')" for="item-updateDate"
              >Update Date</label
            >
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="item-updateDate"
                  v-model="$v.item.updateDate.$model"
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
                id="item-updateDate"
                data-cy="updateDate"
                type="text"
                class="form-control"
                name="updateDate"
                :class="{ valid: !$v.item.updateDate.$invalid, invalid: $v.item.updateDate.$invalid }"
                v-model="$v.item.updateDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.subItems')" for="item-subItems"
              >Sub Items</label
            >
            <input
              type="text"
              class="form-control"
              name="subItems"
              id="item-subItems"
              data-cy="subItems"
              :class="{ valid: !$v.item.subItems.$invalid, invalid: $v.item.subItems.$invalid }"
              v-model="$v.item.subItems.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.mirror')" for="item-mirror">Mirror</label>
            <input
              type="text"
              class="form-control"
              name="mirror"
              id="item-mirror"
              data-cy="mirror"
              :class="{ valid: !$v.item.mirror.$invalid, invalid: $v.item.mirror.$invalid }"
              v-model="$v.item.mirror.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.label')" for="item-label">Label</label>
            <input
              type="text"
              class="form-control"
              name="label"
              id="item-label"
              data-cy="label"
              :class="{ valid: !$v.item.label.$invalid, invalid: $v.item.label.$invalid }"
              v-model="$v.item.label.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.item.moqsPcsCommitment')"
              for="item-moqsPcsCommitment"
              >Moqs Pcs Commitment</label
            >
            <input
              type="text"
              class="form-control"
              name="moqsPcsCommitment"
              id="item-moqsPcsCommitment"
              data-cy="moqsPcsCommitment"
              :class="{ valid: !$v.item.moqsPcsCommitment.$invalid, invalid: $v.item.moqsPcsCommitment.$invalid }"
              v-model="$v.item.moqsPcsCommitment.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.moqCommitment')" for="item-moqCommitment"
              >Moq Commitment</label
            >
            <input
              type="text"
              class="form-control"
              name="moqCommitment"
              id="item-moqCommitment"
              data-cy="moqCommitment"
              :class="{ valid: !$v.item.moqCommitment.$invalid, invalid: $v.item.moqCommitment.$invalid }"
              v-model="$v.item.moqCommitment.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.item.updatedMoqAfterNegotiation')"
              for="item-updatedMoqAfterNegotiation"
              >Updated Moq After Negotiation</label
            >
            <input
              type="text"
              class="form-control"
              name="updatedMoqAfterNegotiation"
              id="item-updatedMoqAfterNegotiation"
              data-cy="updatedMoqAfterNegotiation"
              :class="{ valid: !$v.item.updatedMoqAfterNegotiation.$invalid, invalid: $v.item.updatedMoqAfterNegotiation.$invalid }"
              v-model="$v.item.updatedMoqAfterNegotiation.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.uom')" for="item-uom">Uom</label>
            <input
              type="text"
              class="form-control"
              name="uom"
              id="item-uom"
              data-cy="uom"
              :class="{ valid: !$v.item.uom.$invalid, invalid: $v.item.uom.$invalid }"
              v-model="$v.item.uom.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.bom')" for="item-bom">Bom</label>
            <input
              type="text"
              class="form-control"
              name="bom"
              id="item-bom"
              data-cy="bom"
              :class="{ valid: !$v.item.bom.$invalid, invalid: $v.item.bom.$invalid }"
              v-model="$v.item.bom.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.item.priceManagementStatus')"
              for="item-priceManagementStatus"
              >Price Management Status</label
            >
            <input
              type="text"
              class="form-control"
              name="priceManagementStatus"
              id="item-priceManagementStatus"
              data-cy="priceManagementStatus"
              :class="{ valid: !$v.item.priceManagementStatus.$invalid, invalid: $v.item.priceManagementStatus.$invalid }"
              v-model="$v.item.priceManagementStatus.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.comment')" for="item-comment">Comment</label>
            <input
              type="text"
              class="form-control"
              name="comment"
              id="item-comment"
              data-cy="comment"
              :class="{ valid: !$v.item.comment.$invalid, invalid: $v.item.comment.$invalid }"
              v-model="$v.item.comment.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.juneY')" for="item-juneY">June Y</label>
            <input
              type="text"
              class="form-control"
              name="juneY"
              id="item-juneY"
              data-cy="juneY"
              :class="{ valid: !$v.item.juneY.$invalid, invalid: $v.item.juneY.$invalid }"
              v-model="$v.item.juneY.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.commentsJuneY')" for="item-commentsJuneY"
              >Comments June Y</label
            >
            <input
              type="text"
              class="form-control"
              name="commentsJuneY"
              id="item-commentsJuneY"
              data-cy="commentsJuneY"
              :class="{ valid: !$v.item.commentsJuneY.$invalid, invalid: $v.item.commentsJuneY.$invalid }"
              v-model="$v.item.commentsJuneY.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.decemberY')" for="item-decemberY"
              >December Y</label
            >
            <input
              type="text"
              class="form-control"
              name="decemberY"
              id="item-decemberY"
              data-cy="decemberY"
              :class="{ valid: !$v.item.decemberY.$invalid, invalid: $v.item.decemberY.$invalid }"
              v-model="$v.item.decemberY.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.item.commentsDecemberY')"
              for="item-commentsDecemberY"
              >Comments December Y</label
            >
            <input
              type="text"
              class="form-control"
              name="commentsDecemberY"
              id="item-commentsDecemberY"
              data-cy="commentsDecemberY"
              :class="{ valid: !$v.item.commentsDecemberY.$invalid, invalid: $v.item.commentsDecemberY.$invalid }"
              v-model="$v.item.commentsDecemberY.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.productTaxonomy')" for="item-productTaxonomy"
              >Product Taxonomy</label
            >
            <input
              type="text"
              class="form-control"
              name="productTaxonomy"
              id="item-productTaxonomy"
              data-cy="productTaxonomy"
              :class="{ valid: !$v.item.productTaxonomy.$invalid, invalid: $v.item.productTaxonomy.$invalid }"
              v-model="$v.item.productTaxonomy.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.validPeriod')" for="item-validPeriod"
              >Valid Period</label
            >
            <input
              type="text"
              class="form-control"
              name="validPeriod"
              id="item-validPeriod"
              data-cy="validPeriod"
              :class="{ valid: !$v.item.validPeriod.$invalid, invalid: $v.item.validPeriod.$invalid }"
              v-model="$v.item.validPeriod.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.withTax')" for="item-withTax">With Tax</label>
            <input
              type="text"
              class="form-control"
              name="withTax"
              id="item-withTax"
              data-cy="withTax"
              :class="{ valid: !$v.item.withTax.$invalid, invalid: $v.item.withTax.$invalid }"
              v-model="$v.item.withTax.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.unitPrice')" for="item-unitPrice"
              >Unit Price</label
            >
            <input
              type="text"
              class="form-control"
              name="unitPrice"
              id="item-unitPrice"
              data-cy="unitPrice"
              :class="{ valid: !$v.item.unitPrice.$invalid, invalid: $v.item.unitPrice.$invalid }"
              v-model="$v.item.unitPrice.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.item.currency')" for="item-currency">Currency</label>
            <input
              type="text"
              class="form-control"
              name="currency"
              id="item-currency"
              data-cy="currency"
              :class="{ valid: !$v.item.currency.$invalid, invalid: $v.item.currency.$invalid }"
              v-model="$v.item.currency.$model"
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
            :disabled="$v.item.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./item-update.component.ts"></script>
