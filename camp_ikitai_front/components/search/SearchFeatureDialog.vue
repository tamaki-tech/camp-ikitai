<template>
  <v-row justify="center">
    <v-dialog
      v-model="dialog"
      fullscreen
      hide-overlay
      transition="dialog-bottom-transition"
    >
      <v-card>
        <v-toolbar dark color="primary">
          <v-btn icon dark @click="closeDialog">
            <v-icon>mdi-close</v-icon>
          </v-btn>
          <v-toolbar-title>特徴から探す</v-toolbar-title>
        </v-toolbar>
        <br />
        <v-card-text>
          <search-feature-check-box-list
            :selected.sync="selected"
            :dialog.sync="showDialog"
          />
        </v-card-text>
      </v-card>
    </v-dialog>
  </v-row>
</template>

<script lang="ts">
import { Vue, Component, PropSync } from 'nuxt-property-decorator'

@Component
export default class SearchFeatureDialog extends Vue {
  @PropSync('dialog', { type: Boolean, default: false })
  showDialog!: boolean

  selected: string[] = []

  closeDialog() {
    this.showDialog = false
  }
}
</script>