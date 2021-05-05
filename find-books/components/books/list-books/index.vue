<template>
  <div>
    <!-- {{ collectionParams }} -->
    <v-progress-circular
      v-if="loading"
      :size="100"
      color="primary"
      indeterminate
      
    ></v-progress-circular>
      
    <v-card
      v-for="book in books"
      :key="book.ID"
      outline
      class="mx-auto"
      style="margin-top: 15px"
    >
      <v-card-text>
        <v-row>
          <v-col cols="12" sm="6" md="8" style="display: flex">
            <div>
              <v-avatar color="primary" rounded size="56">
                <span color="primary" class="white--text headline">F </span>
              </v-avatar>
            </div>
            <div>
              <v-card-title style="padding-top: 0">
                {{ book.title }}·

                <v-chip color="orange" dense outlined style="margin-left: 5px">
                  #{{ book.ID }}
                </v-chip>
              </v-card-title>
              <v-card-subtitle style="display: flex">
                <div style="margin-right: 15px">Author: {{ book.author }}</div>

               
              </v-card-subtitle>
            </div>
          </v-col>
          <v-col cols="6" md="4">  
            <v-chip
                  v-for="categoria in book.categories"
                  :key="categoria.categoria_id"
                  color="blue"
                  dense
                  outlined
                  small
                  >{{ categoria.nicename }}</v-chip></v-col>
        </v-row>
      </v-card-text>
    </v-card>
  </div>
</template>

<script>
export default {
  props: ["collectionParams"],
  watch: {
    collectionParams: {
      handler() {
        this.books = null;
        this.getBooks();
      },
      deep: true,
    },
  },
  mounted() {
    this.getBooks();
  },
  data() {
    return {
      books: null,
      loading: false,
    };
  },

  methods: {
    getBooks() {
      this.loading=true
      this.$axios
        .get(
          `https://www.etnassoft.com/api/v1/get/?results_range=${this.collectionParams.page},${this.collectionParams.items}`
        )
        .then((response) => {
          this.books = response.data;
          this.loading=false

        });
    },
  },
};
</script>

<style>
</style>