<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterSampleApplicationApp.productTaxmonomy.home.createOrEditLabel"
          data-cy="ProductTaxmonomyCreateUpdateHeading"
          v-text="$t('jhipsterSampleApplicationApp.productTaxmonomy.home.createOrEditLabel')"
        >
          Create or edit a ProductTaxmonomy
        </h2>
        <div>
          <div class="form-group" v-if="productTaxmonomy.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="productTaxmonomy.id" readonly />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.productTaxmonomy.itemId')"
              for="product-taxmonomy-itemId"
              >Item Id</label
            >
            <input
              type="text"
              class="form-control"
              name="itemId"
              id="product-taxmonomy-itemId"
              data-cy="itemId"
              :class="{ valid: !$v.productTaxmonomy.itemId.$invalid, invalid: $v.productTaxmonomy.itemId.$invalid }"
              v-model="$v.productTaxmonomy.itemId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.productTaxmonomy.kingdeeId')"
              for="product-taxmonomy-kingdeeId"
              >Kingdee Id</label
            >
            <input
              type="text"
              class="form-control"
              name="kingdeeId"
              id="product-taxmonomy-kingdeeId"
              data-cy="kingdeeId"
              :class="{ valid: !$v.productTaxmonomy.kingdeeId.$invalid, invalid: $v.productTaxmonomy.kingdeeId.$invalid }"
              v-model="$v.productTaxmonomy.kingdeeId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.productTaxmonomy.itemName')"
              for="product-taxmonomy-itemName"
              >Item Name</label
            >
            <input
              type="text"
              class="form-control"
              name="itemName"
              id="product-taxmonomy-itemName"
              data-cy="itemName"
              :class="{ valid: !$v.productTaxmonomy.itemName.$invalid, invalid: $v.productTaxmonomy.itemName.$invalid }"
              v-model="$v.productTaxmonomy.itemName.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.productTaxmonomy.groupName')"
              for="product-taxmonomy-groupName"
              >Group Name</label
            >
            <input
              type="text"
              class="form-control"
              name="groupName"
              id="product-taxmonomy-groupName"
              data-cy="groupName"
              :class="{ valid: !$v.productTaxmonomy.groupName.$invalid, invalid: $v.productTaxmonomy.groupName.$invalid }"
              v-model="$v.productTaxmonomy.groupName.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.productTaxmonomy.parentGroupName')"
              for="product-taxmonomy-parentGroupName"
              >Parent Group Name</label
            >
            <input
              type="text"
              class="form-control"
              name="parentGroupName"
              id="product-taxmonomy-parentGroupName"
              data-cy="parentGroupName"
              :class="{ valid: !$v.productTaxmonomy.parentGroupName.$invalid, invalid: $v.productTaxmonomy.parentGroupName.$invalid }"
              v-model="$v.productTaxmonomy.parentGroupName.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.productTaxmonomy.subGroupName')"
              for="product-taxmonomy-subGroupName"
              >Sub Group Name</label
            >
            <input
              type="text"
              class="form-control"
              name="subGroupName"
              id="product-taxmonomy-subGroupName"
              data-cy="subGroupName"
              :class="{ valid: !$v.productTaxmonomy.subGroupName.$invalid, invalid: $v.productTaxmonomy.subGroupName.$invalid }"
              v-model="$v.productTaxmonomy.subGroupName.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.productTaxmonomy.description')"
              for="product-taxmonomy-description"
              >Description</label
            >
            <input
              type="text"
              class="form-control"
              name="description"
              id="product-taxmonomy-description"
              data-cy="description"
              :class="{ valid: !$v.productTaxmonomy.description.$invalid, invalid: $v.productTaxmonomy.description.$invalid }"
              v-model="$v.productTaxmonomy.description.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.productTaxmonomy.boardId')"
              for="product-taxmonomy-boardId"
              >Board Id</label
            >
            <input
              type="text"
              class="form-control"
              name="boardId"
              id="product-taxmonomy-boardId"
              data-cy="boardId"
              :class="{ valid: !$v.productTaxmonomy.boardId.$invalid, invalid: $v.productTaxmonomy.boardId.$invalid }"
              v-model="$v.productTaxmonomy.boardId.$model"
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
            :disabled="$v.productTaxmonomy.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./product-taxmonomy-update.component.ts"></script>
