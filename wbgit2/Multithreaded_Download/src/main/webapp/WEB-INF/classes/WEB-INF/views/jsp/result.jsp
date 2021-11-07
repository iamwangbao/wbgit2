<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Download information page</title>
  <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
</head>
<body>

<h2>Download information</h2>
   <table   >
    <tr>
        <td>File Name</td>
        <td>${file}</td>
    </tr>
    <tr>
        <td>URL</td>
        <td>${downpath}</td>
    </tr>
    <tr>
        <td>Sava Path</td>
        <td>${savapath}</td>
    </tr>
</table>  
</body>
</html>