<template>
  <div v-if="mounted">
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
                    `${campSiteInfo.address}`
                  }}
                </font>
              </h3>
            </v-col>
          </v-row>
          <sns-icons />
          <!-- <facility-exist-part :camp-site-info="campSiteInfo" /> -->
          <v-row class="mt-3">
            <v-col>
              <!-- tentアイコン使ってるところ共通化する -->
              <img
                width="35px"
                src="icon/tent.svg"
                style="float: left"
                class="mr-3 mt-1"
                alt=""
              />
              <h2 class="mt-1">施設補足情報</h2>
            </v-col>
          </v-row>
          <v-row class="mb-5">
            <v-col>
              <p>{{ campSiteInfo.addition }}</p>
            </v-col>
          </v-row>
          <camp-site-detail-mobile
            v-if="$vuetify.breakpoint.mobile"
            :camp-site-info="campSiteInfo"
            :map-center="center"
          />
          <camp-site-detail-pc
            v-else
            :camp-site-info="campSiteInfo"
            :map-center="center"
          />
          <v-row class="mt-5">
            <v-col>
              <img
                width="35px"
                src="icon/tent.svg"
                style="float: left"
                class="mr-3 mt-1"
                alt=""
              />
              <h2 class="mt-1">写真ギャラリー</h2>
            </v-col>
          </v-row>
          <v-row>
            <v-col v-for="n in 9" :key="n" class="d-flex child-flex" cols="4">
              <v-img
                :src="`https://camp-ikitai-demo.s3.ap-northeast-1.amazonaws.com/data/img/garally-demo/${n}.jpg`"
                :lazy-load="`https://camp-ikitai-demo.s3.ap-northeast-1.amazonaws.com/data/img/garally-demo/${n}.jpg`"
                aspect-ratio="1"
                class="grey lighten-2"
              >
                <template #placeholder>
                  <v-row
                    class="fill-height ma-0"
                    align="center"
                    justify="center"
                  >
                    <v-progress-circular
                      indeterminate
                      color="grey lighten-5"
                    ></v-progress-circular>
                  </v-row>
                </template>
              </v-img>
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
import { CampSiteInfo } from '@/domains/campSite/CampSiteInfo'
import CampSiteService from '@/domains/campSite/CampSiteService'
import ServiceFactory from '@/domains/ServiceFactory'

@Component
export default class SiteDetail extends Vue {
  campSiteService!: CampSiteService
  campSiteInfo!: CampSiteInfo
  center = [0, 0]
  mounted = false

  async fetch() {
    this.campSiteService = await ServiceFactory.getContentService()
    this.campSiteInfo = await this.campSiteService.searchById(
      this.$route.params.id
    )
    this.center = [this.campSiteInfo.latitude, this.campSiteInfo.longitude]
    this.mounted = true
  }
}
</script>