<template>
  <v-container>
    <v-btn @click="()=>{$router.push(books)}">Access</v-btn>
  </v-container>
</template>

<script>
export default {
  data(){
    return{
      books:{path:"books"}
    }
  },
 
};
</script>
