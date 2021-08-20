<template>
  <div>
    <p>
      <h4>キーワード: {{ $route.query.keyword }}</h4>
      検索結果: {{ dispSiteList.length }}件
    </p>
    <camp-site-list :camp-site-infoes="dispSiteList" />
  </div>
</template>

<script lang="ts">
import { Vue, Component } from 'nuxt-property-decorator'
import CampSiteInfo from '@/domains/campSite/CampSiteInfo'
import CampSiteService from '@/domains/campSite/CampSiteService'
import ServiceFactory from '@/domains/ServiceFactory'

@Component
export default class Index extends Vue {
  campSiteService!: CampSiteService

  dispSiteList: CampSiteInfo[] = []

  async fetch() {
    this.campSiteService = await ServiceFactory.getContentService()
    this.search()
  }

  async search() {
    // TODO queryそのまま渡すでバック側に不都合ないか？
    this.dispSiteList = await this.campSiteService.search(this.$route.query)
  }
}
</script>