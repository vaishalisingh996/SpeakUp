 <%@page import="db.Admin"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
<form action="" method="post">  
  <div class="frm" style="width:280px;">
    <table width="100%" border="0">
     <tr>
        <td class="lbl">Name<td><input type="text" class="fld" name="name" />       
     </tr>  
     <tr>
        <td class="lbl">EMAIL<td><input type="text" class="fld" name="email" />       
     </tr> 
     <tr>
        <td class="lbl">Mobile<td><input type="text" class="fld" name="mobile" />       
     </tr>  
    <tr>
        <td class="lbl">Complain Message<td><textarea class="fld" style="height:70px;" name="msg" ></textarea>       
     </tr> 
     <tr>
         <th colspan="2"><input type="submit" value=" C O M P L A I N " /> <input type="reset" value=" C l e a r " />      
     </tr>
          
   </table> 
   </div>
   
   <%
String name = request.getParameter("name");
String email = request.getParameter("email");
String mobile = request.getParameter("mobile");
String msg = request.getParameter("msg");

     if(name!=null && email!=null && mobile!=null){
 
String m = Admin.addcomplain(name, email, mobile, msg);
out.println(m);
     }
%>
   
    
   </form>
</body>
</html>