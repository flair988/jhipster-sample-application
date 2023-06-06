package com.mycompany.myapp.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.mycompany.myapp.IntegrationTest;
import com.mycompany.myapp.domain.PI;
import com.mycompany.myapp.repository.PIRepository;
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
 * Integration tests for the {@link PIResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class PIResourceIT {

    private static final String DEFAULT_ITEM_NAME = "AAAAAAAAAA";
    private static final String UPDATED_ITEM_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_ITEM_CODE = "AAAAAAAAAA";
    private static final String UPDATED_ITEM_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_PO_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_PO_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_IS_NEW_ITEM = "AAAAAAAAAA";
    private static final String UPDATED_IS_NEW_ITEM = "BBBBBBBBBB";

    private static final String DEFAULT_CATEGORY = "AAAAAAAAAA";
    private static final String UPDATED_CATEGORY = "BBBBBBBBBB";

    private static final String DEFAULT_CLIENT = "AAAAAAAAAA";
    private static final String UPDATED_CLIENT = "BBBBBBBBBB";

    private static final String DEFAULT_SUPPLIER = "AAAAAAAAAA";
    private static final String UPDATED_SUPPLIER = "BBBBBBBBBB";

    private static final String DEFAULT_SUPPLIER_CODE = "AAAAAAAAAA";
    private static final String UPDATED_SUPPLIER_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_ORDER_DATE = "AAAAAAAAAA";
    private static final String UPDATED_ORDER_DATE = "BBBBBBBBBB";

    private static final String DEFAULT_PORT = "AAAAAAAAAA";
    private static final String UPDATED_PORT = "BBBBBBBBBB";

    private static final String DEFAULT_REQUESTED_END_OF_PROD_DATE = "AAAAAAAAAA";
    private static final String UPDATED_REQUESTED_END_OF_PROD_DATE = "BBBBBBBBBB";

    private static final String DEFAULT_ITEM_QUANTITY = "AAAAAAAAAA";
    private static final String UPDATED_ITEM_QUANTITY = "BBBBBBBBBB";

    private static final String DEFAULT_COUNTRY_OF_ORIGIN = "AAAAAAAAAA";
    private static final String UPDATED_COUNTRY_OF_ORIGIN = "BBBBBBBBBB";

    private static final String DEFAULT_COUNTRY_OF_FINAL_DESTINATION = "AAAAAAAAAA";
    private static final String UPDATED_COUNTRY_OF_FINAL_DESTINATION = "BBBBBBBBBB";

    private static final String DEFAULT_PRODUCTION_LEAD_TIME_COMMITMENT = "AAAAAAAAAA";
    private static final String UPDATED_PRODUCTION_LEAD_TIME_COMMITMENT = "BBBBBBBBBB";

    private static final String DEFAULT_CONSIGNEE = "AAAAAAAAAA";
    private static final String UPDATED_CONSIGNEE = "BBBBBBBBBB";

    private static final String DEFAULT_CARRIAGE_BY = "AAAAAAAAAA";
    private static final String UPDATED_CARRIAGE_BY = "BBBBBBBBBB";

    private static final String DEFAULT_TERMS_OF_DELIVERY = "AAAAAAAAAA";
    private static final String UPDATED_TERMS_OF_DELIVERY = "BBBBBBBBBB";

    private static final String DEFAULT_TERMS_OF_PAYMENT = "AAAAAAAAAA";
    private static final String UPDATED_TERMS_OF_PAYMENT = "BBBBBBBBBB";

    private static final String DEFAULT_ITEM_UNIT = "AAAAAAAAAA";
    private static final String UPDATED_ITEM_UNIT = "BBBBBBBBBB";

    private static final String DEFAULT_RATE = "AAAAAAAAAA";
    private static final String UPDATED_RATE = "BBBBBBBBBB";

    private static final String DEFAULT_AMOUNT = "AAAAAAAAAA";
    private static final String UPDATED_AMOUNT = "BBBBBBBBBB";

    private static final String DEFAULT_TOTAL_AMOUNT = "AAAAAAAAAA";
    private static final String UPDATED_TOTAL_AMOUNT = "BBBBBBBBBB";

    private static final String DEFAULT_DISCOUNT_RATE = "AAAAAAAAAA";
    private static final String UPDATED_DISCOUNT_RATE = "BBBBBBBBBB";

    private static final String DEFAULT_CURRENCY = "AAAAAAAAAA";
    private static final String UPDATED_CURRENCY = "BBBBBBBBBB";

    private static final String DEFAULT_PI_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_PI_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_REMARKS = "AAAAAAAAAA";
    private static final String UPDATED_REMARKS = "BBBBBBBBBB";

    private static final String DEFAULT_ITEM_ID = "AAAAAAAAAA";
    private static final String UPDATED_ITEM_ID = "BBBBBBBBBB";

    private static final String DEFAULT_BOARD_ID = "AAAAAAAAAA";
    private static final String UPDATED_BOARD_ID = "BBBBBBBBBB";

    private static final String DEFAULT_KINGDEE_ID = "AAAAAAAAAA";
    private static final String UPDATED_KINGDEE_ID = "BBBBBBBBBB";

    private static final String DEFAULT_PORT_OF_DISCHARGE = "AAAAAAAAAA";
    private static final String UPDATED_PORT_OF_DISCHARGE = "BBBBBBBBBB";

    private static final String DEFAULT_PORT_OF_LOADING = "AAAAAAAAAA";
    private static final String UPDATED_PORT_OF_LOADING = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/pis";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private PIRepository pIRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restPIMockMvc;

    private PI pI;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PI createEntity(EntityManager em) {
        PI pI = new PI()
            .itemName(DEFAULT_ITEM_NAME)
            .itemCode(DEFAULT_ITEM_CODE)
            .poNumber(DEFAULT_PO_NUMBER)
            .isNewItem(DEFAULT_IS_NEW_ITEM)
            .category(DEFAULT_CATEGORY)
            .client(DEFAULT_CLIENT)
            .supplier(DEFAULT_SUPPLIER)
            .supplierCode(DEFAULT_SUPPLIER_CODE)
            .orderDate(DEFAULT_ORDER_DATE)
            .port(DEFAULT_PORT)
            .requestedEndOfProdDate(DEFAULT_REQUESTED_END_OF_PROD_DATE)
            .itemQuantity(DEFAULT_ITEM_QUANTITY)
            .countryOfOrigin(DEFAULT_COUNTRY_OF_ORIGIN)
            .countryOfFinalDestination(DEFAULT_COUNTRY_OF_FINAL_DESTINATION)
            .productionLeadTimeCommitment(DEFAULT_PRODUCTION_LEAD_TIME_COMMITMENT)
            .consignee(DEFAULT_CONSIGNEE)
            .carriageBy(DEFAULT_CARRIAGE_BY)
            .termsOfDelivery(DEFAULT_TERMS_OF_DELIVERY)
            .termsOfPayment(DEFAULT_TERMS_OF_PAYMENT)
            .itemUnit(DEFAULT_ITEM_UNIT)
            .rate(DEFAULT_RATE)
            .amount(DEFAULT_AMOUNT)
            .totalAmount(DEFAULT_TOTAL_AMOUNT)
            .discountRate(DEFAULT_DISCOUNT_RATE)
            .currency(DEFAULT_CURRENCY)
            .piStatus(DEFAULT_PI_STATUS)
            .remarks(DEFAULT_REMARKS)
            .itemId(DEFAULT_ITEM_ID)
            .boardId(DEFAULT_BOARD_ID)
            .kingdeeId(DEFAULT_KINGDEE_ID)
            .portOfDischarge(DEFAULT_PORT_OF_DISCHARGE)
            .portOfLoading(DEFAULT_PORT_OF_LOADING);
        return pI;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PI createUpdatedEntity(EntityManager em) {
        PI pI = new PI()
            .itemName(UPDATED_ITEM_NAME)
            .itemCode(UPDATED_ITEM_CODE)
            .poNumber(UPDATED_PO_NUMBER)
            .isNewItem(UPDATED_IS_NEW_ITEM)
            .category(UPDATED_CATEGORY)
            .client(UPDATED_CLIENT)
            .supplier(UPDATED_SUPPLIER)
            .supplierCode(UPDATED_SUPPLIER_CODE)
            .orderDate(UPDATED_ORDER_DATE)
            .port(UPDATED_PORT)
            .requestedEndOfProdDate(UPDATED_REQUESTED_END_OF_PROD_DATE)
            .itemQuantity(UPDATED_ITEM_QUANTITY)
            .countryOfOrigin(UPDATED_COUNTRY_OF_ORIGIN)
            .countryOfFinalDestination(UPDATED_COUNTRY_OF_FINAL_DESTINATION)
            .productionLeadTimeCommitment(UPDATED_PRODUCTION_LEAD_TIME_COMMITMENT)
            .consignee(UPDATED_CONSIGNEE)
            .carriageBy(UPDATED_CARRIAGE_BY)
            .termsOfDelivery(UPDATED_TERMS_OF_DELIVERY)
            .termsOfPayment(UPDATED_TERMS_OF_PAYMENT)
            .itemUnit(UPDATED_ITEM_UNIT)
            .rate(UPDATED_RATE)
            .amount(UPDATED_AMOUNT)
            .totalAmount(UPDATED_TOTAL_AMOUNT)
            .discountRate(UPDATED_DISCOUNT_RATE)
            .currency(UPDATED_CURRENCY)
            .piStatus(UPDATED_PI_STATUS)
            .remarks(UPDATED_REMARKS)
            .itemId(UPDATED_ITEM_ID)
            .boardId(UPDATED_BOARD_ID)
            .kingdeeId(UPDATED_KINGDEE_ID)
            .portOfDischarge(UPDATED_PORT_OF_DISCHARGE)
            .portOfLoading(UPDATED_PORT_OF_LOADING);
        return pI;
    }

    @BeforeEach
    public void initTest() {
        pI = createEntity(em);
    }

    @Test
    @Transactional
    void createPI() throws Exception {
        int databaseSizeBeforeCreate = pIRepository.findAll().size();
        // Create the PI
        restPIMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(pI)))
            .andExpect(status().isCreated());

        // Validate the PI in the database
        List<PI> pIList = pIRepository.findAll();
        assertThat(pIList).hasSize(databaseSizeBeforeCreate + 1);
        PI testPI = pIList.get(pIList.size() - 1);
        assertThat(testPI.getItemName()).isEqualTo(DEFAULT_ITEM_NAME);
        assertThat(testPI.getItemCode()).isEqualTo(DEFAULT_ITEM_CODE);
        assertThat(testPI.getPoNumber()).isEqualTo(DEFAULT_PO_NUMBER);
        assertThat(testPI.getIsNewItem()).isEqualTo(DEFAULT_IS_NEW_ITEM);
        assertThat(testPI.getCategory()).isEqualTo(DEFAULT_CATEGORY);
        assertThat(testPI.getClient()).isEqualTo(DEFAULT_CLIENT);
        assertThat(testPI.getSupplier()).isEqualTo(DEFAULT_SUPPLIER);
        assertThat(testPI.getSupplierCode()).isEqualTo(DEFAULT_SUPPLIER_CODE);
        assertThat(testPI.getOrderDate()).isEqualTo(DEFAULT_ORDER_DATE);
        assertThat(testPI.getPort()).isEqualTo(DEFAULT_PORT);
        assertThat(testPI.getRequestedEndOfProdDate()).isEqualTo(DEFAULT_REQUESTED_END_OF_PROD_DATE);
        assertThat(testPI.getItemQuantity()).isEqualTo(DEFAULT_ITEM_QUANTITY);
        assertThat(testPI.getCountryOfOrigin()).isEqualTo(DEFAULT_COUNTRY_OF_ORIGIN);
        assertThat(testPI.getCountryOfFinalDestination()).isEqualTo(DEFAULT_COUNTRY_OF_FINAL_DESTINATION);
        assertThat(testPI.getProductionLeadTimeCommitment()).isEqualTo(DEFAULT_PRODUCTION_LEAD_TIME_COMMITMENT);
        assertThat(testPI.getConsignee()).isEqualTo(DEFAULT_CONSIGNEE);
        assertThat(testPI.getCarriageBy()).isEqualTo(DEFAULT_CARRIAGE_BY);
        assertThat(testPI.getTermsOfDelivery()).isEqualTo(DEFAULT_TERMS_OF_DELIVERY);
        assertThat(testPI.getTermsOfPayment()).isEqualTo(DEFAULT_TERMS_OF_PAYMENT);
        assertThat(testPI.getItemUnit()).isEqualTo(DEFAULT_ITEM_UNIT);
        assertThat(testPI.getRate()).isEqualTo(DEFAULT_RATE);
        assertThat(testPI.getAmount()).isEqualTo(DEFAULT_AMOUNT);
        assertThat(testPI.getTotalAmount()).isEqualTo(DEFAULT_TOTAL_AMOUNT);
        assertThat(testPI.getDiscountRate()).isEqualTo(DEFAULT_DISCOUNT_RATE);
        assertThat(testPI.getCurrency()).isEqualTo(DEFAULT_CURRENCY);
        assertThat(testPI.getPiStatus()).isEqualTo(DEFAULT_PI_STATUS);
        assertThat(testPI.getRemarks()).isEqualTo(DEFAULT_REMARKS);
        assertThat(testPI.getItemId()).isEqualTo(DEFAULT_ITEM_ID);
        assertThat(testPI.getBoardId()).isEqualTo(DEFAULT_BOARD_ID);
        assertThat(testPI.getKingdeeId()).isEqualTo(DEFAULT_KINGDEE_ID);
        assertThat(testPI.getPortOfDischarge()).isEqualTo(DEFAULT_PORT_OF_DISCHARGE);
        assertThat(testPI.getPortOfLoading()).isEqualTo(DEFAULT_PORT_OF_LOADING);
    }

    @Test
    @Transactional
    void createPIWithExistingId() throws Exception {
        // Create the PI with an existing ID
        pI.setId(1L);

        int databaseSizeBeforeCreate = pIRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restPIMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(pI)))
            .andExpect(status().isBadRequest());

        // Validate the PI in the database
        List<PI> pIList = pIRepository.findAll();
        assertThat(pIList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllPIS() throws Exception {
        // Initialize the database
        pIRepository.saveAndFlush(pI);

        // Get all the pIList
        restPIMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(pI.getId().intValue())))
            .andExpect(jsonPath("$.[*].itemName").value(hasItem(DEFAULT_ITEM_NAME)))
            .andExpect(jsonPath("$.[*].itemCode").value(hasItem(DEFAULT_ITEM_CODE)))
            .andExpect(jsonPath("$.[*].poNumber").value(hasItem(DEFAULT_PO_NUMBER)))
            .andExpect(jsonPath("$.[*].isNewItem").value(hasItem(DEFAULT_IS_NEW_ITEM)))
            .andExpect(jsonPath("$.[*].category").value(hasItem(DEFAULT_CATEGORY)))
            .andExpect(jsonPath("$.[*].client").value(hasItem(DEFAULT_CLIENT)))
            .andExpect(jsonPath("$.[*].supplier").value(hasItem(DEFAULT_SUPPLIER)))
            .andExpect(jsonPath("$.[*].supplierCode").value(hasItem(DEFAULT_SUPPLIER_CODE)))
            .andExpect(jsonPath("$.[*].orderDate").value(hasItem(DEFAULT_ORDER_DATE)))
            .andExpect(jsonPath("$.[*].port").value(hasItem(DEFAULT_PORT)))
            .andExpect(jsonPath("$.[*].requestedEndOfProdDate").value(hasItem(DEFAULT_REQUESTED_END_OF_PROD_DATE)))
            .andExpect(jsonPath("$.[*].itemQuantity").value(hasItem(DEFAULT_ITEM_QUANTITY)))
            .andExpect(jsonPath("$.[*].countryOfOrigin").value(hasItem(DEFAULT_COUNTRY_OF_ORIGIN)))
            .andExpect(jsonPath("$.[*].countryOfFinalDestination").value(hasItem(DEFAULT_COUNTRY_OF_FINAL_DESTINATION)))
            .andExpect(jsonPath("$.[*].productionLeadTimeCommitment").value(hasItem(DEFAULT_PRODUCTION_LEAD_TIME_COMMITMENT)))
            .andExpect(jsonPath("$.[*].consignee").value(hasItem(DEFAULT_CONSIGNEE)))
            .andExpect(jsonPath("$.[*].carriageBy").value(hasItem(DEFAULT_CARRIAGE_BY)))
            .andExpect(jsonPath("$.[*].termsOfDelivery").value(hasItem(DEFAULT_TERMS_OF_DELIVERY)))
            .andExpect(jsonPath("$.[*].termsOfPayment").value(hasItem(DEFAULT_TERMS_OF_PAYMENT)))
            .andExpect(jsonPath("$.[*].itemUnit").value(hasItem(DEFAULT_ITEM_UNIT)))
            .andExpect(jsonPath("$.[*].rate").value(hasItem(DEFAULT_RATE)))
            .andExpect(jsonPath("$.[*].amount").value(hasItem(DEFAULT_AMOUNT)))
            .andExpect(jsonPath("$.[*].totalAmount").value(hasItem(DEFAULT_TOTAL_AMOUNT)))
            .andExpect(jsonPath("$.[*].discountRate").value(hasItem(DEFAULT_DISCOUNT_RATE)))
            .andExpect(jsonPath("$.[*].currency").value(hasItem(DEFAULT_CURRENCY)))
            .andExpect(jsonPath("$.[*].piStatus").value(hasItem(DEFAULT_PI_STATUS)))
            .andExpect(jsonPath("$.[*].remarks").value(hasItem(DEFAULT_REMARKS)))
            .andExpect(jsonPath("$.[*].itemId").value(hasItem(DEFAULT_ITEM_ID)))
            .andExpect(jsonPath("$.[*].boardId").value(hasItem(DEFAULT_BOARD_ID)))
            .andExpect(jsonPath("$.[*].kingdeeId").value(hasItem(DEFAULT_KINGDEE_ID)))
            .andExpect(jsonPath("$.[*].portOfDischarge").value(hasItem(DEFAULT_PORT_OF_DISCHARGE)))
            .andExpect(jsonPath("$.[*].portOfLoading").value(hasItem(DEFAULT_PORT_OF_LOADING)));
    }

    @Test
    @Transactional
    void getPI() throws Exception {
        // Initialize the database
        pIRepository.saveAndFlush(pI);

        // Get the pI
        restPIMockMvc
            .perform(get(ENTITY_API_URL_ID, pI.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(pI.getId().intValue()))
            .andExpect(jsonPath("$.itemName").value(DEFAULT_ITEM_NAME))
            .andExpect(jsonPath("$.itemCode").value(DEFAULT_ITEM_CODE))
            .andExpect(jsonPath("$.poNumber").value(DEFAULT_PO_NUMBER))
            .andExpect(jsonPath("$.isNewItem").value(DEFAULT_IS_NEW_ITEM))
            .andExpect(jsonPath("$.category").value(DEFAULT_CATEGORY))
            .andExpect(jsonPath("$.client").value(DEFAULT_CLIENT))
            .andExpect(jsonPath("$.supplier").value(DEFAULT_SUPPLIER))
            .andExpect(jsonPath("$.supplierCode").value(DEFAULT_SUPPLIER_CODE))
            .andExpect(jsonPath("$.orderDate").value(DEFAULT_ORDER_DATE))
            .andExpect(jsonPath("$.port").value(DEFAULT_PORT))
            .andExpect(jsonPath("$.requestedEndOfProdDate").value(DEFAULT_REQUESTED_END_OF_PROD_DATE))
            .andExpect(jsonPath("$.itemQuantity").value(DEFAULT_ITEM_QUANTITY))
            .andExpect(jsonPath("$.countryOfOrigin").value(DEFAULT_COUNTRY_OF_ORIGIN))
            .andExpect(jsonPath("$.countryOfFinalDestination").value(DEFAULT_COUNTRY_OF_FINAL_DESTINATION))
            .andExpect(jsonPath("$.productionLeadTimeCommitment").value(DEFAULT_PRODUCTION_LEAD_TIME_COMMITMENT))
            .andExpect(jsonPath("$.consignee").value(DEFAULT_CONSIGNEE))
            .andExpect(jsonPath("$.carriageBy").value(DEFAULT_CARRIAGE_BY))
            .andExpect(jsonPath("$.termsOfDelivery").value(DEFAULT_TERMS_OF_DELIVERY))
            .andExpect(jsonPath("$.termsOfPayment").value(DEFAULT_TERMS_OF_PAYMENT))
            .andExpect(jsonPath("$.itemUnit").value(DEFAULT_ITEM_UNIT))
            .andExpect(jsonPath("$.rate").value(DEFAULT_RATE))
            .andExpect(jsonPath("$.amount").value(DEFAULT_AMOUNT))
            .andExpect(jsonPath("$.totalAmount").value(DEFAULT_TOTAL_AMOUNT))
            .andExpect(jsonPath("$.discountRate").value(DEFAULT_DISCOUNT_RATE))
            .andExpect(jsonPath("$.currency").value(DEFAULT_CURRENCY))
            .andExpect(jsonPath("$.piStatus").value(DEFAULT_PI_STATUS))
            .andExpect(jsonPath("$.remarks").value(DEFAULT_REMARKS))
            .andExpect(jsonPath("$.itemId").value(DEFAULT_ITEM_ID))
            .andExpect(jsonPath("$.boardId").value(DEFAULT_BOARD_ID))
            .andExpect(jsonPath("$.kingdeeId").value(DEFAULT_KINGDEE_ID))
            .andExpect(jsonPath("$.portOfDischarge").value(DEFAULT_PORT_OF_DISCHARGE))
            .andExpect(jsonPath("$.portOfLoading").value(DEFAULT_PORT_OF_LOADING));
    }

    @Test
    @Transactional
    void getNonExistingPI() throws Exception {
        // Get the pI
        restPIMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingPI() throws Exception {
        // Initialize the database
        pIRepository.saveAndFlush(pI);

        int databaseSizeBeforeUpdate = pIRepository.findAll().size();

        // Update the pI
        PI updatedPI = pIRepository.findById(pI.getId()).get();
        // Disconnect from session so that the updates on updatedPI are not directly saved in db
        em.detach(updatedPI);
        updatedPI
            .itemName(UPDATED_ITEM_NAME)
            .itemCode(UPDATED_ITEM_CODE)
            .poNumber(UPDATED_PO_NUMBER)
            .isNewItem(UPDATED_IS_NEW_ITEM)
            .category(UPDATED_CATEGORY)
            .client(UPDATED_CLIENT)
            .supplier(UPDATED_SUPPLIER)
            .supplierCode(UPDATED_SUPPLIER_CODE)
            .orderDate(UPDATED_ORDER_DATE)
            .port(UPDATED_PORT)
            .requestedEndOfProdDate(UPDATED_REQUESTED_END_OF_PROD_DATE)
            .itemQuantity(UPDATED_ITEM_QUANTITY)
            .countryOfOrigin(UPDATED_COUNTRY_OF_ORIGIN)
            .countryOfFinalDestination(UPDATED_COUNTRY_OF_FINAL_DESTINATION)
            .productionLeadTimeCommitment(UPDATED_PRODUCTION_LEAD_TIME_COMMITMENT)
            .consignee(UPDATED_CONSIGNEE)
            .carriageBy(UPDATED_CARRIAGE_BY)
            .termsOfDelivery(UPDATED_TERMS_OF_DELIVERY)
            .termsOfPayment(UPDATED_TERMS_OF_PAYMENT)
            .itemUnit(UPDATED_ITEM_UNIT)
            .rate(UPDATED_RATE)
            .amount(UPDATED_AMOUNT)
            .totalAmount(UPDATED_TOTAL_AMOUNT)
            .discountRate(UPDATED_DISCOUNT_RATE)
            .currency(UPDATED_CURRENCY)
            .piStatus(UPDATED_PI_STATUS)
            .remarks(UPDATED_REMARKS)
            .itemId(UPDATED_ITEM_ID)
            .boardId(UPDATED_BOARD_ID)
            .kingdeeId(UPDATED_KINGDEE_ID)
            .portOfDischarge(UPDATED_PORT_OF_DISCHARGE)
            .portOfLoading(UPDATED_PORT_OF_LOADING);

        restPIMockMvc
            .perform(
                put(ENTITY_API_URL_ID, updatedPI.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(updatedPI))
            )
            .andExpect(status().isOk());

        // Validate the PI in the database
        List<PI> pIList = pIRepository.findAll();
        assertThat(pIList).hasSize(databaseSizeBeforeUpdate);
        PI testPI = pIList.get(pIList.size() - 1);
        assertThat(testPI.getItemName()).isEqualTo(UPDATED_ITEM_NAME);
        assertThat(testPI.getItemCode()).isEqualTo(UPDATED_ITEM_CODE);
        assertThat(testPI.getPoNumber()).isEqualTo(UPDATED_PO_NUMBER);
        assertThat(testPI.getIsNewItem()).isEqualTo(UPDATED_IS_NEW_ITEM);
        assertThat(testPI.getCategory()).isEqualTo(UPDATED_CATEGORY);
        assertThat(testPI.getClient()).isEqualTo(UPDATED_CLIENT);
        assertThat(testPI.getSupplier()).isEqualTo(UPDATED_SUPPLIER);
        assertThat(testPI.getSupplierCode()).isEqualTo(UPDATED_SUPPLIER_CODE);
        assertThat(testPI.getOrderDate()).isEqualTo(UPDATED_ORDER_DATE);
        assertThat(testPI.getPort()).isEqualTo(UPDATED_PORT);
        assertThat(testPI.getRequestedEndOfProdDate()).isEqualTo(UPDATED_REQUESTED_END_OF_PROD_DATE);
        assertThat(testPI.getItemQuantity()).isEqualTo(UPDATED_ITEM_QUANTITY);
        assertThat(testPI.getCountryOfOrigin()).isEqualTo(UPDATED_COUNTRY_OF_ORIGIN);
        assertThat(testPI.getCountryOfFinalDestination()).isEqualTo(UPDATED_COUNTRY_OF_FINAL_DESTINATION);
        assertThat(testPI.getProductionLeadTimeCommitment()).isEqualTo(UPDATED_PRODUCTION_LEAD_TIME_COMMITMENT);
        assertThat(testPI.getConsignee()).isEqualTo(UPDATED_CONSIGNEE);
        assertThat(testPI.getCarriageBy()).isEqualTo(UPDATED_CARRIAGE_BY);
        assertThat(testPI.getTermsOfDelivery()).isEqualTo(UPDATED_TERMS_OF_DELIVERY);
        assertThat(testPI.getTermsOfPayment()).isEqualTo(UPDATED_TERMS_OF_PAYMENT);
        assertThat(testPI.getItemUnit()).isEqualTo(UPDATED_ITEM_UNIT);
        assertThat(testPI.getRate()).isEqualTo(UPDATED_RATE);
        assertThat(testPI.getAmount()).isEqualTo(UPDATED_AMOUNT);
        assertThat(testPI.getTotalAmount()).isEqualTo(UPDATED_TOTAL_AMOUNT);
        assertThat(testPI.getDiscountRate()).isEqualTo(UPDATED_DISCOUNT_RATE);
        assertThat(testPI.getCurrency()).isEqualTo(UPDATED_CURRENCY);
        assertThat(testPI.getPiStatus()).isEqualTo(UPDATED_PI_STATUS);
        assertThat(testPI.getRemarks()).isEqualTo(UPDATED_REMARKS);
        assertThat(testPI.getItemId()).isEqualTo(UPDATED_ITEM_ID);
        assertThat(testPI.getBoardId()).isEqualTo(UPDATED_BOARD_ID);
        assertThat(testPI.getKingdeeId()).isEqualTo(UPDATED_KINGDEE_ID);
        assertThat(testPI.getPortOfDischarge()).isEqualTo(UPDATED_PORT_OF_DISCHARGE);
        assertThat(testPI.getPortOfLoading()).isEqualTo(UPDATED_PORT_OF_LOADING);
    }

    @Test
    @Transactional
    void putNonExistingPI() throws Exception {
        int databaseSizeBeforeUpdate = pIRepository.findAll().size();
        pI.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restPIMockMvc
            .perform(
                put(ENTITY_API_URL_ID, pI.getId()).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(pI))
            )
            .andExpect(status().isBadRequest());

        // Validate the PI in the database
        List<PI> pIList = pIRepository.findAll();
        assertThat(pIList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchPI() throws Exception {
        int databaseSizeBeforeUpdate = pIRepository.findAll().size();
        pI.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restPIMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(pI))
            )
            .andExpect(status().isBadRequest());

        // Validate the PI in the database
        List<PI> pIList = pIRepository.findAll();
        assertThat(pIList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamPI() throws Exception {
        int databaseSizeBeforeUpdate = pIRepository.findAll().size();
        pI.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restPIMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(pI)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the PI in the database
        List<PI> pIList = pIRepository.findAll();
        assertThat(pIList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdatePIWithPatch() throws Exception {
        // Initialize the database
        pIRepository.saveAndFlush(pI);

        int databaseSizeBeforeUpdate = pIRepository.findAll().size();

        // Update the pI using partial update
        PI partialUpdatedPI = new PI();
        partialUpdatedPI.setId(pI.getId());

        partialUpdatedPI
            .category(UPDATED_CATEGORY)
            .client(UPDATED_CLIENT)
            .supplier(UPDATED_SUPPLIER)
            .supplierCode(UPDATED_SUPPLIER_CODE)
            .countryOfFinalDestination(UPDATED_COUNTRY_OF_FINAL_DESTINATION)
            .productionLeadTimeCommitment(UPDATED_PRODUCTION_LEAD_TIME_COMMITMENT)
            .consignee(UPDATED_CONSIGNEE)
            .carriageBy(UPDATED_CARRIAGE_BY)
            .amount(UPDATED_AMOUNT)
            .totalAmount(UPDATED_TOTAL_AMOUNT)
            .discountRate(UPDATED_DISCOUNT_RATE)
            .currency(UPDATED_CURRENCY)
            .piStatus(UPDATED_PI_STATUS)
            .boardId(UPDATED_BOARD_ID)
            .kingdeeId(UPDATED_KINGDEE_ID)
            .portOfDischarge(UPDATED_PORT_OF_DISCHARGE)
            .portOfLoading(UPDATED_PORT_OF_LOADING);

        restPIMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedPI.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedPI))
            )
            .andExpect(status().isOk());

        // Validate the PI in the database
        List<PI> pIList = pIRepository.findAll();
        assertThat(pIList).hasSize(databaseSizeBeforeUpdate);
        PI testPI = pIList.get(pIList.size() - 1);
        assertThat(testPI.getItemName()).isEqualTo(DEFAULT_ITEM_NAME);
        assertThat(testPI.getItemCode()).isEqualTo(DEFAULT_ITEM_CODE);
        assertThat(testPI.getPoNumber()).isEqualTo(DEFAULT_PO_NUMBER);
        assertThat(testPI.getIsNewItem()).isEqualTo(DEFAULT_IS_NEW_ITEM);
        assertThat(testPI.getCategory()).isEqualTo(UPDATED_CATEGORY);
        assertThat(testPI.getClient()).isEqualTo(UPDATED_CLIENT);
        assertThat(testPI.getSupplier()).isEqualTo(UPDATED_SUPPLIER);
        assertThat(testPI.getSupplierCode()).isEqualTo(UPDATED_SUPPLIER_CODE);
        assertThat(testPI.getOrderDate()).isEqualTo(DEFAULT_ORDER_DATE);
        assertThat(testPI.getPort()).isEqualTo(DEFAULT_PORT);
        assertThat(testPI.getRequestedEndOfProdDate()).isEqualTo(DEFAULT_REQUESTED_END_OF_PROD_DATE);
        assertThat(testPI.getItemQuantity()).isEqualTo(DEFAULT_ITEM_QUANTITY);
        assertThat(testPI.getCountryOfOrigin()).isEqualTo(DEFAULT_COUNTRY_OF_ORIGIN);
        assertThat(testPI.getCountryOfFinalDestination()).isEqualTo(UPDATED_COUNTRY_OF_FINAL_DESTINATION);
        assertThat(testPI.getProductionLeadTimeCommitment()).isEqualTo(UPDATED_PRODUCTION_LEAD_TIME_COMMITMENT);
        assertThat(testPI.getConsignee()).isEqualTo(UPDATED_CONSIGNEE);
        assertThat(testPI.getCarriageBy()).isEqualTo(UPDATED_CARRIAGE_BY);
        assertThat(testPI.getTermsOfDelivery()).isEqualTo(DEFAULT_TERMS_OF_DELIVERY);
        assertThat(testPI.getTermsOfPayment()).isEqualTo(DEFAULT_TERMS_OF_PAYMENT);
        assertThat(testPI.getItemUnit()).isEqualTo(DEFAULT_ITEM_UNIT);
        assertThat(testPI.getRate()).isEqualTo(DEFAULT_RATE);
        assertThat(testPI.getAmount()).isEqualTo(UPDATED_AMOUNT);
        assertThat(testPI.getTotalAmount()).isEqualTo(UPDATED_TOTAL_AMOUNT);
        assertThat(testPI.getDiscountRate()).isEqualTo(UPDATED_DISCOUNT_RATE);
        assertThat(testPI.getCurrency()).isEqualTo(UPDATED_CURRENCY);
        assertThat(testPI.getPiStatus()).isEqualTo(UPDATED_PI_STATUS);
        assertThat(testPI.getRemarks()).isEqualTo(DEFAULT_REMARKS);
        assertThat(testPI.getItemId()).isEqualTo(DEFAULT_ITEM_ID);
        assertThat(testPI.getBoardId()).isEqualTo(UPDATED_BOARD_ID);
        assertThat(testPI.getKingdeeId()).isEqualTo(UPDATED_KINGDEE_ID);
        assertThat(testPI.getPortOfDischarge()).isEqualTo(UPDATED_PORT_OF_DISCHARGE);
        assertThat(testPI.getPortOfLoading()).isEqualTo(UPDATED_PORT_OF_LOADING);
    }

    @Test
    @Transactional
    void fullUpdatePIWithPatch() throws Exception {
        // Initialize the database
        pIRepository.saveAndFlush(pI);

        int databaseSizeBeforeUpdate = pIRepository.findAll().size();

        // Update the pI using partial update
        PI partialUpdatedPI = new PI();
        partialUpdatedPI.setId(pI.getId());

        partialUpdatedPI
            .itemName(UPDATED_ITEM_NAME)
            .itemCode(UPDATED_ITEM_CODE)
            .poNumber(UPDATED_PO_NUMBER)
            .isNewItem(UPDATED_IS_NEW_ITEM)
            .category(UPDATED_CATEGORY)
            .client(UPDATED_CLIENT)
            .supplier(UPDATED_SUPPLIER)
            .supplierCode(UPDATED_SUPPLIER_CODE)
            .orderDate(UPDATED_ORDER_DATE)
            .port(UPDATED_PORT)
            .requestedEndOfProdDate(UPDATED_REQUESTED_END_OF_PROD_DATE)
            .itemQuantity(UPDATED_ITEM_QUANTITY)
            .countryOfOrigin(UPDATED_COUNTRY_OF_ORIGIN)
            .countryOfFinalDestination(UPDATED_COUNTRY_OF_FINAL_DESTINATION)
            .productionLeadTimeCommitment(UPDATED_PRODUCTION_LEAD_TIME_COMMITMENT)
            .consignee(UPDATED_CONSIGNEE)
            .carriageBy(UPDATED_CARRIAGE_BY)
            .termsOfDelivery(UPDATED_TERMS_OF_DELIVERY)
            .termsOfPayment(UPDATED_TERMS_OF_PAYMENT)
            .itemUnit(UPDATED_ITEM_UNIT)
            .rate(UPDATED_RATE)
            .amount(UPDATED_AMOUNT)
            .totalAmount(UPDATED_TOTAL_AMOUNT)
            .discountRate(UPDATED_DISCOUNT_RATE)
            .currency(UPDATED_CURRENCY)
            .piStatus(UPDATED_PI_STATUS)
            .remarks(UPDATED_REMARKS)
            .itemId(UPDATED_ITEM_ID)
            .boardId(UPDATED_BOARD_ID)
            .kingdeeId(UPDATED_KINGDEE_ID)
            .portOfDischarge(UPDATED_PORT_OF_DISCHARGE)
            .portOfLoading(UPDATED_PORT_OF_LOADING);

        restPIMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedPI.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedPI))
            )
            .andExpect(status().isOk());

        // Validate the PI in the database
        List<PI> pIList = pIRepository.findAll();
        assertThat(pIList).hasSize(databaseSizeBeforeUpdate);
        PI testPI = pIList.get(pIList.size() - 1);
        assertThat(testPI.getItemName()).isEqualTo(UPDATED_ITEM_NAME);
        assertThat(testPI.getItemCode()).isEqualTo(UPDATED_ITEM_CODE);
        assertThat(testPI.getPoNumber()).isEqualTo(UPDATED_PO_NUMBER);
        assertThat(testPI.getIsNewItem()).isEqualTo(UPDATED_IS_NEW_ITEM);
        assertThat(testPI.getCategory()).isEqualTo(UPDATED_CATEGORY);
        assertThat(testPI.getClient()).isEqualTo(UPDATED_CLIENT);
        assertThat(testPI.getSupplier()).isEqualTo(UPDATED_SUPPLIER);
        assertThat(testPI.getSupplierCode()).isEqualTo(UPDATED_SUPPLIER_CODE);
        assertThat(testPI.getOrderDate()).isEqualTo(UPDATED_ORDER_DATE);
        assertThat(testPI.getPort()).isEqualTo(UPDATED_PORT);
        assertThat(testPI.getRequestedEndOfProdDate()).isEqualTo(UPDATED_REQUESTED_END_OF_PROD_DATE);
        assertThat(testPI.getItemQuantity()).isEqualTo(UPDATED_ITEM_QUANTITY);
        assertThat(testPI.getCountryOfOrigin()).isEqualTo(UPDATED_COUNTRY_OF_ORIGIN);
        assertThat(testPI.getCountryOfFinalDestination()).isEqualTo(UPDATED_COUNTRY_OF_FINAL_DESTINATION);
        assertThat(testPI.getProductionLeadTimeCommitment()).isEqualTo(UPDATED_PRODUCTION_LEAD_TIME_COMMITMENT);
        assertThat(testPI.getConsignee()).isEqualTo(UPDATED_CONSIGNEE);
        assertThat(testPI.getCarriageBy()).isEqualTo(UPDATED_CARRIAGE_BY);
        assertThat(testPI.getTermsOfDelivery()).isEqualTo(UPDATED_TERMS_OF_DELIVERY);
        assertThat(testPI.getTermsOfPayment()).isEqualTo(UPDATED_TERMS_OF_PAYMENT);
        assertThat(testPI.getItemUnit()).isEqualTo(UPDATED_ITEM_UNIT);
        assertThat(testPI.getRate()).isEqualTo(UPDATED_RATE);
        assertThat(testPI.getAmount()).isEqualTo(UPDATED_AMOUNT);
        assertThat(testPI.getTotalAmount()).isEqualTo(UPDATED_TOTAL_AMOUNT);
        assertThat(testPI.getDiscountRate()).isEqualTo(UPDATED_DISCOUNT_RATE);
        assertThat(testPI.getCurrency()).isEqualTo(UPDATED_CURRENCY);
        assertThat(testPI.getPiStatus()).isEqualTo(UPDATED_PI_STATUS);
        assertThat(testPI.getRemarks()).isEqualTo(UPDATED_REMARKS);
        assertThat(testPI.getItemId()).isEqualTo(UPDATED_ITEM_ID);
        assertThat(testPI.getBoardId()).isEqualTo(UPDATED_BOARD_ID);
        assertThat(testPI.getKingdeeId()).isEqualTo(UPDATED_KINGDEE_ID);
        assertThat(testPI.getPortOfDischarge()).isEqualTo(UPDATED_PORT_OF_DISCHARGE);
        assertThat(testPI.getPortOfLoading()).isEqualTo(UPDATED_PORT_OF_LOADING);
    }

    @Test
    @Transactional
    void patchNonExistingPI() throws Exception {
        int databaseSizeBeforeUpdate = pIRepository.findAll().size();
        pI.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restPIMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, pI.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(pI))
            )
            .andExpect(status().isBadRequest());

        // Validate the PI in the database
        List<PI> pIList = pIRepository.findAll();
        assertThat(pIList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchPI() throws Exception {
        int databaseSizeBeforeUpdate = pIRepository.findAll().size();
        pI.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restPIMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(pI))
            )
            .andExpect(status().isBadRequest());

        // Validate the PI in the database
        List<PI> pIList = pIRepository.findAll();
        assertThat(pIList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamPI() throws Exception {
        int databaseSizeBeforeUpdate = pIRepository.findAll().size();
        pI.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restPIMockMvc
            .perform(patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(pI)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the PI in the database
        List<PI> pIList = pIRepository.findAll();
        assertThat(pIList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deletePI() throws Exception {
        // Initialize the database
        pIRepository.saveAndFlush(pI);

        int databaseSizeBeforeDelete = pIRepository.findAll().size();

        // Delete the pI
        restPIMockMvc.perform(delete(ENTITY_API_URL_ID, pI.getId()).accept(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<PI> pIList = pIRepository.findAll();
        assertThat(pIList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
