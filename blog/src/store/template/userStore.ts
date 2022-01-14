import { defineStore } from 'pinia';
import api from '@/request/api';

const userStore = defineStore('user', {
  state: () => ({
    login: false,
    loginTime: 0,
    img: null,
    imgValue: null,
  }),
  getters: {
  },
  actions: {
    postLogin(params?: object) {
      api.active.login(params).then((data) => {
        if (data === false) {
          this.loginTime += 1;
          return;
        }
        this.login = true;
      });
    },
    postCvv() {
      api.common.cvv().then((data) => {
        // @ts-ignore
        const {img, value} = data.data as any;
        this.img = img;
        this.imgValue = value;
      });
    },
  },
});

export {userStore};
