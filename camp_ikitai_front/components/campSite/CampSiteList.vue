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
          <v-row no-gutters>
            <div class="text-caption">
              <strong>
                料金: {{ site.price }} 円
              </strong>
            </div>
          </v-row>
          <v-row no-gutters>
            <div class="text-caption">
              <strong>
                アクセス: {{ site.access }}
              </strong>
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