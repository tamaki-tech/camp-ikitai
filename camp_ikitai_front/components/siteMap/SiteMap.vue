<template>
  <l-map :zoom="zoom" :center="center" style="z-index: 0">
    <l-tile-layer :url="url"></l-tile-layer>
    <l-marker :lat-lng="center" />
  </l-map>
</template>

<script lang="ts">
import { Vue, Component, Prop } from 'nuxt-property-decorator'

@Component
export default class SiteMap extends Vue {
  @Prop()
  center!: []

  zoom = 15
  url = 'http://{s}.tile.osm.org/{z}/{x}/{y}.png'
}
</script>