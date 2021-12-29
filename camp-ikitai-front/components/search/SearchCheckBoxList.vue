<template>
  <div>
    <search-check-box
      v-for="item in items"
      :key="item.label"
      :selected.sync="selectedItemList"
      :item-list="item.items"
      :label="item.label"
    />
  </div>
</template>

<script lang="ts">
import { Vue, Component, Prop, PropSync } from 'nuxt-property-decorator'
import { SearchItems } from '~/domains/campSite/SearchItems'

@Component
export default class SearchCheckBoxList extends Vue {
  @PropSync('selected', { type: Array, default: null })
  selectedItemList!: string[]

  @PropSync('dialog', { type: Boolean, default: false })
  showDialog!: boolean

  @Prop()
  items!: SearchItems[]

  dispItems = []
}
</script>