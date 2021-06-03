<template>
    <div class="login">
        <div class="container">
            <a href="/#/index"><img src="/imgs/login-logo.png" alt="" /></a>
        </div>
        <div class="wrapper">
            <div class="container">
                <div class="login-form">
                    <h3>
                        <span class="checked">邮箱注册</span><span class="sep-line">|</span
                    ><span>手机号码注册</span>
                    </h3>
                    <span class="ctr">账号:</span>
                    <div class="input" >
                        <input type="text" placeholder="请输入帐号" v-model="username" />
                    </div>
                    <span class="ctr">密码:</span>
                    <div class="input">
                        <input type="password" placeholder="请输入密码" v-model="password"/>
                    </div>
                    <span class="ctr">确定密码:</span>
                    <div class="input">
                        <input type="password" placeholder="确定密码" v-model="checkpassword" @blur="blur"/>
                    </div>
                    <span class="ctr">邮箱:</span>
                    <div class="input">
                        <input type="email" placeholder="请输入邮箱" v-model="email"/>
                    </div>
                    <div class="btn-box">
                        <a href="javascript:;" class="btn" @click="register">注册</a>
                    </div>
<!--                    <div class="tips">-->
<!--                        &lt;!&ndash;                        <div class="sms" @click="register">手机短信登录/注册</div>&ndash;&gt;-->
<!--                        <div class="reg">立即注册<span>|</span>忘记密码？</div>-->
<!--                    </div>-->
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
    export default {
        name: "register",

        data(){

            return{
                username:'',
                password:'',
                email:'',
                checkpassword:''

            }
        },
        methods:{
            register(){
                let { username,password,email } = this;
                this.axios.post('/user/register',{
                    username,
                    password,
                    email
                }).then(()=>{
                    this.$message.success("恭喜您注册成功");
                    this.$router.push('/login');
                })
            },
            blur(){
               if ( this.password !== this.checkpassword){
                   this.$message.warning("您输入的两次密码不相同");
                }
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
                    height: 530px;
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
                    .ctr{
                        font-size: 13px;
                        font-weight: bold;
                    }

                    .input {
                            display: flex;
                            width: 342px;
                            height: 50px;
                            border: 1px solid #e5e5e5;
                            margin-bottom: 20px;
                            margin-right: 0px;
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
                        margin-top: 10px;
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