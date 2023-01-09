<template>
  <component :is="layout">
    <router-view />
  </component>
</template>

<script lang="ts">
  import {defineComponent, computed, watch} from "vue";
  import {useRoute, useRouter} from "vue-router";
  import firebase from "@/firebase";
  import { getAuth } from "firebase/auth";
  import axios from "axios";
  import {userInfo} from "@/stores/UserInfo";

  const defaultLayout = "default";

  export default defineComponent({
    setup() {
      const { currentRoute } = useRouter();
      const auth = getAuth(firebase);
      const storeUserInfo = userInfo();

      const router = useRouter();
      const check = ()=> {
        axios.get('/api/account/check').then(({data}) => {
          if (data) {
            userInfo().setUserInfo({
              userId: data.email,
              userNm: data.name,
              userImg: data.image
            })
          } else {
            router.replace('/');
          }
        });
      }

      const route = useRoute();
      watch(route, () => {
        check();
      })

      let layout = null;
      layout = computed(
          () => `${currentRoute.value.meta.layout || defaultLayout}-layout`
      );

      return {
        layout
      };
    },
  });
</script>