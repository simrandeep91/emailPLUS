<%-- 
    Document   : index
    Created on : Dec 10, 2009, 10:51:27 AM
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body><br/><br/><br/>
        <table border="1" align="center" bgcolor="cyan">
            <tr>
                <th colspan="2">Download Demo</th>
            </tr>
            <tr>
                <td><input type="text" name="txtFilePath" size="50" readonly value="/home/student/Demo.txt"></td>
                <td><a href="DownloadServlet?path=/home/student/Demo.txt">Download</a></td>
            </tr>

        </table>
    </body>
</html>
