<template>
  <v-list-item>
    <v-list-item-avatar>
      <v-avatar rounded size="56">
        <img src="https://picsum.photos/295/295" />
      </v-avatar>
    </v-list-item-avatar>
    <v-list-item-content>
      <v-list-item-title
        @click="() => $router.push({ path: 'book/' + book.bookId })"
        >{{ book.title }}
      </v-list-item-title>
      <v-list-item-subtitle style="display: flex">
        {{ book.autor.firstName }}
        {{ book.autor.lastName }}

        <div v-for="categoria in book.categories" :key="categoria.category_id">
          <v-chip x-small outlined>{{ categoria.category }}</v-chip>
        </div>
      </v-list-item-subtitle>
    </v-list-item-content>
    <v-list-item-action>
      <v-list-item-action-text> {{ book.price }} eur </v-list-item-action-text>
      <v-list-item-action-text>
        <v-btn icon x-small @click="delBook" :disabled="cantidad == 0"
          ><v-icon>mdi-minus</v-icon></v-btn
        >
        <v-btn icon x-small @click="addBook"><v-icon>mdi-plus</v-icon></v-btn>
      </v-list-item-action-text>
    </v-list-item-action>
  </v-list-item>
</template>

<script>
export default {
  props: ["book", "carrito"],

  mounted() {},
  watch: {
    cantidad(val) {
      console.log(val);
    },
  },

  data() {
    return {
      cantidad: 0,
    };
  },

  methods: {
    addBook() {
      this.cantidad++;
      // this.$emit("add-book", this.book);
    },
    delBook() {
      this.cantidad--;
      // this.$emit("del-book", this.book);
    },
  },
};
</script>

<style>
</style>