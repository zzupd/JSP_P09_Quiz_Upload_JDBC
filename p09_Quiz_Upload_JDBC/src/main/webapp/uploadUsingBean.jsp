<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>        

<jsp:useBean id="fuo" class="pack.ex.FUO" />

<%
boolean chk1 = fuo.mtdUpload(request);
%>   

<jsp:useBean id="dbConn" class="pack.jdbc.DBConn" />
<%
String[] rtnData = fuo.rtnData;
dbConn.mtdDBConn();
boolean chk2 = dbConn.mtdInsert(rtnData, request);
%>    
<script>
<% if (chk1 && chk2) { %>
	alert("업로드 및 DB 입력 성공!!");
	<% } else { %>
	alert("실패!!");
<% } %>
	location.href="fileSend_.html";
</script>			