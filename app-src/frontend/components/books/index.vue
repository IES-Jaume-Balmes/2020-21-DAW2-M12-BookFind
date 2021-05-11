<template>
  <v-container fluid>
    <ActionBar
      :collectionParams="collectionParams"
      @change-params="(val) => (collectionParams = val)"
      @change-view="(val) => (vistaFilters = val)"
      :carrito="carrito"
    />
    <v-row v-if="vistaFilters">
      <v-col cols="12" sm="6" md="8">
        <ListBooks
          :collectionParams="collectionParams"
          @carrito="(val) => (carrito = val)"
        />
      </v-col>
      <v-col cols="6" md="4">
        <!-- v-model="filters" -->
        <Filters />
      </v-col>
    </v-row>
    <v-row v-else>
      <v-col>
        <ListBooks
          :collectionParams="collectionParams"
          @carrito="(val) => (carrito = val)"
        />
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import ListBooks from "./list-books";
import ActionBar from "./action-bar";
import Filters from "./filters";

export default {
  components: { ListBooks, ActionBar, Filters },
  watch: {
    carrito: {
      handler() {
       // console.log(this.carrito);
      },
      deep: true,
    },
  },
  data() {
    return {
      vistaFilters: false,
      collectionParams: {
        page: 1,
        items: 40,
      },
      carrito: [],
    };
  },
};
</script>

<style>
</style>