export interface IProductFinished {
  id?: number;
  itemName?: string | null;
  itemId?: string | null;
  boardId?: string | null;
  kingdeeId?: string | null;
  supplier?: string | null;
  supplierEmail?: string | null;
  orderDate?: string | null;
  cateGory?: string | null;
  remark?: string | null;
  materialReceiptDate?: string | null;
}

export class ProductFinished implements IProductFinished {
  constructor(
    public id?: number,
    public itemName?: string | null,
    public itemId?: string | null,
    public boardId?: string | null,
    public kingdeeId?: string | null,
    public supplier?: string | null,
    public supplierEmail?: string | null,
    public orderDate?: string | null,
    public cateGory?: string | null,
    public remark?: string | null,
    public materialReceiptDate?: string | null
  ) {}
}
