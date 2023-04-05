// import { defineConfig } from "vite";
// import vue from "@vitejs/plugin-vue";
// const path = require("path");
//
// // https://vitejs.dev/config/
// export default defineConfig({
//   plugins: [vue()],
//   resolve: {
//     alias: {
//       "@": path.resolve(__dirname, "./src"),
//     },
//   },
//   build:{
//     outDir: "../src/main/resources/static"
//   },
//   server: {
//     proxy:{
//       "/api":"http://localhost:8080"
//     }
//   },
// });


const path = require("path");

module.exports = {


  outputDir : path.resolve('backend/public'),
  devServer: {
    proxy: {
      '/api': {
        target: 'http://localhost:3000/api',
        changeOrigin: true,
        pathRewrite: {
          '^/api': ''
        }
      }
    }
  }
}