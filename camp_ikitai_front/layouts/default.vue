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
  </v-app>
</template>

<script>
// TODO variables.scssに定義できるのでは？
export default {
}
</script>
<style scoped>
.v-application {
  background-color: #f3f3f3;
}
</style>