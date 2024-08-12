<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Show Trainees</title>
</head>
<body>
    <h1>Trainee Details </h1>
    <br>
    <h3> List without iteration </h3>
    ${traineelist}

    <h3>List with iteration </h3>
    <ul>
    <c:forEach var="trainee" items="${traineeList}">
       <li>
            <p>ID : ${trainee.id}</p>
            <p>Name : ${trainee.name}</p>
            <p>Location : ${trainee.location}</p>
       </li>
    </c:forEach>
    </ul>
</body>
</html>