<template>
  <form>
    <v-card elevation="0" class="mx-auto my-12" max-width="50%">
      <v-card-title>Stock</v-card-title>
      <v-card-text>
        <!-- :counter="10" -->
        <v-text-field
          v-model="name"
          outlined
          :error-messages="nameErrors"
          :counter="13"
          label="ISBN"
          required
          @input="$v.name.$touch()"
          @blur="$v.name.$touch()"
        ></v-text-field>
        <!-- <v-text-field
          v-model="name"
          outlined
          :error-messages="nameErrors"
          label="Title"
          required
          @input="$v.name.$touch()"
          @blur="$v.name.$touch()"
        ></v-text-field
        ><v-text-field
          v-model="name"
          outlined
          :error-messages="nameErrors"
          label="Author"
          required
          @input="$v.name.$touch()"
          @blur="$v.name.$touch()"
        ></v-text-field> -->
        <!-- <v-text-field
          v-model="email"
          :error-messages="emailErrors"
          label="E-mail"
          required
          @input="$v.email.$touch()"
          @blur="$v.email.$touch()"
        ></v-text-field>
        <v-select
          v-model="select"
          :items="items"
          :error-messages="selectErrors"
          label="Item"
          required
          @change="$v.select.$touch()"
          @blur="$v.select.$touch()"
        ></v-select>
        <v-checkbox
          v-model="checkbox"
          :error-messages="checkboxErrors"
          label="Do you agree?"
          required
          @change="$v.checkbox.$touch()"
          @blur="$v.checkbox.$touch()"
        ></v-checkbox> -->

        <v-btn class="mr-4" @click="submit"> submit </v-btn>
        <v-btn @click="clear"> clear </v-btn>
      </v-card-text>
    </v-card>
  </form>
</template>

<script>
import { validationMixin } from "vuelidate";
import {
  required,
  minLength,
  maxLength,
  email,
} from "vuelidate/lib/validators";

export default {
  mixins: [validationMixin],

  validations: {
    name: { required, minLength: minLength(13), maxLength: maxLength(13) },
    email: { required, email },
    select: { required },
    checkbox: {
      checked(val) {
        return val;
      },
    },
  },

  data: () => ({
    name: "",
    email: "",
    select: null,
    items: ["Item 1", "Item 2", "Item 3", "Item 4"],
    checkbox: false,
  }),

  computed: {
    // checkboxErrors() {
    //   const errors = [];
    //   if (!this.$v.checkbox.$dirty) return errors;
    //   !this.$v.checkbox.checked && errors.push("You must agree to continue!");
    //   return errors;
    // },
    // selectErrors() {
    //   const errors = [];
    //   if (!this.$v.select.$dirty) return errors;
    //   !this.$v.select.required && errors.push("Item is required");
    //   return errors;
    // },
    nameErrors() {
      const errors = [];
      if (!this.$v.name.$dirty) return errors;
      !this.$v.name.minLength && errors.push("Menos de 13");
      !this.$v.name.maxLength && errors.push("Mas de 13");
      !this.$v.name.required && errors.push("Name is required.");
      return errors;
    },
    // emailErrors() {
    //   const errors = [];
    //   if (!this.$v.email.$dirty) return errors;
    //   !this.$v.email.email && errors.push("Must be valid e-mail");
    //   !this.$v.email.required && errors.push("E-mail is required");
    //   return errors;
    // },
  },

  methods: {
    submit() {
      this.$v.$touch();
    },
    clear() {
      this.$v.$reset();
      this.name = "";
      this.email = "";
      this.select = null;
      this.checkbox = false;
    },
  },
};
</script>

<style>
</style>