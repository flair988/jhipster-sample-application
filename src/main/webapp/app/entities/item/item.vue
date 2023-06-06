<template>
  <div>
    <h2 id="page-heading" data-cy="ItemHeading">
      <span v-text="$t('jhipsterSampleApplicationApp.item.home.title')" id="item-heading">Items</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('jhipsterSampleApplicationApp.item.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'ItemCreate' }" custom v-slot="{ navigate }">
          <button @click="navigate" id="jh-create-entity" data-cy="entityCreateButton" class="btn btn-primary jh-create-entity create-item">
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('jhipsterSampleApplicationApp.item.home.createLabel')"> Create a new Item </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && items && items.length === 0">
      <span v-text="$t('jhipsterSampleApplicationApp.item.home.notFound')">No items found</span>
    </div>
    <div class="table-responsive" v-if="items && items.length > 0">
      <table class="table table-striped" aria-describedby="items">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.people')">People</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.itemStatus')">Item Status</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.itemFranceName')">Item France Name</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.itemId')">Item Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.boardId')">Board Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.kingdeeId')">Kingdee Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.itemName')">Item Name</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.parentItem')">Parent Item</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.codeP')">Code P</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.codeag')">Codeag</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.mondayId')">Monday Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.dcsMerchandiser')">Dcs Merchandiser</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.stockedInProdex')">Stocked In Prodex</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.supplier')">Supplier</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.technicalDocuments')">Technical Documents</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.certification')">Certification</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.opportunitySheet')">Opportunity Sheet</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.packingType')">Packing Type</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.salePackageImage')">Sale Package Image</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.cartonLengthMilimeter')">Carton Length Milimeter</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.cartonHeightMilimeter')">Carton Height Milimeter</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.portOfDeparture')">Port Of Departure</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.barcode')">Barcode</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.cartonWeightKg')">Carton Weight Kg</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.cartonWeightGr')">Carton Weight Gr</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.cartonWidthMilimeter')">Carton Width Milimeter</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterSampleApplicationApp.item.productionLeadtimeCommitmentsFromSuppliers')"
                >Production Leadtime Commitments From Suppliers</span
              >
            </th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.negotiatedPrice')">Negotiated Price</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterSampleApplicationApp.item.productDescriptionAndFonctionalities')"
                >Product Description And Fonctionalities</span
              >
            </th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.drawing')">Drawing</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.userManual')">User Manual</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterSampleApplicationApp.item.supplierMarketingService')">Supplier Marketing Service</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.palletSize')">Pallet Size</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.typeOfMarketing')">Type Of Marketing</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.productPic')">Product Pic</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.updateDate')">Update Date</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.subItems')">Sub Items</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.mirror')">Mirror</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.label')">Label</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.moqsPcsCommitment')">Moqs Pcs Commitment</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.moqCommitment')">Moq Commitment</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterSampleApplicationApp.item.updatedMoqAfterNegotiation')">Updated Moq After Negotiation</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.uom')">Uom</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.bom')">Bom</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.priceManagementStatus')">Price Management Status</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.comment')">Comment</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.juneY')">June Y</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.commentsJuneY')">Comments June Y</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.decemberY')">December Y</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.commentsDecemberY')">Comments December Y</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.productTaxonomy')">Product Taxonomy</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.validPeriod')">Valid Period</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.withTax')">With Tax</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.unitPrice')">Unit Price</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.item.currency')">Currency</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="item in items" :key="item.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'ItemView', params: { itemId: item.id } }">{{ item.id }}</router-link>
            </td>
            <td>{{ item.people }}</td>
            <td>{{ item.itemStatus }}</td>
            <td>{{ item.itemFranceName }}</td>
            <td>{{ item.itemId }}</td>
            <td>{{ item.boardId }}</td>
            <td>{{ item.kingdeeId }}</td>
            <td>{{ item.itemName }}</td>
            <td>{{ item.parentItem }}</td>
            <td>{{ item.codeP }}</td>
            <td>{{ item.codeag }}</td>
            <td>{{ item.mondayId }}</td>
            <td>{{ item.dcsMerchandiser }}</td>
            <td>{{ item.stockedInProdex }}</td>
            <td>{{ item.supplier }}</td>
            <td>{{ item.technicalDocuments }}</td>
            <td>{{ item.certification }}</td>
            <td>{{ item.opportunitySheet }}</td>
            <td>{{ item.packingType }}</td>
            <td>{{ item.salePackageImage }}</td>
            <td>{{ item.cartonLengthMilimeter }}</td>
            <td>{{ item.cartonHeightMilimeter }}</td>
            <td>{{ item.portOfDeparture }}</td>
            <td>{{ item.barcode }}</td>
            <td>{{ item.cartonWeightKg }}</td>
            <td>{{ item.cartonWeightGr }}</td>
            <td>{{ item.cartonWidthMilimeter }}</td>
            <td>{{ item.productionLeadtimeCommitmentsFromSuppliers }}</td>
            <td>{{ item.negotiatedPrice }}</td>
            <td>{{ item.productDescriptionAndFonctionalities }}</td>
            <td>{{ item.drawing }}</td>
            <td>{{ item.userManual }}</td>
            <td>{{ item.supplierMarketingService }}</td>
            <td>{{ item.palletSize }}</td>
            <td>{{ item.typeOfMarketing }}</td>
            <td>{{ item.productPic }}</td>
            <td>{{ item.updateDate }}</td>
            <td>{{ item.subItems }}</td>
            <td>{{ item.mirror }}</td>
            <td>{{ item.label }}</td>
            <td>{{ item.moqsPcsCommitment }}</td>
            <td>{{ item.moqCommitment }}</td>
            <td>{{ item.updatedMoqAfterNegotiation }}</td>
            <td>{{ item.uom }}</td>
            <td>{{ item.bom }}</td>
            <td>{{ item.priceManagementStatus }}</td>
            <td>{{ item.comment }}</td>
            <td>{{ item.juneY }}</td>
            <td>{{ item.commentsJuneY }}</td>
            <td>{{ item.decemberY }}</td>
            <td>{{ item.commentsDecemberY }}</td>
            <td>{{ item.productTaxonomy }}</td>
            <td>{{ item.validPeriod }}</td>
            <td>{{ item.withTax }}</td>
            <td>{{ item.unitPrice }}</td>
            <td>{{ item.currency }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'ItemView', params: { itemId: item.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'ItemEdit', params: { itemId: item.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(item)"
                  variant="danger"
                  class="btn btn-sm"
                  data-cy="entityDeleteButton"
                  v-b-modal.removeEntity
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.delete')">Delete</span>
                </b-button>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span id="jhipsterSampleApplicationApp.item.delete.question" data-cy="itemDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-item-heading" v-text="$t('jhipsterSampleApplicationApp.item.delete.question', { id: removeId })">
          Are you sure you want to delete this Item?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-item"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeItem()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./item.component.ts"></script>
