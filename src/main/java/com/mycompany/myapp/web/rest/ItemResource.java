package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.domain.Item;
import com.mycompany.myapp.repository.ItemRepository;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.Item}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class ItemResource {

    private final Logger log = LoggerFactory.getLogger(ItemResource.class);

    private static final String ENTITY_NAME = "item";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ItemRepository itemRepository;

    public ItemResource(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    /**
     * {@code POST  /items} : Create a new item.
     *
     * @param item the item to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new item, or with status {@code 400 (Bad Request)} if the item has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/items")
    public ResponseEntity<Item> createItem(@RequestBody Item item) throws URISyntaxException {
        log.debug("REST request to save Item : {}", item);
        if (item.getId() != null) {
            throw new BadRequestAlertException("A new item cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Item result = itemRepository.save(item);
        return ResponseEntity
            .created(new URI("/api/items/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /items/:id} : Updates an existing item.
     *
     * @param id the id of the item to save.
     * @param item the item to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated item,
     * or with status {@code 400 (Bad Request)} if the item is not valid,
     * or with status {@code 500 (Internal Server Error)} if the item couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/items/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable(value = "id", required = false) final Long id, @RequestBody Item item)
        throws URISyntaxException {
        log.debug("REST request to update Item : {}, {}", id, item);
        if (item.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, item.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!itemRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Item result = itemRepository.save(item);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, item.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /items/:id} : Partial updates given fields of an existing item, field will ignore if it is null
     *
     * @param id the id of the item to save.
     * @param item the item to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated item,
     * or with status {@code 400 (Bad Request)} if the item is not valid,
     * or with status {@code 404 (Not Found)} if the item is not found,
     * or with status {@code 500 (Internal Server Error)} if the item couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/items/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<Item> partialUpdateItem(@PathVariable(value = "id", required = false) final Long id, @RequestBody Item item)
        throws URISyntaxException {
        log.debug("REST request to partial update Item partially : {}, {}", id, item);
        if (item.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, item.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!itemRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<Item> result = itemRepository
            .findById(item.getId())
            .map(existingItem -> {
                if (item.getItemStatus() != null) {
                    existingItem.setItemStatus(item.getItemStatus());
                }
                if (item.getItemFranceName() != null) {
                    existingItem.setItemFranceName(item.getItemFranceName());
                }
                if (item.getKingdeeId() != null) {
                    existingItem.setKingdeeId(item.getKingdeeId());
                }
                if (item.getItemName() != null) {
                    existingItem.setItemName(item.getItemName());
                }
                if (item.getCodeag() != null) {
                    existingItem.setCodeag(item.getCodeag());
                }
                if (item.getTechnicalDocuments() != null) {
                    existingItem.setTechnicalDocuments(item.getTechnicalDocuments());
                }
                if (item.getCertification() != null) {
                    existingItem.setCertification(item.getCertification());
                }
                if (item.getOpportunitySheet() != null) {
                    existingItem.setOpportunitySheet(item.getOpportunitySheet());
                }
                if (item.getPackingType() != null) {
                    existingItem.setPackingType(item.getPackingType());
                }
                if (item.getSalePackageImage() != null) {
                    existingItem.setSalePackageImage(item.getSalePackageImage());
                }
                if (item.getCartonLengthMilimeter() != null) {
                    existingItem.setCartonLengthMilimeter(item.getCartonLengthMilimeter());
                }
                if (item.getCartonHeightMilimeter() != null) {
                    existingItem.setCartonHeightMilimeter(item.getCartonHeightMilimeter());
                }
                if (item.getBarcode() != null) {
                    existingItem.setBarcode(item.getBarcode());
                }
                if (item.getCartonWeightKg() != null) {
                    existingItem.setCartonWeightKg(item.getCartonWeightKg());
                }
                if (item.getCartonWeightGr() != null) {
                    existingItem.setCartonWeightGr(item.getCartonWeightGr());
                }
                if (item.getCartonWidthMilimeter() != null) {
                    existingItem.setCartonWidthMilimeter(item.getCartonWidthMilimeter());
                }
                if (item.getProductDescriptionAndFonctionalities() != null) {
                    existingItem.setProductDescriptionAndFonctionalities(item.getProductDescriptionAndFonctionalities());
                }
                if (item.getDrawing() != null) {
                    existingItem.setDrawing(item.getDrawing());
                }
                if (item.getUserManual() != null) {
                    existingItem.setUserManual(item.getUserManual());
                }
                if (item.getPalletSize() != null) {
                    existingItem.setPalletSize(item.getPalletSize());
                }
                if (item.getTypeOfMarketing() != null) {
                    existingItem.setTypeOfMarketing(item.getTypeOfMarketing());
                }
                if (item.getProductPic() != null) {
                    existingItem.setProductPic(item.getProductPic());
                }
                if (item.getLabel() != null) {
                    existingItem.setLabel(item.getLabel());
                }
                if (item.getComment() != null) {
                    existingItem.setComment(item.getComment());
                }
                if (item.getProductTaxonomy() != null) {
                    existingItem.setProductTaxonomy(item.getProductTaxonomy());
                }
                if (item.getNetWeight() != null) {
                    existingItem.setNetWeight(item.getNetWeight());
                }
                if (item.getGrossWeight() != null) {
                    existingItem.setGrossWeight(item.getGrossWeight());
                }
                if (item.getUnitOfWeight() != null) {
                    existingItem.setUnitOfWeight(item.getUnitOfWeight());
                }
                if (item.getCartonVolumeMilimeter() != null) {
                    existingItem.setCartonVolumeMilimeter(item.getCartonVolumeMilimeter());
                }

                return existingItem;
            })
            .map(itemRepository::save);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, item.getId().toString())
        );
    }

    /**
     * {@code GET  /items} : get all the items.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of items in body.
     */
    @GetMapping("/items")
    public List<Item> getAllItems() {
        log.debug("REST request to get all Items");
        return itemRepository.findAll();
    }

    /**
     * {@code GET  /items/:id} : get the "id" item.
     *
     * @param id the id of the item to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the item, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/items/{id}")
    public ResponseEntity<Item> getItem(@PathVariable Long id) {
        log.debug("REST request to get Item : {}", id);
        Optional<Item> item = itemRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(item);
    }

    /**
     * {@code DELETE  /items/:id} : delete the "id" item.
     *
     * @param id the id of the item to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/items/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        log.debug("REST request to delete Item : {}", id);
        itemRepository.deleteById(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
