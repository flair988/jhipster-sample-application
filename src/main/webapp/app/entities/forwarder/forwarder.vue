<template>
  <div>
    <h2 id="page-heading" data-cy="ForwarderHeading">
      <span v-text="$t('jhipsterSampleApplicationApp.forwarder.home.title')" id="forwarder-heading">Forwarders</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('jhipsterSampleApplicationApp.forwarder.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'ForwarderCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-forwarder"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('jhipsterSampleApplicationApp.forwarder.home.createLabel')"> Create a new Forwarder </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && forwarders && forwarders.length === 0">
      <span v-text="$t('jhipsterSampleApplicationApp.forwarder.home.notFound')">No forwarders found</span>
    </div>
    <div class="table-responsive" v-if="forwarders && forwarders.length > 0">
      <table class="table table-striped" aria-describedby="forwarders">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.forwarder.itemName')">Item Name</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.forwarder.itemId')">Item Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.forwarder.boardId')">Board Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.forwarder.kingdeeId')">Kingdee Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.forwarder.contact')">Contact</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.forwarder.email')">Email</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.forwarder.telephone')">Telephone</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="forwarder in forwarders" :key="forwarder.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'ForwarderView', params: { forwarderId: forwarder.id } }">{{ forwarder.id }}</router-link>
            </td>
            <td>{{ forwarder.itemName }}</td>
            <td>{{ forwarder.itemId }}</td>
            <td>{{ forwarder.boardId }}</td>
            <td>{{ forwarder.kingdeeId }}</td>
            <td>{{ forwarder.contact }}</td>
            <td>{{ forwarder.email }}</td>
            <td>{{ forwarder.telephone }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'ForwarderView', params: { forwarderId: forwarder.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'ForwarderEdit', params: { forwarderId: forwarder.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(forwarder)"
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
          id="jhipsterSampleApplicationApp.forwarder.delete.question"
          data-cy="forwarderDeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-forwarder-heading" v-text="$t('jhipsterSampleApplicationApp.forwarder.delete.question', { id: removeId })">
          Are you sure you want to delete this Forwarder?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-forwarder"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeForwarder()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./forwarder.component.ts"></script>
