import { createStore } from 'vuex'
import sessionModule from './session';


export default createStore({
  state: {
    //userData: null, // Aquí almacenarás los datos recuperados
    //profileData: null, // Aquí almacenarás los datos recuperados
  },
  getters: {
    getProfileData: (state) => state.profileData,
  },
  mutations: {
    setUserData(state, userData) {
      state.userData = userData;
    },

    setProfileData(state, profileData) {
      state.profileData = profileData;
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
  modules: {
    session: sessionModule,
  },
})

