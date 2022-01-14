import { defineStore } from 'pinia';
import api from '@/request/api';
const userStore = defineStore('user', {
    state: () => ({
        count: 2,
        login: false,
        loginTime: 0,
        img: null,
        imgValue: null,
    }),
    getters: {
        double: (state) => state.count * 2,
    },
    actions: {
        increment() {
            this.count++;
        },
        postLogin(params) {
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
                const { img, value } = data.data;
                this.img = img;
                this.imgValue = value;
            });
        },
    },
});
export { userStore };
//# sourceMappingURL=userStore.js.map