<template>
  <div class="hello">
    <h1>Weather by Campus Num'</h1>
    <router-link to="villes" >Voir les villes disponible</router-link>

    
  </div>
</template>

<script>
export default {
  name: 'Home',
  props: {
    
  },
  methods: {
    onListClick() {
      console.log('coucou')
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
