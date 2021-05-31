<template>
  <v-container fluid>
    <v-btn small outlined to="/"> home </v-btn>
    <v-card elevation="0" class="mx-auto my-12" max-width="90%">
      <v-card-title>PAY</v-card-title>
      <v-card-text>
        <v-list v-for="book in $store.state.books.carrito" :key="book.id">
          <Book :book="book" @update-carrito="getCarrito" />
          <v-divider></v-divider>
        </v-list>
      </v-card-text>
      <v-card-actions class="d-flex flex-row-reverse">
        <v-chip label dense disabled outlined>{{ total }}</v-chip>
        Total:
      </v-card-actions>
      <v-card-actions class="d-flex flex-row-reverse">
        <v-btn color="primary" to="/pay" :disabled="$store.state.books.carrito.length==0">BUY</v-btn>
      </v-card-actions>
    </v-card>
  </v-container>
</template>

<script>
import Book from "./book";
export default {
  components: { Book },
  mounted() {
    this.getCarrito();
  },
  data: () => ({
    total: null,
  }),
  methods: {
    getCarrito() {
      this.getTotal();
    },
    getTotal() {
      let total = 0;
      this.$store.state.books.carrito.forEach((b) => {
        total += b.book.price * b.cantidad;
      });
      this.total = total;
    },
  },
};
</script>

<style>
</style>