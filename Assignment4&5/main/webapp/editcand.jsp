<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Candidate</title>
</head>
<body>
  <h2>Edit Candidate</h2>
  <jsp:useBean id="fcb" class="com.sunbeam.FindCandidateBean"/>
  <jsp:setProperty property="candId" name="fcb" param="id"/>
  ${fcb.findCandidate()}
  <form method="post" action="updatecand.jsp">
  <input type="hidden" name="id" value="${fcb.cand.id}"/>
 Name: <input type="text" name="name" value="${fcb.cand.name}"/>
 Party: <input type="text" name="party" value="${fcb.cand.party}"/>
     Votes: <input type="text" name="votes"  readonly="readonly" value="${fcb.cand.votes}"/>
  <br/>
  <input type="submit" value="Update"/>
  </form>
</body>
</html>