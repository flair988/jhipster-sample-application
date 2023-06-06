<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterSampleApplicationApp.uom.home.createOrEditLabel"
          data-cy="UomCreateUpdateHeading"
          v-text="$t('jhipsterSampleApplicationApp.uom.home.createOrEditLabel')"
        >
          Create or edit a Uom
        </h2>
        <div>
          <div class="form-group" v-if="uom.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="uom.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.uom.itemId')" for="uom-itemId">Item Id</label>
            <input
              type="text"
              class="form-control"
              name="itemId"
              id="uom-itemId"
              data-cy="itemId"
              :class="{ valid: !$v.uom.itemId.$invalid, invalid: $v.uom.itemId.$invalid }"
              v-model="$v.uom.itemId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.uom.uom')" for="uom-uom">Uom</label>
            <input
              type="text"
              class="form-control"
              name="uom"
              id="uom-uom"
              data-cy="uom"
              :class="{ valid: !$v.uom.uom.$invalid, invalid: $v.uom.uom.$invalid }"
              v-model="$v.uom.uom.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.uom.uomGroup')" for="uom-uomGroup">Uom Group</label>
            <input
              type="text"
              class="form-control"
              name="uomGroup"
              id="uom-uomGroup"
              data-cy="uomGroup"
              :class="{ valid: !$v.uom.uomGroup.$invalid, invalid: $v.uom.uomGroup.$invalid }"
              v-model="$v.uom.uomGroup.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.uom.description')" for="uom-description"
              >Description</label
            >
            <input
              type="text"
              class="form-control"
              name="description"
              id="uom-description"
              data-cy="description"
              :class="{ valid: !$v.uom.description.$invalid, invalid: $v.uom.description.$invalid }"
              v-model="$v.uom.description.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.uom.subItems')" for="uom-subItems">Sub Items</label>
            <input
              type="text"
              class="form-control"
              name="subItems"
              id="uom-subItems"
              data-cy="subItems"
              :class="{ valid: !$v.uom.subItems.$invalid, invalid: $v.uom.subItems.$invalid }"
              v-model="$v.uom.subItems.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.uom.parentItem')" for="uom-parentItem"
              >Parent Item</label
            >
            <input
              type="text"
              class="form-control"
              name="parentItem"
              id="uom-parentItem"
              data-cy="parentItem"
              :class="{ valid: !$v.uom.parentItem.$invalid, invalid: $v.uom.parentItem.$invalid }"
              v-model="$v.uom.parentItem.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.uom.boardId')" for="uom-boardId">Board Id</label>
            <input
              type="text"
              class="form-control"
              name="boardId"
              id="uom-boardId"
              data-cy="boardId"
              :class="{ valid: !$v.uom.boardId.$invalid, invalid: $v.uom.boardId.$invalid }"
              v-model="$v.uom.boardId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.uom.kingdeeId')" for="uom-kingdeeId"
              >Kingdee Id</label
            >
            <input
              type="text"
              class="form-control"
              name="kingdeeId"
              id="uom-kingdeeId"
              data-cy="kingdeeId"
              :class="{ valid: !$v.uom.kingdeeId.$invalid, invalid: $v.uom.kingdeeId.$invalid }"
              v-model="$v.uom.kingdeeId.$model"
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
            :disabled="$v.uom.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./uom-update.component.ts"></script>
