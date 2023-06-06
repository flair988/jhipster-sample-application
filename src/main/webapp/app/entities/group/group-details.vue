<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="group">
        <h2 class="jh-entity-heading" data-cy="groupDetailsHeading">
          <span v-text="$t('jhipsterSampleApplicationApp.group.detail.title')">Group</span> {{ group.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.group.groupId')">Group Id</span>
          </dt>
          <dd>
            <span>{{ group.groupId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.group.groupNumber')">Group Number</span>
          </dt>
          <dd>
            <span>{{ group.groupNumber }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.group.parentId')">Parent Id</span>
          </dt>
          <dd>
            <span>{{ group.parentId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.group.groupName')">Group Name</span>
          </dt>
          <dd>
            <span>{{ group.groupName }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.group.description')">Description</span>
          </dt>
          <dd>
            <span>{{ group.description }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link v-if="group.id" :to="{ name: 'GroupEdit', params: { groupId: group.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./group-details.component.ts"></script>
