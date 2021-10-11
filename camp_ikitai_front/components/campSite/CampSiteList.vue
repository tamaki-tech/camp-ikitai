<template>
  <div>
    <v-spacer></v-spacer>
    </v-toolbar>
    <v-sheet rounded shaped align="center">
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
                <div class="text-caption mt-1 mb-1" >{{ `${site.address.pref} ${site.address.city} ${site.address.otherAddress}` }}</div>
              </v-row>
              <v-row no-gutters>
                <div class="text-caption">
                  {{ site.access }}
                </div>
              </v-row>
              <v-row no-gutters>
                <div class="text-caption">
                  {{ site.price }} 円
                </div>
              </v-row>
            <v-row no-gutters>
              <v-col cols="6">
                <div class="text-caption">
                  <strong>
                    イキタイ
                  </strong>
                  <v-chip color="red" outlined x-small>
                  {{ site.ikitai }}
                  </v-chip>
                </div>
              </v-col>
              <v-col cols="6">
                <div class="text-caption">
                  <strong>
                    クチコミ
                  </strong>
                  <v-chip color="red" outlined x-small>
                    {{ site.reviewCount }}
                  </v-chip>
                </div>
              </v-col>
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
import CampSiteInfo from '@/domains/campSite/CampSiteInfo'

@Component
export default class Index extends Vue {
  @Prop()
  campSiteInfoes!: CampSiteInfo[]
}
</script>