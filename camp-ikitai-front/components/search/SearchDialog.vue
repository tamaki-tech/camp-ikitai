<template>
  <v-row justify="center">
    <v-dialog
      v-model="dialog"
      max-width="1000px"
      persistent
      no-click-animation
    >
      <v-card>
        <v-toolbar dark color="primary">
          <v-btn icon dark @click="() => {showDialog = false}">
            <v-icon>mdi-close</v-icon>
          </v-btn>
          <v-toolbar-title>{{ label }}から探す</v-toolbar-title>
        </v-toolbar>
        <br />
        <v-card-text>
          <search-check-box-list
            :selected.sync="selectedItems"
            :dialog.sync="showDialog"
            :items="searchItems"
          />
        <v-btn block color="primary" @click="search">
          この条件で絞り込む
        </v-btn>
        </v-card-text>
      </v-card>
    </v-dialog>
  </v-row>
</template>

<script lang="ts">
import { Vue, Component, PropSync, Prop } from 'nuxt-property-decorator'
import { SearchItems } from '~/domains/campSite/SearchItems'

@Component
export default class SearchDialog extends Vue {
  @PropSync('dialog', { type: Boolean, default: false })
  showDialog!: boolean

  @PropSync('selected', { type: Array, default: null })
  selectedItems!: string[]

  @Prop()
  searchItems!: SearchItems[]

  @Prop()
  label!: string

  search() {
    this.showDialog = false
    this.$emit('search')
  }
}
</script>