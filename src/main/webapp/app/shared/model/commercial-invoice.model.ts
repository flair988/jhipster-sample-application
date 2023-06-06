export interface ICommercialInvoice {
  id?: number;
  itemName?: string | null;
  itemId?: string | null;
  boardId?: string | null;
  kingdeeId?: string | null;
  date?: string | null;
  client?: string | null;
  cateGory?: string | null;
  totalPrice?: string | null;
  currency?: string | null;
  remarks?: string | null;
}

export class CommercialInvoice implements ICommercialInvoice {
  constructor(
    public id?: number,
    public itemName?: string | null,
    public itemId?: string | null,
    public boardId?: string | null,
    public kingdeeId?: string | null,
    public date?: string | null,
    public client?: string | null,
    public cateGory?: string | null,
    public totalPrice?: string | null,
    public currency?: string | null,
    public remarks?: string | null
  ) {}
}
