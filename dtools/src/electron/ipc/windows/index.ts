import {BrowserWindow, ipcMain} from 'electron';

function plugIn(win: BrowserWindow, plug: boolean) {
  ipcMain.on('plug', (event, args) => {
    if (plug) {
      win.setContentSize(800, 55, true);
    } else {
      win.setContentSize(800, 550, true);
    }
    plug = !plug;
  });
}

export { plugIn };

