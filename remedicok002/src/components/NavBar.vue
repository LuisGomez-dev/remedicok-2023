<template>
  <div v-if=!tienePerfil >
    <NavBarNoPerfil />
  </div>

  <div v-if="tienePerfil">
    <NavBarAdmin @cerrar-sesion="cerrarSesion" />
  </div>

</template>

<script>
import { mapGetters } from 'vuex';
import { mapMutations } from 'vuex';

import NavBarNoPerfil from '@/components/nav/NavBarNoPerfil.vue'
import NavBarAdmin from '@/components/nav/NavBarAdmin.vue'

export default {
  name: 'NavBar',
  
  components: {
    NavBarNoPerfil,
    NavBarAdmin
  },
  
  computed: {
    ...mapGetters(['getUserData']),
    tienePerfil() {
      return !!this.getUserData;
    }
  },
  
  methods: {
    ...mapMutations(['clearUserData']), // Importa la mutación

    cerrarSesion() {
      this.clearUserData();
      this.$router.push('/');
    },
  },
};
</script>
