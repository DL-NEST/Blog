<template>
  <div class="main-top">
    <transition name="sidebar"
                enter-active-class="animate__animated animate__slideInDown"
                leave-active-class="animate__animated animate__slideInDown">
      <top-control v-show="sidebar"/>
    </transition>
  </div>
  <div class="main">
    <div class="main-sidebar">
      <transition name="sidebar"
                        enter-active-class="animate__animated animate__fadeInLeft"
                        leave-active-class="animate__animated animate__fadeInLeft">
        <sidebar v-show="sidebar" />
      </transition>
    </div>
    <div class="main-content">
      <content />
    </div>
  </div>
</template>

<script lang="ts">
import {defineComponent, ref} from 'vue';
import sidebar from './component/sidebar.vue'
import content from './component/content.vue'
import TopControl from '@/components/TopControl.vue';

export default defineComponent({
  name: 'app-main',
  setup(){
    const sidebar = ref<boolean>(false)
    return{
      sidebar
    }
  },
  components:{ sidebar, content, TopControl },
  mounted() {
    this.sidebar=true
  }
});
</script>

<style lang="scss" scoped>
.main{
  position: absolute;
  width: 100%;
  height: 100%;
  //
  display: flex;
  flex-direction: row;
}
.main{
  .main-sidebar{
    position: relative;
    width: 29vw;
    height: 100%;
    border-right:1px solid rgba(0,0,0,0.1);
  }
  .main-content{
    position: relative;
    width: 71vw;
    height: 100%;
    padding-top: 6rem;
    padding-bottom: 1rem;
    box-sizing:border-box;
  }
}
.main-top{
  border-left:1px solid rgba(116, 116, 116, 0.2);
  border-bottom:1px solid rgba(116, 116, 116, 0.2);
  width: 71vw;
  height: 6rem;
  left: 29vw;
  top: 0;
  position: absolute;
  z-index: 150;
  background-color: white;
}

@media screen and (max-width: 1200px){
  .main{
    display: flex;
    flex-direction: column;
    position: relative;
    width: 100%;
    height: 100%;
    overflow-y: auto;
    overflow-x: hidden;
    flex-grow: 1;
  }
  .main{
    box-sizing:border-box;
    .main-sidebar{
      position: relative;
      width: 100%;
      margin-top: 1rem;
      margin-bottom: 1rem;
      height: auto;
      border-right:0;
    }
    .main-content{
      position: relative;
      width: 100%;
      height: auto;
      padding-top: 0!important;
    }
  }
  .main-top{
    left: 0!important;
    position: sticky;
    z-index: 150;
    width: 100%;
    height: 6rem;
  }
}


@media screen and (max-width: 520px) {

}
.main::-webkit-scrollbar {
  width: 0.8rem;
}
.main::-webkit-scrollbar-track {
  background: rgba(231, 231, 231, 0.5);
  border-radius: 2px;
  -webkit-border-radius: 2px;
}
// 滚动条的颜色
.main::-webkit-scrollbar-thumb {
  background: rgba(147, 147, 147, 0.5);
  -webkit-border-radius: 3px;
}
// 滚动条的选中的颜色
.main::-webkit-scrollbar-thumb:hover {
  background: rgba(147, 147, 147, 0.8);
}

.main::-webkit-scrollbar-corner {
  background: #545454;
}

</style>
