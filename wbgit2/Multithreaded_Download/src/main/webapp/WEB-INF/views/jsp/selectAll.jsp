<%@ page import="java.util.List" %>
<%@ page import="com.down.ssm.domain.DownInformation" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.down.ssm.pojo.time" %><%--
  Created by IntelliJ IDEA.
  User: New me
  Date: 2021/11/11
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询所有</title>
</head>
<body>

<h2>${CRUDstring}</h2>
<%
    String YNsuccess;
    time nowtime =new time();
    List<DownInformation> downInformations =(List<DownInformation>)pageContext.getAttribute("downInformations", PageContext.REQUEST_SCOPE);
%>


<% for (DownInformation downInformation : downInformations) {
%>
<table>
    <tr>
        <td><label>下载id</label></td>
        <td><%=downInformation.getDown_id()%>
        </td>
    </tr>
    <tr>
        <td><label>下载链接</label></td>
        <td><%=downInformation.getDown_url()%>
        </td>
    </tr>
    <tr>
        <td><label>文件名称</label></td>
        <td><%=downInformation.getDown_filename()%>
        </td>
    </tr>

    <tr>
        <td><label>保存路径</label></td>
        <td><%=downInformation.getDown_savapath()%>
        </td>
    </tr>

    <tr>
        <td><label>文件大小</label></td>
        <td><%=downInformation.getDown_size()%>
        </td>
    </tr>

    <tr>

        <td><label>下载开始时间</label></td>
        <td><%=nowtime.formattime(downInformation.getDown_strattime())%>
        </td>

    </tr>


    <tr>
        <td><label>下载结束时间</label></td>
        <td><%=nowtime.formattime(downInformation.getDown_endtime())%>
        </td>
    </tr>

    <tr>
        <td><label>下载完成状态</label></td>
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
<h4>-------------------<h4>
<%}%>

</body>
</html>
