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
    public bonFire = Facility,
    public shop = Facility,
    public power = Facility,
    public bath = Facility,
    public coordinate: [] = [],
    public otherImage: OtherImage[] = []
  ) { }
}