<template>
  <div>
    <p>
      <v-row no-gutters justify="center">
        <v-col cols="6">
          <v-text-field
            prefix="地域"
            placeholder="選択する"
            append-icon="mdi-plus-circle"
            solo
            @click="showPrefSearchDialog"
          />
        </v-col>
        <v-col cols="6">
          <v-text-field
            prefix="条件"
            placeholder="選択する"
            append-icon="mdi-plus-circle"
            solo
            @click="showFeatureSearchDialog"
          />
        </v-col>
      </v-row>
      <v-row no-gutters>
        <v-col cols="12">
          <v-text-field
            prefix="キーワード"
            placeholder="施設名・エリアなど"
            solo
          />
        </v-col>
      </v-row>
      <v-row no-gutters>
        <v-col>
          <v-btn v-model="selected" block color="primary"
            ><v-icon>mdi-magnify</v-icon>検索</v-btn
          >
        </v-col>
      </v-row>
      <br />
      検索結果: {{ dispSiteList.length }}件
    </p>
    <v-row>
      <v-col>
        <v-select v-model="selected" :items="items" solo></v-select>
      </v-col>
    </v-row>
    <camp-site-list :camp-site-infoes="dispSiteList" />
    <search-pref-dialog :dialog.sync="prefSearchDialogShowFlg" />
    <search-feature-dialog :dialog.sync="featureSearchDialogShowFlg" />
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
  prefSearchDialogShowFlg = false
  featureSearchDialogShowFlg = false

  items = [
    '現在地から近い順',
    'イキタイ多い順',
    'クチコミ 多い順',
    '料金 高い順',
    '料金 低い順',
  ]

  selected = this.items[1]

  async fetch() {
    this.campSiteService = await ServiceFactory.getContentService()
    this.search()
  }

  async search() {
    // TODO queryそのまま渡すでバック側に不都合ないか？
    this.dispSiteList = await this.campSiteService.search(this.$route.query)
  }

  showPrefSearchDialog() {
    this.prefSearchDialogShowFlg = true
  }

  showFeatureSearchDialog() {
    this.featureSearchDialogShowFlg = true
  }
}
</script>