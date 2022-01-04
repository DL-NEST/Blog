/** axios封装全局请求
 * 1.封装拦截器,响应器,请求
 * 2.后台数据不需要cookie采用Token放置请求头
 * 3，后端数据标准{"code": 2000,"msg": "成功","data": {"test": "dd"}}
 */
import './http';
import axios from 'axios';
import registerInterceptor from './interceptor';

// 定义axios的实列
const instance = axios.create({
  // baseURL 默认的请求地址
  baseURL: '/api',
  headers: { 'Content-Type': 'application/json'}, // 定义数据头
  timeout: 100 * 1000, // 请求超时时间
});
// 注册拦截器
registerInterceptor(instance);

export default instance;
