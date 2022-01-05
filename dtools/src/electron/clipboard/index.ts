// 剪切板
import {clipboard} from 'electron';


function readString() {
  return clipboard.readText();
}

export {readString};
