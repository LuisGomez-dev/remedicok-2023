<template>
  <a href="https://getbootstrap.com/docs/5.3/getting-started/introduction/">bootstrap items</a>
  <NavBar />
  <router-view/>
</template>

<script>
import NavBar from '../src/components/NavBar.vue'
export default {
  name: 'App',
  components: {
    NavBar
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
