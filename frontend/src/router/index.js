import { createRouter, createWebHistory } from "vue-router";
import Tables from "@/views/Tables.vue";
import SignIn from "@/views/SignIn.vue";

const routes = [
  {
    path: "/",
    name: "/",
    redirect: "/tables",
  },

  {
    path: "/tables",
    name: "Tables",
    component: Tables,
  },

  {
    path: "/sign-in",
    name: "Sign In",
    component: SignIn,
  }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
  linkActiveClass: "active",
});

export default router;
