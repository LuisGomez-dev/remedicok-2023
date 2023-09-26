<template>
    <div class="public">
      <div class="container text-center">
        <div class="row">
          <div class="col-md-6 offset-md-3">
            <div class="card">
              <div class="card-header">
                Acceso
              </div>
              <div class="card-body">
                <form @submit="login">
                  <div class="row mb-3">
                    <label for="inputEmail3" class="col-sm-2 col-form-label">Usuario</label>
                    <div class="col-sm-10">
                      <input type="email" class="form-control" id="inputEmail3" v-model="usuario">
                    </div>
                  </div>
                  <div class="row mb-3">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">Clave</label>
                    <div class="col-sm-10">
                      <input type="password" class="form-control" id="inputPassword3" v-model="contrasena">
                    </div>
                  </div>
                  <fieldset class="row mb-3"></fieldset>
                  <button type="submit" class="btn btn-primary">Login</button>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>

    import axios from "axios";
    import config from "@/config/config"

    export default {
      name: "LoginView",
      data() {
          return {
          usuario: "",
          contrasena: ""
          };
      },
      methods: {
        async login(event) {
          event.preventDefault();
          try {
              const userProfile = await this.getUserProfile();              
              // Actualiza los datos en el store global
              this.$store.dispatch('globalUserData', userProfile );
              this.redirectBasedOnProfile(userProfile);


          } catch (error) {
              console.error(error);
          }
        },

        async getUserProfile() {
          // Realiza una solicitud al servidor para obtener el perfil del usuario
          const response = await axios.post(`${config.apiBaseUrl}/login`, {
              usuario: this.usuario,
              contrasena: this.contrasena
              });

          console.log(response.data); // Puedes hacer algo con la respuesta
          return response.data; // Suponiendo que el servidor devuelve los datos del perfil del usuario
        },

        redirectBasedOnProfile(userProfile) {
          const userRoles = userProfile.usuario.perfiles.map((perfil) => perfil.nombre); // Lista de roles del usuario

          this.$store.dispatch('globalProfileData', userRoles );
          switch (true) {
            case userRoles.includes('ROLE_ADMIN'):
              // Redirigir al usuario a la ruta de administrador
              this.$router.push('/admin/dashboard');
              break;
            case userRoles.includes('ROLE_VETERINARIO'):
              // Redirigir al usuario a la ruta de veterinario
              this.$router.push('/veterinario/dashboard');
              break;
            case userRoles.includes('ROLE_PACIENTE'):
              // Redirigir al usuario a la ruta de paciente
              this.$router.push('/paciente/dashboard');
              break;
            default:
              // Redirigir a una ruta predeterminada para otros roles o manejarlo según sea necesario
              this.$router.push('/base/dashboard');
              break;
          }
        },
      }
    };


  /*
  import axios from "axios";
  import config from "@/config";

  export default {
    name: "LoginView",
    data() {
      return {
        usuario: "",
        contrasena: ""
      };
    },
    methods: {
      async login(event) {
        event.preventDefault();
        try {
        const response = await axios.post(`${config.apiBaseUrl}/login`, { // Accede a la configuración como config.apiBaseUrl
            usuario: this.usuario,
            contrasena: this.contrasena
          });
          // Maneja la respuesta del servidor aquí
          console.log(response.data); // Puedes hacer algo con la respuesta
        } catch (error) {
          // Maneja los errores aquí
          console.error(error);
        }
      }
    }
  };
  */
  </script>
  
