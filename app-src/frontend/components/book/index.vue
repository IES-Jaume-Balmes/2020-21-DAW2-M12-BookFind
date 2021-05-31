<template>
  <v-container fluid>
    <v-btn small outlined to="/"> home </v-btn>
    <v-row v-if="book">
      <v-col md="8">
        <Detalle :book="book" />
      </v-col>
      <v-col md="4">
        <Control :book="book" />
      </v-col>
      <v-col md="12">
        <Recomendation
          v-for="(categoria, i) in book.categories"
          :key="i"
          :categoria="categoria.category"
        />
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import Detalle from "./detalle";
import Recomendation from "./recomendation";
import Control from "./control";

export default {
  props: ["book_id"],
  components: { Detalle, Recomendation, Control },
  mounted() {
    this.getBook();
    // this.getBooks();
  },

  data: () => ({
    url: "http://localhost:8080/",
    book: null,
    books_categoria: [],
    model: null,
  }),
  methods: {
    getBook() {
      this.$axios.get(`${this.url}books/${this.book_id}`).then((response) => {
        console.log(response.data);
        this.book = response.data;
      });
    },
  },
};
</script>

