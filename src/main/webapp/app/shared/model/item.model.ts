export interface IItem {
  id?: number;
  people?: string | null;
  itemStatus?: string | null;
  itemFranceName?: string | null;
  itemId?: string | null;
  boardId?: string | null;
  kingdeeId?: string | null;
  itemName?: string | null;
  parentItem?: string | null;
  codeP?: string | null;
  codeag?: string | null;
  mondayId?: string | null;
  dcsMerchandiser?: string | null;
  stockedInProdex?: string | null;
  supplier?: string | null;
  technicalDocuments?: string | null;
  certification?: string | null;
  opportunitySheet?: string | null;
  packingType?: string | null;
  salePackageImage?: string | null;
  cartonLengthMilimeter?: string | null;
  cartonHeightMilimeter?: string | null;
  portOfDeparture?: string | null;
  barcode?: string | null;
  cartonWeightKg?: string | null;
  cartonWeightGr?: string | null;
  cartonWidthMilimeter?: string | null;
  productionLeadtimeCommitmentsFromSuppliers?: string | null;
  negotiatedPrice?: string | null;
  productDescriptionAndFonctionalities?: string | null;
  drawing?: string | null;
  userManual?: string | null;
  supplierMarketingService?: string | null;
  palletSize?: string | null;
  typeOfMarketing?: string | null;
  productPic?: string | null;
  updateDate?: Date | null;
  subItems?: string | null;
  mirror?: string | null;
  label?: string | null;
  moqsPcsCommitment?: string | null;
  moqCommitment?: string | null;
  updatedMoqAfterNegotiation?: string | null;
  uom?: string | null;
  bom?: string | null;
  priceManagementStatus?: string | null;
  comment?: string | null;
  juneY?: string | null;
  commentsJuneY?: string | null;
  decemberY?: string | null;
  commentsDecemberY?: string | null;
  productTaxonomy?: string | null;
  validPeriod?: string | null;
  withTax?: string | null;
  unitPrice?: string | null;
  currency?: string | null;
}

export class Item implements IItem {
  constructor(
    public id?: number,
    public people?: string | null,
    public itemStatus?: string | null,
    public itemFranceName?: string | null,
    public itemId?: string | null,
    public boardId?: string | null,
    public kingdeeId?: string | null,
    public itemName?: string | null,
    public parentItem?: string | null,
    public codeP?: string | null,
    public codeag?: string | null,
    public mondayId?: string | null,
    public dcsMerchandiser?: string | null,
    public stockedInProdex?: string | null,
    public supplier?: string | null,
    public technicalDocuments?: string | null,
    public certification?: string | null,
    public opportunitySheet?: string | null,
    public packingType?: string | null,
    public salePackageImage?: string | null,
    public cartonLengthMilimeter?: string | null,
    public cartonHeightMilimeter?: string | null,
    public portOfDeparture?: string | null,
    public barcode?: string | null,
    public cartonWeightKg?: string | null,
    public cartonWeightGr?: string | null,
    public cartonWidthMilimeter?: string | null,
    public productionLeadtimeCommitmentsFromSuppliers?: string | null,
    public negotiatedPrice?: string | null,
    public productDescriptionAndFonctionalities?: string | null,
    public drawing?: string | null,
    public userManual?: string | null,
    public supplierMarketingService?: string | null,
    public palletSize?: string | null,
    public typeOfMarketing?: string | null,
    public productPic?: string | null,
    public updateDate?: Date | null,
    public subItems?: string | null,
    public mirror?: string | null,
    public label?: string | null,
    public moqsPcsCommitment?: string | null,
    public moqCommitment?: string | null,
    public updatedMoqAfterNegotiation?: string | null,
    public uom?: string | null,
    public bom?: string | null,
    public priceManagementStatus?: string | null,
    public comment?: string | null,
    public juneY?: string | null,
    public commentsJuneY?: string | null,
    public decemberY?: string | null,
    public commentsDecemberY?: string | null,
    public productTaxonomy?: string | null,
    public validPeriod?: string | null,
    public withTax?: string | null,
    public unitPrice?: string | null,
    public currency?: string | null
  ) {}
}
