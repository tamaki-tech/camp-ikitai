<template>
  <div>
    <v-row style="height: 450px" justify="center" align-content="center">
      <v-col align="center">
        あなただけのお気に入りが見つかる
        <h2>キャンプ△イキタイ</h2>
        <v-text-field v-model="searchWords" :label="message" type="text">
          <template #append-outer>
            <v-btn color="primary" @click="toSearchResultPage">検索</v-btn>
          </template>
        </v-text-field>
        <v-btn color="primary">現在地から探す</v-btn>
      </v-col>
    </v-row>
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

  message = 'キャンプ場名・エリア'
  searchWords = ''
  dispSiteList: CampSiteInfo[] = []
  dialogShowFlag = false

  async fetch() {
    this.campSiteService = await ServiceFactory.getContentService()
  }

  toSearchResultPage() {
    return this.$router.push(`/search?keyword=${this.searchWords}`)
  }
}
</script>

<style scoped>
::v-deep .v-text-field {
  width: 500px;
}
</style>