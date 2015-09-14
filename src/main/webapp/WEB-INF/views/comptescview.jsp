<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion des clients</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>

	<form:form method="post" action="/spring/comptes/saveCompte"
		modelAttribute="compte">
		<table class="table table-striped table-bordered">
			<tr>
				<td><form:label path="id">
						Id du compte :
					</form:label></td>
				<td>${ compte.id }<form:hidden path="id" /></td>
			</tr>
			<tr>
				<td><form:label path="libelle">
						Libellé :
					</form:label></td>
				<td><form:input path="libelle" /></td>
			</tr>
			<tr>

				<td><form:label path="solde">
						Solde :
					</form:label></td>
				<td><form:input path="solde" /></td>
			</tr>
			<tr>
				<td><form:label path="debitAut">
						Débit autorisé :
					</form:label></td>
				<td><form:input path="debitAut" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Valider" /></td>
			</tr>
		</table>
	</form:form>

	<span> 
		<a href="?lang=fr">fr</a> <a href="?lang=en">en</a>
	</span>

</body>
</html>