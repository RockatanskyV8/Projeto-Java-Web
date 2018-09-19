package br.com.teste.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

//import br.com.teste.jdbc.JDBCComandos;
import br.com.teste.jdbc.EquipamentoDAO;
import br.com.teste.models.Equipamento;

public class OiMundo extends HttpServlet{
	@Override
	public void service(ServletRequest request, 
						ServletResponse response) 
						throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		Connection con = (Connection) request.getAttribute("conexao");
		EquipamentoDAO dao = new EquipamentoDAO(con);
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title> Primeira Servlet </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table style=\"width:50%\">");
		//out.println("<table>");
		out.println("<tr>");
		out.println("<th>Nome</th>");
		out.println("<th>Local</th>");
		out.println("<th>Data</th>");
		out.println("</tr>");
		for(Equipamento c : dao.Show()){
			out.print("<tr>");
	        out.print("<td>" + c.getName() + "</td>");
	        out.print("<td>" + c.getLocal()+ "</td>");
	        out.print("<td>" + c.getAdquirido()+ "</td>");

	        out.print("</tr>");
	    }
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
}
