<template>
  <div>
    <h1>detail page</h1>
    <p>{{ $route.params.id }}</p>
  </div>
</template>

<script lang="ts">
import { Vue, Component } from 'nuxt-property-decorator'
@Component
export default class SiteDetail extends Vue {}
</script>