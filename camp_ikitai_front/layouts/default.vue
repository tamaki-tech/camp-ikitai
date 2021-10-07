<template>
  <v-app>
    <v-app-bar fixed app>
      <v-spacer />
      <v-toolbar-title> CAMP△IKITAI </v-toolbar-title>
      <v-spacer />
    </v-app-bar>
    <v-main>
      <v-container>
        <Nuxt />
      </v-container>
    </v-main>
    <v-footer app>
      <span>&copy; {{ new Date().getFullYear() }}</span>
    </v-footer>
  </v-app>
</template>