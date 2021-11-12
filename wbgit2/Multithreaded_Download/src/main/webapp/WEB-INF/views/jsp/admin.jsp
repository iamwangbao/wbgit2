<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Scanner" %>
<%@ page import="java.io.FileReader" %>
<%@ page import="javax.script.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>数据库信息管理</title>
    <script src="${pageContext.request.contextPath}/static/js/adminFunction.js"></script>
</head>
<body>

<a href="admin/selectAll">查询所有</a>

<br><br>
<input type="text" id="selectonedown_id"/>
<input type="button"  value="根据id查询一行" onclick="selectoneinputvalue()"/>

<br><br>

<form:form id="deleteone" name="deleteone" method="post" action="">
    <input type="hidden"  name="_method" value="DELETE"/>
    <input type="text" id="deleteonedown_id"/>
    <input type="submit" value="根据id删除一行" onclick="deleteoneinputvalue()"/>
</form:form>


<br><br>
<form:form modelAttribute="downInformations" method="POST" action="admin/insert">
    <!--增加 -->
    <table>
        <tr>
            <td><form:label path="down_id">下载id</form:label></td>
            <td><form:input path="down_id"/></td>
        </tr>
        <tr>
            <td><form:label  path="down_url">下载链接</form:label></td>
            <td><form:input path="down_url"/></td>
        </tr>
        <tr>
            <td><form:label  path="down_filename">文件名称</form:label></td>
            <td><form:input path="down_filename"/></td>
        </tr>

        <tr>
            <td><form:label  path="down_savapath">保存路径</form:label></td>
            <td><form:input path="down_savapath"/></td>
        </tr>

        <tr>
            <td><form:label  path="down_size">文件大小</form:label></td>
            <td><form:input path="down_size"/></td>
        </tr>

        <tr>

            <td><form:label  path="down_strattime">下载开始时间</form:label></td>
            <%
                Date d = new Date();
            %>
            <td><form:input  path="down_strattime" value="<%=d%>"/></td>

        </tr>


        <tr>
            <td><form:label  path="down_endtime">下载结束时间</form:label></td>
            <td><form:input path="down_endtime" value="<%=d%>"/></td>
        </tr>

        <tr>
            <td><form:label  path="down_YNsuccess">下载完成状态</form:label></td>
            <td><form:input path="down_YNsuccess"/></td>
        </tr>

        <tr>
            <td> <input type="submit" value="根据id插入一行"/></td>
        </tr>
    </table>
</form:form>
<br><br>
<form:form id="updateone" name="updateone" modelAttribute="downInformations" method="post" action="">
    <!-- 修改 -->
    <table>
        <tr>
            <td><form:label path="down_id">下载id</form:label></td>
            <td><form:input id="updateonedown_id"  path="down_id"/></td>
        </tr>
        <tr>
            <td><form:label path="down_url">下载链接</form:label></td>
            <td><form:input path="down_url"/></td>
        </tr>
        <tr>
            <td><form:label  path="down_filename">文件名称</form:label></td>
            <td><form:input path="down_filename"/></td>
        </tr>

        <tr>
            <td><form:label  path="down_savapath">保存路径</form:label></td>
            <td><form:input path="down_savapath"/></td>
        </tr>

        <tr>
            <td><form:label  path="down_size">文件大小</form:label></td>
            <td><form:input path="down_size"/></td>
        </tr>

        <tr>

            <td><form:label  path="down_strattime">下载开始时间</form:label></td>
            <%
                Date d = new Date();
            %>
            <td><form:input  path="down_strattime" value="<%=d%>"/></td>

        </tr>


        <tr>
            <td><form:label  path="down_endtime">下载结束时间</form:label></td>
            <td><form:input path="down_endtime" value="<%=d%>"/></td>
        </tr>

        <tr>
            <td><form:label  path="down_YNsuccess">下载完成状态</form:label></td>
            <td><form:input path="down_YNsuccess"/></td>
        </tr>
    </table>
    <input type="hidden"  name="_method" value="PUT"/>
    <input type="submit" value="根据id更新一行" onclick="updateoneinputvalue()"/>
</form:form>

</body>
</html>
