<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery/jquery-3.3.1.js"> </script>
    <script type="text/javascript" >
    function requestByJson(){
        $.ajax({
            type : 'post',
            url : '${pageContext.request.contextPath}/jsonsource',
            //设置contentType类型为json
            headers: {'Content-type': 'application/json;charset=UTF-8'},
            //json数据
            data : '{"name":"happyness","phone":"12345678901"}',
             //请求成功后的回调函数
            success : function(data) {
            alert(data.name);
        }
    });
    }

    function resquestByKV() {
        $.ajax({
            type : 'post',
            url : '${pageContext.request.contextPath}/kvsource',
            data : 'name=kvuser&phone=kvpsw',
            success : function(data) {
                alert(data.name);
            }
        });
    }

    //将表单数据发出，发出JSON
        function sendFrom() {
            var u1 = $("#u1").val();
            var p1 = $("#p1").val();
            $.ajax({
                type : 'post',
                url : '${pageContext.request.contextPath}/jsonsource_1',
                headers: {'Content-type': 'application/json;charset=UTF-8'},
                data : '{'+'"name":'+'"'+u1+'"'+','+'"phone":'+'"'+p1+'"'+'}',
                success : function(data){
                    alert(data.name+"============="+data.phone);
                    $("#u2").val(data.name);
                    $("#p2").val(data.phone);
                }
            });
        }

    </script>
    <script>
        function test(){
            alert("asdfasdf");
        }
    </script>
</head>
<body>
<h2>My Spring MVC Test Successed!</h2>

<input type="button" value="json" onclick="requestByJson()" />
<input type="button" value="keyvalue" onclick="resquestByKV()">
<br/>
<from>
    用户名:<input type="text" id="u1" name="name" /><br/>
    联系方式：<input type="text" id="p1" name="phone"><br/>
    <input type="button" value="提交" onclick="sendFrom()">
</from><br/>
========================================================<br/>
<from>
    用户名:<input type="text" id="u2" name="" /><br/>
    联系方式：<input type="text" id="p2" name=""><br/>
</from><br/>
</body>
</html>
