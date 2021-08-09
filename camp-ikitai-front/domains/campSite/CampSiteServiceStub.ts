import axios from 'axios'
import CampSiteService from '@/domains/campSite/CampSiteService'
import CampSiteInfo from '@/domains/campSite/CampSiteInfo'

export default class CampSiteServiceStub implements CampSiteService {
    async search(): Promise<CampSiteInfo[]> {
        return ((await axios.get('/data/content/CampSiteSearch.json')).data) as CampSiteInfo[]
    }

    async searchById(): Promise<CampSiteInfo> {
        return ((await axios.get('/data/content/CampSiteSearchById.json')).data) as CampSiteInfo
    }
}
