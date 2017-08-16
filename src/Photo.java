
import java.io.IOException;
import java.sql.Blob;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Photo extends HttpServlet
{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        try{
            
            String id=req.getParameter("n");
            ServletOutputStream o=resp.getOutputStream();
            ResultSet rs=db.Admin.getImage(id);
            rs.next();
            Blob blob=rs.getBlob(1);
            o.write(blob.getBytes(1,(int)blob.length()));
            
}catch(Exception ex){
        }
        }
}