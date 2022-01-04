<template>
  <div class="message"></div>
</template>

<script lang="ts">
import {defineComponent} from 'vue';

export default defineComponent({
  name: 'message'
});
</script>

<style lang="scss" scoped>
.message{
  position: absolute;
  width: 100%;
  height: 100%;
  background-color: #bbbbfc;
}
</style>
