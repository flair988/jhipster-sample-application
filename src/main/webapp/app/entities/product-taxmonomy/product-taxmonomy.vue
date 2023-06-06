<template>
  <div>
    <h2 id="page-heading" data-cy="ProductTaxmonomyHeading">
      <span v-text="$t('jhipsterSampleApplicationApp.productTaxmonomy.home.title')" id="product-taxmonomy-heading"
        >Product Taxmonomies</span
      >
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('jhipsterSampleApplicationApp.productTaxmonomy.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'ProductTaxmonomyCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-product-taxmonomy"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('jhipsterSampleApplicationApp.productTaxmonomy.home.createLabel')"> Create a new Product Taxmonomy </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && productTaxmonomies && productTaxmonomies.length === 0">
      <span v-text="$t('jhipsterSampleApplicationApp.productTaxmonomy.home.notFound')">No productTaxmonomies found</span>
    </div>
    <div class="table-responsive" v-if="productTaxmonomies && productTaxmonomies.length > 0">
      <table class="table table-striped" aria-describedby="productTaxmonomies">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.productTaxmonomy.itemId')">Item Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.productTaxmonomy.kingdeeId')">Kingdee Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.productTaxmonomy.itemName')">Item Name</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.productTaxmonomy.groupName')">Group Name</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.productTaxmonomy.parentGroupName')">Parent Group Name</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.productTaxmonomy.subGroupName')">Sub Group Name</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.productTaxmonomy.description')">Description</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.productTaxmonomy.boardId')">Board Id</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="productTaxmonomy in productTaxmonomies" :key="productTaxmonomy.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'ProductTaxmonomyView', params: { productTaxmonomyId: productTaxmonomy.id } }">{{
                productTaxmonomy.id
              }}</router-link>
            </td>
            <td>{{ productTaxmonomy.itemId }}</td>
            <td>{{ productTaxmonomy.kingdeeId }}</td>
            <td>{{ productTaxmonomy.itemName }}</td>
            <td>{{ productTaxmonomy.groupName }}</td>
            <td>{{ productTaxmonomy.parentGroupName }}</td>
            <td>{{ productTaxmonomy.subGroupName }}</td>
            <td>{{ productTaxmonomy.description }}</td>
            <td>{{ productTaxmonomy.boardId }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'ProductTaxmonomyView', params: { productTaxmonomyId: productTaxmonomy.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link
                  :to="{ name: 'ProductTaxmonomyEdit', params: { productTaxmonomyId: productTaxmonomy.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(productTaxmonomy)"
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
          id="jhipsterSampleApplicationApp.productTaxmonomy.delete.question"
          data-cy="productTaxmonomyDeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p
          id="jhi-delete-productTaxmonomy-heading"
          v-text="$t('jhipsterSampleApplicationApp.productTaxmonomy.delete.question', { id: removeId })"
        >
          Are you sure you want to delete this Product Taxmonomy?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-productTaxmonomy"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeProductTaxmonomy()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./product-taxmonomy.component.ts"></script>
