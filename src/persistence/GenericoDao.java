package persistence;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.leandrocolevati.bancodedados.GenericDao;
import br.com.leandrocolevati.bancodedados.Sgbd;

public class GenericoDao {

	public Connection getConnection() throws SQLException{
		GenericDao gDao = new GenericDao("localhost", "l.colevati", "com@fatec", "testehorario", true, Sgbd.SQLSERVER);
		return gDao.getConnection();
	}
	
}
