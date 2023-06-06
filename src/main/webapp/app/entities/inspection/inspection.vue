<template>
  <div>
    <h2 id="page-heading" data-cy="InspectionHeading">
      <span v-text="$t('jhipsterSampleApplicationApp.inspection.home.title')" id="inspection-heading">Inspections</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('jhipsterSampleApplicationApp.inspection.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'InspectionCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-inspection"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('jhipsterSampleApplicationApp.inspection.home.createLabel')"> Create a new Inspection </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && inspections && inspections.length === 0">
      <span v-text="$t('jhipsterSampleApplicationApp.inspection.home.notFound')">No inspections found</span>
    </div>
    <div class="table-responsive" v-if="inspections && inspections.length > 0">
      <table class="table table-striped" aria-describedby="inspections">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.inspection.itemName')">Item Name</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.inspection.itemId')">Item Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.inspection.boardId')">Board Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.inspection.kingdeeId')">Kingdee Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.inspection.supplierName')">Supplier Name</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.inspection.email')">Email</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.inspection.inspectionDate')">Inspection Date</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterSampleApplicationApp.inspection.endOfProductionDate')">End Of Production Date</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.inspection.cateGory')">Cate Gory</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.inspection.technicalFile')">Technical File</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.inspection.qCResult')">Q C Result</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.inspection.docStatus')">Doc Status</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterSampleApplicationApp.inspection.goodsReadyForPickUpDate')">Goods Ready For Pick Up Date</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.inspection.inspectionType')">Inspection Type</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterSampleApplicationApp.inspection.inspectionBookingStatus')">Inspection Booking Status</span>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="inspection in inspections" :key="inspection.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'InspectionView', params: { inspectionId: inspection.id } }">{{ inspection.id }}</router-link>
            </td>
            <td>{{ inspection.itemName }}</td>
            <td>{{ inspection.itemId }}</td>
            <td>{{ inspection.boardId }}</td>
            <td>{{ inspection.kingdeeId }}</td>
            <td>{{ inspection.supplierName }}</td>
            <td>{{ inspection.email }}</td>
            <td>{{ inspection.inspectionDate }}</td>
            <td>{{ inspection.endOfProductionDate }}</td>
            <td>{{ inspection.cateGory }}</td>
            <td>{{ inspection.technicalFile }}</td>
            <td>{{ inspection.qCResult }}</td>
            <td>{{ inspection.docStatus }}</td>
            <td>{{ inspection.goodsReadyForPickUpDate }}</td>
            <td>{{ inspection.inspectionType }}</td>
            <td>{{ inspection.inspectionBookingStatus }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'InspectionView', params: { inspectionId: inspection.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'InspectionEdit', params: { inspectionId: inspection.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(inspection)"
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
          id="jhipsterSampleApplicationApp.inspection.delete.question"
          data-cy="inspectionDeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-inspection-heading" v-text="$t('jhipsterSampleApplicationApp.inspection.delete.question', { id: removeId })">
          Are you sure you want to delete this Inspection?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-inspection"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeInspection()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./inspection.component.ts"></script>
