<template>
  <!-- <div>

    <v-list v-for="book in $store.state.books.carrito" :key="book.id">
      <v-list-item>
        <v-list-item-avatar>
          <v-avatar rounded size="56">
            <img src="https://picsum.photos/295/295" />
          </v-avatar>
        </v-list-item-avatar>
        <v-list-item-content>
          <v-list-item-title>{{ book.book.title }} </v-list-item-title>
        </v-list-item-content>

        <v-list-item-action>
          <v-list-item-action-text>
            {{ book.cantidad }}
          </v-list-item-action-text>
        </v-list-item-action>
      </v-list-item>
    </v-list>
  </div> -->
  <div class="text-center">
    <v-menu open-on-hover offset-y>
      <template v-slot:activator="{ on, attrs }">
        <v-btn icon v-bind="attrs" v-on="on" x-large>
          <v-icon> mdi-cart-outline</v-icon>
        </v-btn>
      </template>

      <v-list>
        <!-- <v-list-item v-for="(item, index) in items" :key="index">
                <v-list-item-title>{{ item.title }}</v-list-item-title>
              </v-list-item> -->
      </v-list>
    </v-menu>
  </div>
</template>

<script>
export default {
  // props: ["carrito"],

  watch: {
    carrito: {
      handler(val) {
        console.log(val);
      },
      deep: true,
    },
  },

  mounted() {
    // console.log('siuuu');
    // console.log("carrito");
  },
};
</script>

<style>
</style>