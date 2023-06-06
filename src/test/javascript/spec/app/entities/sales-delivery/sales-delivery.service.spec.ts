/* tslint:disable max-line-length */
import axios from 'axios';
import sinon from 'sinon';

import SalesDeliveryService from '@/entities/sales-delivery/sales-delivery.service';
import { SalesDelivery } from '@/shared/model/sales-delivery.model';

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
  describe('SalesDelivery Service', () => {
    let service: SalesDeliveryService;
    let elemDefault;

    beforeEach(() => {
      service = new SalesDeliveryService();
      elemDefault = new SalesDelivery(
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

      it('should create a SalesDelivery', async () => {
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

      it('should not create a SalesDelivery', async () => {
        axiosStub.post.rejects(error);

        return service
          .create({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should update a SalesDelivery', async () => {
        const returnedFromService = Object.assign(
          {
            itemName: 'BBBBBB',
            itemId: 'BBBBBB',
            boardId: 'BBBBBB',
            kingdeeId: 'BBBBBB',
            customer: 'BBBBBB',
            orderDate: 'BBBBBB',
            totalActualShipQty: 'BBBBBB',
            totalQtyDelivery: 'BBBBBB',
            loadingPort: 'BBBBBB',
            dischargePort: 'BBBBBB',
            transportMode: 'BBBBBB',
            incoterm: 'BBBBBB',
            forwarder: 'BBBBBB',
            eta: 'BBBBBB',
            etd: 'BBBBBB',
            containerType: 'BBBBBB',
            containerSize: 'BBBBBB',
            remark: 'BBBBBB',
            kingdeeUniqueId: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);
        axiosStub.put.resolves({ data: returnedFromService });

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not update a SalesDelivery', async () => {
        axiosStub.put.rejects(error);

        return service
          .update({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should partial update a SalesDelivery', async () => {
        const patchObject = Object.assign(
          {
            itemName: 'BBBBBB',
            itemId: 'BBBBBB',
            kingdeeId: 'BBBBBB',
            orderDate: 'BBBBBB',
            dischargePort: 'BBBBBB',
            incoterm: 'BBBBBB',
            forwarder: 'BBBBBB',
            eta: 'BBBBBB',
            etd: 'BBBBBB',
            containerType: 'BBBBBB',
            kingdeeUniqueId: 'BBBBBB',
          },
          new SalesDelivery()
        );
        const returnedFromService = Object.assign(patchObject, elemDefault);

        const expected = Object.assign({}, returnedFromService);
        axiosStub.patch.resolves({ data: returnedFromService });

        return service.partialUpdate(patchObject).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not partial update a SalesDelivery', async () => {
        axiosStub.patch.rejects(error);

        return service
          .partialUpdate({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of SalesDelivery', async () => {
        const returnedFromService = Object.assign(
          {
            itemName: 'BBBBBB',
            itemId: 'BBBBBB',
            boardId: 'BBBBBB',
            kingdeeId: 'BBBBBB',
            customer: 'BBBBBB',
            orderDate: 'BBBBBB',
            totalActualShipQty: 'BBBBBB',
            totalQtyDelivery: 'BBBBBB',
            loadingPort: 'BBBBBB',
            dischargePort: 'BBBBBB',
            transportMode: 'BBBBBB',
            incoterm: 'BBBBBB',
            forwarder: 'BBBBBB',
            eta: 'BBBBBB',
            etd: 'BBBBBB',
            containerType: 'BBBBBB',
            containerSize: 'BBBBBB',
            remark: 'BBBBBB',
            kingdeeUniqueId: 'BBBBBB',
          },
          elemDefault
        );
        const expected = Object.assign({}, returnedFromService);
        axiosStub.get.resolves([returnedFromService]);
        return service.retrieve().then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of SalesDelivery', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should delete a SalesDelivery', async () => {
        axiosStub.delete.resolves({ ok: true });
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });

      it('should not delete a SalesDelivery', async () => {
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
