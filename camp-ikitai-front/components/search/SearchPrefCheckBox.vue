<template>
  <div>
    <h3>関東</h3>
    <v-checkbox
      v-for="pref in prefKanto"
      :key="pref.name"
      v-model="selectedPrefList"
      :label="pref.name"
      :value="pref.value"
    />
    <v-btn block color="primary" @click="showList"> このエリアで絞り込む </v-btn>
  </div>
</template>

<script lang="ts">
import { Vue, Component, PropSync } from 'nuxt-property-decorator'

@Component
export default class SearchPrefDialogHoge extends Vue {
  @PropSync('selected', { type: Array, default: null })
  selectedPrefList!: string[]

  prefKanto: { name: string; value: string }[] = [
    { name: '東京', value: 'tokyo' },
    { name: '神奈川', value: 'kanagawa' },
    { name: '埼玉', value: 'saitama' },
    { name: '茨城', value: 'ibaragi' },
    { name: '群馬', value: 'gunnma' },
    { name: '栃木', value: 'tochigi' },
  ]

  showList() {
    console.log(this.selectedPrefList)
  }
}
</script>