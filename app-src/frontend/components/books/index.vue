<template>
  <v-container fluid>
    
    <ActionBar
      :collectionParams="collectionParams"
      @change-params="(val) => (collectionParams = val)"
      @change-view="(val) => (vistaFilters = val)"
    />
    <v-row v-if="vistaFilters">
      <v-col cols="12" sm="6" md="8">
        <ListBooks :collectionParams="collectionParams" />
      </v-col>
      <v-col cols="6" md="4">
        <!-- <Filters v-model="filters" /> -->
      </v-col>
    </v-row>
    <v-row v-else>
      <v-col>
        <ListBooks :collectionParams="collectionParams" />
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import ListBooks from "./list-books";
import ActionBar from "./action-bar";

export default {
  components: { ListBooks, ActionBar },
  data() {
    return {
      vistaFilters: false,
      collectionParams: {
        page: 1,
        items: 40,
      },
    };
  },
};
</script>

<style>
</style>