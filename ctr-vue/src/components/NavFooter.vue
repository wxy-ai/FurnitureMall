<template>
    <div class="footer">
        <div class="footer-logo">
            <img src="/imgs/logo.png" alt="">
            <p>家具商城</p>
            <p>基于Springboot + Vue.js家具商城</p>
        </div>
    </div>
</template>

<script>
    export default {
        name: "NavFooter"
    }
</script>

<style scoped lang="scss">
    .footer{
        height: 234px;
        border-top: 4px #FF6600;
        background-color: #333333;
        color: #999999;
        font-size: 16px;
        text-align: center;
        .footer-logo{
            margin-bottom: 331px;
            img {
                margin-top: 46px;
                width: 53px;
                height: 36px;
                margin-bottom: 13px;
            }
        }
    }
</style>