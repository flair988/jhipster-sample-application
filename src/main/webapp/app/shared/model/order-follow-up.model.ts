export interface IOrderFollowUp {
  id?: number;
  itemId?: string | null;
  poNumber?: string | null;
  customer?: string | null;
  supplier?: string | null;
  orderDate?: string | null;
  cateGory?: string | null;
  inspectionDate?: string | null;
  requestEndOfProdDate?: string | null;
  totalAmount?: string | null;
  totalDiscount?: string | null;
  disCountRate?: string | null;
  regularCheck?: string | null;
  etd?: string | null;
  atd?: string | null;
  eta?: string | null;
  updatedEta?: string | null;
  forwarder?: string | null;
  documentStatus?: string | null;
  customInstruction?: string | null;
  customInspection?: string | null;
  depositPaymentDate?: string | null;
  balanceOfTotalPaymentDate?: string | null;
  amountDepositPayment?: string | null;
  amountPayment?: string | null;
  dcMember?: string | null;
  comment?: string | null;
  itemName?: string | null;
  boardId?: string | null;
  kingdeeId?: string | null;
  parentKingdeeId?: string | null;
  parentMondayId?: string | null;
  qty?: string | null;
  itemCode?: string | null;
  amount?: string | null;
  discount?: string | null;
  unit?: string | null;
  contractEndOfProdDate?: string | null;
}

export class OrderFollowUp implements IOrderFollowUp {
  constructor(
    public id?: number,
    public itemId?: string | null,
    public poNumber?: string | null,
    public customer?: string | null,
    public supplier?: string | null,
    public orderDate?: string | null,
    public cateGory?: string | null,
    public inspectionDate?: string | null,
    public requestEndOfProdDate?: string | null,
    public totalAmount?: string | null,
    public totalDiscount?: string | null,
    public disCountRate?: string | null,
    public regularCheck?: string | null,
    public etd?: string | null,
    public atd?: string | null,
    public eta?: string | null,
    public updatedEta?: string | null,
    public forwarder?: string | null,
    public documentStatus?: string | null,
    public customInstruction?: string | null,
    public customInspection?: string | null,
    public depositPaymentDate?: string | null,
    public balanceOfTotalPaymentDate?: string | null,
    public amountDepositPayment?: string | null,
    public amountPayment?: string | null,
    public dcMember?: string | null,
    public comment?: string | null,
    public itemName?: string | null,
    public boardId?: string | null,
    public kingdeeId?: string | null,
    public parentKingdeeId?: string | null,
    public parentMondayId?: string | null,
    public qty?: string | null,
    public itemCode?: string | null,
    public amount?: string | null,
    public discount?: string | null,
    public unit?: string | null,
    public contractEndOfProdDate?: string | null
  ) {}
}
