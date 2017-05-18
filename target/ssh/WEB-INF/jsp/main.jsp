<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2017/5/15
  Time: 下午3:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Bootstrap 实例 - 上下文类</title>
    <link rel="stylesheet" href="/jquery-2.1.1/bootstrap.min.css">
    <script src="/jquery-2.1.1/jquery.js"></script>
    <script src="/jquery-2.1.1/bootstrap.min.js"></script>
</head>
<body>

<table class="table">
    <caption>所有用户信息</caption>
    <thead>
    <tr>
        <th>id</th>
        <th>用户名</th>
        <th>密码</th>
        <th>昵称</th>
    </tr>
    </thead>
    <tbody id="tbody">
    </tbody>
</table>
<div style="text-align: center">
    <a id="pre">上一页</a>
    <input id="number" style="width: 30px" type="number" value="1">
    <button id="btn">跳转</button>
    <a id="next">下一页</a>
</div>
<script>
    var pageNumber = 1;
    loadData(pageNumber);
    var totalPage;
    function loadData(pageNumber) {
        $.ajax({
            type: "get",
            url: "http://localhost:8080/getAllUser?pageNumber=" + pageNumber,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (result) {
                if (result.code == "S01") {
                    var contents = result.contents.userinfoEntities;
                    totalPage = result.contents.totalPage;
                    var html = "";
                    for (var i = 0; i < contents.length; i++) {
                        html += "<tr class=" + getBackGround(i % 4) + "><td>" + contents[i].id + "</td><td>" + contents[i].username + "</td><td>" + contents[i].password + "</td><td>" + contents[i].nickname + "</td>></tr>"
                    }
                    $('#tbody').html(html);
                }
            },
            error: function (result) {
                $("#request-process-patent").html(result);
            }
        });
    }
    function getBackGround(i) {
        var backGround = ["active", "success", "warning", "danger"];
        return backGround[i];
    }

    $('#pre').click(function () {
        var currentPage = $('#number').val();
        if (currentPage > 1) {
            loadData(--pageNumber);
            $('#number').val(--currentPage);
        }
    });

    $('#next').click(function () {
        var currentPage = $('#number').val();
        if (currentPage != totalPage) {
            loadData(++pageNumber);
            $('#number').val(++currentPage);
        }
    });
    $('#btn').click(function () {
        var currentPage = $('#number').val();
        if (currentPage<totalPage){
            loadData(currentPage);
        }
        else {
            loadData(totalPage);
            $('#number').val(totalPage);
        }
    });
</script>
</body>
</html>