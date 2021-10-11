<template>
  <div>
    <v-sheet rounded shaped align="center">
      <br />
      <v-sheet max-width="900">
        <div class="mt-3">
          <v-row no-gutters justify="center">
            <v-col cols="6">
              <v-text-field
                prefix="地域"
                placeholder="選択する"
                append-icon="mdi-plus-circle"
                outlined
                @click="showPrefSearchDialog"
              />
            </v-col>
            <v-col cols="6">
              <v-text-field
                prefix="条件"
                placeholder="選択する"
                append-icon="mdi-plus-circle"
                outlined
                @click="showFeatureSearchDialog"
              />
            </v-col>
          </v-row>
          <v-row no-gutters>
            <v-col cols="12">
              <v-text-field
                v-model="searchWords"
                prefix="キーワード"
                placeholder="施設名・エリアなど"
                outlined
              />
            </v-col>
          </v-row>
          <v-row no-gutters>
            <v-col>
              <v-btn
                v-model="selected"
                block
                color="primary"
                elevation="0"
                @click="search"
              >
                <v-icon>mdi-magnify</v-icon>検索
              </v-btn>
            </v-col>
          </v-row>
          <br />
          <v-row no-gutters>
            <v-col>
              <v-select v-model="selected" :items="items" outlined></v-select>
            </v-col>
          </v-row>
        </div>
      </v-sheet>
    </v-sheet>
    <div class="mt-8 mb-3">
      <v-row>
        <v-col cols="10">
          <h3>キャンプ場検索結果一覧</h3>
        </v-col>
        <v-col v-if="!$vuetify.breakpoint.mobile" cols="2">
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
import { Features, Prefectures } from '@/domains/search/SearchItems'
import { SearchUtils } from '@/domains/search/SearchUtils'

@Component
export default class Index extends Vue {
  campSiteService!: CampSiteService

  dispSiteList: CampSiteInfo[] = []
  selectedPrefItems: string[] = []
  selectedFeatureItems: string[] = []

  prefSearchDialogShowFlg = false
  featureSearchDialogShowFlg = false
  searchWords = ''

  prefItems = Prefectures
  featureItems = Features

  selected = ''
  page = 1

  items = [
    '現在地から近い順',
    'イキタイ多い順',
    'クチコミ 多い順',
    '料金 高い順',
    '料金 低い順',
  ]

  async fetch() {
    this.selected = this.items[1]
    this.campSiteService = await ServiceFactory.getContentService()
    this.setParams()
    this.search()
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