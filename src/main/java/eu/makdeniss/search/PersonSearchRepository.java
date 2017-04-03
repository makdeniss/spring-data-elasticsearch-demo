package eu.makdeniss.search;

import eu.makdeniss.domain.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by Deniss Makarenkov on 03/04/2017.
 * Visit http://www.makdeniss.eu/
 */
public interface PersonSearchRepository extends ElasticsearchRepository<Person, Long> {
}
