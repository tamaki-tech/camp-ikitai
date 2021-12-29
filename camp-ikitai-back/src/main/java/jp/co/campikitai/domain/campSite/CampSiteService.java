package jp.co.campikitai.domain.campSite;

import java.util.List;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import jp.co.campikitai.common.Factory;
import jp.co.campikitai.domain.campSite.dto.CampSiteDto;
import jp.co.campikitai.domain.campSite.dto.FacilityDto;
import jp.co.campikitai.domain.campSite.dto.SiteTypeDto;
import jp.co.campikitai.domain.campSite.response.InitResponse;
import jp.co.campikitai.domain.campSite.specification.CampSiteSpecification;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CampSiteService {

    private final CampSiteRepository campSiteRepository;
    private final FacilityRepository facilityRepository;
    private final SiteTypeRepository siteTypeRepository;
    private final CampSiteSpecification specification;
    private final Factory factory;

    public InitResponse init() {
        InitResponse response = new InitResponse();
        response.setFacilities(factory.map(IterableUtils.toList(facilityRepository.findAll()), FacilityDto.class));
        response.setSiteTypes(factory.map(IterableUtils.toList(siteTypeRepository.findAll()), SiteTypeDto.class));
        return response;
    }

    public List<CampSiteDto> search(List<String> prefs, List<String> facilities) {
        // 都道府県検索条件
        Specification<CampSiteEntity> searchSpec = specification.prefIn(prefs);

        // 設備検索用クエリの作成
        for (String facility : facilities) {
            searchSpec = searchSpec.and(specification.facilityEqual(facility));
        }
        return factory.map(campSiteRepository.findAll(searchSpec), CampSiteDto.class);
    }

    public CampSiteDto get(int id) {
        return factory.map(campSiteRepository.findById(id), CampSiteDto.class);
    }
}
