<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="forwarder">
        <h2 class="jh-entity-heading" data-cy="forwarderDetailsHeading">
          <span v-text="t$('jhipsterSampleApplicationApp.forwarder.detail.title')"></span> {{ forwarder.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.forwarder.itemName')"></span>
          </dt>
          <dd>
            <span>{{ forwarder.itemName }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.forwarder.itemId')"></span>
          </dt>
          <dd>
            <span>{{ forwarder.itemId }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.forwarder.boardId')"></span>
          </dt>
          <dd>
            <span>{{ forwarder.boardId }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.forwarder.kingdeeId')"></span>
          </dt>
          <dd>
            <span>{{ forwarder.kingdeeId }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.forwarder.contact')"></span>
          </dt>
          <dd>
            <span>{{ forwarder.contact }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.forwarder.email')"></span>
          </dt>
          <dd>
            <span>{{ forwarder.email }}</span>
          </dd>
          <dt>
            <span v-text="t$('jhipsterSampleApplicationApp.forwarder.telephone')"></span>
          </dt>
          <dd>
            <span>{{ forwarder.telephone }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.back')"></span>
        </button>
        <router-link
          v-if="forwarder.id"
          :to="{ name: 'ForwarderEdit', params: { forwarderId: forwarder.id } }"
          custom
          v-slot="{ navigate }"
        >
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.edit')"></span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./forwarder-details.component.ts"></script>
