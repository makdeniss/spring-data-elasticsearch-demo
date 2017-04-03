package eu.makdeniss.service;

import eu.makdeniss.domain.Person;
import eu.makdeniss.domain.PersonDTO;
import eu.makdeniss.mapper.PersonMapper;
import eu.makdeniss.repository.PersonRepository;
import eu.makdeniss.search.PersonSearchRepository;
import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

/**
 * Created by Deniss Makarenkov on 03/04/2017.
 * Visit http://www.makdeniss.eu/
 */
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonSearchRepository personSearchRepository;
    private final PersonMapper personMapper;

    private static final Logger log = Logger.getLogger(PersonServiceImpl.class);

    public PersonServiceImpl(PersonRepository personRepository, PersonSearchRepository personSearchRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personSearchRepository = personSearchRepository;
        this.personMapper = personMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public PersonDTO findOne(Long id) {
        log.info("Request to query for a Person with id: " + id);
        Person person = personRepository.findOne(id);
        return personMapper.personToPersonDTO(person);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PersonDTO> findAll(Pageable pageable) {
        log.info("Request to query all People");
        Page<Person> result = personRepository.findAll(pageable);
        return result.map(person -> personMapper.personToPersonDTO(person));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PersonDTO> search(String query, Pageable pageable) {
        log.info("Request to search for a page of People with a query" + query);
        Page<Person> result = personSearchRepository.search(queryStringQuery(query), pageable);
        return result.map(person -> personMapper.personToPersonDTO(person));
    }
}
