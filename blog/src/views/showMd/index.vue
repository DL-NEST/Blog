<template>
  <div class="showMd">
      <mavon-editor v-model="MdData"
                    :editable="false"
                    :toolbarsFlag="false"
                    :ishljs="true"
                    :subfield="false"
                    defaultOpen="preview"
                    :transition="true"
                    previewBackground="#ffffff"
      />
    <div class="showMd-pl">评论区</div>
    <mavon-editor v-model="PostData"
                  :ishljs="true"
                  defaultOpen="preview"
                  :transition="true"
                  previewBackground="#ffffff"
                  @save="saveMd"
    />
  </div>
</template>

<script lang="ts">
import {defineComponent, ref} from 'vue';
import * as cheerio from 'cheerio';

export default defineComponent({
  name: 'showMd',
  setup(){
    const MdData = ref<string>()
    const PostData = ref<string>()
    return{
      MdData,
      PostData
    }
  },
  methods:{
    saveMd(value:string ,render:string){
      console.log(value);
    }
  },
  mounted() {
    this.axios.get('/data/test.md',{
      timeout:800,
      params: { timestamp: new Date() }
    })
    .then(require=>{
      this.MdData = require.data
    })
    // this.axios.get('/data',{
    //   timeout:800,
    //   params: { timestamp: new Date() }
    // }).then(require=>{
    //   const $ = cheerio.load(require.data);
    //   console.log($('a'));
    // })

  }
});
</script>

<style lang="scss" scoped>
.showMd{
  width: auto;
  height: auto;
  padding: 5px;
}
.showMd{
  .showMd-pl{
    padding: 10px;
    width: 100%;
    display: flex;
    flex-direction: row;
    justify-content: flex-start;
    font-family: "Adobe 黑体 Std R";
    font-size: 1.5em;
    margin-top: 5px;
    margin-bottom: 5px;
  }
}
</style>
