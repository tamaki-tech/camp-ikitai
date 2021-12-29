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

    public Specification<CampSiteEntity> facilityEqual(String facility) {
        return (root, query, cb) -> cb.equal(root.join("facilityEntities", JoinType.LEFT).get("name"), facility);
    }
}
