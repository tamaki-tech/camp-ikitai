package jp.co.campikitai.interfaces;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.campikitai.domain.campSite.CampSiteService;
import jp.co.campikitai.domain.campSite.dto.CampSiteDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/campSites")
public class CampSiteController {

    private final CampSiteService campSiteService;
    private final ModelMapper mapper;

    @GetMapping("")
    public List<CampSiteDto> find() {
        List<CampSiteDto> campSites = new ArrayList<>();
        campSiteService.findAll().forEach(entity -> campSites.add(mapper.map(entity, CampSiteDto.class)));
        return campSites;
    }
}
