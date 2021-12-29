package jp.co.campikitai.domain.campSite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CampSiteRepository
                extends JpaRepository<CampSiteEntity, Integer>, JpaSpecificationExecutor<CampSiteEntity> {
        @Query("SELECT campSite FROM CampSiteEntity campSite WHERE campSite.id = :id")
        CampSiteEntity findById(@Param("id") int id);
}
