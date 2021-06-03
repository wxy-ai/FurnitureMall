<template>
    <div class="index">
        <div class="container">
            <div class="swiper-box">
                <div class="nav-menu">
                    <ul class="menu-wrap">
                        <li class="menu-item">
                            <a href="javascript:;">卧室 家具</a>
                            <div class="children">
<!--                                <ul v-for="(item,i) in menuList" v-bind:key="i">-->
<!--                                    <li v-for="(sub,j) in item" v-bind:key="j">-->
<!--                                        <a v-bind:href="sub?'/product/' + sub.id:''">-->
<!--                                            <img v-bind:src="sub?sub.img: '/imgs/item-box-1.png'"  alt="">-->
<!--                                            {{sub?sub.name:'卧室家具'}}-->
<!--                                        </a>-->
<!--                                    </li>-->
<!--                                </ul>     -->
                                <ul v-for="(item,i) in menuList" v-bind:key="i">
                                    <li v-for="(sub,j) in item" v-bind:key="j">
                                        <a v-bind:href="'/product/' + sub.id">
                                            <img v-bind:src="sub.mainImage"  alt="">
                                            {{sub.name.slice(0,4)}}
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li class="menu-item">
                            <a href="javascript:;">客厅 家具</a>
                            <div class="children">
                                <ul v-for="(item,i) in menuList2" v-bind:key="i">
                                    <li v-for="(sub,j) in item" v-bind:key="j">
                                        <a v-bind:href="'/product/' + sub.id">
                                            <img v-bind:src="sub.mainImage"  alt="">
                                            {{sub.name.slice(0,4)}}
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li class="menu-item">
                            <a href="javascript:;">厨房 家具</a>
                            <div class="children">
                                <ul v-for="(item,i) in menuList3" v-bind:key="i">
                                    <li v-for="(sub,j) in item" v-bind:key="j">
                                        <a v-bind:href="'/product/' + sub.id">
                                            <img v-bind:src="sub.mainImage"  alt="">
                                            {{sub.name.slice(0,4)}}
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li class="menu-item">
                            <a href="javascript:;">餐厅 家具</a>
                            <div class="children">
                                <ul v-for="(item,i) in menuList4" v-bind:key="i">
                                    <li v-for="(sub,j) in item" v-bind:key="j">
                                        <a v-bind:href="'/product/' + sub.id">
                                            <img v-bind:src="sub.mainImage"  alt="">
                                            {{sub.name.slice(0,4)}}
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li class="menu-item">
                            <a href="javascript:;">古典 家具</a>
                            <div class="children">
                                <ul v-for="(item,i) in menuList5" v-bind:key="i">
                                    <li v-for="(sub,j) in item" v-bind:key="j">
                                        <a v-bind:href="'/product/' + sub.id">
                                            <img v-bind:src="sub.mainImage"  alt="">
                                            {{sub.name.slice(0,4)}}
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li class="menu-item">
                            <a href="javascript:;">现代 简约</a>
                            <div class="children">
                                <ul v-for="(item,i) in menuList6" v-bind:key="i">
                                    <li v-for="(sub,j) in item" v-bind:key="j">
                                        <a v-bind:href="'/product/' + sub.id">
                                            <img v-bind:src="sub.mainImage"  alt="">
                                            {{sub.name.slice(0,4)}}
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </li>

                    </ul>
                </div>
                <swiper v-bind:options = "swiperOption">
                    <swiper-slide v-for="(item,index) in slideList" v-bind:key="index">
                        <a v-bind:href="'/product/' + item.id"><img v-bind:src="item.mainImage" alt=""></a>
                    </swiper-slide>
                    <div class="swiper-pagination" slot="pagination"></div>
                    <div class="swiper-button-prev" slot="button-prev"></div>
                    <div class="swiper-button-next" slot="button-next"></div>
                </swiper>
            </div>
            <div class="ads-box">
                <a v-bind:href="'/product/'+item.id" v-for="(item,index) in adsList" v-bind:key="index">
                    <img v-lazy="item.mainImage" alt="">
                </a>
            </div>
<!--            <div class="banner">-->
<!--                <a href="/product/30">-->
<!--                    <img v-lazy="'/imgs/banner-1.png'" alt="">-->
<!--                </a>-->
<!--            </div>-->
        </div>
        <div class="product-box">
            <div class="container">
                <h2>卧室家具</h2>
                <div class="wrapper">
                    <div class="banner-left">
                        <a v-bind:href="'/product/'+item.id" v-for="(item,index) in bnrList" v-bind:key="index">
                            <img v-lazy="item.mainImage" alt="">
                        </a>
                    </div>
                    <div class="list-box">
                        <div class="list" v-for="(arr,i) in indexList" v-bind:key="i">
                            <div class="item" v-for="(item,j) in arr" v-bind:key="j">
<!--                                <span v-bind:class="{'new-pro':j%2==0}">新品</span>-->
                                <div class="item-img">
                                    <img v-bind:src="item.mainImage" alt="" @click="goToDetail(item.id)">
                                </div>
                                <div class="item-info">
                                    <h3>{{item.name}}</h3>
                                    <p>{{item.subtitle}}</p>
                                    <p class="price" @click="addCart(item.id)">{{item.price}}元</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <ServiceBar></ServiceBar>
        <modal title="提示"
               sureText="查看购物车"
               btnType="1"
               modalType="middle" v-bind:showModal="showModal"
               v-on:submit="goToCart"
               v-on:cancel="showModal=false"
        >
            <template v-slot:body>
                <p>商品添加成功!</p>
            </template>

        </modal>
    </div>
</template>

<script>

    import ServiceBar from "../components/ServiceBar"
    import { Swiper, SwiperSlide } from 'vue-awesome-swiper'
    import 'swiper/css/swiper.css'
    import Modal from "../components/Modal";
    export default {
        name: "index",
        components: {
            Modal,
            Swiper,
            SwiperSlide,
            ServiceBar},
        data(){
        return{
            swiperOption: {
                autoplay: true,
                loop: true,
                effect: 'cube',
                cubeEffect: {
                    slideShadows: true,
                    shadow: true,
                    shadowOffset: 100,
                    shadowScale: 0.6
                },
                pagination:{
                    el: '.swiper-pagination',
                    clickable: true
                },
                navigation: {
                    nextEl: '.swiper-button-next',
                    prevEl: '.swiper-button-prev'
                }

            },
            bnrList:[

            ],
            slideList: [
                // {
                //     id:'42',
                //     img:'/imgs/slider/slide-1.jpg'
                // },
                // {
                //     id:'45',
                //     img:'/imgs/slider/slide-2.jpg'
                // },
                // {
                //     id:'46',
                //     img:'/imgs/slider/slide-3.jpg'
                // },
                // {
                //     id:'',
                //     img:'/imgs/slider/slide-4.jpg'
                // },
                // {
                //     id:'',
                //     img:'/imgs/slider/slide-5.jpg'
                // }
            ],
            menuList: [

                //     {
                //         id:30,
                //         img:'/imgs/item-box-1.png',
                //         name:'床垫',
                //     },
                //     {
                //         id:31,
                //         img:'/imgs/item-box-2.png',
                //         name:'床垫',
                //     },
                //     {
                //         id:33,
                //         img:'/imgs/item-box-3.jpg',
                //         name:'床垫',
                //     },
                //     {
                //         id:34,
                //         img:'/imgs/item-box-4.jpg',
                //         name:'床垫',
                //     },
                // ],
                // [0,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,0]

            ],
            menuList2:[],
            menuList3:[],
            menuList4:[],
            menuList5:[],
            menuList6:[],
            adsList: [
                // {
                //     id:33,
                //     img:'/imgs/ads/ads-1.png',
                // },
                // {
                //     id:34,
                //     img:'/imgs/ads/ads-1.png',
                // },
                // {
                //     id:34,
                //     img:'/imgs/ads/ads-1.png',
                // },
                // {
                //     id:35,
                //     img:'/imgs/ads/ads-1.png',
                // },
            ],
            indexList: [],
            showModal:false
        }
        },
        mounted() {
            this.init();
            this.menu();
            this.menu2();
            this.menu3();
            this.menu4();
            this.menu5();
            this.menu6();
            this.slide();
            this.ads();
            this.bnr();
        },
        methods: {
            init(){
                this.axios.get('/products',{
                    params:{
                        categoryId:100001,
                        pageSize: 8,
                    }
                }).then((res)=>{
                    this.indexList = [res.list.slice(0,4),res.list.slice(4,8)];
                })
            },
            menu(){
                this.axios.get('/products',{
                    params:{
                        categoryId:100001,
                    }
                }).then((res)=>{
                    this.menuList = [res.list.slice(0,4),res.list.slice(4,8)];

                })
            },
            menu2(){
                this.axios.get('/products',{
                    params:{
                        categoryId:100002,
                    }
                }).then((res)=>{
                    this.menuList2 = [res.list.slice(0,4),res.list.slice(4,8)];

                })
            },
            menu3(){
                this.axios.get('/products',{
                    params:{
                        categoryId:100003,
                    }
                }).then((res)=>{
                    this.menuList3 = [res.list.slice(0,4),res.list.slice(4,8)];

                })
            },
            menu4(){
                this.axios.get('/products',{
                    params:{
                        categoryId:100004,
                    }
                }).then((res)=>{
                    this.menuList4 = [res.list.slice(0,4),res.list.slice(4,8)];

                })
            },
            menu5(){
                this.axios.get('/products',{
                    params:{
                        categoryId:100005,
                    }
                }).then((res)=>{
                    this.menuList5 = [res.list.slice(0,4),res.list.slice(4,8)];

                })
            },
            menu6(){
                this.axios.get('/products',{
                    params:{
                        categoryId:100006,
                    }
                }).then((res)=>{
                    this.menuList6 = [res.list.slice(0,4),res.list.slice(4,8)];

                })
            },
            slide(){
                this.axios.get('/products',{
                    params:{
                        categoryId:100007,
                    }
                }).then((res)=>{
                    this.slideList = res.list;

                })
            },
            ads(){
                this.axios.get('/products',{
                    params:{
                        categoryId:100008,
                    }
                }).then((res)=>{
                    this.adsList = res.list;

                })
            },
            bnr(){
                this.axios.get('/products',{
                    params:{
                        categoryId:100009,
                    }
                }).then((res)=>{
                    this.bnrList = res.list;

                })
            },
            addCart(id){
                this.axios.post('/carts',{
                    productId:id,
                    selected: true
                }).then((res)=>{
                    this.$store.dispatch('saveCartCount',res.cartTotalQuantity);
                    this.showModal=true
                }).catch(()=>{
                    this.showModal = true;
                })
            },
            goToCart(){
                this.$router.push('/cart');
            },
            goToDetail(id){
                this.$router.push(`/detail/${id}`);
            }
        }
    }
</script>

<style scoped lang="scss">
    @import "./../assets/scss/mixin";
    .index{
        .swiper-box{
            .nav-menu{
                position: absolute;
                width: 264px;
                height: 451px;
                z-index: 9;
                padding: 26px 0;
                background-color: #55585a7a;
                box-sizing: border-box;
                .menu-wrap{
                    .menu-item{
                        height: 50px;
                        line-height: 50px;
                        a{
                            display: block;
                            position: relative;
                            font-size: 16px;
                            color: #ffffff;
                            padding-left: 30px;
                            &:after{
                                position: absolute;
                                right: 30px;
                                top: 17.5px;
                                content: ' ';
                                @include bgImg(10px,15px,'/imgs/icon-arrow.png')
                        }
                        }
                        &:hover{
                            background-color: #666666;
                            .children{
                                display: block;
                            }
                        }
                        .children{
                            display: none;
                            width: 962px;
                            height: 451px;
                            background-color: #ffffff;
                            position: absolute;
                            top: 0;
                            left: 264px;
                            border: 1px solid #e5e5e5;
                            ul{
                                display: flex;
                                justify-content: space-between;
                                height: 75px;
                                li{
                                    height: 75px;
                                    line-height: 75px;
                                    flex: 1;
                                    padding-left: 23px;
                                }
                                a{
                                    color: #333333;
                                    font-size: 14px;
                                }
                                img{
                                    width: 45px;
                                    height: 35px;
                                    vertical-align: middle;
                                    margin-right: 15px;
                                }
                            }
                        }
                    }
                }
            }
            .swiper-container{
                height: 451px;
                .swiper-button-prev{
                    left: 274px;
                }
                img{
                    width: 100%;
                    height: 100%;
                }
            }
        }
    }
    .ads-box{
        @include flex();
        margin-top: 14px;
        margin-bottom: 31px;
        a{
            width: 220px;
            height: 220px;
        }
    }
    /*.banner{*/
    /*    margin-bottom: 50px;*/
    /*}*/
    .product-box{
        background-color: #F5F5F5;
        padding: 30px 0 50px;
        h2{
            font-size: 22px;
            height: 21px;
            line-height: 21px;
            color: #333333;
            margin-bottom: 20px;
        }
        .wrapper{
            display: flex;
            .banner-left{
                margin-right: 16px;
                img{
                    width: 224px;
                    height: 619px;
                }
            }
            .list-box{
                .list{
                    @include flex();
                    width: 986px;
                    margin-bottom: 14px;
                    &:last-child{
                        margin-bottom: 0;
                    }
                    .item{
                        width: 236px;
                        height: 302px;
                        background-color: #ffffff;
                        text-align: center;
                        span{
                            display: inline-block;
                            width: 67px;
                            height: 24px;
                            line-height: 24px;
                            color: #F5F5F5;
                            /*&.new-pro{*/
                            /*    background-color: #7ECF68;*/
                            /*}*/
                        }
                        .item-img{
                            img{
                                width: 100%;
                                height: 195px;
                                cursor:pointer;
                            }
                        }
                        .item-info{
                            h3{
                                font-size: 14px;
                                color: #333333;
                                line-height: 14px;
                                font-weight: bold;
                            }
                            p{
                                color: #999999;
                                line-height: 13px;
                                margin: 6px auto 13px;
                            }
                            .price{
                                color: #F20A0A;
                                font-size: 14px;
                                font-weight: bold;
                                cursor: pointer;
                                &:after{
                                    @include bgImg(22px,22px,'/imgs/icon-cart-hover.png');
                                    content: ' ';
                                    margin-left: 5px;

                                }
                            }

                        }
                    }
                }
            }
        }
    }

</style>