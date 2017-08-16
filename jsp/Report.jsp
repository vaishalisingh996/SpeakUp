<%@page import="java.sql.ResultSet" %> 
<pre><h2>
<% 
    try
    {
        ResultSet rs=db.Admin.getData();
        while(rs.next())
              {
               out.println("Person Id :"+rs.getString(1));
               out.println("Name :"+rs.getString(2));
               out.println("<img src=Photo?n="+rs.getString(1)+" height=200 width=200 style="+"'border-radius:100px;border:2px solid orange;'>");
                          
              }
                           }catch(Exception ex){}
        %>
<a href="ngoblog.jsp"> Add new Blog </a>
</h2>
</pre>