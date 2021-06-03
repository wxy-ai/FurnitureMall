<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>

export default {
  name: 'App',
  components: {
  },
  data(){
    return {

    }
  },

  mounted() {
    if (this.$cookie.get('userId')){
      this.getUser();
      this.getCartCount();
    }
  },

  methods:{
    getUser(){
      this.axios.get('/user').then((res={})=>{
        this.$store.dispatch('saveUserName',res.username);
      })
    },
    getCartCount(){
      this.axios.get('/carts/products/sum').then((res=0)=>{
        this.$store.dispatch('saveCartCount',res);
      })
    }
  }
}
</script>

<style lang="scss">
  @import "./assets/scss/reset";
  @import "./assets/scss/config";
  @import "./assets/scss/button";
  @import "./assets/scss/base";
</style>
