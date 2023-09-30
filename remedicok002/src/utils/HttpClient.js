import axios from 'axios';
import config from "@/config/config";
import store from '@/store/index';


const HttpClient = {
  // Método para configurar el token en el encabezado
  setHeader() {
    return {
      'Authorization': store.getters.getToken,
    };
  },
  // Método para realizar una solicitud GET
  async get(subUrl) {
      const headers = this.setHeader();
      const url = `${config.apiBaseUrl}` + subUrl;
      const response = await axios.get(url, { headers });
      return response;
  },

  // Método para realizar una solicitud POST
  async post(subUrl, datos) {
      const headers = this.setHeader();
      const url = `${config.apiBaseUrl}` + subUrl;
      const response = await axios.post(url, datos, { headers });
      return response;
  },

  // Método para realizar una solicitud DELETE
  async hacerSolicitudDelete(subUrl) {
      const headers = this.setHeader();
      const url = `${config.apiBaseUrl}` + subUrl;
      const response = await axios.delete(url, { headers });
      return response;
  },

  // Método para realizar una solicitud PUT
  async hacerSolicitudPut(subUrl, datos) {
      const headers = this.setHeader();
      const url = `${config.apiBaseUrl}` + subUrl;
      const response = await axios.put(url, datos, { headers });
      return response;
  },
};

export default HttpClient;
