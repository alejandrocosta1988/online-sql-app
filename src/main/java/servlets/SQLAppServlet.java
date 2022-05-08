package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SQLAppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SQLAppServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sqlStatement = request.getParameter("sql-statement");
		String sqlResult = "";
		
		
		try {

			String dbUrl = "jdbc:mysql://localhost:3306/OnlineSQL";
			String user = "root";
			String password = "";
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(dbUrl, user, password);
			
			sqlResult = "Conectado ao banco de dados com sucesso.";
			
		} catch (ClassNotFoundException classNotFound) {
			
			sqlResult = "<p>Erro ao tentar se conectar ao banco de dados. <br>" + classNotFound.getMessage() + "</p>";
			classNotFound.printStackTrace();
			
		}	catch (SQLException sqlException) {
			
			sqlResult = "<p>Erro ao executar a declaração SQL: <br>" + sqlException.getMessage() + "</p>";
			
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("sqlResult", sqlResult);
		session.setAttribute("sqlStatement", sqlStatement);
		
		String url = "/index.jsp";
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
	}

}
