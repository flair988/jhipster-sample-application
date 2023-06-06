<template>
  <div>
    <h2 id="page-heading" data-cy="OrderFollowUpHeading">
      <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.home.title')" id="order-follow-up-heading">Order Follow Ups</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'OrderFollowUpCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-order-follow-up"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.home.createLabel')"> Create a new Order Follow Up </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && orderFollowUps && orderFollowUps.length === 0">
      <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.home.notFound')">No orderFollowUps found</span>
    </div>
    <div class="table-responsive" v-if="orderFollowUps && orderFollowUps.length > 0">
      <table class="table table-striped" aria-describedby="orderFollowUps">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.itemId')">Item Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.poNumber')">Po Number</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.customer')">Customer</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.supplier')">Supplier</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.orderDate')">Order Date</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.cateGory')">Cate Gory</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.inspectionDate')">Inspection Date</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.requestEndOfProdDate')">Request End Of Prod Date</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.totalAmount')">Total Amount</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.totalDiscount')">Total Discount</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.disCountRate')">Dis Count Rate</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.regularCheck')">Regular Check</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.etd')">Etd</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.atd')">Atd</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.eta')">Eta</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.updatedEta')">Updated Eta</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.forwarder')">Forwarder</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.documentStatus')">Document Status</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.customInstruction')">Custom Instruction</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.customInspection')">Custom Inspection</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.depositPaymentDate')">Deposit Payment Date</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.balanceOfTotalPaymentDate')">Balance Of Total Payment Date</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.amountDepositPayment')">Amount Deposit Payment</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.amountPayment')">Amount Payment</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.dcMember')">Dc Member</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.comment')">Comment</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.itemName')">Item Name</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.boardId')">Board Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.kingdeeId')">Kingdee Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.parentKingdeeId')">Parent Kingdee Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.parentMondayId')">Parent Monday Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.qty')">Qty</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.itemCode')">Item Code</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.amount')">Amount</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.discount')">Discount</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.unit')">Unit</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.contractEndOfProdDate')">Contract End Of Prod Date</span>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="orderFollowUp in orderFollowUps" :key="orderFollowUp.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'OrderFollowUpView', params: { orderFollowUpId: orderFollowUp.id } }">{{
                orderFollowUp.id
              }}</router-link>
            </td>
            <td>{{ orderFollowUp.itemId }}</td>
            <td>{{ orderFollowUp.poNumber }}</td>
            <td>{{ orderFollowUp.customer }}</td>
            <td>{{ orderFollowUp.supplier }}</td>
            <td>{{ orderFollowUp.orderDate }}</td>
            <td>{{ orderFollowUp.cateGory }}</td>
            <td>{{ orderFollowUp.inspectionDate }}</td>
            <td>{{ orderFollowUp.requestEndOfProdDate }}</td>
            <td>{{ orderFollowUp.totalAmount }}</td>
            <td>{{ orderFollowUp.totalDiscount }}</td>
            <td>{{ orderFollowUp.disCountRate }}</td>
            <td>{{ orderFollowUp.regularCheck }}</td>
            <td>{{ orderFollowUp.etd }}</td>
            <td>{{ orderFollowUp.atd }}</td>
            <td>{{ orderFollowUp.eta }}</td>
            <td>{{ orderFollowUp.updatedEta }}</td>
            <td>{{ orderFollowUp.forwarder }}</td>
            <td>{{ orderFollowUp.documentStatus }}</td>
            <td>{{ orderFollowUp.customInstruction }}</td>
            <td>{{ orderFollowUp.customInspection }}</td>
            <td>{{ orderFollowUp.depositPaymentDate }}</td>
            <td>{{ orderFollowUp.balanceOfTotalPaymentDate }}</td>
            <td>{{ orderFollowUp.amountDepositPayment }}</td>
            <td>{{ orderFollowUp.amountPayment }}</td>
            <td>{{ orderFollowUp.dcMember }}</td>
            <td>{{ orderFollowUp.comment }}</td>
            <td>{{ orderFollowUp.itemName }}</td>
            <td>{{ orderFollowUp.boardId }}</td>
            <td>{{ orderFollowUp.kingdeeId }}</td>
            <td>{{ orderFollowUp.parentKingdeeId }}</td>
            <td>{{ orderFollowUp.parentMondayId }}</td>
            <td>{{ orderFollowUp.qty }}</td>
            <td>{{ orderFollowUp.itemCode }}</td>
            <td>{{ orderFollowUp.amount }}</td>
            <td>{{ orderFollowUp.discount }}</td>
            <td>{{ orderFollowUp.unit }}</td>
            <td>{{ orderFollowUp.contractEndOfProdDate }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'OrderFollowUpView', params: { orderFollowUpId: orderFollowUp.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link
                  :to="{ name: 'OrderFollowUpEdit', params: { orderFollowUpId: orderFollowUp.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(orderFollowUp)"
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
          id="jhipsterSampleApplicationApp.orderFollowUp.delete.question"
          data-cy="orderFollowUpDeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p
          id="jhi-delete-orderFollowUp-heading"
          v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.delete.question', { id: removeId })"
        >
          Are you sure you want to delete this Order Follow Up?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-orderFollowUp"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeOrderFollowUp()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./order-follow-up.component.ts"></script>
