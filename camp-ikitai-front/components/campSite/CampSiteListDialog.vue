<template>
  <v-dialog
    v-model="dialogShowFlag"
    fullscreen
    hide-overlay
    transition="dialog-bottom-transition"
  >
    <v-card>
      <v-toolbar>
        <v-btn icon @click="dialogShowFlag = false">
          <v-icon>mdi-close</v-icon>
        </v-btn>
        <v-toolbar-title>検索結果</v-toolbar-title>
        <v-spacer></v-spacer>
      </v-toolbar>
      <v-sheet v-for="site in campSiteInfoes" :key="site.id">
        <v-row>
          <v-col>
            <h4>{{ site.siteName }}</h4>
          </v-col>
        </v-row>
        <v-row>
          <v-col>
            {{ `〒${site.address.zipCode}` }}
          </v-col>
        </v-row>
        <v-row>
          <v-col>
            {{
              `${site.address.pref} ${site.address.city} ${site.address.otherAddress}`
            }}
          </v-col>
        </v-row>
        <v-row>
          <v-divider></v-divider>
        </v-row>
      </v-sheet>
    </v-card>
  </v-dialog>
</template>

<script lang="ts">
import { Vue, Component, PropSync, Prop } from 'nuxt-property-decorator'
import CampSiteInfo from '~/domains/campSite/CampSiteInfo'

@Component
export default class Index extends Vue {
  @PropSync('dialog', { type: Boolean, default: false })
  dialogShowFlag!: boolean

  @Prop()
  campSiteInfoes!: CampSiteInfo[]
}
</script>