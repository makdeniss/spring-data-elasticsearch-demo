package eu.makdeniss.controller;

import eu.makdeniss.domain.PersonDTO;
import eu.makdeniss.service.PersonService;
import eu.makdeniss.util.PaginationUtil;
import eu.makdeniss.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * Created by Deniss Makarenkov on 03/04/2017.
 * Visit http://www.makdeniss.eu/
 */
@RestController()
@RequestMapping("/api")
public class PersonController {

    private final PersonService personService;
    private final Logger log = LoggerFactory.getLogger(PersonController.class);
    private static final String ENTITY_NAME = "person";

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/people")
    public ResponseEntity<List<PersonDTO>> getAllPeople(Pageable pageable) throws URISyntaxException {
        log.info("REST request to get a page of People");
        Page<PersonDTO> page = personService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/people");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }


    @GetMapping("/people/{id}")
    public ResponseEntity<PersonDTO> getPerson(@PathVariable Long id) {
        log.info("REST request to get Person: {}", id);
        PersonDTO personDTO = personService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(personDTO));
    }

    @GetMapping("/_search/people")
    public ResponseEntity<List<PersonDTO>> searchPeople(@RequestParam String query, Pageable pageable) throws URISyntaxException {
        log.debug("REST request to search for a page of Appointments for query {}", query);
        Page<PersonDTO> page = personService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/people");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }
}
