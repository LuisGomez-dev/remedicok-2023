<template>
    <nav class="navbar navbar-expand-lg bg-body-tertiary custom-navbar">
        <div class="container-fluid">

            <!-- Contenido común para la barra de navegación -->
          <a class="navbar-brand" href="#">Remedic - ok</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>

          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <router-link  class="nav-link active" aria-current="page" to="/admin/dashboard">Home</router-link> 
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
              <router-link  class="nav-link" to="/login">Inicio</router-link>
            </li>
          </ul>
        </div>
      
    </nav>

</template>
  
<script>

export default {
  name: 'NavBarNoPerfil',
};
</script>
  
