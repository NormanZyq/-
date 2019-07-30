<%--
  Created by IntelliJ IDEA.
  User: zyq
  Date: 2019-07-29
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%
    try {
        int testId = Integer.parseInt(request.getParameter("id"));

    } catch (NumberFormatException ex) {
        response.sendRedirect("/mypage");
    }



%>


<head>
    <meta charset="utf-8">
    <title></title>
    <!-- 新 Bootstrap4 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>

    <!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
    <script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>

    <!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>


    <script type="text/javascript">
        function check() {
            var bo = false;

            //var exs = $("radio");
            for (var i = 0; i < 3; i++) {
                var name = "optradio" + i;
                var exschild = $("input[name='" + name + "']");
                bo = false;
                //alert(exschild.length);

                for (var j = 0; j < exschild.length; j++) {
                    //alert("inner for"+$(exschild[j]).attr("type"));
                    //alert($(exschild[j]).prop("checked"));
                    if ($(exschild[j]).prop("checked") == true) {
                        bo = true;
                        continue;
                    }
                }
                if (bo == false) {
                    alert("第" + (i + 1) + "题没有做鸭 ヽ(。>д<)ｐ");
                }
            }

            if (bo == true) {
                alert("提交成功惹d(´ω｀*)")
                window.history.back()
            } else {
                alert("提交失败惹(◍´꒳`◍)")
            }
        }
    </script>



    <script type="text/javascript">
        var time_now_server, time_now_client, time_end, time_server_client;

        //考试结束时间
        time_end = new Date("2019/11/11 00:00:0"); //结束的时间
        time_end = time_end.getTime(); //获取的是毫秒

        time_now_server = new Date(); //开始的时间
        time_now_server = time_now_server.getTime();
        setTimeout("show_time()", 1000);

        function show_time() {
            var timer = document.getElementById("timer");
            var hourid = document.getElementById("hour");
            if (!timer) {
                return;
            }
            timer.innerHTML = time_now_server;

            var time_now, time_distance, str_time;
            var int_day, int_hour, int_minute, int_second;
            var time_now = new Date();
            time_now = time_now.getTime();
            time_distance = time_end - time_now;
            if (time_distance > 0) {
                int_day = Math.floor(time_distance / 86400000)
                time_distance -= int_day * 86400000;
                int_hour = Math.floor(time_distance / 3600000)
                time_distance -= int_hour * 3600000;
                int_minute = Math.floor(time_distance / 60000)
                time_distance -= int_minute * 60000;
                int_second = Math.floor(time_distance / 1000)

                if (int_hour < 10)
                    int_hour = "0" + int_hour;
                if (int_minute < 10)
                    int_minute = "0" + int_minute;
                if (int_second < 10)
                    int_second = "0" + int_second;
                str_time = int_day + "天   " + int_hour + "小时   " + int_minute + "分钟   " + int_second + "秒";
                timer.innerHTML = str_time;
                setTimeout("show_time()", 1000);
            } else {
                timer.innerHTML = 0;
            }
        }
    </script>

</head>
<body class="text-center" onLoad="timeCounter('timeCounter')">

<div class="container">

    <nav class="navbar navbar-expand-sm bg-light navbar-light fixed-top shadow shadow-sm">
        <ul class="navbar-nav">
            <li class="nav-item">
                <img src="rua.jpg" class=" img-thumbnail  m-auto" height="100" width="100" />
            </li>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <li class="nav-item">
                <p class="text-primary display-4 m-auto">[谁来起个名字(￣∇￣)]</p>
            </li>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <form class="form-inline mx-auto">
                <font color="coral" size="5px">
                    <b>
                        <div id="timer"></div>
                    </b>
                </font>
            </form>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <form class="form-inline col-md-1 offset-md-11 m-auto">
                <button class="btn btn-lg btn-outline-primary " type="button" onclick="window.history.back()">EXIT</button>
            </form>
        </ul>
    </nav>
</div>




<br /><br />

<h4>这是一张试卷</h4>

<div class="row">
    <div class="col-md-3 offset-md-3"></div>
    <div class="col-md-3 offset-md-2 ">

        <font color="coral" size="5px">
            <div id="timer"></div>
        </font>
    </div>

</div>

<br /><br /><br /><br />

<div class="container" id="exer">
    <div class="card w-75 mx-auto shadow shadow-sm">
        <div class="card-header">第一题</div>
        <div class="card-body">
            题目内容<br /><br />A<br /><br />B<br /><br />C<br /><br />D<br /><br />
        </div>
        <div class="card-footer">
            <label><input type="radio" name="optradio0" id="ex">
                &nbsp;&nbsp;A&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <label><input type="radio" name="optradio0" id="ex">
                &nbsp;&nbsp;B&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <label><input type="radio" name="optradio0" id="ex">
                &nbsp;&nbsp;C&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <label><input type="radio" name="optradio0" id="ex">
                &nbsp;&nbsp;D&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
        </div>
    </div>
    <br />
    <div class="card w-75 mx-auto shadow shadow-sm">
        <div class="card-header">第二题</div>
        <div class="card-body">
            题目内容<br /><br />A<br /><br />B<br /><br />C<br /><br />D<br /><br />
        </div>
        <div class="card-footer">
            <label><input type="radio" name="optradio1" id="ex">
                &nbsp;&nbsp;A&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <label><input type="radio" name="optradio1" id="ex">
                &nbsp;&nbsp;B&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <label><input type="radio" name="optradio1" id="ex">
                &nbsp;&nbsp;C&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <label><input type="radio" name="optradio1" id="ex">
                &nbsp;&nbsp;D&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
        </div>
    </div>
    <br />
    <div class="card w-75 mx-auto shadow shadow-sm">
        <div class="card-header">第三题</div>
        <div class="card-body">
            题目内容<br /><br />A<br /><br />B<br /><br />C<br /><br />D<br /><br />
        </div>
        <div class="card-footer">
            <label><input type="radio" name="optradio2" id="ex">
                &nbsp;&nbsp;A&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <label><input type="radio" name="optradio2" id="ex">
                &nbsp;&nbsp;B&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <label><input type="radio" name="optradio2" id="ex">
                &nbsp;&nbsp;C&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <label><input type="radio" name="optradio2" id="ex">
                &nbsp;&nbsp;D&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
        </div>
    </div>
</div>

<br /><br /><br />

<form class="form-inline col-md-1 offset-md-11 m-auto">
    <button class="btn btn-lg btn-info" type="button" onclick="check()">&nbsp;&nbsp;交&nbsp;卷&nbsp;&nbsp;</button>
    <p><br /><br /><br /><br /><br /><br /><br /><br /><br />&nbsp;</p>

</form>


</body>
</html>