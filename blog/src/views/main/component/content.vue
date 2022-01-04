<template>
  <div class="content">
      <router-view />
  </div>
</template>

<script lang="ts">
import {defineComponent} from 'vue';


export default defineComponent({
  components:{},
  name: 'content'
});
</script>

<style lang="scss" scoped>
.content{
  position: relative;
  width: 100%;
  height: 100%;
  overflow-y: auto;
}

// 滚动条
.content::-webkit-scrollbar {
  width: 0.8rem;
}
.content::-webkit-scrollbar-track {
  background: rgba(231, 231, 231, 0.5);
  border-radius: 2px;
  -webkit-border-radius: 2px;
}
// 滚动条的颜色
.content::-webkit-scrollbar-thumb {
  background: rgba(147, 147, 147, 0.5);
  -webkit-border-radius: 3px;
}
// 滚动条的选中的颜色
.content::-webkit-scrollbar-thumb:hover {
  background: rgba(147, 147, 147, 0.8);
}

.content::-webkit-scrollbar-corner {
  background: #545454;
}

@media screen and (max-width: 1200px) {
  .content{
    height: auto;
    overflow-y: inherit;
  }
}

</style>
