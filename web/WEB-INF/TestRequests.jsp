<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Test Requests</title>
    </head>
    <body>
        <h1>Tests Requests</h1>
		<h2>createRequest(Request request)</h2>
		<h2>updateRequestStatus(Request request)</h2>
		<h2>listRequests()</h2>
        <c:forEach items="${requestsList}" var="request" varStatus="boucle">
            <p>${ boucle.count }. ${request}</p>
        </c:forEach>
        <br>
        <h2>retrieveRequestFromID(long ID)</h2>
        <p>${requestFromID}</p>
    </body>
</html>