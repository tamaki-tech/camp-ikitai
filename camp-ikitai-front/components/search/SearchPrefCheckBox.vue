<template>
  <div>
    <!-- TODO Component切り出す -->
    <div>
      <h3>関東</h3>
      <v-row v-for="prefPair in prefKanto" :key="prefPair.id" no-gutters dense>
        <v-col v-for="pref in prefPair.value" :key="pref.name">
          <v-checkbox
            v-model="selectedPrefList"
            :label="pref.name"
            :value="pref.value"
          />
        </v-col>
      </v-row>
    </div>
    <v-divider></v-divider>
    <br />
    <div>
      <h3>北陸・甲信越</h3>
      <v-row
        v-for="prefPair in prefHokuriku"
        :key="prefPair.id"
        no-gutters
        dense
      >
        <v-col v-for="pref in prefPair.value" :key="pref.name">
          <v-checkbox
            v-model="selectedPrefList"
            :label="pref.name"
            :value="pref.value"
          />
        </v-col>
      </v-row>
    </div>
    <v-btn block color="primary" @click="toSearchResult">
      このエリアで絞り込む
    </v-btn>
  </div>
</template>

<script lang="ts">
import { Vue, Component, PropSync } from 'nuxt-property-decorator'
import { SearchItems } from '@/domains/campSite/SearchItems'

@Component
export default class SearchPrefDialogHoge extends Vue {
  @PropSync('selected', { type: Array, default: null })
  selectedPrefList!: string[]

  @PropSync('dialog', { type: Boolean, default: false })
  showDialog!: boolean

  prefKanto: any = []
  prefHokuriku: any = []

  fetch() {
    this.prefKanto = SearchItems.prefKanto
    this.prefHokuriku = SearchItems.prefHokuriku
  }

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