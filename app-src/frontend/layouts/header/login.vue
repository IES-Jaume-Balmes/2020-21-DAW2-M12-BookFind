
<template>
    <!-- <v-menu v-model="menu" open-on-hover offset-y> -->

  <v-menu
  
    offset-y
    :close-on-content-click="false"
    v-if="!$store.state.books.userType"
  >
    <template v-slot:activator="{ on, attrs }">
      <v-btn icon v-bind="attrs" v-on="on" x-large>
        <v-icon> mdi-account-circle</v-icon>
      </v-btn>
    </template>

    <v-list>
      <v-list-item
        ><v-form ref="form" v-model="valid" lazy-validation>
          <v-card elevation="0" class="mx-auto my-12" width="500">
            <v-card-text>
              <v-text-field
                v-model="email"
                label="Email"
                prepend-icon="mdi-account-circle"
                :rules="[
                  (v) => !!v || 'E-mail is required',
                  (v) => /.+@.+\..+/.test(v) || 'E-mail must be valid',
                ]"
              />
              <v-text-field
                v-model="password"
                label="Password"
                :type="showPassword ? 'text' : 'password'"
                prepend-icon="mdi-lock"
                :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
                @click:append="showPassword = !showPassword"
                :rules="[(v) => !!v || 'Campo obligatorio']"
              />
            </v-card-text>

            <v-card-actions class="d-flex flex-row-reverse">
              <v-btn
                color="primary"
                :disabled="!(email && password)"
                @click="submit()"
                >Login</v-btn
              >
              <v-btn class="mr-4" to="/register">Register</v-btn>
            </v-card-actions>
          </v-card>
        </v-form>
      </v-list-item>
    </v-list>
  </v-menu>
</template>


<script>
export default {
  data: () => ({
    showPassword: false,
    valid: true,
    email: null,
    password: null,
    users: [
      { email: "admin@findbook.com", password: "1234", type: "admin" },
      { email: "user@findbook.com", password: "1234", type: "user" },
    ],
  }),
  methods: {
    submit() {
      let u = {
        email: this.email,
        password: this.password,
      };

      this.users.forEach((user) => {
        if (user.email == u.email && user.password == u.password) {
          this.$store.commit("books/setUserType", user.type);
          this.$emit("update-user");

        }
      });
    },
  },
};
</script>