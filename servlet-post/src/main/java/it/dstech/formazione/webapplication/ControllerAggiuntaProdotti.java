package it.dstech.formazione.webapplication;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.formazione.webapplication.model.Prodotto;
import it.dstech.formazione.webapplication.repos.DBManagment;

public class ControllerAggiuntaProdotti extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("messaggio", "hai provato a fare l'accesso all'aggiunta di un prodotto dalla get");
		req.getRequestDispatcher("index.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		
		int qta = Integer.parseInt(req.getParameter("qta"));
		Prodotto p = new Prodotto();
		p.setQuantita(qta);
		p.setNome(nome);
		try {
			DBManagment dbManagment = new DBManagment();
			dbManagment.addProdotto(p);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("index.jsp").forward(req, resp);

	}
}
