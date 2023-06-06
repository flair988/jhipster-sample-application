<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterSampleApplicationApp.mondayUser.home.createOrEditLabel"
          data-cy="MondayUserCreateUpdateHeading"
          v-text="$t('jhipsterSampleApplicationApp.mondayUser.home.createOrEditLabel')"
        >
          Create or edit a MondayUser
        </h2>
        <div>
          <div class="form-group" v-if="mondayUser.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="mondayUser.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.mondayUser.mondayId')" for="monday-user-mondayId"
              >Monday Id</label
            >
            <input
              type="number"
              class="form-control"
              name="mondayId"
              id="monday-user-mondayId"
              data-cy="mondayId"
              :class="{ valid: !$v.mondayUser.mondayId.$invalid, invalid: $v.mondayUser.mondayId.$invalid }"
              v-model.number="$v.mondayUser.mondayId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.mondayUser.name')" for="monday-user-name"
              >Name</label
            >
            <input
              type="text"
              class="form-control"
              name="name"
              id="monday-user-name"
              data-cy="name"
              :class="{ valid: !$v.mondayUser.name.$invalid, invalid: $v.mondayUser.name.$invalid }"
              v-model="$v.mondayUser.name.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.mondayUser.email')" for="monday-user-email"
              >Email</label
            >
            <input
              type="text"
              class="form-control"
              name="email"
              id="monday-user-email"
              data-cy="email"
              :class="{ valid: !$v.mondayUser.email.$invalid, invalid: $v.mondayUser.email.$invalid }"
              v-model="$v.mondayUser.email.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.mondayUser.url')" for="monday-user-url">Url</label>
            <input
              type="text"
              class="form-control"
              name="url"
              id="monday-user-url"
              data-cy="url"
              :class="{ valid: !$v.mondayUser.url.$invalid, invalid: $v.mondayUser.url.$invalid }"
              v-model="$v.mondayUser.url.$model"
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
            :disabled="$v.mondayUser.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./monday-user-update.component.ts"></script>
