<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterSampleApplicationApp.processLog.home.createOrEditLabel"
          data-cy="ProcessLogCreateUpdateHeading"
          v-text="$t('jhipsterSampleApplicationApp.processLog.home.createOrEditLabel')"
        >
          Create or edit a ProcessLog
        </h2>
        <div>
          <div class="form-group" v-if="processLog.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="processLog.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.processLog.type')" for="process-log-type"
              >Type</label
            >
            <input
              type="text"
              class="form-control"
              name="type"
              id="process-log-type"
              data-cy="type"
              :class="{ valid: !$v.processLog.type.$invalid, invalid: $v.processLog.type.$invalid }"
              v-model="$v.processLog.type.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.processLog.request')" for="process-log-request"
              >Request</label
            >
            <input
              type="text"
              class="form-control"
              name="request"
              id="process-log-request"
              data-cy="request"
              :class="{ valid: !$v.processLog.request.$invalid, invalid: $v.processLog.request.$invalid }"
              v-model="$v.processLog.request.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.processLog.response')" for="process-log-response"
              >Response</label
            >
            <input
              type="text"
              class="form-control"
              name="response"
              id="process-log-response"
              data-cy="response"
              :class="{ valid: !$v.processLog.response.$invalid, invalid: $v.processLog.response.$invalid }"
              v-model="$v.processLog.response.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.processLog.status')" for="process-log-status"
              >Status</label
            >
            <input
              type="text"
              class="form-control"
              name="status"
              id="process-log-status"
              data-cy="status"
              :class="{ valid: !$v.processLog.status.$invalid, invalid: $v.processLog.status.$invalid }"
              v-model="$v.processLog.status.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.processLog.reason')" for="process-log-reason"
              >Reason</label
            >
            <input
              type="text"
              class="form-control"
              name="reason"
              id="process-log-reason"
              data-cy="reason"
              :class="{ valid: !$v.processLog.reason.$invalid, invalid: $v.processLog.reason.$invalid }"
              v-model="$v.processLog.reason.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.processLog.processStartTime')"
              for="process-log-processStartTime"
              >Process Start Time</label
            >
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="process-log-processStartTime"
                  v-model="$v.processLog.processStartTime.$model"
                  name="processStartTime"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="process-log-processStartTime"
                data-cy="processStartTime"
                type="text"
                class="form-control"
                name="processStartTime"
                :class="{ valid: !$v.processLog.processStartTime.$invalid, invalid: $v.processLog.processStartTime.$invalid }"
                v-model="$v.processLog.processStartTime.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.processLog.processEndTime')"
              for="process-log-processEndTime"
              >Process End Time</label
            >
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="process-log-processEndTime"
                  v-model="$v.processLog.processEndTime.$model"
                  name="processEndTime"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="process-log-processEndTime"
                data-cy="processEndTime"
                type="text"
                class="form-control"
                name="processEndTime"
                :class="{ valid: !$v.processLog.processEndTime.$invalid, invalid: $v.processLog.processEndTime.$invalid }"
                v-model="$v.processLog.processEndTime.$model"
              />
            </b-input-group>
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
            :disabled="$v.processLog.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./process-log-update.component.ts"></script>
