<template>
  <v-list-item>
    <v-list-item-avatar>
      <v-avatar rounded size="56">
        <img :src="book.book.image" />
      </v-avatar>
    </v-list-item-avatar>
    <v-list-item-content>
      <v-list-item-title
        @click="() => $router.push({ path: 'book/' + book.book.bookId })"
        >{{ book.book.title }} - #{{ book.book.bookId }}
      </v-list-item-title>
    </v-list-item-content>
    <v-list-item-action>
      <v-list-item-action-text> x {{ cantidad }} </v-list-item-action-text>
      <v-list-item-action-text> {{ book.book.price }} </v-list-item-action-text>
      <v-list-item-action-text v-if="$store.state.books.userType == 'user'">
        <v-btn icon x-small @click="delBook(book.cantidad)" :disabled="cantidad == 0"
          ><v-icon>mdi-minus</v-icon></v-btn
        >
        <v-btn icon x-small @click="addBook(book.cantidad)"
          ><v-icon>mdi-plus</v-icon></v-btn
        >
      </v-list-item-action-text>
    </v-list-item-action>
  </v-list-item>
</template>

<script>
export default {
  props: ["book"],
  mounted() {
    this.cantidad = this.book.cantidad;
  },

  data() {
    return {
      cantidad: 0,
    };
  },

  methods: {
    addBook(cantidad) {
      this.$store.commit("books/setCarrito", {
        id: this.book.id,
        book: this.book.book,
        cantidad: ++cantidad,
      });
      this.cantidad = cantidad;
      this.$emit('update-carrito')
    },
    delBook(cantidad) {
      this.$store.commit("books/setCarrito", {
        id: this.book.id,
        book: this.book.book,
        cantidad: --cantidad,
      });
      this.cantidad = cantidad;
      this.$emit('update-carrito')
    },
  },
};
</script>

<style>
</style>