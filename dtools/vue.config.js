const path = require('path')

module.exports = {
    pluginOptions: {
        electronBuilder: {
            nodeIntegration: true,
            builderOptions:{
                asar: true,
                npmRebuild: false,
            },
            externals: ['node-notifier','robotjs'],
            nodeModulesPath: ['../../node_modules', './node_modules','../node_modules']//这里是多个node_modules路径，按自己需要配置即可
        },
    },
    devServer: {
        proxy: {
            '/api': {
                target: 'http://localhost:8080/', // 后端接口地址
                changeOrigin: true, // 是否允许跨越
                secure: false,
                // ws: true,
                pathRewrite: {
                    '^/api': ''
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
