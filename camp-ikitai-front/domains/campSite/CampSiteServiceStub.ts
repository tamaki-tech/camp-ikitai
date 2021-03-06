import axios from 'axios'
import CampSiteService from '@/domains/campSite/CampSiteService'
import { CampSiteInfo } from '@/domains/campSite/CampSiteInfo'
import { InitResponse } from './SearchItems'

export default class CampSiteServiceStub implements CampSiteService {
  async init(): Promise<InitResponse> {
    return (await (
      await axios.get(`${process.env.BASE_URL}data/content/init.json`)
    ).data) as InitResponse
  }

  // eslint-disable-next-line @typescript-eslint/no-unused-vars
  async search(param: string): Promise<CampSiteInfo[]> {
    return (
      await axios.get(`${process.env.BASE_URL}data/content/CampSiteSearch.json`)
    ).data as CampSiteInfo[]
  }

  async searchById(id: string): Promise<CampSiteInfo> {
    return (
      await axios.get(
        `${process.env.BASE_URL}data/content/CampSiteInfo/${id}.json`
      )
    ).data as CampSiteInfo
  }
}
