import { CampSiteInfo } from '@/domains/campSite/CampSiteInfo'
import { InitResponse } from './SearchItems'

export default interface CampSiteService {
  init: () => Promise<InitResponse>
  search: (param: string) => Promise<CampSiteInfo[]>
  searchById: (id: string) => Promise<CampSiteInfo>
}
