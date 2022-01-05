<template>
  <div class="app-main">
    <div class="search">
      <input
          class="search-main"
          placeholder="Hallo,World!"
          ref="search"
          style="-webkit-app-region: drag;"
          @focus="drag(true)"
          @blur="drag(false)"
      />
      <div class="settings" @click="pull">
        <svg viewBox="0 0 1024 1024" xmlns="http://www.w3.org/2000/svg" width="200" height="200"><path d="M563.20625 545.3875l232.1875-142.7a51.25 51.25 0 0 0-53.6-87.2375L512.00625 456.6 282.61875 315.45a51.25 51.25 0 0 0-53.65 87.2375l231.8375 142.5875v273.925a51.25 51.25 0 1 0 102.4 0zM512.00625 0l443.3875 256v512L512.00625 1024 68.60625 768V256z m0 0" ></path></svg>
      </div>
    </div>
    <div class="center">
<!--      <div class="link-item" v-for="i in 10"></div>-->
      <plug-store/>
    </div>
  </div>
</template>

<script lang="ts">
import {defineComponent} from 'vue';
import {NInput} from 'naive-ui'
import PlugStore from '../plug/plugstore/index.vue'
const { ipcRenderer } = window.require("electron");

export default defineComponent({
  name: 'search',
  setup(){
  },
  components:{
    NInput,
    PlugStore
  },
  methods:{
    pull(){
      ipcRenderer.send('plug')
    },
    drag(bool:boolean){
      let search = this.$refs.search as HTMLElement
      if(bool){
        search.setAttribute('style','-webkit-app-region: drag;')
      }else {
        search.setAttribute('style','-webkit-app-region: no-drag;')
      }
    }
  },
  mounted() {
    let search = this.$refs.search as HTMLElement
    search.focus()
  }
});
</script>

<style lang="scss" scoped>
.app-main{
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
}
.center{
  width: 100%;
  flex-grow: 1;
  height: 0;
  display: flex;
  flex-direction: column;
  .link-item{
    position: relative;
    background-color: #42b983;
    width: 100%;
    height: 50px;
  }
}
.search{
  width: 100%;
  height: 56px;
  margin: 0;
  position: relative;
  box-sizing:border-box;
  display: flex;
  flex-direction: row;
  align-items: center;
  padding: 1rem;
  .search-main{
    cursor: default;
    position: relative;
    top: 0;
    flex-grow: 1;
    margin: 0;
    border: none;
    outline:medium;
    font-size: 2.3rem;
    vertical-align:top;
    box-sizing:border-box;
    text-align: left;
    height: 100%;
    font-family: "Adobe 黑体 Std R";
    padding-bottom: 0.2rem;
  }
  .settings{
    -webkit-app-region: no-drag;
    margin-left: 1rem;
    cursor: pointer;
    display: flex;
    justify-content: center;
    align-items: center;
    svg{
      width: 3.6rem;
      height: auto;
      fill: #000000;
    }
  }
}
</style>
