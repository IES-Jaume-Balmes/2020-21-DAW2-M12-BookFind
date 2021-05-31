<template>
  <v-progress-circular
    v-if="loading"
    :size="100"
    color="primary"
    indeterminate
  ></v-progress-circular>
  <div v-else>
    <div v-if="books.length == 0">no hay resultados</div>
    <v-list v-else v-for="book in books" :key="book.bookId">
      <Book :book="book" @update-carrito="$emit('update-carrito')" />
      <v-divider></v-divider>
    </v-list>
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

  },
  data() {
    return {
      loading: false,
      books: [],
      url: "http://localhost:8080/books/page",
    };
  },
  methods: {
    getBooks() {
      this.loading = true;
      this.$axios
        .get(
          `${this.url}?pageSize=${this.collectionParams.pageSize}&pageNumber=${this.collectionParams.pageNumber}&sort=${this.collectionParams.sortBy},${this.collectionParams.sort}`
        )
        .then((response) => {
          this.loading = false;
          this.books = response.data.content;
        });
    },
  },
};
</script>

<style>
</style>