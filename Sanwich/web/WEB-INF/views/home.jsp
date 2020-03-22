<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: devcold
  Date: 22/03/2020
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>lua chon mui vi</title>
</head>
<body>
<p>
    sandwich
</p>
<form:checkbox path="preferences.interests" value="Quidditch" /> Herbology:
<form:checkbox path="preferences.interests" value="Herbology" /> Defence Against the Dark Arts:
<form:checkbox path="preferences.interests" value="Defence Against the Dark Arts" />

</body>
</html>
