import CampSiteInfo from '@/domains/campSite/CampSiteInfo'
type Dictionary<T> = { [key: string]: T }

export default interface CampSiteService {
  search: (param: Dictionary<string | (string | null)[]>) => Promise<CampSiteInfo[]>
  searchById: (id: string) => Promise<CampSiteInfo>
}