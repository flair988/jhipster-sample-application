import { Component, Vue, Inject } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';

import { IItem, Item } from '@/shared/model/item.model';
import ItemService from './item.service';

const validations: any = {
  item: {
    people: {},
    itemStatus: {},
    itemFranceName: {},
    itemId: {},
    boardId: {},
    kingdeeId: {},
    itemName: {},
    parentItem: {},
    codeP: {},
    codeag: {},
    mondayId: {},
    dcsMerchandiser: {},
    stockedInProdex: {},
    supplier: {},
    technicalDocuments: {},
    certification: {},
    opportunitySheet: {},
    packingType: {},
    salePackageImage: {},
    cartonLengthMilimeter: {},
    cartonHeightMilimeter: {},
    portOfDeparture: {},
    barcode: {},
    cartonWeightKg: {},
    cartonWeightGr: {},
    cartonWidthMilimeter: {},
    productionLeadtimeCommitmentsFromSuppliers: {},
    negotiatedPrice: {},
    productDescriptionAndFonctionalities: {},
    drawing: {},
    userManual: {},
    supplierMarketingService: {},
    palletSize: {},
    typeOfMarketing: {},
    productPic: {},
    updateDate: {},
    subItems: {},
    mirror: {},
    label: {},
    moqsPcsCommitment: {},
    moqCommitment: {},
    updatedMoqAfterNegotiation: {},
    uom: {},
    bom: {},
    priceManagementStatus: {},
    comment: {},
    juneY: {},
    commentsJuneY: {},
    decemberY: {},
    commentsDecemberY: {},
    productTaxonomy: {},
    validPeriod: {},
    withTax: {},
    unitPrice: {},
    currency: {},
  },
};

@Component({
  validations,
})
export default class ItemUpdate extends Vue {
  @Inject('itemService') private itemService: () => ItemService;
  @Inject('alertService') private alertService: () => AlertService;

  public item: IItem = new Item();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.itemId) {
        vm.retrieveItem(to.params.itemId);
      }
    });
  }

  created(): void {
    this.currentLanguage = this.$store.getters.currentLanguage;
    this.$store.watch(
      () => this.$store.getters.currentLanguage,
      () => {
        this.currentLanguage = this.$store.getters.currentLanguage;
      }
    );
  }

  public save(): void {
    this.isSaving = true;
    if (this.item.id) {
      this.itemService()
        .update(this.item)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterSampleApplicationApp.item.updated', { param: param.id });
          return (this.$root as any).$bvToast.toast(message.toString(), {
            toaster: 'b-toaster-top-center',
            title: 'Info',
            variant: 'info',
            solid: true,
            autoHideDelay: 5000,
          });
        })
        .catch(error => {
          this.isSaving = false;
          this.alertService().showHttpError(this, error.response);
        });
    } else {
      this.itemService()
        .create(this.item)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterSampleApplicationApp.item.created', { param: param.id });
          (this.$root as any).$bvToast.toast(message.toString(), {
            toaster: 'b-toaster-top-center',
            title: 'Success',
            variant: 'success',
            solid: true,
            autoHideDelay: 5000,
          });
        })
        .catch(error => {
          this.isSaving = false;
          this.alertService().showHttpError(this, error.response);
        });
    }
  }

  public retrieveItem(itemId): void {
    this.itemService()
      .find(itemId)
      .then(res => {
        this.item = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
