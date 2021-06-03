import Vue from 'vue'
import App from './App.vue'
import axios from "axios";
import router from './router'
import VueLazyload from "vue-lazyload";
import VueCookie from "vue-cookie";
import store from './store'
import { Message} from "element-ui";
import 'element-ui/lib/theme-chalk/index.css';
Vue.use(VueLazyload,{
  loading:'/imgs/loading-svg/loading-bars.svg'
})
Vue.prototype.axios = axios
Vue.prototype.$message = Message
Vue.use(VueCookie);

// Vue.use(Button)
// Vue.use(Form)
// Vue.use(FormItem)
// Vue.use(Input)
// Vue.use(Container)
// Vue.use(Header)
// Vue.use(Aside)
// Vue.use(Main)
// Vue.use(Menu)
// Vue.use(Submenu)
// Vue.use(MenuItem)
// Vue.use(Breadcrumb)
// Vue.use(BreadcrumbItem)
// Vue.use(Card)
// Vue.use(Row)
// Vue.use(Col)
// Vue.use(Table)
// Vue.use(TableColumn)
// Vue.use(Switch)
// Vue.use(Tooltip)
// Vue.use(Pagination)
// Vue.use(Dialog)
// Vue.prototype.$confirm = MessageBox.confirm
Vue.config.productionTip = false
// 根据前端得跨域方式做调整
axios.defaults.baseURL = '/api';
axios.defaults.timeout = 10000;
axios.defaults.withCredentials = true;
// 接口错误拦截
axios.interceptors.response.use(function (response) {
  let res = response.data;
  let path = location.pathname;
  if(res.status === 0){
    return res.data;
  }else if (res.status === 10){
    if (path !== '/index' && path !== '/login'){
      window.location.href='/login';
    }
    // window.location.href='/login';
    return Promise.reject(res);
  }else {
    Message.warning(res.msg);
    // alert(res.msg);
    return Promise.reject(res);
  }

})

Vue.filter('dateFormat', function(originVal) {
  const dt = new Date(originVal)

  const y = dt.getFullYear()
  const m = (dt.getMonth() + 1 + '').padStart(2, '0')
  const d = (dt.getDate() + '').padStart(2, '0')

  const hh = (dt.getHours() + '').padStart(2, '0')
  const mm = (dt.getMinutes() + '').padStart(2, '0')
  const ss = (dt.getSeconds() + '').padStart(2, '0')

  return `${y}-${m}-${d} ${hh}:${mm}:${ss}`
})


new Vue({
  // 加载路由
  router,
  store,
  render: h => h(App),
}).$mount('#app')
