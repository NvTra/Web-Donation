package com.tranv.webdonation.testDb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Testdb
 */
@WebServlet("/Testdb")
public class Testdb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setup database variable
		String user = "admin";
		String pass = "admin";

		String jdbcUrl = "jdbc:mysql://localhost:3306/web_donation_asm01?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=yes&characterEncoding=UTF-8";
		String driver = "com.mysql.jdbc.Driver";
		// conection to database
		try {
			PrintWriter out = response.getWriter();

			out.println("Connecting to database: " + jdbcUrl);

			Class.forName(driver);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

			out.println("\n SUCCESS!!!");
			myConn.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
