const notifier = require('node-notifier');
// 发一个通知
function sendNotification(options) {
    notifier.notify({
        ...options,
        sound: false,
        icon: 'E:\\project\\Blog\\dtools\\public\\favicon.ico',
    });
    notifier.on('click', (notifierObjectL, option, event) => {
    });
}
export { sendNotification };
//# sourceMappingURL=index.js.map