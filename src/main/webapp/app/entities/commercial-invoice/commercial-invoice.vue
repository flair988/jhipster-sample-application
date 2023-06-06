<template>
  <div>
    <h2 id="page-heading" data-cy="CommercialInvoiceHeading">
      <span v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.home.title')" id="commercial-invoice-heading"
        >Commercial Invoices</span
      >
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'CommercialInvoiceCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-commercial-invoice"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.home.createLabel')"> Create a new Commercial Invoice </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && commercialInvoices && commercialInvoices.length === 0">
      <span v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.home.notFound')">No commercialInvoices found</span>
    </div>
    <div class="table-responsive" v-if="commercialInvoices && commercialInvoices.length > 0">
      <table class="table table-striped" aria-describedby="commercialInvoices">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.itemName')">Item Name</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.itemId')">Item Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.boardId')">Board Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.kingdeeId')">Kingdee Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.date')">Date</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.client')">Client</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.cateGory')">Cate Gory</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.totalPrice')">Total Price</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.currency')">Currency</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.remarks')">Remarks</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="commercialInvoice in commercialInvoices" :key="commercialInvoice.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'CommercialInvoiceView', params: { commercialInvoiceId: commercialInvoice.id } }">{{
                commercialInvoice.id
              }}</router-link>
            </td>
            <td>{{ commercialInvoice.itemName }}</td>
            <td>{{ commercialInvoice.itemId }}</td>
            <td>{{ commercialInvoice.boardId }}</td>
            <td>{{ commercialInvoice.kingdeeId }}</td>
            <td>{{ commercialInvoice.date }}</td>
            <td>{{ commercialInvoice.client }}</td>
            <td>{{ commercialInvoice.cateGory }}</td>
            <td>{{ commercialInvoice.totalPrice }}</td>
            <td>{{ commercialInvoice.currency }}</td>
            <td>{{ commercialInvoice.remarks }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'CommercialInvoiceView', params: { commercialInvoiceId: commercialInvoice.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link
                  :to="{ name: 'CommercialInvoiceEdit', params: { commercialInvoiceId: commercialInvoice.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(commercialInvoice)"
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
          id="jhipsterSampleApplicationApp.commercialInvoice.delete.question"
          data-cy="commercialInvoiceDeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p
          id="jhi-delete-commercialInvoice-heading"
          v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.delete.question', { id: removeId })"
        >
          Are you sure you want to delete this Commercial Invoice?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-commercialInvoice"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeCommercialInvoice()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./commercial-invoice.component.ts"></script>
