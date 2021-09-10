<template>
  <div>
    <search-check-box
      :selected.sync="selectedPrefList"
      :item-list="prefKanto"
      label="関東"
    />
    <search-check-box
      :selected.sync="selectedPrefList"
      :item-list="prefHokuriku"
      label="北陸・甲信越"
    />
    <v-btn block color="primary" @click="toSearchResult">
      このエリアで絞り込む
    </v-btn>
  </div>
</template>

<script lang="ts">
import { Vue, Component, PropSync } from 'nuxt-property-decorator'
import { Prefectures } from '~/domains/search/SearchItems'

@Component
export default class SearchPreCheckBoxList extends Vue {
  @PropSync('selected', { type: Array, default: null })
  selectedPrefList!: string[]

  @PropSync('dialog', { type: Boolean, default: false })
  showDialog!: boolean

  prefKanto: any = []
  prefHokuriku: any = []

  fetch() {
    // TODO リファクタ
    this.prefKanto = Prefectures.kanto
    this.prefHokuriku = Prefectures.hokuriku
  }

  // TODO親Component側のメソッドを叩くようにリファクタする
  toSearchResult() {
    this.showDialog = false
    return this.$router.push(`/search?${this.createGetParam()}`)
  }

  private createGetParam(): string {
    let res = ''
    this.selectedPrefList.forEach((pref) => {
      res += res === '' ? `pref=${pref}` : `&pref=${pref}`
    })
    return res
  }
}
</script>