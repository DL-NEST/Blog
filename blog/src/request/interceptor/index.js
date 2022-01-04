import axios from 'axios';
axios.defaults.adapter = require('axios/lib/adapters/http');
/**
 * @realize 注册拦截器
 */
// 3，后端数据标准{"code": 2000,"msg": "成功","data": {"test": "dd"}}
export default function registerInterceptor(instance) {
    // 请求拦截器+装饰请求，添加token
    instance.interceptors.request.use((config) => {
        // 请求拦截器的
        if (config.url === '/user/login' || '/user/detection') {
            config.headers = { 'Content-Type': 'application/json' };
            return config;
        }
        config.headers = { 'Token': 'test', 'Content-Type': 'application/json' }; // 添加请求头的Token
        return config;
    }, (error) => Promise.reject(() => {
        // 请求错误
        window.$message?.error('请求失败'); // 弹出错误信息
    }));
    // 响应拦截器
    instance.interceptors.response.use((res) => {
        const { data } = res;
        if (data.code !== 2000) {
            window.$message?.error(data.code + '.' + data.msg); // 弹出错误信息
            return false;
        }
        return data;
    }, (err) => {
        // 服务器未响应错误
        return Promise.reject(err.response);
    });
    return instance;
}
//# sourceMappingURL=index.js.map