export interface IInspection {
  id?: number;
  itemName?: string | null;
  itemId?: string | null;
  boardId?: string | null;
  kingdeeId?: string | null;
  supplierName?: string | null;
  email?: string | null;
  inspectionDate?: string | null;
  endOfProductionDate?: string | null;
  cateGory?: string | null;
  technicalFile?: string | null;
  qCResult?: string | null;
  docStatus?: string | null;
  goodsReadyForPickUpDate?: string | null;
  inspectionType?: string | null;
  inspectionBookingStatus?: string | null;
}

export class Inspection implements IInspection {
  constructor(
    public id?: number,
    public itemName?: string | null,
    public itemId?: string | null,
    public boardId?: string | null,
    public kingdeeId?: string | null,
    public supplierName?: string | null,
    public email?: string | null,
    public inspectionDate?: string | null,
    public endOfProductionDate?: string | null,
    public cateGory?: string | null,
    public technicalFile?: string | null,
    public qCResult?: string | null,
    public docStatus?: string | null,
    public goodsReadyForPickUpDate?: string | null,
    public inspectionType?: string | null,
    public inspectionBookingStatus?: string | null
  ) {}
}
