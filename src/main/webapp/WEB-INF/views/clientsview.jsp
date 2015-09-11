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

	<form:form method="post" action="/spring/saveClient"
		modelAttribute="client">
		<table class="table table-striped table-bordered">
			<tr>
				<td><form:label path="id">
						<spring:message code="page.clientsview.fid" />
					</form:label></td>
				<td>${ client.id }<form:hidden path="id" /></td>
			</tr>
			<tr>
				<td><form:label path="nom">
						<spring:message code="page.clientsview.fnom" />
					</form:label></td>
				<td><form:input path="nom" /></td>
				<%--Show errors for name field --%>
				<td><form:errors path="nom" /></td>
			</tr>
			<tr>

				<td><form:label path="prenom">
						<spring:message code="page.clientsview.fprenom" />
					</form:label></td>
				<td><form:input path="prenom" /></td>
				<%--Show errors for firstname field --%>
				<td><form:errors path="prenom" /></td>
			</tr>
			<tr>
				<td><form:label path="login">
						<spring:message code="page.clientsview.flogin" />
					</form:label></td>
				<td><form:input path="login" /></td>
				<%--Show errors for login field --%>
				<td><form:errors path="login" /></td>
			</tr>
			<tr>
				<td><form:label path="motDePasse">
						<spring:message code="page.clientsview.fmdp" />
					</form:label></td>
				<td><form:password path="motDePasse" /></td>
				<%--Show errors for password field --%>
				<td><form:errors path="motDePasse" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="<spring:message code="page.clientsview.button" />" /></td>
			</tr>
		</table>
	</form:form>
	
	<font color="green" style="weight-bold">${ msg }</font>

	<table class="table table-striped table-bordered">
		<tr>
			<th><spring:message code="page.clientsview.id" /></th>
			<th><spring:message code="page.clientsview.nom" /></th>
			<th><spring:message code="page.clientsview.prenom" /></th>
			<th><spring:message code="page.clientsview.edit" /></th>
			<th><spring:message code="page.clientsview.delete" /></th>
		</tr>
		<c:forEach items="${clients}" var="c">
			<tr>
				<td>${ c.id }</td>
				<td>${ c.nom }</td>
				<td>${ c.prenom }</td>
				<td><a href="/spring/editClient/${ c.id }">Editer</a></td>
				<td><a href="/spring/deleteClient?id=${ c.id }">Supprimer</a></td>
			</tr>
		</c:forEach>
	</table>

	<span> 
		<a href="?lang=fr">fr</a> <a href="?lang=en">en</a>
	</span>

</body>
</html>