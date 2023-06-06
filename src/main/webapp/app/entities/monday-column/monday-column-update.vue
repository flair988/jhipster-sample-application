<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterSampleApplicationApp.mondayColumn.home.createOrEditLabel"
          data-cy="MondayColumnCreateUpdateHeading"
          v-text="$t('jhipsterSampleApplicationApp.mondayColumn.home.createOrEditLabel')"
        >
          Create or edit a MondayColumn
        </h2>
        <div>
          <div class="form-group" v-if="mondayColumn.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="mondayColumn.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.mondayColumn.boardId')" for="monday-column-boardId"
              >Board Id</label
            >
            <input
              type="text"
              class="form-control"
              name="boardId"
              id="monday-column-boardId"
              data-cy="boardId"
              :class="{ valid: !$v.mondayColumn.boardId.$invalid, invalid: $v.mondayColumn.boardId.$invalid }"
              v-model="$v.mondayColumn.boardId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.mondayColumn.columnId')" for="monday-column-columnId"
              >Column Id</label
            >
            <input
              type="text"
              class="form-control"
              name="columnId"
              id="monday-column-columnId"
              data-cy="columnId"
              :class="{ valid: !$v.mondayColumn.columnId.$invalid, invalid: $v.mondayColumn.columnId.$invalid }"
              v-model="$v.mondayColumn.columnId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.mondayColumn.title')" for="monday-column-title"
              >Title</label
            >
            <input
              type="text"
              class="form-control"
              name="title"
              id="monday-column-title"
              data-cy="title"
              :class="{ valid: !$v.mondayColumn.title.$invalid, invalid: $v.mondayColumn.title.$invalid }"
              v-model="$v.mondayColumn.title.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.mondayColumn.type')" for="monday-column-type"
              >Type</label
            >
            <input
              type="text"
              class="form-control"
              name="type"
              id="monday-column-type"
              data-cy="type"
              :class="{ valid: !$v.mondayColumn.type.$invalid, invalid: $v.mondayColumn.type.$invalid }"
              v-model="$v.mondayColumn.type.$model"
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
            :disabled="$v.mondayColumn.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./monday-column-update.component.ts"></script>
