import CampSiteInfo from '@/domains/campSite/CampSiteInfo'

export default interface CampSiteService {
  search: (param: string) => Promise<CampSiteInfo[]>
  searchById: (id: string) => Promise<CampSiteInfo>
}