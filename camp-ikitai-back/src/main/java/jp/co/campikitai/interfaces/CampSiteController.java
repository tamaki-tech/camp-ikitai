package jp.co.campikitai.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.campikitai.domain.campSite.CampSiteService;
import jp.co.campikitai.domain.campSite.dto.CampSiteDto;
import jp.co.campikitai.domain.campSite.response.InitResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/campSites")
public class CampSiteController {

    private final CampSiteService campSiteService;

    @GetMapping("")
    public List<CampSiteDto> find() {
        return campSiteService.findAll();
    }

    @GetMapping("/init")
    public InitResponse init() {
        return campSiteService.init();
    }

}
