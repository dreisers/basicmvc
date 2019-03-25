<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>bbsResult2.jsp</title>
</head>
<body>
  <h1>* 글쓰기 결과*</h1>
  작성자 : ${dto.wname }<br>
  제목   : ${dto.subject }<br>
  내용   : ${dto.content }<br>
  비밀번호 : ${dto.passwd }<br>   
  
</body>
</html>