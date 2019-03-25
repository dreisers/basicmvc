<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>bbs/bbsForm.jsp</title>
</head>
<body>
<h3>* 글쓰기 *</h3>
<p><a href="bbsList.jsp">[글목록]</a></p>
<form name="bbsfrm"
      method="post"
      action="create.do">
<table border="1">
<tr>
    <th>작성자</th>
    <td><input type="text" name="wname" size="10" maxlength="20" required></td>
</tr> 
<tr>
    <th>제목</th>
    <td><input type="text" name="subject" size="20" maxlength="100" required></td>
</tr> 
<tr>
    <th>내용</th>
    <td>
      <textarea rows="5" cols="30" name="content"></textarea>
    </td>
</tr> 
<tr>
    <th>비밀번호</th>
    <td><input type="password" name="passwd" size="10" maxlength="10" required></td>
</tr> 
<tr>
    <td colspan="2" align="center">
      <input type="submit" value="쓰기">
      <input type="reset" value="취소">
    </td>
</tr> 
</table>
</form>
</body>
</html>