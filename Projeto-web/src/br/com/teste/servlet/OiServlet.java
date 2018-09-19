package br.com.teste.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(
		name = "oiServlet",
		urlPatterns = {"/oiServlet"},
		initParams = {@WebInitParam(name = "param1", value = "value1"),
					  @WebInitParam(name = "param2", value = "value2")}
		)
public class OiServlet extends HttpServlet{
	private String parametro1;
	private String parametro2;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.parametro1 = config.getInitParameter(parametro1);
		this.parametro2 = config.getInitParameter(parametro2);
	}
	
	public void service(ServletRequest request, 
			ServletResponse response) 
			throws ServletException, IOException {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.println("<h2>Exemplo com InitParam Servlet</h2>");
			
			ServletConfig config = getServletConfig();
			
			String parametro1 = config.getInitParameter("param1");
			out.println("Valor do parâmetro 1: " + parametro1);
			
			String parametro2 = config.getInitParameter("param2");
			out.println("Valor do parâmetro 2: " + parametro2);
			
			out.close();

	}
	
}
