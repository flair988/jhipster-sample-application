<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="commercialInvoice">
        <h2 class="jh-entity-heading" data-cy="commercialInvoiceDetailsHeading">
          <span v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.detail.title')">CommercialInvoice</span>
          {{ commercialInvoice.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.itemName')">Item Name</span>
          </dt>
          <dd>
            <span>{{ commercialInvoice.itemName }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.itemId')">Item Id</span>
          </dt>
          <dd>
            <span>{{ commercialInvoice.itemId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.boardId')">Board Id</span>
          </dt>
          <dd>
            <span>{{ commercialInvoice.boardId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.kingdeeId')">Kingdee Id</span>
          </dt>
          <dd>
            <span>{{ commercialInvoice.kingdeeId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.date')">Date</span>
          </dt>
          <dd>
            <span>{{ commercialInvoice.date }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.client')">Client</span>
          </dt>
          <dd>
            <span>{{ commercialInvoice.client }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.cateGory')">Cate Gory</span>
          </dt>
          <dd>
            <span>{{ commercialInvoice.cateGory }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.totalPrice')">Total Price</span>
          </dt>
          <dd>
            <span>{{ commercialInvoice.totalPrice }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.currency')">Currency</span>
          </dt>
          <dd>
            <span>{{ commercialInvoice.currency }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.commercialInvoice.remarks')">Remarks</span>
          </dt>
          <dd>
            <span>{{ commercialInvoice.remarks }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="commercialInvoice.id"
          :to="{ name: 'CommercialInvoiceEdit', params: { commercialInvoiceId: commercialInvoice.id } }"
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

<script lang="ts" src="./commercial-invoice-details.component.ts"></script>
