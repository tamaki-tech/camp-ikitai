<template>
  <div>
    <search-check-box
      :selected.sync="selectedFeatureList"
      :item-list="installations"
      label="施設タイプ"
    />
    <search-check-box
      :selected.sync="selectedFeatureList"
      :item-list="facilities"
      label="場内設備"
    />
    <v-btn block color="primary" @click="toSearchResult">
      この条件で絞り込む
    </v-btn>
  </div>
</template>

<script lang="ts">
import { Vue, Component, PropSync } from 'nuxt-property-decorator'
import { Features } from '~/domains/search/SearchItems'

@Component
export default class SearchFeatureCheckBoxList extends Vue {
  @PropSync('selected', { type: Array, default: null })
  selectedFeatureList!: string[]

  @PropSync('dialog', { type: Boolean, default: false })
  showDialog!: boolean

  installations: any = []
  facilities: any = []

  fetch() {
    // TODO リファクタ
    this.installations = Features.installations
    this.facilities = Features.facilities
  }

  // TODO親Component側のメソッドを叩くようにリファクタする
  toSearchResult() {
    this.showDialog = false
    return this.$router.push(`/search?${this.createGetParam()}`)
  }

  private createGetParam(): string {
    let res = ''
    this.selectedFeatureList.forEach((feature) => {
      res += res === '' ? `feature=${feature}` : `&feature=${feature}`
    })
    return res
  }
}
</script>