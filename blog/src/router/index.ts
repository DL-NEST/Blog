import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router';
import {createRouterGuide} from './guards';
import type { App } from 'vue';

const routes: RouteRecordRaw[] = [
  {
    path: '/',
    redirect: '/main',
  },
  {
    path: '/main',
    name: 'main',
    component: () => import('views/main/index.vue'),
    children: [
      {
        path: '/main',
        redirect: '/page_main',
      },
      {
        path: '/page_main',
        name: 'page_main',
        component: () => import('views/main/page/page_main/index.vue'),
      },
      {
        path: '/archive',
        name: 'archive',
        component: () => import('views/main/page/archive/index.vue'),
      },
      {
        path: '/label',
        name: 'label',
        component: () => import('views/main/page/label/index.vue'),
      },
      {
        path: '/links',
        name: 'links',
        component: () => import('views/main/page/links/index.vue'),
      },
      {
        path: '/message',
        name: 'message',
        component: () => import('views/main/page/message/index.vue'),
      },
      {
        path: '/about',
        name: 'about',
        component: () => import('views/main/page/about/index.vue'),
      },
      {
        path: '/show',
        name: 'show',
        component: () => import('views/showMd/index.vue'),
      },
    ],
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('views/login/index.vue'),
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export async function setupRouter(app: App) {
  // 装载路由
  app.use(router);
  // 装载路由守卫
  createRouterGuide(router);
  // 等待装载结束
  await router.isReady();
}
