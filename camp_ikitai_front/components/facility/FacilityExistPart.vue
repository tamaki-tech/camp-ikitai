<template>
    <v-sheet align="center">
      <div v-for="facility in facilities" :key="facility.id">
        <v-row>
          <v-col cols="4">{{ facility.facilityName }}</v-col>
          <v-col cols="8">{{ facility.isExist }}</v-col>
        </v-row>
        <v-divider></v-divider>
      </div>
      <br />
    </div>
    </v-sheet>

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