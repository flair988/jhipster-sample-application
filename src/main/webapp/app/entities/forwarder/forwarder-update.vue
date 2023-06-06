<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterSampleApplicationApp.forwarder.home.createOrEditLabel"
          data-cy="ForwarderCreateUpdateHeading"
          v-text="$t('jhipsterSampleApplicationApp.forwarder.home.createOrEditLabel')"
        >
          Create or edit a Forwarder
        </h2>
        <div>
          <div class="form-group" v-if="forwarder.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="forwarder.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.forwarder.itemName')" for="forwarder-itemName"
              >Item Name</label
            >
            <input
              type="text"
              class="form-control"
              name="itemName"
              id="forwarder-itemName"
              data-cy="itemName"
              :class="{ valid: !$v.forwarder.itemName.$invalid, invalid: $v.forwarder.itemName.$invalid }"
              v-model="$v.forwarder.itemName.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.forwarder.itemId')" for="forwarder-itemId"
              >Item Id</label
            >
            <input
              type="text"
              class="form-control"
              name="itemId"
              id="forwarder-itemId"
              data-cy="itemId"
              :class="{ valid: !$v.forwarder.itemId.$invalid, invalid: $v.forwarder.itemId.$invalid }"
              v-model="$v.forwarder.itemId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.forwarder.boardId')" for="forwarder-boardId"
              >Board Id</label
            >
            <input
              type="text"
              class="form-control"
              name="boardId"
              id="forwarder-boardId"
              data-cy="boardId"
              :class="{ valid: !$v.forwarder.boardId.$invalid, invalid: $v.forwarder.boardId.$invalid }"
              v-model="$v.forwarder.boardId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.forwarder.kingdeeId')" for="forwarder-kingdeeId"
              >Kingdee Id</label
            >
            <input
              type="text"
              class="form-control"
              name="kingdeeId"
              id="forwarder-kingdeeId"
              data-cy="kingdeeId"
              :class="{ valid: !$v.forwarder.kingdeeId.$invalid, invalid: $v.forwarder.kingdeeId.$invalid }"
              v-model="$v.forwarder.kingdeeId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.forwarder.contact')" for="forwarder-contact"
              >Contact</label
            >
            <input
              type="text"
              class="form-control"
              name="contact"
              id="forwarder-contact"
              data-cy="contact"
              :class="{ valid: !$v.forwarder.contact.$invalid, invalid: $v.forwarder.contact.$invalid }"
              v-model="$v.forwarder.contact.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.forwarder.email')" for="forwarder-email"
              >Email</label
            >
            <input
              type="text"
              class="form-control"
              name="email"
              id="forwarder-email"
              data-cy="email"
              :class="{ valid: !$v.forwarder.email.$invalid, invalid: $v.forwarder.email.$invalid }"
              v-model="$v.forwarder.email.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.forwarder.telephone')" for="forwarder-telephone"
              >Telephone</label
            >
            <input
              type="text"
              class="form-control"
              name="telephone"
              id="forwarder-telephone"
              data-cy="telephone"
              :class="{ valid: !$v.forwarder.telephone.$invalid, invalid: $v.forwarder.telephone.$invalid }"
              v-model="$v.forwarder.telephone.$model"
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
            :disabled="$v.forwarder.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./forwarder-update.component.ts"></script>
