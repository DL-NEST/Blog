'use strict';

import { app, protocol, BrowserWindow } from 'electron';
import { createProtocol } from 'vue-cli-plugin-electron-builder/lib';
import installExtension, { VUEJS3_DEVTOOLS } from 'electron-devtools-installer';
const isDevelopment = process.env.NODE_ENV !== 'production';

// 方案必须在应用程序准备好之前注册
protocol.registerSchemesAsPrivileged([
  { scheme: 'app', privileges: { secure: true, standard: true } },
]);

async function createWindow() {
  // Create the browser window.
  const win = new BrowserWindow({
    width: 800,
    height: 600,
    webPreferences: {
      nodeIntegration: true,
      contextIsolation: false,
    },
  });

  if (process.env.WEBPACK_DEV_SERVER_URL) {
    // Load the url of the dev server if in development mode
    await win.loadURL(process.env.WEBPACK_DEV_SERVER_URL as string);
    if (!process.env.IS_TEST) {
          // win.webContents.openDevTools(); // 是否在测试环境
       }
  } else {
    createProtocol('app');
    // 在未开发时加载index.html
    await win.loadURL('app://./index.html');
  }
}

// 当所有窗口都关闭时退出。
app.on('window-all-closed', () => {
  if (process.platform !== 'darwin') {
    app.quit();
  }
});

app.on('activate', () => {
  if (BrowserWindow.getAllWindows().length === 0) { createWindow(); }
});

// 这个方法将被调用时，电子已完成
// 初始化并准备创建浏览器窗口。
// 某些api只能在事件发生后使用。
app.on('ready', async () => {
    // try {
    //   await installExtension(VUEJS3_DEVTOOLS);
    // } catch (e) {
    //   console.error('Vue Devtools failed to install:', e.toString());
    // }
  // }
  await createWindow();
});

// 在开发模式下，在父进程请求时干净地退出。
if (isDevelopment) {
  if (process.platform === 'win32') {
    process.on('message', (data) => {
      if (data === 'graceful-exit') {
        app.quit();
      }
    });
  } else {
    process.on('SIGTERM', () => {
      app.quit();
    });
  }
}
