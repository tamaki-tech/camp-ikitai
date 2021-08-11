<template>
  <div>
    <h2>{{ campSiteInfo.siteName }}</h2>
    <h5>
      {{ `${campSiteInfo.address.pref} ${campSiteInfo.address.city}` }}
    </h5>
    <br />
    <div v-for="facility in campSiteInfo.facilities" :key="facility.id">
      <v-row>
        <v-col>{{ facility.facilityName }}</v-col>
        <v-col>{{ facility.isExist }}</v-col>
      </v-row>
      <v-divider></v-divider>
    </div>
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