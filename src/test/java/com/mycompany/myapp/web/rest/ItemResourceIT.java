package com.mycompany.myapp.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.mycompany.myapp.IntegrationTest;
import com.mycompany.myapp.domain.Item;
import com.mycompany.myapp.repository.ItemRepository;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link ItemResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class ItemResourceIT {

    private static final String DEFAULT_PEOPLE = "AAAAAAAAAA";
    private static final String UPDATED_PEOPLE = "BBBBBBBBBB";

    private static final String DEFAULT_ITEM_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_ITEM_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_ITEM_FRANCE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_ITEM_FRANCE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_ITEM_ID = "AAAAAAAAAA";
    private static final String UPDATED_ITEM_ID = "BBBBBBBBBB";

    private static final String DEFAULT_BOARD_ID = "AAAAAAAAAA";
    private static final String UPDATED_BOARD_ID = "BBBBBBBBBB";

    private static final String DEFAULT_KINGDEE_ID = "AAAAAAAAAA";
    private static final String UPDATED_KINGDEE_ID = "BBBBBBBBBB";

    private static final String DEFAULT_ITEM_NAME = "AAAAAAAAAA";
    private static final String UPDATED_ITEM_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_PARENT_ITEM = "AAAAAAAAAA";
    private static final String UPDATED_PARENT_ITEM = "BBBBBBBBBB";

    private static final String DEFAULT_CODE_P = "AAAAAAAAAA";
    private static final String UPDATED_CODE_P = "BBBBBBBBBB";

    private static final String DEFAULT_CODEAG = "AAAAAAAAAA";
    private static final String UPDATED_CODEAG = "BBBBBBBBBB";

    private static final String DEFAULT_MONDAY_ID = "AAAAAAAAAA";
    private static final String UPDATED_MONDAY_ID = "BBBBBBBBBB";

    private static final String DEFAULT_DCS_MERCHANDISER = "AAAAAAAAAA";
    private static final String UPDATED_DCS_MERCHANDISER = "BBBBBBBBBB";

    private static final String DEFAULT_STOCKED_IN_PRODEX = "AAAAAAAAAA";
    private static final String UPDATED_STOCKED_IN_PRODEX = "BBBBBBBBBB";

    private static final String DEFAULT_SUPPLIER = "AAAAAAAAAA";
    private static final String UPDATED_SUPPLIER = "BBBBBBBBBB";

    private static final String DEFAULT_TECHNICAL_DOCUMENTS = "AAAAAAAAAA";
    private static final String UPDATED_TECHNICAL_DOCUMENTS = "BBBBBBBBBB";

    private static final String DEFAULT_CERTIFICATION = "AAAAAAAAAA";
    private static final String UPDATED_CERTIFICATION = "BBBBBBBBBB";

    private static final String DEFAULT_OPPORTUNITY_SHEET = "AAAAAAAAAA";
    private static final String UPDATED_OPPORTUNITY_SHEET = "BBBBBBBBBB";

    private static final String DEFAULT_PACKING_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_PACKING_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_SALE_PACKAGE_IMAGE = "AAAAAAAAAA";
    private static final String UPDATED_SALE_PACKAGE_IMAGE = "BBBBBBBBBB";

    private static final String DEFAULT_CARTON_LENGTH_MILIMETER = "AAAAAAAAAA";
    private static final String UPDATED_CARTON_LENGTH_MILIMETER = "BBBBBBBBBB";

    private static final String DEFAULT_CARTON_HEIGHT_MILIMETER = "AAAAAAAAAA";
    private static final String UPDATED_CARTON_HEIGHT_MILIMETER = "BBBBBBBBBB";

    private static final String DEFAULT_PORT_OF_DEPARTURE = "AAAAAAAAAA";
    private static final String UPDATED_PORT_OF_DEPARTURE = "BBBBBBBBBB";

    private static final String DEFAULT_BARCODE = "AAAAAAAAAA";
    private static final String UPDATED_BARCODE = "BBBBBBBBBB";

    private static final String DEFAULT_CARTON_WEIGHT_KG = "AAAAAAAAAA";
    private static final String UPDATED_CARTON_WEIGHT_KG = "BBBBBBBBBB";

    private static final String DEFAULT_CARTON_WEIGHT_GR = "AAAAAAAAAA";
    private static final String UPDATED_CARTON_WEIGHT_GR = "BBBBBBBBBB";

    private static final String DEFAULT_CARTON_WIDTH_MILIMETER = "AAAAAAAAAA";
    private static final String UPDATED_CARTON_WIDTH_MILIMETER = "BBBBBBBBBB";

    private static final String DEFAULT_PRODUCTION_LEADTIME_COMMITMENTS_FROM_SUPPLIERS = "AAAAAAAAAA";
    private static final String UPDATED_PRODUCTION_LEADTIME_COMMITMENTS_FROM_SUPPLIERS = "BBBBBBBBBB";

    private static final String DEFAULT_NEGOTIATED_PRICE = "AAAAAAAAAA";
    private static final String UPDATED_NEGOTIATED_PRICE = "BBBBBBBBBB";

    private static final String DEFAULT_PRODUCT_DESCRIPTION_AND_FONCTIONALITIES = "AAAAAAAAAA";
    private static final String UPDATED_PRODUCT_DESCRIPTION_AND_FONCTIONALITIES = "BBBBBBBBBB";

    private static final String DEFAULT_DRAWING = "AAAAAAAAAA";
    private static final String UPDATED_DRAWING = "BBBBBBBBBB";

    private static final String DEFAULT_USER_MANUAL = "AAAAAAAAAA";
    private static final String UPDATED_USER_MANUAL = "BBBBBBBBBB";

    private static final String DEFAULT_SUPPLIER_MARKETING_SERVICE = "AAAAAAAAAA";
    private static final String UPDATED_SUPPLIER_MARKETING_SERVICE = "BBBBBBBBBB";

    private static final String DEFAULT_PALLET_SIZE = "AAAAAAAAAA";
    private static final String UPDATED_PALLET_SIZE = "BBBBBBBBBB";

    private static final String DEFAULT_TYPE_OF_MARKETING = "AAAAAAAAAA";
    private static final String UPDATED_TYPE_OF_MARKETING = "BBBBBBBBBB";

    private static final String DEFAULT_PRODUCT_PIC = "AAAAAAAAAA";
    private static final String UPDATED_PRODUCT_PIC = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_UPDATE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UPDATE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_SUB_ITEMS = "AAAAAAAAAA";
    private static final String UPDATED_SUB_ITEMS = "BBBBBBBBBB";

    private static final String DEFAULT_MIRROR = "AAAAAAAAAA";
    private static final String UPDATED_MIRROR = "BBBBBBBBBB";

    private static final String DEFAULT_LABEL = "AAAAAAAAAA";
    private static final String UPDATED_LABEL = "BBBBBBBBBB";

    private static final String DEFAULT_MOQS_PCS_COMMITMENT = "AAAAAAAAAA";
    private static final String UPDATED_MOQS_PCS_COMMITMENT = "BBBBBBBBBB";

    private static final String DEFAULT_MOQ_COMMITMENT = "AAAAAAAAAA";
    private static final String UPDATED_MOQ_COMMITMENT = "BBBBBBBBBB";

    private static final String DEFAULT_UPDATED_MOQ_AFTER_NEGOTIATION = "AAAAAAAAAA";
    private static final String UPDATED_UPDATED_MOQ_AFTER_NEGOTIATION = "BBBBBBBBBB";

    private static final String DEFAULT_UOM = "AAAAAAAAAA";
    private static final String UPDATED_UOM = "BBBBBBBBBB";

    private static final String DEFAULT_BOM = "AAAAAAAAAA";
    private static final String UPDATED_BOM = "BBBBBBBBBB";

    private static final String DEFAULT_PRICE_MANAGEMENT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_PRICE_MANAGEMENT_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_COMMENT = "AAAAAAAAAA";
    private static final String UPDATED_COMMENT = "BBBBBBBBBB";

    private static final String DEFAULT_JUNE_Y = "AAAAAAAAAA";
    private static final String UPDATED_JUNE_Y = "BBBBBBBBBB";

    private static final String DEFAULT_COMMENTS_JUNE_Y = "AAAAAAAAAA";
    private static final String UPDATED_COMMENTS_JUNE_Y = "BBBBBBBBBB";

    private static final String DEFAULT_DECEMBER_Y = "AAAAAAAAAA";
    private static final String UPDATED_DECEMBER_Y = "BBBBBBBBBB";

    private static final String DEFAULT_COMMENTS_DECEMBER_Y = "AAAAAAAAAA";
    private static final String UPDATED_COMMENTS_DECEMBER_Y = "BBBBBBBBBB";

    private static final String DEFAULT_PRODUCT_TAXONOMY = "AAAAAAAAAA";
    private static final String UPDATED_PRODUCT_TAXONOMY = "BBBBBBBBBB";

    private static final String DEFAULT_VALID_PERIOD = "AAAAAAAAAA";
    private static final String UPDATED_VALID_PERIOD = "BBBBBBBBBB";

    private static final String DEFAULT_WITH_TAX = "AAAAAAAAAA";
    private static final String UPDATED_WITH_TAX = "BBBBBBBBBB";

    private static final String DEFAULT_UNIT_PRICE = "AAAAAAAAAA";
    private static final String UPDATED_UNIT_PRICE = "BBBBBBBBBB";

    private static final String DEFAULT_CURRENCY = "AAAAAAAAAA";
    private static final String UPDATED_CURRENCY = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/items";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restItemMockMvc;

    private Item item;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Item createEntity(EntityManager em) {
        Item item = new Item()
            .people(DEFAULT_PEOPLE)
            .itemStatus(DEFAULT_ITEM_STATUS)
            .itemFranceName(DEFAULT_ITEM_FRANCE_NAME)
            .itemId(DEFAULT_ITEM_ID)
            .boardId(DEFAULT_BOARD_ID)
            .kingdeeId(DEFAULT_KINGDEE_ID)
            .itemName(DEFAULT_ITEM_NAME)
            .parentItem(DEFAULT_PARENT_ITEM)
            .codeP(DEFAULT_CODE_P)
            .codeag(DEFAULT_CODEAG)
            .mondayId(DEFAULT_MONDAY_ID)
            .dcsMerchandiser(DEFAULT_DCS_MERCHANDISER)
            .stockedInProdex(DEFAULT_STOCKED_IN_PRODEX)
            .supplier(DEFAULT_SUPPLIER)
            .technicalDocuments(DEFAULT_TECHNICAL_DOCUMENTS)
            .certification(DEFAULT_CERTIFICATION)
            .opportunitySheet(DEFAULT_OPPORTUNITY_SHEET)
            .packingType(DEFAULT_PACKING_TYPE)
            .salePackageImage(DEFAULT_SALE_PACKAGE_IMAGE)
            .cartonLengthMilimeter(DEFAULT_CARTON_LENGTH_MILIMETER)
            .cartonHeightMilimeter(DEFAULT_CARTON_HEIGHT_MILIMETER)
            .portOfDeparture(DEFAULT_PORT_OF_DEPARTURE)
            .barcode(DEFAULT_BARCODE)
            .cartonWeightKg(DEFAULT_CARTON_WEIGHT_KG)
            .cartonWeightGr(DEFAULT_CARTON_WEIGHT_GR)
            .cartonWidthMilimeter(DEFAULT_CARTON_WIDTH_MILIMETER)
            .productionLeadtimeCommitmentsFromSuppliers(DEFAULT_PRODUCTION_LEADTIME_COMMITMENTS_FROM_SUPPLIERS)
            .negotiatedPrice(DEFAULT_NEGOTIATED_PRICE)
            .productDescriptionAndFonctionalities(DEFAULT_PRODUCT_DESCRIPTION_AND_FONCTIONALITIES)
            .drawing(DEFAULT_DRAWING)
            .userManual(DEFAULT_USER_MANUAL)
            .supplierMarketingService(DEFAULT_SUPPLIER_MARKETING_SERVICE)
            .palletSize(DEFAULT_PALLET_SIZE)
            .typeOfMarketing(DEFAULT_TYPE_OF_MARKETING)
            .productPic(DEFAULT_PRODUCT_PIC)
            .updateDate(DEFAULT_UPDATE_DATE)
            .subItems(DEFAULT_SUB_ITEMS)
            .mirror(DEFAULT_MIRROR)
            .label(DEFAULT_LABEL)
            .moqsPcsCommitment(DEFAULT_MOQS_PCS_COMMITMENT)
            .moqCommitment(DEFAULT_MOQ_COMMITMENT)
            .updatedMoqAfterNegotiation(DEFAULT_UPDATED_MOQ_AFTER_NEGOTIATION)
            .uom(DEFAULT_UOM)
            .bom(DEFAULT_BOM)
            .priceManagementStatus(DEFAULT_PRICE_MANAGEMENT_STATUS)
            .comment(DEFAULT_COMMENT)
            .juneY(DEFAULT_JUNE_Y)
            .commentsJuneY(DEFAULT_COMMENTS_JUNE_Y)
            .decemberY(DEFAULT_DECEMBER_Y)
            .commentsDecemberY(DEFAULT_COMMENTS_DECEMBER_Y)
            .productTaxonomy(DEFAULT_PRODUCT_TAXONOMY)
            .validPeriod(DEFAULT_VALID_PERIOD)
            .withTax(DEFAULT_WITH_TAX)
            .unitPrice(DEFAULT_UNIT_PRICE)
            .currency(DEFAULT_CURRENCY);
        return item;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Item createUpdatedEntity(EntityManager em) {
        Item item = new Item()
            .people(UPDATED_PEOPLE)
            .itemStatus(UPDATED_ITEM_STATUS)
            .itemFranceName(UPDATED_ITEM_FRANCE_NAME)
            .itemId(UPDATED_ITEM_ID)
            .boardId(UPDATED_BOARD_ID)
            .kingdeeId(UPDATED_KINGDEE_ID)
            .itemName(UPDATED_ITEM_NAME)
            .parentItem(UPDATED_PARENT_ITEM)
            .codeP(UPDATED_CODE_P)
            .codeag(UPDATED_CODEAG)
            .mondayId(UPDATED_MONDAY_ID)
            .dcsMerchandiser(UPDATED_DCS_MERCHANDISER)
            .stockedInProdex(UPDATED_STOCKED_IN_PRODEX)
            .supplier(UPDATED_SUPPLIER)
            .technicalDocuments(UPDATED_TECHNICAL_DOCUMENTS)
            .certification(UPDATED_CERTIFICATION)
            .opportunitySheet(UPDATED_OPPORTUNITY_SHEET)
            .packingType(UPDATED_PACKING_TYPE)
            .salePackageImage(UPDATED_SALE_PACKAGE_IMAGE)
            .cartonLengthMilimeter(UPDATED_CARTON_LENGTH_MILIMETER)
            .cartonHeightMilimeter(UPDATED_CARTON_HEIGHT_MILIMETER)
            .portOfDeparture(UPDATED_PORT_OF_DEPARTURE)
            .barcode(UPDATED_BARCODE)
            .cartonWeightKg(UPDATED_CARTON_WEIGHT_KG)
            .cartonWeightGr(UPDATED_CARTON_WEIGHT_GR)
            .cartonWidthMilimeter(UPDATED_CARTON_WIDTH_MILIMETER)
            .productionLeadtimeCommitmentsFromSuppliers(UPDATED_PRODUCTION_LEADTIME_COMMITMENTS_FROM_SUPPLIERS)
            .negotiatedPrice(UPDATED_NEGOTIATED_PRICE)
            .productDescriptionAndFonctionalities(UPDATED_PRODUCT_DESCRIPTION_AND_FONCTIONALITIES)
            .drawing(UPDATED_DRAWING)
            .userManual(UPDATED_USER_MANUAL)
            .supplierMarketingService(UPDATED_SUPPLIER_MARKETING_SERVICE)
            .palletSize(UPDATED_PALLET_SIZE)
            .typeOfMarketing(UPDATED_TYPE_OF_MARKETING)
            .productPic(UPDATED_PRODUCT_PIC)
            .updateDate(UPDATED_UPDATE_DATE)
            .subItems(UPDATED_SUB_ITEMS)
            .mirror(UPDATED_MIRROR)
            .label(UPDATED_LABEL)
            .moqsPcsCommitment(UPDATED_MOQS_PCS_COMMITMENT)
            .moqCommitment(UPDATED_MOQ_COMMITMENT)
            .updatedMoqAfterNegotiation(UPDATED_UPDATED_MOQ_AFTER_NEGOTIATION)
            .uom(UPDATED_UOM)
            .bom(UPDATED_BOM)
            .priceManagementStatus(UPDATED_PRICE_MANAGEMENT_STATUS)
            .comment(UPDATED_COMMENT)
            .juneY(UPDATED_JUNE_Y)
            .commentsJuneY(UPDATED_COMMENTS_JUNE_Y)
            .decemberY(UPDATED_DECEMBER_Y)
            .commentsDecemberY(UPDATED_COMMENTS_DECEMBER_Y)
            .productTaxonomy(UPDATED_PRODUCT_TAXONOMY)
            .validPeriod(UPDATED_VALID_PERIOD)
            .withTax(UPDATED_WITH_TAX)
            .unitPrice(UPDATED_UNIT_PRICE)
            .currency(UPDATED_CURRENCY);
        return item;
    }

    @BeforeEach
    public void initTest() {
        item = createEntity(em);
    }

    @Test
    @Transactional
    void createItem() throws Exception {
        int databaseSizeBeforeCreate = itemRepository.findAll().size();
        // Create the Item
        restItemMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(item)))
            .andExpect(status().isCreated());

        // Validate the Item in the database
        List<Item> itemList = itemRepository.findAll();
        assertThat(itemList).hasSize(databaseSizeBeforeCreate + 1);
        Item testItem = itemList.get(itemList.size() - 1);
        assertThat(testItem.getPeople()).isEqualTo(DEFAULT_PEOPLE);
        assertThat(testItem.getItemStatus()).isEqualTo(DEFAULT_ITEM_STATUS);
        assertThat(testItem.getItemFranceName()).isEqualTo(DEFAULT_ITEM_FRANCE_NAME);
        assertThat(testItem.getItemId()).isEqualTo(DEFAULT_ITEM_ID);
        assertThat(testItem.getBoardId()).isEqualTo(DEFAULT_BOARD_ID);
        assertThat(testItem.getKingdeeId()).isEqualTo(DEFAULT_KINGDEE_ID);
        assertThat(testItem.getItemName()).isEqualTo(DEFAULT_ITEM_NAME);
        assertThat(testItem.getParentItem()).isEqualTo(DEFAULT_PARENT_ITEM);
        assertThat(testItem.getCodeP()).isEqualTo(DEFAULT_CODE_P);
        assertThat(testItem.getCodeag()).isEqualTo(DEFAULT_CODEAG);
        assertThat(testItem.getMondayId()).isEqualTo(DEFAULT_MONDAY_ID);
        assertThat(testItem.getDcsMerchandiser()).isEqualTo(DEFAULT_DCS_MERCHANDISER);
        assertThat(testItem.getStockedInProdex()).isEqualTo(DEFAULT_STOCKED_IN_PRODEX);
        assertThat(testItem.getSupplier()).isEqualTo(DEFAULT_SUPPLIER);
        assertThat(testItem.getTechnicalDocuments()).isEqualTo(DEFAULT_TECHNICAL_DOCUMENTS);
        assertThat(testItem.getCertification()).isEqualTo(DEFAULT_CERTIFICATION);
        assertThat(testItem.getOpportunitySheet()).isEqualTo(DEFAULT_OPPORTUNITY_SHEET);
        assertThat(testItem.getPackingType()).isEqualTo(DEFAULT_PACKING_TYPE);
        assertThat(testItem.getSalePackageImage()).isEqualTo(DEFAULT_SALE_PACKAGE_IMAGE);
        assertThat(testItem.getCartonLengthMilimeter()).isEqualTo(DEFAULT_CARTON_LENGTH_MILIMETER);
        assertThat(testItem.getCartonHeightMilimeter()).isEqualTo(DEFAULT_CARTON_HEIGHT_MILIMETER);
        assertThat(testItem.getPortOfDeparture()).isEqualTo(DEFAULT_PORT_OF_DEPARTURE);
        assertThat(testItem.getBarcode()).isEqualTo(DEFAULT_BARCODE);
        assertThat(testItem.getCartonWeightKg()).isEqualTo(DEFAULT_CARTON_WEIGHT_KG);
        assertThat(testItem.getCartonWeightGr()).isEqualTo(DEFAULT_CARTON_WEIGHT_GR);
        assertThat(testItem.getCartonWidthMilimeter()).isEqualTo(DEFAULT_CARTON_WIDTH_MILIMETER);
        assertThat(testItem.getProductionLeadtimeCommitmentsFromSuppliers())
            .isEqualTo(DEFAULT_PRODUCTION_LEADTIME_COMMITMENTS_FROM_SUPPLIERS);
        assertThat(testItem.getNegotiatedPrice()).isEqualTo(DEFAULT_NEGOTIATED_PRICE);
        assertThat(testItem.getProductDescriptionAndFonctionalities()).isEqualTo(DEFAULT_PRODUCT_DESCRIPTION_AND_FONCTIONALITIES);
        assertThat(testItem.getDrawing()).isEqualTo(DEFAULT_DRAWING);
        assertThat(testItem.getUserManual()).isEqualTo(DEFAULT_USER_MANUAL);
        assertThat(testItem.getSupplierMarketingService()).isEqualTo(DEFAULT_SUPPLIER_MARKETING_SERVICE);
        assertThat(testItem.getPalletSize()).isEqualTo(DEFAULT_PALLET_SIZE);
        assertThat(testItem.getTypeOfMarketing()).isEqualTo(DEFAULT_TYPE_OF_MARKETING);
        assertThat(testItem.getProductPic()).isEqualTo(DEFAULT_PRODUCT_PIC);
        assertThat(testItem.getUpdateDate()).isEqualTo(DEFAULT_UPDATE_DATE);
        assertThat(testItem.getSubItems()).isEqualTo(DEFAULT_SUB_ITEMS);
        assertThat(testItem.getMirror()).isEqualTo(DEFAULT_MIRROR);
        assertThat(testItem.getLabel()).isEqualTo(DEFAULT_LABEL);
        assertThat(testItem.getMoqsPcsCommitment()).isEqualTo(DEFAULT_MOQS_PCS_COMMITMENT);
        assertThat(testItem.getMoqCommitment()).isEqualTo(DEFAULT_MOQ_COMMITMENT);
        assertThat(testItem.getUpdatedMoqAfterNegotiation()).isEqualTo(DEFAULT_UPDATED_MOQ_AFTER_NEGOTIATION);
        assertThat(testItem.getUom()).isEqualTo(DEFAULT_UOM);
        assertThat(testItem.getBom()).isEqualTo(DEFAULT_BOM);
        assertThat(testItem.getPriceManagementStatus()).isEqualTo(DEFAULT_PRICE_MANAGEMENT_STATUS);
        assertThat(testItem.getComment()).isEqualTo(DEFAULT_COMMENT);
        assertThat(testItem.getJuneY()).isEqualTo(DEFAULT_JUNE_Y);
        assertThat(testItem.getCommentsJuneY()).isEqualTo(DEFAULT_COMMENTS_JUNE_Y);
        assertThat(testItem.getDecemberY()).isEqualTo(DEFAULT_DECEMBER_Y);
        assertThat(testItem.getCommentsDecemberY()).isEqualTo(DEFAULT_COMMENTS_DECEMBER_Y);
        assertThat(testItem.getProductTaxonomy()).isEqualTo(DEFAULT_PRODUCT_TAXONOMY);
        assertThat(testItem.getValidPeriod()).isEqualTo(DEFAULT_VALID_PERIOD);
        assertThat(testItem.getWithTax()).isEqualTo(DEFAULT_WITH_TAX);
        assertThat(testItem.getUnitPrice()).isEqualTo(DEFAULT_UNIT_PRICE);
        assertThat(testItem.getCurrency()).isEqualTo(DEFAULT_CURRENCY);
    }

    @Test
    @Transactional
    void createItemWithExistingId() throws Exception {
        // Create the Item with an existing ID
        item.setId(1L);

        int databaseSizeBeforeCreate = itemRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restItemMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(item)))
            .andExpect(status().isBadRequest());

        // Validate the Item in the database
        List<Item> itemList = itemRepository.findAll();
        assertThat(itemList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllItems() throws Exception {
        // Initialize the database
        itemRepository.saveAndFlush(item);

        // Get all the itemList
        restItemMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(item.getId().intValue())))
            .andExpect(jsonPath("$.[*].people").value(hasItem(DEFAULT_PEOPLE)))
            .andExpect(jsonPath("$.[*].itemStatus").value(hasItem(DEFAULT_ITEM_STATUS)))
            .andExpect(jsonPath("$.[*].itemFranceName").value(hasItem(DEFAULT_ITEM_FRANCE_NAME)))
            .andExpect(jsonPath("$.[*].itemId").value(hasItem(DEFAULT_ITEM_ID)))
            .andExpect(jsonPath("$.[*].boardId").value(hasItem(DEFAULT_BOARD_ID)))
            .andExpect(jsonPath("$.[*].kingdeeId").value(hasItem(DEFAULT_KINGDEE_ID)))
            .andExpect(jsonPath("$.[*].itemName").value(hasItem(DEFAULT_ITEM_NAME)))
            .andExpect(jsonPath("$.[*].parentItem").value(hasItem(DEFAULT_PARENT_ITEM)))
            .andExpect(jsonPath("$.[*].codeP").value(hasItem(DEFAULT_CODE_P)))
            .andExpect(jsonPath("$.[*].codeag").value(hasItem(DEFAULT_CODEAG)))
            .andExpect(jsonPath("$.[*].mondayId").value(hasItem(DEFAULT_MONDAY_ID)))
            .andExpect(jsonPath("$.[*].dcsMerchandiser").value(hasItem(DEFAULT_DCS_MERCHANDISER)))
            .andExpect(jsonPath("$.[*].stockedInProdex").value(hasItem(DEFAULT_STOCKED_IN_PRODEX)))
            .andExpect(jsonPath("$.[*].supplier").value(hasItem(DEFAULT_SUPPLIER)))
            .andExpect(jsonPath("$.[*].technicalDocuments").value(hasItem(DEFAULT_TECHNICAL_DOCUMENTS)))
            .andExpect(jsonPath("$.[*].certification").value(hasItem(DEFAULT_CERTIFICATION)))
            .andExpect(jsonPath("$.[*].opportunitySheet").value(hasItem(DEFAULT_OPPORTUNITY_SHEET)))
            .andExpect(jsonPath("$.[*].packingType").value(hasItem(DEFAULT_PACKING_TYPE)))
            .andExpect(jsonPath("$.[*].salePackageImage").value(hasItem(DEFAULT_SALE_PACKAGE_IMAGE)))
            .andExpect(jsonPath("$.[*].cartonLengthMilimeter").value(hasItem(DEFAULT_CARTON_LENGTH_MILIMETER)))
            .andExpect(jsonPath("$.[*].cartonHeightMilimeter").value(hasItem(DEFAULT_CARTON_HEIGHT_MILIMETER)))
            .andExpect(jsonPath("$.[*].portOfDeparture").value(hasItem(DEFAULT_PORT_OF_DEPARTURE)))
            .andExpect(jsonPath("$.[*].barcode").value(hasItem(DEFAULT_BARCODE)))
            .andExpect(jsonPath("$.[*].cartonWeightKg").value(hasItem(DEFAULT_CARTON_WEIGHT_KG)))
            .andExpect(jsonPath("$.[*].cartonWeightGr").value(hasItem(DEFAULT_CARTON_WEIGHT_GR)))
            .andExpect(jsonPath("$.[*].cartonWidthMilimeter").value(hasItem(DEFAULT_CARTON_WIDTH_MILIMETER)))
            .andExpect(
                jsonPath("$.[*].productionLeadtimeCommitmentsFromSuppliers")
                    .value(hasItem(DEFAULT_PRODUCTION_LEADTIME_COMMITMENTS_FROM_SUPPLIERS))
            )
            .andExpect(jsonPath("$.[*].negotiatedPrice").value(hasItem(DEFAULT_NEGOTIATED_PRICE)))
            .andExpect(
                jsonPath("$.[*].productDescriptionAndFonctionalities").value(hasItem(DEFAULT_PRODUCT_DESCRIPTION_AND_FONCTIONALITIES))
            )
            .andExpect(jsonPath("$.[*].drawing").value(hasItem(DEFAULT_DRAWING)))
            .andExpect(jsonPath("$.[*].userManual").value(hasItem(DEFAULT_USER_MANUAL)))
            .andExpect(jsonPath("$.[*].supplierMarketingService").value(hasItem(DEFAULT_SUPPLIER_MARKETING_SERVICE)))
            .andExpect(jsonPath("$.[*].palletSize").value(hasItem(DEFAULT_PALLET_SIZE)))
            .andExpect(jsonPath("$.[*].typeOfMarketing").value(hasItem(DEFAULT_TYPE_OF_MARKETING)))
            .andExpect(jsonPath("$.[*].productPic").value(hasItem(DEFAULT_PRODUCT_PIC)))
            .andExpect(jsonPath("$.[*].updateDate").value(hasItem(DEFAULT_UPDATE_DATE.toString())))
            .andExpect(jsonPath("$.[*].subItems").value(hasItem(DEFAULT_SUB_ITEMS)))
            .andExpect(jsonPath("$.[*].mirror").value(hasItem(DEFAULT_MIRROR)))
            .andExpect(jsonPath("$.[*].label").value(hasItem(DEFAULT_LABEL)))
            .andExpect(jsonPath("$.[*].moqsPcsCommitment").value(hasItem(DEFAULT_MOQS_PCS_COMMITMENT)))
            .andExpect(jsonPath("$.[*].moqCommitment").value(hasItem(DEFAULT_MOQ_COMMITMENT)))
            .andExpect(jsonPath("$.[*].updatedMoqAfterNegotiation").value(hasItem(DEFAULT_UPDATED_MOQ_AFTER_NEGOTIATION)))
            .andExpect(jsonPath("$.[*].uom").value(hasItem(DEFAULT_UOM)))
            .andExpect(jsonPath("$.[*].bom").value(hasItem(DEFAULT_BOM)))
            .andExpect(jsonPath("$.[*].priceManagementStatus").value(hasItem(DEFAULT_PRICE_MANAGEMENT_STATUS)))
            .andExpect(jsonPath("$.[*].comment").value(hasItem(DEFAULT_COMMENT)))
            .andExpect(jsonPath("$.[*].juneY").value(hasItem(DEFAULT_JUNE_Y)))
            .andExpect(jsonPath("$.[*].commentsJuneY").value(hasItem(DEFAULT_COMMENTS_JUNE_Y)))
            .andExpect(jsonPath("$.[*].decemberY").value(hasItem(DEFAULT_DECEMBER_Y)))
            .andExpect(jsonPath("$.[*].commentsDecemberY").value(hasItem(DEFAULT_COMMENTS_DECEMBER_Y)))
            .andExpect(jsonPath("$.[*].productTaxonomy").value(hasItem(DEFAULT_PRODUCT_TAXONOMY)))
            .andExpect(jsonPath("$.[*].validPeriod").value(hasItem(DEFAULT_VALID_PERIOD)))
            .andExpect(jsonPath("$.[*].withTax").value(hasItem(DEFAULT_WITH_TAX)))
            .andExpect(jsonPath("$.[*].unitPrice").value(hasItem(DEFAULT_UNIT_PRICE)))
            .andExpect(jsonPath("$.[*].currency").value(hasItem(DEFAULT_CURRENCY)));
    }

    @Test
    @Transactional
    void getItem() throws Exception {
        // Initialize the database
        itemRepository.saveAndFlush(item);

        // Get the item
        restItemMockMvc
            .perform(get(ENTITY_API_URL_ID, item.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(item.getId().intValue()))
            .andExpect(jsonPath("$.people").value(DEFAULT_PEOPLE))
            .andExpect(jsonPath("$.itemStatus").value(DEFAULT_ITEM_STATUS))
            .andExpect(jsonPath("$.itemFranceName").value(DEFAULT_ITEM_FRANCE_NAME))
            .andExpect(jsonPath("$.itemId").value(DEFAULT_ITEM_ID))
            .andExpect(jsonPath("$.boardId").value(DEFAULT_BOARD_ID))
            .andExpect(jsonPath("$.kingdeeId").value(DEFAULT_KINGDEE_ID))
            .andExpect(jsonPath("$.itemName").value(DEFAULT_ITEM_NAME))
            .andExpect(jsonPath("$.parentItem").value(DEFAULT_PARENT_ITEM))
            .andExpect(jsonPath("$.codeP").value(DEFAULT_CODE_P))
            .andExpect(jsonPath("$.codeag").value(DEFAULT_CODEAG))
            .andExpect(jsonPath("$.mondayId").value(DEFAULT_MONDAY_ID))
            .andExpect(jsonPath("$.dcsMerchandiser").value(DEFAULT_DCS_MERCHANDISER))
            .andExpect(jsonPath("$.stockedInProdex").value(DEFAULT_STOCKED_IN_PRODEX))
            .andExpect(jsonPath("$.supplier").value(DEFAULT_SUPPLIER))
            .andExpect(jsonPath("$.technicalDocuments").value(DEFAULT_TECHNICAL_DOCUMENTS))
            .andExpect(jsonPath("$.certification").value(DEFAULT_CERTIFICATION))
            .andExpect(jsonPath("$.opportunitySheet").value(DEFAULT_OPPORTUNITY_SHEET))
            .andExpect(jsonPath("$.packingType").value(DEFAULT_PACKING_TYPE))
            .andExpect(jsonPath("$.salePackageImage").value(DEFAULT_SALE_PACKAGE_IMAGE))
            .andExpect(jsonPath("$.cartonLengthMilimeter").value(DEFAULT_CARTON_LENGTH_MILIMETER))
            .andExpect(jsonPath("$.cartonHeightMilimeter").value(DEFAULT_CARTON_HEIGHT_MILIMETER))
            .andExpect(jsonPath("$.portOfDeparture").value(DEFAULT_PORT_OF_DEPARTURE))
            .andExpect(jsonPath("$.barcode").value(DEFAULT_BARCODE))
            .andExpect(jsonPath("$.cartonWeightKg").value(DEFAULT_CARTON_WEIGHT_KG))
            .andExpect(jsonPath("$.cartonWeightGr").value(DEFAULT_CARTON_WEIGHT_GR))
            .andExpect(jsonPath("$.cartonWidthMilimeter").value(DEFAULT_CARTON_WIDTH_MILIMETER))
            .andExpect(
                jsonPath("$.productionLeadtimeCommitmentsFromSuppliers").value(DEFAULT_PRODUCTION_LEADTIME_COMMITMENTS_FROM_SUPPLIERS)
            )
            .andExpect(jsonPath("$.negotiatedPrice").value(DEFAULT_NEGOTIATED_PRICE))
            .andExpect(jsonPath("$.productDescriptionAndFonctionalities").value(DEFAULT_PRODUCT_DESCRIPTION_AND_FONCTIONALITIES))
            .andExpect(jsonPath("$.drawing").value(DEFAULT_DRAWING))
            .andExpect(jsonPath("$.userManual").value(DEFAULT_USER_MANUAL))
            .andExpect(jsonPath("$.supplierMarketingService").value(DEFAULT_SUPPLIER_MARKETING_SERVICE))
            .andExpect(jsonPath("$.palletSize").value(DEFAULT_PALLET_SIZE))
            .andExpect(jsonPath("$.typeOfMarketing").value(DEFAULT_TYPE_OF_MARKETING))
            .andExpect(jsonPath("$.productPic").value(DEFAULT_PRODUCT_PIC))
            .andExpect(jsonPath("$.updateDate").value(DEFAULT_UPDATE_DATE.toString()))
            .andExpect(jsonPath("$.subItems").value(DEFAULT_SUB_ITEMS))
            .andExpect(jsonPath("$.mirror").value(DEFAULT_MIRROR))
            .andExpect(jsonPath("$.label").value(DEFAULT_LABEL))
            .andExpect(jsonPath("$.moqsPcsCommitment").value(DEFAULT_MOQS_PCS_COMMITMENT))
            .andExpect(jsonPath("$.moqCommitment").value(DEFAULT_MOQ_COMMITMENT))
            .andExpect(jsonPath("$.updatedMoqAfterNegotiation").value(DEFAULT_UPDATED_MOQ_AFTER_NEGOTIATION))
            .andExpect(jsonPath("$.uom").value(DEFAULT_UOM))
            .andExpect(jsonPath("$.bom").value(DEFAULT_BOM))
            .andExpect(jsonPath("$.priceManagementStatus").value(DEFAULT_PRICE_MANAGEMENT_STATUS))
            .andExpect(jsonPath("$.comment").value(DEFAULT_COMMENT))
            .andExpect(jsonPath("$.juneY").value(DEFAULT_JUNE_Y))
            .andExpect(jsonPath("$.commentsJuneY").value(DEFAULT_COMMENTS_JUNE_Y))
            .andExpect(jsonPath("$.decemberY").value(DEFAULT_DECEMBER_Y))
            .andExpect(jsonPath("$.commentsDecemberY").value(DEFAULT_COMMENTS_DECEMBER_Y))
            .andExpect(jsonPath("$.productTaxonomy").value(DEFAULT_PRODUCT_TAXONOMY))
            .andExpect(jsonPath("$.validPeriod").value(DEFAULT_VALID_PERIOD))
            .andExpect(jsonPath("$.withTax").value(DEFAULT_WITH_TAX))
            .andExpect(jsonPath("$.unitPrice").value(DEFAULT_UNIT_PRICE))
            .andExpect(jsonPath("$.currency").value(DEFAULT_CURRENCY));
    }

    @Test
    @Transactional
    void getNonExistingItem() throws Exception {
        // Get the item
        restItemMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingItem() throws Exception {
        // Initialize the database
        itemRepository.saveAndFlush(item);

        int databaseSizeBeforeUpdate = itemRepository.findAll().size();

        // Update the item
        Item updatedItem = itemRepository.findById(item.getId()).get();
        // Disconnect from session so that the updates on updatedItem are not directly saved in db
        em.detach(updatedItem);
        updatedItem
            .people(UPDATED_PEOPLE)
            .itemStatus(UPDATED_ITEM_STATUS)
            .itemFranceName(UPDATED_ITEM_FRANCE_NAME)
            .itemId(UPDATED_ITEM_ID)
            .boardId(UPDATED_BOARD_ID)
            .kingdeeId(UPDATED_KINGDEE_ID)
            .itemName(UPDATED_ITEM_NAME)
            .parentItem(UPDATED_PARENT_ITEM)
            .codeP(UPDATED_CODE_P)
            .codeag(UPDATED_CODEAG)
            .mondayId(UPDATED_MONDAY_ID)
            .dcsMerchandiser(UPDATED_DCS_MERCHANDISER)
            .stockedInProdex(UPDATED_STOCKED_IN_PRODEX)
            .supplier(UPDATED_SUPPLIER)
            .technicalDocuments(UPDATED_TECHNICAL_DOCUMENTS)
            .certification(UPDATED_CERTIFICATION)
            .opportunitySheet(UPDATED_OPPORTUNITY_SHEET)
            .packingType(UPDATED_PACKING_TYPE)
            .salePackageImage(UPDATED_SALE_PACKAGE_IMAGE)
            .cartonLengthMilimeter(UPDATED_CARTON_LENGTH_MILIMETER)
            .cartonHeightMilimeter(UPDATED_CARTON_HEIGHT_MILIMETER)
            .portOfDeparture(UPDATED_PORT_OF_DEPARTURE)
            .barcode(UPDATED_BARCODE)
            .cartonWeightKg(UPDATED_CARTON_WEIGHT_KG)
            .cartonWeightGr(UPDATED_CARTON_WEIGHT_GR)
            .cartonWidthMilimeter(UPDATED_CARTON_WIDTH_MILIMETER)
            .productionLeadtimeCommitmentsFromSuppliers(UPDATED_PRODUCTION_LEADTIME_COMMITMENTS_FROM_SUPPLIERS)
            .negotiatedPrice(UPDATED_NEGOTIATED_PRICE)
            .productDescriptionAndFonctionalities(UPDATED_PRODUCT_DESCRIPTION_AND_FONCTIONALITIES)
            .drawing(UPDATED_DRAWING)
            .userManual(UPDATED_USER_MANUAL)
            .supplierMarketingService(UPDATED_SUPPLIER_MARKETING_SERVICE)
            .palletSize(UPDATED_PALLET_SIZE)
            .typeOfMarketing(UPDATED_TYPE_OF_MARKETING)
            .productPic(UPDATED_PRODUCT_PIC)
            .updateDate(UPDATED_UPDATE_DATE)
            .subItems(UPDATED_SUB_ITEMS)
            .mirror(UPDATED_MIRROR)
            .label(UPDATED_LABEL)
            .moqsPcsCommitment(UPDATED_MOQS_PCS_COMMITMENT)
            .moqCommitment(UPDATED_MOQ_COMMITMENT)
            .updatedMoqAfterNegotiation(UPDATED_UPDATED_MOQ_AFTER_NEGOTIATION)
            .uom(UPDATED_UOM)
            .bom(UPDATED_BOM)
            .priceManagementStatus(UPDATED_PRICE_MANAGEMENT_STATUS)
            .comment(UPDATED_COMMENT)
            .juneY(UPDATED_JUNE_Y)
            .commentsJuneY(UPDATED_COMMENTS_JUNE_Y)
            .decemberY(UPDATED_DECEMBER_Y)
            .commentsDecemberY(UPDATED_COMMENTS_DECEMBER_Y)
            .productTaxonomy(UPDATED_PRODUCT_TAXONOMY)
            .validPeriod(UPDATED_VALID_PERIOD)
            .withTax(UPDATED_WITH_TAX)
            .unitPrice(UPDATED_UNIT_PRICE)
            .currency(UPDATED_CURRENCY);

        restItemMockMvc
            .perform(
                put(ENTITY_API_URL_ID, updatedItem.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(updatedItem))
            )
            .andExpect(status().isOk());

        // Validate the Item in the database
        List<Item> itemList = itemRepository.findAll();
        assertThat(itemList).hasSize(databaseSizeBeforeUpdate);
        Item testItem = itemList.get(itemList.size() - 1);
        assertThat(testItem.getPeople()).isEqualTo(UPDATED_PEOPLE);
        assertThat(testItem.getItemStatus()).isEqualTo(UPDATED_ITEM_STATUS);
        assertThat(testItem.getItemFranceName()).isEqualTo(UPDATED_ITEM_FRANCE_NAME);
        assertThat(testItem.getItemId()).isEqualTo(UPDATED_ITEM_ID);
        assertThat(testItem.getBoardId()).isEqualTo(UPDATED_BOARD_ID);
        assertThat(testItem.getKingdeeId()).isEqualTo(UPDATED_KINGDEE_ID);
        assertThat(testItem.getItemName()).isEqualTo(UPDATED_ITEM_NAME);
        assertThat(testItem.getParentItem()).isEqualTo(UPDATED_PARENT_ITEM);
        assertThat(testItem.getCodeP()).isEqualTo(UPDATED_CODE_P);
        assertThat(testItem.getCodeag()).isEqualTo(UPDATED_CODEAG);
        assertThat(testItem.getMondayId()).isEqualTo(UPDATED_MONDAY_ID);
        assertThat(testItem.getDcsMerchandiser()).isEqualTo(UPDATED_DCS_MERCHANDISER);
        assertThat(testItem.getStockedInProdex()).isEqualTo(UPDATED_STOCKED_IN_PRODEX);
        assertThat(testItem.getSupplier()).isEqualTo(UPDATED_SUPPLIER);
        assertThat(testItem.getTechnicalDocuments()).isEqualTo(UPDATED_TECHNICAL_DOCUMENTS);
        assertThat(testItem.getCertification()).isEqualTo(UPDATED_CERTIFICATION);
        assertThat(testItem.getOpportunitySheet()).isEqualTo(UPDATED_OPPORTUNITY_SHEET);
        assertThat(testItem.getPackingType()).isEqualTo(UPDATED_PACKING_TYPE);
        assertThat(testItem.getSalePackageImage()).isEqualTo(UPDATED_SALE_PACKAGE_IMAGE);
        assertThat(testItem.getCartonLengthMilimeter()).isEqualTo(UPDATED_CARTON_LENGTH_MILIMETER);
        assertThat(testItem.getCartonHeightMilimeter()).isEqualTo(UPDATED_CARTON_HEIGHT_MILIMETER);
        assertThat(testItem.getPortOfDeparture()).isEqualTo(UPDATED_PORT_OF_DEPARTURE);
        assertThat(testItem.getBarcode()).isEqualTo(UPDATED_BARCODE);
        assertThat(testItem.getCartonWeightKg()).isEqualTo(UPDATED_CARTON_WEIGHT_KG);
        assertThat(testItem.getCartonWeightGr()).isEqualTo(UPDATED_CARTON_WEIGHT_GR);
        assertThat(testItem.getCartonWidthMilimeter()).isEqualTo(UPDATED_CARTON_WIDTH_MILIMETER);
        assertThat(testItem.getProductionLeadtimeCommitmentsFromSuppliers())
            .isEqualTo(UPDATED_PRODUCTION_LEADTIME_COMMITMENTS_FROM_SUPPLIERS);
        assertThat(testItem.getNegotiatedPrice()).isEqualTo(UPDATED_NEGOTIATED_PRICE);
        assertThat(testItem.getProductDescriptionAndFonctionalities()).isEqualTo(UPDATED_PRODUCT_DESCRIPTION_AND_FONCTIONALITIES);
        assertThat(testItem.getDrawing()).isEqualTo(UPDATED_DRAWING);
        assertThat(testItem.getUserManual()).isEqualTo(UPDATED_USER_MANUAL);
        assertThat(testItem.getSupplierMarketingService()).isEqualTo(UPDATED_SUPPLIER_MARKETING_SERVICE);
        assertThat(testItem.getPalletSize()).isEqualTo(UPDATED_PALLET_SIZE);
        assertThat(testItem.getTypeOfMarketing()).isEqualTo(UPDATED_TYPE_OF_MARKETING);
        assertThat(testItem.getProductPic()).isEqualTo(UPDATED_PRODUCT_PIC);
        assertThat(testItem.getUpdateDate()).isEqualTo(UPDATED_UPDATE_DATE);
        assertThat(testItem.getSubItems()).isEqualTo(UPDATED_SUB_ITEMS);
        assertThat(testItem.getMirror()).isEqualTo(UPDATED_MIRROR);
        assertThat(testItem.getLabel()).isEqualTo(UPDATED_LABEL);
        assertThat(testItem.getMoqsPcsCommitment()).isEqualTo(UPDATED_MOQS_PCS_COMMITMENT);
        assertThat(testItem.getMoqCommitment()).isEqualTo(UPDATED_MOQ_COMMITMENT);
        assertThat(testItem.getUpdatedMoqAfterNegotiation()).isEqualTo(UPDATED_UPDATED_MOQ_AFTER_NEGOTIATION);
        assertThat(testItem.getUom()).isEqualTo(UPDATED_UOM);
        assertThat(testItem.getBom()).isEqualTo(UPDATED_BOM);
        assertThat(testItem.getPriceManagementStatus()).isEqualTo(UPDATED_PRICE_MANAGEMENT_STATUS);
        assertThat(testItem.getComment()).isEqualTo(UPDATED_COMMENT);
        assertThat(testItem.getJuneY()).isEqualTo(UPDATED_JUNE_Y);
        assertThat(testItem.getCommentsJuneY()).isEqualTo(UPDATED_COMMENTS_JUNE_Y);
        assertThat(testItem.getDecemberY()).isEqualTo(UPDATED_DECEMBER_Y);
        assertThat(testItem.getCommentsDecemberY()).isEqualTo(UPDATED_COMMENTS_DECEMBER_Y);
        assertThat(testItem.getProductTaxonomy()).isEqualTo(UPDATED_PRODUCT_TAXONOMY);
        assertThat(testItem.getValidPeriod()).isEqualTo(UPDATED_VALID_PERIOD);
        assertThat(testItem.getWithTax()).isEqualTo(UPDATED_WITH_TAX);
        assertThat(testItem.getUnitPrice()).isEqualTo(UPDATED_UNIT_PRICE);
        assertThat(testItem.getCurrency()).isEqualTo(UPDATED_CURRENCY);
    }

    @Test
    @Transactional
    void putNonExistingItem() throws Exception {
        int databaseSizeBeforeUpdate = itemRepository.findAll().size();
        item.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restItemMockMvc
            .perform(
                put(ENTITY_API_URL_ID, item.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(item))
            )
            .andExpect(status().isBadRequest());

        // Validate the Item in the database
        List<Item> itemList = itemRepository.findAll();
        assertThat(itemList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchItem() throws Exception {
        int databaseSizeBeforeUpdate = itemRepository.findAll().size();
        item.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restItemMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(item))
            )
            .andExpect(status().isBadRequest());

        // Validate the Item in the database
        List<Item> itemList = itemRepository.findAll();
        assertThat(itemList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamItem() throws Exception {
        int databaseSizeBeforeUpdate = itemRepository.findAll().size();
        item.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restItemMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(item)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Item in the database
        List<Item> itemList = itemRepository.findAll();
        assertThat(itemList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateItemWithPatch() throws Exception {
        // Initialize the database
        itemRepository.saveAndFlush(item);

        int databaseSizeBeforeUpdate = itemRepository.findAll().size();

        // Update the item using partial update
        Item partialUpdatedItem = new Item();
        partialUpdatedItem.setId(item.getId());

        partialUpdatedItem
            .itemId(UPDATED_ITEM_ID)
            .parentItem(UPDATED_PARENT_ITEM)
            .codeP(UPDATED_CODE_P)
            .codeag(UPDATED_CODEAG)
            .mondayId(UPDATED_MONDAY_ID)
            .dcsMerchandiser(UPDATED_DCS_MERCHANDISER)
            .supplier(UPDATED_SUPPLIER)
            .technicalDocuments(UPDATED_TECHNICAL_DOCUMENTS)
            .certification(UPDATED_CERTIFICATION)
            .packingType(UPDATED_PACKING_TYPE)
            .portOfDeparture(UPDATED_PORT_OF_DEPARTURE)
            .cartonWeightGr(UPDATED_CARTON_WEIGHT_GR)
            .drawing(UPDATED_DRAWING)
            .userManual(UPDATED_USER_MANUAL)
            .supplierMarketingService(UPDATED_SUPPLIER_MARKETING_SERVICE)
            .typeOfMarketing(UPDATED_TYPE_OF_MARKETING)
            .uom(UPDATED_UOM)
            .bom(UPDATED_BOM)
            .priceManagementStatus(UPDATED_PRICE_MANAGEMENT_STATUS)
            .comment(UPDATED_COMMENT)
            .juneY(UPDATED_JUNE_Y)
            .decemberY(UPDATED_DECEMBER_Y)
            .commentsDecemberY(UPDATED_COMMENTS_DECEMBER_Y)
            .withTax(UPDATED_WITH_TAX);

        restItemMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedItem.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedItem))
            )
            .andExpect(status().isOk());

        // Validate the Item in the database
        List<Item> itemList = itemRepository.findAll();
        assertThat(itemList).hasSize(databaseSizeBeforeUpdate);
        Item testItem = itemList.get(itemList.size() - 1);
        assertThat(testItem.getPeople()).isEqualTo(DEFAULT_PEOPLE);
        assertThat(testItem.getItemStatus()).isEqualTo(DEFAULT_ITEM_STATUS);
        assertThat(testItem.getItemFranceName()).isEqualTo(DEFAULT_ITEM_FRANCE_NAME);
        assertThat(testItem.getItemId()).isEqualTo(UPDATED_ITEM_ID);
        assertThat(testItem.getBoardId()).isEqualTo(DEFAULT_BOARD_ID);
        assertThat(testItem.getKingdeeId()).isEqualTo(DEFAULT_KINGDEE_ID);
        assertThat(testItem.getItemName()).isEqualTo(DEFAULT_ITEM_NAME);
        assertThat(testItem.getParentItem()).isEqualTo(UPDATED_PARENT_ITEM);
        assertThat(testItem.getCodeP()).isEqualTo(UPDATED_CODE_P);
        assertThat(testItem.getCodeag()).isEqualTo(UPDATED_CODEAG);
        assertThat(testItem.getMondayId()).isEqualTo(UPDATED_MONDAY_ID);
        assertThat(testItem.getDcsMerchandiser()).isEqualTo(UPDATED_DCS_MERCHANDISER);
        assertThat(testItem.getStockedInProdex()).isEqualTo(DEFAULT_STOCKED_IN_PRODEX);
        assertThat(testItem.getSupplier()).isEqualTo(UPDATED_SUPPLIER);
        assertThat(testItem.getTechnicalDocuments()).isEqualTo(UPDATED_TECHNICAL_DOCUMENTS);
        assertThat(testItem.getCertification()).isEqualTo(UPDATED_CERTIFICATION);
        assertThat(testItem.getOpportunitySheet()).isEqualTo(DEFAULT_OPPORTUNITY_SHEET);
        assertThat(testItem.getPackingType()).isEqualTo(UPDATED_PACKING_TYPE);
        assertThat(testItem.getSalePackageImage()).isEqualTo(DEFAULT_SALE_PACKAGE_IMAGE);
        assertThat(testItem.getCartonLengthMilimeter()).isEqualTo(DEFAULT_CARTON_LENGTH_MILIMETER);
        assertThat(testItem.getCartonHeightMilimeter()).isEqualTo(DEFAULT_CARTON_HEIGHT_MILIMETER);
        assertThat(testItem.getPortOfDeparture()).isEqualTo(UPDATED_PORT_OF_DEPARTURE);
        assertThat(testItem.getBarcode()).isEqualTo(DEFAULT_BARCODE);
        assertThat(testItem.getCartonWeightKg()).isEqualTo(DEFAULT_CARTON_WEIGHT_KG);
        assertThat(testItem.getCartonWeightGr()).isEqualTo(UPDATED_CARTON_WEIGHT_GR);
        assertThat(testItem.getCartonWidthMilimeter()).isEqualTo(DEFAULT_CARTON_WIDTH_MILIMETER);
        assertThat(testItem.getProductionLeadtimeCommitmentsFromSuppliers())
            .isEqualTo(DEFAULT_PRODUCTION_LEADTIME_COMMITMENTS_FROM_SUPPLIERS);
        assertThat(testItem.getNegotiatedPrice()).isEqualTo(DEFAULT_NEGOTIATED_PRICE);
        assertThat(testItem.getProductDescriptionAndFonctionalities()).isEqualTo(DEFAULT_PRODUCT_DESCRIPTION_AND_FONCTIONALITIES);
        assertThat(testItem.getDrawing()).isEqualTo(UPDATED_DRAWING);
        assertThat(testItem.getUserManual()).isEqualTo(UPDATED_USER_MANUAL);
        assertThat(testItem.getSupplierMarketingService()).isEqualTo(UPDATED_SUPPLIER_MARKETING_SERVICE);
        assertThat(testItem.getPalletSize()).isEqualTo(DEFAULT_PALLET_SIZE);
        assertThat(testItem.getTypeOfMarketing()).isEqualTo(UPDATED_TYPE_OF_MARKETING);
        assertThat(testItem.getProductPic()).isEqualTo(DEFAULT_PRODUCT_PIC);
        assertThat(testItem.getUpdateDate()).isEqualTo(DEFAULT_UPDATE_DATE);
        assertThat(testItem.getSubItems()).isEqualTo(DEFAULT_SUB_ITEMS);
        assertThat(testItem.getMirror()).isEqualTo(DEFAULT_MIRROR);
        assertThat(testItem.getLabel()).isEqualTo(DEFAULT_LABEL);
        assertThat(testItem.getMoqsPcsCommitment()).isEqualTo(DEFAULT_MOQS_PCS_COMMITMENT);
        assertThat(testItem.getMoqCommitment()).isEqualTo(DEFAULT_MOQ_COMMITMENT);
        assertThat(testItem.getUpdatedMoqAfterNegotiation()).isEqualTo(DEFAULT_UPDATED_MOQ_AFTER_NEGOTIATION);
        assertThat(testItem.getUom()).isEqualTo(UPDATED_UOM);
        assertThat(testItem.getBom()).isEqualTo(UPDATED_BOM);
        assertThat(testItem.getPriceManagementStatus()).isEqualTo(UPDATED_PRICE_MANAGEMENT_STATUS);
        assertThat(testItem.getComment()).isEqualTo(UPDATED_COMMENT);
        assertThat(testItem.getJuneY()).isEqualTo(UPDATED_JUNE_Y);
        assertThat(testItem.getCommentsJuneY()).isEqualTo(DEFAULT_COMMENTS_JUNE_Y);
        assertThat(testItem.getDecemberY()).isEqualTo(UPDATED_DECEMBER_Y);
        assertThat(testItem.getCommentsDecemberY()).isEqualTo(UPDATED_COMMENTS_DECEMBER_Y);
        assertThat(testItem.getProductTaxonomy()).isEqualTo(DEFAULT_PRODUCT_TAXONOMY);
        assertThat(testItem.getValidPeriod()).isEqualTo(DEFAULT_VALID_PERIOD);
        assertThat(testItem.getWithTax()).isEqualTo(UPDATED_WITH_TAX);
        assertThat(testItem.getUnitPrice()).isEqualTo(DEFAULT_UNIT_PRICE);
        assertThat(testItem.getCurrency()).isEqualTo(DEFAULT_CURRENCY);
    }

    @Test
    @Transactional
    void fullUpdateItemWithPatch() throws Exception {
        // Initialize the database
        itemRepository.saveAndFlush(item);

        int databaseSizeBeforeUpdate = itemRepository.findAll().size();

        // Update the item using partial update
        Item partialUpdatedItem = new Item();
        partialUpdatedItem.setId(item.getId());

        partialUpdatedItem
            .people(UPDATED_PEOPLE)
            .itemStatus(UPDATED_ITEM_STATUS)
            .itemFranceName(UPDATED_ITEM_FRANCE_NAME)
            .itemId(UPDATED_ITEM_ID)
            .boardId(UPDATED_BOARD_ID)
            .kingdeeId(UPDATED_KINGDEE_ID)
            .itemName(UPDATED_ITEM_NAME)
            .parentItem(UPDATED_PARENT_ITEM)
            .codeP(UPDATED_CODE_P)
            .codeag(UPDATED_CODEAG)
            .mondayId(UPDATED_MONDAY_ID)
            .dcsMerchandiser(UPDATED_DCS_MERCHANDISER)
            .stockedInProdex(UPDATED_STOCKED_IN_PRODEX)
            .supplier(UPDATED_SUPPLIER)
            .technicalDocuments(UPDATED_TECHNICAL_DOCUMENTS)
            .certification(UPDATED_CERTIFICATION)
            .opportunitySheet(UPDATED_OPPORTUNITY_SHEET)
            .packingType(UPDATED_PACKING_TYPE)
            .salePackageImage(UPDATED_SALE_PACKAGE_IMAGE)
            .cartonLengthMilimeter(UPDATED_CARTON_LENGTH_MILIMETER)
            .cartonHeightMilimeter(UPDATED_CARTON_HEIGHT_MILIMETER)
            .portOfDeparture(UPDATED_PORT_OF_DEPARTURE)
            .barcode(UPDATED_BARCODE)
            .cartonWeightKg(UPDATED_CARTON_WEIGHT_KG)
            .cartonWeightGr(UPDATED_CARTON_WEIGHT_GR)
            .cartonWidthMilimeter(UPDATED_CARTON_WIDTH_MILIMETER)
            .productionLeadtimeCommitmentsFromSuppliers(UPDATED_PRODUCTION_LEADTIME_COMMITMENTS_FROM_SUPPLIERS)
            .negotiatedPrice(UPDATED_NEGOTIATED_PRICE)
            .productDescriptionAndFonctionalities(UPDATED_PRODUCT_DESCRIPTION_AND_FONCTIONALITIES)
            .drawing(UPDATED_DRAWING)
            .userManual(UPDATED_USER_MANUAL)
            .supplierMarketingService(UPDATED_SUPPLIER_MARKETING_SERVICE)
            .palletSize(UPDATED_PALLET_SIZE)
            .typeOfMarketing(UPDATED_TYPE_OF_MARKETING)
            .productPic(UPDATED_PRODUCT_PIC)
            .updateDate(UPDATED_UPDATE_DATE)
            .subItems(UPDATED_SUB_ITEMS)
            .mirror(UPDATED_MIRROR)
            .label(UPDATED_LABEL)
            .moqsPcsCommitment(UPDATED_MOQS_PCS_COMMITMENT)
            .moqCommitment(UPDATED_MOQ_COMMITMENT)
            .updatedMoqAfterNegotiation(UPDATED_UPDATED_MOQ_AFTER_NEGOTIATION)
            .uom(UPDATED_UOM)
            .bom(UPDATED_BOM)
            .priceManagementStatus(UPDATED_PRICE_MANAGEMENT_STATUS)
            .comment(UPDATED_COMMENT)
            .juneY(UPDATED_JUNE_Y)
            .commentsJuneY(UPDATED_COMMENTS_JUNE_Y)
            .decemberY(UPDATED_DECEMBER_Y)
            .commentsDecemberY(UPDATED_COMMENTS_DECEMBER_Y)
            .productTaxonomy(UPDATED_PRODUCT_TAXONOMY)
            .validPeriod(UPDATED_VALID_PERIOD)
            .withTax(UPDATED_WITH_TAX)
            .unitPrice(UPDATED_UNIT_PRICE)
            .currency(UPDATED_CURRENCY);

        restItemMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedItem.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedItem))
            )
            .andExpect(status().isOk());

        // Validate the Item in the database
        List<Item> itemList = itemRepository.findAll();
        assertThat(itemList).hasSize(databaseSizeBeforeUpdate);
        Item testItem = itemList.get(itemList.size() - 1);
        assertThat(testItem.getPeople()).isEqualTo(UPDATED_PEOPLE);
        assertThat(testItem.getItemStatus()).isEqualTo(UPDATED_ITEM_STATUS);
        assertThat(testItem.getItemFranceName()).isEqualTo(UPDATED_ITEM_FRANCE_NAME);
        assertThat(testItem.getItemId()).isEqualTo(UPDATED_ITEM_ID);
        assertThat(testItem.getBoardId()).isEqualTo(UPDATED_BOARD_ID);
        assertThat(testItem.getKingdeeId()).isEqualTo(UPDATED_KINGDEE_ID);
        assertThat(testItem.getItemName()).isEqualTo(UPDATED_ITEM_NAME);
        assertThat(testItem.getParentItem()).isEqualTo(UPDATED_PARENT_ITEM);
        assertThat(testItem.getCodeP()).isEqualTo(UPDATED_CODE_P);
        assertThat(testItem.getCodeag()).isEqualTo(UPDATED_CODEAG);
        assertThat(testItem.getMondayId()).isEqualTo(UPDATED_MONDAY_ID);
        assertThat(testItem.getDcsMerchandiser()).isEqualTo(UPDATED_DCS_MERCHANDISER);
        assertThat(testItem.getStockedInProdex()).isEqualTo(UPDATED_STOCKED_IN_PRODEX);
        assertThat(testItem.getSupplier()).isEqualTo(UPDATED_SUPPLIER);
        assertThat(testItem.getTechnicalDocuments()).isEqualTo(UPDATED_TECHNICAL_DOCUMENTS);
        assertThat(testItem.getCertification()).isEqualTo(UPDATED_CERTIFICATION);
        assertThat(testItem.getOpportunitySheet()).isEqualTo(UPDATED_OPPORTUNITY_SHEET);
        assertThat(testItem.getPackingType()).isEqualTo(UPDATED_PACKING_TYPE);
        assertThat(testItem.getSalePackageImage()).isEqualTo(UPDATED_SALE_PACKAGE_IMAGE);
        assertThat(testItem.getCartonLengthMilimeter()).isEqualTo(UPDATED_CARTON_LENGTH_MILIMETER);
        assertThat(testItem.getCartonHeightMilimeter()).isEqualTo(UPDATED_CARTON_HEIGHT_MILIMETER);
        assertThat(testItem.getPortOfDeparture()).isEqualTo(UPDATED_PORT_OF_DEPARTURE);
        assertThat(testItem.getBarcode()).isEqualTo(UPDATED_BARCODE);
        assertThat(testItem.getCartonWeightKg()).isEqualTo(UPDATED_CARTON_WEIGHT_KG);
        assertThat(testItem.getCartonWeightGr()).isEqualTo(UPDATED_CARTON_WEIGHT_GR);
        assertThat(testItem.getCartonWidthMilimeter()).isEqualTo(UPDATED_CARTON_WIDTH_MILIMETER);
        assertThat(testItem.getProductionLeadtimeCommitmentsFromSuppliers())
            .isEqualTo(UPDATED_PRODUCTION_LEADTIME_COMMITMENTS_FROM_SUPPLIERS);
        assertThat(testItem.getNegotiatedPrice()).isEqualTo(UPDATED_NEGOTIATED_PRICE);
        assertThat(testItem.getProductDescriptionAndFonctionalities()).isEqualTo(UPDATED_PRODUCT_DESCRIPTION_AND_FONCTIONALITIES);
        assertThat(testItem.getDrawing()).isEqualTo(UPDATED_DRAWING);
        assertThat(testItem.getUserManual()).isEqualTo(UPDATED_USER_MANUAL);
        assertThat(testItem.getSupplierMarketingService()).isEqualTo(UPDATED_SUPPLIER_MARKETING_SERVICE);
        assertThat(testItem.getPalletSize()).isEqualTo(UPDATED_PALLET_SIZE);
        assertThat(testItem.getTypeOfMarketing()).isEqualTo(UPDATED_TYPE_OF_MARKETING);
        assertThat(testItem.getProductPic()).isEqualTo(UPDATED_PRODUCT_PIC);
        assertThat(testItem.getUpdateDate()).isEqualTo(UPDATED_UPDATE_DATE);
        assertThat(testItem.getSubItems()).isEqualTo(UPDATED_SUB_ITEMS);
        assertThat(testItem.getMirror()).isEqualTo(UPDATED_MIRROR);
        assertThat(testItem.getLabel()).isEqualTo(UPDATED_LABEL);
        assertThat(testItem.getMoqsPcsCommitment()).isEqualTo(UPDATED_MOQS_PCS_COMMITMENT);
        assertThat(testItem.getMoqCommitment()).isEqualTo(UPDATED_MOQ_COMMITMENT);
        assertThat(testItem.getUpdatedMoqAfterNegotiation()).isEqualTo(UPDATED_UPDATED_MOQ_AFTER_NEGOTIATION);
        assertThat(testItem.getUom()).isEqualTo(UPDATED_UOM);
        assertThat(testItem.getBom()).isEqualTo(UPDATED_BOM);
        assertThat(testItem.getPriceManagementStatus()).isEqualTo(UPDATED_PRICE_MANAGEMENT_STATUS);
        assertThat(testItem.getComment()).isEqualTo(UPDATED_COMMENT);
        assertThat(testItem.getJuneY()).isEqualTo(UPDATED_JUNE_Y);
        assertThat(testItem.getCommentsJuneY()).isEqualTo(UPDATED_COMMENTS_JUNE_Y);
        assertThat(testItem.getDecemberY()).isEqualTo(UPDATED_DECEMBER_Y);
        assertThat(testItem.getCommentsDecemberY()).isEqualTo(UPDATED_COMMENTS_DECEMBER_Y);
        assertThat(testItem.getProductTaxonomy()).isEqualTo(UPDATED_PRODUCT_TAXONOMY);
        assertThat(testItem.getValidPeriod()).isEqualTo(UPDATED_VALID_PERIOD);
        assertThat(testItem.getWithTax()).isEqualTo(UPDATED_WITH_TAX);
        assertThat(testItem.getUnitPrice()).isEqualTo(UPDATED_UNIT_PRICE);
        assertThat(testItem.getCurrency()).isEqualTo(UPDATED_CURRENCY);
    }

    @Test
    @Transactional
    void patchNonExistingItem() throws Exception {
        int databaseSizeBeforeUpdate = itemRepository.findAll().size();
        item.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restItemMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, item.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(item))
            )
            .andExpect(status().isBadRequest());

        // Validate the Item in the database
        List<Item> itemList = itemRepository.findAll();
        assertThat(itemList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchItem() throws Exception {
        int databaseSizeBeforeUpdate = itemRepository.findAll().size();
        item.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restItemMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(item))
            )
            .andExpect(status().isBadRequest());

        // Validate the Item in the database
        List<Item> itemList = itemRepository.findAll();
        assertThat(itemList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamItem() throws Exception {
        int databaseSizeBeforeUpdate = itemRepository.findAll().size();
        item.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restItemMockMvc
            .perform(patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(item)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Item in the database
        List<Item> itemList = itemRepository.findAll();
        assertThat(itemList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteItem() throws Exception {
        // Initialize the database
        itemRepository.saveAndFlush(item);

        int databaseSizeBeforeDelete = itemRepository.findAll().size();

        // Delete the item
        restItemMockMvc
            .perform(delete(ENTITY_API_URL_ID, item.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Item> itemList = itemRepository.findAll();
        assertThat(itemList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
