package com.mycompany.myapp.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.mycompany.myapp.IntegrationTest;
import com.mycompany.myapp.domain.OrderFollowUp;
import com.mycompany.myapp.repository.OrderFollowUpRepository;
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
 * Integration tests for the {@link OrderFollowUpResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class OrderFollowUpResourceIT {

    private static final String DEFAULT_ITEM_ID = "AAAAAAAAAA";
    private static final String UPDATED_ITEM_ID = "BBBBBBBBBB";

    private static final String DEFAULT_PO_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_PO_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_CUSTOMER = "AAAAAAAAAA";
    private static final String UPDATED_CUSTOMER = "BBBBBBBBBB";

    private static final String DEFAULT_SUPPLIER = "AAAAAAAAAA";
    private static final String UPDATED_SUPPLIER = "BBBBBBBBBB";

    private static final String DEFAULT_ORDER_DATE = "AAAAAAAAAA";
    private static final String UPDATED_ORDER_DATE = "BBBBBBBBBB";

    private static final String DEFAULT_CATE_GORY = "AAAAAAAAAA";
    private static final String UPDATED_CATE_GORY = "BBBBBBBBBB";

    private static final String DEFAULT_INSPECTION_DATE = "AAAAAAAAAA";
    private static final String UPDATED_INSPECTION_DATE = "BBBBBBBBBB";

    private static final String DEFAULT_REQUEST_END_OF_PROD_DATE = "AAAAAAAAAA";
    private static final String UPDATED_REQUEST_END_OF_PROD_DATE = "BBBBBBBBBB";

    private static final String DEFAULT_TOTAL_AMOUNT = "AAAAAAAAAA";
    private static final String UPDATED_TOTAL_AMOUNT = "BBBBBBBBBB";

    private static final String DEFAULT_TOTAL_DISCOUNT = "AAAAAAAAAA";
    private static final String UPDATED_TOTAL_DISCOUNT = "BBBBBBBBBB";

    private static final String DEFAULT_DIS_COUNT_RATE = "AAAAAAAAAA";
    private static final String UPDATED_DIS_COUNT_RATE = "BBBBBBBBBB";

    private static final String DEFAULT_REGULAR_CHECK = "AAAAAAAAAA";
    private static final String UPDATED_REGULAR_CHECK = "BBBBBBBBBB";

    private static final String DEFAULT_ETD = "AAAAAAAAAA";
    private static final String UPDATED_ETD = "BBBBBBBBBB";

    private static final String DEFAULT_ATD = "AAAAAAAAAA";
    private static final String UPDATED_ATD = "BBBBBBBBBB";

    private static final String DEFAULT_ETA = "AAAAAAAAAA";
    private static final String UPDATED_ETA = "BBBBBBBBBB";

    private static final String DEFAULT_UPDATED_ETA = "AAAAAAAAAA";
    private static final String UPDATED_UPDATED_ETA = "BBBBBBBBBB";

    private static final String DEFAULT_FORWARDER = "AAAAAAAAAA";
    private static final String UPDATED_FORWARDER = "BBBBBBBBBB";

    private static final String DEFAULT_DOCUMENT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_DOCUMENT_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_CUSTOM_INSTRUCTION = "AAAAAAAAAA";
    private static final String UPDATED_CUSTOM_INSTRUCTION = "BBBBBBBBBB";

    private static final String DEFAULT_CUSTOM_INSPECTION = "AAAAAAAAAA";
    private static final String UPDATED_CUSTOM_INSPECTION = "BBBBBBBBBB";

    private static final String DEFAULT_DEPOSIT_PAYMENT_DATE = "AAAAAAAAAA";
    private static final String UPDATED_DEPOSIT_PAYMENT_DATE = "BBBBBBBBBB";

    private static final String DEFAULT_BALANCE_OF_TOTAL_PAYMENT_DATE = "AAAAAAAAAA";
    private static final String UPDATED_BALANCE_OF_TOTAL_PAYMENT_DATE = "BBBBBBBBBB";

    private static final String DEFAULT_AMOUNT_DEPOSIT_PAYMENT = "AAAAAAAAAA";
    private static final String UPDATED_AMOUNT_DEPOSIT_PAYMENT = "BBBBBBBBBB";

    private static final String DEFAULT_AMOUNT_PAYMENT = "AAAAAAAAAA";
    private static final String UPDATED_AMOUNT_PAYMENT = "BBBBBBBBBB";

    private static final String DEFAULT_DC_MEMBER = "AAAAAAAAAA";
    private static final String UPDATED_DC_MEMBER = "BBBBBBBBBB";

    private static final String DEFAULT_COMMENT = "AAAAAAAAAA";
    private static final String UPDATED_COMMENT = "BBBBBBBBBB";

    private static final String DEFAULT_ITEM_NAME = "AAAAAAAAAA";
    private static final String UPDATED_ITEM_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_BOARD_ID = "AAAAAAAAAA";
    private static final String UPDATED_BOARD_ID = "BBBBBBBBBB";

    private static final String DEFAULT_KINGDEE_ID = "AAAAAAAAAA";
    private static final String UPDATED_KINGDEE_ID = "BBBBBBBBBB";

    private static final String DEFAULT_PARENT_KINGDEE_ID = "AAAAAAAAAA";
    private static final String UPDATED_PARENT_KINGDEE_ID = "BBBBBBBBBB";

    private static final String DEFAULT_PARENT_MONDAY_ID = "AAAAAAAAAA";
    private static final String UPDATED_PARENT_MONDAY_ID = "BBBBBBBBBB";

    private static final String DEFAULT_QTY = "AAAAAAAAAA";
    private static final String UPDATED_QTY = "BBBBBBBBBB";

    private static final String DEFAULT_ITEM_CODE = "AAAAAAAAAA";
    private static final String UPDATED_ITEM_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_AMOUNT = "AAAAAAAAAA";
    private static final String UPDATED_AMOUNT = "BBBBBBBBBB";

    private static final String DEFAULT_DISCOUNT = "AAAAAAAAAA";
    private static final String UPDATED_DISCOUNT = "BBBBBBBBBB";

    private static final String DEFAULT_UNIT = "AAAAAAAAAA";
    private static final String UPDATED_UNIT = "BBBBBBBBBB";

    private static final String DEFAULT_CONTRACT_END_OF_PROD_DATE = "AAAAAAAAAA";
    private static final String UPDATED_CONTRACT_END_OF_PROD_DATE = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/order-follow-ups";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private OrderFollowUpRepository orderFollowUpRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restOrderFollowUpMockMvc;

    private OrderFollowUp orderFollowUp;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static OrderFollowUp createEntity(EntityManager em) {
        OrderFollowUp orderFollowUp = new OrderFollowUp()
            .itemId(DEFAULT_ITEM_ID)
            .poNumber(DEFAULT_PO_NUMBER)
            .customer(DEFAULT_CUSTOMER)
            .supplier(DEFAULT_SUPPLIER)
            .orderDate(DEFAULT_ORDER_DATE)
            .cateGory(DEFAULT_CATE_GORY)
            .inspectionDate(DEFAULT_INSPECTION_DATE)
            .requestEndOfProdDate(DEFAULT_REQUEST_END_OF_PROD_DATE)
            .totalAmount(DEFAULT_TOTAL_AMOUNT)
            .totalDiscount(DEFAULT_TOTAL_DISCOUNT)
            .disCountRate(DEFAULT_DIS_COUNT_RATE)
            .regularCheck(DEFAULT_REGULAR_CHECK)
            .etd(DEFAULT_ETD)
            .atd(DEFAULT_ATD)
            .eta(DEFAULT_ETA)
            .updatedEta(DEFAULT_UPDATED_ETA)
            .forwarder(DEFAULT_FORWARDER)
            .documentStatus(DEFAULT_DOCUMENT_STATUS)
            .customInstruction(DEFAULT_CUSTOM_INSTRUCTION)
            .customInspection(DEFAULT_CUSTOM_INSPECTION)
            .depositPaymentDate(DEFAULT_DEPOSIT_PAYMENT_DATE)
            .balanceOfTotalPaymentDate(DEFAULT_BALANCE_OF_TOTAL_PAYMENT_DATE)
            .amountDepositPayment(DEFAULT_AMOUNT_DEPOSIT_PAYMENT)
            .amountPayment(DEFAULT_AMOUNT_PAYMENT)
            .dcMember(DEFAULT_DC_MEMBER)
            .comment(DEFAULT_COMMENT)
            .itemName(DEFAULT_ITEM_NAME)
            .boardId(DEFAULT_BOARD_ID)
            .kingdeeId(DEFAULT_KINGDEE_ID)
            .parentKingdeeId(DEFAULT_PARENT_KINGDEE_ID)
            .parentMondayId(DEFAULT_PARENT_MONDAY_ID)
            .qty(DEFAULT_QTY)
            .itemCode(DEFAULT_ITEM_CODE)
            .amount(DEFAULT_AMOUNT)
            .discount(DEFAULT_DISCOUNT)
            .unit(DEFAULT_UNIT)
            .contractEndOfProdDate(DEFAULT_CONTRACT_END_OF_PROD_DATE);
        return orderFollowUp;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static OrderFollowUp createUpdatedEntity(EntityManager em) {
        OrderFollowUp orderFollowUp = new OrderFollowUp()
            .itemId(UPDATED_ITEM_ID)
            .poNumber(UPDATED_PO_NUMBER)
            .customer(UPDATED_CUSTOMER)
            .supplier(UPDATED_SUPPLIER)
            .orderDate(UPDATED_ORDER_DATE)
            .cateGory(UPDATED_CATE_GORY)
            .inspectionDate(UPDATED_INSPECTION_DATE)
            .requestEndOfProdDate(UPDATED_REQUEST_END_OF_PROD_DATE)
            .totalAmount(UPDATED_TOTAL_AMOUNT)
            .totalDiscount(UPDATED_TOTAL_DISCOUNT)
            .disCountRate(UPDATED_DIS_COUNT_RATE)
            .regularCheck(UPDATED_REGULAR_CHECK)
            .etd(UPDATED_ETD)
            .atd(UPDATED_ATD)
            .eta(UPDATED_ETA)
            .updatedEta(UPDATED_UPDATED_ETA)
            .forwarder(UPDATED_FORWARDER)
            .documentStatus(UPDATED_DOCUMENT_STATUS)
            .customInstruction(UPDATED_CUSTOM_INSTRUCTION)
            .customInspection(UPDATED_CUSTOM_INSPECTION)
            .depositPaymentDate(UPDATED_DEPOSIT_PAYMENT_DATE)
            .balanceOfTotalPaymentDate(UPDATED_BALANCE_OF_TOTAL_PAYMENT_DATE)
            .amountDepositPayment(UPDATED_AMOUNT_DEPOSIT_PAYMENT)
            .amountPayment(UPDATED_AMOUNT_PAYMENT)
            .dcMember(UPDATED_DC_MEMBER)
            .comment(UPDATED_COMMENT)
            .itemName(UPDATED_ITEM_NAME)
            .boardId(UPDATED_BOARD_ID)
            .kingdeeId(UPDATED_KINGDEE_ID)
            .parentKingdeeId(UPDATED_PARENT_KINGDEE_ID)
            .parentMondayId(UPDATED_PARENT_MONDAY_ID)
            .qty(UPDATED_QTY)
            .itemCode(UPDATED_ITEM_CODE)
            .amount(UPDATED_AMOUNT)
            .discount(UPDATED_DISCOUNT)
            .unit(UPDATED_UNIT)
            .contractEndOfProdDate(UPDATED_CONTRACT_END_OF_PROD_DATE);
        return orderFollowUp;
    }

    @BeforeEach
    public void initTest() {
        orderFollowUp = createEntity(em);
    }

    @Test
    @Transactional
    void createOrderFollowUp() throws Exception {
        int databaseSizeBeforeCreate = orderFollowUpRepository.findAll().size();
        // Create the OrderFollowUp
        restOrderFollowUpMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(orderFollowUp)))
            .andExpect(status().isCreated());

        // Validate the OrderFollowUp in the database
        List<OrderFollowUp> orderFollowUpList = orderFollowUpRepository.findAll();
        assertThat(orderFollowUpList).hasSize(databaseSizeBeforeCreate + 1);
        OrderFollowUp testOrderFollowUp = orderFollowUpList.get(orderFollowUpList.size() - 1);
        assertThat(testOrderFollowUp.getItemId()).isEqualTo(DEFAULT_ITEM_ID);
        assertThat(testOrderFollowUp.getPoNumber()).isEqualTo(DEFAULT_PO_NUMBER);
        assertThat(testOrderFollowUp.getCustomer()).isEqualTo(DEFAULT_CUSTOMER);
        assertThat(testOrderFollowUp.getSupplier()).isEqualTo(DEFAULT_SUPPLIER);
        assertThat(testOrderFollowUp.getOrderDate()).isEqualTo(DEFAULT_ORDER_DATE);
        assertThat(testOrderFollowUp.getCateGory()).isEqualTo(DEFAULT_CATE_GORY);
        assertThat(testOrderFollowUp.getInspectionDate()).isEqualTo(DEFAULT_INSPECTION_DATE);
        assertThat(testOrderFollowUp.getRequestEndOfProdDate()).isEqualTo(DEFAULT_REQUEST_END_OF_PROD_DATE);
        assertThat(testOrderFollowUp.getTotalAmount()).isEqualTo(DEFAULT_TOTAL_AMOUNT);
        assertThat(testOrderFollowUp.getTotalDiscount()).isEqualTo(DEFAULT_TOTAL_DISCOUNT);
        assertThat(testOrderFollowUp.getDisCountRate()).isEqualTo(DEFAULT_DIS_COUNT_RATE);
        assertThat(testOrderFollowUp.getRegularCheck()).isEqualTo(DEFAULT_REGULAR_CHECK);
        assertThat(testOrderFollowUp.getEtd()).isEqualTo(DEFAULT_ETD);
        assertThat(testOrderFollowUp.getAtd()).isEqualTo(DEFAULT_ATD);
        assertThat(testOrderFollowUp.getEta()).isEqualTo(DEFAULT_ETA);
        assertThat(testOrderFollowUp.getUpdatedEta()).isEqualTo(DEFAULT_UPDATED_ETA);
        assertThat(testOrderFollowUp.getForwarder()).isEqualTo(DEFAULT_FORWARDER);
        assertThat(testOrderFollowUp.getDocumentStatus()).isEqualTo(DEFAULT_DOCUMENT_STATUS);
        assertThat(testOrderFollowUp.getCustomInstruction()).isEqualTo(DEFAULT_CUSTOM_INSTRUCTION);
        assertThat(testOrderFollowUp.getCustomInspection()).isEqualTo(DEFAULT_CUSTOM_INSPECTION);
        assertThat(testOrderFollowUp.getDepositPaymentDate()).isEqualTo(DEFAULT_DEPOSIT_PAYMENT_DATE);
        assertThat(testOrderFollowUp.getBalanceOfTotalPaymentDate()).isEqualTo(DEFAULT_BALANCE_OF_TOTAL_PAYMENT_DATE);
        assertThat(testOrderFollowUp.getAmountDepositPayment()).isEqualTo(DEFAULT_AMOUNT_DEPOSIT_PAYMENT);
        assertThat(testOrderFollowUp.getAmountPayment()).isEqualTo(DEFAULT_AMOUNT_PAYMENT);
        assertThat(testOrderFollowUp.getDcMember()).isEqualTo(DEFAULT_DC_MEMBER);
        assertThat(testOrderFollowUp.getComment()).isEqualTo(DEFAULT_COMMENT);
        assertThat(testOrderFollowUp.getItemName()).isEqualTo(DEFAULT_ITEM_NAME);
        assertThat(testOrderFollowUp.getBoardId()).isEqualTo(DEFAULT_BOARD_ID);
        assertThat(testOrderFollowUp.getKingdeeId()).isEqualTo(DEFAULT_KINGDEE_ID);
        assertThat(testOrderFollowUp.getParentKingdeeId()).isEqualTo(DEFAULT_PARENT_KINGDEE_ID);
        assertThat(testOrderFollowUp.getParentMondayId()).isEqualTo(DEFAULT_PARENT_MONDAY_ID);
        assertThat(testOrderFollowUp.getQty()).isEqualTo(DEFAULT_QTY);
        assertThat(testOrderFollowUp.getItemCode()).isEqualTo(DEFAULT_ITEM_CODE);
        assertThat(testOrderFollowUp.getAmount()).isEqualTo(DEFAULT_AMOUNT);
        assertThat(testOrderFollowUp.getDiscount()).isEqualTo(DEFAULT_DISCOUNT);
        assertThat(testOrderFollowUp.getUnit()).isEqualTo(DEFAULT_UNIT);
        assertThat(testOrderFollowUp.getContractEndOfProdDate()).isEqualTo(DEFAULT_CONTRACT_END_OF_PROD_DATE);
    }

    @Test
    @Transactional
    void createOrderFollowUpWithExistingId() throws Exception {
        // Create the OrderFollowUp with an existing ID
        orderFollowUp.setId(1L);

        int databaseSizeBeforeCreate = orderFollowUpRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restOrderFollowUpMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(orderFollowUp)))
            .andExpect(status().isBadRequest());

        // Validate the OrderFollowUp in the database
        List<OrderFollowUp> orderFollowUpList = orderFollowUpRepository.findAll();
        assertThat(orderFollowUpList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllOrderFollowUps() throws Exception {
        // Initialize the database
        orderFollowUpRepository.saveAndFlush(orderFollowUp);

        // Get all the orderFollowUpList
        restOrderFollowUpMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(orderFollowUp.getId().intValue())))
            .andExpect(jsonPath("$.[*].itemId").value(hasItem(DEFAULT_ITEM_ID)))
            .andExpect(jsonPath("$.[*].poNumber").value(hasItem(DEFAULT_PO_NUMBER)))
            .andExpect(jsonPath("$.[*].customer").value(hasItem(DEFAULT_CUSTOMER)))
            .andExpect(jsonPath("$.[*].supplier").value(hasItem(DEFAULT_SUPPLIER)))
            .andExpect(jsonPath("$.[*].orderDate").value(hasItem(DEFAULT_ORDER_DATE)))
            .andExpect(jsonPath("$.[*].cateGory").value(hasItem(DEFAULT_CATE_GORY)))
            .andExpect(jsonPath("$.[*].inspectionDate").value(hasItem(DEFAULT_INSPECTION_DATE)))
            .andExpect(jsonPath("$.[*].requestEndOfProdDate").value(hasItem(DEFAULT_REQUEST_END_OF_PROD_DATE)))
            .andExpect(jsonPath("$.[*].totalAmount").value(hasItem(DEFAULT_TOTAL_AMOUNT)))
            .andExpect(jsonPath("$.[*].totalDiscount").value(hasItem(DEFAULT_TOTAL_DISCOUNT)))
            .andExpect(jsonPath("$.[*].disCountRate").value(hasItem(DEFAULT_DIS_COUNT_RATE)))
            .andExpect(jsonPath("$.[*].regularCheck").value(hasItem(DEFAULT_REGULAR_CHECK)))
            .andExpect(jsonPath("$.[*].etd").value(hasItem(DEFAULT_ETD)))
            .andExpect(jsonPath("$.[*].atd").value(hasItem(DEFAULT_ATD)))
            .andExpect(jsonPath("$.[*].eta").value(hasItem(DEFAULT_ETA)))
            .andExpect(jsonPath("$.[*].updatedEta").value(hasItem(DEFAULT_UPDATED_ETA)))
            .andExpect(jsonPath("$.[*].forwarder").value(hasItem(DEFAULT_FORWARDER)))
            .andExpect(jsonPath("$.[*].documentStatus").value(hasItem(DEFAULT_DOCUMENT_STATUS)))
            .andExpect(jsonPath("$.[*].customInstruction").value(hasItem(DEFAULT_CUSTOM_INSTRUCTION)))
            .andExpect(jsonPath("$.[*].customInspection").value(hasItem(DEFAULT_CUSTOM_INSPECTION)))
            .andExpect(jsonPath("$.[*].depositPaymentDate").value(hasItem(DEFAULT_DEPOSIT_PAYMENT_DATE)))
            .andExpect(jsonPath("$.[*].balanceOfTotalPaymentDate").value(hasItem(DEFAULT_BALANCE_OF_TOTAL_PAYMENT_DATE)))
            .andExpect(jsonPath("$.[*].amountDepositPayment").value(hasItem(DEFAULT_AMOUNT_DEPOSIT_PAYMENT)))
            .andExpect(jsonPath("$.[*].amountPayment").value(hasItem(DEFAULT_AMOUNT_PAYMENT)))
            .andExpect(jsonPath("$.[*].dcMember").value(hasItem(DEFAULT_DC_MEMBER)))
            .andExpect(jsonPath("$.[*].comment").value(hasItem(DEFAULT_COMMENT)))
            .andExpect(jsonPath("$.[*].itemName").value(hasItem(DEFAULT_ITEM_NAME)))
            .andExpect(jsonPath("$.[*].boardId").value(hasItem(DEFAULT_BOARD_ID)))
            .andExpect(jsonPath("$.[*].kingdeeId").value(hasItem(DEFAULT_KINGDEE_ID)))
            .andExpect(jsonPath("$.[*].parentKingdeeId").value(hasItem(DEFAULT_PARENT_KINGDEE_ID)))
            .andExpect(jsonPath("$.[*].parentMondayId").value(hasItem(DEFAULT_PARENT_MONDAY_ID)))
            .andExpect(jsonPath("$.[*].qty").value(hasItem(DEFAULT_QTY)))
            .andExpect(jsonPath("$.[*].itemCode").value(hasItem(DEFAULT_ITEM_CODE)))
            .andExpect(jsonPath("$.[*].amount").value(hasItem(DEFAULT_AMOUNT)))
            .andExpect(jsonPath("$.[*].discount").value(hasItem(DEFAULT_DISCOUNT)))
            .andExpect(jsonPath("$.[*].unit").value(hasItem(DEFAULT_UNIT)))
            .andExpect(jsonPath("$.[*].contractEndOfProdDate").value(hasItem(DEFAULT_CONTRACT_END_OF_PROD_DATE)));
    }

    @Test
    @Transactional
    void getOrderFollowUp() throws Exception {
        // Initialize the database
        orderFollowUpRepository.saveAndFlush(orderFollowUp);

        // Get the orderFollowUp
        restOrderFollowUpMockMvc
            .perform(get(ENTITY_API_URL_ID, orderFollowUp.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(orderFollowUp.getId().intValue()))
            .andExpect(jsonPath("$.itemId").value(DEFAULT_ITEM_ID))
            .andExpect(jsonPath("$.poNumber").value(DEFAULT_PO_NUMBER))
            .andExpect(jsonPath("$.customer").value(DEFAULT_CUSTOMER))
            .andExpect(jsonPath("$.supplier").value(DEFAULT_SUPPLIER))
            .andExpect(jsonPath("$.orderDate").value(DEFAULT_ORDER_DATE))
            .andExpect(jsonPath("$.cateGory").value(DEFAULT_CATE_GORY))
            .andExpect(jsonPath("$.inspectionDate").value(DEFAULT_INSPECTION_DATE))
            .andExpect(jsonPath("$.requestEndOfProdDate").value(DEFAULT_REQUEST_END_OF_PROD_DATE))
            .andExpect(jsonPath("$.totalAmount").value(DEFAULT_TOTAL_AMOUNT))
            .andExpect(jsonPath("$.totalDiscount").value(DEFAULT_TOTAL_DISCOUNT))
            .andExpect(jsonPath("$.disCountRate").value(DEFAULT_DIS_COUNT_RATE))
            .andExpect(jsonPath("$.regularCheck").value(DEFAULT_REGULAR_CHECK))
            .andExpect(jsonPath("$.etd").value(DEFAULT_ETD))
            .andExpect(jsonPath("$.atd").value(DEFAULT_ATD))
            .andExpect(jsonPath("$.eta").value(DEFAULT_ETA))
            .andExpect(jsonPath("$.updatedEta").value(DEFAULT_UPDATED_ETA))
            .andExpect(jsonPath("$.forwarder").value(DEFAULT_FORWARDER))
            .andExpect(jsonPath("$.documentStatus").value(DEFAULT_DOCUMENT_STATUS))
            .andExpect(jsonPath("$.customInstruction").value(DEFAULT_CUSTOM_INSTRUCTION))
            .andExpect(jsonPath("$.customInspection").value(DEFAULT_CUSTOM_INSPECTION))
            .andExpect(jsonPath("$.depositPaymentDate").value(DEFAULT_DEPOSIT_PAYMENT_DATE))
            .andExpect(jsonPath("$.balanceOfTotalPaymentDate").value(DEFAULT_BALANCE_OF_TOTAL_PAYMENT_DATE))
            .andExpect(jsonPath("$.amountDepositPayment").value(DEFAULT_AMOUNT_DEPOSIT_PAYMENT))
            .andExpect(jsonPath("$.amountPayment").value(DEFAULT_AMOUNT_PAYMENT))
            .andExpect(jsonPath("$.dcMember").value(DEFAULT_DC_MEMBER))
            .andExpect(jsonPath("$.comment").value(DEFAULT_COMMENT))
            .andExpect(jsonPath("$.itemName").value(DEFAULT_ITEM_NAME))
            .andExpect(jsonPath("$.boardId").value(DEFAULT_BOARD_ID))
            .andExpect(jsonPath("$.kingdeeId").value(DEFAULT_KINGDEE_ID))
            .andExpect(jsonPath("$.parentKingdeeId").value(DEFAULT_PARENT_KINGDEE_ID))
            .andExpect(jsonPath("$.parentMondayId").value(DEFAULT_PARENT_MONDAY_ID))
            .andExpect(jsonPath("$.qty").value(DEFAULT_QTY))
            .andExpect(jsonPath("$.itemCode").value(DEFAULT_ITEM_CODE))
            .andExpect(jsonPath("$.amount").value(DEFAULT_AMOUNT))
            .andExpect(jsonPath("$.discount").value(DEFAULT_DISCOUNT))
            .andExpect(jsonPath("$.unit").value(DEFAULT_UNIT))
            .andExpect(jsonPath("$.contractEndOfProdDate").value(DEFAULT_CONTRACT_END_OF_PROD_DATE));
    }

    @Test
    @Transactional
    void getNonExistingOrderFollowUp() throws Exception {
        // Get the orderFollowUp
        restOrderFollowUpMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingOrderFollowUp() throws Exception {
        // Initialize the database
        orderFollowUpRepository.saveAndFlush(orderFollowUp);

        int databaseSizeBeforeUpdate = orderFollowUpRepository.findAll().size();

        // Update the orderFollowUp
        OrderFollowUp updatedOrderFollowUp = orderFollowUpRepository.findById(orderFollowUp.getId()).get();
        // Disconnect from session so that the updates on updatedOrderFollowUp are not directly saved in db
        em.detach(updatedOrderFollowUp);
        updatedOrderFollowUp
            .itemId(UPDATED_ITEM_ID)
            .poNumber(UPDATED_PO_NUMBER)
            .customer(UPDATED_CUSTOMER)
            .supplier(UPDATED_SUPPLIER)
            .orderDate(UPDATED_ORDER_DATE)
            .cateGory(UPDATED_CATE_GORY)
            .inspectionDate(UPDATED_INSPECTION_DATE)
            .requestEndOfProdDate(UPDATED_REQUEST_END_OF_PROD_DATE)
            .totalAmount(UPDATED_TOTAL_AMOUNT)
            .totalDiscount(UPDATED_TOTAL_DISCOUNT)
            .disCountRate(UPDATED_DIS_COUNT_RATE)
            .regularCheck(UPDATED_REGULAR_CHECK)
            .etd(UPDATED_ETD)
            .atd(UPDATED_ATD)
            .eta(UPDATED_ETA)
            .updatedEta(UPDATED_UPDATED_ETA)
            .forwarder(UPDATED_FORWARDER)
            .documentStatus(UPDATED_DOCUMENT_STATUS)
            .customInstruction(UPDATED_CUSTOM_INSTRUCTION)
            .customInspection(UPDATED_CUSTOM_INSPECTION)
            .depositPaymentDate(UPDATED_DEPOSIT_PAYMENT_DATE)
            .balanceOfTotalPaymentDate(UPDATED_BALANCE_OF_TOTAL_PAYMENT_DATE)
            .amountDepositPayment(UPDATED_AMOUNT_DEPOSIT_PAYMENT)
            .amountPayment(UPDATED_AMOUNT_PAYMENT)
            .dcMember(UPDATED_DC_MEMBER)
            .comment(UPDATED_COMMENT)
            .itemName(UPDATED_ITEM_NAME)
            .boardId(UPDATED_BOARD_ID)
            .kingdeeId(UPDATED_KINGDEE_ID)
            .parentKingdeeId(UPDATED_PARENT_KINGDEE_ID)
            .parentMondayId(UPDATED_PARENT_MONDAY_ID)
            .qty(UPDATED_QTY)
            .itemCode(UPDATED_ITEM_CODE)
            .amount(UPDATED_AMOUNT)
            .discount(UPDATED_DISCOUNT)
            .unit(UPDATED_UNIT)
            .contractEndOfProdDate(UPDATED_CONTRACT_END_OF_PROD_DATE);

        restOrderFollowUpMockMvc
            .perform(
                put(ENTITY_API_URL_ID, updatedOrderFollowUp.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(updatedOrderFollowUp))
            )
            .andExpect(status().isOk());

        // Validate the OrderFollowUp in the database
        List<OrderFollowUp> orderFollowUpList = orderFollowUpRepository.findAll();
        assertThat(orderFollowUpList).hasSize(databaseSizeBeforeUpdate);
        OrderFollowUp testOrderFollowUp = orderFollowUpList.get(orderFollowUpList.size() - 1);
        assertThat(testOrderFollowUp.getItemId()).isEqualTo(UPDATED_ITEM_ID);
        assertThat(testOrderFollowUp.getPoNumber()).isEqualTo(UPDATED_PO_NUMBER);
        assertThat(testOrderFollowUp.getCustomer()).isEqualTo(UPDATED_CUSTOMER);
        assertThat(testOrderFollowUp.getSupplier()).isEqualTo(UPDATED_SUPPLIER);
        assertThat(testOrderFollowUp.getOrderDate()).isEqualTo(UPDATED_ORDER_DATE);
        assertThat(testOrderFollowUp.getCateGory()).isEqualTo(UPDATED_CATE_GORY);
        assertThat(testOrderFollowUp.getInspectionDate()).isEqualTo(UPDATED_INSPECTION_DATE);
        assertThat(testOrderFollowUp.getRequestEndOfProdDate()).isEqualTo(UPDATED_REQUEST_END_OF_PROD_DATE);
        assertThat(testOrderFollowUp.getTotalAmount()).isEqualTo(UPDATED_TOTAL_AMOUNT);
        assertThat(testOrderFollowUp.getTotalDiscount()).isEqualTo(UPDATED_TOTAL_DISCOUNT);
        assertThat(testOrderFollowUp.getDisCountRate()).isEqualTo(UPDATED_DIS_COUNT_RATE);
        assertThat(testOrderFollowUp.getRegularCheck()).isEqualTo(UPDATED_REGULAR_CHECK);
        assertThat(testOrderFollowUp.getEtd()).isEqualTo(UPDATED_ETD);
        assertThat(testOrderFollowUp.getAtd()).isEqualTo(UPDATED_ATD);
        assertThat(testOrderFollowUp.getEta()).isEqualTo(UPDATED_ETA);
        assertThat(testOrderFollowUp.getUpdatedEta()).isEqualTo(UPDATED_UPDATED_ETA);
        assertThat(testOrderFollowUp.getForwarder()).isEqualTo(UPDATED_FORWARDER);
        assertThat(testOrderFollowUp.getDocumentStatus()).isEqualTo(UPDATED_DOCUMENT_STATUS);
        assertThat(testOrderFollowUp.getCustomInstruction()).isEqualTo(UPDATED_CUSTOM_INSTRUCTION);
        assertThat(testOrderFollowUp.getCustomInspection()).isEqualTo(UPDATED_CUSTOM_INSPECTION);
        assertThat(testOrderFollowUp.getDepositPaymentDate()).isEqualTo(UPDATED_DEPOSIT_PAYMENT_DATE);
        assertThat(testOrderFollowUp.getBalanceOfTotalPaymentDate()).isEqualTo(UPDATED_BALANCE_OF_TOTAL_PAYMENT_DATE);
        assertThat(testOrderFollowUp.getAmountDepositPayment()).isEqualTo(UPDATED_AMOUNT_DEPOSIT_PAYMENT);
        assertThat(testOrderFollowUp.getAmountPayment()).isEqualTo(UPDATED_AMOUNT_PAYMENT);
        assertThat(testOrderFollowUp.getDcMember()).isEqualTo(UPDATED_DC_MEMBER);
        assertThat(testOrderFollowUp.getComment()).isEqualTo(UPDATED_COMMENT);
        assertThat(testOrderFollowUp.getItemName()).isEqualTo(UPDATED_ITEM_NAME);
        assertThat(testOrderFollowUp.getBoardId()).isEqualTo(UPDATED_BOARD_ID);
        assertThat(testOrderFollowUp.getKingdeeId()).isEqualTo(UPDATED_KINGDEE_ID);
        assertThat(testOrderFollowUp.getParentKingdeeId()).isEqualTo(UPDATED_PARENT_KINGDEE_ID);
        assertThat(testOrderFollowUp.getParentMondayId()).isEqualTo(UPDATED_PARENT_MONDAY_ID);
        assertThat(testOrderFollowUp.getQty()).isEqualTo(UPDATED_QTY);
        assertThat(testOrderFollowUp.getItemCode()).isEqualTo(UPDATED_ITEM_CODE);
        assertThat(testOrderFollowUp.getAmount()).isEqualTo(UPDATED_AMOUNT);
        assertThat(testOrderFollowUp.getDiscount()).isEqualTo(UPDATED_DISCOUNT);
        assertThat(testOrderFollowUp.getUnit()).isEqualTo(UPDATED_UNIT);
        assertThat(testOrderFollowUp.getContractEndOfProdDate()).isEqualTo(UPDATED_CONTRACT_END_OF_PROD_DATE);
    }

    @Test
    @Transactional
    void putNonExistingOrderFollowUp() throws Exception {
        int databaseSizeBeforeUpdate = orderFollowUpRepository.findAll().size();
        orderFollowUp.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restOrderFollowUpMockMvc
            .perform(
                put(ENTITY_API_URL_ID, orderFollowUp.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(orderFollowUp))
            )
            .andExpect(status().isBadRequest());

        // Validate the OrderFollowUp in the database
        List<OrderFollowUp> orderFollowUpList = orderFollowUpRepository.findAll();
        assertThat(orderFollowUpList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchOrderFollowUp() throws Exception {
        int databaseSizeBeforeUpdate = orderFollowUpRepository.findAll().size();
        orderFollowUp.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restOrderFollowUpMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(orderFollowUp))
            )
            .andExpect(status().isBadRequest());

        // Validate the OrderFollowUp in the database
        List<OrderFollowUp> orderFollowUpList = orderFollowUpRepository.findAll();
        assertThat(orderFollowUpList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamOrderFollowUp() throws Exception {
        int databaseSizeBeforeUpdate = orderFollowUpRepository.findAll().size();
        orderFollowUp.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restOrderFollowUpMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(orderFollowUp)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the OrderFollowUp in the database
        List<OrderFollowUp> orderFollowUpList = orderFollowUpRepository.findAll();
        assertThat(orderFollowUpList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateOrderFollowUpWithPatch() throws Exception {
        // Initialize the database
        orderFollowUpRepository.saveAndFlush(orderFollowUp);

        int databaseSizeBeforeUpdate = orderFollowUpRepository.findAll().size();

        // Update the orderFollowUp using partial update
        OrderFollowUp partialUpdatedOrderFollowUp = new OrderFollowUp();
        partialUpdatedOrderFollowUp.setId(orderFollowUp.getId());

        partialUpdatedOrderFollowUp
            .itemId(UPDATED_ITEM_ID)
            .poNumber(UPDATED_PO_NUMBER)
            .customer(UPDATED_CUSTOMER)
            .inspectionDate(UPDATED_INSPECTION_DATE)
            .requestEndOfProdDate(UPDATED_REQUEST_END_OF_PROD_DATE)
            .atd(UPDATED_ATD)
            .updatedEta(UPDATED_UPDATED_ETA)
            .documentStatus(UPDATED_DOCUMENT_STATUS)
            .customInstruction(UPDATED_CUSTOM_INSTRUCTION)
            .balanceOfTotalPaymentDate(UPDATED_BALANCE_OF_TOTAL_PAYMENT_DATE)
            .amountDepositPayment(UPDATED_AMOUNT_DEPOSIT_PAYMENT)
            .itemName(UPDATED_ITEM_NAME)
            .itemCode(UPDATED_ITEM_CODE)
            .unit(UPDATED_UNIT)
            .contractEndOfProdDate(UPDATED_CONTRACT_END_OF_PROD_DATE);

        restOrderFollowUpMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedOrderFollowUp.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedOrderFollowUp))
            )
            .andExpect(status().isOk());

        // Validate the OrderFollowUp in the database
        List<OrderFollowUp> orderFollowUpList = orderFollowUpRepository.findAll();
        assertThat(orderFollowUpList).hasSize(databaseSizeBeforeUpdate);
        OrderFollowUp testOrderFollowUp = orderFollowUpList.get(orderFollowUpList.size() - 1);
        assertThat(testOrderFollowUp.getItemId()).isEqualTo(UPDATED_ITEM_ID);
        assertThat(testOrderFollowUp.getPoNumber()).isEqualTo(UPDATED_PO_NUMBER);
        assertThat(testOrderFollowUp.getCustomer()).isEqualTo(UPDATED_CUSTOMER);
        assertThat(testOrderFollowUp.getSupplier()).isEqualTo(DEFAULT_SUPPLIER);
        assertThat(testOrderFollowUp.getOrderDate()).isEqualTo(DEFAULT_ORDER_DATE);
        assertThat(testOrderFollowUp.getCateGory()).isEqualTo(DEFAULT_CATE_GORY);
        assertThat(testOrderFollowUp.getInspectionDate()).isEqualTo(UPDATED_INSPECTION_DATE);
        assertThat(testOrderFollowUp.getRequestEndOfProdDate()).isEqualTo(UPDATED_REQUEST_END_OF_PROD_DATE);
        assertThat(testOrderFollowUp.getTotalAmount()).isEqualTo(DEFAULT_TOTAL_AMOUNT);
        assertThat(testOrderFollowUp.getTotalDiscount()).isEqualTo(DEFAULT_TOTAL_DISCOUNT);
        assertThat(testOrderFollowUp.getDisCountRate()).isEqualTo(DEFAULT_DIS_COUNT_RATE);
        assertThat(testOrderFollowUp.getRegularCheck()).isEqualTo(DEFAULT_REGULAR_CHECK);
        assertThat(testOrderFollowUp.getEtd()).isEqualTo(DEFAULT_ETD);
        assertThat(testOrderFollowUp.getAtd()).isEqualTo(UPDATED_ATD);
        assertThat(testOrderFollowUp.getEta()).isEqualTo(DEFAULT_ETA);
        assertThat(testOrderFollowUp.getUpdatedEta()).isEqualTo(UPDATED_UPDATED_ETA);
        assertThat(testOrderFollowUp.getForwarder()).isEqualTo(DEFAULT_FORWARDER);
        assertThat(testOrderFollowUp.getDocumentStatus()).isEqualTo(UPDATED_DOCUMENT_STATUS);
        assertThat(testOrderFollowUp.getCustomInstruction()).isEqualTo(UPDATED_CUSTOM_INSTRUCTION);
        assertThat(testOrderFollowUp.getCustomInspection()).isEqualTo(DEFAULT_CUSTOM_INSPECTION);
        assertThat(testOrderFollowUp.getDepositPaymentDate()).isEqualTo(DEFAULT_DEPOSIT_PAYMENT_DATE);
        assertThat(testOrderFollowUp.getBalanceOfTotalPaymentDate()).isEqualTo(UPDATED_BALANCE_OF_TOTAL_PAYMENT_DATE);
        assertThat(testOrderFollowUp.getAmountDepositPayment()).isEqualTo(UPDATED_AMOUNT_DEPOSIT_PAYMENT);
        assertThat(testOrderFollowUp.getAmountPayment()).isEqualTo(DEFAULT_AMOUNT_PAYMENT);
        assertThat(testOrderFollowUp.getDcMember()).isEqualTo(DEFAULT_DC_MEMBER);
        assertThat(testOrderFollowUp.getComment()).isEqualTo(DEFAULT_COMMENT);
        assertThat(testOrderFollowUp.getItemName()).isEqualTo(UPDATED_ITEM_NAME);
        assertThat(testOrderFollowUp.getBoardId()).isEqualTo(DEFAULT_BOARD_ID);
        assertThat(testOrderFollowUp.getKingdeeId()).isEqualTo(DEFAULT_KINGDEE_ID);
        assertThat(testOrderFollowUp.getParentKingdeeId()).isEqualTo(DEFAULT_PARENT_KINGDEE_ID);
        assertThat(testOrderFollowUp.getParentMondayId()).isEqualTo(DEFAULT_PARENT_MONDAY_ID);
        assertThat(testOrderFollowUp.getQty()).isEqualTo(DEFAULT_QTY);
        assertThat(testOrderFollowUp.getItemCode()).isEqualTo(UPDATED_ITEM_CODE);
        assertThat(testOrderFollowUp.getAmount()).isEqualTo(DEFAULT_AMOUNT);
        assertThat(testOrderFollowUp.getDiscount()).isEqualTo(DEFAULT_DISCOUNT);
        assertThat(testOrderFollowUp.getUnit()).isEqualTo(UPDATED_UNIT);
        assertThat(testOrderFollowUp.getContractEndOfProdDate()).isEqualTo(UPDATED_CONTRACT_END_OF_PROD_DATE);
    }

    @Test
    @Transactional
    void fullUpdateOrderFollowUpWithPatch() throws Exception {
        // Initialize the database
        orderFollowUpRepository.saveAndFlush(orderFollowUp);

        int databaseSizeBeforeUpdate = orderFollowUpRepository.findAll().size();

        // Update the orderFollowUp using partial update
        OrderFollowUp partialUpdatedOrderFollowUp = new OrderFollowUp();
        partialUpdatedOrderFollowUp.setId(orderFollowUp.getId());

        partialUpdatedOrderFollowUp
            .itemId(UPDATED_ITEM_ID)
            .poNumber(UPDATED_PO_NUMBER)
            .customer(UPDATED_CUSTOMER)
            .supplier(UPDATED_SUPPLIER)
            .orderDate(UPDATED_ORDER_DATE)
            .cateGory(UPDATED_CATE_GORY)
            .inspectionDate(UPDATED_INSPECTION_DATE)
            .requestEndOfProdDate(UPDATED_REQUEST_END_OF_PROD_DATE)
            .totalAmount(UPDATED_TOTAL_AMOUNT)
            .totalDiscount(UPDATED_TOTAL_DISCOUNT)
            .disCountRate(UPDATED_DIS_COUNT_RATE)
            .regularCheck(UPDATED_REGULAR_CHECK)
            .etd(UPDATED_ETD)
            .atd(UPDATED_ATD)
            .eta(UPDATED_ETA)
            .updatedEta(UPDATED_UPDATED_ETA)
            .forwarder(UPDATED_FORWARDER)
            .documentStatus(UPDATED_DOCUMENT_STATUS)
            .customInstruction(UPDATED_CUSTOM_INSTRUCTION)
            .customInspection(UPDATED_CUSTOM_INSPECTION)
            .depositPaymentDate(UPDATED_DEPOSIT_PAYMENT_DATE)
            .balanceOfTotalPaymentDate(UPDATED_BALANCE_OF_TOTAL_PAYMENT_DATE)
            .amountDepositPayment(UPDATED_AMOUNT_DEPOSIT_PAYMENT)
            .amountPayment(UPDATED_AMOUNT_PAYMENT)
            .dcMember(UPDATED_DC_MEMBER)
            .comment(UPDATED_COMMENT)
            .itemName(UPDATED_ITEM_NAME)
            .boardId(UPDATED_BOARD_ID)
            .kingdeeId(UPDATED_KINGDEE_ID)
            .parentKingdeeId(UPDATED_PARENT_KINGDEE_ID)
            .parentMondayId(UPDATED_PARENT_MONDAY_ID)
            .qty(UPDATED_QTY)
            .itemCode(UPDATED_ITEM_CODE)
            .amount(UPDATED_AMOUNT)
            .discount(UPDATED_DISCOUNT)
            .unit(UPDATED_UNIT)
            .contractEndOfProdDate(UPDATED_CONTRACT_END_OF_PROD_DATE);

        restOrderFollowUpMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedOrderFollowUp.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedOrderFollowUp))
            )
            .andExpect(status().isOk());

        // Validate the OrderFollowUp in the database
        List<OrderFollowUp> orderFollowUpList = orderFollowUpRepository.findAll();
        assertThat(orderFollowUpList).hasSize(databaseSizeBeforeUpdate);
        OrderFollowUp testOrderFollowUp = orderFollowUpList.get(orderFollowUpList.size() - 1);
        assertThat(testOrderFollowUp.getItemId()).isEqualTo(UPDATED_ITEM_ID);
        assertThat(testOrderFollowUp.getPoNumber()).isEqualTo(UPDATED_PO_NUMBER);
        assertThat(testOrderFollowUp.getCustomer()).isEqualTo(UPDATED_CUSTOMER);
        assertThat(testOrderFollowUp.getSupplier()).isEqualTo(UPDATED_SUPPLIER);
        assertThat(testOrderFollowUp.getOrderDate()).isEqualTo(UPDATED_ORDER_DATE);
        assertThat(testOrderFollowUp.getCateGory()).isEqualTo(UPDATED_CATE_GORY);
        assertThat(testOrderFollowUp.getInspectionDate()).isEqualTo(UPDATED_INSPECTION_DATE);
        assertThat(testOrderFollowUp.getRequestEndOfProdDate()).isEqualTo(UPDATED_REQUEST_END_OF_PROD_DATE);
        assertThat(testOrderFollowUp.getTotalAmount()).isEqualTo(UPDATED_TOTAL_AMOUNT);
        assertThat(testOrderFollowUp.getTotalDiscount()).isEqualTo(UPDATED_TOTAL_DISCOUNT);
        assertThat(testOrderFollowUp.getDisCountRate()).isEqualTo(UPDATED_DIS_COUNT_RATE);
        assertThat(testOrderFollowUp.getRegularCheck()).isEqualTo(UPDATED_REGULAR_CHECK);
        assertThat(testOrderFollowUp.getEtd()).isEqualTo(UPDATED_ETD);
        assertThat(testOrderFollowUp.getAtd()).isEqualTo(UPDATED_ATD);
        assertThat(testOrderFollowUp.getEta()).isEqualTo(UPDATED_ETA);
        assertThat(testOrderFollowUp.getUpdatedEta()).isEqualTo(UPDATED_UPDATED_ETA);
        assertThat(testOrderFollowUp.getForwarder()).isEqualTo(UPDATED_FORWARDER);
        assertThat(testOrderFollowUp.getDocumentStatus()).isEqualTo(UPDATED_DOCUMENT_STATUS);
        assertThat(testOrderFollowUp.getCustomInstruction()).isEqualTo(UPDATED_CUSTOM_INSTRUCTION);
        assertThat(testOrderFollowUp.getCustomInspection()).isEqualTo(UPDATED_CUSTOM_INSPECTION);
        assertThat(testOrderFollowUp.getDepositPaymentDate()).isEqualTo(UPDATED_DEPOSIT_PAYMENT_DATE);
        assertThat(testOrderFollowUp.getBalanceOfTotalPaymentDate()).isEqualTo(UPDATED_BALANCE_OF_TOTAL_PAYMENT_DATE);
        assertThat(testOrderFollowUp.getAmountDepositPayment()).isEqualTo(UPDATED_AMOUNT_DEPOSIT_PAYMENT);
        assertThat(testOrderFollowUp.getAmountPayment()).isEqualTo(UPDATED_AMOUNT_PAYMENT);
        assertThat(testOrderFollowUp.getDcMember()).isEqualTo(UPDATED_DC_MEMBER);
        assertThat(testOrderFollowUp.getComment()).isEqualTo(UPDATED_COMMENT);
        assertThat(testOrderFollowUp.getItemName()).isEqualTo(UPDATED_ITEM_NAME);
        assertThat(testOrderFollowUp.getBoardId()).isEqualTo(UPDATED_BOARD_ID);
        assertThat(testOrderFollowUp.getKingdeeId()).isEqualTo(UPDATED_KINGDEE_ID);
        assertThat(testOrderFollowUp.getParentKingdeeId()).isEqualTo(UPDATED_PARENT_KINGDEE_ID);
        assertThat(testOrderFollowUp.getParentMondayId()).isEqualTo(UPDATED_PARENT_MONDAY_ID);
        assertThat(testOrderFollowUp.getQty()).isEqualTo(UPDATED_QTY);
        assertThat(testOrderFollowUp.getItemCode()).isEqualTo(UPDATED_ITEM_CODE);
        assertThat(testOrderFollowUp.getAmount()).isEqualTo(UPDATED_AMOUNT);
        assertThat(testOrderFollowUp.getDiscount()).isEqualTo(UPDATED_DISCOUNT);
        assertThat(testOrderFollowUp.getUnit()).isEqualTo(UPDATED_UNIT);
        assertThat(testOrderFollowUp.getContractEndOfProdDate()).isEqualTo(UPDATED_CONTRACT_END_OF_PROD_DATE);
    }

    @Test
    @Transactional
    void patchNonExistingOrderFollowUp() throws Exception {
        int databaseSizeBeforeUpdate = orderFollowUpRepository.findAll().size();
        orderFollowUp.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restOrderFollowUpMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, orderFollowUp.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(orderFollowUp))
            )
            .andExpect(status().isBadRequest());

        // Validate the OrderFollowUp in the database
        List<OrderFollowUp> orderFollowUpList = orderFollowUpRepository.findAll();
        assertThat(orderFollowUpList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchOrderFollowUp() throws Exception {
        int databaseSizeBeforeUpdate = orderFollowUpRepository.findAll().size();
        orderFollowUp.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restOrderFollowUpMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(orderFollowUp))
            )
            .andExpect(status().isBadRequest());

        // Validate the OrderFollowUp in the database
        List<OrderFollowUp> orderFollowUpList = orderFollowUpRepository.findAll();
        assertThat(orderFollowUpList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamOrderFollowUp() throws Exception {
        int databaseSizeBeforeUpdate = orderFollowUpRepository.findAll().size();
        orderFollowUp.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restOrderFollowUpMockMvc
            .perform(
                patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(orderFollowUp))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the OrderFollowUp in the database
        List<OrderFollowUp> orderFollowUpList = orderFollowUpRepository.findAll();
        assertThat(orderFollowUpList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteOrderFollowUp() throws Exception {
        // Initialize the database
        orderFollowUpRepository.saveAndFlush(orderFollowUp);

        int databaseSizeBeforeDelete = orderFollowUpRepository.findAll().size();

        // Delete the orderFollowUp
        restOrderFollowUpMockMvc
            .perform(delete(ENTITY_API_URL_ID, orderFollowUp.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<OrderFollowUp> orderFollowUpList = orderFollowUpRepository.findAll();
        assertThat(orderFollowUpList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
