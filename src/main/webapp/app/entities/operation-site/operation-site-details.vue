<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="operationSite">
        <h2 class="jh-entity-heading" data-cy="operationSiteDetailsHeading">
          <span v-text="$t('jhipsterSampleApplicationApp.operationSite.detail.title')">OperationSite</span> {{ operationSite.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.operationSite.itemName')">Item Name</span>
          </dt>
          <dd>
            <span>{{ operationSite.itemName }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.operationSite.linkSupplierFactory')">Link Supplier Factory</span>
          </dt>
          <dd>
            <span>{{ operationSite.linkSupplierFactory }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.operationSite.typeOfSite')">Type Of Site</span>
          </dt>
          <dd>
            <span>{{ operationSite.typeOfSite }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.operationSite.contact')">Contact</span>
          </dt>
          <dd>
            <span>{{ operationSite.contact }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.operationSite.siteAddress')">Site Address</span>
          </dt>
          <dd>
            <span>{{ operationSite.siteAddress }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.operationSite.cateGory')">Cate Gory</span>
          </dt>
          <dd>
            <span>{{ operationSite.cateGory }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.operationSite.country')">Country</span>
          </dt>
          <dd>
            <span>{{ operationSite.country }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.operationSite.boardId')">Board Id</span>
          </dt>
          <dd>
            <span>{{ operationSite.boardId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.operationSite.kingdeeId')">Kingdee Id</span>
          </dt>
          <dd>
            <span>{{ operationSite.kingdeeId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.operationSite.itemId')">Item Id</span>
          </dt>
          <dd>
            <span>{{ operationSite.itemId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.operationSite.businessLicense')">Business License</span>
          </dt>
          <dd>
            <span>{{ operationSite.businessLicense }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.operationSite.sasDate')">Sas Date</span>
          </dt>
          <dd>
            <span>{{ operationSite.sasDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.operationSite.iso900ValidUtil')">Iso 900 Valid Util</span>
          </dt>
          <dd>
            <span>{{ operationSite.iso900ValidUtil }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.operationSite.iso14001ValidUtil')">Iso 14001 Valid Util</span>
          </dt>
          <dd>
            <span>{{ operationSite.iso14001ValidUtil }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.operationSite.attributeLor')">Attribute Lor</span>
          </dt>
          <dd>
            <span>{{ operationSite.attributeLor }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.operationSite.siteQualification')">Site Qualification</span>
          </dt>
          <dd>
            <span>{{ operationSite.siteQualification }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.operationSite.qualificationScore')">Qualification Score</span>
          </dt>
          <dd>
            <span>{{ operationSite.qualificationScore }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.operationSite.pqvScore')">Pqv Score</span>
          </dt>
          <dd>
            <span>{{ operationSite.pqvScore }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.operationSite.pqvDate')">Pqv Date</span>
          </dt>
          <dd>
            <span>{{ operationSite.pqvDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.operationSite.pqvDecision')">Pqv Decision</span>
          </dt>
          <dd>
            <span>{{ operationSite.pqvDecision }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.operationSite.technicalAuditDate')">Technical Audit Date</span>
          </dt>
          <dd>
            <span>{{ operationSite.technicalAuditDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.operationSite.technicalAuditScore')">Technical Audit Score</span>
          </dt>
          <dd>
            <span>{{ operationSite.technicalAuditScore }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.operationSite.thirdRdPartyDate')">Third Rd Party Date</span>
          </dt>
          <dd>
            <span>{{ operationSite.thirdRdPartyDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.operationSite.thirdRdPartyScore')">Third Rd Party Score</span>
          </dt>
          <dd>
            <span>{{ operationSite.thirdRdPartyScore }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.operationSite.bopeDate')">Bope Date</span>
          </dt>
          <dd>
            <span>{{ operationSite.bopeDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.operationSite.bopeScore')">Bope Score</span>
          </dt>
          <dd>
            <span>{{ operationSite.bopeScore }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.operationSite.capRequired')">Cap Required</span>
          </dt>
          <dd>
            <span>{{ operationSite.capRequired }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="operationSite.id"
          :to="{ name: 'OperationSiteEdit', params: { operationSiteId: operationSite.id } }"
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

<script lang="ts" src="./operation-site-details.component.ts"></script>
