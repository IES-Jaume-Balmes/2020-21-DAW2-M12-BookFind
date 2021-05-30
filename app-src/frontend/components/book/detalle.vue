<template>
  <v-card elevation="0" class="mx-auto" max-width="500">
    <v-img
      :src="book.image"
      max-height="660"
      max-width="371"
      class="white--text align-end"
    >
      <v-card-title>{{ book.title }}</v-card-title>
      <v-card-subtitle v-text="book.author.fullName" style="color: white" />
    </v-img>

  </v-card>
</template>
<script>
export default {
  props: ["book"],
};
</script>

<style>
</style>