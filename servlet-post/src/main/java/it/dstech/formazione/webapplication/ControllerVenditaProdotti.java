package it.dstech.formazione.webapplication;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.formazione.webapplication.repos.DBManagment;

public class ControllerVenditaProdotti extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("id"));
		int qta = Integer.parseInt(req.getParameter("qta")); 
		try {
			DBManagment db = new DBManagment();
			boolean vendiProdotto = db.vendiProdotto(id, qta);
			if(vendiProdotto) {
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
			else {
				req.setAttribute("messaggio", "quantita insufficente per essere venduta");
				req.getRequestDispatcher("error.jsp").forward(req, resp);
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
