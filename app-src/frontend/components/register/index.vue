<template>
  <form>
    <v-card elevation="0" class="mx-auto my-12" max-width="50%">
      <v-card-title>Register</v-card-title>
      <v-card-text>
        <v-text-field
          v-model="name"
          outlined
          :rules="nameRules"
          label="Name"
          required
        />
        <v-text-field
          v-model="uname"
          outlined
          :rules="unameRules"
          label="User name"
          required
        />

        <v-text-field
          v-model="email"
          outlined
          :rules="emailRules"
          label="Email"
          required
        />
        <v-text-field
          v-model="password1"
          outlined
          label="Password"
          :type="showPassword1 ? 'text' : 'password'"
          :append-icon="showPassword1 ? 'mdi-eye' : 'mdi-eye-off'"
          @click:append="showPassword1 = !showPassword1"
          :rules="password1Rules"
          required
        />
        <v-text-field
          v-model="password2"
          outlined
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
          :rules="phoneRules"
          :counter="9"
          label="Phone"
          required
        />

         <div class="d-flex flex-row-reverse">
          <v-btn @click="submit" color="primary">Register</v-btn>
          <v-btn class="mr-4" @click="clear">Clear</v-btn>
        </div>

      
      </v-card-text>
    </v-card>
  </form>
</template>

<script>
export default {
  data: () => ({
    valid: false,
    name: "",
    nameRules: [
      (v) => !!v || "Name is required",
      (v) => v.length <= 10 || "Name must be less than 10 characters",
    ],
    uname: "",
    unameRules: [(v) => !!v || "User name is required"],
    email: "",
    emailRules: [
      (v) => !!v || "E-mail is required",
      (v) => /.+@.+/.test(v) || "E-mail must be valid",
    ],
    phone: "",
    phoneRules: [
      (v) => !!v || "Phone is required",
      (v) => v.length <= 10 || "Phone must be less than 10 characters",
      (v) => (v > 600000000 && v < 799999999) || "No es un numero válido",
    ],
    password1: "",
    password1Rules: [
      (v) => !!v || "Password is required",
      (v) => v.length <= 8 || "Phone must be less than 8 characters",
    ],
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
    submit() {
      // Aquí hay que hacer el push a la API y en el then volver al inicio
    },
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