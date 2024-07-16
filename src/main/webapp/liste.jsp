

<%@ page import = "dao.Gestiondb" %>
    <%@ page import = "Model.Etudiant" %>
    <%@ page import = "java.util.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>liste</title>

</head>
<body>

<table border="1">
<tr>
<td>nom</td>
<td>prenom</td>
<td>tlfn</td>
<td>action</td>
</tr>
 <% Gestiondb g =new Gestiondb();
  List<Etudiant>  l=g.getAllEtudiants();%>
<% 
for(Etudiant e:l){ %>
<tr>
<td><%=e.getNom() %></td>
<td><%=e.getPrenom() %></td>
<td><%=e.getNumr() %></td>

<td><a href="Supprimer?id=<%=e.getNum()%>">Supprimer</a></td>
</tr>
<% } 
%>
<p> Ajouter un Etudiant </p>

<form action="Ajouter" method="post">
  <label for="num">Numero</label>
  <input type="number" id="num" name="num"><br>
  <label for="prenom">prenom:</label>
  <input type="text" id="prenom" name="prenom">
  <label for="nom">nom</label>
  <input type="text" id="nom" name="nom"><br>
  <label for="tel">numtlfn</label>
  <input type="number" id="tel" name="tel">
  <button type="submit">Enregister</button>
</form>
</table>
</body>
</html>
body>
</html>