<template>
  <div>
    <h2 id="page-heading" data-cy="SupplierHeading">
      <span v-text="$t('jhipsterSampleApplicationApp.supplier.home.title')" id="supplier-heading">Suppliers</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('jhipsterSampleApplicationApp.supplier.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'SupplierCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-supplier"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('jhipsterSampleApplicationApp.supplier.home.createLabel')"> Create a new Supplier </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && suppliers && suppliers.length === 0">
      <span v-text="$t('jhipsterSampleApplicationApp.supplier.home.notFound')">No suppliers found</span>
    </div>
    <div class="table-responsive" v-if="suppliers && suppliers.length > 0">
      <table class="table table-striped" aria-describedby="suppliers">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.supplier.client')">Client</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.supplier.parentItem')">Parent Item</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.supplier.itemId')">Item Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.supplier.boardId')">Board Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.supplier.person')">Person</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.supplier.category')">Category</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.supplier.subCategory')">Sub Category</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.supplier.supplierStatus')">Supplier Status</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.supplier.capStatus')">Cap Status</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.supplier.qualificationScore')">Qualification Score</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.supplier.bopeScore')">Bope Score</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.supplier.internalSupplierId')">Internal Supplier Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.supplier.contact')">Contact</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.supplier.contactPhoneNumber')">Contact Phone Number</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.supplier.contactEmailAddress')">Contact Email Address</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.supplier.country')">Country</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.supplier.operationSite')">Operation Site</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.supplier.address')">Address</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.supplier.website')">Website</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.supplier.productTaxonomy')">Product Taxonomy</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterSampleApplicationApp.supplier.relationStartingYear')">Relation Starting Year</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.supplier.businessLicense')">Business License</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.supplier.rexOriginStatus')">Rex Origin Status</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.supplier.createDate')">Create Date</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.supplier.updateDate')">Update Date</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.supplier.item')">Item</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.supplier.mirror')">Mirror</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.supplier.subItems')">Sub Items</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.supplier.owner')">Owner</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.supplier.status')">Status</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.supplier.date')">Date</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.supplier.formula')">Formula</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.supplier.kingdeeId')">Kingdee Id</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="supplier in suppliers" :key="supplier.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'SupplierView', params: { supplierId: supplier.id } }">{{ supplier.id }}</router-link>
            </td>
            <td>{{ supplier.client }}</td>
            <td>{{ supplier.parentItem }}</td>
            <td>{{ supplier.itemId }}</td>
            <td>{{ supplier.boardId }}</td>
            <td>{{ supplier.person }}</td>
            <td>{{ supplier.category }}</td>
            <td>{{ supplier.subCategory }}</td>
            <td>{{ supplier.supplierStatus }}</td>
            <td>{{ supplier.capStatus }}</td>
            <td>{{ supplier.qualificationScore }}</td>
            <td>{{ supplier.bopeScore }}</td>
            <td>{{ supplier.internalSupplierId }}</td>
            <td>{{ supplier.contact }}</td>
            <td>{{ supplier.contactPhoneNumber }}</td>
            <td>{{ supplier.contactEmailAddress }}</td>
            <td>{{ supplier.country }}</td>
            <td>{{ supplier.operationSite }}</td>
            <td>{{ supplier.address }}</td>
            <td>{{ supplier.website }}</td>
            <td>{{ supplier.productTaxonomy }}</td>
            <td>{{ supplier.relationStartingYear }}</td>
            <td>{{ supplier.businessLicense }}</td>
            <td>{{ supplier.rexOriginStatus }}</td>
            <td>{{ supplier.createDate }}</td>
            <td>{{ supplier.updateDate }}</td>
            <td>{{ supplier.item }}</td>
            <td>{{ supplier.mirror }}</td>
            <td>{{ supplier.subItems }}</td>
            <td>{{ supplier.owner }}</td>
            <td>{{ supplier.status }}</td>
            <td>{{ supplier.date }}</td>
            <td>{{ supplier.formula }}</td>
            <td>{{ supplier.kingdeeId }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'SupplierView', params: { supplierId: supplier.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'SupplierEdit', params: { supplierId: supplier.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(supplier)"
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
        ><span
          id="jhipsterSampleApplicationApp.supplier.delete.question"
          data-cy="supplierDeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-supplier-heading" v-text="$t('jhipsterSampleApplicationApp.supplier.delete.question', { id: removeId })">
          Are you sure you want to delete this Supplier?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-supplier"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeSupplier()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./supplier.component.ts"></script>
