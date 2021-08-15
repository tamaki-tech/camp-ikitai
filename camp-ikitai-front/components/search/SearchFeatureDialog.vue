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
        <v-list three-line subheader>
          <v-list-item>
            <v-list-item-content> test </v-list-item-content>
          </v-list-item>
        </v-list>
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

  closeDialog() {
    this.showDialog = false
  }
}
</script>