import { createRouter, createWebHistory } from 'vue-router';
const routes = [
    {
        path: '/',
        redirect: 'app-main',
    },
    {
        path: '/app-main',
        name: 'app-main',
        component: () => import('../views/search/index.vue'),
    },
];
const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes,
});
export default router;
//# sourceMappingURL=index.js.map