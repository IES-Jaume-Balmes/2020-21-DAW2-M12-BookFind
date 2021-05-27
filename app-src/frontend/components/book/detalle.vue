<template>
  <v-card elevation="0" class="mx-auto my-12">
    <v-img
      src="https://cdn.vuetifyjs.com/images/cards/plane.jpg"
      class="white--text align-end"
    >
      <v-card-title>{{ book.title }}</v-card-title>
      <v-card-subtitle>{{ book.author }}</v-card-subtitle>
    </v-img>
    <v-card-actions>
      <v-spacer></v-spacer>

      <v-btn icon>
        <v-icon>mdi-heart</v-icon>
      </v-btn>

      <v-btn icon>
        <v-icon>mdi-bookmark</v-icon>
      </v-btn>

      <v-btn icon>
        <v-icon>mdi-share-variant</v-icon>
      </v-btn>
    </v-card-actions>
    <v-card-text> 
      {{book.description}}
    </v-card-text>
  </v-card>
</template>
<script>
export default {
  props: ["book"],
  data: () => ({}),
};
</script>

<style>
</style>