<template>
  <div>
    <v-spacer></v-spacer>
    </v-toolbar>
    <v-sheet v-for="site in campSiteInfoes" :key="site.id" @click="()=>{$router.push(`/sites/${site.id}`)}">
      <br>
      <v-divider></v-divider>
      <br>
      <strong>{{ site.siteName }}</strong>
      <p class="text-caption" >{{ `${site.address.pref} ${site.address.city} ${site.address.otherAddress}` }}</p>
      <v-row>
        <v-col cols="4" align-self="center">
          <v-img contain max-height="100" max-width="100" :src="site.imagePath" />
        </v-col>
        <v-col cols="8">
          <p>{{ `${site.address.pref} ${site.address.city} ${site.address.otherAddress}` }}</p>
        </v-col>
      </v-row>
    </v-sheet>
    <br>
    <v-divider></v-divider>
  </div>
</template>

<script lang="ts">
import { Vue, Component, Prop } from 'nuxt-property-decorator'
import CampSiteInfo from '@/domains/campSite/CampSiteInfo'

@Component
export default class Index extends Vue {
  @Prop()
  campSiteInfoes!: CampSiteInfo[]
}
</script>