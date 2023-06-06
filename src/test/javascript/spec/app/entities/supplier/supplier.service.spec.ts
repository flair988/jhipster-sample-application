/* tslint:disable max-line-length */
import axios from 'axios';
import sinon from 'sinon';
import dayjs from 'dayjs';

import { DATE_FORMAT } from '@/shared/date/filters';
import SupplierService from '@/entities/supplier/supplier.service';
import { Supplier } from '@/shared/model/supplier.model';

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
  describe('Supplier Service', () => {
    let service: SupplierService;
    let elemDefault;
    let currentDate: Date;

    beforeEach(() => {
      service = new SupplierService();
      currentDate = new Date();
      elemDefault = new Supplier(
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
        currentDate,
        currentDate,
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
        const returnedFromService = Object.assign(
          {
            createDate: dayjs(currentDate).format(DATE_FORMAT),
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
          },
          elemDefault
        );
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

      it('should create a Supplier', async () => {
        const returnedFromService = Object.assign(
          {
            id: 123,
            createDate: dayjs(currentDate).format(DATE_FORMAT),
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            createDate: currentDate,
            updateDate: currentDate,
          },
          returnedFromService
        );

        axiosStub.post.resolves({ data: returnedFromService });
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not create a Supplier', async () => {
        axiosStub.post.rejects(error);

        return service
          .create({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should update a Supplier', async () => {
        const returnedFromService = Object.assign(
          {
            client: 'BBBBBB',
            parentItem: 'BBBBBB',
            itemId: 'BBBBBB',
            boardId: 'BBBBBB',
            person: 'BBBBBB',
            category: 'BBBBBB',
            subCategory: 'BBBBBB',
            supplierStatus: 'BBBBBB',
            capStatus: 'BBBBBB',
            qualificationScore: 'BBBBBB',
            bopeScore: 'BBBBBB',
            internalSupplierId: 'BBBBBB',
            contact: 'BBBBBB',
            contactPhoneNumber: 'BBBBBB',
            contactEmailAddress: 'BBBBBB',
            country: 'BBBBBB',
            operationSite: 'BBBBBB',
            address: 'BBBBBB',
            website: 'BBBBBB',
            productTaxonomy: 'BBBBBB',
            relationStartingYear: 'BBBBBB',
            businessLicense: 'BBBBBB',
            rexOriginStatus: 'BBBBBB',
            createDate: dayjs(currentDate).format(DATE_FORMAT),
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
            item: 'BBBBBB',
            mirror: 'BBBBBB',
            subItems: 'BBBBBB',
            owner: 'BBBBBB',
            status: 'BBBBBB',
            date: 'BBBBBB',
            formula: 'BBBBBB',
            kingdeeId: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            createDate: currentDate,
            updateDate: currentDate,
          },
          returnedFromService
        );
        axiosStub.put.resolves({ data: returnedFromService });

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not update a Supplier', async () => {
        axiosStub.put.rejects(error);

        return service
          .update({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should partial update a Supplier', async () => {
        const patchObject = Object.assign(
          {
            client: 'BBBBBB',
            parentItem: 'BBBBBB',
            person: 'BBBBBB',
            subCategory: 'BBBBBB',
            internalSupplierId: 'BBBBBB',
            contact: 'BBBBBB',
            contactPhoneNumber: 'BBBBBB',
            contactEmailAddress: 'BBBBBB',
            productTaxonomy: 'BBBBBB',
            businessLicense: 'BBBBBB',
            rexOriginStatus: 'BBBBBB',
            createDate: dayjs(currentDate).format(DATE_FORMAT),
            mirror: 'BBBBBB',
            owner: 'BBBBBB',
            date: 'BBBBBB',
          },
          new Supplier()
        );
        const returnedFromService = Object.assign(patchObject, elemDefault);

        const expected = Object.assign(
          {
            createDate: currentDate,
            updateDate: currentDate,
          },
          returnedFromService
        );
        axiosStub.patch.resolves({ data: returnedFromService });

        return service.partialUpdate(patchObject).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not partial update a Supplier', async () => {
        axiosStub.patch.rejects(error);

        return service
          .partialUpdate({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of Supplier', async () => {
        const returnedFromService = Object.assign(
          {
            client: 'BBBBBB',
            parentItem: 'BBBBBB',
            itemId: 'BBBBBB',
            boardId: 'BBBBBB',
            person: 'BBBBBB',
            category: 'BBBBBB',
            subCategory: 'BBBBBB',
            supplierStatus: 'BBBBBB',
            capStatus: 'BBBBBB',
            qualificationScore: 'BBBBBB',
            bopeScore: 'BBBBBB',
            internalSupplierId: 'BBBBBB',
            contact: 'BBBBBB',
            contactPhoneNumber: 'BBBBBB',
            contactEmailAddress: 'BBBBBB',
            country: 'BBBBBB',
            operationSite: 'BBBBBB',
            address: 'BBBBBB',
            website: 'BBBBBB',
            productTaxonomy: 'BBBBBB',
            relationStartingYear: 'BBBBBB',
            businessLicense: 'BBBBBB',
            rexOriginStatus: 'BBBBBB',
            createDate: dayjs(currentDate).format(DATE_FORMAT),
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
            item: 'BBBBBB',
            mirror: 'BBBBBB',
            subItems: 'BBBBBB',
            owner: 'BBBBBB',
            status: 'BBBBBB',
            date: 'BBBBBB',
            formula: 'BBBBBB',
            kingdeeId: 'BBBBBB',
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            createDate: currentDate,
            updateDate: currentDate,
          },
          returnedFromService
        );
        axiosStub.get.resolves([returnedFromService]);
        return service.retrieve().then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of Supplier', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should delete a Supplier', async () => {
        axiosStub.delete.resolves({ ok: true });
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });

      it('should not delete a Supplier', async () => {
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
