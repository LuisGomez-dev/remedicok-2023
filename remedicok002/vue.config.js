const { defineConfig } = require('@vue/cli-service')


const path = require("path");

module.exports = {
  // Otras configuraciones de Vue CLI...
  transpileDependencies: true,

  configureWebpack: {
    resolve: {
      alias: {
        "@config": path.resolve(__dirname, "src/config"),
      },
    },
  },
};


/*
module.exports = {
  // Otras configuraciones de Vue CLI...
  transpileDependencies: true,

  configureWebpack: {
    resolve: {
      alias: {
        "@config": process.env.NODE_ENV === "production" ? "@/config.prod" : "@/config.dev",
      },
    },
  },
  
};
*/
/*
module.exports = defineConfig({
  transpileDependencies: true
})
*/