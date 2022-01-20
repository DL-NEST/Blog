import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import {resolve} from 'path'

// https://vitejs.dev/config/
export default defineConfig({
  root:'./plugins',
  plugins: [vue()],
  build: {
    rollupOptions: {
      input: {
        pulgstore: resolve(__dirname, './pulgstore/index.html'),
        test: resolve(__dirname, './test/index.html')
      },
      output:{
        entryFileNames:(chunkInfo => {
          console.log(chunkInfo)
          return 'plug-[name].js'
        })
      }
    },
  }
})
