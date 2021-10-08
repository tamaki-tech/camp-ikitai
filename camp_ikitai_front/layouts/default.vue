<template>
  <v-app>
    <v-app-bar dence flat app>
      <v-spacer />
      <v-toolbar-title> CAMP△IKITAI </v-toolbar-title>
      <v-spacer />
    </v-app-bar>
    <v-main>
      <v-container>
        <Nuxt />
      </v-container>
    </v-main>
  </v-app>
</template>

<style scoped lang="scss">
  /** pc */
  @media screen and (min-width: 1025px) {
    .v-application {
      background-color: #f3f3f3;
    }
  }
</style>