export default {
    state: {
      tienePerfil: false, // Inicialmente, establecido en falso
    },
    getters: {
      getUserData(state) {
        // Obtiene la información del usuario desde tu almacenamiento global
        return state.tienePerfil;
      },
    },
    mutations: {
      clearUserData(state) {
        // Limpia la información del usuario y establece "tienePerfil" en falso
        state.tienePerfil = false;
      },
      setUserData(state, userData) {
        // Establece la información del usuario y "tienePerfil" en verdadero
        state.tienePerfil = !!userData;
      },
    },
  };
  
  