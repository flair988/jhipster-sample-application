<template>
  <div>
    <h2 id="page-heading" data-cy="ProductFinishedHeading">
      <span v-text="$t('jhipsterSampleApplicationApp.productFinished.home.title')" id="product-finished-heading">Product Finisheds</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('jhipsterSampleApplicationApp.productFinished.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'ProductFinishedCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-product-finished"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('jhipsterSampleApplicationApp.productFinished.home.createLabel')"> Create a new Product Finished </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && productFinisheds && productFinisheds.length === 0">
      <span v-text="$t('jhipsterSampleApplicationApp.productFinished.home.notFound')">No productFinisheds found</span>
    </div>
    <div class="table-responsive" v-if="productFinisheds && productFinisheds.length > 0">
      <table class="table table-striped" aria-describedby="productFinisheds">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.productFinished.itemName')">Item Name</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.productFinished.itemId')">Item Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.productFinished.boardId')">Board Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.productFinished.kingdeeId')">Kingdee Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.productFinished.supplier')">Supplier</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.productFinished.supplierEmail')">Supplier Email</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.productFinished.orderDate')">Order Date</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.productFinished.cateGory')">Cate Gory</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.productFinished.remark')">Remark</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterSampleApplicationApp.productFinished.materialReceiptDate')">Material Receipt Date</span>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="productFinished in productFinisheds" :key="productFinished.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'ProductFinishedView', params: { productFinishedId: productFinished.id } }">{{
                productFinished.id
              }}</router-link>
            </td>
            <td>{{ productFinished.itemName }}</td>
            <td>{{ productFinished.itemId }}</td>
            <td>{{ productFinished.boardId }}</td>
            <td>{{ productFinished.kingdeeId }}</td>
            <td>{{ productFinished.supplier }}</td>
            <td>{{ productFinished.supplierEmail }}</td>
            <td>{{ productFinished.orderDate }}</td>
            <td>{{ productFinished.cateGory }}</td>
            <td>{{ productFinished.remark }}</td>
            <td>{{ productFinished.materialReceiptDate }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'ProductFinishedView', params: { productFinishedId: productFinished.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link
                  :to="{ name: 'ProductFinishedEdit', params: { productFinishedId: productFinished.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(productFinished)"
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
          id="jhipsterSampleApplicationApp.productFinished.delete.question"
          data-cy="productFinishedDeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p
          id="jhi-delete-productFinished-heading"
          v-text="$t('jhipsterSampleApplicationApp.productFinished.delete.question', { id: removeId })"
        >
          Are you sure you want to delete this Product Finished?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-productFinished"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeProductFinished()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./product-finished.component.ts"></script>
