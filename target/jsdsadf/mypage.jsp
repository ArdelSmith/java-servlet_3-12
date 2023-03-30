<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="icon" type="image/vnd.microsoft.icon" href="static/images/favicon.ico" />
    <title>Devcolibri.com</title>
</head>
<body>
	<button style="position: fixed; top: 0; right: 0; height:30px;width:60px"><a href="${prevLink}/logout">Log out</a></button>
    <h1>${date}</h1>
    <h2>Current user: ${username}</h2>
    <h3><a href="${prevLink}/files?path=${parent}"><image src ="static/images/previous.png" width="50" height="50"></a></h3>
    <h4>${path}</h4>
    <table border="1" cellpadding="5">
        <tr>
            <th>Type</th>
            <th>FileName</th>
            <th>Size</th>
        </tr>
        <c:forEach items="${list}" var="list">
        <tr>
        <td><image src="${list.isDirectory() ? 'static/images/directory.png' : 'static/images/file.jpg'}" width="50" height="50"></td>
        <td>
            <c:choose>
            	<c:when test="${list.isDirectory()}">
            		<c:choose>
            			<c:when test="${Paths.get(list.getPath()).getParent() != null}">
            				<a href="${prevLink}/files?path=${path}/${list.getName()}">${list.getName()}</a>
            			</c:when>
            			<c:when test="${Paths.get(list.getPath()).getParent() == null}">
            				<a href="${prevLink}/files?path=${path}/${list.getName()}">${list.getName()}</a>
            			</c:when>
            		</c:choose>
                </c:when>
                <c:otherwise>
                    <a href="${prevLink}/download?path=${path}/${list.getName()}" download="${list.getName()}">${list.getName()}</a>
                </c:otherwise>
            </c:choose>
        </td>
        <td><c:out value = "${list.length()} Bytes"/></td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>
