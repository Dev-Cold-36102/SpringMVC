<%--
  Created by IntelliJ IDEA.
  User: devcold
  Date: 22/03/2020
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>may tinh</title>
</head>
<body>
<p>Caculator</p>
<form action="/caculator" method="post">
    <input id="operand" value="+" style="display: none" name="operand">
    <input name="firstOperator" value="${firstOperator}" type="number">
    <input name="secondOperator" value="${secondOperator}" type="number">
    <table>
        <tr>
            <td>
                <input type="submit" onclick="setOperand('+')" value="+">
            </td>
            <td>
                <input type="submit" onclick="setOperand('-')" value="-">
            <td>
                <input type="submit" onclick="setOperand('*')" value="*">
            </td>
            <td>
                <input type="submit" onclick="setOperand('/')" value="/">
            </td>
        </tr>
    </table>
</form>
<p>result:</p>
<input name="result" value="${result}">
<script>
    function setOperand(operand) {
        document.getElementById("operand").value = operand;
    }
</script>
</body>
</html>
