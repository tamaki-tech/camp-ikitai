import CampSiteInfo from '@/domains/campSite/CampSiteInfo'
import { SearchParam } from '../search/SearchUtils'
import { InitResponse } from './SearchItems'

export default interface CampSiteService {
  init: () => Promise<InitResponse>
  search: (param: SearchParam[]) => Promise<CampSiteInfo[]>
  searchById: (id: string) => Promise<CampSiteInfo>
}
