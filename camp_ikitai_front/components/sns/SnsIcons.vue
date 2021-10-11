<template>
  <v-row v-if="!$vuetify.breakpoint.mobile">
    <v-col cols="2">
      <v-btn color="secondary" outlined>
        <v-img src="icon/twitter.svg" height="20px" width="20px" />
        <strong>ツイートする</strong>
      </v-btn>
    </v-col>
    <v-col cols="2">
      <v-btn color="secondary" outlined>
        <v-img src="icon/line.svg" height="20px" width="20px" />
        <strong>友達に教える</strong>
      </v-btn>
    </v-col>
    <v-col cols="2">
      <v-btn color="secondary" outlined>
        <v-img src="icon/facebook.svg" height="25px" width="25px" />
        <strong>シェアする</strong>
      </v-btn>
    </v-col>
  </v-row>
</template>

<script lang="ts">
import { Vue, Component } from 'nuxt-property-decorator'

@Component
export default class SnsIcons extends Vue {}
</script>