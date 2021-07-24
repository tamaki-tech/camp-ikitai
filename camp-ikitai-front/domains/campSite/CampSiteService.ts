import CampSiteInfo from './CampSiteInfo'

export default interface CampSiteService {
  search: (keyword: string) => Promise<CampSiteInfo[]>
}