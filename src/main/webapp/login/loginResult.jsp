<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>loginResult.jsp</title>
</head>
<body>
	<h1>* 로그인 결과  *</h1>
	1)JSP<br>
	<%=request.getAttribute("msg") %><br>
	아이디 : <%=request.getAttribute("r_id") %><br>
	비밀번호 : <%=request.getAttribute("r_pw") %><br>
	아이디(세션) : <%=session.getAttribute("s_id") %><br>
	비밀번호(세션) : <%=session.getAttribute("s_pw") %><br>
	
	<hr>
	2)EL<br>
	${msg }<br>
	아이디 ${r_id}<br>
	비밀번호 ${r_pw}<br>
	아이디(세션) ${s_id}<br>
	비밀번호(세션) ${s_pw}<br>
</body>
</html>