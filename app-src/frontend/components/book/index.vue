<template>
  <v-row>
    <v-col md="8">
      <Detalle />
    </v-col>
    <v-col md="4"> panel add </v-col>
    <v-col>
      <v-sheet class="mx-auto" v-if="libros">
        <v-slide-group
          v-model="model"
          class="pa-4"
          active-class="success"
          show-arrows
        >
          <v-slide-item v-for="libro in libros" :key="libro.bookId">
            <!-- v-slot="{ active, toggle }" -->
            <!-- :color="active ? undefined : 'grey lighten-1'" -->
            <v-card @click="foo(libro.bookId)" class="ma-4">
              <v-img
                src="https://picsum.photos/282/450"
                class="white--text align-end"
                gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
              >
                <v-card-title v-text="libro.title"></v-card-title>
                <!-- <v-card-subtitle>{{active}}</v-card-subtitle> -->
              </v-img>
            </v-card>
          </v-slide-item>
        </v-slide-group>
      </v-sheet>
    </v-col>
  </v-row>
</template>

<script>
import Detalle from "./detalle";
export default {
  components: { Detalle },
  mounted() {
    // this.getLibrosByCategoria();
    this.getLibros();
  },
  data: () => ({
    model: null,
    libros: null,
  }),
  methods: {
    foo(id) {
      console.info("ve", id);
    },
    getLibros() {
      // http://localhost:8080/books/price-asc
      this.$axios
        .get("https://www.etnassoft.com/api/v1/get/?category_id=212")
        .then((response) => {
        //   console.info("libros", response.data);
          this.libros = response.data;
        });
    },
    // getLibrosByCategoria() {
    //   this.$axios
    //     .get("https://www.etnassoft.com/api/v1/get/?category_id=212")
    //     .then((response) => {
    //     //   console.info("libros", response.data);
    //       this.libros = response.data;
    //     });
    // },
  },
};
</script>

