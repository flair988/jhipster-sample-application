package com.mycompany.myapp.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Supplier.
 */
@Entity
@Table(name = "supplier")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "client")
    private String client;

    @Column(name = "parent_item")
    private String parentItem;

    @Column(name = "item_id")
    private String itemId;

    @Column(name = "board_id")
    private String boardId;

    @Column(name = "person")
    private String person;

    @Column(name = "category")
    private String category;

    @Column(name = "sub_category")
    private String subCategory;

    @Column(name = "supplier_status")
    private String supplierStatus;

    @Column(name = "cap_status")
    private String capStatus;

    @Column(name = "qualification_score")
    private String qualificationScore;

    @Column(name = "bope_score")
    private String bopeScore;

    @Column(name = "internal_supplier_id")
    private String internalSupplierId;

    @Column(name = "contact")
    private String contact;

    @Column(name = "contact_phone_number")
    private String contactPhoneNumber;

    @Column(name = "contact_email_address")
    private String contactEmailAddress;

    @Column(name = "country")
    private String country;

    @Column(name = "operation_site")
    private String operationSite;

    @Column(name = "address")
    private String address;

    @Column(name = "website")
    private String website;

    @Column(name = "product_taxonomy")
    private String productTaxonomy;

    @Column(name = "relation_starting_year")
    private String relationStartingYear;

    @Column(name = "business_license")
    private String businessLicense;

    @Column(name = "rex_origin_status")
    private String rexOriginStatus;

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;

    @Column(name = "item")
    private String item;

    @Column(name = "mirror")
    private String mirror;

    @Column(name = "sub_items")
    private String subItems;

    @Column(name = "owner")
    private String owner;

    @Column(name = "status")
    private String status;

    @Column(name = "date")
    private String date;

    @Column(name = "formula")
    private String formula;

    @Column(name = "kingdee_id")
    private String kingdeeId;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Supplier id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClient() {
        return this.client;
    }

    public Supplier client(String client) {
        this.setClient(client);
        return this;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getParentItem() {
        return this.parentItem;
    }

    public Supplier parentItem(String parentItem) {
        this.setParentItem(parentItem);
        return this;
    }

    public void setParentItem(String parentItem) {
        this.parentItem = parentItem;
    }

    public String getItemId() {
        return this.itemId;
    }

    public Supplier itemId(String itemId) {
        this.setItemId(itemId);
        return this;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getBoardId() {
        return this.boardId;
    }

    public Supplier boardId(String boardId) {
        this.setBoardId(boardId);
        return this;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public String getPerson() {
        return this.person;
    }

    public Supplier person(String person) {
        this.setPerson(person);
        return this;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getCategory() {
        return this.category;
    }

    public Supplier category(String category) {
        this.setCategory(category);
        return this;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return this.subCategory;
    }

    public Supplier subCategory(String subCategory) {
        this.setSubCategory(subCategory);
        return this;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getSupplierStatus() {
        return this.supplierStatus;
    }

    public Supplier supplierStatus(String supplierStatus) {
        this.setSupplierStatus(supplierStatus);
        return this;
    }

    public void setSupplierStatus(String supplierStatus) {
        this.supplierStatus = supplierStatus;
    }

    public String getCapStatus() {
        return this.capStatus;
    }

    public Supplier capStatus(String capStatus) {
        this.setCapStatus(capStatus);
        return this;
    }

    public void setCapStatus(String capStatus) {
        this.capStatus = capStatus;
    }

    public String getQualificationScore() {
        return this.qualificationScore;
    }

    public Supplier qualificationScore(String qualificationScore) {
        this.setQualificationScore(qualificationScore);
        return this;
    }

    public void setQualificationScore(String qualificationScore) {
        this.qualificationScore = qualificationScore;
    }

    public String getBopeScore() {
        return this.bopeScore;
    }

    public Supplier bopeScore(String bopeScore) {
        this.setBopeScore(bopeScore);
        return this;
    }

    public void setBopeScore(String bopeScore) {
        this.bopeScore = bopeScore;
    }

    public String getInternalSupplierId() {
        return this.internalSupplierId;
    }

    public Supplier internalSupplierId(String internalSupplierId) {
        this.setInternalSupplierId(internalSupplierId);
        return this;
    }

    public void setInternalSupplierId(String internalSupplierId) {
        this.internalSupplierId = internalSupplierId;
    }

    public String getContact() {
        return this.contact;
    }

    public Supplier contact(String contact) {
        this.setContact(contact);
        return this;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactPhoneNumber() {
        return this.contactPhoneNumber;
    }

    public Supplier contactPhoneNumber(String contactPhoneNumber) {
        this.setContactPhoneNumber(contactPhoneNumber);
        return this;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public String getContactEmailAddress() {
        return this.contactEmailAddress;
    }

    public Supplier contactEmailAddress(String contactEmailAddress) {
        this.setContactEmailAddress(contactEmailAddress);
        return this;
    }

    public void setContactEmailAddress(String contactEmailAddress) {
        this.contactEmailAddress = contactEmailAddress;
    }

    public String getCountry() {
        return this.country;
    }

    public Supplier country(String country) {
        this.setCountry(country);
        return this;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getOperationSite() {
        return this.operationSite;
    }

    public Supplier operationSite(String operationSite) {
        this.setOperationSite(operationSite);
        return this;
    }

    public void setOperationSite(String operationSite) {
        this.operationSite = operationSite;
    }

    public String getAddress() {
        return this.address;
    }

    public Supplier address(String address) {
        this.setAddress(address);
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return this.website;
    }

    public Supplier website(String website) {
        this.setWebsite(website);
        return this;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getProductTaxonomy() {
        return this.productTaxonomy;
    }

    public Supplier productTaxonomy(String productTaxonomy) {
        this.setProductTaxonomy(productTaxonomy);
        return this;
    }

    public void setProductTaxonomy(String productTaxonomy) {
        this.productTaxonomy = productTaxonomy;
    }

    public String getRelationStartingYear() {
        return this.relationStartingYear;
    }

    public Supplier relationStartingYear(String relationStartingYear) {
        this.setRelationStartingYear(relationStartingYear);
        return this;
    }

    public void setRelationStartingYear(String relationStartingYear) {
        this.relationStartingYear = relationStartingYear;
    }

    public String getBusinessLicense() {
        return this.businessLicense;
    }

    public Supplier businessLicense(String businessLicense) {
        this.setBusinessLicense(businessLicense);
        return this;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getRexOriginStatus() {
        return this.rexOriginStatus;
    }

    public Supplier rexOriginStatus(String rexOriginStatus) {
        this.setRexOriginStatus(rexOriginStatus);
        return this;
    }

    public void setRexOriginStatus(String rexOriginStatus) {
        this.rexOriginStatus = rexOriginStatus;
    }

    public LocalDate getCreateDate() {
        return this.createDate;
    }

    public Supplier createDate(LocalDate createDate) {
        this.setCreateDate(createDate);
        return this;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getUpdateDate() {
        return this.updateDate;
    }

    public Supplier updateDate(LocalDate updateDate) {
        this.setUpdateDate(updateDate);
        return this;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public String getItem() {
        return this.item;
    }

    public Supplier item(String item) {
        this.setItem(item);
        return this;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getMirror() {
        return this.mirror;
    }

    public Supplier mirror(String mirror) {
        this.setMirror(mirror);
        return this;
    }

    public void setMirror(String mirror) {
        this.mirror = mirror;
    }

    public String getSubItems() {
        return this.subItems;
    }

    public Supplier subItems(String subItems) {
        this.setSubItems(subItems);
        return this;
    }

    public void setSubItems(String subItems) {
        this.subItems = subItems;
    }

    public String getOwner() {
        return this.owner;
    }

    public Supplier owner(String owner) {
        this.setOwner(owner);
        return this;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getStatus() {
        return this.status;
    }

    public Supplier status(String status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return this.date;
    }

    public Supplier date(String date) {
        this.setDate(date);
        return this;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFormula() {
        return this.formula;
    }

    public Supplier formula(String formula) {
        this.setFormula(formula);
        return this;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getKingdeeId() {
        return this.kingdeeId;
    }

    public Supplier kingdeeId(String kingdeeId) {
        this.setKingdeeId(kingdeeId);
        return this;
    }

    public void setKingdeeId(String kingdeeId) {
        this.kingdeeId = kingdeeId;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Supplier)) {
            return false;
        }
        return id != null && id.equals(((Supplier) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Supplier{" +
            "id=" + getId() +
            ", client='" + getClient() + "'" +
            ", parentItem='" + getParentItem() + "'" +
            ", itemId='" + getItemId() + "'" +
            ", boardId='" + getBoardId() + "'" +
            ", person='" + getPerson() + "'" +
            ", category='" + getCategory() + "'" +
            ", subCategory='" + getSubCategory() + "'" +
            ", supplierStatus='" + getSupplierStatus() + "'" +
            ", capStatus='" + getCapStatus() + "'" +
            ", qualificationScore='" + getQualificationScore() + "'" +
            ", bopeScore='" + getBopeScore() + "'" +
            ", internalSupplierId='" + getInternalSupplierId() + "'" +
            ", contact='" + getContact() + "'" +
            ", contactPhoneNumber='" + getContactPhoneNumber() + "'" +
            ", contactEmailAddress='" + getContactEmailAddress() + "'" +
            ", country='" + getCountry() + "'" +
            ", operationSite='" + getOperationSite() + "'" +
            ", address='" + getAddress() + "'" +
            ", website='" + getWebsite() + "'" +
            ", productTaxonomy='" + getProductTaxonomy() + "'" +
            ", relationStartingYear='" + getRelationStartingYear() + "'" +
            ", businessLicense='" + getBusinessLicense() + "'" +
            ", rexOriginStatus='" + getRexOriginStatus() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", updateDate='" + getUpdateDate() + "'" +
            ", item='" + getItem() + "'" +
            ", mirror='" + getMirror() + "'" +
            ", subItems='" + getSubItems() + "'" +
            ", owner='" + getOwner() + "'" +
            ", status='" + getStatus() + "'" +
            ", date='" + getDate() + "'" +
            ", formula='" + getFormula() + "'" +
            ", kingdeeId='" + getKingdeeId() + "'" +
            "}";
    }
}
