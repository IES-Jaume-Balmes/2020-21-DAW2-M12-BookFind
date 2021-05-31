<template>
  <v-row class="mb-6" no-gutters v-if="books">
    <v-col>
      <v-avatar color="primary" rounded>
        <span class="white--text headline">BF</span>
      </v-avatar>
    </v-col>
    <v-col :cols="6">
      <v-autocomplete
        chips
        outlined
        deletable-chips
        dense
        item-text="title"
        item-value="id"
        :items="books"
        label="Search"
        prepend-inner-icon="mdi-magnify"
        @change="
          (val) =>
            $router.push({
              path:
                $route.name == 'index' ? `book/${val}` : `/book/${val}`,
            })
        "
      />
    </v-col>
    <v-col class="d-flex flex-row-reverse">
      <Login
        @update-user="$emit('update-user')"
        v-if="!$store.state.books.userType"
      />

      <div v-if="$store.state.books.userType" style="display: flex">
        <Carrito v-if="$store.state.books.userType == 'user'" />

        <v-btn
          icon
          x-large
          @click="() => $router.push({ path: 'add-stock/' })"
          v-if="$store.state.books.userType == 'admin'"
        >
          <v-icon>mdi-plus-circle-outline</v-icon>
        </v-btn>

        <v-btn icon x-large @click="logout()">
          <v-icon>mdi-logout</v-icon>
        </v-btn>
      </div>
    </v-col>
  </v-row>
</template>

<script>
import Login from "./login";
import Carrito from "./carrito";
export default {
  components: { Login, Carrito },
 
  data: () => ({
    search: null,
    books: null,
    path: null,
    url: "http://localhost:8080/books/all",
  }),

  mounted() {
    this.getAllBooks();
  },

  methods: {
    getAllBooks() {
      let libros = [];
      this.$axios.get(`${this.url}`).then((response) => {
        // console.log(response);
        response.data.forEach((element) => {
          libros.push({
            id: element.bookId,
            title: element.title,
            author: element.author.fullName,
          });
        });
        this.books = libros;
      });
    },
    logout() {
      this.$store.commit("books/setUserType", null);
      this.$emit("update-user");
    },
  },
};
</script>

<style>
</style>