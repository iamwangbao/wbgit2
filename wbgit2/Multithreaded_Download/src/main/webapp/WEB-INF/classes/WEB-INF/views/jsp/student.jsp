<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Download information input page</title>
</head>
<body>

<h2>input Download Information</h2>
<form:form method="POST" action="/Multithreaded_Download/addStudent">

<table border="2" >
<tr >
<td >
<!-- 第一个 -->
 <table >
    <tr>
        <td><form:label path="file">File Name</form:label></td>
        <td><form:input path="file" /></td>
    </tr>
    <tr>
        <td><form:label path="downpath">URL</form:label></td>
        <td><form:input path="downpath" /></td>
    </tr>
    <tr>
        <td><form:label path="savapath">Sava Path</form:label></td>
        <td><form:input path="savapath" /></td>
    </tr>
   
</table>

</td>

<td>
<!-- 第二个 -->
 <table>
    <tr>
        <td><form:label path="file">File Name</form:label></td>
        <td><form:input path="file" /></td>
    </tr>
    <tr>
        <td><form:label path="downpath">URL</form:label></td>
        <td><form:input path="downpath" /></td>
    </tr>
    <tr>
        <td><form:label path="savapath">Sava Path</form:label></td>
        <td><form:input path="savapath" /></td>
    </tr>
    
</table>
</td>
</tr>

<tr>
<td>
<!-- 第三个 -->
      <table>
    <tr>
        <td><form:label path="file">File Name</form:label></td>
        <td><form:input path="file" /></td>
    </tr>
    <tr>
        <td><form:label path="downpath">URL</form:label></td>
        <td><form:input path="downpath" /></td>
    </tr>
    <tr>
        <td><form:label path="savapath">Sava Path</form:label></td>
        <td><form:input path="savapath" /></td>
    </tr>
   
</table>

</td>
        
<td>
<!-- 第四个 -->
   <table>
    <tr>
        <td><form:label path="file">File Name</form:label></td>
        <td><form:input path="file" /></td>
    </tr>
    <tr>
        <td><form:label path="downpath">URL</form:label></td>
        <td><form:input path="downpath" /></td>
    </tr>
    <tr>
        <td><form:label path="savapath">Sava Path</form:label></td>
        <td><form:input path="savapath" /></td>
    </tr>
   
</table> 
    
 </td>
 </tr>
   
    <tr align="center">
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>   
      
</form:form>
</body>
</html>