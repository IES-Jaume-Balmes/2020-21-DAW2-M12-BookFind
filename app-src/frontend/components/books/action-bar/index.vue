<template>
  <v-row v-if="params">
    <v-col cols="12" sm="6" md="8" style="display: flex">
      <!-- <v-select
        label="Ordenar"
        dense
        outlined
        :items="itemsPerPage"
        small-chips
        @change="(val) => (params.items = val)"
        :value="params.items"
      ></v-select>  -->
     
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

      <!-- <v-menu offset-y>
        <template v-slot:activator="{ on, attrs }">
          <v-btn icon v-bind="attrs" v-on="on">
            <v-icon> mdi-cart-outline</v-icon>
          </v-btn>
        </template>

        <v-list>
          <v-list-item v-for="(item, i) in carrito" :key="i">
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>
      <v-chip label outlined>
        {{ carrito.length }}
      </v-chip> -->
      <v-select
        label="libros"
        dense
        outlined
        :items="itemsPerPage"
        small-chips
        @change="(val) => (params.items = val)"
        :value="params.items"
      ></v-select>
    </v-col>
  </v-row>
</template>

<script>
export default {
  props: ["collectionParams", "carrito"],
  watch: {
    params: {
      handler() {
        this.$emit("change-params", this.params);
      },
      deep: true,
    },
    btnFilters(val) {
      this.$emit("change-view", val);
    },
  },
  mounted() {
    this.params = this.collectionParams;
    this.statusBtn();
  },
  data() {
    return {
      numCarrito: 0,
      params: null,
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