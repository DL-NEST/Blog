import {app, BrowserWindow, globalShortcut} from 'electron';
import {readString, sendNotification} from '@/electron';
import {keyToggle} from 'robotjs';
const robot = require('robotjs');

function createWatch(win: BrowserWindow) {
  app.whenReady().then(() => {
    // 重新加载浏览器资源
    globalShortcut.register('Alt+q', () => {
      win.reload();
    });
    // 打开开发者调试工具
    globalShortcut.register('Alt+w', () => {
      win.webContents.openDevTools({ mode: 'undocked' });
    });
    globalShortcut.register('Alt+space', () => {
      if (win.isVisible()) {
        win.hide();
      } else {
        // robot.keyToggle('control', 'down');
        // robot.keyToggle('c', 'down');
        // robot.keyToggle('c', 'up');
        // robot.keyToggle('control', 'up');
        // console.log(readString());
        win.show();
        // sendNotification({title: '剪切板', message: });
      }
    });
  });
}

// 添加全局快捷键
function addShortcut(win: BrowserWindow, keyGroup: string) {
  app.whenReady().then(() => {
    // 重新加载浏览器资源
    globalShortcut.register(keyGroup, () => {
      win.reload();
    });
  });
}

export {createWatch, addShortcut};
