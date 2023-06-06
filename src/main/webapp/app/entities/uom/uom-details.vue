<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="uom">
        <h2 class="jh-entity-heading" data-cy="uomDetailsHeading">
          <span v-text="$t('jhipsterSampleApplicationApp.uom.detail.title')">Uom</span> {{ uom.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.uom.itemId')">Item Id</span>
          </dt>
          <dd>
            <span>{{ uom.itemId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.uom.uom')">Uom</span>
          </dt>
          <dd>
            <span>{{ uom.uom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.uom.uomGroup')">Uom Group</span>
          </dt>
          <dd>
            <span>{{ uom.uomGroup }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.uom.description')">Description</span>
          </dt>
          <dd>
            <span>{{ uom.description }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.uom.subItems')">Sub Items</span>
          </dt>
          <dd>
            <span>{{ uom.subItems }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.uom.parentItem')">Parent Item</span>
          </dt>
          <dd>
            <span>{{ uom.parentItem }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.uom.boardId')">Board Id</span>
          </dt>
          <dd>
            <span>{{ uom.boardId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.uom.kingdeeId')">Kingdee Id</span>
          </dt>
          <dd>
            <span>{{ uom.kingdeeId }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link v-if="uom.id" :to="{ name: 'UomEdit', params: { uomId: uom.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./uom-details.component.ts"></script>
