import CampSiteInfo from '@/domains/campSite/CampSiteInfo'
import { SearchParam } from '../search/SearchUtils';

export default interface CampSiteService {
  search: (param: SearchParam[]) => Promise<CampSiteInfo[]>
  searchById: (id: string) => Promise<CampSiteInfo>
}