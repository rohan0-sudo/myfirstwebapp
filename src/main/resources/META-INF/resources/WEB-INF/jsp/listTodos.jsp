<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>todos in git repository !! ok</title>
		<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<div class = "container">
			<div>welcome ${name}</div>
			<div>Todos are:</div>
			
			<table class="table">
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
			<a href="add-todo" class="btn btn-success">Add Todo</a>
		</div>
			<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
			<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
		
	</body>
</html>