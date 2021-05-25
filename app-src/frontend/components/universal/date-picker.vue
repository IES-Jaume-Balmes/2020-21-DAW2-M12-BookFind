<template>
    <v-menu
      ref="menu"
      v-model="menu"
      :close-on-content-click="false"
      transition="scale-transition"
      offset-y
      max-width="290px"
      min-width="290px"
    >
      <template v-slot:activator="{ on, attrs }">
        <v-text-field
          autocomplete="off"
          outlined
          dense
          clearable
          v-model="dateFormatted"
          :label="label"
          hint="DD/MM/YYYY"
          persistent-hint
          v-bind="attrs"
          @blur="date = parseDate(dateFormatted)"
          v-on="on"
          prepend-inner-icon="mdi-calendar"
        ></v-text-field>

      

      </template>
      <v-date-picker
        :range="range"
        color="primary"
        :first-day-of-week="1"
        no-title
        :value="mdate"
        @input="updateDate"
      ></v-date-picker>
    </v-menu>
</template>

<script>
export default {
  model: {
    prop: "mdate",
    event: "change",
  },
  props: {
    label: {
      required: false,
      default: () => {
        return "Fecha de creación";
      },
    },
    mdate: String,
    range: {
      type: Boolean,
      default: () => {
        return false;
      },
    },
  },
  data() {
   
    return {
      date: null,//new Date().toISOString().substr(0, 10),
      dateFormatted: null, //this.formatDate(new Date().toISOString().substr(0, 10)),
      menu: false,
    };
  },
  mounted() {
    this.date = this.mdate;
  },
  watch: {
    mdate(val) {
      this.date = val;
    },
    date(val) {
      this.dateFormatted = this.formatDate(this.date);
    },
    dateFormatted(val) {
      if (val === null) {
        this.date = null;
        this.$emit("change", this.date);
      }
    },
  },

  methods: {
    updateDate(val) {
      this.date = val;
      this.menu = false;
      this.$emit("change", this.date);
    },
    formatDate(date) {
      if (!date) return null;
      const [year, month, day] = date.split("-");
      return `${day}/${month}/${year}`;
    },
    parseDate(date) {
      if (!date) return null;
      const [day, month, year] = date.split("/");
      return `${year}-${month.padStart(2, "0")}-${day.padStart(2, "0")}`;
    },
  },
};
</script>
