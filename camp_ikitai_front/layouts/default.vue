<template>
  <v-app>
    <div>
      <v-app-bar v-if="$vuetify.breakpoint.mobile" flat app>
        <v-app-bar-nav-icon />
        <v-spacer />
        <v-img
          v-if="$route.path !== '/'"
          src="logo.png"
          max-height="100"
          max-width="100"
          @click="toHome"
        />
        <v-spacer />
        <v-icon>mdi-magnify</v-icon>
      </v-app-bar>
      <v-app-bar v-else flat height="100px">
        <v-img
          v-if="$route.path !== '/'"
          class="mt-5 mb-5"
          src="logo.png"
          max-height="200"
          max-width="200"
          @click="toHome"
        />
        <v-tabs hide-slider>
          <v-tab><strong>キャンプイキタイとは</strong></v-tab>
          <v-tab><strong>マガジン</strong></v-tab>
          <v-tab><strong>キャンプ場登録</strong></v-tab>
        </v-tabs>
        <v-spacer />
      </v-app-bar>
    </div>

    <v-main>
      <v-container>
        <Nuxt />
      </v-container>
    </v-main>
  </v-app>
</template>

<script lang="ts">
import { Vue, Component } from 'nuxt-property-decorator'

@Component
export default class Default extends Vue {
  toHome() {
    this.$router.push('/')
  }
}
</script>


<style scoped lang="scss">
/** pc */
@media screen and (min-width: 1025px) {
  .v-application {
    background-color: #f3f3f3;
  }
  .theme--light.v-app-bar.v-toolbar.v-sheet {
    background-color: rgba(0, 0, 0, 0);
  }
}
</style>