import { createApp } from 'vue';
import App from './App.vue';
// @ts-ignore
import axios from 'axios';
import { createPinia } from 'pinia';
import {setupRouter} from '@/router';

// 导入md插件
import mavonEditor from 'mavon-editor';
import 'mavon-editor/dist/css/index.css';

import '@/style/index.scss';
import VueAxios from 'vue-axios';
// 引入animate
import 'animate.css';



// 创建实列
const app = createApp(App);

(function setupApp() {
  // axios
  app.use(VueAxios, axios);
  // 装载全局store/pinia
  app.use(createPinia());
  // 导入md插件
  app.use(mavonEditor);
  // 装载路由
  setupRouter(app).catch((error) => {
    console.log('路由初始化失败' + error);
  });
  // 挂载实列
  app.mount('#app');
})();

