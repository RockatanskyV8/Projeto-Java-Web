package br.com.teste.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.teste.jdbc.EquipamentoDAO;
import br.com.teste.models.Equipamento;

@WebServlet("/adicionaEquipamento")
public class AdicionaEquipamento extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		
		String		nome 			= request.getParameter("nome");
		String 		local 			= request.getParameter("local");
		String 		adquirido		= request.getParameter("adquirido");
		Calendar 	data		 	= null;
		
		try{
			Date d = new SimpleDateFormat("dd/MM/yyyy").parse(adquirido);
			data = Calendar.getInstance();
			data.setTime(d);
		}catch(ParseException e){
			 out.println("Erro de conversão da data");
             return;
		}
		
		Equipamento e = new Equipamento();
		e.setName(nome);
		e.setLocal(local);
		e.setAdquirido(data);
		
		Connection con = (Connection) request.getAttribute("conexao");
		
		EquipamentoDAO dao = new EquipamentoDAO(con);
		dao.adiciona(e);
		
        RequestDispatcher rd = request.getRequestDispatcher("/adiciona-equipamento.jsp");
        rd.forward(request, response);
	}
}
