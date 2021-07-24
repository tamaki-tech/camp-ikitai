<template>
  <v-row style="height: 450px" justify="center" align-content="center">
    <v-col align="center">
      あなただけのお気に入りが見つかる
      <h2>キャンプ△イキタイ</h2>
    </v-col>
    <v-col align="center">
      <v-text-field :label="message" type="text">
        <template #append-outer>
          <v-btn color="primary" elevation="0">検索</v-btn>
        </template>
      </v-text-field>
      <v-btn color="primary" elevation="0">現在地から探す</v-btn>
    </v-col>
  </v-row>
</template>

<script lang="ts">
import { Vue, Component } from 'nuxt-property-decorator'

@Component
export default class Index extends Vue {
  message = 'キャンプ場名・エリア'
}
</script>

<style scoped>
::v-deep .v-text-field {
  width: 500px;
}
</style>