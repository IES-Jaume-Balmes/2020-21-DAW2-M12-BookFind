<template>
  <v-card elevation="0" class="mx-auto my-12">
    <v-img :src="book.image" class="white--text align-end">
      <v-card-title>{{ book.title }}</v-card-title>
    </v-img>
    <v-card-text>
      {{ book.description }}
    </v-card-text>
  </v-card>
</template>
<script>
export default {
  props: ["book"],
  // data: () => ({}),
};
</script>

<style>
</style>