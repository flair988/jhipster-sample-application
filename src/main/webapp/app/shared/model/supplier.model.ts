export interface ISupplier {
  id?: number;
  client?: string | null;
  parentItem?: string | null;
  itemId?: string | null;
  boardId?: string | null;
  person?: string | null;
  category?: string | null;
  subCategory?: string | null;
  supplierStatus?: string | null;
  capStatus?: string | null;
  qualificationScore?: string | null;
  bopeScore?: string | null;
  internalSupplierId?: string | null;
  contact?: string | null;
  contactPhoneNumber?: string | null;
  contactEmailAddress?: string | null;
  country?: string | null;
  operationSite?: string | null;
  address?: string | null;
  website?: string | null;
  productTaxonomy?: string | null;
  relationStartingYear?: string | null;
  businessLicense?: string | null;
  rexOriginStatus?: string | null;
  createDate?: Date | null;
  updateDate?: Date | null;
  item?: string | null;
  mirror?: string | null;
  subItems?: string | null;
  owner?: string | null;
  status?: string | null;
  date?: string | null;
  formula?: string | null;
  kingdeeId?: string | null;
}

export class Supplier implements ISupplier {
  constructor(
    public id?: number,
    public client?: string | null,
    public parentItem?: string | null,
    public itemId?: string | null,
    public boardId?: string | null,
    public person?: string | null,
    public category?: string | null,
    public subCategory?: string | null,
    public supplierStatus?: string | null,
    public capStatus?: string | null,
    public qualificationScore?: string | null,
    public bopeScore?: string | null,
    public internalSupplierId?: string | null,
    public contact?: string | null,
    public contactPhoneNumber?: string | null,
    public contactEmailAddress?: string | null,
    public country?: string | null,
    public operationSite?: string | null,
    public address?: string | null,
    public website?: string | null,
    public productTaxonomy?: string | null,
    public relationStartingYear?: string | null,
    public businessLicense?: string | null,
    public rexOriginStatus?: string | null,
    public createDate?: Date | null,
    public updateDate?: Date | null,
    public item?: string | null,
    public mirror?: string | null,
    public subItems?: string | null,
    public owner?: string | null,
    public status?: string | null,
    public date?: string | null,
    public formula?: string | null,
    public kingdeeId?: string | null
  ) {}
}
