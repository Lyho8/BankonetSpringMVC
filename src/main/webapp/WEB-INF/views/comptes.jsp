<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion des comptes de ${ client.nom } ${ client.prenom }</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>

	<p>
		<a href="/spring/comptes/${ client.id }/addCompteE">Ajouter compte épargne</a> |
		<a href="/spring/comptes/${ client.id }/addCompteC">Ajouter compte courant</a>
	</p>

	<table class="table table-striped table-bordered">
		<tr>
			<th>Id</th>
			<th>Libellé</th>
			<th>Type</th>
			<th>Solde</th>
			<th>Editer</th>
			<th>Supprimer</th>
		</tr>
		<c:forEach items="${comptes}" var="c">
			<tr>
				<td>${ c.id }</td>
				<td>${ c.libelle }</td>
				<td>${ c.dtype }</td>
				<td>${ c.solde }</td>
				<td><a href="/spring/editCompte?id=${ c.id }">Editer</a></td>
				<td><a href="/spring/deleteCompte?id=${ c.id }">Supprimer</a></td>
			</tr>
		</c:forEach>
	</table>

	<span> 
		<a href="?lang=fr">fr</a> | <a href="?lang=en">en</a>
	</span>

</body>
</html>