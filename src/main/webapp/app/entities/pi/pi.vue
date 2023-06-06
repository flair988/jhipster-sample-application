<template>
  <div>
    <h2 id="page-heading" data-cy="PIHeading">
      <span v-text="$t('jhipsterSampleApplicationApp.pI.home.title')" id="pi-heading">PIS</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('jhipsterSampleApplicationApp.pI.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'PICreate' }" custom v-slot="{ navigate }">
          <button @click="navigate" id="jh-create-entity" data-cy="entityCreateButton" class="btn btn-primary jh-create-entity create-pi">
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('jhipsterSampleApplicationApp.pI.home.createLabel')"> Create a new PI </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && pIS && pIS.length === 0">
      <span v-text="$t('jhipsterSampleApplicationApp.pI.home.notFound')">No pIS found</span>
    </div>
    <div class="table-responsive" v-if="pIS && pIS.length > 0">
      <table class="table table-striped" aria-describedby="pIS">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.pI.itemName')">Item Name</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.pI.itemCode')">Item Code</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.pI.poNumber')">Po Number</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.pI.isNewItem')">Is New Item</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.pI.category')">Category</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.pI.client')">Client</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.pI.supplier')">Supplier</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.pI.supplierCode')">Supplier Code</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.pI.orderDate')">Order Date</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.pI.port')">Port</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterSampleApplicationApp.pI.requestedEndOfProdDate')">Requested End Of Prod Date</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.pI.itemQuantity')">Item Quantity</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.pI.countryOfOrigin')">Country Of Origin</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterSampleApplicationApp.pI.countryOfFinalDestination')">Country Of Final Destination</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterSampleApplicationApp.pI.productionLeadTimeCommitment')">Production Lead Time Commitment</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.pI.consignee')">Consignee</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.pI.carriageBy')">Carriage By</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.pI.termsOfDelivery')">Terms Of Delivery</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.pI.termsOfPayment')">Terms Of Payment</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.pI.itemUnit')">Item Unit</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.pI.rate')">Rate</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.pI.amount')">Amount</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.pI.totalAmount')">Total Amount</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.pI.discountRate')">Discount Rate</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.pI.currency')">Currency</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.pI.piStatus')">Pi Status</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.pI.remarks')">Remarks</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.pI.itemId')">Item Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.pI.boardId')">Board Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.pI.kingdeeId')">Kingdee Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.pI.portOfDischarge')">Port Of Discharge</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.pI.portOfLoading')">Port Of Loading</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="pI in pIS" :key="pI.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'PIView', params: { pIId: pI.id } }">{{ pI.id }}</router-link>
            </td>
            <td>{{ pI.itemName }}</td>
            <td>{{ pI.itemCode }}</td>
            <td>{{ pI.poNumber }}</td>
            <td>{{ pI.isNewItem }}</td>
            <td>{{ pI.category }}</td>
            <td>{{ pI.client }}</td>
            <td>{{ pI.supplier }}</td>
            <td>{{ pI.supplierCode }}</td>
            <td>{{ pI.orderDate }}</td>
            <td>{{ pI.port }}</td>
            <td>{{ pI.requestedEndOfProdDate }}</td>
            <td>{{ pI.itemQuantity }}</td>
            <td>{{ pI.countryOfOrigin }}</td>
            <td>{{ pI.countryOfFinalDestination }}</td>
            <td>{{ pI.productionLeadTimeCommitment }}</td>
            <td>{{ pI.consignee }}</td>
            <td>{{ pI.carriageBy }}</td>
            <td>{{ pI.termsOfDelivery }}</td>
            <td>{{ pI.termsOfPayment }}</td>
            <td>{{ pI.itemUnit }}</td>
            <td>{{ pI.rate }}</td>
            <td>{{ pI.amount }}</td>
            <td>{{ pI.totalAmount }}</td>
            <td>{{ pI.discountRate }}</td>
            <td>{{ pI.currency }}</td>
            <td>{{ pI.piStatus }}</td>
            <td>{{ pI.remarks }}</td>
            <td>{{ pI.itemId }}</td>
            <td>{{ pI.boardId }}</td>
            <td>{{ pI.kingdeeId }}</td>
            <td>{{ pI.portOfDischarge }}</td>
            <td>{{ pI.portOfLoading }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'PIView', params: { pIId: pI.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'PIEdit', params: { pIId: pI.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(pI)"
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
        ><span id="jhipsterSampleApplicationApp.pI.delete.question" data-cy="pIDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-pI-heading" v-text="$t('jhipsterSampleApplicationApp.pI.delete.question', { id: removeId })">
          Are you sure you want to delete this PI?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-pI"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removePI()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./pi.component.ts"></script>
