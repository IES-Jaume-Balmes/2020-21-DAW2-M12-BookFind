<template>
  <v-container fluid>
    <ActionBar :collectionParams="collectionParams" />
    <ListBooks :collectionParams="collectionParams" />
  </v-container>
</template>

<script>
import ListBooks from "./list-books";
import ActionBar from "./action-bar";
import Filters from "./filters";

export default {
  components: { ListBooks, ActionBar, Filters },


  mounted() {
    if (this.$store.state.books.userType) {
      this.typeUser = this.$store.state.books.userType;
    }
  },
  data: () => ({
    typeUser: null,

    collectionParams: {
      pageSize: 20,
      pageNumber: 0,
      sortBy: "price",
      sort: "asc",
    },
  }),

};
</script>

<style>
</style>