<%@page import="com.jihoon.pmedical.vo.PmedicalVo"%>
<%@page import="java.util.List"%>
<%@page import="com.jihoon.pmedical.dao.PmedicalDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	PmedicalDao pmedicalDao = new PmedicalDao();
	List<PmedicalVo> list = pmedicalDao.getList();
%>
<!DOCTYPE html>
<html>
<style>
	table {
		border: 0px solid black;
		border-collapse: collapse;
		text-align: center;
	}
	th,td {
		border: 1px solid;
		border-collapse: collapse;
		padding: 15px;
		
	}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>진료 차트</title>
</head>
<body>
	<h1>내원 일지</h1>
	<form method="post" action="/pmedical02-1/pm?a=addform">
		<button onclick="window.location.href='/pmedical02-1/pm?a=addform'">추가하기</button>
	</form>
	<hr>
	<%
		for (int i = 0; i < list.size(); i++) {
			PmedicalVo pv = list.get(i);
	%>
	<table>
		<colgroup>
			<col style="background:#eee;">
			<col>
			<col style="background:#eee;">
			<col>
		</colgroup>
		<tr>
			<th> 번호 </th>
			<td><%=pv.getNo()%></td>
			<th> 전화번호 </th>
			<td><%=pv.getTel()%></td>
		</tr>			
		<tr>
			<th> 이름 </th>
			<td><%=pv.getName()%></td>
			<th> 성별 </th>
			<td><%=pv.getGender()%></td>
		</tr>			
		<tr>
			<th> 검진일 </th>
			<td colspan=3><%=pv.getDate()%></td>
		</tr>

		<tr>
			<th> 진료<br>내용 </th>
			<td width=100 style="word-break: break-all;"  colspan=9><%=pv.getStatus()%></td>
		</tr>
	</table>
		<button onclick="window.location.href='/pmedical02-1/pm?a=delete&no=<%=pv.getNo()%>'">삭제</button>
		<button onclick="window.location.href='/pmedical02-1/pm?a=updateform&no=<%=pv.getNo()%>'">수정</button>
	<br>
	<hr>
	<%
		}
	%>
</body>
</html>