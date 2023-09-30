import { createStore } from 'vuex'

export default createStore({
  state: {
    userData: null, // Aquí almacenas los datos del usuario
    token: null, // Aquí almacenas el token
    //tienePerfil: false, // Inicialmente, establecido en falso
    profileData:null,
  },
  getters: {
    getUserData(state) {
          // eslint-disable-next-line no-debugger
          debugger;
      return state.userData;
    },
    getProfileData(state) {
      // eslint-disable-next-line no-debugger
      debugger;
      return state.profileData;
    },
    getToken(state) {
      return state.token;
    },
  },
  mutations: {
    setUserData(state, userData) {
      state.userData = userData;
    },
    setProfileData(state, profileData) {
      state.profileData = profileData;
    },
    setToken(state, token) {
      state.token = token;
    },
    clearUserData(state) {
      state.userData = null;
      state.token = null;
    },
  },
  actions: {
    globalUserData({ commit }, userData) {
      commit('setUserData', userData);
    },
    globalProfileData({ commit }, profileData) {
      commit('setProfileData', profileData);
    },
  },
  modules: {},
})

