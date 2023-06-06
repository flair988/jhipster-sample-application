<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="productTaxmonomy">
        <h2 class="jh-entity-heading" data-cy="productTaxmonomyDetailsHeading">
          <span v-text="$t('jhipsterSampleApplicationApp.productTaxmonomy.detail.title')">ProductTaxmonomy</span> {{ productTaxmonomy.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.productTaxmonomy.itemId')">Item Id</span>
          </dt>
          <dd>
            <span>{{ productTaxmonomy.itemId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.productTaxmonomy.kingdeeId')">Kingdee Id</span>
          </dt>
          <dd>
            <span>{{ productTaxmonomy.kingdeeId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.productTaxmonomy.itemName')">Item Name</span>
          </dt>
          <dd>
            <span>{{ productTaxmonomy.itemName }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.productTaxmonomy.groupName')">Group Name</span>
          </dt>
          <dd>
            <span>{{ productTaxmonomy.groupName }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.productTaxmonomy.parentGroupName')">Parent Group Name</span>
          </dt>
          <dd>
            <span>{{ productTaxmonomy.parentGroupName }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.productTaxmonomy.subGroupName')">Sub Group Name</span>
          </dt>
          <dd>
            <span>{{ productTaxmonomy.subGroupName }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.productTaxmonomy.description')">Description</span>
          </dt>
          <dd>
            <span>{{ productTaxmonomy.description }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.productTaxmonomy.boardId')">Board Id</span>
          </dt>
          <dd>
            <span>{{ productTaxmonomy.boardId }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="productTaxmonomy.id"
          :to="{ name: 'ProductTaxmonomyEdit', params: { productTaxmonomyId: productTaxmonomy.id } }"
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

<script lang="ts" src="./product-taxmonomy-details.component.ts"></script>
