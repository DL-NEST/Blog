import {plugIn} from './windows';
import {BrowserView, BrowserWindow} from 'electron';

function setIpc(win: BrowserWindow, view: BrowserView) {
  plugIn(win, view, false);
}

export {setIpc};
