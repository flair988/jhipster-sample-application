<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterSampleApplicationApp.orderFollowUp.home.createOrEditLabel"
          data-cy="OrderFollowUpCreateUpdateHeading"
          v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.home.createOrEditLabel')"
        >
          Create or edit a OrderFollowUp
        </h2>
        <div>
          <div class="form-group" v-if="orderFollowUp.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="orderFollowUp.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.itemId')" for="order-follow-up-itemId"
              >Item Id</label
            >
            <input
              type="text"
              class="form-control"
              name="itemId"
              id="order-follow-up-itemId"
              data-cy="itemId"
              :class="{ valid: !$v.orderFollowUp.itemId.$invalid, invalid: $v.orderFollowUp.itemId.$invalid }"
              v-model="$v.orderFollowUp.itemId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.poNumber')"
              for="order-follow-up-poNumber"
              >Po Number</label
            >
            <input
              type="text"
              class="form-control"
              name="poNumber"
              id="order-follow-up-poNumber"
              data-cy="poNumber"
              :class="{ valid: !$v.orderFollowUp.poNumber.$invalid, invalid: $v.orderFollowUp.poNumber.$invalid }"
              v-model="$v.orderFollowUp.poNumber.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.customer')"
              for="order-follow-up-customer"
              >Customer</label
            >
            <input
              type="text"
              class="form-control"
              name="customer"
              id="order-follow-up-customer"
              data-cy="customer"
              :class="{ valid: !$v.orderFollowUp.customer.$invalid, invalid: $v.orderFollowUp.customer.$invalid }"
              v-model="$v.orderFollowUp.customer.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.supplier')"
              for="order-follow-up-supplier"
              >Supplier</label
            >
            <input
              type="text"
              class="form-control"
              name="supplier"
              id="order-follow-up-supplier"
              data-cy="supplier"
              :class="{ valid: !$v.orderFollowUp.supplier.$invalid, invalid: $v.orderFollowUp.supplier.$invalid }"
              v-model="$v.orderFollowUp.supplier.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.orderDate')"
              for="order-follow-up-orderDate"
              >Order Date</label
            >
            <input
              type="text"
              class="form-control"
              name="orderDate"
              id="order-follow-up-orderDate"
              data-cy="orderDate"
              :class="{ valid: !$v.orderFollowUp.orderDate.$invalid, invalid: $v.orderFollowUp.orderDate.$invalid }"
              v-model="$v.orderFollowUp.orderDate.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.cateGory')"
              for="order-follow-up-cateGory"
              >Cate Gory</label
            >
            <input
              type="text"
              class="form-control"
              name="cateGory"
              id="order-follow-up-cateGory"
              data-cy="cateGory"
              :class="{ valid: !$v.orderFollowUp.cateGory.$invalid, invalid: $v.orderFollowUp.cateGory.$invalid }"
              v-model="$v.orderFollowUp.cateGory.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.inspectionDate')"
              for="order-follow-up-inspectionDate"
              >Inspection Date</label
            >
            <input
              type="text"
              class="form-control"
              name="inspectionDate"
              id="order-follow-up-inspectionDate"
              data-cy="inspectionDate"
              :class="{ valid: !$v.orderFollowUp.inspectionDate.$invalid, invalid: $v.orderFollowUp.inspectionDate.$invalid }"
              v-model="$v.orderFollowUp.inspectionDate.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.requestEndOfProdDate')"
              for="order-follow-up-requestEndOfProdDate"
              >Request End Of Prod Date</label
            >
            <input
              type="text"
              class="form-control"
              name="requestEndOfProdDate"
              id="order-follow-up-requestEndOfProdDate"
              data-cy="requestEndOfProdDate"
              :class="{ valid: !$v.orderFollowUp.requestEndOfProdDate.$invalid, invalid: $v.orderFollowUp.requestEndOfProdDate.$invalid }"
              v-model="$v.orderFollowUp.requestEndOfProdDate.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.totalAmount')"
              for="order-follow-up-totalAmount"
              >Total Amount</label
            >
            <input
              type="text"
              class="form-control"
              name="totalAmount"
              id="order-follow-up-totalAmount"
              data-cy="totalAmount"
              :class="{ valid: !$v.orderFollowUp.totalAmount.$invalid, invalid: $v.orderFollowUp.totalAmount.$invalid }"
              v-model="$v.orderFollowUp.totalAmount.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.totalDiscount')"
              for="order-follow-up-totalDiscount"
              >Total Discount</label
            >
            <input
              type="text"
              class="form-control"
              name="totalDiscount"
              id="order-follow-up-totalDiscount"
              data-cy="totalDiscount"
              :class="{ valid: !$v.orderFollowUp.totalDiscount.$invalid, invalid: $v.orderFollowUp.totalDiscount.$invalid }"
              v-model="$v.orderFollowUp.totalDiscount.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.disCountRate')"
              for="order-follow-up-disCountRate"
              >Dis Count Rate</label
            >
            <input
              type="text"
              class="form-control"
              name="disCountRate"
              id="order-follow-up-disCountRate"
              data-cy="disCountRate"
              :class="{ valid: !$v.orderFollowUp.disCountRate.$invalid, invalid: $v.orderFollowUp.disCountRate.$invalid }"
              v-model="$v.orderFollowUp.disCountRate.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.regularCheck')"
              for="order-follow-up-regularCheck"
              >Regular Check</label
            >
            <input
              type="text"
              class="form-control"
              name="regularCheck"
              id="order-follow-up-regularCheck"
              data-cy="regularCheck"
              :class="{ valid: !$v.orderFollowUp.regularCheck.$invalid, invalid: $v.orderFollowUp.regularCheck.$invalid }"
              v-model="$v.orderFollowUp.regularCheck.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.etd')" for="order-follow-up-etd"
              >Etd</label
            >
            <input
              type="text"
              class="form-control"
              name="etd"
              id="order-follow-up-etd"
              data-cy="etd"
              :class="{ valid: !$v.orderFollowUp.etd.$invalid, invalid: $v.orderFollowUp.etd.$invalid }"
              v-model="$v.orderFollowUp.etd.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.atd')" for="order-follow-up-atd"
              >Atd</label
            >
            <input
              type="text"
              class="form-control"
              name="atd"
              id="order-follow-up-atd"
              data-cy="atd"
              :class="{ valid: !$v.orderFollowUp.atd.$invalid, invalid: $v.orderFollowUp.atd.$invalid }"
              v-model="$v.orderFollowUp.atd.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.eta')" for="order-follow-up-eta"
              >Eta</label
            >
            <input
              type="text"
              class="form-control"
              name="eta"
              id="order-follow-up-eta"
              data-cy="eta"
              :class="{ valid: !$v.orderFollowUp.eta.$invalid, invalid: $v.orderFollowUp.eta.$invalid }"
              v-model="$v.orderFollowUp.eta.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.updatedEta')"
              for="order-follow-up-updatedEta"
              >Updated Eta</label
            >
            <input
              type="text"
              class="form-control"
              name="updatedEta"
              id="order-follow-up-updatedEta"
              data-cy="updatedEta"
              :class="{ valid: !$v.orderFollowUp.updatedEta.$invalid, invalid: $v.orderFollowUp.updatedEta.$invalid }"
              v-model="$v.orderFollowUp.updatedEta.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.forwarder')"
              for="order-follow-up-forwarder"
              >Forwarder</label
            >
            <input
              type="text"
              class="form-control"
              name="forwarder"
              id="order-follow-up-forwarder"
              data-cy="forwarder"
              :class="{ valid: !$v.orderFollowUp.forwarder.$invalid, invalid: $v.orderFollowUp.forwarder.$invalid }"
              v-model="$v.orderFollowUp.forwarder.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.documentStatus')"
              for="order-follow-up-documentStatus"
              >Document Status</label
            >
            <input
              type="text"
              class="form-control"
              name="documentStatus"
              id="order-follow-up-documentStatus"
              data-cy="documentStatus"
              :class="{ valid: !$v.orderFollowUp.documentStatus.$invalid, invalid: $v.orderFollowUp.documentStatus.$invalid }"
              v-model="$v.orderFollowUp.documentStatus.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.customInstruction')"
              for="order-follow-up-customInstruction"
              >Custom Instruction</label
            >
            <input
              type="text"
              class="form-control"
              name="customInstruction"
              id="order-follow-up-customInstruction"
              data-cy="customInstruction"
              :class="{ valid: !$v.orderFollowUp.customInstruction.$invalid, invalid: $v.orderFollowUp.customInstruction.$invalid }"
              v-model="$v.orderFollowUp.customInstruction.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.customInspection')"
              for="order-follow-up-customInspection"
              >Custom Inspection</label
            >
            <input
              type="text"
              class="form-control"
              name="customInspection"
              id="order-follow-up-customInspection"
              data-cy="customInspection"
              :class="{ valid: !$v.orderFollowUp.customInspection.$invalid, invalid: $v.orderFollowUp.customInspection.$invalid }"
              v-model="$v.orderFollowUp.customInspection.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.depositPaymentDate')"
              for="order-follow-up-depositPaymentDate"
              >Deposit Payment Date</label
            >
            <input
              type="text"
              class="form-control"
              name="depositPaymentDate"
              id="order-follow-up-depositPaymentDate"
              data-cy="depositPaymentDate"
              :class="{ valid: !$v.orderFollowUp.depositPaymentDate.$invalid, invalid: $v.orderFollowUp.depositPaymentDate.$invalid }"
              v-model="$v.orderFollowUp.depositPaymentDate.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.balanceOfTotalPaymentDate')"
              for="order-follow-up-balanceOfTotalPaymentDate"
              >Balance Of Total Payment Date</label
            >
            <input
              type="text"
              class="form-control"
              name="balanceOfTotalPaymentDate"
              id="order-follow-up-balanceOfTotalPaymentDate"
              data-cy="balanceOfTotalPaymentDate"
              :class="{
                valid: !$v.orderFollowUp.balanceOfTotalPaymentDate.$invalid,
                invalid: $v.orderFollowUp.balanceOfTotalPaymentDate.$invalid,
              }"
              v-model="$v.orderFollowUp.balanceOfTotalPaymentDate.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.amountDepositPayment')"
              for="order-follow-up-amountDepositPayment"
              >Amount Deposit Payment</label
            >
            <input
              type="text"
              class="form-control"
              name="amountDepositPayment"
              id="order-follow-up-amountDepositPayment"
              data-cy="amountDepositPayment"
              :class="{ valid: !$v.orderFollowUp.amountDepositPayment.$invalid, invalid: $v.orderFollowUp.amountDepositPayment.$invalid }"
              v-model="$v.orderFollowUp.amountDepositPayment.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.amountPayment')"
              for="order-follow-up-amountPayment"
              >Amount Payment</label
            >
            <input
              type="text"
              class="form-control"
              name="amountPayment"
              id="order-follow-up-amountPayment"
              data-cy="amountPayment"
              :class="{ valid: !$v.orderFollowUp.amountPayment.$invalid, invalid: $v.orderFollowUp.amountPayment.$invalid }"
              v-model="$v.orderFollowUp.amountPayment.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.dcMember')"
              for="order-follow-up-dcMember"
              >Dc Member</label
            >
            <input
              type="text"
              class="form-control"
              name="dcMember"
              id="order-follow-up-dcMember"
              data-cy="dcMember"
              :class="{ valid: !$v.orderFollowUp.dcMember.$invalid, invalid: $v.orderFollowUp.dcMember.$invalid }"
              v-model="$v.orderFollowUp.dcMember.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.comment')"
              for="order-follow-up-comment"
              >Comment</label
            >
            <input
              type="text"
              class="form-control"
              name="comment"
              id="order-follow-up-comment"
              data-cy="comment"
              :class="{ valid: !$v.orderFollowUp.comment.$invalid, invalid: $v.orderFollowUp.comment.$invalid }"
              v-model="$v.orderFollowUp.comment.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.itemName')"
              for="order-follow-up-itemName"
              >Item Name</label
            >
            <input
              type="text"
              class="form-control"
              name="itemName"
              id="order-follow-up-itemName"
              data-cy="itemName"
              :class="{ valid: !$v.orderFollowUp.itemName.$invalid, invalid: $v.orderFollowUp.itemName.$invalid }"
              v-model="$v.orderFollowUp.itemName.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.boardId')"
              for="order-follow-up-boardId"
              >Board Id</label
            >
            <input
              type="text"
              class="form-control"
              name="boardId"
              id="order-follow-up-boardId"
              data-cy="boardId"
              :class="{ valid: !$v.orderFollowUp.boardId.$invalid, invalid: $v.orderFollowUp.boardId.$invalid }"
              v-model="$v.orderFollowUp.boardId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.kingdeeId')"
              for="order-follow-up-kingdeeId"
              >Kingdee Id</label
            >
            <input
              type="text"
              class="form-control"
              name="kingdeeId"
              id="order-follow-up-kingdeeId"
              data-cy="kingdeeId"
              :class="{ valid: !$v.orderFollowUp.kingdeeId.$invalid, invalid: $v.orderFollowUp.kingdeeId.$invalid }"
              v-model="$v.orderFollowUp.kingdeeId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.parentKingdeeId')"
              for="order-follow-up-parentKingdeeId"
              >Parent Kingdee Id</label
            >
            <input
              type="text"
              class="form-control"
              name="parentKingdeeId"
              id="order-follow-up-parentKingdeeId"
              data-cy="parentKingdeeId"
              :class="{ valid: !$v.orderFollowUp.parentKingdeeId.$invalid, invalid: $v.orderFollowUp.parentKingdeeId.$invalid }"
              v-model="$v.orderFollowUp.parentKingdeeId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.parentMondayId')"
              for="order-follow-up-parentMondayId"
              >Parent Monday Id</label
            >
            <input
              type="text"
              class="form-control"
              name="parentMondayId"
              id="order-follow-up-parentMondayId"
              data-cy="parentMondayId"
              :class="{ valid: !$v.orderFollowUp.parentMondayId.$invalid, invalid: $v.orderFollowUp.parentMondayId.$invalid }"
              v-model="$v.orderFollowUp.parentMondayId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.qty')" for="order-follow-up-qty"
              >Qty</label
            >
            <input
              type="text"
              class="form-control"
              name="qty"
              id="order-follow-up-qty"
              data-cy="qty"
              :class="{ valid: !$v.orderFollowUp.qty.$invalid, invalid: $v.orderFollowUp.qty.$invalid }"
              v-model="$v.orderFollowUp.qty.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.itemCode')"
              for="order-follow-up-itemCode"
              >Item Code</label
            >
            <input
              type="text"
              class="form-control"
              name="itemCode"
              id="order-follow-up-itemCode"
              data-cy="itemCode"
              :class="{ valid: !$v.orderFollowUp.itemCode.$invalid, invalid: $v.orderFollowUp.itemCode.$invalid }"
              v-model="$v.orderFollowUp.itemCode.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.amount')" for="order-follow-up-amount"
              >Amount</label
            >
            <input
              type="text"
              class="form-control"
              name="amount"
              id="order-follow-up-amount"
              data-cy="amount"
              :class="{ valid: !$v.orderFollowUp.amount.$invalid, invalid: $v.orderFollowUp.amount.$invalid }"
              v-model="$v.orderFollowUp.amount.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.discount')"
              for="order-follow-up-discount"
              >Discount</label
            >
            <input
              type="text"
              class="form-control"
              name="discount"
              id="order-follow-up-discount"
              data-cy="discount"
              :class="{ valid: !$v.orderFollowUp.discount.$invalid, invalid: $v.orderFollowUp.discount.$invalid }"
              v-model="$v.orderFollowUp.discount.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.unit')" for="order-follow-up-unit"
              >Unit</label
            >
            <input
              type="text"
              class="form-control"
              name="unit"
              id="order-follow-up-unit"
              data-cy="unit"
              :class="{ valid: !$v.orderFollowUp.unit.$invalid, invalid: $v.orderFollowUp.unit.$invalid }"
              v-model="$v.orderFollowUp.unit.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.contractEndOfProdDate')"
              for="order-follow-up-contractEndOfProdDate"
              >Contract End Of Prod Date</label
            >
            <input
              type="text"
              class="form-control"
              name="contractEndOfProdDate"
              id="order-follow-up-contractEndOfProdDate"
              data-cy="contractEndOfProdDate"
              :class="{ valid: !$v.orderFollowUp.contractEndOfProdDate.$invalid, invalid: $v.orderFollowUp.contractEndOfProdDate.$invalid }"
              v-model="$v.orderFollowUp.contractEndOfProdDate.$model"
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
            :disabled="$v.orderFollowUp.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./order-follow-up-update.component.ts"></script>
