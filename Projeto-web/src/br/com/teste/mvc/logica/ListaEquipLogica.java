package br.com.teste.mvc.logica;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.teste.jdbc.EquipamentoDAO;
import br.com.teste.models.Equipamento;
public class ListaEquipLogica implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		Connection con = (Connection) req.getAttribute("conexao");
		
		List<Equipamento> equip = new EquipamentoDAO(con).Show();
		
		req.setAttribute("equipamentos", equip);
		
		return "WEB-INF/jsp/JSTLteste.jsp";
	}

}
