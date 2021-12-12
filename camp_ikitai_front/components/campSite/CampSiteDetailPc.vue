<template>
  <div>
    <v-row>
      <v-col>
        <img
          width="35px"
          src="icon/tent.svg"
          style="float: left"
          class="mr-3 mt-1"
          alt=""
        />
        <h2 class="mt-1">基本情報</h2>
      </v-col>
    </v-row>
    <v-sheet class="mt-5 mb-5">
      <div class="flex-container">
        <div class="mr-5">
          <v-img
            max-height="400px"
            max-width="400px"
            :src="campSiteInfo.imagePath"
          />
          <div class="map mt-5">
            <site-map :center="mapCenter" />
          </div>
        </div>
        <div style="width: 50%">
          <table>
            <tr class="mt-5">
              <th id="site-name" class="table_th">施設名</th>
              <td class="table-td">{{ campSiteInfo.siteName }}</td>
            </tr>
            <tr class="mt-5">
              <th id="site-type" class="table_th">施設タイプ</th>
              <td class="table-td">{{ campSiteInfo.type }}</td>
            </tr>
            <tr class="mt-5">
              <th id="access" class="table_th">アクセス</th>
              <td class="table-td">{{ campSiteInfo.access }}</td>
            </tr>
            <tr class="mt-5">
              <th id="phon-number" class="table_th">電話番号</th>
              <td class="table-td">{{ campSiteInfo.phoneNumber }}</td>
            </tr>
            <tr class="mt-5">
              <th id="url" class="table_th">HP</th>
              <td class="table-td">
                <v-btn
                  :href="isExists(campSiteInfo.url)"
                  text
                  color="link"
                  class="x-small post-link align-center py-1 px-2"
                >
                  <strong>公式サイトを開く</strong>
                </v-btn>
              </td>
            </tr>
            <tr class="mt-5">
              <th id="place" class="table_th">料金</th>
              <!-- TODO XSS対策 -->
              <td class="table-td" v-html="campSiteInfo.price"></td>
            </tr>
          </table>
          <div class="mt-5" />
        </div>
      </div>
    </v-sheet>
  </div>
</template>

<script lang="ts">
import { Vue, Component, Prop } from 'nuxt-property-decorator'
import CampSiteInfo from '@/domains/campSite/CampSiteInfo'

@Component
export default class CampSiteDetailPc extends Vue {
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

.flex-container {
  display: flex;
}

.map {
  z-index: 0;
  height: 300px;
  width: 400px;
}

.table-td {
  border-top: 1px solid #eee;
  font-size: 16px;
  padding: 15px 0;
}

.table_th {
  width: 130px;
  /** 共通化 */
  border-top: 1px solid #eee;
  font-size: 16px;
  padding: 15px 0;
}

table {
  width: 500px;
}
</style>