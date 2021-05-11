<template>
  <v-card>
    <v-card-title>Filters</v-card-title>
    <v-card-text>
      <v-select
        v-model="filters.categoria"
        :items="categoria"
        item-text="name"
        item-value="category_id"
        label="Categoría"
        chips
        small-chips
        deletable-chips
        dense
        outlined
        multiple
        @change="
          (val) => {
            filters.categoria = val;
          }
        "
      ></v-select>
    </v-card-text>
  </v-card>
</template>

<script>
export default {
  watch: {
    filters: {
      handler() {
        console.info("filters ", this.filters);
      },
      deep: true,
    },
  },
  mounted() {
    this.getCategoria();
  },
  data() {
    return {
      filters: { categoria: [] },
      categoria: [],
    };
  },
  methods: {
    getCategoria() {
      this.$axios(
        `https://www.etnassoft.com/api/v1/get/?get_categories=all`
      ).then((response) => {
        // console.info("cat", response);
        this.categoria = response.data;
      });
    },
  },
};
</script>

<style>
</style>