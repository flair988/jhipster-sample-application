package com.mycompany.myapp.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.mycompany.myapp.IntegrationTest;
import com.mycompany.myapp.domain.Inspection;
import com.mycompany.myapp.repository.InspectionRepository;
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
 * Integration tests for the {@link InspectionResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class InspectionResourceIT {

    private static final String DEFAULT_ITEM_NAME = "AAAAAAAAAA";
    private static final String UPDATED_ITEM_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_ITEM_ID = "AAAAAAAAAA";
    private static final String UPDATED_ITEM_ID = "BBBBBBBBBB";

    private static final String DEFAULT_BOARD_ID = "AAAAAAAAAA";
    private static final String UPDATED_BOARD_ID = "BBBBBBBBBB";

    private static final String DEFAULT_KINGDEE_ID = "AAAAAAAAAA";
    private static final String UPDATED_KINGDEE_ID = "BBBBBBBBBB";

    private static final String DEFAULT_SUPPLIER_NAME = "AAAAAAAAAA";
    private static final String UPDATED_SUPPLIER_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_INSPECTION_DATE = "AAAAAAAAAA";
    private static final String UPDATED_INSPECTION_DATE = "BBBBBBBBBB";

    private static final String DEFAULT_END_OF_PRODUCTION_DATE = "AAAAAAAAAA";
    private static final String UPDATED_END_OF_PRODUCTION_DATE = "BBBBBBBBBB";

    private static final String DEFAULT_CATE_GORY = "AAAAAAAAAA";
    private static final String UPDATED_CATE_GORY = "BBBBBBBBBB";

    private static final String DEFAULT_TECHNICAL_FILE = "AAAAAAAAAA";
    private static final String UPDATED_TECHNICAL_FILE = "BBBBBBBBBB";

    private static final String DEFAULT_Q_C_RESULT = "AAAAAAAAAA";
    private static final String UPDATED_Q_C_RESULT = "BBBBBBBBBB";

    private static final String DEFAULT_DOC_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_DOC_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_GOODS_READY_FOR_PICK_UP_DATE = "AAAAAAAAAA";
    private static final String UPDATED_GOODS_READY_FOR_PICK_UP_DATE = "BBBBBBBBBB";

    private static final String DEFAULT_INSPECTION_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_INSPECTION_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_INSPECTION_BOOKING_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_INSPECTION_BOOKING_STATUS = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/inspections";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private InspectionRepository inspectionRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restInspectionMockMvc;

    private Inspection inspection;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Inspection createEntity(EntityManager em) {
        Inspection inspection = new Inspection()
            .itemName(DEFAULT_ITEM_NAME)
            .itemId(DEFAULT_ITEM_ID)
            .boardId(DEFAULT_BOARD_ID)
            .kingdeeId(DEFAULT_KINGDEE_ID)
            .supplierName(DEFAULT_SUPPLIER_NAME)
            .email(DEFAULT_EMAIL)
            .inspectionDate(DEFAULT_INSPECTION_DATE)
            .endOfProductionDate(DEFAULT_END_OF_PRODUCTION_DATE)
            .cateGory(DEFAULT_CATE_GORY)
            .technicalFile(DEFAULT_TECHNICAL_FILE)
            .qCResult(DEFAULT_Q_C_RESULT)
            .docStatus(DEFAULT_DOC_STATUS)
            .goodsReadyForPickUpDate(DEFAULT_GOODS_READY_FOR_PICK_UP_DATE)
            .inspectionType(DEFAULT_INSPECTION_TYPE)
            .inspectionBookingStatus(DEFAULT_INSPECTION_BOOKING_STATUS);
        return inspection;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Inspection createUpdatedEntity(EntityManager em) {
        Inspection inspection = new Inspection()
            .itemName(UPDATED_ITEM_NAME)
            .itemId(UPDATED_ITEM_ID)
            .boardId(UPDATED_BOARD_ID)
            .kingdeeId(UPDATED_KINGDEE_ID)
            .supplierName(UPDATED_SUPPLIER_NAME)
            .email(UPDATED_EMAIL)
            .inspectionDate(UPDATED_INSPECTION_DATE)
            .endOfProductionDate(UPDATED_END_OF_PRODUCTION_DATE)
            .cateGory(UPDATED_CATE_GORY)
            .technicalFile(UPDATED_TECHNICAL_FILE)
            .qCResult(UPDATED_Q_C_RESULT)
            .docStatus(UPDATED_DOC_STATUS)
            .goodsReadyForPickUpDate(UPDATED_GOODS_READY_FOR_PICK_UP_DATE)
            .inspectionType(UPDATED_INSPECTION_TYPE)
            .inspectionBookingStatus(UPDATED_INSPECTION_BOOKING_STATUS);
        return inspection;
    }

    @BeforeEach
    public void initTest() {
        inspection = createEntity(em);
    }

    @Test
    @Transactional
    void createInspection() throws Exception {
        int databaseSizeBeforeCreate = inspectionRepository.findAll().size();
        // Create the Inspection
        restInspectionMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(inspection)))
            .andExpect(status().isCreated());

        // Validate the Inspection in the database
        List<Inspection> inspectionList = inspectionRepository.findAll();
        assertThat(inspectionList).hasSize(databaseSizeBeforeCreate + 1);
        Inspection testInspection = inspectionList.get(inspectionList.size() - 1);
        assertThat(testInspection.getItemName()).isEqualTo(DEFAULT_ITEM_NAME);
        assertThat(testInspection.getItemId()).isEqualTo(DEFAULT_ITEM_ID);
        assertThat(testInspection.getBoardId()).isEqualTo(DEFAULT_BOARD_ID);
        assertThat(testInspection.getKingdeeId()).isEqualTo(DEFAULT_KINGDEE_ID);
        assertThat(testInspection.getSupplierName()).isEqualTo(DEFAULT_SUPPLIER_NAME);
        assertThat(testInspection.getEmail()).isEqualTo(DEFAULT_EMAIL);
        assertThat(testInspection.getInspectionDate()).isEqualTo(DEFAULT_INSPECTION_DATE);
        assertThat(testInspection.getEndOfProductionDate()).isEqualTo(DEFAULT_END_OF_PRODUCTION_DATE);
        assertThat(testInspection.getCateGory()).isEqualTo(DEFAULT_CATE_GORY);
        assertThat(testInspection.getTechnicalFile()).isEqualTo(DEFAULT_TECHNICAL_FILE);
        assertThat(testInspection.getqCResult()).isEqualTo(DEFAULT_Q_C_RESULT);
        assertThat(testInspection.getDocStatus()).isEqualTo(DEFAULT_DOC_STATUS);
        assertThat(testInspection.getGoodsReadyForPickUpDate()).isEqualTo(DEFAULT_GOODS_READY_FOR_PICK_UP_DATE);
        assertThat(testInspection.getInspectionType()).isEqualTo(DEFAULT_INSPECTION_TYPE);
        assertThat(testInspection.getInspectionBookingStatus()).isEqualTo(DEFAULT_INSPECTION_BOOKING_STATUS);
    }

    @Test
    @Transactional
    void createInspectionWithExistingId() throws Exception {
        // Create the Inspection with an existing ID
        inspection.setId(1L);

        int databaseSizeBeforeCreate = inspectionRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restInspectionMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(inspection)))
            .andExpect(status().isBadRequest());

        // Validate the Inspection in the database
        List<Inspection> inspectionList = inspectionRepository.findAll();
        assertThat(inspectionList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllInspections() throws Exception {
        // Initialize the database
        inspectionRepository.saveAndFlush(inspection);

        // Get all the inspectionList
        restInspectionMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(inspection.getId().intValue())))
            .andExpect(jsonPath("$.[*].itemName").value(hasItem(DEFAULT_ITEM_NAME)))
            .andExpect(jsonPath("$.[*].itemId").value(hasItem(DEFAULT_ITEM_ID)))
            .andExpect(jsonPath("$.[*].boardId").value(hasItem(DEFAULT_BOARD_ID)))
            .andExpect(jsonPath("$.[*].kingdeeId").value(hasItem(DEFAULT_KINGDEE_ID)))
            .andExpect(jsonPath("$.[*].supplierName").value(hasItem(DEFAULT_SUPPLIER_NAME)))
            .andExpect(jsonPath("$.[*].email").value(hasItem(DEFAULT_EMAIL)))
            .andExpect(jsonPath("$.[*].inspectionDate").value(hasItem(DEFAULT_INSPECTION_DATE)))
            .andExpect(jsonPath("$.[*].endOfProductionDate").value(hasItem(DEFAULT_END_OF_PRODUCTION_DATE)))
            .andExpect(jsonPath("$.[*].cateGory").value(hasItem(DEFAULT_CATE_GORY)))
            .andExpect(jsonPath("$.[*].technicalFile").value(hasItem(DEFAULT_TECHNICAL_FILE)))
            .andExpect(jsonPath("$.[*].qCResult").value(hasItem(DEFAULT_Q_C_RESULT)))
            .andExpect(jsonPath("$.[*].docStatus").value(hasItem(DEFAULT_DOC_STATUS)))
            .andExpect(jsonPath("$.[*].goodsReadyForPickUpDate").value(hasItem(DEFAULT_GOODS_READY_FOR_PICK_UP_DATE)))
            .andExpect(jsonPath("$.[*].inspectionType").value(hasItem(DEFAULT_INSPECTION_TYPE)))
            .andExpect(jsonPath("$.[*].inspectionBookingStatus").value(hasItem(DEFAULT_INSPECTION_BOOKING_STATUS)));
    }

    @Test
    @Transactional
    void getInspection() throws Exception {
        // Initialize the database
        inspectionRepository.saveAndFlush(inspection);

        // Get the inspection
        restInspectionMockMvc
            .perform(get(ENTITY_API_URL_ID, inspection.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(inspection.getId().intValue()))
            .andExpect(jsonPath("$.itemName").value(DEFAULT_ITEM_NAME))
            .andExpect(jsonPath("$.itemId").value(DEFAULT_ITEM_ID))
            .andExpect(jsonPath("$.boardId").value(DEFAULT_BOARD_ID))
            .andExpect(jsonPath("$.kingdeeId").value(DEFAULT_KINGDEE_ID))
            .andExpect(jsonPath("$.supplierName").value(DEFAULT_SUPPLIER_NAME))
            .andExpect(jsonPath("$.email").value(DEFAULT_EMAIL))
            .andExpect(jsonPath("$.inspectionDate").value(DEFAULT_INSPECTION_DATE))
            .andExpect(jsonPath("$.endOfProductionDate").value(DEFAULT_END_OF_PRODUCTION_DATE))
            .andExpect(jsonPath("$.cateGory").value(DEFAULT_CATE_GORY))
            .andExpect(jsonPath("$.technicalFile").value(DEFAULT_TECHNICAL_FILE))
            .andExpect(jsonPath("$.qCResult").value(DEFAULT_Q_C_RESULT))
            .andExpect(jsonPath("$.docStatus").value(DEFAULT_DOC_STATUS))
            .andExpect(jsonPath("$.goodsReadyForPickUpDate").value(DEFAULT_GOODS_READY_FOR_PICK_UP_DATE))
            .andExpect(jsonPath("$.inspectionType").value(DEFAULT_INSPECTION_TYPE))
            .andExpect(jsonPath("$.inspectionBookingStatus").value(DEFAULT_INSPECTION_BOOKING_STATUS));
    }

    @Test
    @Transactional
    void getNonExistingInspection() throws Exception {
        // Get the inspection
        restInspectionMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingInspection() throws Exception {
        // Initialize the database
        inspectionRepository.saveAndFlush(inspection);

        int databaseSizeBeforeUpdate = inspectionRepository.findAll().size();

        // Update the inspection
        Inspection updatedInspection = inspectionRepository.findById(inspection.getId()).get();
        // Disconnect from session so that the updates on updatedInspection are not directly saved in db
        em.detach(updatedInspection);
        updatedInspection
            .itemName(UPDATED_ITEM_NAME)
            .itemId(UPDATED_ITEM_ID)
            .boardId(UPDATED_BOARD_ID)
            .kingdeeId(UPDATED_KINGDEE_ID)
            .supplierName(UPDATED_SUPPLIER_NAME)
            .email(UPDATED_EMAIL)
            .inspectionDate(UPDATED_INSPECTION_DATE)
            .endOfProductionDate(UPDATED_END_OF_PRODUCTION_DATE)
            .cateGory(UPDATED_CATE_GORY)
            .technicalFile(UPDATED_TECHNICAL_FILE)
            .qCResult(UPDATED_Q_C_RESULT)
            .docStatus(UPDATED_DOC_STATUS)
            .goodsReadyForPickUpDate(UPDATED_GOODS_READY_FOR_PICK_UP_DATE)
            .inspectionType(UPDATED_INSPECTION_TYPE)
            .inspectionBookingStatus(UPDATED_INSPECTION_BOOKING_STATUS);

        restInspectionMockMvc
            .perform(
                put(ENTITY_API_URL_ID, updatedInspection.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(updatedInspection))
            )
            .andExpect(status().isOk());

        // Validate the Inspection in the database
        List<Inspection> inspectionList = inspectionRepository.findAll();
        assertThat(inspectionList).hasSize(databaseSizeBeforeUpdate);
        Inspection testInspection = inspectionList.get(inspectionList.size() - 1);
        assertThat(testInspection.getItemName()).isEqualTo(UPDATED_ITEM_NAME);
        assertThat(testInspection.getItemId()).isEqualTo(UPDATED_ITEM_ID);
        assertThat(testInspection.getBoardId()).isEqualTo(UPDATED_BOARD_ID);
        assertThat(testInspection.getKingdeeId()).isEqualTo(UPDATED_KINGDEE_ID);
        assertThat(testInspection.getSupplierName()).isEqualTo(UPDATED_SUPPLIER_NAME);
        assertThat(testInspection.getEmail()).isEqualTo(UPDATED_EMAIL);
        assertThat(testInspection.getInspectionDate()).isEqualTo(UPDATED_INSPECTION_DATE);
        assertThat(testInspection.getEndOfProductionDate()).isEqualTo(UPDATED_END_OF_PRODUCTION_DATE);
        assertThat(testInspection.getCateGory()).isEqualTo(UPDATED_CATE_GORY);
        assertThat(testInspection.getTechnicalFile()).isEqualTo(UPDATED_TECHNICAL_FILE);
        assertThat(testInspection.getqCResult()).isEqualTo(UPDATED_Q_C_RESULT);
        assertThat(testInspection.getDocStatus()).isEqualTo(UPDATED_DOC_STATUS);
        assertThat(testInspection.getGoodsReadyForPickUpDate()).isEqualTo(UPDATED_GOODS_READY_FOR_PICK_UP_DATE);
        assertThat(testInspection.getInspectionType()).isEqualTo(UPDATED_INSPECTION_TYPE);
        assertThat(testInspection.getInspectionBookingStatus()).isEqualTo(UPDATED_INSPECTION_BOOKING_STATUS);
    }

    @Test
    @Transactional
    void putNonExistingInspection() throws Exception {
        int databaseSizeBeforeUpdate = inspectionRepository.findAll().size();
        inspection.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restInspectionMockMvc
            .perform(
                put(ENTITY_API_URL_ID, inspection.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(inspection))
            )
            .andExpect(status().isBadRequest());

        // Validate the Inspection in the database
        List<Inspection> inspectionList = inspectionRepository.findAll();
        assertThat(inspectionList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchInspection() throws Exception {
        int databaseSizeBeforeUpdate = inspectionRepository.findAll().size();
        inspection.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restInspectionMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(inspection))
            )
            .andExpect(status().isBadRequest());

        // Validate the Inspection in the database
        List<Inspection> inspectionList = inspectionRepository.findAll();
        assertThat(inspectionList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamInspection() throws Exception {
        int databaseSizeBeforeUpdate = inspectionRepository.findAll().size();
        inspection.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restInspectionMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(inspection)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Inspection in the database
        List<Inspection> inspectionList = inspectionRepository.findAll();
        assertThat(inspectionList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateInspectionWithPatch() throws Exception {
        // Initialize the database
        inspectionRepository.saveAndFlush(inspection);

        int databaseSizeBeforeUpdate = inspectionRepository.findAll().size();

        // Update the inspection using partial update
        Inspection partialUpdatedInspection = new Inspection();
        partialUpdatedInspection.setId(inspection.getId());

        partialUpdatedInspection
            .itemName(UPDATED_ITEM_NAME)
            .boardId(UPDATED_BOARD_ID)
            .kingdeeId(UPDATED_KINGDEE_ID)
            .supplierName(UPDATED_SUPPLIER_NAME)
            .email(UPDATED_EMAIL)
            .endOfProductionDate(UPDATED_END_OF_PRODUCTION_DATE)
            .technicalFile(UPDATED_TECHNICAL_FILE)
            .qCResult(UPDATED_Q_C_RESULT)
            .docStatus(UPDATED_DOC_STATUS);

        restInspectionMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedInspection.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedInspection))
            )
            .andExpect(status().isOk());

        // Validate the Inspection in the database
        List<Inspection> inspectionList = inspectionRepository.findAll();
        assertThat(inspectionList).hasSize(databaseSizeBeforeUpdate);
        Inspection testInspection = inspectionList.get(inspectionList.size() - 1);
        assertThat(testInspection.getItemName()).isEqualTo(UPDATED_ITEM_NAME);
        assertThat(testInspection.getItemId()).isEqualTo(DEFAULT_ITEM_ID);
        assertThat(testInspection.getBoardId()).isEqualTo(UPDATED_BOARD_ID);
        assertThat(testInspection.getKingdeeId()).isEqualTo(UPDATED_KINGDEE_ID);
        assertThat(testInspection.getSupplierName()).isEqualTo(UPDATED_SUPPLIER_NAME);
        assertThat(testInspection.getEmail()).isEqualTo(UPDATED_EMAIL);
        assertThat(testInspection.getInspectionDate()).isEqualTo(DEFAULT_INSPECTION_DATE);
        assertThat(testInspection.getEndOfProductionDate()).isEqualTo(UPDATED_END_OF_PRODUCTION_DATE);
        assertThat(testInspection.getCateGory()).isEqualTo(DEFAULT_CATE_GORY);
        assertThat(testInspection.getTechnicalFile()).isEqualTo(UPDATED_TECHNICAL_FILE);
        assertThat(testInspection.getqCResult()).isEqualTo(UPDATED_Q_C_RESULT);
        assertThat(testInspection.getDocStatus()).isEqualTo(UPDATED_DOC_STATUS);
        assertThat(testInspection.getGoodsReadyForPickUpDate()).isEqualTo(DEFAULT_GOODS_READY_FOR_PICK_UP_DATE);
        assertThat(testInspection.getInspectionType()).isEqualTo(DEFAULT_INSPECTION_TYPE);
        assertThat(testInspection.getInspectionBookingStatus()).isEqualTo(DEFAULT_INSPECTION_BOOKING_STATUS);
    }

    @Test
    @Transactional
    void fullUpdateInspectionWithPatch() throws Exception {
        // Initialize the database
        inspectionRepository.saveAndFlush(inspection);

        int databaseSizeBeforeUpdate = inspectionRepository.findAll().size();

        // Update the inspection using partial update
        Inspection partialUpdatedInspection = new Inspection();
        partialUpdatedInspection.setId(inspection.getId());

        partialUpdatedInspection
            .itemName(UPDATED_ITEM_NAME)
            .itemId(UPDATED_ITEM_ID)
            .boardId(UPDATED_BOARD_ID)
            .kingdeeId(UPDATED_KINGDEE_ID)
            .supplierName(UPDATED_SUPPLIER_NAME)
            .email(UPDATED_EMAIL)
            .inspectionDate(UPDATED_INSPECTION_DATE)
            .endOfProductionDate(UPDATED_END_OF_PRODUCTION_DATE)
            .cateGory(UPDATED_CATE_GORY)
            .technicalFile(UPDATED_TECHNICAL_FILE)
            .qCResult(UPDATED_Q_C_RESULT)
            .docStatus(UPDATED_DOC_STATUS)
            .goodsReadyForPickUpDate(UPDATED_GOODS_READY_FOR_PICK_UP_DATE)
            .inspectionType(UPDATED_INSPECTION_TYPE)
            .inspectionBookingStatus(UPDATED_INSPECTION_BOOKING_STATUS);

        restInspectionMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedInspection.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedInspection))
            )
            .andExpect(status().isOk());

        // Validate the Inspection in the database
        List<Inspection> inspectionList = inspectionRepository.findAll();
        assertThat(inspectionList).hasSize(databaseSizeBeforeUpdate);
        Inspection testInspection = inspectionList.get(inspectionList.size() - 1);
        assertThat(testInspection.getItemName()).isEqualTo(UPDATED_ITEM_NAME);
        assertThat(testInspection.getItemId()).isEqualTo(UPDATED_ITEM_ID);
        assertThat(testInspection.getBoardId()).isEqualTo(UPDATED_BOARD_ID);
        assertThat(testInspection.getKingdeeId()).isEqualTo(UPDATED_KINGDEE_ID);
        assertThat(testInspection.getSupplierName()).isEqualTo(UPDATED_SUPPLIER_NAME);
        assertThat(testInspection.getEmail()).isEqualTo(UPDATED_EMAIL);
        assertThat(testInspection.getInspectionDate()).isEqualTo(UPDATED_INSPECTION_DATE);
        assertThat(testInspection.getEndOfProductionDate()).isEqualTo(UPDATED_END_OF_PRODUCTION_DATE);
        assertThat(testInspection.getCateGory()).isEqualTo(UPDATED_CATE_GORY);
        assertThat(testInspection.getTechnicalFile()).isEqualTo(UPDATED_TECHNICAL_FILE);
        assertThat(testInspection.getqCResult()).isEqualTo(UPDATED_Q_C_RESULT);
        assertThat(testInspection.getDocStatus()).isEqualTo(UPDATED_DOC_STATUS);
        assertThat(testInspection.getGoodsReadyForPickUpDate()).isEqualTo(UPDATED_GOODS_READY_FOR_PICK_UP_DATE);
        assertThat(testInspection.getInspectionType()).isEqualTo(UPDATED_INSPECTION_TYPE);
        assertThat(testInspection.getInspectionBookingStatus()).isEqualTo(UPDATED_INSPECTION_BOOKING_STATUS);
    }

    @Test
    @Transactional
    void patchNonExistingInspection() throws Exception {
        int databaseSizeBeforeUpdate = inspectionRepository.findAll().size();
        inspection.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restInspectionMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, inspection.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(inspection))
            )
            .andExpect(status().isBadRequest());

        // Validate the Inspection in the database
        List<Inspection> inspectionList = inspectionRepository.findAll();
        assertThat(inspectionList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchInspection() throws Exception {
        int databaseSizeBeforeUpdate = inspectionRepository.findAll().size();
        inspection.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restInspectionMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(inspection))
            )
            .andExpect(status().isBadRequest());

        // Validate the Inspection in the database
        List<Inspection> inspectionList = inspectionRepository.findAll();
        assertThat(inspectionList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamInspection() throws Exception {
        int databaseSizeBeforeUpdate = inspectionRepository.findAll().size();
        inspection.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restInspectionMockMvc
            .perform(
                patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(inspection))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the Inspection in the database
        List<Inspection> inspectionList = inspectionRepository.findAll();
        assertThat(inspectionList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteInspection() throws Exception {
        // Initialize the database
        inspectionRepository.saveAndFlush(inspection);

        int databaseSizeBeforeDelete = inspectionRepository.findAll().size();

        // Delete the inspection
        restInspectionMockMvc
            .perform(delete(ENTITY_API_URL_ID, inspection.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Inspection> inspectionList = inspectionRepository.findAll();
        assertThat(inspectionList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
