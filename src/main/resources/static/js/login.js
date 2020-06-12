/*
登录
1. 获取用户名和密码，将数据封装到data中
2. ajax发送登录请求
3. 接收接口返回值，200-跳转到成功页；100-显示错误信息
 */

$("#btn-login").click(function () {
    // 1. 获取用户名和密码，将数据封装到data中
    let username = $("#login-username").val();
    let password = $("#login-password").val();

    let url = "/login";

    let data = {};
    data.username = username;
    data.password = password;

    // 2. ajax发送注册请求
    $.post(url, data, function (data) {
        // 登录成功
        if (data.code === 200) {
            window.location.href = '/success';
        } else {
            // 登录失败
            $("#login-error").css("display", "block").html(data.msg);
        }
    })

})


/*
注册
0. 给注册按钮绑定点击事件
1. 获取用户名和密码，将数据封装到data中
2. ajax发送登录请求
3. 接收接口返回值，200-跳转到登录页并显示注册成功/或弹出模态框，确认后跳转到登录页；100-显示错误信息
 */

// 0. 给注册按钮绑定点击事件
$("#btn-register").click(function () {
    // 1. 获取用户名和密码，将数据封装到data中
    let username = $("#register-username").val();
    let password = $("#register-passord").val();
    // 调试输出
    // console.log("username:" + username, "password:" + password);
    // alert("username:" + username + " password:" + password);

    let url = "/register";

    let data = {};
    data.username = username;
    data.password = password;

    // 2. ajax发送注册请求，接收数据
    $.post(url, data, function (data) {
        // 注册成功
        if (data.code === 200) {
            window.location.href = '/index';
        } else {
            // 注册失败
            $("#register-error").css("display", "block").html(data.msg);
        }
    })
})

// 切换标签页时，将提示框隐藏
$("a[role='tab']").click(function () {
    $("#login-error").css("display", "none")
    $("#register-error").css("display", "none")
})