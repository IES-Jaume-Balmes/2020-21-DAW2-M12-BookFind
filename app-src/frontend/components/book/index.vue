<template>
  <v-row v-if="book">
    <v-col md="8">
      <Detalle :book="book" />
    </v-col>
    <v-col md="4"> {{ book_id }}</v-col>
    <v-col md="12" v-for="categoria in books_categoria" :key="categoria.id">
      <v-card>
        <v-card-title
          >Recomendaciones por Categorias #{{ categoria.name }}</v-card-title
        >
        <v-card-text>
          <v-sheet class="mx-auto" v-if="categoria.books">
            <v-slide-group
              v-model="model"
              class="pa-4"
              active-class="success"
              show-arrows
            >
              <v-slide-item v-for="book in categoria.books" :key="book.id">
                <v-card
                  @click="() => $router.push({ path: '' + book.ID })"
                  class="ma-4"
                >
                  <v-img
                    src="https://picsum.photos/282/450"
                    class="white--text align-end"
                    gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
                  >
                    <v-card-title v-text="book.title"></v-card-title>
                    <v-card-subtitle v-text="book.ID"></v-card-subtitle>
                  </v-img>
                </v-card>
              </v-slide-item>
            </v-slide-group>
          </v-sheet>
        </v-card-text>
      </v-card>
    </v-col>
    
  </v-row>
</template>

<script>
import Detalle from "./detalle";
export default {
  props: ["book_id"],
  components: { Detalle },
  mounted() {
    this.getBook();
    this.getBooks();
  },

  data: () => ({
    book: null,
    books_categoria: [],
    model: null,
  }),
  methods: {
    getBooksByCategoria() {
      this.book.categories.forEach((categoria) => {
        this.getBooks(categoria.category_id, categoria.name);
      });
    },

    getBooks() {
      this.$axios
        .get(`https://www.etnassoft.com/api/v1/get/?category_id=212`)
        .then((response) => {
          console.log(response);
           this.books_categoria.push({
            id: '15',
            name: 'foo',
            books: response.data,
          }); 
        });
    },
    getBook() {
      this.$axios
        .get(`http://localhost:8080/books/${this.book_id}`)
        .then((response) => {
          console.log(response.data);
           this.book = response.data;
          // this.getBooksByCategoria();
        });
    },
  },
};
</script>

