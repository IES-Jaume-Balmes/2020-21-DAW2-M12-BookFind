<template>
  <v-list-item>
    <v-list-item-avatar>
      <v-avatar rounded size="56">
        <img src="https://picsum.photos/295/295" />
      </v-avatar>
    </v-list-item-avatar>
    <v-list-item-content>
      <v-list-item-title>{{ book.title }} </v-list-item-title>
      <v-list-item-subtitle>{{ book.author }} </v-list-item-subtitle>
    </v-list-item-content>
    <v-list-item-action>
      <v-list-item-action-text> 15 eur </v-list-item-action-text>
      <v-list-item-action-text>
        <v-btn icon x-small @click="delBook"><v-icon>mdi-minus</v-icon></v-btn>
        <v-btn icon x-small @click="addBook"><v-icon>mdi-plus</v-icon></v-btn>
      </v-list-item-action-text>
    </v-list-item-action>
  </v-list-item>
</template>

<script>
export default {
  props: ["book", "carrito"],

  methods: {
    addBook() {
      this.$emit("add-book", this.book);
    },
    delBook() {
      this.$emit("del-book", this.book);
    },
  },
};
</script>

<style>
</style>