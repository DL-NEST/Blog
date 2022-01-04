// 输出配置
import {User} from './http';
class Api {
  /* 公共模块 */
  public static common = {
    getUserAll: (() => {
      return User.get('/Rf/All');
    }),
    cvv() {
      return User.post('/user/cvv');
    },
  };
  /* 活动模块 */
  public static active = {
    login(params?: object) {
      return User.post('/user/login', params);
    },
  };
}

export default Api;
