<template>
  <v-row>
    <v-col cols="12" md="5"> </v-col>

    <v-col cols="6" md="7" class="d-flex flex-row-reverse">
      <v-btn icon @click="collectionParams.pageNumber++">
        <v-icon> mdi-chevron-right</v-icon>
      </v-btn>
      <v-chip disabled label outlined>{{ numPag }}</v-chip>
      <v-btn
        icon
        @click="collectionParams.pageNumber--"
        :disabled="collectionParams.pageNumber === 0"
        style="margin-left: 30px;"

      >
        <v-icon> mdi-chevron-left</v-icon>
      </v-btn>
      <v-select
        label="Sort"
        dense
        outlined
        :items="sort"
        small-chips
        @change="(val) => (collectionParams.sort = val)"
        :value="collectionParams.sort"
        style="margin-left: 15px;"

      />
      <v-select
        label="Sort by"
        dense
        outlined
        :items="sortBy"
        small-chips
        @change="(val) => (collectionParams.sortBy = val)"
        :value="collectionParams.sortBy"
        style="margin-left: 15px;"
      />
      <v-select
        label="Books"
        dense
        outlined
        :items="pageSizes"
        small-chips
        @change="(val) => (collectionParams.pageSize = val)"
        :value="collectionParams.pageSize"
        style="margin-left: 15px;"

      />
    </v-col>
  </v-row>
</template>

<script>
export default {
  props: ["collectionParams"],
  watch: {
    btnFilters(val) {
      this.$emit("change-view", val);
    },
    collectionParams: {
      handler() {
        this.numPag = this.collectionParams.pageNumber + 1;
      },
      deep: true,
    },
  },
  mounted() {
    this.numPag = this.collectionParams.pageNumber + 1;
  },
  data() {
    return {
      numPag: 0,
      pageSizes: [10, 20, 30],
      sortBy: ["title", "price", "categories", "author"],
      sort: ["asc", "desc"],
      btnFilters: null,
    };
  },
};
</script>

<style>
</style>