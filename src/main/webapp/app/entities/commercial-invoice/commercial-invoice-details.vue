<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="commercialInvoice">
        <h2 class="jh-entity-heading" data-cy="commercialInvoiceDetailsHeading">
          <span v-text="t$('jhipsterSampleApplicationApp.commercialInvoice.detail.title')"></span> {{ commercialInvoice.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.commercialInvoice.itemName')"></span>
          </dt>
          <dd>
            <span>{{ commercialInvoice.itemName }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.commercialInvoice.kingdeeId')"></span>
          </dt>
          <dd>
            <span>{{ commercialInvoice.kingdeeId }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.commercialInvoice.date')"></span>
          </dt>
          <dd>
            <span>{{ commercialInvoice.date }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.commercialInvoice.client')"></span>
          </dt>
          <dd>
            <span>{{ commercialInvoice.client }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.commercialInvoice.cateGory')"></span>
          </dt>
          <dd>
            <span>{{ commercialInvoice.cateGory }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.commercialInvoice.totalPrice')"></span>
          </dt>
          <dd>
            <span>{{ commercialInvoice.totalPrice }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.commercialInvoice.currency')"></span>
          </dt>
          <dd>
            <span>{{ commercialInvoice.currency }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.commercialInvoice.remarks')"></span>
          </dt>
          <dd>
            <span>{{ commercialInvoice.remarks }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.commercialInvoice.clientId')"></span>
          </dt>
          <dd>
            <span>{{ commercialInvoice.clientId }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.commercialInvoice.docStatus')"></span>
          </dt>
          <dd>
            <span>{{ commercialInvoice.docStatus }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.back')"></span>
        </button>
        <router-link
          v-if="commercialInvoice.id"
          :to="{ name: 'CommercialInvoiceEdit', params: { commercialInvoiceId: commercialInvoice.id } }"
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

<script lang="ts" src="./commercial-invoice-details.component.ts"></script>
