package jp.co.campikitai.domain.campSite;

import java.util.List;

import org.apache.commons.collections4.IterableUtils;
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

    public List<CampSiteDto> search(List<String> pref, List<String> facility) {
        List<CampSiteEntity> campSites = campSiteRepository.findAll(
                specification.facilityIn(facility).and(specification.prefIn(pref)));
        return factory.map(campSites, CampSiteDto.class);
    }
}
