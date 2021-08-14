<template>
  <div>
    <v-img contain max-height="500px" :src="campSiteInfo.imagePath" />
    <br />
    <v-row>
      <v-col cols="4"><strong>施設名</strong></v-col>
      <v-col cols="8">{{ campSiteInfo.siteName }}</v-col>
    </v-row>
    <v-divider></v-divider>
    <v-row>
      <v-col cols="4"><strong>施設タイプ</strong></v-col>
      <v-col cols="8">{{ isExists(campSiteInfo.type) }}</v-col>
    </v-row>
    <v-divider></v-divider>
    <v-row>
      <v-col cols="4"><strong>アクセス</strong></v-col>
      <v-col cols="8">{{ isExists(campSiteInfo.access) }}</v-col>
    </v-row>
    <v-divider></v-divider>
    <v-row>
      <v-col cols="4"><strong>電話番号</strong></v-col>
      <v-col cols="8">{{ isExists(campSiteInfo.phoneNumber) }}</v-col>
    </v-row>
    <v-divider></v-divider>
    <v-row>
      <v-col cols="4"><strong>HP</strong></v-col>
      <v-col cols="8">{{ isExists(campSiteInfo.url) }}</v-col>
    </v-row>
    <v-divider></v-divider>
    <v-row>
      <v-col cols="4"><strong>料金</strong></v-col>
      <v-col cols="8">{{ isExists(campSiteInfo.price) }}</v-col>
    </v-row>
    <v-divider></v-divider>
  </div>
</template>

<script lang="ts">
import { Vue, Component, Prop } from 'nuxt-property-decorator'
import CampSiteInfo from '@/domains/campSite/CampSiteInfo'

@Component
export default class SiteDetail extends Vue {
  @Prop()
  campSiteInfo!: CampSiteInfo

  // TODO ハイフンはback側で作った方が良いか？
  isExists(value: string) {
    return value == null ? '-' : value
  }
}
</script>