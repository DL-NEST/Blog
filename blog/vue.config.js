// vue.config.js
const path = require('path')

module.exports = {
    publicPath:'/',
    devServer: {
        proxy: {
            '/api': {
                target: 'http://localhost:8011/', // 后端接口地址
                changeOrigin: true, // 是否允许跨越
                secure: false,
                // ws: true,
                pathRewrite: {
                    '^/api': ''
                }
            },
            '/data': {
                target: 'http://localhost:8000/', // 后端接口地址
                changeOrigin: true, // 是否允许跨越
                secure: false,
                // ws: true,
                pathRewrite: {
                    '^/data': ''
                }
            }
        },
    },
    // 自定义默认路径
    chainWebpack: config => {
        config.resolve.alias
            .set('views', path.resolve(__dirname, 'src/views'));
    }
}
