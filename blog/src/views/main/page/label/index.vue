<template>
  <div class="page-label"></div>
</template>

<script lang="ts">
import {defineComponent} from 'vue';

export default defineComponent({
  name: 'pageLabel'
});
</script>

<style lang="scss" scoped>
.page-label{
  position: absolute;
  width: 100%;
  height: 100%;
  background-color: #bbbbfc;
}
</style>
