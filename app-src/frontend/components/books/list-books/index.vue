<template>
  <div>
    <v-progress-circular
      v-if="loading"
      :size="100"
      color="primary"
      indeterminate
    ></v-progress-circular>
    <div v-else>
      <div v-if="books.length == 0">no hay resultados</div>
      <div v-else>
        <v-list v-for="book in books" :key="book.id">
          <Book
            :book="book"
            @add-book="pushCarrito"
            @del-book="deleteBook"
            :carrito="carrito"
          />
          <!-- @add-book="(val) => carrito.push(val)" -->
          <!-- @del-book="(val) => carrito.push(val)" -->
          <v-divider></v-divider>
        </v-list>
      </div>
    </div>
  </div>
</template>

<script>
import Book from "./book";
export default {
  components: { Book },
  props: ["collectionParams"],
  mounted() {
    this.getBooks();
  },
  watch: {
    collectionParams: {
      handler() {
        this.getBooks();
      },
      deep: true,
    },
    carrito(val) {
      // this.carrito.push(val);
      console.info("carrito ", val);
    },
  },
  data() {
    return {
      loading: false,
      books: [],
      carrito: [],
    };
  },
  methods: {
    pushCarrito(book) {
      
      this.carrito.push(book);
    },
    deleteBook(book) {
      console.info("borra este libro ", book);
      this.carrito.forEach((b) => {
        if (b === book) {
          console.log("Existe Borralo");
        }
      });
    },
    getBooks() {
      this.loading = true;
      this.$axios
        .get(
          `https://www.etnassoft.com/api/v1/get/?results_range=${this.collectionParams.page},${this.collectionParams.items}`
        )
        .then((response) => {
          this.loading = false;
          this.books = response.data;
        });
    },
  },
};
</script>

<style>
</style>