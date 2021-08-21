<template>
  <div>
    <h3>{{ label }}</h3>
    <v-row v-for="itemPair in itemList" :key="itemPair.id" no-gutters dense>
      <v-col v-for="item in itemPair.value" :key="item.name">
        <v-checkbox
          v-model="selectedList"
          :label="item.name"
          :value="item.value"
        />
      </v-col>
    </v-row>
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
}
</script>