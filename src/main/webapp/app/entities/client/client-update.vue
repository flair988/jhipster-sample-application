<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterSampleApplicationApp.client.home.createOrEditLabel"
          data-cy="ClientCreateUpdateHeading"
          v-text="$t('jhipsterSampleApplicationApp.client.home.createOrEditLabel')"
        >
          Create or edit a Client
        </h2>
        <div>
          <div class="form-group" v-if="client.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="client.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.client.itemId')" for="client-itemId">Item Id</label>
            <input
              type="text"
              class="form-control"
              name="itemId"
              id="client-itemId"
              data-cy="itemId"
              :class="{ valid: !$v.client.itemId.$invalid, invalid: $v.client.itemId.$invalid }"
              v-model="$v.client.itemId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.client.itemName')" for="client-itemName"
              >Item Name</label
            >
            <input
              type="text"
              class="form-control"
              name="itemName"
              id="client-itemName"
              data-cy="itemName"
              :class="{ valid: !$v.client.itemName.$invalid, invalid: $v.client.itemName.$invalid }"
              v-model="$v.client.itemName.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.client.boardId')" for="client-boardId"
              >Board Id</label
            >
            <input
              type="text"
              class="form-control"
              name="boardId"
              id="client-boardId"
              data-cy="boardId"
              :class="{ valid: !$v.client.boardId.$invalid, invalid: $v.client.boardId.$invalid }"
              v-model="$v.client.boardId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.client.subItems')" for="client-subItems"
              >Sub Items</label
            >
            <input
              type="text"
              class="form-control"
              name="subItems"
              id="client-subItems"
              data-cy="subItems"
              :class="{ valid: !$v.client.subItems.$invalid, invalid: $v.client.subItems.$invalid }"
              v-model="$v.client.subItems.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.client.kingdeeId')" for="client-kingdeeId"
              >Kingdee Id</label
            >
            <input
              type="text"
              class="form-control"
              name="kingdeeId"
              id="client-kingdeeId"
              data-cy="kingdeeId"
              :class="{ valid: !$v.client.kingdeeId.$invalid, invalid: $v.client.kingdeeId.$invalid }"
              v-model="$v.client.kingdeeId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.client.customerName')" for="client-customerName"
              >Customer Name</label
            >
            <input
              type="text"
              class="form-control"
              name="customerName"
              id="client-customerName"
              data-cy="customerName"
              :class="{ valid: !$v.client.customerName.$invalid, invalid: $v.client.customerName.$invalid }"
              v-model="$v.client.customerName.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.client.customerCode')" for="client-customerCode"
              >Customer Code</label
            >
            <input
              type="text"
              class="form-control"
              name="customerCode"
              id="client-customerCode"
              data-cy="customerCode"
              :class="{ valid: !$v.client.customerCode.$invalid, invalid: $v.client.customerCode.$invalid }"
              v-model="$v.client.customerCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterSampleApplicationApp.client.customerFrenceName')"
              for="client-customerFrenceName"
              >Customer Frence Name</label
            >
            <input
              type="text"
              class="form-control"
              name="customerFrenceName"
              id="client-customerFrenceName"
              data-cy="customerFrenceName"
              :class="{ valid: !$v.client.customerFrenceName.$invalid, invalid: $v.client.customerFrenceName.$invalid }"
              v-model="$v.client.customerFrenceName.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterSampleApplicationApp.client.comment')" for="client-comment"
              >Comment</label
            >
            <input
              type="text"
              class="form-control"
              name="comment"
              id="client-comment"
              data-cy="comment"
              :class="{ valid: !$v.client.comment.$invalid, invalid: $v.client.comment.$invalid }"
              v-model="$v.client.comment.$model"
            />
          </div>
        </div>
        <div>
          <button type="button" id="cancel-save" data-cy="entityCreateCancelButton" class="btn btn-secondary" v-on:click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
          </button>
          <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="$v.client.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./client-update.component.ts"></script>
