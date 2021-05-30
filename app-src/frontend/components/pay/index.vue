<template>
  <v-container fluid>
    <v-btn small outlined to="/"> home </v-btn>
    <v-card elevation="0" class="mx-auto my-12" max-width="90%">
      <v-card-title>PAY</v-card-title>
      <v-card-text>
        <v-list v-for="book in $store.state.books.carrito" :key="book.id">
          <v-list-item
            @click="
              () =>
                $router.push({
                  path:
                    $route.name == 'index'
                      ? `book/${book.id}`
                      : `/book/${book.id}`,
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
                x {{ book.cantidad }}
              </v-list-item-action-text>
              <v-list-item-action-text>
                {{ book.book.price }}
              </v-list-item-action-text>
            </v-list-item-action>
          </v-list-item>
        </v-list>
      </v-card-text>
      <v-card-actions class="d-flex flex-row-reverse">
        <v-chip label dense disabled outlined>{{ total }}</v-chip>
        Total:
      </v-card-actions>
      <v-card-actions class="d-flex flex-row-reverse">
        <v-btn color="primary" to="/pay">BUY</v-btn>
      </v-card-actions>
    </v-card>
  </v-container>
</template>

<script>
export default {
  mounted() {
    let total = 0;
    this.$store.state.books.carrito.forEach((b) => {
      total += b.book.price * b.cantidad;
    });
    this.total = total;
  },
  data: () => ({
    total: null,
  }),
};
</script>

<style>
</style>