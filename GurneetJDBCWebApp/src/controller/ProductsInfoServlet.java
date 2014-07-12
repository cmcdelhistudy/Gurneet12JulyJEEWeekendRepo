package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

@WebServlet("/ProductsInfoServlet")
public class ProductsInfoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();

		ArrayList<Product> productlist = new ArrayList<Product>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager
					.getConnection("jdbc:oracle:thin:system/1267@localhost:1521:XE");

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery("select * from  Product");

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				float price = rs.getFloat(3);
				String desc = rs.getString(4);

				Product p = new Product();
				p.setId(id);
				p.setName(name);
				p.setPrice(price);
				p.setDescription(desc);

				productlist.add(p);

			}

			request.setAttribute("PRODUCT_LIST", productlist);

			request.getRequestDispatcher("productsinfo.jsp").forward(request,
					response);

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

	}

}
