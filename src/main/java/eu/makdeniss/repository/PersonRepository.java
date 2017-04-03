package eu.makdeniss.repository;

import eu.makdeniss.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Deniss Makarenkov on 03/04/2017.
 * Visit http://www.makdeniss.eu/
 */
@RepositoryRestResource
public interface PersonRepository extends JpaRepository<Person, Long> {
}
