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
  latitude: string
  longitude: string
  price: string
  address: string
}
