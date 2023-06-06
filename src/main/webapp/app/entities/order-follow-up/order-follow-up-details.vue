<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="orderFollowUp">
        <h2 class="jh-entity-heading" data-cy="orderFollowUpDetailsHeading">
          <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.detail.title')">OrderFollowUp</span> {{ orderFollowUp.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.itemId')">Item Id</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.itemId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.poNumber')">Po Number</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.poNumber }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.customer')">Customer</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.customer }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.supplier')">Supplier</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.supplier }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.orderDate')">Order Date</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.orderDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.cateGory')">Cate Gory</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.cateGory }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.inspectionDate')">Inspection Date</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.inspectionDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.requestEndOfProdDate')">Request End Of Prod Date</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.requestEndOfProdDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.totalAmount')">Total Amount</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.totalAmount }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.totalDiscount')">Total Discount</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.totalDiscount }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.disCountRate')">Dis Count Rate</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.disCountRate }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.regularCheck')">Regular Check</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.regularCheck }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.etd')">Etd</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.etd }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.atd')">Atd</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.atd }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.eta')">Eta</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.eta }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.updatedEta')">Updated Eta</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.updatedEta }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.forwarder')">Forwarder</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.forwarder }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.documentStatus')">Document Status</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.documentStatus }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.customInstruction')">Custom Instruction</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.customInstruction }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.customInspection')">Custom Inspection</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.customInspection }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.depositPaymentDate')">Deposit Payment Date</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.depositPaymentDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.balanceOfTotalPaymentDate')">Balance Of Total Payment Date</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.balanceOfTotalPaymentDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.amountDepositPayment')">Amount Deposit Payment</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.amountDepositPayment }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.amountPayment')">Amount Payment</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.amountPayment }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.dcMember')">Dc Member</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.dcMember }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.comment')">Comment</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.comment }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.itemName')">Item Name</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.itemName }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.boardId')">Board Id</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.boardId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.kingdeeId')">Kingdee Id</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.kingdeeId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.parentKingdeeId')">Parent Kingdee Id</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.parentKingdeeId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.parentMondayId')">Parent Monday Id</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.parentMondayId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.qty')">Qty</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.qty }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.itemCode')">Item Code</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.itemCode }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.amount')">Amount</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.amount }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.discount')">Discount</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.discount }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.unit')">Unit</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.unit }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.orderFollowUp.contractEndOfProdDate')">Contract End Of Prod Date</span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.contractEndOfProdDate }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="orderFollowUp.id"
          :to="{ name: 'OrderFollowUpEdit', params: { orderFollowUpId: orderFollowUp.id } }"
          custom
          v-slot="{ navigate }"
        >
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./order-follow-up-details.component.ts"></script>
