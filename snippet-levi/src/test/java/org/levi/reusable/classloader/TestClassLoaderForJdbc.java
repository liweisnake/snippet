package org.levi.reusable.classloader;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class TestClassLoaderForJdbc {

	@Test
	public void test() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
