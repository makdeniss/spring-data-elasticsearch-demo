package eu.makdeniss.service;

import eu.makdeniss.domain.PersonDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Deniss Makarenkov on 03/04/2017.
 * Visit http://www.makdeniss.eu/
 */
public interface PersonService {

    PersonDTO findOne(Long id);

    Page<PersonDTO> findAll(Pageable pageable);

    Page<PersonDTO> search(String query, Pageable pageable);
}
