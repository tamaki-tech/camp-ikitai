<template>
  <div>
    <h2>{{ campSiteInfo.siteName }}</h2>
    <h5>{{ `${campSiteInfo.address.pref} ${campSiteInfo.address.city}` }}</h5>
    <br />
    <h4>■設備・ルール</h4>
    <div v-for="facility in campSiteInfo.facilities" :key="facility.id">
      <v-row>
        <v-col cols="4">{{ facility.facilityName }}</v-col>
        <v-col cols="8">{{ facility.isExist }}</v-col>
      </v-row>
      <v-divider></v-divider>
    </div>
    <br />
    <h4>■施設補足情報</h4>
    {{ campSiteInfo.addition }}
    <!-- TODO brは別の方法を検討する -->
    <br />
    <br />
    <h3>基本情報</h3>
    <camp-site-detail :camp-site-info="campSiteInfo" />
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