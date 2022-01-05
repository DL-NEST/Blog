import {app, BrowserWindow, Menu, Tray, shell, Notification} from 'electron';
import {sendNotification} from '@/electron';


function signTray(tray: Tray, win: BrowserWindow) {
  const contextMenu = Menu.buildFromTemplate([
    { label: '关于项目', type: 'normal' , click: () => {
        shell.openExternal('https://github.com/DL-NEST');
      }},
    { label: '检测更新', type: 'normal' , click: () => {
        sendNotification({title: '检测更新', message: '没有更新'});
      }},
    { label: 'Item2', type: 'separator' },
    { label: '重新加载', type: 'normal' , click: () => {
        win.reload();
        win.show();
      }},
    { label: '退出', type: 'normal' , click: () => {
        app.quit();
      }},
  ]);
  tray.setToolTip('dtools\n版本号：0.1.0\n作者：dl-nest');
  tray.setContextMenu(contextMenu);
  tray.on('click', () => {
      win.show();
  });
}

export {signTray};
