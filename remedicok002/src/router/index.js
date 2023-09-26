/*
import { createRouter, createWebHashHistory } from 'vue-router'
//import HomeView from '../views/HomeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: () => import( '../views/public/PublicView.vue')
    
  },
  {
    path: '/about',
    name: 'about',
    component: () => import( '../views/AboutView.vue')
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
*/
import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  { path: '/',      name: 'home',  component: () => import('../views/public/PublicView.vue')  },
  { path: '/login',      name: 'login',  component: () => import('../views/public/LoginView.vue')  },
  { path: '/admin/dashboard', name: 'adminDashBoard', component: () => import('../views/admin/AdmindbView.vue')  },
  { path: '/paciente/dashboard', name: 'pacienteDashBoard', component: () => import('../views/paciente/PacientedbView.vue')  },
  { path: '/base/dashboard', name: 'baseDashBoard', component: () => import('../views/base/BasedbView.vue')  },
  { path: '/veterinario/dashboard', name: 'veterinarioDashBoard', component: () => import('../views/veterinario/VeterinariodbView.vue')  },
  { path: '/about', name: 'about', component: () => import('../views/AboutView.vue')  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
