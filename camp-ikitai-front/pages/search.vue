<template>
  <div>
    <v-sheet rounded shaped align="center" class="rounded-xl">
      <br />
      <v-sheet max-width="900">
        <search-part
          :pref-dialog.sync="prefSearchDialogShowFlg"
          :feature-dialog.sync="featureSearchDialogShowFlg"
          :keyword.sync="searchWords"
          :selected.sync="selected"
          :select-items="items"
          @search="search"
        />
      </v-sheet>
    </v-sheet>
    <div class="mt-8 mb-3">
      <v-row>
        <v-col cols="8">
          <h3>キャンプ場検索結果一覧</h3>
        </v-col>
        <v-col v-if="!$vuetify.breakpoint.mobile" cols="2" align="center">
          <v-select v-model="selected" dense :items="items" />
        </v-col>
        <v-col v-if="!$vuetify.breakpoint.mobile" cols="2" align="center">
          検索結果: <strong>{{ dispSiteList.length }}</strong> 件
        </v-col>
      </v-row>
    </div>
    <camp-site-list :camp-site-infoes="dispSiteList" />
    <br />

    <!-- 詳細検索ダイアログ -->
    <search-dialog
      :dialog.sync="prefSearchDialogShowFlg"
      :selected.sync="selectedPrefItems"
      label="都道府県"
      :search-items="prefItems"
      @search="search"
    />
    <search-dialog
      :dialog.sync="featureSearchDialogShowFlg"
      :selected.sync="selectedFeatureItems"
      label="特徴"
      :search-items="featureItems"
      @search="search"
    />
    <div class="text-center mt-5">
      <v-pagination v-model="page" :length="6" circle />
    </div>
  </div>
</template>

<script lang="ts">
import { Vue, Component } from 'nuxt-property-decorator'
import CampSiteInfo from '@/domains/campSite/CampSiteInfo'
import CampSiteService from '@/domains/campSite/CampSiteService'
import ServiceFactory from '@/domains/ServiceFactory'
import { SearchUtils } from '@/domains/search/SearchUtils'
import { Prefectures } from '~/domains/search/PrefectureItems'
import { InitResponse, SearchItems } from '~/domains/campSite/SearchItems'

@Component
export default class Index extends Vue {
  campSiteService!: CampSiteService

  dispSiteList: CampSiteInfo[] = []
  selectedPrefItems: string[] = []
  selectedFeatureItems: string[] = []

  prefSearchDialogShowFlg = false
  featureSearchDialogShowFlg = false
  searchWords = ''

  initResponse!: InitResponse
  prefItems = Prefectures
  featureItems: SearchItems[] = []

  selected = ''
  page = 1

  items = [
    '近い順',
    'イキタイ多い順',
    'クチコミ 多い順',
    '料金 高い順',
    '料金 低い順',
  ]

  async fetch() {
    this.selected = this.items[1]
    this.campSiteService = await ServiceFactory.getContentService()
    this.initResponse = await this.campSiteService.init()
    this.setFacilities()
    this.setParams()
    this.search()
  }

  // TODO 共通化
  setFacilities() {
    this.featureItems.push({
      label: '施設タイプ',
      items: this.initResponse.siteTypes,
    })
    this.featureItems.push({
      label: '場内設備',
      items: this.initResponse.facilities,
    })
  }

  setParams() {
    const prefectures = this.$route.query.pref
    const features = this.$route.query.feature
    const keywords = this.$route.query.keyword
    this.selectedPrefItems = prefectures ? (prefectures as string[]) : []
    this.selectedFeatureItems = features ? (features as string[]) : []
    if (keywords) {
      this.searchWords =
        typeof keywords === 'string' ? keywords : keywords.join(' ')
    }
  }

  async search() {
    // 検索
    this.dispSiteList = await this.campSiteService.search(
      SearchUtils.createParam(
        this.searchWords.split(' '),
        this.selectedPrefItems,
        this.selectedFeatureItems
      )
    )

    // URL繋げる
    const param = SearchUtils.createGetUriParam(
      this.searchWords.split(' '),
      this.selectedPrefItems,
      this.selectedFeatureItems
    )
    this.$router.push(`/search?${param}`)
  }

  showPrefSearchDialog() {
    this.prefSearchDialogShowFlg = true
  }

  showFeatureSearchDialog() {
    this.featureSearchDialogShowFlg = true
  }
}
</script>