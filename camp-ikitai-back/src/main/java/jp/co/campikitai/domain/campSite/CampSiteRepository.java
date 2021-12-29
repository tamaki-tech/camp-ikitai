package jp.co.campikitai.domain.campSite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CampSiteRepository
                extends JpaRepository<CampSiteEntity, Integer>, JpaSpecificationExecutor<CampSiteEntity> {
}
