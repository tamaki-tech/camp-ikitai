<template>
  <div>
    <v-spacer></v-spacer>
    </v-toolbar>
    <v-sheet rounded shaped align="center" class="rounded-xl">
      <br>
      <v-sheet v-for="site in campSiteInfoes" :key="site.id" max-width="900" @click="()=>{$router.push(`/sites/${site.id}`)}">
        <div class="mt-4 mb-4">
          <v-row>
            <v-col cols="4" align-self="center">
              <v-img contain max-height="230px" max-width="230px" :src="site.imagePath" />
            </v-col>
            <v-col cols="7">
              <v-row no-gutters>
                <strong v-if="$vuetify.breakpoint.mobile">{{ site.siteName }}</strong>
                <h3 v-else>{{ site.siteName }}</h3>               
              </v-row>
              <v-row no-gutters>
                <div class="text-caption mt-1 mb-1" >{{ `${site.address}` }}</div>
              </v-row>
              <v-row no-gutters>
                <div class="text-caption">
                  {{ site.access }}
                </div>
              </v-row>
            </v-col>
          </v-row>
        </div>
        <v-divider></v-divider>
      </v-sheet>
    </v-sheet>
  </div>
</template>

<script lang="ts">
import { Vue, Component, Prop } from 'nuxt-property-decorator'
import { CampSiteInfo } from '@/domains/campSite/CampSiteInfo'

@Component
export default class Index extends Vue {
  @Prop()
  campSiteInfoes!: CampSiteInfo[]
}
</script>