<template>
  <div>
    <h2 id="page-heading" data-cy="MondayUserHeading">
      <span v-text="$t('jhipsterSampleApplicationApp.mondayUser.home.title')" id="monday-user-heading">Monday Users</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('jhipsterSampleApplicationApp.mondayUser.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'MondayUserCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-monday-user"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('jhipsterSampleApplicationApp.mondayUser.home.createLabel')"> Create a new Monday User </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && mondayUsers && mondayUsers.length === 0">
      <span v-text="$t('jhipsterSampleApplicationApp.mondayUser.home.notFound')">No mondayUsers found</span>
    </div>
    <div class="table-responsive" v-if="mondayUsers && mondayUsers.length > 0">
      <table class="table table-striped" aria-describedby="mondayUsers">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.mondayUser.mondayId')">Monday Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.mondayUser.name')">Name</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.mondayUser.email')">Email</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.mondayUser.url')">Url</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="mondayUser in mondayUsers" :key="mondayUser.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'MondayUserView', params: { mondayUserId: mondayUser.id } }">{{ mondayUser.id }}</router-link>
            </td>
            <td>{{ mondayUser.mondayId }}</td>
            <td>{{ mondayUser.name }}</td>
            <td>{{ mondayUser.email }}</td>
            <td>{{ mondayUser.url }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'MondayUserView', params: { mondayUserId: mondayUser.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'MondayUserEdit', params: { mondayUserId: mondayUser.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(mondayUser)"
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
          id="jhipsterSampleApplicationApp.mondayUser.delete.question"
          data-cy="mondayUserDeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-mondayUser-heading" v-text="$t('jhipsterSampleApplicationApp.mondayUser.delete.question', { id: removeId })">
          Are you sure you want to delete this Monday User?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-mondayUser"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeMondayUser()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./monday-user.component.ts"></script>
