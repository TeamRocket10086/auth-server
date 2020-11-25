<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Register</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
    <link rel="stylesheet" href="css/style.default.css" id="theme-stylesheet">
</head>
<body>
<div class="page login-page">
    <div class="container d-flex align-items-center">
        <div class="form-holder has-shadow">
            <div class="row">
                <!-- Logo & Information Panel-->
                <div class="col-lg-6">
                    <div class="info d-flex align-items-center">
                        <div class="content">
                            <div class="logo">
                                <h1>Welcome</h1>
                            </div>
                            <p>Register page</p>
                        </div>
                    </div>
                </div>
                <!-- Form Panel    -->
                <div class="col-lg-6 bg-white">
                    <div class="form d-flex align-items-center">
                        <div class="content">
                            <form method="post" action="/auth/register?redirect=${param.redirect}" class="form-validate" id="registerFrom">
                                <div class="form-group">
                                    <input id="register-username" class="input-material" type="text" name="username" placeholder="Username" >
                                    <div class="invalid-feedback">
                                        The user name must be between 2 and 10 digits
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input id="register-password" class="input-material" type="password" name="password" placeholder="Password"   >
                                    <div class="invalid-feedback">
                                        The password must be between 6 and 10 digits
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input id="register-passwords" class="input-material" type="re-password" name="re-password" placeholder="Re-password"   >
                                    <div class="invalid-feedback">
                                        Both passwords must be the same and between 6 and 10 digits
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input id="register-registerToken" class="input-material" type="registerToken" name="registerToken" placeholder="RegisterToken" >
                                    <div class="invalid-feedback">
                                        Invalid email format
                                    </div>
                                </div>

                                <div class="form-group">
                                    <button id="regbtn" type="submit" name="registerSubmit" class="btn btn-primary">Register</button>
                                </div>
                                <small>Already have account?</small><a href="login" class="signup">&nbsp;Login</a>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- JavaScript files-->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
    $(function(){
        /*错误class  form-control is-invalid
        正确class  form-control is-valid*/
        var flagName=false;
        var flagPas=false;
        var flagPass=false;
        // var flagEmail=false;
        // var flagPhone=false;
        /*验证用户名*/
        var name,passWord,passWords,email,phone;
        $("#register-username").change(function(){
            name=$("#register-username").val();
            if(name.length<2||name.length>10){
                $("#register-username").removeClass("form-control is-valid")
                $("#register-username").addClass("form-control is-invalid");
                flagName=false;
            }else{
                $("#register-username").removeClass("form-control is-invalid")
                $("#register-username").addClass("form-control is-valid");
                flagName=true;
            }
        })
        /*验证密码*/
        $("#register-password").change(function(){
            passWord=$("#register-password").val();
            if(passWord.length<6||passWord.length>18){
                $("#register-password").removeClass("form-control is-valid")
                $("#register-password").addClass("form-control is-invalid");
                flagPas=false;
            }else{
                $("#register-password").removeClass("form-control is-invalid")
                $("#register-password").addClass("form-control is-valid");
                flagPas=true;
            }
        })
        /*验证确认密码*/
        $("#register-passwords").change(function(){
            passWords=$("#register-passwords").val();
            if((passWord!=passWords)||(passWords.length<6||passWords.length>18)){
                $("#register-passwords").removeClass("form-control is-valid")
                $("#register-passwords").addClass("form-control is-invalid");
                flagPass=false;
            }else{
                $("#register-passwords").removeClass("form-control is-invalid")
                $("#register-passwords").addClass("form-control is-valid");
                flagPass=true;
            }
        })


        // var reg = /^\w+((.\w+)|(-\w+))@[A-Za-z0-9]+((.|-)[A-Za-z0-9]+).[A-Za-z0-9]+$/;
        // $("#register-email").change(function(){
        //     email=$("#register-email").val();
        //     if(!reg.test(email)){
        //         $("#register-email").removeClass("form-control is-valid")
        //         $("#register-email").addClass("form-control is-invalid");
        //         flagEmail=false;
        //     }else{
        //         $("#register-email").removeClass("form-control is-invalid")
        //         $("#register-email").addClass("form-control is-valid");
        //         flagPass=true;
        //     }
        // })
        //
        // $("#register-phone").change(function(){
        //     phone=$("#register-phone").val();
        //     if(phone.length!=10){
        //         $("#register-phone").removeClass("form-control is-valid")
        //         $("#register-phone").addClass("form-control is-invalid");
        //         flagEmail=false;
        //     }else{
        //         $("#register-phone").removeClass("form-control is-invalid")
        //         $("#register-phone").addClass("form-control is-valid");
        //         flagPass=true;
        //     }
        // })



        $("#regbtn").click(function(){
            if(flagName&&flagPas&&flagPass){
                localStorage.setItem("name",name);
                localStorage.setItem("passWord",passWord);
                location="login.html"
            }else{
                if(!flagName){
                    $("#register-username").addClass("form-control is-invalid");
                }
                if(!flagPas){
                    $("#register-password").addClass("form-control is-invalid");
                }
                if(!flagPass){
                    $("#register-passwords").addClass("form-control is-invalid");
                }
                // if(!flagEmail){
                //     $("#register-email").addClass("form-control is-invalid");
                // }
                // if(!flagPhone){
                //     $("#register-phone").addClass("form-control is-invalid");
                // }
            }
        })
    })
</script>
</body>
</html>