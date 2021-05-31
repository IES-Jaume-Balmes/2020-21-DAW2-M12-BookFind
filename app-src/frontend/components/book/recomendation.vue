<template>
  <v-card elevation="0" class="mx-auto my-12">
    <v-card-title v-if="categoria" v-text="categoria"/>
    <v-card-title v-if="author" v-text="author.fullName"/>
    <v-card-text>
      <v-sheet class="mx-auto">
        <v-slide-group
          v-model="model"
          class="pa-4"
          active-class="success"
          show-arrows
        >
          <v-slide-item v-for="(book, i) in books" :key="i">
            <v-card
              @click="() => $router.push({ path: '' + book.bookId })"
              class="ma-4"
            >
              <v-img
                :src="book.image"
                class="white--text align-end"
                gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
              >
                <v-card-title v-text="book.title" />
                <v-card-subtitle
                  v-text="book.author.fullName"
                  style="color: white"
                />
              </v-img>
            </v-card>
          </v-slide-item>
        </v-slide-group>
      </v-sheet>
    </v-card-text>
  </v-card>
</template>

<script>
export default {
  props: ["categoria", "author"],
  mounted() {
    if (this.categoria) {
      this.getBooksByCategory();
    }

    if (this.author) {
      this.getBooksByAuthor();
    }
  },
  data: () => ({
    books: null,
    model: null,
  }),
  methods: {
    getBooksByCategory() {
      this.$axios
        .get(
          `http://localhost:8080/books/category/${this.categoria}?pageSize=10&pageNumber=0`
        )
        .then((response) => {
          this.books = response.data.content;
        });
    },
    getBooksByAuthor() {
      if (this.author) {
        this.$axios
          .get(`http://localhost:8080/books/author/id/${this.author.authorId}`)
          .then((response) => {
            this.books = response.data.content;
          });
      }
    },
  },
};
</script>

<style>
</style>