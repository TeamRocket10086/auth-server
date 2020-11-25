<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<html>--%>
<%--<head>--%>
<%--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">--%>
<%--    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>--%>
<%--    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>--%>
<%--    <title>Login</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<form method="POST" action="/auth/login?redirect=${param.redirect}">--%>
<%--    <div style="color: red">${error}</div>--%>
<%--    <div class="form-group">--%>
<%--        <label for="InputName">User Name</label>--%>
<%--        <input name="username" class="form-control" id="InputName" placeholder="Enter UserName">--%>
<%--    </div>--%>
<%--    <div class="form-group">--%>
<%--        <label for="InputPassword1">Password</label>--%>
<%--        <input name="password" type="password" class="form-control" id="InputPassword1" placeholder="Password">--%>
<%--    </div>--%>
<%--    <button type="submit" class="btn btn-primary">Sign In</button>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>


<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Login</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="robots" content="all,follow">
    <link rel="stylesheet" href="https://ajax.aspnetcdn.com/ajax/bootstrap/4.2.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.default.css" id="theme-stylesheet">
<%--    css/style.default.css--%>
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
                            <p></p>
                        </div>
                    </div>
                </div>
                <!-- Form Panel    -->
                <div class="col-lg-6 bg-white">
                    <div class="form d-flex align-items-center">
                        <div class="content">
                            <form method="post" action="/auth/login?redirect=${param.redirect}" class="form-validate" id="loginFrom">
                                <div style="color: red">${error}</div>
                                <div class="form-group">
                                    <input id="login-username" type="text" name="username" required data-msg="input username" placeholder="username" value="" class="input-material">
                                </div>
                                <div class="form-group">
                                    <input id="login-password" type="password" name="password" required data-msg="input passwode" placeholder="password" class="input-material">
                                </div>
                                <button id="login" type="submit" class="btn btn-primary">Login</button>
                                <div style="margin-top: -40px;">
                                    <!-- <input type="checkbox"  id="check1"/>&nbsp;<span>remember password</span>
                                    <input type="checkbox" id="check2"/>&nbsp;<span>auto login</span> -->
                                    <div class="custom-control custom-checkbox " style="float: right;">
                                        <input type="checkbox" class="custom-control-input" id="check2" >
                                        <label class="custom-control-label" for="check2">auto login</label>
                                    </div>
                                    <div class="custom-control custom-checkbox " style="float: right;">
                                        <input type="checkbox" class="custom-control-input" id="check1" >
                                        <label class="custom-control-label" for="check1">remember password&nbsp;&nbsp;</label>
                                    </div>
                                </div>
                            </form>
                            <br />
                            <small>Do not have an account?</small><a href="register" class="signup">&nbsp;Register</a>
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
<script src="vendor/jquery-validation/jquery.validate.min.js"></script>
<!-- Main File-->
<script src="js/front.js"></script>
<script>
    $(function(){
        var check1s=localStorage.getItem("check1");
        var check2s=localStorage.getItem("check2");
        var oldName=localStorage.getItem("userName");
        var oldPass=localStorage.getItem("passWord");
        if(check1s=="true"){
            $("#login-username").val(oldName);
            $("#login-password").val(oldPass);
            $("#check1").prop('checked',true);
        }else{
            $("#login-username").val('');
            $("#login-password").val('');
            $("#check1").prop('checked',false);
        }
        if(check2s=="true"){
            $("#check2").prop('checked',true);
            $("#loginFrom").submit();
            //location="https://www.baidu.com?userName="+oldName+"&passWord="+oldPass;
        }else{
            $("#check2").prop('checked',false);
        }
        /*if(localStorage.getItem("name")!=null){
            $("#login-username").val(localStorage.getItem("name"));
        }*/

        $("#login").click(function(){
            var userName=$("#login-username").val();
            var passWord=$("#login-password").val();
            localStorage.setItem("userName",userName)
            localStorage.setItem("passWord",passWord)
            var check1 = $("#check1").prop('checked');
            var check2 = $('#check2').prop('checked');
            localStorage.setItem("check1",check1);
            localStorage.setItem("check2",check2);
        })

        /*$("#check2").click(function(){
            var flag=$('#check2').prop('checked');
            if(flag){
                var userName=$("#login-username").val();
                var passWord=$("#login-password").val();
                $.ajax({
                    type:"post",
                    url:"http://localhost:8080/powers/pow/regUsers",
                    data:{"userName":userName,"passWord":passWord},
                    async:true,
                    success:function(res){
                        alert(res);
                    }
                });
            }
        })*/
    })
</script>
</body>
</html>