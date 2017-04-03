package eu.makdeniss.repository;

import eu.makdeniss.domain.CorePersonStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

/**
 * Created by Deniss Makarenkov on 03/04/2017.
 * Visit http://www.makdeniss.eu/
 */
@RepositoryRestController
public interface CorePersonStatsRepository extends JpaRepository<CorePersonStats, Long> {
}
