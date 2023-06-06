package com.mycompany.myapp.domain;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A SalesDelivery.
 */
@Entity
@Table(name = "sales_delivery")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class SalesDelivery implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_id")
    private String itemId;

    @Column(name = "board_id")
    private String boardId;

    @Column(name = "kingdee_id")
    private String kingdeeId;

    @Column(name = "customer")
    private String customer;

    @Column(name = "order_date")
    private String orderDate;

    @Column(name = "total_actual_ship_qty")
    private String totalActualShipQty;

    @Column(name = "total_qty_delivery")
    private String totalQtyDelivery;

    @Column(name = "loading_port")
    private String loadingPort;

    @Column(name = "discharge_port")
    private String dischargePort;

    @Column(name = "transport_mode")
    private String transportMode;

    @Column(name = "incoterm")
    private String incoterm;

    @Column(name = "forwarder")
    private String forwarder;

    @Column(name = "eta")
    private String eta;

    @Column(name = "etd")
    private String etd;

    @Column(name = "container_type")
    private String containerType;

    @Column(name = "container_size")
    private String containerSize;

    @Column(name = "remark")
    private String remark;

    @Column(name = "kingdee_unique_id")
    private String kingdeeUniqueId;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public SalesDelivery id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return this.itemName;
    }

    public SalesDelivery itemName(String itemName) {
        this.setItemName(itemName);
        return this;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemId() {
        return this.itemId;
    }

    public SalesDelivery itemId(String itemId) {
        this.setItemId(itemId);
        return this;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getBoardId() {
        return this.boardId;
    }

    public SalesDelivery boardId(String boardId) {
        this.setBoardId(boardId);
        return this;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public String getKingdeeId() {
        return this.kingdeeId;
    }

    public SalesDelivery kingdeeId(String kingdeeId) {
        this.setKingdeeId(kingdeeId);
        return this;
    }

    public void setKingdeeId(String kingdeeId) {
        this.kingdeeId = kingdeeId;
    }

    public String getCustomer() {
        return this.customer;
    }

    public SalesDelivery customer(String customer) {
        this.setCustomer(customer);
        return this;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getOrderDate() {
        return this.orderDate;
    }

    public SalesDelivery orderDate(String orderDate) {
        this.setOrderDate(orderDate);
        return this;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getTotalActualShipQty() {
        return this.totalActualShipQty;
    }

    public SalesDelivery totalActualShipQty(String totalActualShipQty) {
        this.setTotalActualShipQty(totalActualShipQty);
        return this;
    }

    public void setTotalActualShipQty(String totalActualShipQty) {
        this.totalActualShipQty = totalActualShipQty;
    }

    public String getTotalQtyDelivery() {
        return this.totalQtyDelivery;
    }

    public SalesDelivery totalQtyDelivery(String totalQtyDelivery) {
        this.setTotalQtyDelivery(totalQtyDelivery);
        return this;
    }

    public void setTotalQtyDelivery(String totalQtyDelivery) {
        this.totalQtyDelivery = totalQtyDelivery;
    }

    public String getLoadingPort() {
        return this.loadingPort;
    }

    public SalesDelivery loadingPort(String loadingPort) {
        this.setLoadingPort(loadingPort);
        return this;
    }

    public void setLoadingPort(String loadingPort) {
        this.loadingPort = loadingPort;
    }

    public String getDischargePort() {
        return this.dischargePort;
    }

    public SalesDelivery dischargePort(String dischargePort) {
        this.setDischargePort(dischargePort);
        return this;
    }

    public void setDischargePort(String dischargePort) {
        this.dischargePort = dischargePort;
    }

    public String getTransportMode() {
        return this.transportMode;
    }

    public SalesDelivery transportMode(String transportMode) {
        this.setTransportMode(transportMode);
        return this;
    }

    public void setTransportMode(String transportMode) {
        this.transportMode = transportMode;
    }

    public String getIncoterm() {
        return this.incoterm;
    }

    public SalesDelivery incoterm(String incoterm) {
        this.setIncoterm(incoterm);
        return this;
    }

    public void setIncoterm(String incoterm) {
        this.incoterm = incoterm;
    }

    public String getForwarder() {
        return this.forwarder;
    }

    public SalesDelivery forwarder(String forwarder) {
        this.setForwarder(forwarder);
        return this;
    }

    public void setForwarder(String forwarder) {
        this.forwarder = forwarder;
    }

    public String getEta() {
        return this.eta;
    }

    public SalesDelivery eta(String eta) {
        this.setEta(eta);
        return this;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    public String getEtd() {
        return this.etd;
    }

    public SalesDelivery etd(String etd) {
        this.setEtd(etd);
        return this;
    }

    public void setEtd(String etd) {
        this.etd = etd;
    }

    public String getContainerType() {
        return this.containerType;
    }

    public SalesDelivery containerType(String containerType) {
        this.setContainerType(containerType);
        return this;
    }

    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    public String getContainerSize() {
        return this.containerSize;
    }

    public SalesDelivery containerSize(String containerSize) {
        this.setContainerSize(containerSize);
        return this;
    }

    public void setContainerSize(String containerSize) {
        this.containerSize = containerSize;
    }

    public String getRemark() {
        return this.remark;
    }

    public SalesDelivery remark(String remark) {
        this.setRemark(remark);
        return this;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getKingdeeUniqueId() {
        return this.kingdeeUniqueId;
    }

    public SalesDelivery kingdeeUniqueId(String kingdeeUniqueId) {
        this.setKingdeeUniqueId(kingdeeUniqueId);
        return this;
    }

    public void setKingdeeUniqueId(String kingdeeUniqueId) {
        this.kingdeeUniqueId = kingdeeUniqueId;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SalesDelivery)) {
            return false;
        }
        return id != null && id.equals(((SalesDelivery) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SalesDelivery{" +
            "id=" + getId() +
            ", itemName='" + getItemName() + "'" +
            ", itemId='" + getItemId() + "'" +
            ", boardId='" + getBoardId() + "'" +
            ", kingdeeId='" + getKingdeeId() + "'" +
            ", customer='" + getCustomer() + "'" +
            ", orderDate='" + getOrderDate() + "'" +
            ", totalActualShipQty='" + getTotalActualShipQty() + "'" +
            ", totalQtyDelivery='" + getTotalQtyDelivery() + "'" +
            ", loadingPort='" + getLoadingPort() + "'" +
            ", dischargePort='" + getDischargePort() + "'" +
            ", transportMode='" + getTransportMode() + "'" +
            ", incoterm='" + getIncoterm() + "'" +
            ", forwarder='" + getForwarder() + "'" +
            ", eta='" + getEta() + "'" +
            ", etd='" + getEtd() + "'" +
            ", containerType='" + getContainerType() + "'" +
            ", containerSize='" + getContainerSize() + "'" +
            ", remark='" + getRemark() + "'" +
            ", kingdeeUniqueId='" + getKingdeeUniqueId() + "'" +
            "}";
    }
}
