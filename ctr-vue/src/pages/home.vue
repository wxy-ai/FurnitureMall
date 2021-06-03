<template>
    <div>
        <nav-header></nav-header>
        <router-view/>
        <nav-footer></nav-footer>
    </div>
</template>

<script>
    import NavHeader from "../components/NavHeader";
    import NavFooter from "../components/NavFooter";
    export default {
        name: "Home",
        components: {NavFooter, NavHeader}
    }
</script>

<style scoped>

</style>