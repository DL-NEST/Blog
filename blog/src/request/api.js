// 输出配置
import { User } from './http';
class Api {
}
/* 公共模块 */
Api.common = {
    getUserAll: (() => {
        return User.get('/Rf/All');
    }),
    cvv() {
        return User.post('/user/cvv');
    },
};
/* 活动模块 */
Api.active = {
    login(params) {
        return User.post('/user/login', params);
    },
};
export default Api;
//# sourceMappingURL=api.js.map