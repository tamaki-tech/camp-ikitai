package jp.co.campikitai.domain.campSite.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class CampSiteDto {
    private int id;
    private SiteTypeDto siteType;
    private String siteName;
    private String addition;
    private String access;
    private String phoneNumber;
    private String url;
    private String price;
    private String imagePath;
    private String latitude;
    private String longitude;

    @JsonIgnore private List<FacilityDto> facilityEntities;

    @JsonGetter("facilities")
    private List<FacilityDto> getFacilities(){
        return this.getFacilityEntities();
    }
}
