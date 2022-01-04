import {pageConst} from '@/interface/pageConst';

export const topList: pageConst[] = [
  {
    name: '首页',
    path: '/main',
    title: 'main',
  },
  {
    name: '归档',
    path: '/archive',
    title: 'archive',
  },
  {
    name: '标签',
    path: '/label',
    title: 'label',
  },
  {
    name: '关于',
    path: '/about',
    title: 'about',
  },  {
    name: '留言',
    path: '/message',
    title: 'message',
  },
  {
    name: '友链',
    path: '/links',
    title: 'links',
  },
];

export function getNum(title: string): any {
  let i = 0;
  topList.forEach((value, index) => {
    if (title === value.title) {
      i = index;
    }
  });
  return i;
}
