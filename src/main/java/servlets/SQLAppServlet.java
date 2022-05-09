package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.DatabaseConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.SQLUtil;

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

			Connection connection = DatabaseConnection.getConnection();
			
			if (connection != null) {
				sqlResult = "Conectado ao banco de dados com sucesso.";
			}
			
			Statement statement = connection.createStatement();
			sqlStatement = sqlStatement.trim();
			
			if (sqlStatement.length() >= 6) {
				
				String sqlType = sqlStatement.substring(0, 6);
				if (sqlType.equalsIgnoreCase("select")) {
					ResultSet resultSet = statement.executeQuery(sqlStatement);
					sqlResult = SQLUtil.getHtmlTable(resultSet);
					resultSet.close();
				}
				
			}
			
		} catch (SQLException sqlException) {
			
			sqlResult = "<p>Erro ao executar a declaração SQL: <br>" + sqlException.getMessage() + "</p>";
			
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("sqlResult", sqlResult);
		session.setAttribute("sqlStatement", sqlStatement);
		
		String url = "/index.jsp";
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
	}

}
