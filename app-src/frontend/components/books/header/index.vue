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
      <v-menu offset-y>
        <template v-slot:activator="{ on, attrs }">
          <v-btn icon v-bind="attrs" v-on="on" x-large>
            <v-icon> mdi-account-circle</v-icon>
          </v-btn>
        </template>

        <!-- <v-list>
          
          <v-list-item> -->
            <Login />
          <!-- </v-list-item>
        </v-list> -->
      </v-menu>
      <v-menu offset-y>
        <template v-slot:activator="{ on, attrs }">
          <v-btn icon v-bind="attrs" v-on="on" x-large>
            <v-icon> mdi-cart-outline</v-icon>
          </v-btn>
        </template>

        <v-list>
          <!-- <v-list-item v-for="(item, i) in carrito" :key="i">
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item> -->
        </v-list>
      </v-menu>
      <!-- <v-chip  outlined   large>
        8
      </v-chip> -->
    </v-col>
  </v-row>
</template>

<script>
import Login from "./login";
export default {
  components: { Login },
};
</script>

<style>
</style>