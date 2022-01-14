import { defineStore } from 'pinia';
const RfStore = defineStore('Rf', {
    state: () => ({
        count: 2,
        login: true,
    }),
    getters: {
        double: (state) => state.count * 2,
    },
    actions: {
        increment() {
            this.count++;
        },
    },
});
export { RfStore };
//# sourceMappingURL=RfStore.js.map