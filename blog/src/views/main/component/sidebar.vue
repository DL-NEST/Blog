<template>
  <div class="sidebar">
    <div class="blog-theme">
      <div class="blog-head" style="  user-select: none;">
        <img src="../../../assets/head.jpg" alt="">
      </div>
      <h3 style="letter-spacing:0.2rem;">DL-Nest</h3>
      <div class="signature">
        <p>
          活得漂亮是种本能。
          <br>
          Living beautifully is instinctive.
        </p>
      </div>
      <div class="Blog-link">
        <blog-link/>
      </div>
    </div>
    <div class="footer">
      <div class="p"><span>© 2021 - 2022   DL-Nest</span></div>
      <div class="beiAn">备案信息：渝ICP</div>
    </div>
  </div>
</template>

<script lang="ts">
import {defineComponent} from 'vue';
import BlogLink from '@/components/BlogLink.vue'

export default defineComponent({
  components:{
    BlogLink
  },
  name: 'sidebar'
});
</script>

<style lang="scss" scoped>
.sidebar{
  position: relative;
  width: 100%;
  height: 100%;
  background-color: #ffffff;
  // 布局
  display: flex;
  flex-direction: column;
  // 阴影
  z-index: 99;
}
.sidebar{
  .blog-theme{
    position: relative;
    width: 100%;
    height: auto;
    // 布局
    display: flex;
    flex-direction: column;
    align-items: center;
    //定位
    margin-top: 26rem;
  }
  .Blog-link{
    margin-top: 0.5rem;
    position: relative;
    width: 100%;
    height: auto;
  }
  .footer{
    letter-spacing:0.1rem;
    position: absolute;
    bottom: 0.4rem;
    width: 100%;
    height: auto;
    font-size: 1.2rem;
    color: rgba(0,0,0,0.5);
  }
}
.blog-theme{
  .blog-head{
    width: 13.7rem;
    height: 13.7rem;
    border-radius: 50%;
    overflow: hidden;
    img{
      max-width: 100%;
      height: auto;
    }
  }
  h3{
    margin-top: 1.5rem;
    margin-bottom: 1rem;
    text-decoration: none;
    color: #464646;
    font-size: 3.2rem;
    font-weight: bold;
  }
  .signature{
    color: #565654;
    letter-spacing:0.2rem;
    p{
      margin: 0.1rem;
      line-height: 1.9rem;
      font-weight: 400;
      font-size: 1.5rem;
    }
  }
}

@media screen and (max-width: 1200px){
  .footer{
    display: none;
  }
  .blog-theme{
    margin-top: 0!important;
  }
}


</style>
