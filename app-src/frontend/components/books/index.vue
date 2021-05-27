<template>
  <v-container fluid>
    <Header />
     <ActionBar
      :collectionParams="collectionParams"
      @change-view="(val) => (showFilters = val)"
    />
    <v-row>
      <v-col cols="12" :md="md">
        <ListBooks
          :collectionParams="collectionParams"
          @carrito="(val) => (carrito = val)"
        />
      </v-col>
      <v-col v-if="showFilters" cols="6" md="4">
        <Filters />
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
  // watch: {
  //   carrito: {
  //     handler() {
  //       // console.log(this.carrito);
  //     },
  //     deep: true,
  //   },
  // }

  watch: {
    showFilters(val) {
      this.md = val ? 8 : 12;
    },
  },
  data() {
    return {
      md: 12,
      showFilters: false,
      collectionParams: {
        pageSize: 2,
        pageNumber: 0,
        sortBy:'price',
        sort: 'asc',
        // sort: ['price', 'asc'],
      },
      carrito: [],
    };
  },
};
</script>

<style>
</style>