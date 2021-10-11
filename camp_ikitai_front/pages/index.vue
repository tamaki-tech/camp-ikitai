<template>
  <div>
    <v-row style="height: 500px" justify="center" align-content="center">
      <v-col align="center">
        <h4>
          あなただけのお気に入りが見つかる
        </h4>
        <v-img
        class="ml-md-5"
        src="logo.png"
        max-height="500"
        max-width="500"
        />
        <br />
        <v-row justify="center">
          <v-col>
            <v-btn x-small outlined>キーワードから探す</v-btn>
            <v-btn color="primary" x-small elevation="0" @click="showPrefSearchDialog">
              都道府県から探す
            </v-btn>
            <v-btn color="primary" x-small elevation="0" @click="showFeatureSearchDialog">
              特徴から探す
            </v-btn>
          </v-col>
        </v-row>
        <v-text-field v-model="searchWords" :label="message" type="text">
          <template #append-outer>
            <v-btn color="primary" elevation="0" @click="toSearchResult">検索</v-btn>
          </template>
        </v-text-field>
        <v-btn color="primary" elevation="0">現在地から探す</v-btn>
      </v-col>
    </v-row>
    <search-dialog
      :dialog.sync="prefSearchDialogShowFlg"
      :selected.sync="selectedPrefItems"
      label="都道府県"
      :search-items="prefItems"
      @search="toSearchResult"
    />
    <search-dialog
      :dialog.sync="featureSearchDialogShowFlg"
      :selected.sync="selectedFeatureItems"
      label="特徴"
      :search-items="featureItems"
      @search="toSearchResult"
    />
  </div>
</template>

<script lang="ts">
import { Vue, Component } from 'nuxt-property-decorator'
import CampSiteInfo from '@/domains/campSite/CampSiteInfo'
import CampSiteService from '@/domains/campSite/CampSiteService'
import { Features, Prefectures } from '@/domains/search/SearchItems'
import { SearchUtils } from '@/domains/search/SearchUtils'

@Component
export default class Index extends Vue {
  campSiteService!: CampSiteService

  message = 'キャンプ場名・エリア'
  searchWords = ''
  dispSiteList: CampSiteInfo[] = []

  prefSearchDialogShowFlg = false
  featureSearchDialogShowFlg = false
  selectedPrefItems = []
  selectedFeatureItems = []

  prefItems = Prefectures
  featureItems = Features

  showPrefSearchDialog() {
    this.prefSearchDialogShowFlg = true
  }

  showFeatureSearchDialog() {
    this.featureSearchDialogShowFlg = true
  }

  toSearchResult() {
    const param = SearchUtils.createGetUriParam(
      this.searchWords.split(' '),
      this.selectedPrefItems,
      this.selectedFeatureItems
    )
    return this.$router.push(`/search?${param}`)
  }
}
</script>

<style scoped>
::v-deep .v-text-field {
  width: 500px;
}
</style>