<template>
  <div>
    <h2 id="page-heading" data-cy="MondayColumnHeading">
      <span v-text="$t('jhipsterSampleApplicationApp.mondayColumn.home.title')" id="monday-column-heading">Monday Columns</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('jhipsterSampleApplicationApp.mondayColumn.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'MondayColumnCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-monday-column"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('jhipsterSampleApplicationApp.mondayColumn.home.createLabel')"> Create a new Monday Column </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && mondayColumns && mondayColumns.length === 0">
      <span v-text="$t('jhipsterSampleApplicationApp.mondayColumn.home.notFound')">No mondayColumns found</span>
    </div>
    <div class="table-responsive" v-if="mondayColumns && mondayColumns.length > 0">
      <table class="table table-striped" aria-describedby="mondayColumns">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.mondayColumn.boardId')">Board Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.mondayColumn.columnId')">Column Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.mondayColumn.title')">Title</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.mondayColumn.type')">Type</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="mondayColumn in mondayColumns" :key="mondayColumn.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'MondayColumnView', params: { mondayColumnId: mondayColumn.id } }">{{
                mondayColumn.id
              }}</router-link>
            </td>
            <td>{{ mondayColumn.boardId }}</td>
            <td>{{ mondayColumn.columnId }}</td>
            <td>{{ mondayColumn.title }}</td>
            <td>{{ mondayColumn.type }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'MondayColumnView', params: { mondayColumnId: mondayColumn.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'MondayColumnEdit', params: { mondayColumnId: mondayColumn.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(mondayColumn)"
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
          id="jhipsterSampleApplicationApp.mondayColumn.delete.question"
          data-cy="mondayColumnDeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-mondayColumn-heading" v-text="$t('jhipsterSampleApplicationApp.mondayColumn.delete.question', { id: removeId })">
          Are you sure you want to delete this Monday Column?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-mondayColumn"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeMondayColumn()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./monday-column.component.ts"></script>
