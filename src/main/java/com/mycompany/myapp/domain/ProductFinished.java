package com.mycompany.myapp.domain;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A ProductFinished.
 */
@Entity
@Table(name = "product_finished")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ProductFinished implements Serializable {

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

    @Column(name = "supplier")
    private String supplier;

    @Column(name = "supplier_email")
    private String supplierEmail;

    @Column(name = "order_date")
    private String orderDate;

    @Column(name = "cate_gory")
    private String cateGory;

    @Column(name = "remark")
    private String remark;

    @Column(name = "material_receipt_date")
    private String materialReceiptDate;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public ProductFinished id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return this.itemName;
    }

    public ProductFinished itemName(String itemName) {
        this.setItemName(itemName);
        return this;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemId() {
        return this.itemId;
    }

    public ProductFinished itemId(String itemId) {
        this.setItemId(itemId);
        return this;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getBoardId() {
        return this.boardId;
    }

    public ProductFinished boardId(String boardId) {
        this.setBoardId(boardId);
        return this;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public String getKingdeeId() {
        return this.kingdeeId;
    }

    public ProductFinished kingdeeId(String kingdeeId) {
        this.setKingdeeId(kingdeeId);
        return this;
    }

    public void setKingdeeId(String kingdeeId) {
        this.kingdeeId = kingdeeId;
    }

    public String getSupplier() {
        return this.supplier;
    }

    public ProductFinished supplier(String supplier) {
        this.setSupplier(supplier);
        return this;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getSupplierEmail() {
        return this.supplierEmail;
    }

    public ProductFinished supplierEmail(String supplierEmail) {
        this.setSupplierEmail(supplierEmail);
        return this;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }

    public String getOrderDate() {
        return this.orderDate;
    }

    public ProductFinished orderDate(String orderDate) {
        this.setOrderDate(orderDate);
        return this;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCateGory() {
        return this.cateGory;
    }

    public ProductFinished cateGory(String cateGory) {
        this.setCateGory(cateGory);
        return this;
    }

    public void setCateGory(String cateGory) {
        this.cateGory = cateGory;
    }

    public String getRemark() {
        return this.remark;
    }

    public ProductFinished remark(String remark) {
        this.setRemark(remark);
        return this;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMaterialReceiptDate() {
        return this.materialReceiptDate;
    }

    public ProductFinished materialReceiptDate(String materialReceiptDate) {
        this.setMaterialReceiptDate(materialReceiptDate);
        return this;
    }

    public void setMaterialReceiptDate(String materialReceiptDate) {
        this.materialReceiptDate = materialReceiptDate;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProductFinished)) {
            return false;
        }
        return id != null && id.equals(((ProductFinished) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProductFinished{" +
            "id=" + getId() +
            ", itemName='" + getItemName() + "'" +
            ", itemId='" + getItemId() + "'" +
            ", boardId='" + getBoardId() + "'" +
            ", kingdeeId='" + getKingdeeId() + "'" +
            ", supplier='" + getSupplier() + "'" +
            ", supplierEmail='" + getSupplierEmail() + "'" +
            ", orderDate='" + getOrderDate() + "'" +
            ", cateGory='" + getCateGory() + "'" +
            ", remark='" + getRemark() + "'" +
            ", materialReceiptDate='" + getMaterialReceiptDate() + "'" +
            "}";
    }
}
