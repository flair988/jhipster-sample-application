package com.mycompany.myapp.domain;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A CommercialInvoice.
 */
@Entity
@Table(name = "commercial_invoice")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class CommercialInvoice implements Serializable {

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

    @Column(name = "date")
    private String date;

    @Column(name = "client")
    private String client;

    @Column(name = "cate_gory")
    private String cateGory;

    @Column(name = "total_price")
    private String totalPrice;

    @Column(name = "currency")
    private String currency;

    @Column(name = "remarks")
    private String remarks;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public CommercialInvoice id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return this.itemName;
    }

    public CommercialInvoice itemName(String itemName) {
        this.setItemName(itemName);
        return this;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemId() {
        return this.itemId;
    }

    public CommercialInvoice itemId(String itemId) {
        this.setItemId(itemId);
        return this;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getBoardId() {
        return this.boardId;
    }

    public CommercialInvoice boardId(String boardId) {
        this.setBoardId(boardId);
        return this;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public String getKingdeeId() {
        return this.kingdeeId;
    }

    public CommercialInvoice kingdeeId(String kingdeeId) {
        this.setKingdeeId(kingdeeId);
        return this;
    }

    public void setKingdeeId(String kingdeeId) {
        this.kingdeeId = kingdeeId;
    }

    public String getDate() {
        return this.date;
    }

    public CommercialInvoice date(String date) {
        this.setDate(date);
        return this;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClient() {
        return this.client;
    }

    public CommercialInvoice client(String client) {
        this.setClient(client);
        return this;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getCateGory() {
        return this.cateGory;
    }

    public CommercialInvoice cateGory(String cateGory) {
        this.setCateGory(cateGory);
        return this;
    }

    public void setCateGory(String cateGory) {
        this.cateGory = cateGory;
    }

    public String getTotalPrice() {
        return this.totalPrice;
    }

    public CommercialInvoice totalPrice(String totalPrice) {
        this.setTotalPrice(totalPrice);
        return this;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCurrency() {
        return this.currency;
    }

    public CommercialInvoice currency(String currency) {
        this.setCurrency(currency);
        return this;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public CommercialInvoice remarks(String remarks) {
        this.setRemarks(remarks);
        return this;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CommercialInvoice)) {
            return false;
        }
        return id != null && id.equals(((CommercialInvoice) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CommercialInvoice{" +
            "id=" + getId() +
            ", itemName='" + getItemName() + "'" +
            ", itemId='" + getItemId() + "'" +
            ", boardId='" + getBoardId() + "'" +
            ", kingdeeId='" + getKingdeeId() + "'" +
            ", date='" + getDate() + "'" +
            ", client='" + getClient() + "'" +
            ", cateGory='" + getCateGory() + "'" +
            ", totalPrice='" + getTotalPrice() + "'" +
            ", currency='" + getCurrency() + "'" +
            ", remarks='" + getRemarks() + "'" +
            "}";
    }
}
