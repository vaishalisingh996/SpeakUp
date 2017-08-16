<body color=lightyellow>
 <form action=Validate.jsp method=post>
  <pre>
   <%
      String t = request.getParameter("t");
      if(t!=null)
    	  out.print("Sorry this is Invalid Login Id & Password, re-enter Plz....");
   %>
   
     User Id  <input type=text name=uid />
     
     Password <input type=password name=ps />
     
        <input type=submit value='Sign In' /> 
  </pre>
 </form> 
</body>