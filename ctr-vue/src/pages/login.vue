<template>
    <div class="login">
        <div class="container">
            <a href="/#/index"><img src="/imgs/login-logo.png" alt="" /></a>
        </div>
        <div class="wrapper">
            <div class="container">
                <div class="login-form">
                    <h3>
                        <span class="checked">帐号登录</span><span class="sep-line">|</span
                    ><span>扫码登录</span>
                    </h3>
                    <div class="input">
                        <input type="text" placeholder="请输入帐号" v-model="username" />
                    </div>
                    <div class="input">
                        <input type="password" placeholder="请输入密码" v-model="password"/>
                    </div>
                    <div class="btn-box">
                        <a href="javascript:;" class="btn" @click="login">登录</a>
                    </div>
                    <div class="tips">
<!--                        <div class="sms" @click="register">手机短信登录/注册</div>-->
                         <div class="reg" @click="goToRegister">立即注册<span>|</span>忘记密码？</div>
                    </div>
                </div>
            </div>
        </div>
        <div class="footer">
            <p>家具商城</p>
            <p>基于Springboot + Vue.js家具商城</p>
        </div>
    </div>
</template>
<script>
    import { mapActions } from 'vuex';
    export default {
        name: "login",
        data(){
            return{
                username:'',
                password:'',
                userId:'',
            }
        },
        methods:{
            login(){
                let { username,password } = this;
                this.axios.post('/user/login',{
                    username,
                    password
                }).then((res)=>{
                    this.$cookie.set('userId',res.id,{expires:'Session'});
                    // this.$store.dispatch('saveUserName',res.username);
                    this.saveUserName(res.username);
                    this.$message.success("登录成功");
                    this.$router.push({
                        name:'index',
                        params:{
                            from:'login'
                        }
                    });
                })
            },
            ...mapActions(['saveUserName']),
            goToRegister(){
                this.$router.push('/register');
            }
        }
    };
</script>
<style lang="scss">
    .login {
        & > .container {
            height: 113px;
            img {
                width: auto;
                height: 100%;
            }
        }
        .wrapper {
            background: url("/imgs/login-bg.jpg") no-repeat center;
            .container {
                height: 576px;
                .login-form {
                    box-sizing: border-box;
                    padding-left: 31px;
                    padding-right: 31px;
                    width: 410px;
                    height: 510px;
                    background-color: #ffffff;
                    position: absolute;
                    bottom: 29px;
                    right: 0;
                    h3 {
                        line-height: 23px;
                        font-size: 24px;
                        text-align: center;
                        margin: 40px auto 49px;
                        .checked {
                            color: #e4393c;
                        }
                        .sep-line {
                            margin: 0 32px;
                        }
                    }
                    .input {
                        display: inline-block;
                        width: 348px;
                        height: 50px;
                        border: 1px solid #e5e5e5;
                        margin-bottom: 20px;
                        input {
                            width: 100%;
                            height: 100%;
                            border: none;
                            padding: 18px;
                        }
                    }
                    .btn {
                        width: 100%;
                        line-height: 50px;
                        margin-top: 5px;
                        font-size: 16px;
                    }
                    .tips {
                        margin-top: 14px;
                        display: flex;
                        justify-content: space-between;
                        font-size: 14px;
                        cursor: pointer;
                        .sms {
                            color: #ff6600;
                        }
                        .reg {
                            color: #999999;
                            span {
                                margin: 0 7px;
                            }
                        }
                    }
                }
            }
        }
        .footer {
            height: 100px;
            padding-top: 60px;
            color: #999999;
            font-size: 16px;
            text-align: center;
            .footer-link {
                a {
                    color: #999999;
                    display: inline-block;
                }
                span {
                    margin: 0 10px;
                }
            }
            .copyright {
                margin-top: 13px;
            }
        }
    }
</style>