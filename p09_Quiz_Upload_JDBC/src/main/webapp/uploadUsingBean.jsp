<%@page import="pack.dto.DataBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>        

<!-- 업로드 & DB 처리 시작 -->
<%
long startTM = System.currentTimeMillis();
// 처리시간 확인용 코드
%>
<jsp:useBean id="fuo" class="pack.ex.FUO" />


<%
DataBean dataBean = new DataBean();
boolean chk1 = fuo.mtdUpload(request, dataBean);
%>

<jsp:useBean id="dbConn" class="pack.jdbc.DBConn" />
<%
dbConn.mtdDBConn();
boolean chk2 = dbConn.mtdInsert(request, dataBean);

long endTM = System.currentTimeMillis();
System.out.print("총 처리시간 : " + (endTM - startTM) + " ms");
%>    
<script>
<% if (chk1 && chk2) { %>
	alert("업로드 및 DB 입력 성공!!");
	<% } else { %>
	alert("실패!!");
<% } %>
	location.href="fileSend_.html";
</script>	