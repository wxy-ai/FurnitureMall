//封装路由
import Vue from 'vue'
import Router from 'vue-router'
import Home from '../pages/home'
import Index from '../pages/index'
import Product from '../pages/product'
import Detail from '../pages/detail'
import Cart from '../pages/cart'
import Order from '../pages/order'
import OrderList from '../pages/orderList'
import OrderConfirm from '../pages/orderConfirm'
import OrderPay from '../pages/orderPay'
import Login from "../pages/login";
import Register from "../pages/register";
import Search from "../pages/search"
Vue.use(Router);

export default new Router({

    mode: 'history',
    routes:[
        {
            path: '/',
            name: 'home',
            component: Home,
            redirect: '/index',

            children: [
                {
                    path: '/index',
                    name: 'index',
                    component: Index,
                },
                {
                    // 动态路由
                    path: '/product/:id',
                    name: 'product',
                    component: Product,
                },
                {
                    path: '/detail/:id',
                    name: 'detail',
                    component: Detail,
                } ,
            ]
        },
        {
            path: '/cart',
            name: 'cart',
            component: Cart
        },
        {
            path: '/productName',
            name: 'search',
            component: Search,

        },
        {
            path: '/register',
            name: 'register',
            component: Register
        },

        {
            path: '/login',
            name: 'login',
            component: Login
        },
        {
            path: '/order',
            name: 'order',
            component: Order,
            children: [
                {
                    path: 'list',
                    name: 'order-list',
                    component: OrderList
                },
                {
                    path: 'confirm',
                    name: 'order-confirm',
                    component: OrderConfirm
                },
                {
                    path: 'pay',
                    name: 'order-pay',
                    component: OrderPay
                }
            ]
        }


    ]
})

