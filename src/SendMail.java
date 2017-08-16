import java.sql.ResultSetMetaData;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Security;
import java.sql.CallableStatement;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.Admin;
public class SendMail extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); 
		try
		{
			   String id = request.getParameter("id");
			   String[] EMAILADDR = {Admin.getEmail(id)}; 
		       Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		       Properties props = new Properties();
		       props.put("mail.smtp.host", "smtp.gmail.com");
		       props.put("mail.smtp.auth", "true");
		       props.put("mail.debug", "true");
		       props.put("mail.smtp.port", "465");
		       props.put("mail.smtp.socketFactory.port", "465");
		       props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		       props.put("mail.smtp.socketFactory.fallback", "false");
		       Session ses = Session.getDefaultInstance(props,new javax.mail.Authenticator() {
		             protected PasswordAuthentication getPasswordAuthentication() {
		               return new PasswordAuthentication("deepika.14bit1051@abes.ac.in","dips1996");//Please Provide The Sender Address
		            }
		       });
		       ses.setDebug(true);
		       Message msgg = new MimeMessage(ses); // Multipurpose Internet Mail Extension 
		       InternetAddress addressFrom = new InternetAddress("vaishalisingh996");
		       msgg.setFrom(addressFrom);
		       InternetAddress[] ADDRESS_TO = new InternetAddress[EMAILADDR.length];
		       for (int i = 0; i < EMAILADDR.length; i++) {
		          ADDRESS_TO[i] = new InternetAddress(EMAILADDR[i]);
		       }
		       msgg.setRecipients(Message.RecipientType.BCC, ADDRESS_TO);
		      // Setting the Subject and Content Type
		       msgg.setSubject("Testing mail");
		       msgg.setContent("This is my testing mail", "text/html");
		       Transport.send(msgg);
		       out.println("Mail Send Successfully.");
		       String m = Admin.comp_status(id);
		       out.println(m);
		    } catch(Exception e){out.println(e);}

	}

}
