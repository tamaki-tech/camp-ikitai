package jp.co.campikitai.domain.campSite;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CampSiteService {
    private final CampSiteRepository campSiteRepository;

    public Iterable<CampSiteEntity> findAll() {
        return campSiteRepository.findAll();
    }
}
