<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>Drop Down</title>
<style>
	select{
	width:200px;
}
</style>
</head>

<body>

<div style="text-align:center;display:block;">
<h2>
	List of Countries, States and Cities 
</h2>

<form action="" method="POST">

<select name="countries" id="countries" onchange="this.form.submit()">
<c:forEach var="country" items="${countries}">
	<c:if test = "${country != selectedCountries}">
    	<option value="${country}"> <c:out value="${country}"/></option>
    </c:if>
</c:forEach>
	<c:if test="${not empty selectedCountries}">
  		<option value="${selectedCountries}" selected>${selectedCountries}</option>
 	</c:if>
</select>
<br/>

<select name="states" id="states" onchange="this.form.submit()">
	<c:if test="${not empty selectedStates}">
  		<option value="${selectedStates}" selected>${selectedStates}</option>
	</c:if>
<c:forEach var="state" items="${states}">
<c:if test = "${state != selectedStates}">
    <option value="${state}"> <c:out value="${state}"/></option>
    </c:if>
</c:forEach>

</select>
<br/>

<select name="cities" id="cities">
<c:forEach var="city" items="${cities}">
    <option value="${city}"> <c:out value="${city}"/></option>
</c:forEach>
</select>
<br/>
<br/>


<a href="/demo/index"> Go to React App</a> 
</form>
</div>
</body>
</html>
