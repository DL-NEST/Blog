import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router';
import Home from '../views/Home.vue';

const routes: RouteRecordRaw[] = [
  {
    path: '/',
    redirect: '/search',
  },
  {
    path: '/search',
    name: 'search',
    component: () => import('../views/search/index.vue'),
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
