package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddProductInfoServlet")
public class AddProductInfoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(request.getParameter("pid"));
		String name = request.getParameter("name");
		float price = Float.parseFloat(request.getParameter("price"));
		String desc = request.getParameter("description");

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:system/1267@localhost:1521:XE");

			Statement st = con.createStatement();

			int r = st.executeUpdate("insert into Product values(" + id + ",' "
					+ name + " '," + price + ",'" + desc + "')");

			if (r > 0) {
				request.getRequestDispatcher("ProductsInfoServlet")
						.forward(request, response);
			}

		} catch (ClassNotFoundException e) {
			out.println("Driver Class Not available " + e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			out.println("SQL Exception  " + e.getMessage());
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
