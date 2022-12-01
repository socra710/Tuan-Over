import {createRouter, createWebHistory, RouteRecordRaw, useRouter} from "vue-router";

import Dashboard from "../views/Dashboard.vue";
import Linkfor from "../views/Linkfor.vue";
import Login from "../views/Login.vue";
import {getAuth} from "firebase/auth";
import firebase from "@/firebase";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    name: "Login",
    component: Login,
    meta: { layout: "empty" },
  },
  {
    path: "/dashboard",
    name: "Dashboard",
    component: Dashboard,
    meta: { requiresAuth: false },
    beforeEnter: (to, from) => {
      const auth = getAuth(firebase);
      const router = useRouter();
      auth.onAuthStateChanged(user => {
        if (user) {
          const { currentUser } = auth;
          console.log('Currently logged in user', currentUser);
        } else {
          return false;
        }
      });
    },
  },
  {
    path: "/linkfor",
    name: "Linkfor",
    component: Linkfor
  }
];


export default createRouter({
  history: createWebHistory(),
  routes,
});