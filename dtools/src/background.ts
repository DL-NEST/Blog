'use strict';
import {app, protocol, BrowserWindow, Tray, Menu, Notification, ipcMain, shell, BrowserView, dialog } from 'electron';
import { createProtocol } from 'vue-cli-plugin-electron-builder/lib';
import installExtension, { VUEJS3_DEVTOOLS } from 'electron-devtools-installer';
const isDevelopment = process.env.NODE_ENV !== 'production';
import {createWatch, sendNotification, signTray} from './electron';
import {setIpc} from '@/electron/ipc';
// 导入用户的配置文件
import {winConfig} from './config';
import express from 'express';
const plugApp = express();

// 方案必须在应用程序准备好之前注册
protocol.registerSchemesAsPrivileged([
  { scheme: 'app', privileges: { secure: true, standard: true , supportFetchAPI: true} },
]);
// 主进程全局变量
let win: BrowserWindow;
let tray;
let view: BrowserView;
async function createWindow() {
  // 创建窗口
  win = new BrowserWindow({
    width: winConfig.w,
    height: 550,
    x: 650,
    y: 300,
    icon: 'E:\\project\\Blog\\dtools\\public\\favicon.ico',
    fullscreenable: false,  // 全屏
    skipTaskbar: true,     // 底栏不可见
    frame: false,   // 无边框
    resizable: false, // 窗口不可以调整大小
    autoHideMenuBar: true,
    alwaysOnTop: true,      // 测试模式永远在最上层
    webPreferences: {
      nodeIntegration: true,
      contextIsolation: false,
      enableRemoteModule: true, // 使用remote模块
    },
  });
  // view插件展示块
  view = new BrowserView();
  win.setBrowserView(view);
  view.setBounds({ x: 0, y: 55, width: winConfig.w, height: 495 });
  view.webContents.loadURL('http://localhost:3001/test/').then();
  win.setContentSize(winConfig.w, 55, true);
  // 隐藏插件区域
  // 注册全局快捷键
  createWatch(win);
  // 注册托盘
  app.whenReady().then(() => {
    app.setAppUserModelId(process.execPath);
    tray = new Tray('G:\\project\\Blog\\dtools\\public\\favicon.ico');
    signTray(tray, win);
  });
  // 注册ipc
  setIpc(win, view);
  // 屏蔽系统上下文菜单
  win.hookWindowMessage(0x116, (e) => {
    win.setEnabled(false);
    setTimeout(() => {
      win.setEnabled(true);
    }, 20);
  });
  win.once('ready-to-show', () => {
    // view.webContents.loadURL('https://www.qq.com/').then();
  });
  if (process.env.WEBPACK_DEV_SERVER_URL) {
    // Load the url of the dev server if in development mode
    await win.loadURL(process.env.WEBPACK_DEV_SERVER_URL as string);
    if (!process.env.IS_TEST) {
      // win.webContents.openDevTools(); // 是否在测试环境
    }
  } else {
    // 注册的协议
    createProtocol('app');
    // 在未开发时加载index.html
    await win.loadURL('app://./index.html/');
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
  // win.on('blur', () => {
  //   win.hide();
  // });

  win.on('system-context-menu', (event ) => {
    event.preventDefault();
  });
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
