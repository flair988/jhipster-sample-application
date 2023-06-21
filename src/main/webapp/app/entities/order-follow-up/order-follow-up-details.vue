<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="orderFollowUp">
        <h2 class="jh-entity-heading" data-cy="orderFollowUpDetailsHeading">
          <span v-text="t$('jhipsterSampleApplicationApp.orderFollowUp.detail.title')"></span> {{ orderFollowUp.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.orderFollowUp.poNumber')"></span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.poNumber }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.orderFollowUp.supplier')"></span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.supplier }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.orderFollowUp.orderDate')"></span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.orderDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.orderFollowUp.cateGory')"></span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.cateGory }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.orderFollowUp.inspectionDate')"></span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.inspectionDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.orderFollowUp.requestEndOfProdDate')"></span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.requestEndOfProdDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.orderFollowUp.totalAmount')"></span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.totalAmount }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.orderFollowUp.totalDiscount')"></span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.totalDiscount }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.orderFollowUp.disCountRate')"></span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.disCountRate }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.orderFollowUp.regularCheck')"></span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.regularCheck }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.orderFollowUp.etd')"></span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.etd }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.orderFollowUp.atd')"></span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.atd }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.orderFollowUp.eta')"></span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.eta }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.orderFollowUp.updatedEta')"></span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.updatedEta }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.orderFollowUp.documentStatus')"></span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.documentStatus }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.orderFollowUp.customInstruction')"></span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.customInstruction }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.orderFollowUp.customInspection')"></span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.customInspection }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.orderFollowUp.depositPaymentDate')"></span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.depositPaymentDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.orderFollowUp.balanceOfTotalPaymentDate')"></span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.balanceOfTotalPaymentDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.orderFollowUp.amountDepositPayment')"></span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.amountDepositPayment }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.orderFollowUp.amountPayment')"></span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.amountPayment }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.orderFollowUp.dcMember')"></span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.dcMember }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.orderFollowUp.comment')"></span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.comment }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.orderFollowUp.itemName')"></span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.itemName }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.orderFollowUp.kingdeeId')"></span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.kingdeeId }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.orderFollowUp.parentKingdeeId')"></span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.parentKingdeeId }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.orderFollowUp.qty')"></span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.qty }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.orderFollowUp.itemCode')"></span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.itemCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.orderFollowUp.contractEndOfProdDate')"></span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.contractEndOfProdDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.orderFollowUp.supplierId')"></span>
          </dt>
          <dd>
            <span>{{ orderFollowUp.supplierId }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.back')"></span>
        </button>
        <router-link
          v-if="orderFollowUp.id"
          :to="{ name: 'OrderFollowUpEdit', params: { orderFollowUpId: orderFollowUp.id } }"
          custom
          v-slot="{ navigate }"
        >
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.edit')"></span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./order-follow-up-details.component.ts"></script>
