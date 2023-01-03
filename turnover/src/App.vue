<template>
  <component :is="layout">
    <router-view />
  </component>
</template>

<script lang="ts">
  import { defineComponent, computed } from "vue";
  import { useRouter } from "vue-router";
  import firebase from "@/firebase";
  import { getAuth } from "firebase/auth";

  const defaultLayout = "default";

  export default defineComponent({
    setup() {
      const { currentRoute } = useRouter();
      const auth = getAuth(firebase);

      const router = useRouter();
      let layout = null;
      // auth.onAuthStateChanged(user => {
      //   if (user) {
      //     const { currentUser } = auth;
      //     console.log('Currently logged in user', currentUser);
      //   } else {
      //     router.replace('/');
      //   }
      // });

      layout = computed(
        () => `${currentRoute.value.meta.layout || defaultLayout}-layout`
      );

      return {
        layout
      };
    },
  });
</script>
