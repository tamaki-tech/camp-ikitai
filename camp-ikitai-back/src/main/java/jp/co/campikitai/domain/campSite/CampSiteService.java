package jp.co.campikitai.domain.campSite;

import java.util.List;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

import jp.co.campikitai.common.Factory;
import jp.co.campikitai.domain.campSite.dto.CampSiteDto;
import jp.co.campikitai.domain.campSite.dto.FacilityDto;
import jp.co.campikitai.domain.campSite.dto.PrefectureDto;
import jp.co.campikitai.domain.campSite.dto.SiteTypeDto;
import jp.co.campikitai.domain.campSite.response.InitResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CampSiteService {
    private final CampSiteRepository campSiteRepository;
    private final FacilityRepository facilityRepository;
    private final PrefectureRepository prefectureRepository;
    private final SiteTypeRepository siteTypeRepository;
    private final Factory factory;

    public List<CampSiteDto> findAll() {
        return factory.map(IterableUtils.toList(campSiteRepository.findAll()), CampSiteDto.class);
    }

    public InitResponse init() {
        InitResponse response = new InitResponse();
        response.setFacilities(factory.map(IterableUtils.toList(facilityRepository.findAll()), FacilityDto.class));
        response.setPrefectures(factory.map(IterableUtils.toList(prefectureRepository.findAll()), PrefectureDto.class));
        response.setSiteTypes(factory.map(IterableUtils.toList(siteTypeRepository.findAll()), SiteTypeDto.class));
        return response;
    }
}
