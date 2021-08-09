<template>
  <div>
      <v-spacer></v-spacer>
    </v-toolbar>
    <v-sheet v-for="site in campSiteInfoes" :key="site.id" @click="toCapmSiteDetail(site.id)">
      <v-divider></v-divider>
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
      </v-row>
    </v-sheet>
    <v-divider></v-divider>
  </div>
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

  toCapmSiteDetail(id: string) {
    return this.$router.push(`/sites/${id}`)
  }
}
</script>