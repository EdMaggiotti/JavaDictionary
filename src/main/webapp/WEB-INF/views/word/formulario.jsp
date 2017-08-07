<%@include file="../includes/header.jsp" %>

<a href="dictionary"> &lt;&lt; Back to the dictionary</a>
<br>

<c:set var="titulo" value="Update word" scope="page"/>
<c:set var="boton" value="Update" scope="page"/>
<c:if test="${isNew}">
	<c:set var="titulo" value="Create word" scope="page"/>
	<c:set var="boton" value="Create" scope="page"/>
</c:if>

<h1>${titulo}</h1>

<form:form action="word/save" method="post" commandName="word">

	<c:if test="${!isNew}">
		<form:label path="id">id:</form:label> 
		<form:input path="id" readonly="true"/>
		<form:errors path="id" cssClass="error"/>
		<br><br>
	</c:if>
	
	<form:label path="word">Word:</form:label>
	<form:input path="word"/>
	<form:errors path="word"/>
	<br><br>
	
	<form:label path="meaning">Meaning:</form:label>
	<form:input path="meaning"/>
	<form:errors path="meaning" cssClass="error"/>
	<br><br>
	
	<input type="submit" value="${boton}">
</form:form>


<li><a href="dictionary">Cancelar</a></li>

<%@include file="../includes/footer.jsp" %>