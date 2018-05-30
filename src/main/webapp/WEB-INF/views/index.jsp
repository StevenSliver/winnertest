<html>
<head>
    <script type="${pageContext.request.contextPath}/static/jquery/jquery-3.3.1.min.js">
    function requestByJson(){
        $.ajax(
            type : 'post',
            url : '${pageContext.request.contextPath}/jsonsource',
            //设置contentType类型为json
            contentType : 'applaction/json;charset=utf-8',
            //json数据
            data : '{"name":"lyf","phone":"12345678901"}',
             //请求成功后的回调函数
            success : function(data){
                            alert(data.name);
        );
    }
    </script>
    <script>
        function test(){
            alert("asdfasdf");
        }
    </script>

</head>>
<body>
<h2>My Spring MVC Test Successed!</h2>

<input type="button" value="json" onclick="test()" />

</body>
</html>
