import CampSiteService from '@/domains/campSite/CampSiteService'
import CampSiteInfo from '@/domains/campSite/CampSiteInfo'
import axios from 'axios'
import { InitResponse } from './SearchItems'

export default class CampSiteServiceImpl implements CampSiteService {
  async init(): Promise<InitResponse> {
    return (await axios.get(`${process.env.BACK_URL}api/campSites/init`)).data
  }

  async search(): Promise<CampSiteInfo[]> {
    return await Promise.resolve([new CampSiteInfo()])
  }

  async searchById(): Promise<CampSiteInfo> {
    return await Promise.resolve(new CampSiteInfo())
  }
}
