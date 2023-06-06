export interface IPI {
  id?: number;
  itemName?: string | null;
  itemCode?: string | null;
  poNumber?: string | null;
  isNewItem?: string | null;
  category?: string | null;
  client?: string | null;
  supplier?: string | null;
  supplierCode?: string | null;
  orderDate?: string | null;
  port?: string | null;
  requestedEndOfProdDate?: string | null;
  itemQuantity?: string | null;
  countryOfOrigin?: string | null;
  countryOfFinalDestination?: string | null;
  productionLeadTimeCommitment?: string | null;
  consignee?: string | null;
  carriageBy?: string | null;
  termsOfDelivery?: string | null;
  termsOfPayment?: string | null;
  itemUnit?: string | null;
  rate?: string | null;
  amount?: string | null;
  totalAmount?: string | null;
  discountRate?: string | null;
  currency?: string | null;
  piStatus?: string | null;
  remarks?: string | null;
  itemId?: string | null;
  boardId?: string | null;
  kingdeeId?: string | null;
  portOfDischarge?: string | null;
  portOfLoading?: string | null;
}

export class PI implements IPI {
  constructor(
    public id?: number,
    public itemName?: string | null,
    public itemCode?: string | null,
    public poNumber?: string | null,
    public isNewItem?: string | null,
    public category?: string | null,
    public client?: string | null,
    public supplier?: string | null,
    public supplierCode?: string | null,
    public orderDate?: string | null,
    public port?: string | null,
    public requestedEndOfProdDate?: string | null,
    public itemQuantity?: string | null,
    public countryOfOrigin?: string | null,
    public countryOfFinalDestination?: string | null,
    public productionLeadTimeCommitment?: string | null,
    public consignee?: string | null,
    public carriageBy?: string | null,
    public termsOfDelivery?: string | null,
    public termsOfPayment?: string | null,
    public itemUnit?: string | null,
    public rate?: string | null,
    public amount?: string | null,
    public totalAmount?: string | null,
    public discountRate?: string | null,
    public currency?: string | null,
    public piStatus?: string | null,
    public remarks?: string | null,
    public itemId?: string | null,
    public boardId?: string | null,
    public kingdeeId?: string | null,
    public portOfDischarge?: string | null,
    public portOfLoading?: string | null
  ) {}
}
