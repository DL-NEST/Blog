import { ipcMain } from 'electron';
import { winConfig } from '@/config';
function plugIn(win, plug) {
    ipcMain.on('plug', (event, args) => {
        if (plug) {
            win.setContentSize(winConfig.w, 55, true);
        }
        else {
            win.setContentSize(winConfig.w, 550, true);
        }
        plug = !plug;
    });
}
export { plugIn };
//# sourceMappingURL=index.js.map