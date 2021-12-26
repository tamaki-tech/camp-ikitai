package jp.co.campikitai.interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.campikitai.domain.campSite.CampSiteEntity;
import jp.co.campikitai.domain.campSite.CampSiteService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/campSites")
public class CampSiteController {

    private final CampSiteService campSiteService;

    @GetMapping("")
    public Iterable<CampSiteEntity> find() {
        return campSiteService.findAll();
    }
}
