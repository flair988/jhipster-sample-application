<template>
  <div>
    <h2 id="page-heading" data-cy="ProcessLogHeading">
      <span v-text="$t('jhipsterSampleApplicationApp.processLog.home.title')" id="process-log-heading">Process Logs</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('jhipsterSampleApplicationApp.processLog.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'ProcessLogCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-process-log"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('jhipsterSampleApplicationApp.processLog.home.createLabel')"> Create a new Process Log </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && processLogs && processLogs.length === 0">
      <span v-text="$t('jhipsterSampleApplicationApp.processLog.home.notFound')">No processLogs found</span>
    </div>
    <div class="table-responsive" v-if="processLogs && processLogs.length > 0">
      <table class="table table-striped" aria-describedby="processLogs">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.processLog.type')">Type</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.processLog.request')">Request</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.processLog.response')">Response</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.processLog.status')">Status</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.processLog.reason')">Reason</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.processLog.processStartTime')">Process Start Time</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.processLog.processEndTime')">Process End Time</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="processLog in processLogs" :key="processLog.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'ProcessLogView', params: { processLogId: processLog.id } }">{{ processLog.id }}</router-link>
            </td>
            <td>{{ processLog.type }}</td>
            <td>{{ processLog.request }}</td>
            <td>{{ processLog.response }}</td>
            <td>{{ processLog.status }}</td>
            <td>{{ processLog.reason }}</td>
            <td>{{ processLog.processStartTime }}</td>
            <td>{{ processLog.processEndTime }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'ProcessLogView', params: { processLogId: processLog.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'ProcessLogEdit', params: { processLogId: processLog.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(processLog)"
                  variant="danger"
                  class="btn btn-sm"
                  data-cy="entityDeleteButton"
                  v-b-modal.removeEntity
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.delete')">Delete</span>
                </b-button>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span
          id="jhipsterSampleApplicationApp.processLog.delete.question"
          data-cy="processLogDeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-processLog-heading" v-text="$t('jhipsterSampleApplicationApp.processLog.delete.question', { id: removeId })">
          Are you sure you want to delete this Process Log?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-processLog"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeProcessLog()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./process-log.component.ts"></script>
