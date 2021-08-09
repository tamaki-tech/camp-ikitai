import CampSiteInfo from '@/domains/campSite/CampSiteInfo'

export default interface CampSiteService {
  search: (keyword: string) => Promise<CampSiteInfo[]>
  searchById: (id: string) => Promise<CampSiteInfo>
}