<template>
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
    <v-btn block color="primary" @click="showList">
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

  prefKanto: any = []
  
  fetch() {
    this.prefKanto = SearchItems.prefKanto
  }


  showList() {
    console.log(this.selectedPrefList)
  }
}
</script>