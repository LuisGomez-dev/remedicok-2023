// config.js

const config = {
    apiBaseUrl: process.env.NODE_ENV === "production" ? "/api" : "http://localhost:8080/api",
    apiKey: "tu-clave-secreta",
    // Otras configuraciones globales aquí...
  };
  
  export default config;
  