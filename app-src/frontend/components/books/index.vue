<template>
  <v-container fluid>
    <Header @update-user="updateUserType" />
    <ActionBar :collectionParams="collectionParams" />

    <pre>{{ typeUser }}</pre>

    <v-row>
      <v-col cols="12" >
        <ListBooks
          :collectionParams="collectionParams"
        />
      </v-col>
 
    </v-row>
  </v-container>
</template>

<script>
import ListBooks from "./list-books";
import ActionBar from "./action-bar";
import Filters from "./filters";
import Header from "./header";

export default {
  components: { ListBooks, ActionBar, Filters, Header },

  watch: {
    showFilters(val) {
      this.md = val ? 8 : 12;
    },
  },
  mounted() {
    if (this.$store.state.books.userType) {
      this.typeUser = this.$store.state.books.userType;
    }
  },
  data: () => ({
    typeUser: null,
    md: 12,
    showFilters: false,
    collectionParams: {
      pageSize: 2,
      pageNumber: 0,
      sortBy: "price",
      sort: "asc",
    },
    carrito: [],
  }),
  methods: {
    updateUserType() {
      this.typeUser = this.$store.state.books.userType;
    },
  
  },
};
</script>

<style>
</style>