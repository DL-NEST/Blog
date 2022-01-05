import {plugIn} from './windows';
import {BrowserWindow} from 'electron';

function setIpc(win: BrowserWindow) {
  plugIn(win, false);
}

export {setIpc};
