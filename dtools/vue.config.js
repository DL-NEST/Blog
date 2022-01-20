const path = require("path");

module.exports = {
    pluginOptions: {
        electronBuilder: {
            nodeIntegration: true,
            builderOptions: {
                asar: false,
                npmRebuild: false,
                nsis: {
                    oneClick: false, // 一键安装
                    perMachine: false, // 是否开启安装时权限限制（此电脑或当前用户）
                    allowElevation: true, // 允许请求提升。 如果为false，则用户必须使用提升的权限重新启动安装程序。
                    allowToChangeInstallationDirectory: true, // 允许修改安装目录
                    createDesktopShortcut: true, // 创建桌面图标
                    createStartMenuShortcut: true, // 创建开始菜单图标
                    shortcutName: "dTools", // 图标名称
                },
            },
            // preload: "src/preload.js",
            externals: ["robotjs"],
            nodeModulesPath: ["../../node_modules", "./node_modules", "../node_modules"], //这里是多个node_modules路径，按自己需要配置即可
        },
    },
    devServer: {
        proxy: {
            "/api": {
                target: "https://www.baidu.com/", // 后端接口地址
                changeOrigin: true, // 是否允许跨越
                secure: false,
                // ws: true,
                pathRewrite: {
                    "^/api": "",
                },
            },
        },
    },
    // 自定义默认路径
    chainWebpack: config => {
        config.resolve.alias
            .set("views", path.resolve(__dirname, "src/views"));
    },
};
