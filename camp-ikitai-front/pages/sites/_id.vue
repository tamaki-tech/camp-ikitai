<template>
  <div>
    <p>
      <h2>{{ campSiteInfo.siteName }}</h2>
      <h5>{{ `${campSiteInfo.address.pref} ${campSiteInfo.address.city}` }}</h5>
    </p>
    <h4>■設備・ルール</h4>
    <facility-exist-part :facilities="campSiteInfo.facilities" />
    <h4>■施設補足情報</h4>
    <p>{{ campSiteInfo.addition }}</p>
    <h3>基本情報</h3>
    <camp-site-detail :camp-site-info="campSiteInfo" />
    <div id="map">
    <br>
    <no-ssr>
      <!-- 気仙沼大島の緯度・経度(サンプル実装) -->
      <l-map :zoom="zoom" :center="center">
        <l-tile-layer :url="url"></l-tile-layer>
        <l-marker v-for="marker of marker" :key="marker" :lat-lng="marker" />
      </l-map>
    </no-ssr>
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

  // leafletの設定
  center = [38.856355,141.615593]
  zoom = 13
  url = "http://{s}.tile.osm.org/{z}/{x}/{y}.png"

  // マーカーを置く場所一覧（観光地）
  marker= {
    center:  [38.856355,141.615593],
    kugunaribeach: [38.873171,141.63164],
    mtkame: [38.87373,141.617855],
    tatsumai: [38.830445,141.624526],
    kodanobeach: [38.851971,141.622216],
    bridge: [38.878459,141.606309]
  }

  async fetch() {
    this.campSiteService = await ServiceFactory.getContentService()
    this.campSiteInfo = await this.campSiteService.searchById(
      this.$route.params.id
    )
  }
}
</script>

<style scoped>
#map {
    height: 300px;
    width:350px;
}
</style>