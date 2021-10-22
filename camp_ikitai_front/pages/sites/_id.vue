<template>
  <div>
    <v-spacer></v-spacer>
    <v-sheet rounded shaped align="center" class="rounded-xl">
      <v-sheet max-width="900" align="left">
        <div class="mt-4 mb-4">
          <v-row>
            <v-col>
              <h1>
                <strong>{{ campSiteInfo.siteName }}</strong>
              </h1>
            </v-col>
          </v-row>
          <v-row no-gutters>
            <v-col>
              <h3>
                <font color="gray">
                  {{
                    `${campSiteInfo.address.pref} ${campSiteInfo.address.city}`
                  }}
                </font>
              </h3>
            </v-col>
          </v-row>
          <sns-icons />
          <facility-exist-part :facilities="campSiteInfo.facilities" />
          <v-row class="mt-3">
            <v-col>
              <h2>施設補足情報</h2>
            </v-col>
          </v-row>
          <v-row>
            <v-col>
              <p>{{ campSiteInfo.addition }}</p>
            </v-col>
          </v-row>
          <camp-site-detail :camp-site-info="campSiteInfo" />
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