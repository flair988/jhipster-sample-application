<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="inspection">
        <h2 class="jh-entity-heading" data-cy="inspectionDetailsHeading">
          <span v-text="$t('jhipsterSampleApplicationApp.inspection.detail.title')">Inspection</span> {{ inspection.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.inspection.itemName')">Item Name</span>
          </dt>
          <dd>
            <span>{{ inspection.itemName }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.inspection.itemId')">Item Id</span>
          </dt>
          <dd>
            <span>{{ inspection.itemId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.inspection.boardId')">Board Id</span>
          </dt>
          <dd>
            <span>{{ inspection.boardId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.inspection.kingdeeId')">Kingdee Id</span>
          </dt>
          <dd>
            <span>{{ inspection.kingdeeId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.inspection.supplierName')">Supplier Name</span>
          </dt>
          <dd>
            <span>{{ inspection.supplierName }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.inspection.email')">Email</span>
          </dt>
          <dd>
            <span>{{ inspection.email }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.inspection.inspectionDate')">Inspection Date</span>
          </dt>
          <dd>
            <span>{{ inspection.inspectionDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.inspection.endOfProductionDate')">End Of Production Date</span>
          </dt>
          <dd>
            <span>{{ inspection.endOfProductionDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.inspection.cateGory')">Cate Gory</span>
          </dt>
          <dd>
            <span>{{ inspection.cateGory }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.inspection.technicalFile')">Technical File</span>
          </dt>
          <dd>
            <span>{{ inspection.technicalFile }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.inspection.qCResult')">Q C Result</span>
          </dt>
          <dd>
            <span>{{ inspection.qCResult }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.inspection.docStatus')">Doc Status</span>
          </dt>
          <dd>
            <span>{{ inspection.docStatus }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.inspection.goodsReadyForPickUpDate')">Goods Ready For Pick Up Date</span>
          </dt>
          <dd>
            <span>{{ inspection.goodsReadyForPickUpDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.inspection.inspectionType')">Inspection Type</span>
          </dt>
          <dd>
            <span>{{ inspection.inspectionType }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.inspection.inspectionBookingStatus')">Inspection Booking Status</span>
          </dt>
          <dd>
            <span>{{ inspection.inspectionBookingStatus }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="inspection.id"
          :to="{ name: 'InspectionEdit', params: { inspectionId: inspection.id } }"
          custom
          v-slot="{ navigate }"
        >
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./inspection-details.component.ts"></script>
