<template>
  <div>
    <h2>{{ campSiteInfo.siteName }}</h2>
    <p>{{ `〒${campSiteInfo.address.zipCode}` }}</p>
    <p>
      {{
        `${campSiteInfo.address.pref} ${campSiteInfo.address.city} ${campSiteInfo.address.otherAddress}`
      }}
    </p>
  </div>
</template>

<script lang="ts">
import { Vue, Component } from 'nuxt-property-decorator'
import CampSiteInfo from '@/domains/campSite/CampSiteInfo'
import CampSiteService from '@/domains/campSite/CampSiteService'
import ServiceFactory from '@/domains/ServiceFactory'
@Component
export default class SiteDetail extends Vue {
  campSiteService!: CampSiteService
  campSiteInfo: CampSiteInfo = new CampSiteInfo()

  async fetch() {
    this.campSiteService = await ServiceFactory.getContentService()
    this.campSiteInfo = await this.campSiteService.searchById(
      this.$route.params.id
    )
  }
}
</script>