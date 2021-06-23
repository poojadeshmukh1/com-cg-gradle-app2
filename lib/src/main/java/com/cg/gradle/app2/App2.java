package com.cg.gradle.app2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App2 {

	public static void main(String args[]) throws SQLException {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dvdrental", "postgres", "postgres");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		stmt = c.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM emp");
		while (rs.next()) {
			int eid = rs.getInt("eid");
			String ename = rs.getString("ename");
			float salary = rs.getFloat("salary");
			int did = rs.getInt("did");
			System.out.println("EID = " + eid);
			System.out.println("ENAME = " + ename);
			System.out.println("SALARY = " + salary);
			System.out.println("DID = " + did);
		}
	}
}