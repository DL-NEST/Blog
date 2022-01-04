<template>
  <div class="top-control">
    <div class="nav">
      <div class="line" ref="line"></div>
      <span ref="listSpan" v-for="({name,path},index) in topList"
         @click="goPage(path,index)"
         @mouseover="fix(index)"
         @mouseleave="fix(undefined)">
        {{name}}
      </span>
    </div>
    <div class="top-right">
      <div class="artifacts">
        <div class="return" v-show="this.$route.name==='show'" @click="backUp">
          <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><path fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="48" d="M328 112L184 256l144 144"/></svg></div>
        <div class="search">
          <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><path d="M464 428L339.92 303.9a160.48 160.48 0 0030.72-94.58C370.64 120.37 298.27 48 209.32 48S48 120.37 48 209.32s72.37 161.32 161.32 161.32a160.48 160.48 0 0094.58-30.72L428 464zM209.32 319.69a110.38 110.38 0 11110.37-110.37 110.5 110.5 0 01-110.37 110.37z"/></svg>
        </div>
      </div>
      <div class="right-head">
        <img src="../assets/head.jpg" alt="">
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import {defineComponent, ref, watch} from 'vue';
import {getNum, topList} from '@/router/router';

export default defineComponent({
  name: 'TopControl',
  setup(){
    const selection = ref<number>(0)
    return{
      topList,
      selection
    }
  },
  methods:{
    fix(num?:number){
      let line = this.$refs.line as HTMLDivElement
      let listSpan = this.$refs.listSpan as Array<HTMLDivElement>
      if(window.innerWidth>1200)
      {
        line.style.left = 3+((num||num==0?num:this.selection)*(2+listSpan[0].offsetWidth/10))+'rem';
      }else if (window.innerWidth<520)
      {
        line.style.left = 3+((num||num==0?num:this.selection)*(2+listSpan[0].offsetWidth/8))+'rem';
      }
      else {
        line.style.left = 3+((num||num==0?num:this.selection)*(2+listSpan[0].offsetWidth/9))+'rem';
      }
    },
    goPage(path?:string,num?:number){
      this.$router.push(path?path:'/main')
      this.selection = num?num:0
    },
    isPage(){
      this.selection = getNum(this.$route.name as string)
      this.fix(undefined)
    },
    backUp(){
      //后退
      history.back();
    }
  },
  mounted() {
    this.isPage();
  }
});
</script>

<style lang="scss" scoped>
.top-control{
  display: flex;
  justify-content: space-between;
  position: relative;
  height: 100%;
  width: 100%;
  .nav{
    position: relative;
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    padding: 1.8rem 0 1.8rem 3rem;
    user-select: none;
  }
  .top-right{
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    padding: 1.8rem 2rem;
    .right-head{
      width: 3.2rem;
      height: 3.2rem;
      overflow: hidden;
      border-radius: 50%;
      img{
        max-width: 100%;
        height: auto;
      }
    }
    .artifacts{
      display: flex;
      flex-direction: row;
      justify-content: center;
      align-items: center;
      height: 100%;
      width: auto;
      div{
        cursor: pointer;
        margin-right: 3rem;
        height: 100%;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        svg{
          width: 1.9rem;
          height: auto;
          fill: rgba(31, 31, 31,1);
          transition: fill 0.2s ease-in-out;
        }
      }
      div:hover{
        svg{
          fill: rgba(72, 134, 214,1);
        }
      }
    }
  }
}
.nav{
  span{
    margin-right: 2rem;
    text-decoration:none;
    // 字体
    font-size: 1.4rem;
    color: rgba(90,90,90,1);
    cursor: pointer;
  }
  span:hover{
    color: rgb(76, 141, 226);
  }
  .line{
    position: absolute;
    left: 3rem;   //+48px
    top: 5.9rem;
    background-color: #464646;
    width: 3rem;
    height: 0.2rem;
    transition: left 0.2s ease-in-out;
  }
}
@media screen and (max-width: 1200x){

}
</style>
