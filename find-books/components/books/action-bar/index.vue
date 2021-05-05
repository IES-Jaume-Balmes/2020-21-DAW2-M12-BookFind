<template>
  <v-row>
    <v-col cols="12" sm="6" md="8" style="display: flex">
      <v-select
        label="libros"
        dense
        outlined
        :items="itemsPerPage"
        small-chips
        @change="(val) => (params.items = val)"
        :value="params.items"
        style="width: 0;"
      ></v-select>
            <!-- v-model="values"
            :items="items" -->
      <v-autocomplete
            :items="[]"
            outlined
            dense
            chips
            small-chips
            label="Search"
      ></v-autocomplete>
    </v-col>
    <v-col cols="6" md="4" class="d-flex flex-row-reverse">
      <v-btn icon v-if="btnFilters" @click="btnFilters = false">
        <v-icon>mdi-dock-left</v-icon>
      </v-btn>
      <v-btn icon v-else @click="btnFilters = true">
        <v-icon>mdi-dock-right</v-icon>
      </v-btn>

      <v-btn icon @click="params.page++" :disabled="btnStatus">
        <v-icon> mdi-chevron-right</v-icon>
      </v-btn>
      <v-btn icon @click="params.page--" :disabled="params.page === 1">
        <v-icon> mdi-chevron-left</v-icon>
      </v-btn>
    </v-col>
  </v-row>
</template>

<script>
export default {
  watch: {
    params: {
      handler() {
        this.$emit("change-params",this.params)
      },
      deep: true,
    },
  },
  mounted() {
    this.statusBtn();
  },
  data() {
    return {
      params: { page: 1, items: 10 },
      //   page: 1,
      //   items: 10,
      btnStatus: null,
      itemsPerPage: [10, 20, 30, 40],
      btnFilters: null,
    };
  },

  methods: {
    async statusBtn() {
      let page = this.params.page;
      const response = await this.$axios(
        `https://www.etnassoft.com/api/v1/get/?results_range=${page++},${
          this.params.items
        }`
      );

      this.btnStatus = response.data.length == 0;
    },
  },
};
</script>

<style>
</style>