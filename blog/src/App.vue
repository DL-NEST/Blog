<template>
  <router-view/>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
  mounted() {
    if (process.env.VUE_APP_URL_IS_TEXT){
      console.info('%c  _____ _____ ____ _____ \n' +
          ' |_   _| ____/ ___|_   _|\n' +
          '   | | |  _| \\___ \\ | |  \n' +
          '   | | | |___ ___) || |  \n' +
          '   |_| |_____|____/ |_|  \n' +
          '                         '+'开源网址:www.github.com/dl-nest', 'color:#c3b000')
    }else {
      console.info('%c开源网址:www.baidu.com', 'color:#c3b000')
    }
    // 判断移动端
    let flag = navigator.userAgent.match(/(phone|pad|pod|iPhone|iPod|ios|iPad|Android|Mobile|BlackBerry|IEMobile|MQQBrowser|JUC|Fennec|wOSBrowser|BrowserNG|WebOS|Symbian|Windows Phone)/i)
    if (flag){
      console.log('iPhone');
    }else {
      console.log('PC');
    }
  }
})

</script>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  box-sizing:border-box;
  position: relative;
  width: 100%;
  height: 100%;
}
@media screen and (max-width: 1200px){
  #app{
      display: flex;
      flex-direction: column;
  }
}
</style>
