<template>
 <div class="header">
         <div class="nav-topbar">
                 <div class="container">
                         <div class="topbar-menu">
                                 <a href="/index">家具商城</a>
                         </div>
                         <div class="topbar-user">
                                 <a href="javascript:;" v-if="username">{{username}}</a>
                                 <a href="javascript:;" v-if="!username" @click="login">登录</a>
                                 <a href="javascript:;" v-if="username" @click="logout">退出</a>
                                 <a href="/order/list" v-if="username">我的订单</a>
                                 <a href="javascript:;" class="my-cart" @click="goToCart"><span class="icon-cart"></span>购物车({{cartCount}})</a>
                         </div>
                 </div>
         </div>
         <div class="nav-header">
                 <div class="container">
                         <div class="header-logo">
                                 <a href="/index"></a>
                         </div>
                         <div class="header-menu">
                                 <div class="item-menu">
                                         <span>活动</span>
                                         <div class="children">
                                                 <ul>
                                                         <li class="product" v-for="(item,index) in furnitureList" :key="index">
                                                                 <a :href="'product/'+item.id" target="_blank">
                                                                         <div class="pro-img">
                                                                                 <img :src="item.mainImage" alt="">
                                                                         </div>
                                                                         <div class="pro-name">{{item.name}}</div>
                                                                         <div class="pro-price">{{item.price}}</div>
                                                                 </a>

                                                         </li>
                                                 </ul>
                                         </div>
                                 </div>

                         </div>
                         <div class="header-search">
                                 <div class="wrapper">
                                         <input type="text"  name="keyword" v-model="stringName" />
                                         <a href="javascript:;" class="btn" @click="goToSearch"></a>

                                 </div>
                         </div>
                 </div>
         </div>
 </div>
</template>

<script>
        import { mapState} from 'vuex'
        export default {
                name: "NavHeader",
                data(){
                        return{
                                furnitureList:[],
                                stringName:'',

                        }
                        },
                computed:{
                        ...mapState(['cartCount','username']),
                        /*username(){
                          return this.$store.state.username;
                        },
                        cartCount(){
                          return this.$store.state.cartCount;
                        }*/

                },
                filters:{
                        currency(val){
                                if (!val)return '0.00';
                                return '$' + val.toFixed(2) +'元'
                        }
                },
                mounted() {
                        this.getProductList();
                        let params = this.$route.params;
                        if (params && params.from === 'login'){
                                this.getCartCount();
                        }
                        },
                methods:{
                        login(){
                                this.$router.push('/login')
                        },
                        getProductList(){
                                this.axios.get('/products',{
                                        params: {

                                        }
                                }).then((res)=>{
                                        if (res.list.length>6){
                                                this.furnitureList = res.list.slice(0,6);
                                        }
                                })
                        },
                        getCartCount(){
                                this.axios.get('/carts/products/sum').then((res=0)=>{
                                        this.$store.dispatch('saveCartCount',res);
                                })
                        },
                        logout(){
                                this.axios.post('/user/logout').then(()=>{
                                        this.$message.success('退出成功');
                                        this.$cookie.set('userId','',{expires:'-1'});
                                        this.$store.dispatch('saveUserName','');
                                        this.$store.dispatch('saveCartCount','0');
                                })
                        },
                        goToCart(){
                                this.$router.push('/cart');
                        },

                        goToSearch(){

                                this.$router.push({
                                        path:'/productName',
                                        query:{
                                                stringName:this.stringName
                                        }
                                });
                                location.reload()
                        },
                }
    }
</script>

<style scoped lang="scss">
        @import "../assets/scss/base";
        @import "../assets/scss/mixin";
        @import "./../assets/scss/config.scss";
        .header{
                .nav-topbar{
                        height: 39px;
                        line-height: 39px;
                        background-color: #666666;
                        color: #B0B0B0;
                        .container{
                                @include flex();
                                a{
                                        display: inline-block;
                                        color: white;
                                        margin-right: 17px;
                                }
                                .my-cart{
                                        width: 110px;
                                        background-color: #F5F5F5;
                                        color: red;
                                        text-align: center;
                                        margin-right: 0;
                                        .icon-cart{
                                                @include bgImg(16px,12px,'/imgs/icon-cart-hover.png');
                                                /*display: inline-block;*/
                                                /*width: 16px;*/
                                                /*height: 12px;*/
                                                /*background: url('/imgs/icon-cart-hover.png') no-repeat center;*/
                                                /*background-size: contain;*/
                                                margin-right: 4px;
                                        }
                                }
                        }
                }
                .nav-header{
                    .container{
                            position: relative;
                            height: 112px;
                            @include flex();

                            .header-menu {
                                    display: inline-block;
                                    width: 643px;
                                    padding-left: 209px;
                                    flex: 1;
                                    .item-menu {
                                            display: inline-block;
                                            color: #333333;
                                            font-weight: bold;
                                            font-size: 16px;
                                            line-height: 112px;
                                            margin-right: 20px;
                                            span {
                                                    cursor: pointer;
                                            }
                                            &:hover {
                                                    color: $colorA;
                                                    .children {
                                                            height: 220px;
                                                            opacity: 1;
                                                            border-top: 1px solid #e5e5e5;
                                                    }
                                            }
                                            .children {
                                                    position: absolute;
                                                    top: 112px;
                                                    left: 0;
                                                    width: 1226px;
                                                    height: 0;
                                                    opacity: 0;
                                                    overflow: hidden;
                                                    box-shadow: 0px 7px 6px 0px rgba(0, 0, 0, 0.11);
                                                    z-index: 10;
                                                    transition: all 0.5s;
                                                    background-color: #ffffff;
                                                    .product {
                                                            position: relative;
                                                            float: left;
                                                            width: 16.6%;
                                                            height: 220px;
                                                            font-size: 12px;
                                                            line-height: 12px;
                                                            text-align: center;
                                                            a {
                                                                    display: inline-block;
                                                            }
                                                            img {
                                                                    width: auto;
                                                                    height: 111px;
                                                                    margin-top: 26px;
                                                            }
                                                            .pro-img {
                                                                    height: 137px;
                                                            }
                                                            .pro-name {
                                                                    font-weight: bold;
                                                                    margin-top: 19px;
                                                                    margin-bottom: 8px;
                                                                    color: $colorB;
                                                            }
                                                            .pro-price {
                                                                    color: $colorA;
                                                            }
                                                            &:before {
                                                                    content: " ";
                                                                    position: absolute;
                                                                    top: 28px;
                                                                    right: 0;
                                                                    border-left: 1px solid $colorF;
                                                                    height: 100px;
                                                                    width: 1px;
                                                            }
                                                            &:last-child:before {
                                                                    display: none;
                                                            }
                                                    }
                                            }
                                    }
                            }
                            .header-search{
                                        width: 319px;
                                        .wrapper{
                                                height: 50px;
                                                border: 1px solid #E0E0E0;
                                                display: flex;
                                                align-items: center;
                                                input{
                                                        border-right: 1px solid #E0E0E0;
                                                        width: 264px;
                                                        height: 50px;
                                                }
                                                a{
                                                        display: inline-block;
                                                        width: 18px;
                                                        height: 18px;
                                                        background:url('/imgs/icon-search.png') no-repeat center;
                                                        background-size: contain;
                                                }
                                        }
                                }


                        }
                }

        }
</style>
