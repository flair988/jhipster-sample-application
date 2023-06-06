<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="supplier">
        <h2 class="jh-entity-heading" data-cy="supplierDetailsHeading">
          <span v-text="$t('jhipsterSampleApplicationApp.supplier.detail.title')">Supplier</span> {{ supplier.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.supplier.client')">Client</span>
          </dt>
          <dd>
            <span>{{ supplier.client }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.supplier.parentItem')">Parent Item</span>
          </dt>
          <dd>
            <span>{{ supplier.parentItem }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.supplier.itemId')">Item Id</span>
          </dt>
          <dd>
            <span>{{ supplier.itemId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.supplier.boardId')">Board Id</span>
          </dt>
          <dd>
            <span>{{ supplier.boardId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.supplier.person')">Person</span>
          </dt>
          <dd>
            <span>{{ supplier.person }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.supplier.category')">Category</span>
          </dt>
          <dd>
            <span>{{ supplier.category }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.supplier.subCategory')">Sub Category</span>
          </dt>
          <dd>
            <span>{{ supplier.subCategory }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.supplier.supplierStatus')">Supplier Status</span>
          </dt>
          <dd>
            <span>{{ supplier.supplierStatus }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.supplier.capStatus')">Cap Status</span>
          </dt>
          <dd>
            <span>{{ supplier.capStatus }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.supplier.qualificationScore')">Qualification Score</span>
          </dt>
          <dd>
            <span>{{ supplier.qualificationScore }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.supplier.bopeScore')">Bope Score</span>
          </dt>
          <dd>
            <span>{{ supplier.bopeScore }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.supplier.internalSupplierId')">Internal Supplier Id</span>
          </dt>
          <dd>
            <span>{{ supplier.internalSupplierId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.supplier.contact')">Contact</span>
          </dt>
          <dd>
            <span>{{ supplier.contact }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.supplier.contactPhoneNumber')">Contact Phone Number</span>
          </dt>
          <dd>
            <span>{{ supplier.contactPhoneNumber }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.supplier.contactEmailAddress')">Contact Email Address</span>
          </dt>
          <dd>
            <span>{{ supplier.contactEmailAddress }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.supplier.country')">Country</span>
          </dt>
          <dd>
            <span>{{ supplier.country }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.supplier.operationSite')">Operation Site</span>
          </dt>
          <dd>
            <span>{{ supplier.operationSite }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.supplier.address')">Address</span>
          </dt>
          <dd>
            <span>{{ supplier.address }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.supplier.website')">Website</span>
          </dt>
          <dd>
            <span>{{ supplier.website }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.supplier.productTaxonomy')">Product Taxonomy</span>
          </dt>
          <dd>
            <span>{{ supplier.productTaxonomy }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.supplier.relationStartingYear')">Relation Starting Year</span>
          </dt>
          <dd>
            <span>{{ supplier.relationStartingYear }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.supplier.businessLicense')">Business License</span>
          </dt>
          <dd>
            <span>{{ supplier.businessLicense }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.supplier.rexOriginStatus')">Rex Origin Status</span>
          </dt>
          <dd>
            <span>{{ supplier.rexOriginStatus }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.supplier.createDate')">Create Date</span>
          </dt>
          <dd>
            <span>{{ supplier.createDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.supplier.updateDate')">Update Date</span>
          </dt>
          <dd>
            <span>{{ supplier.updateDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.supplier.item')">Item</span>
          </dt>
          <dd>
            <span>{{ supplier.item }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.supplier.mirror')">Mirror</span>
          </dt>
          <dd>
            <span>{{ supplier.mirror }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.supplier.subItems')">Sub Items</span>
          </dt>
          <dd>
            <span>{{ supplier.subItems }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.supplier.owner')">Owner</span>
          </dt>
          <dd>
            <span>{{ supplier.owner }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.supplier.status')">Status</span>
          </dt>
          <dd>
            <span>{{ supplier.status }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.supplier.date')">Date</span>
          </dt>
          <dd>
            <span>{{ supplier.date }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.supplier.formula')">Formula</span>
          </dt>
          <dd>
            <span>{{ supplier.formula }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.supplier.kingdeeId')">Kingdee Id</span>
          </dt>
          <dd>
            <span>{{ supplier.kingdeeId }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link v-if="supplier.id" :to="{ name: 'SupplierEdit', params: { supplierId: supplier.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./supplier-details.component.ts"></script>
