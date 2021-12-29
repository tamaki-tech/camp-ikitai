import CampSiteService from '@/domains/campSite/CampSiteService'
import { CampSiteInfo } from '@/domains/campSite/CampSiteInfo'
import axios from 'axios'
import { InitResponse } from './SearchItems'

export default class CampSiteServiceImpl implements CampSiteService {
  async init(): Promise<InitResponse> {
    return (await axios.get(`${process.env.BACK_URL}api/campSites/init`)).data
  }

  async search(param: string): Promise<CampSiteInfo[]> {
    return (
      await axios.get(`${process.env.BACK_URL}api/campSites/search?${param}`)
    ).data
  }

  async searchById(id: string): Promise<CampSiteInfo> {
    return (await axios.get(`${process.env.BACK_URL}api/campSites/${id}`)).data
  }
}
