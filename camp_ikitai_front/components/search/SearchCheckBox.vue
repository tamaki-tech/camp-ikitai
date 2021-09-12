<template>
  <div>
    <h3>{{ label }}</h3>
    <div>
      <v-row v-for="items in showItemList" :key="items[0].value">
        <v-col v-for="item in items" :key="item.value">
          <v-checkbox
            v-model="selectedList"
            :label="item.name"
            :value="item.value"
          />
        </v-col>
      </v-row>
    </div>
    <v-divider></v-divider>
    <br />
  </div>
</template>

<script lang="ts">
import { Vue, Component, PropSync, Prop } from 'nuxt-property-decorator'

@Component
export default class SearchCheckBox extends Vue {
  @PropSync('selected', { type: Array, default: null })
  selectedList!: string[]

  @Prop()
  itemList!: any

  @Prop()
  label!: string

  showItemList = []

  fetch() {
    // TODO リファクタ
    this.showItemList = this.itemList.reduce(
      (a: any, c: any, i: any) =>
        i % 2 === 0
          ? [...a, [c]]
          : [...a.slice(0, -1), [...a[a.length - 1], c]],
      []
    )
  }
}
</script>