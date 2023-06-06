<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="item">
        <h2 class="jh-entity-heading" data-cy="itemDetailsHeading">
          <span v-text="$t('jhipsterSampleApplicationApp.item.detail.title')">Item</span> {{ item.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.people')">People</span>
          </dt>
          <dd>
            <span>{{ item.people }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.itemStatus')">Item Status</span>
          </dt>
          <dd>
            <span>{{ item.itemStatus }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.itemFranceName')">Item France Name</span>
          </dt>
          <dd>
            <span>{{ item.itemFranceName }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.itemId')">Item Id</span>
          </dt>
          <dd>
            <span>{{ item.itemId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.boardId')">Board Id</span>
          </dt>
          <dd>
            <span>{{ item.boardId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.kingdeeId')">Kingdee Id</span>
          </dt>
          <dd>
            <span>{{ item.kingdeeId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.itemName')">Item Name</span>
          </dt>
          <dd>
            <span>{{ item.itemName }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.parentItem')">Parent Item</span>
          </dt>
          <dd>
            <span>{{ item.parentItem }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.codeP')">Code P</span>
          </dt>
          <dd>
            <span>{{ item.codeP }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.codeag')">Codeag</span>
          </dt>
          <dd>
            <span>{{ item.codeag }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.mondayId')">Monday Id</span>
          </dt>
          <dd>
            <span>{{ item.mondayId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.dcsMerchandiser')">Dcs Merchandiser</span>
          </dt>
          <dd>
            <span>{{ item.dcsMerchandiser }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.stockedInProdex')">Stocked In Prodex</span>
          </dt>
          <dd>
            <span>{{ item.stockedInProdex }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.supplier')">Supplier</span>
          </dt>
          <dd>
            <span>{{ item.supplier }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.technicalDocuments')">Technical Documents</span>
          </dt>
          <dd>
            <span>{{ item.technicalDocuments }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.certification')">Certification</span>
          </dt>
          <dd>
            <span>{{ item.certification }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.opportunitySheet')">Opportunity Sheet</span>
          </dt>
          <dd>
            <span>{{ item.opportunitySheet }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.packingType')">Packing Type</span>
          </dt>
          <dd>
            <span>{{ item.packingType }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.salePackageImage')">Sale Package Image</span>
          </dt>
          <dd>
            <span>{{ item.salePackageImage }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.cartonLengthMilimeter')">Carton Length Milimeter</span>
          </dt>
          <dd>
            <span>{{ item.cartonLengthMilimeter }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.cartonHeightMilimeter')">Carton Height Milimeter</span>
          </dt>
          <dd>
            <span>{{ item.cartonHeightMilimeter }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.portOfDeparture')">Port Of Departure</span>
          </dt>
          <dd>
            <span>{{ item.portOfDeparture }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.barcode')">Barcode</span>
          </dt>
          <dd>
            <span>{{ item.barcode }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.cartonWeightKg')">Carton Weight Kg</span>
          </dt>
          <dd>
            <span>{{ item.cartonWeightKg }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.cartonWeightGr')">Carton Weight Gr</span>
          </dt>
          <dd>
            <span>{{ item.cartonWeightGr }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.cartonWidthMilimeter')">Carton Width Milimeter</span>
          </dt>
          <dd>
            <span>{{ item.cartonWidthMilimeter }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.productionLeadtimeCommitmentsFromSuppliers')"
              >Production Leadtime Commitments From Suppliers</span
            >
          </dt>
          <dd>
            <span>{{ item.productionLeadtimeCommitmentsFromSuppliers }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.negotiatedPrice')">Negotiated Price</span>
          </dt>
          <dd>
            <span>{{ item.negotiatedPrice }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.productDescriptionAndFonctionalities')"
              >Product Description And Fonctionalities</span
            >
          </dt>
          <dd>
            <span>{{ item.productDescriptionAndFonctionalities }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.drawing')">Drawing</span>
          </dt>
          <dd>
            <span>{{ item.drawing }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.userManual')">User Manual</span>
          </dt>
          <dd>
            <span>{{ item.userManual }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.supplierMarketingService')">Supplier Marketing Service</span>
          </dt>
          <dd>
            <span>{{ item.supplierMarketingService }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.palletSize')">Pallet Size</span>
          </dt>
          <dd>
            <span>{{ item.palletSize }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.typeOfMarketing')">Type Of Marketing</span>
          </dt>
          <dd>
            <span>{{ item.typeOfMarketing }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.productPic')">Product Pic</span>
          </dt>
          <dd>
            <span>{{ item.productPic }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.updateDate')">Update Date</span>
          </dt>
          <dd>
            <span>{{ item.updateDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.subItems')">Sub Items</span>
          </dt>
          <dd>
            <span>{{ item.subItems }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.mirror')">Mirror</span>
          </dt>
          <dd>
            <span>{{ item.mirror }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.label')">Label</span>
          </dt>
          <dd>
            <span>{{ item.label }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.moqsPcsCommitment')">Moqs Pcs Commitment</span>
          </dt>
          <dd>
            <span>{{ item.moqsPcsCommitment }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.moqCommitment')">Moq Commitment</span>
          </dt>
          <dd>
            <span>{{ item.moqCommitment }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.updatedMoqAfterNegotiation')">Updated Moq After Negotiation</span>
          </dt>
          <dd>
            <span>{{ item.updatedMoqAfterNegotiation }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.uom')">Uom</span>
          </dt>
          <dd>
            <span>{{ item.uom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.bom')">Bom</span>
          </dt>
          <dd>
            <span>{{ item.bom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.priceManagementStatus')">Price Management Status</span>
          </dt>
          <dd>
            <span>{{ item.priceManagementStatus }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.comment')">Comment</span>
          </dt>
          <dd>
            <span>{{ item.comment }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.juneY')">June Y</span>
          </dt>
          <dd>
            <span>{{ item.juneY }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.commentsJuneY')">Comments June Y</span>
          </dt>
          <dd>
            <span>{{ item.commentsJuneY }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.decemberY')">December Y</span>
          </dt>
          <dd>
            <span>{{ item.decemberY }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.commentsDecemberY')">Comments December Y</span>
          </dt>
          <dd>
            <span>{{ item.commentsDecemberY }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.productTaxonomy')">Product Taxonomy</span>
          </dt>
          <dd>
            <span>{{ item.productTaxonomy }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.validPeriod')">Valid Period</span>
          </dt>
          <dd>
            <span>{{ item.validPeriod }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.withTax')">With Tax</span>
          </dt>
          <dd>
            <span>{{ item.withTax }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.unitPrice')">Unit Price</span>
          </dt>
          <dd>
            <span>{{ item.unitPrice }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.item.currency')">Currency</span>
          </dt>
          <dd>
            <span>{{ item.currency }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link v-if="item.id" :to="{ name: 'ItemEdit', params: { itemId: item.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./item-details.component.ts"></script>
