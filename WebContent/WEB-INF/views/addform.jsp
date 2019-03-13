<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<style>
	table{
		border: 2px solid;
		border-collapse: collapse;
	}
	th,td {
		border: 2px solid;
		padding: 15px;		
	}	
</style>
<head>
<meta charset="UTF-8">
<title>진료기록 추가</title>
</head>
<body>
	<h1>진료기록 추가</h1>
	<form action="/pmedical02-1/pm?a=add" method="post">
		<table>
		<colgroup>
			<col style="background:#eee;">
		</colgroup>
			<tr>
				<th> 이름: </th>
				<td><textarea name="name" cols=60 rows=1></textarea></td>
			</tr>

			<tr>
				<th> 성별: </th>
				<td><textarea name="gender" cols=60 rows=1></textarea></td>
			</tr>
			<tr>
				<th> 전화번호: </th>
				<td><textarea name="tel" cols=60 rows=1></textarea></td>
			</tr>

			<tr>
				<th> 진료내용: </th>
				<td><textarea name="status" cols=60 rows=10></textarea></td>
			</tr>
		</table>
			
			<input type="submit" value=" 추가하기 ">
			
	</form>
	<form method="post" action="/pmedical02-1/pm">
		<button onclick="window.location.href='/pmedical02-1/pm'">메인으로</button>
	</form>
</body>
</html>