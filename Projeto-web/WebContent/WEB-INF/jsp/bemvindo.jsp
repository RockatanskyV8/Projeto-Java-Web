<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bem Vindo ao JSP</title>
</head>
	<body>
		<%String mensagem = " <br />Uma mensagem de string";%>
		<%out.println(mensagem);%>
		
		<%@ page import="br.com.teste.jdbc.EquipamentoDAO"%>
		<%@ page import="br.com.teste.models.Equipamento"%>
		<table style="width:50%">
		<tr>
		<th>Nome</th>
		<th>Local</th>
		<th>Data</th>
		</tr>

		<%-- 
		EquipamentoDAO dao = new EquipamentoDAO();
		
		for(Equipamento c : dao.Show()){
		
			<tr>
			<td><%= c.getName() %></td>
			<td><%= c.getLocal() %></td>
			<td><%= c.getAdquirido() %></td>
			</tr>
		
		--%>
		</table>
	</body>
</html>