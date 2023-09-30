<template>
  <div class="about">
    <h1>Administrtor dashboard </h1>
  </div>
</template>
<script>
import  HttpClient from '@/utils/HttpClient';

export default {
  name: 'AdmindbView',
  components(){
    HttpClient
  },
  created() {    
    this.realizarSolicitudGet();
  },
  methods: {
  async realizarSolicitudGet() {

      const apiUrl = '/personas';
      
      try {
        // Realiza la solicitud GET utilizando el servicio httpClient
        const respuesta = await HttpClient.get(apiUrl);
              // eslint-disable-next-line no-debugger
      debugger;
        this.respuesta = respuesta;
        console.log(respuesta);
      } catch (error) {
        console.error('Error en la solicitud GET:', error);
      }
    },
  }

}
</script>