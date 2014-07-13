package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.ReceivedDateTerm;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SendMailServlet")
public class SendMailServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<body>");

		String ad = request.getParameter("address");
		String msg = request.getParameter("msg");
		try {
			// Attach Mail Jar
			// Create Properties Object
			Properties prop;
			prop = System.getProperties();
			prop.put("mail.smtp.host", "smtp.gmail.com");
			prop.put("mail.smtp.port", "587");
			prop.put("mail.smtp.starttls.enable", "true");
			prop.put("mail.smtp.auth", "true");

			// Create Authentication Object
			MyAuthenticator ma = new MyAuthenticator("hacked.fused@gmail.com",
					"hackingisnotpersonal");
			// Establish Session
			Session s = Session.getInstance(prop, ma);
			// Create Message
			Message m = new MimeMessage(s);

			// array for address of recipeints
			InternetAddress[] adds = { new InternetAddress(ad),
					new InternetAddress("gurneetsinghbedi@gmail.com") };

			m.setRecipients(RecipientType.TO, adds);
			// m.setRecipient(RecipientType.TO, new InternetAddress(ad));
			m.setFrom(new InternetAddress("hacked.fused@gmail.com"));
			m.setSubject("Java Mail from CMC New Delhi");

			// Send Message
			// Create Multipart
			MimeMultipart mp = new MimeMultipart();
			// Create body part
			MimeBodyPart bp = new MimeBodyPart();
			bp.setText(msg);

			// Create body part fro attachment
			MimeBodyPart bpAttach = new MimeBodyPart();
			bpAttach.attachFile(new File("C:/Users/y7rmth/Desktop/angry.png"));

			mp.addBodyPart(bp);
			mp.addBodyPart(bpAttach);

			m.setContent(mp);

			Transport.send(m);
			out.println("<h1>Mail Sent</h1> ");
		} catch (AddressException ae) {
			out.println("Address Exception " + ae.getMessage());
		} catch (MessagingException e) {
			out.println("Messaging Exception " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			out.println("Exception " + e.getMessage());
		}

		out.println("</body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
