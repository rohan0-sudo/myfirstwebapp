<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>todos in git repository !!</title>
	</head>
	<body>
		<div>welcome ${name}</div>
		<div>Todos are:</div>
		
		<table>
		<thead>
			<tr>
				<th>id</th>
				<th>UserName</th>
				<th>Description</th>
				<th>Date</th>
				<th>Status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
						<tr>
							<td>${todo.id}</td>
							<td>${todo.userName}</td>
							<td>${todo.description}</td>
							<td>${todo.targetDate}</td>
							<td>${todo.done}</td>
						</tr>
			</c:forEach>
		</tbody>
		</table>
	</body>
</html>