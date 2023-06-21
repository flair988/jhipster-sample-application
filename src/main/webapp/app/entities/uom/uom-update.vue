<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterSampleApplicationApp.uom.home.createOrEditLabel"
          data-cy="UomCreateUpdateHeading"
          v-text="t$('jhipsterSampleApplicationApp.uom.home.createOrEditLabel')"
        ></h2>
        <div>
          <div class="form-group" v-if="uom.id">
            <label for="id" v-text="t$('global.field.id')"></label>
            <input type="text" class="form-control" id="id" name="id" v-model="uom.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('jhipsterSampleApplicationApp.uom.itemId')" for="uom-itemId"></label>
            <input
              type="text"
              class="form-control"
              name="itemId"
              id="uom-itemId"
              data-cy="itemId"
              :class="{ valid: !v$.itemId.$invalid, invalid: v$.itemId.$invalid }"
              v-model="v$.itemId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('jhipsterSampleApplicationApp.uom.uom')" for="uom-uom"></label>
            <input
              type="text"
              class="form-control"
              name="uom"
              id="uom-uom"
              data-cy="uom"
              :class="{ valid: !v$.uom.$invalid, invalid: v$.uom.$invalid }"
              v-model="v$.uom.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('jhipsterSampleApplicationApp.uom.uomGroup')" for="uom-uomGroup"></label>
            <input
              type="text"
              class="form-control"
              name="uomGroup"
              id="uom-uomGroup"
              data-cy="uomGroup"
              :class="{ valid: !v$.uomGroup.$invalid, invalid: v$.uomGroup.$invalid }"
              v-model="v$.uomGroup.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('jhipsterSampleApplicationApp.uom.description')" for="uom-description"></label>
            <input
              type="text"
              class="form-control"
              name="description"
              id="uom-description"
              data-cy="description"
              :class="{ valid: !v$.description.$invalid, invalid: v$.description.$invalid }"
              v-model="v$.description.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('jhipsterSampleApplicationApp.uom.subItems')" for="uom-subItems"></label>
            <input
              type="text"
              class="form-control"
              name="subItems"
              id="uom-subItems"
              data-cy="subItems"
              :class="{ valid: !v$.subItems.$invalid, invalid: v$.subItems.$invalid }"
              v-model="v$.subItems.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('jhipsterSampleApplicationApp.uom.parentItem')" for="uom-parentItem"></label>
            <input
              type="text"
              class="form-control"
              name="parentItem"
              id="uom-parentItem"
              data-cy="parentItem"
              :class="{ valid: !v$.parentItem.$invalid, invalid: v$.parentItem.$invalid }"
              v-model="v$.parentItem.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('jhipsterSampleApplicationApp.uom.boardId')" for="uom-boardId"></label>
            <input
              type="text"
              class="form-control"
              name="boardId"
              id="uom-boardId"
              data-cy="boardId"
              :class="{ valid: !v$.boardId.$invalid, invalid: v$.boardId.$invalid }"
              v-model="v$.boardId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('jhipsterSampleApplicationApp.uom.kingdeeId')" for="uom-kingdeeId"></label>
            <input
              type="text"
              class="form-control"
              name="kingdeeId"
              id="uom-kingdeeId"
              data-cy="kingdeeId"
              :class="{ valid: !v$.kingdeeId.$invalid, invalid: v$.kingdeeId.$invalid }"
              v-model="v$.kingdeeId.$model"
            />
          </div>
        </div>
        <div>
          <button type="button" id="cancel-save" data-cy="entityCreateCancelButton" class="btn btn-secondary" v-on:click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.cancel')"></span>
          </button>
          <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="v$.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.save')"></span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./uom-update.component.ts"></script>
