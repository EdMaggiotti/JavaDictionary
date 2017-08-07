<%@include file="../includes/header.jsp" %>
    <a href=""> &lt;&lt; Back to the index</a>
    <h2>Words</h2> 
    <c:forEach items="${words}" var="w">
    	<a href="word/detalle/${w.id}">
      		<c:out value="${w.word}"/> 
      		<i>--- <c:out value="${w.meaning}"/></i>
      	</a>
      	<a href="word/eliminar/${w.id}">
      		[X]
      	</a>          
      <br><br>
    </c:forEach>
    
     <hr>
    	<ol>
    		<li><a href="word/new">New word</a></li>
    	</ol>	
    <hr>

<%@include file="../includes/header.jsp" %>    