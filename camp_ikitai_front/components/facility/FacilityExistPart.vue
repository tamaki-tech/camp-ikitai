<template>
  <div class="mb-10">
    <v-row class="mt-5">
      <v-col>
        <h2>施設情報</h2>
      </v-col>
    </v-row>
    <v-sheet align="center">
      <div v-for="facility in facilities" :key="facility.id">
        <v-row>
          <v-col cols="2" class="mt-3 mb-4">
            <v-img
              contain
              max-height="42"
              :src="`icon/facility/${facility.facility}.svg`"
            />
          </v-col>
          <v-col cols="3" class="mt-5 mb-4">
            <strong>{{ facility.facilityName }}</strong>
          </v-col>
          <v-col cols="2" class="mt-2 mb-3">
            <h1>{{ facility.isExist }}</h1>
          </v-col>
        </v-row>
        <v-divider></v-divider>
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
import Facility from '@/domains/campSite/Facility'

@Component
export default class FacilityExistPart extends Vue {
  @Prop()
  facilities!: Facility[]
}
</script>