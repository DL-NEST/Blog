<template>
  <div class="plugStore">
    <div class="fun">
      sh
    </div>
    <div class="fun-main"></div>
  </div>
</template>

<script lang="ts">
import {defineComponent} from 'vue';

export default defineComponent({
  name: 'plugStore'
});
</script>

<style lang="scss" scoped>
.plugStore{
  width: 100%;
  height: 100%;
  background-color: #9a9a9a;
  // 布局
  position: relative;
  display: flex;
  flex-direction: column;
  .fun{
    background-color: rosybrown;
    width: 100%;
    height: 48px;
  }
  .fun-main{
    background-color: #929292;
    width: 100%;
    flex-grow: 1;
  }
}
</style>
