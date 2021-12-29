package jp.co.campikitai.domain.campSite.specification;

import java.util.List;

import javax.persistence.criteria.JoinType;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import jp.co.campikitai.domain.campSite.CampSiteEntity;

@Component
public class CampSiteSpecification {
    public Specification<CampSiteEntity> prefIn(List<String> pref) {
        return (root, query, cb) -> pref.isEmpty() ? cb.conjunction() : root.get("prefecture").in(pref);
    }

    public Specification<CampSiteEntity> facilityIn(List<String> facility) {
        return (root, query, cb) -> facility.isEmpty()
                ? cb.conjunction()
                : root.join("facilityEntities", JoinType.LEFT).get("name").in(facility);
    }
}
