
<template>
  <v-card width="500" class="mx-auto mt-9">
    <v-card-title>Login</v-card-title>
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

    <v-divider></v-divider>
    <v-card-actions>
      <v-btn color="success">Register</v-btn>
      <v-btn
        color="info"
        @click="
          () => {
            $router.push('/books');
          }
        "
        >Login</v-btn
      >
    </v-card-actions>
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