<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterSampleApplicationApp.group.home.createOrEditLabel"
          data-cy="GroupCreateUpdateHeading"
          v-text="$t('jhipsterSampleApplicationApp.group.home.createOrEditLabel')"
        >
          Create or edit a Group
        </h2>
        <div>
          <div class="form-group" v-if="group.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="group.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.group.groupId')" for="group-groupId">Group Id</label>
            <input
              type="number"
              class="form-control"
              name="groupId"
              id="group-groupId"
              data-cy="groupId"
              :class="{ valid: !$v.group.groupId.$invalid, invalid: $v.group.groupId.$invalid }"
              v-model.number="$v.group.groupId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.group.groupNumber')" for="group-groupNumber"
              >Group Number</label
            >
            <input
              type="text"
              class="form-control"
              name="groupNumber"
              id="group-groupNumber"
              data-cy="groupNumber"
              :class="{ valid: !$v.group.groupNumber.$invalid, invalid: $v.group.groupNumber.$invalid }"
              v-model="$v.group.groupNumber.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.group.parentId')" for="group-parentId"
              >Parent Id</label
            >
            <input
              type="number"
              class="form-control"
              name="parentId"
              id="group-parentId"
              data-cy="parentId"
              :class="{ valid: !$v.group.parentId.$invalid, invalid: $v.group.parentId.$invalid }"
              v-model.number="$v.group.parentId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.group.groupName')" for="group-groupName"
              >Group Name</label
            >
            <input
              type="text"
              class="form-control"
              name="groupName"
              id="group-groupName"
              data-cy="groupName"
              :class="{ valid: !$v.group.groupName.$invalid, invalid: $v.group.groupName.$invalid }"
              v-model="$v.group.groupName.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.group.description')" for="group-description"
              >Description</label
            >
            <input
              type="text"
              class="form-control"
              name="description"
              id="group-description"
              data-cy="description"
              :class="{ valid: !$v.group.description.$invalid, invalid: $v.group.description.$invalid }"
              v-model="$v.group.description.$model"
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
            :disabled="$v.group.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./group-update.component.ts"></script>
