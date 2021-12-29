package jp.co.campikitai.interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/search")
    public List<CampSiteDto> search(
            @RequestParam(value = "pref", required = false) String[] pref,
            @RequestParam(value = "feature", required = false) String[] feature,
            @RequestParam(value = "keyword", required = false) String keyword) {
        return campSiteService.search(
                Arrays.asList(Optional.ofNullable(pref).orElse(new String[0])),
                Arrays.asList(Optional.ofNullable(feature).orElse(new String[0])));
    }
}
