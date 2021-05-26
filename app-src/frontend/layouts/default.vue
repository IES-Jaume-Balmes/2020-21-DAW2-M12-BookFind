<template>
  <v-app dark>
    <!-- <v-container> -->
      <!-- <Header /> -->
    <!-- </v-container> -->
   
    <v-main>
      <v-container>
        <nuxt />
      </v-container>
    </v-main>
  
  </v-app>
</template>


<script>
import Header from "./header";

export default {
  components: { Header },
  data() {
    return {
      clipped: false,
      drawer: false,
      fixed: false,
      items: [
        {
          icon: "mdi-apps",
          title: "Welcome",
          to: "/",
        },
        {
          icon: "mdi-chart-bubble",
          title: "Libro",
          to: "/Book",
        },
        {
          icon: "mdi-chart-bubble",
          title: "Add",
          to: "/add-stock",
        },
        {
          icon: "mdi-chart-bubble",
          title: "Register",
          to: "/register",
        },
      ],
      miniVariant: false,
      right: true,
      rightDrawer: false,
      title: "Vuetify.js",
    };
  },
};
</script>
