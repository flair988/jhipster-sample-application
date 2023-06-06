package com.mycompany.myapp.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Item.
 */
@Entity
@Table(name = "item")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "people")
    private String people;

    @Column(name = "item_status")
    private String itemStatus;

    @Column(name = "item_france_name")
    private String itemFranceName;

    @Column(name = "item_id")
    private String itemId;

    @Column(name = "board_id")
    private String boardId;

    @Column(name = "kingdee_id")
    private String kingdeeId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "parent_item")
    private String parentItem;

    @Column(name = "code_p")
    private String codeP;

    @Column(name = "codeag")
    private String codeag;

    @Column(name = "monday_id")
    private String mondayId;

    @Column(name = "dcs_merchandiser")
    private String dcsMerchandiser;

    @Column(name = "stocked_in_prodex")
    private String stockedInProdex;

    @Column(name = "supplier")
    private String supplier;

    @Column(name = "technical_documents")
    private String technicalDocuments;

    @Column(name = "certification")
    private String certification;

    @Column(name = "opportunity_sheet")
    private String opportunitySheet;

    @Column(name = "packing_type")
    private String packingType;

    @Column(name = "sale_package_image")
    private String salePackageImage;

    @Column(name = "carton_length_milimeter")
    private String cartonLengthMilimeter;

    @Column(name = "carton_height_milimeter")
    private String cartonHeightMilimeter;

    @Column(name = "port_of_departure")
    private String portOfDeparture;

    @Column(name = "barcode")
    private String barcode;

    @Column(name = "carton_weight_kg")
    private String cartonWeightKg;

    @Column(name = "carton_weight_gr")
    private String cartonWeightGr;

    @Column(name = "carton_width_milimeter")
    private String cartonWidthMilimeter;

    @Column(name = "production_leadtime_commitments_from_suppliers")
    private String productionLeadtimeCommitmentsFromSuppliers;

    @Column(name = "negotiated_price")
    private String negotiatedPrice;

    @Column(name = "product_description_and_fonctionalities")
    private String productDescriptionAndFonctionalities;

    @Column(name = "drawing")
    private String drawing;

    @Column(name = "user_manual")
    private String userManual;

    @Column(name = "supplier_marketing_service")
    private String supplierMarketingService;

    @Column(name = "pallet_size")
    private String palletSize;

    @Column(name = "type_of_marketing")
    private String typeOfMarketing;

    @Column(name = "product_pic")
    private String productPic;

    @Column(name = "update_date")
    private LocalDate updateDate;

    @Column(name = "sub_items")
    private String subItems;

    @Column(name = "mirror")
    private String mirror;

    @Column(name = "label")
    private String label;

    @Column(name = "moqs_pcs_commitment")
    private String moqsPcsCommitment;

    @Column(name = "moq_commitment")
    private String moqCommitment;

    @Column(name = "updated_moq_after_negotiation")
    private String updatedMoqAfterNegotiation;

    @Column(name = "uom")
    private String uom;

    @Column(name = "bom")
    private String bom;

    @Column(name = "price_management_status")
    private String priceManagementStatus;

    @Column(name = "comment")
    private String comment;

    @Column(name = "june_y")
    private String juneY;

    @Column(name = "comments_june_y")
    private String commentsJuneY;

    @Column(name = "december_y")
    private String decemberY;

    @Column(name = "comments_december_y")
    private String commentsDecemberY;

    @Column(name = "product_taxonomy")
    private String productTaxonomy;

    @Column(name = "valid_period")
    private String validPeriod;

    @Column(name = "with_tax")
    private String withTax;

    @Column(name = "unit_price")
    private String unitPrice;

    @Column(name = "currency")
    private String currency;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Item id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPeople() {
        return this.people;
    }

    public Item people(String people) {
        this.setPeople(people);
        return this;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getItemStatus() {
        return this.itemStatus;
    }

    public Item itemStatus(String itemStatus) {
        this.setItemStatus(itemStatus);
        return this;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    public String getItemFranceName() {
        return this.itemFranceName;
    }

    public Item itemFranceName(String itemFranceName) {
        this.setItemFranceName(itemFranceName);
        return this;
    }

    public void setItemFranceName(String itemFranceName) {
        this.itemFranceName = itemFranceName;
    }

    public String getItemId() {
        return this.itemId;
    }

    public Item itemId(String itemId) {
        this.setItemId(itemId);
        return this;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getBoardId() {
        return this.boardId;
    }

    public Item boardId(String boardId) {
        this.setBoardId(boardId);
        return this;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public String getKingdeeId() {
        return this.kingdeeId;
    }

    public Item kingdeeId(String kingdeeId) {
        this.setKingdeeId(kingdeeId);
        return this;
    }

    public void setKingdeeId(String kingdeeId) {
        this.kingdeeId = kingdeeId;
    }

    public String getItemName() {
        return this.itemName;
    }

    public Item itemName(String itemName) {
        this.setItemName(itemName);
        return this;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getParentItem() {
        return this.parentItem;
    }

    public Item parentItem(String parentItem) {
        this.setParentItem(parentItem);
        return this;
    }

    public void setParentItem(String parentItem) {
        this.parentItem = parentItem;
    }

    public String getCodeP() {
        return this.codeP;
    }

    public Item codeP(String codeP) {
        this.setCodeP(codeP);
        return this;
    }

    public void setCodeP(String codeP) {
        this.codeP = codeP;
    }

    public String getCodeag() {
        return this.codeag;
    }

    public Item codeag(String codeag) {
        this.setCodeag(codeag);
        return this;
    }

    public void setCodeag(String codeag) {
        this.codeag = codeag;
    }

    public String getMondayId() {
        return this.mondayId;
    }

    public Item mondayId(String mondayId) {
        this.setMondayId(mondayId);
        return this;
    }

    public void setMondayId(String mondayId) {
        this.mondayId = mondayId;
    }

    public String getDcsMerchandiser() {
        return this.dcsMerchandiser;
    }

    public Item dcsMerchandiser(String dcsMerchandiser) {
        this.setDcsMerchandiser(dcsMerchandiser);
        return this;
    }

    public void setDcsMerchandiser(String dcsMerchandiser) {
        this.dcsMerchandiser = dcsMerchandiser;
    }

    public String getStockedInProdex() {
        return this.stockedInProdex;
    }

    public Item stockedInProdex(String stockedInProdex) {
        this.setStockedInProdex(stockedInProdex);
        return this;
    }

    public void setStockedInProdex(String stockedInProdex) {
        this.stockedInProdex = stockedInProdex;
    }

    public String getSupplier() {
        return this.supplier;
    }

    public Item supplier(String supplier) {
        this.setSupplier(supplier);
        return this;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getTechnicalDocuments() {
        return this.technicalDocuments;
    }

    public Item technicalDocuments(String technicalDocuments) {
        this.setTechnicalDocuments(technicalDocuments);
        return this;
    }

    public void setTechnicalDocuments(String technicalDocuments) {
        this.technicalDocuments = technicalDocuments;
    }

    public String getCertification() {
        return this.certification;
    }

    public Item certification(String certification) {
        this.setCertification(certification);
        return this;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getOpportunitySheet() {
        return this.opportunitySheet;
    }

    public Item opportunitySheet(String opportunitySheet) {
        this.setOpportunitySheet(opportunitySheet);
        return this;
    }

    public void setOpportunitySheet(String opportunitySheet) {
        this.opportunitySheet = opportunitySheet;
    }

    public String getPackingType() {
        return this.packingType;
    }

    public Item packingType(String packingType) {
        this.setPackingType(packingType);
        return this;
    }

    public void setPackingType(String packingType) {
        this.packingType = packingType;
    }

    public String getSalePackageImage() {
        return this.salePackageImage;
    }

    public Item salePackageImage(String salePackageImage) {
        this.setSalePackageImage(salePackageImage);
        return this;
    }

    public void setSalePackageImage(String salePackageImage) {
        this.salePackageImage = salePackageImage;
    }

    public String getCartonLengthMilimeter() {
        return this.cartonLengthMilimeter;
    }

    public Item cartonLengthMilimeter(String cartonLengthMilimeter) {
        this.setCartonLengthMilimeter(cartonLengthMilimeter);
        return this;
    }

    public void setCartonLengthMilimeter(String cartonLengthMilimeter) {
        this.cartonLengthMilimeter = cartonLengthMilimeter;
    }

    public String getCartonHeightMilimeter() {
        return this.cartonHeightMilimeter;
    }

    public Item cartonHeightMilimeter(String cartonHeightMilimeter) {
        this.setCartonHeightMilimeter(cartonHeightMilimeter);
        return this;
    }

    public void setCartonHeightMilimeter(String cartonHeightMilimeter) {
        this.cartonHeightMilimeter = cartonHeightMilimeter;
    }

    public String getPortOfDeparture() {
        return this.portOfDeparture;
    }

    public Item portOfDeparture(String portOfDeparture) {
        this.setPortOfDeparture(portOfDeparture);
        return this;
    }

    public void setPortOfDeparture(String portOfDeparture) {
        this.portOfDeparture = portOfDeparture;
    }

    public String getBarcode() {
        return this.barcode;
    }

    public Item barcode(String barcode) {
        this.setBarcode(barcode);
        return this;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getCartonWeightKg() {
        return this.cartonWeightKg;
    }

    public Item cartonWeightKg(String cartonWeightKg) {
        this.setCartonWeightKg(cartonWeightKg);
        return this;
    }

    public void setCartonWeightKg(String cartonWeightKg) {
        this.cartonWeightKg = cartonWeightKg;
    }

    public String getCartonWeightGr() {
        return this.cartonWeightGr;
    }

    public Item cartonWeightGr(String cartonWeightGr) {
        this.setCartonWeightGr(cartonWeightGr);
        return this;
    }

    public void setCartonWeightGr(String cartonWeightGr) {
        this.cartonWeightGr = cartonWeightGr;
    }

    public String getCartonWidthMilimeter() {
        return this.cartonWidthMilimeter;
    }

    public Item cartonWidthMilimeter(String cartonWidthMilimeter) {
        this.setCartonWidthMilimeter(cartonWidthMilimeter);
        return this;
    }

    public void setCartonWidthMilimeter(String cartonWidthMilimeter) {
        this.cartonWidthMilimeter = cartonWidthMilimeter;
    }

    public String getProductionLeadtimeCommitmentsFromSuppliers() {
        return this.productionLeadtimeCommitmentsFromSuppliers;
    }

    public Item productionLeadtimeCommitmentsFromSuppliers(String productionLeadtimeCommitmentsFromSuppliers) {
        this.setProductionLeadtimeCommitmentsFromSuppliers(productionLeadtimeCommitmentsFromSuppliers);
        return this;
    }

    public void setProductionLeadtimeCommitmentsFromSuppliers(String productionLeadtimeCommitmentsFromSuppliers) {
        this.productionLeadtimeCommitmentsFromSuppliers = productionLeadtimeCommitmentsFromSuppliers;
    }

    public String getNegotiatedPrice() {
        return this.negotiatedPrice;
    }

    public Item negotiatedPrice(String negotiatedPrice) {
        this.setNegotiatedPrice(negotiatedPrice);
        return this;
    }

    public void setNegotiatedPrice(String negotiatedPrice) {
        this.negotiatedPrice = negotiatedPrice;
    }

    public String getProductDescriptionAndFonctionalities() {
        return this.productDescriptionAndFonctionalities;
    }

    public Item productDescriptionAndFonctionalities(String productDescriptionAndFonctionalities) {
        this.setProductDescriptionAndFonctionalities(productDescriptionAndFonctionalities);
        return this;
    }

    public void setProductDescriptionAndFonctionalities(String productDescriptionAndFonctionalities) {
        this.productDescriptionAndFonctionalities = productDescriptionAndFonctionalities;
    }

    public String getDrawing() {
        return this.drawing;
    }

    public Item drawing(String drawing) {
        this.setDrawing(drawing);
        return this;
    }

    public void setDrawing(String drawing) {
        this.drawing = drawing;
    }

    public String getUserManual() {
        return this.userManual;
    }

    public Item userManual(String userManual) {
        this.setUserManual(userManual);
        return this;
    }

    public void setUserManual(String userManual) {
        this.userManual = userManual;
    }

    public String getSupplierMarketingService() {
        return this.supplierMarketingService;
    }

    public Item supplierMarketingService(String supplierMarketingService) {
        this.setSupplierMarketingService(supplierMarketingService);
        return this;
    }

    public void setSupplierMarketingService(String supplierMarketingService) {
        this.supplierMarketingService = supplierMarketingService;
    }

    public String getPalletSize() {
        return this.palletSize;
    }

    public Item palletSize(String palletSize) {
        this.setPalletSize(palletSize);
        return this;
    }

    public void setPalletSize(String palletSize) {
        this.palletSize = palletSize;
    }

    public String getTypeOfMarketing() {
        return this.typeOfMarketing;
    }

    public Item typeOfMarketing(String typeOfMarketing) {
        this.setTypeOfMarketing(typeOfMarketing);
        return this;
    }

    public void setTypeOfMarketing(String typeOfMarketing) {
        this.typeOfMarketing = typeOfMarketing;
    }

    public String getProductPic() {
        return this.productPic;
    }

    public Item productPic(String productPic) {
        this.setProductPic(productPic);
        return this;
    }

    public void setProductPic(String productPic) {
        this.productPic = productPic;
    }

    public LocalDate getUpdateDate() {
        return this.updateDate;
    }

    public Item updateDate(LocalDate updateDate) {
        this.setUpdateDate(updateDate);
        return this;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public String getSubItems() {
        return this.subItems;
    }

    public Item subItems(String subItems) {
        this.setSubItems(subItems);
        return this;
    }

    public void setSubItems(String subItems) {
        this.subItems = subItems;
    }

    public String getMirror() {
        return this.mirror;
    }

    public Item mirror(String mirror) {
        this.setMirror(mirror);
        return this;
    }

    public void setMirror(String mirror) {
        this.mirror = mirror;
    }

    public String getLabel() {
        return this.label;
    }

    public Item label(String label) {
        this.setLabel(label);
        return this;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getMoqsPcsCommitment() {
        return this.moqsPcsCommitment;
    }

    public Item moqsPcsCommitment(String moqsPcsCommitment) {
        this.setMoqsPcsCommitment(moqsPcsCommitment);
        return this;
    }

    public void setMoqsPcsCommitment(String moqsPcsCommitment) {
        this.moqsPcsCommitment = moqsPcsCommitment;
    }

    public String getMoqCommitment() {
        return this.moqCommitment;
    }

    public Item moqCommitment(String moqCommitment) {
        this.setMoqCommitment(moqCommitment);
        return this;
    }

    public void setMoqCommitment(String moqCommitment) {
        this.moqCommitment = moqCommitment;
    }

    public String getUpdatedMoqAfterNegotiation() {
        return this.updatedMoqAfterNegotiation;
    }

    public Item updatedMoqAfterNegotiation(String updatedMoqAfterNegotiation) {
        this.setUpdatedMoqAfterNegotiation(updatedMoqAfterNegotiation);
        return this;
    }

    public void setUpdatedMoqAfterNegotiation(String updatedMoqAfterNegotiation) {
        this.updatedMoqAfterNegotiation = updatedMoqAfterNegotiation;
    }

    public String getUom() {
        return this.uom;
    }

    public Item uom(String uom) {
        this.setUom(uom);
        return this;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public String getBom() {
        return this.bom;
    }

    public Item bom(String bom) {
        this.setBom(bom);
        return this;
    }

    public void setBom(String bom) {
        this.bom = bom;
    }

    public String getPriceManagementStatus() {
        return this.priceManagementStatus;
    }

    public Item priceManagementStatus(String priceManagementStatus) {
        this.setPriceManagementStatus(priceManagementStatus);
        return this;
    }

    public void setPriceManagementStatus(String priceManagementStatus) {
        this.priceManagementStatus = priceManagementStatus;
    }

    public String getComment() {
        return this.comment;
    }

    public Item comment(String comment) {
        this.setComment(comment);
        return this;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getJuneY() {
        return this.juneY;
    }

    public Item juneY(String juneY) {
        this.setJuneY(juneY);
        return this;
    }

    public void setJuneY(String juneY) {
        this.juneY = juneY;
    }

    public String getCommentsJuneY() {
        return this.commentsJuneY;
    }

    public Item commentsJuneY(String commentsJuneY) {
        this.setCommentsJuneY(commentsJuneY);
        return this;
    }

    public void setCommentsJuneY(String commentsJuneY) {
        this.commentsJuneY = commentsJuneY;
    }

    public String getDecemberY() {
        return this.decemberY;
    }

    public Item decemberY(String decemberY) {
        this.setDecemberY(decemberY);
        return this;
    }

    public void setDecemberY(String decemberY) {
        this.decemberY = decemberY;
    }

    public String getCommentsDecemberY() {
        return this.commentsDecemberY;
    }

    public Item commentsDecemberY(String commentsDecemberY) {
        this.setCommentsDecemberY(commentsDecemberY);
        return this;
    }

    public void setCommentsDecemberY(String commentsDecemberY) {
        this.commentsDecemberY = commentsDecemberY;
    }

    public String getProductTaxonomy() {
        return this.productTaxonomy;
    }

    public Item productTaxonomy(String productTaxonomy) {
        this.setProductTaxonomy(productTaxonomy);
        return this;
    }

    public void setProductTaxonomy(String productTaxonomy) {
        this.productTaxonomy = productTaxonomy;
    }

    public String getValidPeriod() {
        return this.validPeriod;
    }

    public Item validPeriod(String validPeriod) {
        this.setValidPeriod(validPeriod);
        return this;
    }

    public void setValidPeriod(String validPeriod) {
        this.validPeriod = validPeriod;
    }

    public String getWithTax() {
        return this.withTax;
    }

    public Item withTax(String withTax) {
        this.setWithTax(withTax);
        return this;
    }

    public void setWithTax(String withTax) {
        this.withTax = withTax;
    }

    public String getUnitPrice() {
        return this.unitPrice;
    }

    public Item unitPrice(String unitPrice) {
        this.setUnitPrice(unitPrice);
        return this;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getCurrency() {
        return this.currency;
    }

    public Item currency(String currency) {
        this.setCurrency(currency);
        return this;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Item)) {
            return false;
        }
        return id != null && id.equals(((Item) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Item{" +
            "id=" + getId() +
            ", people='" + getPeople() + "'" +
            ", itemStatus='" + getItemStatus() + "'" +
            ", itemFranceName='" + getItemFranceName() + "'" +
            ", itemId='" + getItemId() + "'" +
            ", boardId='" + getBoardId() + "'" +
            ", kingdeeId='" + getKingdeeId() + "'" +
            ", itemName='" + getItemName() + "'" +
            ", parentItem='" + getParentItem() + "'" +
            ", codeP='" + getCodeP() + "'" +
            ", codeag='" + getCodeag() + "'" +
            ", mondayId='" + getMondayId() + "'" +
            ", dcsMerchandiser='" + getDcsMerchandiser() + "'" +
            ", stockedInProdex='" + getStockedInProdex() + "'" +
            ", supplier='" + getSupplier() + "'" +
            ", technicalDocuments='" + getTechnicalDocuments() + "'" +
            ", certification='" + getCertification() + "'" +
            ", opportunitySheet='" + getOpportunitySheet() + "'" +
            ", packingType='" + getPackingType() + "'" +
            ", salePackageImage='" + getSalePackageImage() + "'" +
            ", cartonLengthMilimeter='" + getCartonLengthMilimeter() + "'" +
            ", cartonHeightMilimeter='" + getCartonHeightMilimeter() + "'" +
            ", portOfDeparture='" + getPortOfDeparture() + "'" +
            ", barcode='" + getBarcode() + "'" +
            ", cartonWeightKg='" + getCartonWeightKg() + "'" +
            ", cartonWeightGr='" + getCartonWeightGr() + "'" +
            ", cartonWidthMilimeter='" + getCartonWidthMilimeter() + "'" +
            ", productionLeadtimeCommitmentsFromSuppliers='" + getProductionLeadtimeCommitmentsFromSuppliers() + "'" +
            ", negotiatedPrice='" + getNegotiatedPrice() + "'" +
            ", productDescriptionAndFonctionalities='" + getProductDescriptionAndFonctionalities() + "'" +
            ", drawing='" + getDrawing() + "'" +
            ", userManual='" + getUserManual() + "'" +
            ", supplierMarketingService='" + getSupplierMarketingService() + "'" +
            ", palletSize='" + getPalletSize() + "'" +
            ", typeOfMarketing='" + getTypeOfMarketing() + "'" +
            ", productPic='" + getProductPic() + "'" +
            ", updateDate='" + getUpdateDate() + "'" +
            ", subItems='" + getSubItems() + "'" +
            ", mirror='" + getMirror() + "'" +
            ", label='" + getLabel() + "'" +
            ", moqsPcsCommitment='" + getMoqsPcsCommitment() + "'" +
            ", moqCommitment='" + getMoqCommitment() + "'" +
            ", updatedMoqAfterNegotiation='" + getUpdatedMoqAfterNegotiation() + "'" +
            ", uom='" + getUom() + "'" +
            ", bom='" + getBom() + "'" +
            ", priceManagementStatus='" + getPriceManagementStatus() + "'" +
            ", comment='" + getComment() + "'" +
            ", juneY='" + getJuneY() + "'" +
            ", commentsJuneY='" + getCommentsJuneY() + "'" +
            ", decemberY='" + getDecemberY() + "'" +
            ", commentsDecemberY='" + getCommentsDecemberY() + "'" +
            ", productTaxonomy='" + getProductTaxonomy() + "'" +
            ", validPeriod='" + getValidPeriod() + "'" +
            ", withTax='" + getWithTax() + "'" +
            ", unitPrice='" + getUnitPrice() + "'" +
            ", currency='" + getCurrency() + "'" +
            "}";
    }
}
