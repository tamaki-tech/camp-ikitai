<template>
  <div>
    <v-row>
      <v-col>
        <img
          width="35px"
          src="icon/tent.svg"
          style="float: left"
          class="mr-3"
          alt=""
        />
        <h2>基本情報</h2>
      </v-col>
    </v-row>
    <v-sheet align="center" class="mt-5 mb-5">
      <v-img contain max-height="500px" :src="campSiteInfo.imagePath" />
      <br />
      <v-row>
        <v-col cols="4" align-self="center"><strong>施設名</strong></v-col>
        <v-col cols="8">{{ campSiteInfo.siteName }}</v-col>
      </v-row>
      <v-divider></v-divider>
      <v-row>
        <v-col cols="4" align-self="center"><strong>施設タイプ</strong></v-col>
        <v-col cols="8">{{ isExists(campSiteInfo.type) }}</v-col>
      </v-row>
      <v-divider></v-divider>
      <v-row>
        <v-col cols="4" align-self="center"><strong>アクセス</strong></v-col>
        <v-col cols="8">{{ isExists(campSiteInfo.access) }}</v-col>
      </v-row>
      <v-divider></v-divider>
      <v-row>
        <v-col cols="4" align-self="center"><strong>電話番号</strong></v-col>
        <v-col cols="8">{{ isExists(campSiteInfo.phoneNumber) }}</v-col>
      </v-row>
      <v-divider></v-divider>
      <v-row>
        <v-col cols="4" align-self="center"><strong>HP</strong></v-col>
        <v-col cols="8">
          <v-btn
            :href="isExists(campSiteInfo.url)"
            text
            color="link"
            class="x-small post-link align-center py-1 px-2"
          >
            <strong>公式サイトを開く</strong>
          </v-btn>
        </v-col>
      </v-row>
      <v-divider></v-divider>
      <v-row>
        <v-col cols="4" align-self="center"><strong>料金</strong></v-col>
        <v-col cols="8">{{ isExists(campSiteInfo.price) }}</v-col>
      </v-row>
      <v-divider></v-divider>
    </v-sheet>
    <v-row>
      <v-col cols="12">
        <div class="map">
          <site-map :center="mapCenter" />
        </div>
      </v-col>
    </v-row>
  </div>
</template>

<script lang="ts">
import { Vue, Component, Prop } from 'nuxt-property-decorator'
import CampSiteInfo from '@/domains/campSite/CampSiteInfo'

@Component
export default class CampSiteDetailMobile extends Vue {
  @Prop()
  campSiteInfo!: CampSiteInfo

  @Prop()
  mapCenter!: []

  // TODO ハイフンはback側で作った方が良いか？
  isExists(value: string) {
    return value == null ? '-' : value
  }
}
</script>

<style scoped>
.post-link {
  display: inline-block;
  word-break: break-all;
  padding: 2px 8px;
  border-radius: 5px;
  text-transform: none !important;
  white-space: normal;
  max-width: calc(100% - 30px);
  height: inherit !important;
}

.map {
  z-index: 0;
  height: 300px;
  width: 100%;
}
</style>