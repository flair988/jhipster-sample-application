<template>
  <div>
    <h2 id="page-heading" data-cy="OperationSiteHeading">
      <span v-text="$t('jhipsterSampleApplicationApp.operationSite.home.title')" id="operation-site-heading">Operation Sites</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('jhipsterSampleApplicationApp.operationSite.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'OperationSiteCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-operation-site"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('jhipsterSampleApplicationApp.operationSite.home.createLabel')"> Create a new Operation Site </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && operationSites && operationSites.length === 0">
      <span v-text="$t('jhipsterSampleApplicationApp.operationSite.home.notFound')">No operationSites found</span>
    </div>
    <div class="table-responsive" v-if="operationSites && operationSites.length > 0">
      <table class="table table-striped" aria-describedby="operationSites">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.operationSite.itemName')">Item Name</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterSampleApplicationApp.operationSite.linkSupplierFactory')">Link Supplier Factory</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.operationSite.typeOfSite')">Type Of Site</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.operationSite.contact')">Contact</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.operationSite.siteAddress')">Site Address</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.operationSite.cateGory')">Cate Gory</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.operationSite.country')">Country</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.operationSite.boardId')">Board Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.operationSite.kingdeeId')">Kingdee Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.operationSite.itemId')">Item Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.operationSite.businessLicense')">Business License</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.operationSite.sasDate')">Sas Date</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.operationSite.iso900ValidUtil')">Iso 900 Valid Util</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterSampleApplicationApp.operationSite.iso14001ValidUtil')">Iso 14001 Valid Util</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.operationSite.attributeLor')">Attribute Lor</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.operationSite.siteQualification')">Site Qualification</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterSampleApplicationApp.operationSite.qualificationScore')">Qualification Score</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.operationSite.pqvScore')">Pqv Score</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.operationSite.pqvDate')">Pqv Date</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.operationSite.pqvDecision')">Pqv Decision</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterSampleApplicationApp.operationSite.technicalAuditDate')">Technical Audit Date</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterSampleApplicationApp.operationSite.technicalAuditScore')">Technical Audit Score</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.operationSite.thirdRdPartyDate')">Third Rd Party Date</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterSampleApplicationApp.operationSite.thirdRdPartyScore')">Third Rd Party Score</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.operationSite.bopeDate')">Bope Date</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.operationSite.bopeScore')">Bope Score</span></th>
            <th scope="row"><span v-text="$t('jhipsterSampleApplicationApp.operationSite.capRequired')">Cap Required</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="operationSite in operationSites" :key="operationSite.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'OperationSiteView', params: { operationSiteId: operationSite.id } }">{{
                operationSite.id
              }}</router-link>
            </td>
            <td>{{ operationSite.itemName }}</td>
            <td>{{ operationSite.linkSupplierFactory }}</td>
            <td>{{ operationSite.typeOfSite }}</td>
            <td>{{ operationSite.contact }}</td>
            <td>{{ operationSite.siteAddress }}</td>
            <td>{{ operationSite.cateGory }}</td>
            <td>{{ operationSite.country }}</td>
            <td>{{ operationSite.boardId }}</td>
            <td>{{ operationSite.kingdeeId }}</td>
            <td>{{ operationSite.itemId }}</td>
            <td>{{ operationSite.businessLicense }}</td>
            <td>{{ operationSite.sasDate }}</td>
            <td>{{ operationSite.iso900ValidUtil }}</td>
            <td>{{ operationSite.iso14001ValidUtil }}</td>
            <td>{{ operationSite.attributeLor }}</td>
            <td>{{ operationSite.siteQualification }}</td>
            <td>{{ operationSite.qualificationScore }}</td>
            <td>{{ operationSite.pqvScore }}</td>
            <td>{{ operationSite.pqvDate }}</td>
            <td>{{ operationSite.pqvDecision }}</td>
            <td>{{ operationSite.technicalAuditDate }}</td>
            <td>{{ operationSite.technicalAuditScore }}</td>
            <td>{{ operationSite.thirdRdPartyDate }}</td>
            <td>{{ operationSite.thirdRdPartyScore }}</td>
            <td>{{ operationSite.bopeDate }}</td>
            <td>{{ operationSite.bopeScore }}</td>
            <td>{{ operationSite.capRequired }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'OperationSiteView', params: { operationSiteId: operationSite.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link
                  :to="{ name: 'OperationSiteEdit', params: { operationSiteId: operationSite.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(operationSite)"
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
          id="jhipsterSampleApplicationApp.operationSite.delete.question"
          data-cy="operationSiteDeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p
          id="jhi-delete-operationSite-heading"
          v-text="$t('jhipsterSampleApplicationApp.operationSite.delete.question', { id: removeId })"
        >
          Are you sure you want to delete this Operation Site?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-operationSite"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeOperationSite()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./operation-site.component.ts"></script>
