<template>
  <div>
    <search-check-box
      v-for="item in items"
      :key="item.label"
      :selected.sync="selectedItemList"
      :item-list="item.items"
      :label="item.label"
    />
    <v-btn block color="primary" @click="toSearchResult">
      この条件で絞り込む
    </v-btn>
  </div>
</template>

<script lang="ts">
import { Vue, Component, Prop, PropSync } from 'nuxt-property-decorator'
import SearchItem from '@/domains/search/SearchItems'

@Component
export default class SearchCheckBoxList extends Vue {
  @PropSync('selected', { type: Array, default: null })
  selectedItemList!: string[]

  @PropSync('dialog', { type: Boolean, default: false })
  showDialog!: boolean

  @Prop()
  items!: SearchItem[]

  dispItems = []

  // TODO親Component側のメソッドを叩くようにリファクタする
  toSearchResult() {
    this.showDialog = false
    return this.$router.push(`/search?${this.createGetParam()}`)
  }

  private createGetParam(): string {
    let res = ''
    this.selectedItemList.forEach((pref) => {
      res += res === '' ? `pref=${pref}` : `&pref=${pref}`
    })
    return res
  }
}
</script>