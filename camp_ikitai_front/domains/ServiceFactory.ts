import CampSiteService from "@/domains/campSite/CampSiteService"
import CampSiteServiceImpl from "@/domains/campSite/CampSiteServiceImpl"
import CampSiteServiceStub from "@/domains/campSite/CampSiteServiceStub"

export default class ServiceFactory {
  private static ContentService: CampSiteService

  static async getContentService() {
    if (!this.ContentService) {
      this.ContentService = (await process.env.STUB)
        ? new CampSiteServiceStub()
        : new CampSiteServiceImpl()
    }
    return this.ContentService
  }
}
