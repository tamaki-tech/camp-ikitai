import axios from 'axios'
import CampSiteService from '@/domains/campSite/CampSiteService'
import CampSiteInfo from '@/domains/campSite/CampSiteInfo'
type Dictionary<T> = { [key: string]: T }

export default class CampSiteServiceStub implements CampSiteService {
    // eslint-disable-next-line @typescript-eslint/no-unused-vars
    async search(query: Dictionary<string | (string | null)[]>): Promise<CampSiteInfo[]> {
        return ((await axios.get(`${process.env.BASE_URL}data/content/CampSiteSearch.json`)).data) as CampSiteInfo[]
    }

    async searchById(id: string): Promise<CampSiteInfo> {
        return ((await axios.get(`${process.env.BASE_URL}data/content/CampSiteInfo/${id}.json`)).data) as CampSiteInfo
    }
}