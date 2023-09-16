<template>
    <nav class="navbar navbar-expand-lg bg-body-tertiary custom-navbar">
    <div class="container-fluid">

        <!-- Contenido común para la barra de navegación -->
      <a class="navbar-brand" href="#">Remedic - ok</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <!-- Contenido condicional basado en si el usuario tiene perfil o no -->
      <div v-if="tienePerfil" class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <router-link  class="nav-link active" aria-current="page" to="/">Home</router-link> 
          </li>
          <li class="nav-item">
            <router-link  class="nav-link" to="/about">About</router-link>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                Link
            </a>
            <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="#">Action</a></li>
                <li><a class="dropdown-item" href="#">Another action</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="#">Something else here</a></li>
            </ul>
            </li>
          <li class="nav-item">
            <a class="nav-link" @click="cerrarSesion">Cerrar Sesión</a>
          </li>
        </ul>
      </div>
      <div v-else>
        <!-- Contenido para usuarios sin perfil (por ejemplo, un botón de inicio de sesión) -->
        <button class="btn btn-primary" @click="simularInicioDeSesion">Iniciar Sesión</button>
      </div>

    </div>
    </nav>
</template>
  
  <script>
  export default {
    name: 'NavBar',
    
    data() {
        return {
        tienePerfil: false, // Inicialmente, el usuario no tiene perfil
        };
    },
    methods: {
        simularInicioDeSesion() {
            // Lógica para simular el inicio de sesión
            // Cambia el valor de tienePerfil cuando el usuario inicia sesión
            this.tienePerfil = true; // Cambia esto según tu lógica real
        },
        cerrarSesion() {
            this.tienePerfil = false;
        },
        iniciarSesion() {
            // Lógica para iniciar sesión
        },
    },

  }
  </script>
  
  <style scoped>
    .custom-navbar {
    height: 40px; /* Cambia el valor según tus necesidades */
    }

    .navbar-toggler-icon {
    height: 2rem; /* Cambia el valor según tus necesidades */
    /* También puedes ajustar el ancho si lo deseas */
    /* width: 2rem; */
    }
  </style>
  