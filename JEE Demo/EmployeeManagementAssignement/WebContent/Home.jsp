<%@page import="com.org.beans.Emp"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>
	<%
		Object objEmp = session.getAttribute("emp");
		Emp emp = null;
		if (objEmp != null) {
			emp = (Emp) objEmp;
			session.setAttribute("emp", emp);
		}
		System.out.println("session in home : " + emp);

		if (emp == null) {
			session.setAttribute("error", "Please login Before Continue");
			request.getRequestDispatcher("index.jsp").forward(request, response);

		}
		//session.invalidate();

		Object list = request.getSession().getAttribute("empList");
		List<Emp> listEmp = (List<Emp>) list;
	%>
	<H2>
		Welcome to Home
		<%=emp.getEmail()%>
		<a href="${pageContext.request.contextPath}/ViewDetail?edit=true">Profile</a>
	</H2>
	<c:set var="currentUser" value="<%=emp%>"></c:set>
	<c:set var="listEmp" value="<%=listEmp%>"></c:set>

	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>View Details</th>
			<c:if test="${currentUser.getPermission().equals('admin') }">
				<th>Update</th>
				<th>Delete</th>
			</c:if>


		</tr>
		<c:forEach items="${listEmp }" var="emp">
			<tr>
				<td><c:out value="${emp.getId()}" /></td>
				<td><c:out value="${emp.getName()}" /></td>
				<td><c:out value="${emp.getEmail()}" /></td>
				<c:if test="${currentUser.getEmail().equals(emp.getEmail()) }">
					<td>
						<form
							action="${pageContext.request.contextPath}/viewDetails?edit=true">
							<input type="submit" name="button1" value="View Details" />
						</form>
					</td>
				</c:if>

				<c:if test="${!currentUser.getEmail().equals(emp.getEmail()) }">
					<td>
						<form
							action="${pageContext.request.contextPath}/viewDetails?edit=false">
							<input type="submit" name="button1" value="View Details" />
						</form>
					</td>
				</c:if>



				<c:if test="${currentUser.getPermission().equals('admin') }">

					<td>
						<form
							action="${pageContext.request.contextPath}/editDetails?edit=false">
							<input type="submit" name="button1" value="Edit Employee" />
						</form>
					</td>
					<td>
						<form action="${pageContext.request.contextPath}/deleteEmp">
							<input type="submit" name="button1" value="Delete Employee" />
						</form>
					</td>
				</c:if>




			</tr>

		</c:forEach>

	</table>
</body>
</html>