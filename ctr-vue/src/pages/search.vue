<template>
    <div>
        <NavHeader ></NavHeader>
        <div class="search">
            <div class="container">
                <div class="wrapper">
                    <div class="container">
                        <div class="list-box">
                            <div class="list" v-for="(arr,i) in searchList" v-bind:key="i">
                                <div class="item" v-for="(item,j) in arr" v-bind:key="j">
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
                            <el-pagination
                                    class="pagination"
                                    background
                                    layout="prev, pager, next"
                                    :pageSize="pageSize"
                                    :total="total"
                                    @current-change="handleChange"
                            >
                            </el-pagination>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <service-bar></service-bar>
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
        <nav-footer></nav-footer>
    </div>
</template>
<script>
    import NavHeader from "../components/NavHeader";
    import NavFooter from "../components/NavFooter";
    import ServiceBar from "../components/ServiceBar";
    import { Pagination } from 'element-ui';
    import Modal from "../components/Modal";
    export default {
        name: "search",
        components: {ServiceBar, NavFooter, NavHeader,Modal,
            [Pagination.name]:Pagination},
        data(){
           return{
               pageSize:8,
               pageNum:1,
               total:0,
               searchList:[],
               stringName:this.$route.query.stringName,
               showModal:false
           }
        },
        mounted(){
            this.getProductsByName();
        },
        methods: {
            getProductsByName(){
                    this.axios.get(`/product/${this.stringName}`,{
                        params:{
                            pageNum:this.pageNum
                        }
                    }).then((res)=>{
                        this.total = res.total;
                        this.searchList = [res.list.slice(0,4),res.list.slice(4,8)];

                })

            },
            handleChange(pageNum){
                this.pageNum = pageNum;
                this.getProductsByName();
            },
            goToDetail(id){
                this.$router.push(`/detail/${id}`);
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

        },
    }
</script>

<style scoped lang="scss">
    @import './../assets/scss/config.scss';
    @import './../assets/scss/mixin.scss';
    .search{
        background-color: #F5F5F5;
        .wrapper{
            display:flex;
            .list-box{
                .list{
                    display:flex;
                    align-items:center;
                    width: 1226px;

                    margin-bottom: 14px;
                    &:last-child{
                        margin-bottom: 0;
                    }
                    .item{
                        width: 260px;
                        height: 302px;
                        background-color: #ffffff;
                        text-align: center;
                        margin: 20px;
                        span{
                            display: inline-block;
                            width: 67px;
                            height: 24px;
                            line-height: 24px;
                            color: #F5F5F5;
                            &.new-pro{
                                background-color: #7ECF68;
                            }
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
        .pagination{
            text-align:right;
        }
        .el-pagination.is-background .el-pager li:not(.disabled).active{
            background-color: #4058db;
            color: #FFF;
        }



    }

</style>
