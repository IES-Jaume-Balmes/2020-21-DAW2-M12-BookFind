<template>
  <div class="text-center">
    <v-menu v-model="menu" open-on-hover offset-y>
      <template v-slot:activator="{ on, attrs }">
        <v-btn icon v-bind="attrs" v-on="on" x-large>
          <v-icon> mdi-cart-outline</v-icon>
        </v-btn>
      </template>

      
        <v-card elevation="0" class="mx-auto my-12">
          <v-card-text>
            <v-list v-for="book in books" :key="book.id">
              <v-list-item
                @click="
                  () =>
                    $router.push({
                      path:
                        $route.name == 'index' ? `book/${book.id}` : `/book/${book.id}`,
                    })
                "
              >
                <v-list-item-avatar>
                  <v-avatar rounded size="56">
                    <img :src="book.book.image" />
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
          </v-card-text>
          <v-card-actions class="d-flex flex-row-reverse">
            <v-btn class="mr-4" color="primary" to="/pay">BUY</v-btn>
          </v-card-actions>
        </v-card>
    </v-menu>
  </div>
</template>

<script>
export default {
  watch: {
    menu(val) {
      this.books = this.$store.state.books.carrito;
    },
  },
  data: () => ({
    menu: false,
    books: null,
  }),
 
};
</script>

<style>
</style>