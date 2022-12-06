const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  publicPath: '/rm/f1',
  configureWebpack: {
    devtool: 'source-map'
  }
})