import {BrowserWindow, ipcMain} from 'electron';
import {winConfig} from '@/config';

function plugIn(win: BrowserWindow, plug: boolean) {
  ipcMain.on('plug', (event, args) => {
    if (plug) {
      win.setContentSize(winConfig.w, 55, true);
    } else {
      win.setContentSize(winConfig.w, 550, true);
    }
    plug = !plug;
  });
}

export { plugIn };

