<template>
  <v-app>
    <v-app-bar flat app height="100">
      <v-spacer />
      <v-img
        v-if="$route.path !== '/'"
        class="mt-5 mb-5"
        src="/logo.png"
        max-height="200"
        max-width="200"
        @click="toHome"
      />
      <v-spacer />
    </v-app-bar>
    <v-main>
      <v-container>
        <Nuxt />
      </v-container>
    </v-main>
  </v-app>
</template>

<script lang="ts">
import { Vue, Component } from 'nuxt-property-decorator';

@Component
export default class Default extends Vue {
  toHome() {
    this.$router.push('/');
  }
}
</script>


<style scoped lang="scss">
  /** pc */
  @media screen and (min-width: 1025px) {
    .v-application {
      background-color: #f3f3f3;
    }
  }
</style>