import Address from "@/domains/campSite/Address";

/* eslint-disable no-useless-constructor */
export default class CampSiteInfo {
  constructor(
    public id = '',
    public siteName = '',
    public address = Address
  ) { }
}