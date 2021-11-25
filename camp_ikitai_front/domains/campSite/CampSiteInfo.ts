import Address from "@/domains/campSite/Address";
import Facility from "./Facility";
import OtherImage from "./OtherImage";

/* eslint-disable no-useless-constructor */
export default class CampSiteInfo {
  constructor(
    public id = '',
    public siteName = '',
    public addition = '',
    public imagePath = '',
    public type = '',
    public access = '',
    public phoneNumber = '',
    public url = '',
    public lat = 0.0,
    public lon = 0.0,
    public price = '',
    public address = Address,
    public facilities: Facility[] = [],
    public coordinate: [] = [],
    public ikitai = 0,
    public reviewCount = 0,
    public otherImage: OtherImage[] = []
  ) { }
}