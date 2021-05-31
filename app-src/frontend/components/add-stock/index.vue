<template>
  <v-container fluid>
    <v-btn small outlined to="/"> home </v-btn>
    <v-form ref="form" v-model="valid" lazy-validation>
      <v-card
        elevation="0"
        class="mx-auto my-12"
        max-width="50%"
        v-if="authors"
      >
        <v-card-title>Stock</v-card-title>
        <v-card-text>
          <v-text-field
            v-model="isbn"
            outlined
            :rules="[
              (v) => !!v || 'ISBN is required',
              (v) => v.length <= 10 || 'ISBN must be less than 10 characters',
              (v) => v.length >= 10 || 'ISBN menos than 10 characters',
            ]"
            :counter="10"
            label="ISBN"
            required
            dense
          />
          <v-text-field
            v-model="title"
            outlined
            :rules="[(v) => !!v || 'Title name is required']"
            label="Title"
            required
            dense
          />
          <date-picker
            v-model="mdate"
            label="Publication Date"
            @change="(val) => (mdate = val)"
          />

          <v-autocomplete
            v-model="author"
            :rules="[(v) => !!v || 'Author is required']"
            item-text="name"
            item-value="id"
            :items="authors"
            outlined
            dense
            deletable-chips
            chips
            small-chips
            label="Author"
            required
          />

          <v-textarea
            v-model="description"
            dense
            fill
            outlined
            label="Description"
            :rules="[
              (v) => !!v || 'Description is required',
              (v) => v.trim().split(' ').length >= 10 || 'Min 10 words',
            ]"
            :counter="10"
            :counter-value="(v) => v.trim().split(' ').length"
          />

          <v-text-field
            v-model="price"
            :rules="[
              (v) => !!v || 'Price is required',
              (v) => v > 0 || 'Is not number',
            ]"
            outlined
            dense
            deletable-chips
            chips
            small-chips
            label="P.V.P"
            required
          />
          <v-file-input
            v-model="img"
            label="Img"
            :rules="[(v) => !!v || 'Image is required']"
            outlined
            dense
            chips
            small-chips
            deletable-chips
          />

          <div class="d-flex flex-row-reverse">
            <v-btn
              :disabled="!valid"
              color="primary"
              class="mr-4"
              @click="addStock"
            >
              Add
            </v-btn>
            <v-btn class="mr-4" @click="resetValidation">Clear</v-btn>
          </div>
        </v-card-text>
      </v-card>
    </v-form>
  </v-container>
</template>

<script>
import DatePicker from "@/components/universal/date-picker";

export default {
  components: {
    DatePicker,
  },
  mounted() {
    this.getAuthors();
    // this.$refs.form.validate();
  },
  watch: {
    valid(val) {
      // console.log("form", val);
    },
  },
  data: () => ({
    valid: true,
    // btnValid:true,
    img: [],
    isbn: "",
    title: "",
    mdate: "",
    author: "",
    description: "",
    price: "",
    authors: null,
  }),

  methods: {
    getAuthors() {
      //Aquí va la llamada a la api donde recuperamos los autores para montar el combox
      this.authors = [
        { id: 1, name: "Carlos Ruiz " },
        { id: 2, name: "JK Rowling" },
        { id: 3, name: "Lorca" },
        { id: 4, name: "Pio Baroja" },
      ];
    },
    addStock() {
      // Aquí hay que hacer el push a la API y en el then volver al inicio YA ESTA TODO OK
      console.log("OK");
    },
    resetValidation() {
      this.$refs.form.resetValidation();
    },
  },
};
</script>

<style>
</style>