import {BrowserWindow, NotificationConstructorOptions} from 'electron';
const notifier = require('node-notifier');

// 通知栏
interface Notify {
  title: string;
  message: string;
}

// 发一个通知
function sendNotification(options: Notify) {
  notifier.notify({
    ...options,
    sound: false,
    icon: 'E:\\project\\Blog\\dtools\\public\\favicon.ico',
  });
  notifier.on('click', (notifierObjectL: any, option: any, event: any) => {

  });
}

export {sendNotification};
