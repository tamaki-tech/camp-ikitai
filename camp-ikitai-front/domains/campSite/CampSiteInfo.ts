import { SiteType } from './SearchItems'

/* eslint-disable no-useless-constructor */
export interface CampSiteInfo {
  id: string
  siteType: SiteType
  siteName: string
  addition: string
  prefecture: string
  imagePath: string
  access: string
  phoneNumber: string
  url: string
  latitude: number
  longitude: number
  price: string
  address: string
}
