<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterSampleApplicationApp.productFinished.home.createOrEditLabel"
          data-cy="ProductFinishedCreateUpdateHeading"
          v-text="$t('jhipsterSampleApplicationApp.productFinished.home.createOrEditLabel')"
        >
          Create or edit a ProductFinished
        </h2>
        <div>
          <div class="form-group" v-if="productFinished.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="productFinished.id" readonly />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.productFinished.itemName')"
              for="product-finished-itemName"
              >Item Name</label
            >
            <input
              type="text"
              class="form-control"
              name="itemName"
              id="product-finished-itemName"
              data-cy="itemName"
              :class="{ valid: !$v.productFinished.itemName.$invalid, invalid: $v.productFinished.itemName.$invalid }"
              v-model="$v.productFinished.itemName.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.productFinished.itemId')"
              for="product-finished-itemId"
              >Item Id</label
            >
            <input
              type="text"
              class="form-control"
              name="itemId"
              id="product-finished-itemId"
              data-cy="itemId"
              :class="{ valid: !$v.productFinished.itemId.$invalid, invalid: $v.productFinished.itemId.$invalid }"
              v-model="$v.productFinished.itemId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.productFinished.boardId')"
              for="product-finished-boardId"
              >Board Id</label
            >
            <input
              type="text"
              class="form-control"
              name="boardId"
              id="product-finished-boardId"
              data-cy="boardId"
              :class="{ valid: !$v.productFinished.boardId.$invalid, invalid: $v.productFinished.boardId.$invalid }"
              v-model="$v.productFinished.boardId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.productFinished.kingdeeId')"
              for="product-finished-kingdeeId"
              >Kingdee Id</label
            >
            <input
              type="text"
              class="form-control"
              name="kingdeeId"
              id="product-finished-kingdeeId"
              data-cy="kingdeeId"
              :class="{ valid: !$v.productFinished.kingdeeId.$invalid, invalid: $v.productFinished.kingdeeId.$invalid }"
              v-model="$v.productFinished.kingdeeId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.productFinished.supplier')"
              for="product-finished-supplier"
              >Supplier</label
            >
            <input
              type="text"
              class="form-control"
              name="supplier"
              id="product-finished-supplier"
              data-cy="supplier"
              :class="{ valid: !$v.productFinished.supplier.$invalid, invalid: $v.productFinished.supplier.$invalid }"
              v-model="$v.productFinished.supplier.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.productFinished.supplierEmail')"
              for="product-finished-supplierEmail"
              >Supplier Email</label
            >
            <input
              type="text"
              class="form-control"
              name="supplierEmail"
              id="product-finished-supplierEmail"
              data-cy="supplierEmail"
              :class="{ valid: !$v.productFinished.supplierEmail.$invalid, invalid: $v.productFinished.supplierEmail.$invalid }"
              v-model="$v.productFinished.supplierEmail.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.productFinished.orderDate')"
              for="product-finished-orderDate"
              >Order Date</label
            >
            <input
              type="text"
              class="form-control"
              name="orderDate"
              id="product-finished-orderDate"
              data-cy="orderDate"
              :class="{ valid: !$v.productFinished.orderDate.$invalid, invalid: $v.productFinished.orderDate.$invalid }"
              v-model="$v.productFinished.orderDate.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.productFinished.cateGory')"
              for="product-finished-cateGory"
              >Cate Gory</label
            >
            <input
              type="text"
              class="form-control"
              name="cateGory"
              id="product-finished-cateGory"
              data-cy="cateGory"
              :class="{ valid: !$v.productFinished.cateGory.$invalid, invalid: $v.productFinished.cateGory.$invalid }"
              v-model="$v.productFinished.cateGory.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.productFinished.remark')"
              for="product-finished-remark"
              >Remark</label
            >
            <input
              type="text"
              class="form-control"
              name="remark"
              id="product-finished-remark"
              data-cy="remark"
              :class="{ valid: !$v.productFinished.remark.$invalid, invalid: $v.productFinished.remark.$invalid }"
              v-model="$v.productFinished.remark.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.productFinished.materialReceiptDate')"
              for="product-finished-materialReceiptDate"
              >Material Receipt Date</label
            >
            <input
              type="text"
              class="form-control"
              name="materialReceiptDate"
              id="product-finished-materialReceiptDate"
              data-cy="materialReceiptDate"
              :class="{ valid: !$v.productFinished.materialReceiptDate.$invalid, invalid: $v.productFinished.materialReceiptDate.$invalid }"
              v-model="$v.productFinished.materialReceiptDate.$model"
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
            :disabled="$v.productFinished.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./product-finished-update.component.ts"></script>
