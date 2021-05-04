<template>
  <v-container fluid>
    <ActionBar @change-params="(params) => (collectionParams = params)" />
    <v-row>
      <v-col cols="12" sm="6" md="8">
        <ListBooks :collectionParams="collectionParams" />
      </v-col>
      <v-col cols="6" md="4">
        foo
        <!-- <Filters v-model="filters" /> -->
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import ListBooks from "./list-books";
import ActionBar from "./action-bar";

export default {
  components: { ListBooks, ActionBar },
  watch: {
    collectionParams: {
      handler() {
        console.log(this.collectionParams);
      },
      deep: true,
    },
  },

  data() {
    return {
      collectionParams: {
        page: 1,
        items: 10,
      },
      // results_range: "0,10",
    };
  },
};
</script>

<style>
</style>