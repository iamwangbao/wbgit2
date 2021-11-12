<%@ page import="com.down.ssm.pojo.time" %>
<%@ page import="java.util.Date"%>
<%@ page import="com.down.ssm.domain.DownInformation" %>
<%--
  Created by IntelliJ IDEA.
  User: New me
  Date: 2021/11/10
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增删改查结果界面</title>
</head>
<body>

<h2>${CRUDstring}</h2>

<!-- 第2个 -->
<table>
    <tr>
        <td><label >下载id</label></td>
        <td>${downInformations.down_id}</td>
    </tr>
    <tr>
        <td><label >下载链接</label></td>
        <td>${downInformations.down_url}</td>
    </tr>
    <tr>
        <td><label >文件名称</label></td>
        <td>${downInformations.down_filename}</td>
    </tr>

    <tr>
        <td><label >保存路径</label></td>
        <td>${downInformations.down_savapath}</td>
    </tr>

    <tr>
        <td><label >文件大小</label></td>
        <td>${downInformations.down_size}</td>
    </tr>
<%
    String YNsuccess = " ";
    String strattime = " ";
    String endtime = " ";
    time nowtime =new time();
    DownInformation downInformation= (DownInformation)request.getAttribute("downInformations");
    strattime=nowtime.formattime(downInformation.getDown_strattime());
    endtime = nowtime.formattime(downInformation.getDown_endtime());
%>



    <tr>
        <td><label >下载开始时间</label></td>
        <td> <%=strattime%></td>
    </tr>


    <tr>
        <td><label >下载结束时间</label></td>
        <td><%=endtime%></td>
    </tr>

    <tr>
        <td><label >下载完成状态</label></td>
        <td><%
            if (downInformation.getDown_YNsuccess() == 1) {
                YNsuccess = "下载成功";
            } else {
                YNsuccess = "下载失败";
            }
            pageContext.setAttribute("YNsuccess",YNsuccess);
        %>
            <%= pageContext.getAttribute("YNsuccess")%></td>
    </tr>

</table>


</body>
</html>
