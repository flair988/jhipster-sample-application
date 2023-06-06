/* tslint:disable max-line-length */
import axios from 'axios';
import sinon from 'sinon';

import OrderFollowUpService from '@/entities/order-follow-up/order-follow-up.service';
import { OrderFollowUp } from '@/shared/model/order-follow-up.model';

const error = {
  response: {
    status: null,
    data: {
      type: null,
    },
  },
};

const axiosStub = {
  get: sinon.stub(axios, 'get'),
  post: sinon.stub(axios, 'post'),
  put: sinon.stub(axios, 'put'),
  patch: sinon.stub(axios, 'patch'),
  delete: sinon.stub(axios, 'delete'),
};

describe('Service Tests', () => {
  describe('OrderFollowUp Service', () => {
    let service: OrderFollowUpService;
    let elemDefault;

    beforeEach(() => {
      service = new OrderFollowUpService();
      elemDefault = new OrderFollowUp(
        123,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA'
      );
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign({}, elemDefault);
        axiosStub.get.resolves({ data: returnedFromService });

        return service.find(123).then(res => {
          expect(res).toMatchObject(elemDefault);
        });
      });

      it('should not find an element', async () => {
        axiosStub.get.rejects(error);
        return service
          .find(123)
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should create a OrderFollowUp', async () => {
        const returnedFromService = Object.assign(
          {
            id: 123,
          },
          elemDefault
        );
        const expected = Object.assign({}, returnedFromService);

        axiosStub.post.resolves({ data: returnedFromService });
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not create a OrderFollowUp', async () => {
        axiosStub.post.rejects(error);

        return service
          .create({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should update a OrderFollowUp', async () => {
        const returnedFromService = Object.assign(
          {
            itemId: 'BBBBBB',
            poNumber: 'BBBBBB',
            customer: 'BBBBBB',
            supplier: 'BBBBBB',
            orderDate: 'BBBBBB',
            cateGory: 'BBBBBB',
            inspectionDate: 'BBBBBB',
            requestEndOfProdDate: 'BBBBBB',
            totalAmount: 'BBBBBB',
            totalDiscount: 'BBBBBB',
            disCountRate: 'BBBBBB',
            regularCheck: 'BBBBBB',
            etd: 'BBBBBB',
            atd: 'BBBBBB',
            eta: 'BBBBBB',
            updatedEta: 'BBBBBB',
            forwarder: 'BBBBBB',
            documentStatus: 'BBBBBB',
            customInstruction: 'BBBBBB',
            customInspection: 'BBBBBB',
            depositPaymentDate: 'BBBBBB',
            balanceOfTotalPaymentDate: 'BBBBBB',
            amountDepositPayment: 'BBBBBB',
            amountPayment: 'BBBBBB',
            dcMember: 'BBBBBB',
            comment: 'BBBBBB',
            itemName: 'BBBBBB',
            boardId: 'BBBBBB',
            kingdeeId: 'BBBBBB',
            parentKingdeeId: 'BBBBBB',
            parentMondayId: 'BBBBBB',
            qty: 'BBBBBB',
            itemCode: 'BBBBBB',
            amount: 'BBBBBB',
            discount: 'BBBBBB',
            unit: 'BBBBBB',
            contractEndOfProdDate: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);
        axiosStub.put.resolves({ data: returnedFromService });

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not update a OrderFollowUp', async () => {
        axiosStub.put.rejects(error);

        return service
          .update({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should partial update a OrderFollowUp', async () => {
        const patchObject = Object.assign(
          {
            itemId: 'BBBBBB',
            customer: 'BBBBBB',
            orderDate: 'BBBBBB',
            inspectionDate: 'BBBBBB',
            totalDiscount: 'BBBBBB',
            disCountRate: 'BBBBBB',
            atd: 'BBBBBB',
            forwarder: 'BBBBBB',
            customInspection: 'BBBBBB',
            depositPaymentDate: 'BBBBBB',
            balanceOfTotalPaymentDate: 'BBBBBB',
            amountPayment: 'BBBBBB',
            comment: 'BBBBBB',
            itemName: 'BBBBBB',
            boardId: 'BBBBBB',
            kingdeeId: 'BBBBBB',
            parentMondayId: 'BBBBBB',
            qty: 'BBBBBB',
            itemCode: 'BBBBBB',
            amount: 'BBBBBB',
          },
          new OrderFollowUp()
        );
        const returnedFromService = Object.assign(patchObject, elemDefault);

        const expected = Object.assign({}, returnedFromService);
        axiosStub.patch.resolves({ data: returnedFromService });

        return service.partialUpdate(patchObject).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not partial update a OrderFollowUp', async () => {
        axiosStub.patch.rejects(error);

        return service
          .partialUpdate({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of OrderFollowUp', async () => {
        const returnedFromService = Object.assign(
          {
            itemId: 'BBBBBB',
            poNumber: 'BBBBBB',
            customer: 'BBBBBB',
            supplier: 'BBBBBB',
            orderDate: 'BBBBBB',
            cateGory: 'BBBBBB',
            inspectionDate: 'BBBBBB',
            requestEndOfProdDate: 'BBBBBB',
            totalAmount: 'BBBBBB',
            totalDiscount: 'BBBBBB',
            disCountRate: 'BBBBBB',
            regularCheck: 'BBBBBB',
            etd: 'BBBBBB',
            atd: 'BBBBBB',
            eta: 'BBBBBB',
            updatedEta: 'BBBBBB',
            forwarder: 'BBBBBB',
            documentStatus: 'BBBBBB',
            customInstruction: 'BBBBBB',
            customInspection: 'BBBBBB',
            depositPaymentDate: 'BBBBBB',
            balanceOfTotalPaymentDate: 'BBBBBB',
            amountDepositPayment: 'BBBBBB',
            amountPayment: 'BBBBBB',
            dcMember: 'BBBBBB',
            comment: 'BBBBBB',
            itemName: 'BBBBBB',
            boardId: 'BBBBBB',
            kingdeeId: 'BBBBBB',
            parentKingdeeId: 'BBBBBB',
            parentMondayId: 'BBBBBB',
            qty: 'BBBBBB',
            itemCode: 'BBBBBB',
            amount: 'BBBBBB',
            discount: 'BBBBBB',
            unit: 'BBBBBB',
            contractEndOfProdDate: 'BBBBBB',
          },
          elemDefault
        );
        const expected = Object.assign({}, returnedFromService);
        axiosStub.get.resolves([returnedFromService]);
        return service.retrieve().then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of OrderFollowUp', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should delete a OrderFollowUp', async () => {
        axiosStub.delete.resolves({ ok: true });
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });

      it('should not delete a OrderFollowUp', async () => {
        axiosStub.delete.rejects(error);

        return service
          .delete(123)
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });
    });
  });
});
