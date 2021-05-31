<template>
  <v-card elevation="0" class="mx-auto my-12">
    <v-card-title>{{ categoria }}</v-card-title>
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
                <v-card-subtitle v-text="book.author.fullName" style="color: white;"/>
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
  props: ["categoria"],
  mounted() {
    this.getBooks();
    
  },
  data: () => ({
    books: null,
    model: null,
  }),
  methods: {
    getBooks() {
      this.$axios
        .get(
          `http://localhost:8080/books/category/${this.categoria}?pageSize=10&pageNumber=0`
        )
        .then((response) => {
          this.books = response.data.content;
           console.log(this.books[0].image);
        });
    },
  },
};
</script>

<style>
</style>