<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

Please Enter the Details</br>
<c:forEach items="${parameters}" var="parameter">
   <tr>
        <td>${parameter.prompt}<input type="text" name="firstname"></td></br>
    </tr>
</c:forEach>