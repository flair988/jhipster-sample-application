<template>
  <div>
    <b-dropdown-item to="/group">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.group')">Group</span>
    </b-dropdown-item>
    <b-dropdown-item to="/item">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.item')">Item</span>
    </b-dropdown-item>
    <b-dropdown-item to="/monday-column">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.mondayColumn')">Monday Column</span>
    </b-dropdown-item>
    <b-dropdown-item to="/monday-user">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.mondayUser')">Monday User</span>
    </b-dropdown-item>
    <b-dropdown-item to="/operation-site">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.operationSite')">Operation Site</span>
    </b-dropdown-item>
    <b-dropdown-item to="/order-follow-up">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.orderFollowUp')">Order Follow Up</span>
    </b-dropdown-item>
    <b-dropdown-item to="/pi">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.pi')">PI</span>
    </b-dropdown-item>
    <b-dropdown-item to="/process-log">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.processLog')">Process Log</span>
    </b-dropdown-item>
    <b-dropdown-item to="/product-taxmonomy">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.productTaxmonomy')">Product Taxmonomy</span>
    </b-dropdown-item>
    <b-dropdown-item to="/supplier">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.supplier')">Supplier</span>
    </b-dropdown-item>
    <b-dropdown-item to="/uom">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.uom')">Uom</span>
    </b-dropdown-item>
    <b-dropdown-item to="/client">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.client')">Client</span>
    </b-dropdown-item>
    <b-dropdown-item to="/commercial-invoice">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.commercialInvoice')">Commercial Invoice</span>
    </b-dropdown-item>
    <b-dropdown-item to="/forwarder">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.forwarder')">Forwarder</span>
    </b-dropdown-item>
    <b-dropdown-item to="/forwarder-booking">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.forwarderBooking')">Forwarder Booking</span>
    </b-dropdown-item>
    <b-dropdown-item to="/inspection">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.inspection')">Inspection</span>
    </b-dropdown-item>
    <b-dropdown-item to="/product-finished">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.productFinished')">Product Finished</span>
    </b-dropdown-item>
    <b-dropdown-item to="/sales-delivery">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.salesDelivery')">Sales Delivery</span>
    </b-dropdown-item>
    <!-- jhipster-needle-add-entity-to-menu - JHipster will add entities to the menu here -->
  </div>
</template>

<script lang="ts" src="./entities-menu.component.ts"></script>
