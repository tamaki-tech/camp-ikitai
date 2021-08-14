<template>
  <div>
    <v-spacer></v-spacer>
    </v-toolbar>
    <v-sheet v-for="site in campSiteInfoes" :key="site.id" @click="()=>{$router.push(`/sites/${site.id}`)}">
      <v-divider></v-divider>
      <v-row>
        <v-col cols="4" align-self="center">
          <v-img contain max-height="100" max-width="100" :src="site.imagePath" />
        </v-col>
        <v-col cols="8">
          <p>
            <strong>{{ site.siteName }}</strong>
          </p>
          <p>
            {{ `${site.address.pref} ${site.address.city} ${site.address.otherAddress}` }}
          </p>
        </v-col>
      </v-row>
    </v-sheet>
    <v-divider></v-divider>
  </div>
</template>

<script lang="ts">
import { Vue, Component, PropSync, Prop } from 'nuxt-property-decorator'
import CampSiteInfo from '@/domains/campSite/CampSiteInfo'

@Component
export default class Index extends Vue {
  @PropSync('dialog', { type: Boolean, default: false })
  dialogShowFlag!: boolean

  @Prop()
  campSiteInfoes!: CampSiteInfo[]
}
</script>

<style scoped>
.SideBySide p {
  display: inline-block;
  vertical-align: top; /*縦方向の揃え位置を指定*/
}
</style>