<template>
  <v-row class="mb-6" no-gutters>
    <v-col>
      <v-avatar color="grey" rounded>
        <span class="white--text headline">BF</span>
      </v-avatar>
    </v-col>
    <v-col :cols="6">
      <v-text-field
        solo
        label="Search"
        prepend-inner-icon="mdi-magnify"
      ></v-text-field>
    </v-col>
    <v-col class="d-flex flex-row-reverse">
      <v-menu
        offset-y
        v-model="menu"
        :close-on-content-click="false"
        v-if="!$store.state.books.userType"
      >
        <template v-slot:activator="{ on, attrs }">
          <v-btn icon v-bind="attrs" v-on="on" x-large>
            <v-icon> mdi-account-circle</v-icon>
          </v-btn>
        </template>

        <v-list>
          <v-list-item>
            <Login @update-user="$emit('update-user')" />
          </v-list-item>
        </v-list>
      </v-menu>

      <div v-if="$store.state.books.userType">

        <Carrito />
        <!-- <v-menu
          offset-y
          :close-on-content-click="false"
          v-if="$store.state.books.userType == 'user'"
        >
          <template v-slot:activator="{ on, attrs }">
            <v-btn icon v-bind="attrs" v-on="on" x-large>
              <v-icon> mdi-cart-outline</v-icon>
            </v-btn>
          </template>

          <v-list>
            <Carrito />
          </v-list>
        </v-menu> -->

        

        <v-btn
          icon
          x-large
          @click="() => $router.push({ path: 'add-stock/' })"
          v-if="$store.state.books.userType == 'admin'"
        >
          <v-icon>mdi-plus-circle-outline</v-icon>
        </v-btn>
        <v-btn icon x-large @click="logout()">
          <v-icon>mdi-logout</v-icon>
        </v-btn>
      </div>
    </v-col>
  </v-row>
</template>

<script>
import Login from "./login";
import Carrito from "./carrito";
export default {
  components: { Login, Carrito },
  data: () => ({
    menu: false,
  }),
  methods: {
    logout() {
      this.$store.commit("books/setUserType", null);
      this.$emit("update-user");
    },
  },
};
</script>

<style>
</style>