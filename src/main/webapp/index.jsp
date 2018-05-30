<html>
<head>
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
</body>
</html>
