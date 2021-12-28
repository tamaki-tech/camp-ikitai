package jp.co.campikitai.domain.campSite.response;

import java.util.List;

import jp.co.campikitai.domain.campSite.dto.FacilityDto;
import jp.co.campikitai.domain.campSite.dto.PrefectureDto;
import jp.co.campikitai.domain.campSite.dto.SiteTypeDto;
import lombok.Data;

@Data
public class InitResponse {
    private List<SiteTypeDto> siteTypes;
    private List<FacilityDto> facilities;
    private List<PrefectureDto> prefectures;
}
