/* tslint:disable max-line-length */
import axios from 'axios';
import sinon from 'sinon';
import dayjs from 'dayjs';

import { DATE_FORMAT } from '@/shared/date/filters';
import ItemService from '@/entities/item/item.service';
import { Item } from '@/shared/model/item.model';

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
  describe('Item Service', () => {
    let service: ItemService;
    let elemDefault;
    let currentDate: Date;

    beforeEach(() => {
      service = new ItemService();
      currentDate = new Date();
      elemDefault = new Item(
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
        currentDate,
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
        const returnedFromService = Object.assign(
          {
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

      it('should create a Item', async () => {
        const returnedFromService = Object.assign(
          {
            id: 123,
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            updateDate: currentDate,
          },
          returnedFromService
        );

        axiosStub.post.resolves({ data: returnedFromService });
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not create a Item', async () => {
        axiosStub.post.rejects(error);

        return service
          .create({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should update a Item', async () => {
        const returnedFromService = Object.assign(
          {
            people: 'BBBBBB',
            itemStatus: 'BBBBBB',
            itemFranceName: 'BBBBBB',
            itemId: 'BBBBBB',
            boardId: 'BBBBBB',
            kingdeeId: 'BBBBBB',
            itemName: 'BBBBBB',
            parentItem: 'BBBBBB',
            codeP: 'BBBBBB',
            codeag: 'BBBBBB',
            mondayId: 'BBBBBB',
            dcsMerchandiser: 'BBBBBB',
            stockedInProdex: 'BBBBBB',
            supplier: 'BBBBBB',
            technicalDocuments: 'BBBBBB',
            certification: 'BBBBBB',
            opportunitySheet: 'BBBBBB',
            packingType: 'BBBBBB',
            salePackageImage: 'BBBBBB',
            cartonLengthMilimeter: 'BBBBBB',
            cartonHeightMilimeter: 'BBBBBB',
            portOfDeparture: 'BBBBBB',
            barcode: 'BBBBBB',
            cartonWeightKg: 'BBBBBB',
            cartonWeightGr: 'BBBBBB',
            cartonWidthMilimeter: 'BBBBBB',
            productionLeadtimeCommitmentsFromSuppliers: 'BBBBBB',
            negotiatedPrice: 'BBBBBB',
            productDescriptionAndFonctionalities: 'BBBBBB',
            drawing: 'BBBBBB',
            userManual: 'BBBBBB',
            supplierMarketingService: 'BBBBBB',
            palletSize: 'BBBBBB',
            typeOfMarketing: 'BBBBBB',
            productPic: 'BBBBBB',
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
            subItems: 'BBBBBB',
            mirror: 'BBBBBB',
            label: 'BBBBBB',
            moqsPcsCommitment: 'BBBBBB',
            moqCommitment: 'BBBBBB',
            updatedMoqAfterNegotiation: 'BBBBBB',
            uom: 'BBBBBB',
            bom: 'BBBBBB',
            priceManagementStatus: 'BBBBBB',
            comment: 'BBBBBB',
            juneY: 'BBBBBB',
            commentsJuneY: 'BBBBBB',
            decemberY: 'BBBBBB',
            commentsDecemberY: 'BBBBBB',
            productTaxonomy: 'BBBBBB',
            validPeriod: 'BBBBBB',
            withTax: 'BBBBBB',
            unitPrice: 'BBBBBB',
            currency: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            updateDate: currentDate,
          },
          returnedFromService
        );
        axiosStub.put.resolves({ data: returnedFromService });

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not update a Item', async () => {
        axiosStub.put.rejects(error);

        return service
          .update({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should partial update a Item', async () => {
        const patchObject = Object.assign(
          {
            people: 'BBBBBB',
            boardId: 'BBBBBB',
            kingdeeId: 'BBBBBB',
            parentItem: 'BBBBBB',
            codeP: 'BBBBBB',
            codeag: 'BBBBBB',
            mondayId: 'BBBBBB',
            packingType: 'BBBBBB',
            cartonLengthMilimeter: 'BBBBBB',
            cartonHeightMilimeter: 'BBBBBB',
            cartonWeightKg: 'BBBBBB',
            cartonWidthMilimeter: 'BBBBBB',
            negotiatedPrice: 'BBBBBB',
            supplierMarketingService: 'BBBBBB',
            typeOfMarketing: 'BBBBBB',
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
            subItems: 'BBBBBB',
            mirror: 'BBBBBB',
            moqsPcsCommitment: 'BBBBBB',
            moqCommitment: 'BBBBBB',
            uom: 'BBBBBB',
            bom: 'BBBBBB',
            priceManagementStatus: 'BBBBBB',
            decemberY: 'BBBBBB',
            productTaxonomy: 'BBBBBB',
            validPeriod: 'BBBBBB',
            unitPrice: 'BBBBBB',
            currency: 'BBBBBB',
          },
          new Item()
        );
        const returnedFromService = Object.assign(patchObject, elemDefault);

        const expected = Object.assign(
          {
            updateDate: currentDate,
          },
          returnedFromService
        );
        axiosStub.patch.resolves({ data: returnedFromService });

        return service.partialUpdate(patchObject).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not partial update a Item', async () => {
        axiosStub.patch.rejects(error);

        return service
          .partialUpdate({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of Item', async () => {
        const returnedFromService = Object.assign(
          {
            people: 'BBBBBB',
            itemStatus: 'BBBBBB',
            itemFranceName: 'BBBBBB',
            itemId: 'BBBBBB',
            boardId: 'BBBBBB',
            kingdeeId: 'BBBBBB',
            itemName: 'BBBBBB',
            parentItem: 'BBBBBB',
            codeP: 'BBBBBB',
            codeag: 'BBBBBB',
            mondayId: 'BBBBBB',
            dcsMerchandiser: 'BBBBBB',
            stockedInProdex: 'BBBBBB',
            supplier: 'BBBBBB',
            technicalDocuments: 'BBBBBB',
            certification: 'BBBBBB',
            opportunitySheet: 'BBBBBB',
            packingType: 'BBBBBB',
            salePackageImage: 'BBBBBB',
            cartonLengthMilimeter: 'BBBBBB',
            cartonHeightMilimeter: 'BBBBBB',
            portOfDeparture: 'BBBBBB',
            barcode: 'BBBBBB',
            cartonWeightKg: 'BBBBBB',
            cartonWeightGr: 'BBBBBB',
            cartonWidthMilimeter: 'BBBBBB',
            productionLeadtimeCommitmentsFromSuppliers: 'BBBBBB',
            negotiatedPrice: 'BBBBBB',
            productDescriptionAndFonctionalities: 'BBBBBB',
            drawing: 'BBBBBB',
            userManual: 'BBBBBB',
            supplierMarketingService: 'BBBBBB',
            palletSize: 'BBBBBB',
            typeOfMarketing: 'BBBBBB',
            productPic: 'BBBBBB',
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
            subItems: 'BBBBBB',
            mirror: 'BBBBBB',
            label: 'BBBBBB',
            moqsPcsCommitment: 'BBBBBB',
            moqCommitment: 'BBBBBB',
            updatedMoqAfterNegotiation: 'BBBBBB',
            uom: 'BBBBBB',
            bom: 'BBBBBB',
            priceManagementStatus: 'BBBBBB',
            comment: 'BBBBBB',
            juneY: 'BBBBBB',
            commentsJuneY: 'BBBBBB',
            decemberY: 'BBBBBB',
            commentsDecemberY: 'BBBBBB',
            productTaxonomy: 'BBBBBB',
            validPeriod: 'BBBBBB',
            withTax: 'BBBBBB',
            unitPrice: 'BBBBBB',
            currency: 'BBBBBB',
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            updateDate: currentDate,
          },
          returnedFromService
        );
        axiosStub.get.resolves([returnedFromService]);
        return service.retrieve().then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of Item', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should delete a Item', async () => {
        axiosStub.delete.resolves({ ok: true });
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });

      it('should not delete a Item', async () => {
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
