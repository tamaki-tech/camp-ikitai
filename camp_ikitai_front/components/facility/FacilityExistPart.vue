<template>
  <div class="mb-10">
    <v-row class="mt-5">
      <v-col>
        <h2>施設情報</h2>
      </v-col>
    </v-row>
    <v-sheet align="center">
      <div>
        <v-row>
          <v-col cols="2" class="mt-3 mb-4">
            <v-img
              contain
              max-height="42"
              :src="`icon/facility/bon_fire.svg`"
            />
          </v-col>
          <v-col cols="3" class="mt-5 mb-4">
            <strong>焚き火</strong>
          </v-col>
          <v-col cols="2" class="mt-2 mb-3">
            <h1>{{ campSite.bonFire.isExist ? '⚪︎' : '×' }}</h1>
          </v-col>
          <v-col cols="2" class="mt-5">
            {{ campSite.bonFire.detail }}
          </v-col>
        </v-row>
        <v-divider />
        <v-row>
          <v-col cols="2" class="mt-3 mb-4">
            <v-img contain max-height="42" :src="`icon/facility/store.svg`" />
          </v-col>
          <v-col cols="3" class="mt-5 mb-4">
            <strong>売店</strong>
          </v-col>
          <v-col cols="2" class="mt-2 mb-3">
            <h1>{{ campSite.shop.isExist ? '⚪︎' : '×' }}</h1>
          </v-col>
          <v-col cols="2" class="mt-5">
            {{ campSite.shop.detail }}
          </v-col>
        </v-row>
        <v-divider />
        <v-row>
          <v-col cols="2" class="mt-3 mb-4">
            <v-img contain max-height="42" :src="`icon/facility/power.svg`" />
          </v-col>
          <v-col cols="3" class="mt-5 mb-4">
            <strong>電源</strong>
          </v-col>
          <v-col cols="2" class="mt-2 mb-3">
            <h1>{{ campSite.power.isExist ? '⚪︎' : '×' }}</h1>
          </v-col>
          <v-col cols="2" class="mt-5">
            {{ campSite.power.detail }}
          </v-col>
        </v-row>
        <v-divider />
        <v-row>
          <v-col cols="2" class="mt-3 mb-4">
            <v-img contain max-height="42" :src="`icon/facility/shower.svg`" />
          </v-col>
          <v-col cols="3" class="mt-5 mb-4">
            <strong>シャワー・風呂</strong>
          </v-col>
          <v-col cols="2" class="mt-2 mb-3">
            <h1>{{ campSite.bath.isExist ? '⚪︎' : '×' }}</h1>
          </v-col>
          <v-col cols="2" class="mt-5">
            {{ campSite.bath.detail }}
          </v-col>
        </v-row>
        <v-divider />
      </div>
      <br />
    </v-sheet>
    <v-btn block elevation="0" color="primary">
      <strong>全ての施設情報を見る</strong>
    </v-btn>
  </div>
</template>

<script lang="ts">
import { Vue, Component, Prop } from 'nuxt-property-decorator'
import CampSiteInfo from '@/domains/campSite/CampSiteInfo'

@Component
export default class FacilityExistPart extends Vue {
  @Prop()
  campSiteInfo!: CampSiteInfo

  get campSite() {
    return this.campSiteInfo
  }
}
</script>