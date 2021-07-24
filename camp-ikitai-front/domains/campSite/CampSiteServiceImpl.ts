import CampSiteService from '@/domains/campSite/CampSiteService'
import CampSiteInfo from '@/domains/campSite/CampSiteInfo'

export default class CampSiteServiceImpl implements CampSiteService {
  async search(): Promise<CampSiteInfo[]> {
    return await Promise.resolve([new CampSiteInfo()])
  }
}
