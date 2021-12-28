export interface SearchItem {
  id: number
  name: string
  displayName: string
}

export type Facility = SearchItem
export type Prefecture = SearchItem
export type SiteType = SearchItem

export interface InitResponse {
  facilities: Facility
  prefectures: Prefecture
  siteTypes: SiteType
}
