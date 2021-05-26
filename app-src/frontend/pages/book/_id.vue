<template>
  <Book :book_id="id"/>
</template>
<script>
import Book from "@/components/book";

export default {
  components: { Book },
  asyncData({ params }) {
    return {
      id: params.id,
    };
  },

  data() {
    return {};
  },
};
</script>