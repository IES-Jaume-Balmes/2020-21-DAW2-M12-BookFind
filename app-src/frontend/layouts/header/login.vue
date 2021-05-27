
<template>
  <v-card elevation="0" class="mx-auto my-12" width="500">
    <!-- <v-card-title class="d-flex flex-row-reverse">Login</v-card-title> -->
    <v-card-text>
      <v-text-field label="Email" prepend-icon="mdi-account-circle" />
      <v-text-field
        label="Password"
        :type="showPassword ? 'text' : 'password'"
        prepend-icon="mdi-lock"
        :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
        @click:append="showPassword = !showPassword"
      />
    </v-card-text>

    <v-card-actions  class="d-flex flex-row-reverse">
          <v-btn color="primary">Login</v-btn>
          <v-btn class="mr-4" to="/register" >Register</v-btn> 
    </v-card-actions>
    <!-- @click=" () => { $router.push('/books'); } " -->
  </v-card>
</template>


<script>
export default {
  data() {
    return {
      showPassword: false,
    };
  },
};
</script>