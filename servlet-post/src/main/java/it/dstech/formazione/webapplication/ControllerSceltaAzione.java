package it.dstech.formazione.webapplication;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.formazione.webapplication.model.Prodotto;
import it.dstech.formazione.webapplication.repos.DBManagment;

public class ControllerSceltaAzione extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String azione = req.getParameter("azione");
		System.out.println(azione);
		if ("aggiungi".equalsIgnoreCase(azione)) {
			req.getRequestDispatcher("aggiungi.jsp").forward(req, resp);
		} else if ("stampa".equalsIgnoreCase(azione)) {
			try {
				DBManagment db = new DBManagment();
				List<Prodotto> lista = db.getAll();
				req.setAttribute("lista", lista);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.getRequestDispatcher("stampa.jsp").forward(req, resp);
		} else if ("vendi".equalsIgnoreCase(azione)) {
			try {
				DBManagment db = new DBManagment();
				List<Prodotto> lista = db.getAll();
				req.setAttribute("lista", lista);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	req.getRequestDispatcher("vendi.jsp").forward(req, resp);
		}

	}
}
