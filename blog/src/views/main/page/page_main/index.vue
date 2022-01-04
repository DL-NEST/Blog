<template>
  <div class="page_main">
    <transition-group name="block"
                      enter-active-class="animate__animated animate__fadeInUpBig"
                      leave-active-class="animate__animated animate__fadeInUpBig">
    <div v-for="index in articleNum" class="block" :key="index">
      <div class="block-title">
        <h3 @click="showMd()">Qt学习笔记</h3>
      </div>
      <div class="block-content">
        <p>
          c++基础,qt的安装,qt6的新特性
        </p>
      </div>
      <div class="block-footer">
        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><rect fill="none" stroke="currentColor" stroke-linejoin="round" stroke-width="32" x="48" y="80" width="416" height="384" rx="48"/><circle cx="296" cy="232" r="24"/><circle cx="376" cy="232" r="24"/><circle cx="296" cy="312" r="24"/><circle cx="376" cy="312" r="24"/><circle cx="136" cy="312" r="24"/><circle cx="216" cy="312" r="24"/><circle cx="136" cy="392" r="24"/><circle cx="216" cy="392" r="24"/><circle cx="296" cy="392" r="24"/><path fill="none" stroke="currentColor" stroke-linejoin="round" stroke-width="32" stroke-linecap="round" d="M128 48v32M384 48v32"/><path fill="none" stroke="currentColor" stroke-linejoin="round" stroke-width="32" d="M464 160H48"/></svg>
        <p>
          2022-1-3
        </p>
        <svg xmlns="http://www.w3.org/2000/svg"  viewBox="0 0 512 512"><path d="M216.08 192v143.85a40.08 40.08 0 0080.15 0l.13-188.55a67.94 67.94 0 10-135.87 0v189.82a95.51 95.51 0 10191 0V159.74" fill="none" stroke="currentColor" stroke-linecap="round" stroke-miterlimit="10" stroke-width="32"/></svg>
        <p>C++</p>
      </div>
    </div>
    </transition-group>
  </div>
</template>

<script lang="ts">
import {defineComponent, ref} from 'vue';

export default defineComponent({
  name: 'page_main',
  setup(){
    const articleNum = ref<number>(0)

    return{
      articleNum
    }
  },
  methods:{
    showMd(){
      this.$router.push('/show')
      //this.articleNum += 1
    }
  },
  mounted() {
    for (let i =0;i<10;i++){
      setTimeout(()=>{
        this.articleNum += 1
      },i*200)
    }
  }
});
</script>

<style lang="scss" scoped>
.page_main{
  position: absolute;
  width: 100%;
  height: auto;
  padding: 0 30px 30px 30px;
  box-sizing:border-box;
}
.page_main{
  .block{
    position: relative;
    width: 100%;
    background-color: #ffffff;
    border-bottom:1px solid rgba(116, 116, 116, 0.2);
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    .block-title{
      letter-spacing:0.2rem;
      color: rgba(0,0,0,0.6);
      h3{
        font-size: 2.4rem;
        cursor: pointer;
        margin-bottom: 0;
        text-decoration:none;
        transition: text-decoration 1s ease-in-out;
      }
      h3:hover{
        text-decoration:underline
      }
    }
    .block-content{
      p{
        margin-left: 0.5rem;
        margin-bottom: 1rem;
        font-size: 1.4rem;
      }
    }
    .block-footer{
      margin-bottom: 2rem;
      display: flex;
      flex-direction: row;
      align-items: center;
      justify-content: center;
      svg{
        width: 1.6rem;
        height: auto;
      }
      p{
        letter-spacing:1px;
        margin-left: 1rem;
        margin-right: 1rem;
        font-size: 1.2rem;
        color: rgba(0,0,0,0.5);
      }
    }
  }
}

@media screen and (max-width: 600px){
  .page_main{
    .block{
      .block-title{
        h3{
          font-size: 3rem;
        }
      }
      .block-content{
        p{
          font-size: 2rem;
        }
      }
      .block-footer{
        svg{
          width: 2rem;
        }
        p{
          font-size: 1.4rem;
        }
      }
    }
  }
}


</style>
