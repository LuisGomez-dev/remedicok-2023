<template>
  <div class="about">
    <h1>Administrtor dashboard {{ credencial.usuario.nombre }}</h1>
  </div>
</template>
<script>
// @ is an alias to /src
//import HelloWorld from '@/components/HelloWorld.vue'

import { mapGetters } from 'vuex';

export default {
  name: 'AdmindbView',

  computed: {
    ...mapGetters(['getUserData']),
    credencial() {
      // eslint-disable-next-line no-debugger
      debugger; // Esta línea activará el depurador, pero la regla está desactivada temporalmente
      return this.getUserData;
    },
  },

}
</script>