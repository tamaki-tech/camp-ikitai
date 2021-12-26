<template>
  <div class="mt-3">
    <v-row justify="center">
      <v-col cols="6">
        <v-text-field
          prefix="地域"
          placeholder="選択する"
          append-icon="mdi-plus-circle"
          outlined
          @click="showPrefSearchDialog"
        />
      </v-col>
      <v-col cols="6">
        <v-text-field
          prefix="条件"
          placeholder="選択する"
          append-icon="mdi-plus-circle"
          outlined
          @click="showFeatureSearchDialog"
        />
      </v-col>
    </v-row>
    <v-row no-gutters>
      <v-col cols="12">
        <v-text-field
          v-model="searchKeyword"
          prefix="キーワード"
          placeholder="施設名・エリアなど"
          outlined
        />
      </v-col>
    </v-row>
    <v-row no-gutters>
      <v-col>
        <v-btn
          v-model="selected"
          block
          color="primary"
          elevation="0"
          @click="search"
        >
          <v-icon>mdi-magnify</v-icon>検索
        </v-btn>
      </v-col>
    </v-row>
    <br />
    <v-row v-if="$vuetify.breakpoint.mobile" no-gutters>
      <v-col>
        <v-select v-model="selectedItem" :items="selectItems" outlined></v-select>
      </v-col>
    </v-row>
  </div>
</template>

<script lang="ts">
import { Vue, Component, PropSync, Prop } from 'nuxt-property-decorator'

@Component
export default class SearchPart extends Vue {
  @PropSync('prefDialog', { type: Boolean, default: false })
  prefSearchDialogShowFlg!: boolean

  @PropSync('featureDialog', { type: Boolean, default: false })
  featureSearchDialogShowFlg!: boolean

  @PropSync('keyword', { type: String, default: '' })
  searchKeyword!: string

  @PropSync('selected', { type: String, default: '' })
  selectedItem!: string

  @Prop()
  selectItems!: []

  showPrefSearchDialog() {
    this.prefSearchDialogShowFlg = true
  }

  showFeatureSearchDialog() {
    this.featureSearchDialogShowFlg = true
  }

  search() {
    this.$emit('search')
  }
}
</script>
