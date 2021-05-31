<template>
  <v-card elevation="0" class="mx-auto my-12">
    <v-card-title>{{ book.title }}</v-card-title>
    <v-card-subtitle>{{ book.price }}</v-card-subtitle>
    <v-card-text>
      {{ book.description }}
    </v-card-text>

    <v-card-actions class="d-flex flex-row-reverse">
      <v-btn
        icon
        @click="() => ++cantidad"
        :disabled="!$store.state.books.userType"
      >
        <v-icon> mdi-plus</v-icon>
      </v-btn>
      <v-chip disabled label outlined>{{ cantidad }}</v-chip>
      <v-btn
        icon
        @click="() => --cantidad"
        :disabled="cantidad == 1 || !$store.state.books.userType"
      >
        <v-icon>mdi-minus</v-icon>
      </v-btn>
    </v-card-actions>
    <v-card-actions class="d-flex flex-row-reverse">
      <v-btn
        color="primary"
        :disabled="!$store.state.books.userType"
        @click="add"
        >Add</v-btn
      >
      <v-btn class="mr-4" :disabled="!$store.state.books.userType" to="/pay">buy</v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
export default {
  props: ["book"],
  data: () => ({
    cantidad: 1,
  }),
  methods:{
    add(){
     
      this.$store.commit("books/setCarrito", {
        id: this.book.bookId,
        book: this.book,
        cantidad: this.cantidad,
      });
    }
  }
};
</script>