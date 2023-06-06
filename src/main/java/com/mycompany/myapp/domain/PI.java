package com.mycompany.myapp.domain;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A PI.
 */
@Entity
@Table(name = "pi")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class PI implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_code")
    private String itemCode;

    @Column(name = "po_number")
    private String poNumber;

    @Column(name = "is_new_item")
    private String isNewItem;

    @Column(name = "category")
    private String category;

    @Column(name = "client")
    private String client;

    @Column(name = "supplier")
    private String supplier;

    @Column(name = "supplier_code")
    private String supplierCode;

    @Column(name = "order_date")
    private String orderDate;

    @Column(name = "port")
    private String port;

    @Column(name = "requested_end_of_prod_date")
    private String requestedEndOfProdDate;

    @Column(name = "item_quantity")
    private String itemQuantity;

    @Column(name = "country_of_origin")
    private String countryOfOrigin;

    @Column(name = "country_of_final_destination")
    private String countryOfFinalDestination;

    @Column(name = "production_lead_time_commitment")
    private String productionLeadTimeCommitment;

    @Column(name = "consignee")
    private String consignee;

    @Column(name = "carriage_by")
    private String carriageBy;

    @Column(name = "terms_of_delivery")
    private String termsOfDelivery;

    @Column(name = "terms_of_payment")
    private String termsOfPayment;

    @Column(name = "item_unit")
    private String itemUnit;

    @Column(name = "rate")
    private String rate;

    @Column(name = "amount")
    private String amount;

    @Column(name = "total_amount")
    private String totalAmount;

    @Column(name = "discount_rate")
    private String discountRate;

    @Column(name = "currency")
    private String currency;

    @Column(name = "pi_status")
    private String piStatus;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "item_id")
    private String itemId;

    @Column(name = "board_id")
    private String boardId;

    @Column(name = "kingdee_id")
    private String kingdeeId;

    @Column(name = "port_of_discharge")
    private String portOfDischarge;

    @Column(name = "port_of_loading")
    private String portOfLoading;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public PI id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return this.itemName;
    }

    public PI itemName(String itemName) {
        this.setItemName(itemName);
        return this;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCode() {
        return this.itemCode;
    }

    public PI itemCode(String itemCode) {
        this.setItemCode(itemCode);
        return this;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getPoNumber() {
        return this.poNumber;
    }

    public PI poNumber(String poNumber) {
        this.setPoNumber(poNumber);
        return this;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getIsNewItem() {
        return this.isNewItem;
    }

    public PI isNewItem(String isNewItem) {
        this.setIsNewItem(isNewItem);
        return this;
    }

    public void setIsNewItem(String isNewItem) {
        this.isNewItem = isNewItem;
    }

    public String getCategory() {
        return this.category;
    }

    public PI category(String category) {
        this.setCategory(category);
        return this;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getClient() {
        return this.client;
    }

    public PI client(String client) {
        this.setClient(client);
        return this;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getSupplier() {
        return this.supplier;
    }

    public PI supplier(String supplier) {
        this.setSupplier(supplier);
        return this;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getSupplierCode() {
        return this.supplierCode;
    }

    public PI supplierCode(String supplierCode) {
        this.setSupplierCode(supplierCode);
        return this;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getOrderDate() {
        return this.orderDate;
    }

    public PI orderDate(String orderDate) {
        this.setOrderDate(orderDate);
        return this;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getPort() {
        return this.port;
    }

    public PI port(String port) {
        this.setPort(port);
        return this;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getRequestedEndOfProdDate() {
        return this.requestedEndOfProdDate;
    }

    public PI requestedEndOfProdDate(String requestedEndOfProdDate) {
        this.setRequestedEndOfProdDate(requestedEndOfProdDate);
        return this;
    }

    public void setRequestedEndOfProdDate(String requestedEndOfProdDate) {
        this.requestedEndOfProdDate = requestedEndOfProdDate;
    }

    public String getItemQuantity() {
        return this.itemQuantity;
    }

    public PI itemQuantity(String itemQuantity) {
        this.setItemQuantity(itemQuantity);
        return this;
    }

    public void setItemQuantity(String itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public String getCountryOfOrigin() {
        return this.countryOfOrigin;
    }

    public PI countryOfOrigin(String countryOfOrigin) {
        this.setCountryOfOrigin(countryOfOrigin);
        return this;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getCountryOfFinalDestination() {
        return this.countryOfFinalDestination;
    }

    public PI countryOfFinalDestination(String countryOfFinalDestination) {
        this.setCountryOfFinalDestination(countryOfFinalDestination);
        return this;
    }

    public void setCountryOfFinalDestination(String countryOfFinalDestination) {
        this.countryOfFinalDestination = countryOfFinalDestination;
    }

    public String getProductionLeadTimeCommitment() {
        return this.productionLeadTimeCommitment;
    }

    public PI productionLeadTimeCommitment(String productionLeadTimeCommitment) {
        this.setProductionLeadTimeCommitment(productionLeadTimeCommitment);
        return this;
    }

    public void setProductionLeadTimeCommitment(String productionLeadTimeCommitment) {
        this.productionLeadTimeCommitment = productionLeadTimeCommitment;
    }

    public String getConsignee() {
        return this.consignee;
    }

    public PI consignee(String consignee) {
        this.setConsignee(consignee);
        return this;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getCarriageBy() {
        return this.carriageBy;
    }

    public PI carriageBy(String carriageBy) {
        this.setCarriageBy(carriageBy);
        return this;
    }

    public void setCarriageBy(String carriageBy) {
        this.carriageBy = carriageBy;
    }

    public String getTermsOfDelivery() {
        return this.termsOfDelivery;
    }

    public PI termsOfDelivery(String termsOfDelivery) {
        this.setTermsOfDelivery(termsOfDelivery);
        return this;
    }

    public void setTermsOfDelivery(String termsOfDelivery) {
        this.termsOfDelivery = termsOfDelivery;
    }

    public String getTermsOfPayment() {
        return this.termsOfPayment;
    }

    public PI termsOfPayment(String termsOfPayment) {
        this.setTermsOfPayment(termsOfPayment);
        return this;
    }

    public void setTermsOfPayment(String termsOfPayment) {
        this.termsOfPayment = termsOfPayment;
    }

    public String getItemUnit() {
        return this.itemUnit;
    }

    public PI itemUnit(String itemUnit) {
        this.setItemUnit(itemUnit);
        return this;
    }

    public void setItemUnit(String itemUnit) {
        this.itemUnit = itemUnit;
    }

    public String getRate() {
        return this.rate;
    }

    public PI rate(String rate) {
        this.setRate(rate);
        return this;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getAmount() {
        return this.amount;
    }

    public PI amount(String amount) {
        this.setAmount(amount);
        return this;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTotalAmount() {
        return this.totalAmount;
    }

    public PI totalAmount(String totalAmount) {
        this.setTotalAmount(totalAmount);
        return this;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getDiscountRate() {
        return this.discountRate;
    }

    public PI discountRate(String discountRate) {
        this.setDiscountRate(discountRate);
        return this;
    }

    public void setDiscountRate(String discountRate) {
        this.discountRate = discountRate;
    }

    public String getCurrency() {
        return this.currency;
    }

    public PI currency(String currency) {
        this.setCurrency(currency);
        return this;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPiStatus() {
        return this.piStatus;
    }

    public PI piStatus(String piStatus) {
        this.setPiStatus(piStatus);
        return this;
    }

    public void setPiStatus(String piStatus) {
        this.piStatus = piStatus;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public PI remarks(String remarks) {
        this.setRemarks(remarks);
        return this;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getItemId() {
        return this.itemId;
    }

    public PI itemId(String itemId) {
        this.setItemId(itemId);
        return this;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getBoardId() {
        return this.boardId;
    }

    public PI boardId(String boardId) {
        this.setBoardId(boardId);
        return this;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public String getKingdeeId() {
        return this.kingdeeId;
    }

    public PI kingdeeId(String kingdeeId) {
        this.setKingdeeId(kingdeeId);
        return this;
    }

    public void setKingdeeId(String kingdeeId) {
        this.kingdeeId = kingdeeId;
    }

    public String getPortOfDischarge() {
        return this.portOfDischarge;
    }

    public PI portOfDischarge(String portOfDischarge) {
        this.setPortOfDischarge(portOfDischarge);
        return this;
    }

    public void setPortOfDischarge(String portOfDischarge) {
        this.portOfDischarge = portOfDischarge;
    }

    public String getPortOfLoading() {
        return this.portOfLoading;
    }

    public PI portOfLoading(String portOfLoading) {
        this.setPortOfLoading(portOfLoading);
        return this;
    }

    public void setPortOfLoading(String portOfLoading) {
        this.portOfLoading = portOfLoading;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PI)) {
            return false;
        }
        return id != null && id.equals(((PI) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PI{" +
            "id=" + getId() +
            ", itemName='" + getItemName() + "'" +
            ", itemCode='" + getItemCode() + "'" +
            ", poNumber='" + getPoNumber() + "'" +
            ", isNewItem='" + getIsNewItem() + "'" +
            ", category='" + getCategory() + "'" +
            ", client='" + getClient() + "'" +
            ", supplier='" + getSupplier() + "'" +
            ", supplierCode='" + getSupplierCode() + "'" +
            ", orderDate='" + getOrderDate() + "'" +
            ", port='" + getPort() + "'" +
            ", requestedEndOfProdDate='" + getRequestedEndOfProdDate() + "'" +
            ", itemQuantity='" + getItemQuantity() + "'" +
            ", countryOfOrigin='" + getCountryOfOrigin() + "'" +
            ", countryOfFinalDestination='" + getCountryOfFinalDestination() + "'" +
            ", productionLeadTimeCommitment='" + getProductionLeadTimeCommitment() + "'" +
            ", consignee='" + getConsignee() + "'" +
            ", carriageBy='" + getCarriageBy() + "'" +
            ", termsOfDelivery='" + getTermsOfDelivery() + "'" +
            ", termsOfPayment='" + getTermsOfPayment() + "'" +
            ", itemUnit='" + getItemUnit() + "'" +
            ", rate='" + getRate() + "'" +
            ", amount='" + getAmount() + "'" +
            ", totalAmount='" + getTotalAmount() + "'" +
            ", discountRate='" + getDiscountRate() + "'" +
            ", currency='" + getCurrency() + "'" +
            ", piStatus='" + getPiStatus() + "'" +
            ", remarks='" + getRemarks() + "'" +
            ", itemId='" + getItemId() + "'" +
            ", boardId='" + getBoardId() + "'" +
            ", kingdeeId='" + getKingdeeId() + "'" +
            ", portOfDischarge='" + getPortOfDischarge() + "'" +
            ", portOfLoading='" + getPortOfLoading() + "'" +
            "}";
    }
}
