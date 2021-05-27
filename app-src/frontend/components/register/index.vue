<template>
  <v-form ref="form" v-model="valid" lazy-validation>
    <v-card elevation="0" class="mx-auto my-12" max-width="50%">
      <v-card-title>Register</v-card-title>
      <v-card-text>
        <v-text-field
          v-model="name"
          outlined
          :rules="[
            (v) => !!v || 'Name is required',
            (v) => v.length <= 10 || 'Name must be less than 10 characters',
          ]"
          label="Name"
          dense
          required
        />
        <v-text-field
          v-model="uname"
          outlined
          dense
          :rules="[(v) => !!v || 'User name is required']"
          label="User name"
          required
        />

        <v-text-field
          v-model="email"
          outlined
          dense
          :rules="[
            (v) => !!v || 'E-mail is required',
            (v) => /.+@.+/.test(v) || 'E-mail must be valid',
          ]"
          label="Email"
          required
        />
        <v-text-field
          v-model="password1"
          outlined
          dense
          label="Password"
          :type="showPassword1 ? 'text' : 'password'"
          :append-icon="showPassword1 ? 'mdi-eye' : 'mdi-eye-off'"
          @click:append="showPassword1 = !showPassword1"
          :rules="[
            (v) => !!v || 'Password is required',
            (v) => v.length <= 8 || 'Phone must be less than 8 characters',
          ]"
          required
        />
        <v-text-field
          v-model="password2"
          outlined
          dense
          label="Confirm password"
          :type="showPassword2 ? 'text' : 'password'"
          :append-icon="showPassword2 ? 'mdi-eye' : 'mdi-eye-off'"
          @click:append="showPassword2 = !showPassword2"
          :rules="password2Rules"
          required
        />
        <v-text-field
          v-model="phone"
          outlined
          dense
          :rules="[
            (v) => !!v || 'Phone is required',
            (v) => v.length <= 10 || 'Phone must be less than 10 characters',
            (v) => (v > 600000000 && v < 799999999) || 'No es un numero válido',
          ]"
          :counter="9"
          label="Phone"
          required
        />

        <div class="d-flex flex-row-reverse">
          <v-btn :disabled="!valid"
            class="mr-4" @click="submit" color="primary">Register</v-btn>
          <v-btn class="mr-4" @click="clear">Clear</v-btn>
        </div>
      </v-card-text>
    </v-card>
  </v-form>
</template>

<script>
export default {
  data: () => ({
    valid: true,
    name: "",
    uname: "",
    email: "",
    phone: "",
    password1: "",
    password2: "",
    showPassword1: false,
    showPassword2: false,
  }),
  computed: {
    password2Rules() {
      return [
        (v) => !!v || "Password is required",
        (v) => v.length <= 8 || "Phone must be less than 8 characters",
        (v) => v === this.password1 || "Not same",
      ];
    },
  },

  methods: {
    submit() {},
    clear() {
      this.name = "";
      this.email = "";
      this.uname = "";
      this.phone = "";
      this.password1 = "";
      this.password2 = "";
    },
  },
};
</script>

<style>
</style>