export interface SearchItem {
  id: number
  name: string
  displayName: string
}

export type Facility = SearchItem
export type SiteType = SearchItem

export interface InitResponse {
  facilities: Facility[]
  siteTypes: SiteType[]
}

export interface SearchItems {
  label: string
  items: SearchItem[]
}
