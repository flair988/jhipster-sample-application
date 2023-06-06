package com.mycompany.myapp.domain;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Inspection.
 */
@Entity
@Table(name = "inspection")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Inspection implements Serializable {

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

    @Column(name = "supplier_name")
    private String supplierName;

    @Column(name = "email")
    private String email;

    @Column(name = "inspection_date")
    private String inspectionDate;

    @Column(name = "end_of_production_date")
    private String endOfProductionDate;

    @Column(name = "cate_gory")
    private String cateGory;

    @Column(name = "technical_file")
    private String technicalFile;

    @Column(name = "q_c_result")
    private String qCResult;

    @Column(name = "doc_status")
    private String docStatus;

    @Column(name = "goods_ready_for_pick_up_date")
    private String goodsReadyForPickUpDate;

    @Column(name = "inspection_type")
    private String inspectionType;

    @Column(name = "inspection_booking_status")
    private String inspectionBookingStatus;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Inspection id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return this.itemName;
    }

    public Inspection itemName(String itemName) {
        this.setItemName(itemName);
        return this;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemId() {
        return this.itemId;
    }

    public Inspection itemId(String itemId) {
        this.setItemId(itemId);
        return this;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getBoardId() {
        return this.boardId;
    }

    public Inspection boardId(String boardId) {
        this.setBoardId(boardId);
        return this;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public String getKingdeeId() {
        return this.kingdeeId;
    }

    public Inspection kingdeeId(String kingdeeId) {
        this.setKingdeeId(kingdeeId);
        return this;
    }

    public void setKingdeeId(String kingdeeId) {
        this.kingdeeId = kingdeeId;
    }

    public String getSupplierName() {
        return this.supplierName;
    }

    public Inspection supplierName(String supplierName) {
        this.setSupplierName(supplierName);
        return this;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getEmail() {
        return this.email;
    }

    public Inspection email(String email) {
        this.setEmail(email);
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInspectionDate() {
        return this.inspectionDate;
    }

    public Inspection inspectionDate(String inspectionDate) {
        this.setInspectionDate(inspectionDate);
        return this;
    }

    public void setInspectionDate(String inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public String getEndOfProductionDate() {
        return this.endOfProductionDate;
    }

    public Inspection endOfProductionDate(String endOfProductionDate) {
        this.setEndOfProductionDate(endOfProductionDate);
        return this;
    }

    public void setEndOfProductionDate(String endOfProductionDate) {
        this.endOfProductionDate = endOfProductionDate;
    }

    public String getCateGory() {
        return this.cateGory;
    }

    public Inspection cateGory(String cateGory) {
        this.setCateGory(cateGory);
        return this;
    }

    public void setCateGory(String cateGory) {
        this.cateGory = cateGory;
    }

    public String getTechnicalFile() {
        return this.technicalFile;
    }

    public Inspection technicalFile(String technicalFile) {
        this.setTechnicalFile(technicalFile);
        return this;
    }

    public void setTechnicalFile(String technicalFile) {
        this.technicalFile = technicalFile;
    }

    public String getqCResult() {
        return this.qCResult;
    }

    public Inspection qCResult(String qCResult) {
        this.setqCResult(qCResult);
        return this;
    }

    public void setqCResult(String qCResult) {
        this.qCResult = qCResult;
    }

    public String getDocStatus() {
        return this.docStatus;
    }

    public Inspection docStatus(String docStatus) {
        this.setDocStatus(docStatus);
        return this;
    }

    public void setDocStatus(String docStatus) {
        this.docStatus = docStatus;
    }

    public String getGoodsReadyForPickUpDate() {
        return this.goodsReadyForPickUpDate;
    }

    public Inspection goodsReadyForPickUpDate(String goodsReadyForPickUpDate) {
        this.setGoodsReadyForPickUpDate(goodsReadyForPickUpDate);
        return this;
    }

    public void setGoodsReadyForPickUpDate(String goodsReadyForPickUpDate) {
        this.goodsReadyForPickUpDate = goodsReadyForPickUpDate;
    }

    public String getInspectionType() {
        return this.inspectionType;
    }

    public Inspection inspectionType(String inspectionType) {
        this.setInspectionType(inspectionType);
        return this;
    }

    public void setInspectionType(String inspectionType) {
        this.inspectionType = inspectionType;
    }

    public String getInspectionBookingStatus() {
        return this.inspectionBookingStatus;
    }

    public Inspection inspectionBookingStatus(String inspectionBookingStatus) {
        this.setInspectionBookingStatus(inspectionBookingStatus);
        return this;
    }

    public void setInspectionBookingStatus(String inspectionBookingStatus) {
        this.inspectionBookingStatus = inspectionBookingStatus;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Inspection)) {
            return false;
        }
        return id != null && id.equals(((Inspection) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Inspection{" +
            "id=" + getId() +
            ", itemName='" + getItemName() + "'" +
            ", itemId='" + getItemId() + "'" +
            ", boardId='" + getBoardId() + "'" +
            ", kingdeeId='" + getKingdeeId() + "'" +
            ", supplierName='" + getSupplierName() + "'" +
            ", email='" + getEmail() + "'" +
            ", inspectionDate='" + getInspectionDate() + "'" +
            ", endOfProductionDate='" + getEndOfProductionDate() + "'" +
            ", cateGory='" + getCateGory() + "'" +
            ", technicalFile='" + getTechnicalFile() + "'" +
            ", qCResult='" + getqCResult() + "'" +
            ", docStatus='" + getDocStatus() + "'" +
            ", goodsReadyForPickUpDate='" + getGoodsReadyForPickUpDate() + "'" +
            ", inspectionType='" + getInspectionType() + "'" +
            ", inspectionBookingStatus='" + getInspectionBookingStatus() + "'" +
            "}";
    }
}
