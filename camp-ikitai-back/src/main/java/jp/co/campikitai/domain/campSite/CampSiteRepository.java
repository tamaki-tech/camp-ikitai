package jp.co.campikitai.domain.campSite;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampSiteRepository extends CrudRepository<CampSiteEntity, String> {
}
