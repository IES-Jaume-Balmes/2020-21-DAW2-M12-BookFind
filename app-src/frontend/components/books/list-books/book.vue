<template>
  <v-list-item>
    <v-list-item-avatar>
      <v-avatar rounded size="56">
        <img src="https://picsum.photos/295/295" />
      </v-avatar>
    </v-list-item-avatar>
    <v-list-item-content>
      <v-list-item-title>{{ book.title }} </v-list-item-title>
      <v-list-item-subtitle style="display: flex"
        >{{ book.author }}

        <div v-for="categoria in book.categories" :key="categoria.category_id">
          <v-chip x-small outlined >{{ categoria.name }}</v-chip>
        </div>
      </v-list-item-subtitle>
    </v-list-item-content>
    <v-list-item-action>
      <v-list-item-action-text> 15 eur </v-list-item-action-text>
      <v-list-item-action-text>
        <v-btn icon x-small @click="delBook" :disabled="disabled.del"
          ><v-icon>mdi-minus</v-icon></v-btn
        >
        <v-btn icon x-small @click="addBook" :disabled="disabled.add"
          ><v-icon>mdi-plus</v-icon></v-btn
        >
      </v-list-item-action-text>
    </v-list-item-action>
  </v-list-item>
</template>

<script>
export default {
  props: ["book", "carrito"],

  mounted() {
  },

  data() {
    return {
      disabled: { add: false, del: true },
    };
  },

  methods: {
    addBook() {
      this.disabled.add = true;
      this.disabled.del = false;
      this.$emit("add-book", this.book);
    },
    delBook() {
      this.disabled.add = false;
      this.disabled.del = true;
      this.$emit("del-book", this.book);
    },
  },
};
</script>

<style>
</style>