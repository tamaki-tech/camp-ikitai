<template>
  <div>
    <v-spacer></v-spacer>
    <v-sheet rounded shaped align="center">
      <v-sheet max-width="900" align="left">
        <div class="mt-4 mb-4">
          <v-row >
            <v-col>
              <h2>{{ campSiteInfo.siteName }}</h2>
            </v-col>
          </v-row>
          <v-row>
            <v-col>
              <h5>
                {{
                  `${campSiteInfo.address.pref} ${campSiteInfo.address.city}`
                }}
              </h5>
            </v-col>
          </v-row>
          <v-row>
            <v-col>
              <h4>■設備・ルール</h4>
            </v-col>
          </v-row>
          <facility-exist-part :facilities="campSiteInfo.facilities" />
          <v-row>
            <v-col>
              <h4>■施設補足情報</h4>
            </v-col>
          </v-row>
          <v-row>
            <v-col>
              <p>{{ campSiteInfo.addition }}</p>
            </v-col>
          </v-row>
          <v-row>
            <v-col>
              <h3>基本情報</h3>
            </v-col>
          </v-row>
          <div class="mt-5 mb-5">
            <camp-site-detail :camp-site-info="campSiteInfo" />
          </div>
          <v-row>
            <v-col cols="12">
              <div class="map">
                <site-map :center="center" />
              </div>
            </v-col>
          </v-row>
        </div>

        <br />
      </v-sheet>
    </v-sheet>
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
  center = [0, 0]

  async fetch() {
    this.campSiteService = await ServiceFactory.getContentService()
    this.campSiteInfo = await this.campSiteService.searchById(
      this.$route.params.id
    )
    this.center = this.campSiteInfo.coordinate
  }
}
</script>

<style scoped>
.map {
  z-index: 0;
  height: 300px;
  width: 100%;
}
</style>