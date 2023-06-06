<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="productFinished">
        <h2 class="jh-entity-heading" data-cy="productFinishedDetailsHeading">
          <span v-text="$t('jhipsterSampleApplicationApp.productFinished.detail.title')">ProductFinished</span> {{ productFinished.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.productFinished.itemName')">Item Name</span>
          </dt>
          <dd>
            <span>{{ productFinished.itemName }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.productFinished.itemId')">Item Id</span>
          </dt>
          <dd>
            <span>{{ productFinished.itemId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.productFinished.boardId')">Board Id</span>
          </dt>
          <dd>
            <span>{{ productFinished.boardId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.productFinished.kingdeeId')">Kingdee Id</span>
          </dt>
          <dd>
            <span>{{ productFinished.kingdeeId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.productFinished.supplier')">Supplier</span>
          </dt>
          <dd>
            <span>{{ productFinished.supplier }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.productFinished.supplierEmail')">Supplier Email</span>
          </dt>
          <dd>
            <span>{{ productFinished.supplierEmail }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.productFinished.orderDate')">Order Date</span>
          </dt>
          <dd>
            <span>{{ productFinished.orderDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.productFinished.cateGory')">Cate Gory</span>
          </dt>
          <dd>
            <span>{{ productFinished.cateGory }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.productFinished.remark')">Remark</span>
          </dt>
          <dd>
            <span>{{ productFinished.remark }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.productFinished.materialReceiptDate')">Material Receipt Date</span>
          </dt>
          <dd>
            <span>{{ productFinished.materialReceiptDate }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="productFinished.id"
          :to="{ name: 'ProductFinishedEdit', params: { productFinishedId: productFinished.id } }"
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

<script lang="ts" src="./product-finished-details.component.ts"></script>
