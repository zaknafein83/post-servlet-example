package it.dstech.formazione.webapplication.repos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.dstech.formazione.webapplication.model.Prodotto;

public class DBManagment {

	private Connection connessione;

	public DBManagment() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver"); // in questo punto carichia nella JVM in esecuzione la nostra
													// libreria
		String password = "password"; // la vostra password
		String username = "root"; // la vostra username
		String url = "jdbc:mysql://localhost:3306/magazzino?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false";
		this.connessione = DriverManager.getConnection(url, username, password);
	}

	public void addProdotto(Prodotto p) throws SQLException {
		PreparedStatement prepareStatement = this.connessione.prepareStatement("Insert into prodotto (qta, nome) values (?, ?);");
		prepareStatement.setInt(1, p.getQuantita());
		prepareStatement.setString(2, p.getNome());
		prepareStatement.execute();

	}

	public boolean vendiProdotto(Long id, int qta) throws SQLException {
		PreparedStatement prepareStatement = this.connessione
				.prepareStatement("select * from prodotto where id = ? limit 1");
		prepareStatement.setLong(1, id);
		ResultSet executeQuery = prepareStatement.executeQuery();
		Prodotto prodottoDB = new Prodotto();
		while (executeQuery.next()) {
			prodottoDB.setId(executeQuery.getLong(1));
			prodottoDB.setQuantita(executeQuery.getInt(2));
			prodottoDB.setNome(executeQuery.getString(3));
		}

		if (qta > prodottoDB.getQuantita()) {
			return false;
		}

		PreparedStatement updateQuery = this.connessione
				.prepareStatement("Update prodotto set qta = ? where id = ?");
		updateQuery.setInt(1, prodottoDB.getQuantita() - qta);
		updateQuery.setLong(2, prodottoDB.getId());
		updateQuery.execute();

		return true;

	}

	public List<Prodotto> getAll() throws SQLException {
		PreparedStatement updateQuery = this.connessione.prepareStatement("select * from prodotto;");
		ResultSet executeQuery = updateQuery.executeQuery();
		List<Prodotto> elenco = new ArrayList<>();
		while(executeQuery.next()) {
			Prodotto temp = new Prodotto();
			temp.setId(executeQuery.getLong(1));
			temp.setNome(executeQuery.getString(3));
			temp.setQuantita(executeQuery.getInt(2));
			elenco.add(temp);
		}
		return elenco;
	}

}
