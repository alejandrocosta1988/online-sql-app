<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
  <jsp:include page="includes/head.html"></jsp:include>
</head>

<body>

  <h1>Online SQL App</h1>
  <p>Digite uma declaração SQL e pressione executar. A declaração será executada em um banco de dados MySQL.</p>
  
  <p><b>Declaração SQL:</b></p>
  
  <c:if test="${sqlStatement == null}">
    <c:set var="sqlStatement" value="SELECT * FROM table_users"></c:set>
  </c:if>
  
  <form action="SQLApp" method="post">
    <textarea name="sql-statement" rows="5" cols="100" placeholder="Digite aqui sua declaração em SQL.">${sqlStatement}</textarea>
    <input type="submit" value="Executar">
  </form>
  
  <p><b>Resultado:</b></p>
  <p>${sqlResult}</p>
  
  <hr>

  <footer>
    <jsp:include page="includes/footer.jsp"></jsp:include>
  </footer>

</body>
</html>