package util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class SQLUtil {

	public static String getHtmlTable(ResultSet results) throws SQLException {
		
		StringBuilder htmlTable = new StringBuilder();
		ResultSetMetaData metaData = results.getMetaData();
		int columnCount = metaData.getColumnCount();
		
		htmlTable.append("<table>");
		
		htmlTable.append("<thead>");
		for (int i = 1; i <= columnCount; i++ ) {
			htmlTable.append("<th>");
			htmlTable.append(metaData.getColumnName(i));
			htmlTable.append("</th>");
		}
		htmlTable.append("</thead>");

		htmlTable.append("<tbody>");
		while (results.next()) {
			htmlTable.append("<tr>");
			for (int i = 1; i <= columnCount; i++) {
				htmlTable.append("<td>");
				htmlTable.append(results.getString(i));
				htmlTable.append("</td>");
			}
			htmlTable.append("<tr>");
		}
		htmlTable.append("</tbody>");

		htmlTable.append("</table>");
		
		return htmlTable.toString();
		
	}
	
}
