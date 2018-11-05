package restproject;

import org.restlet.resource.Delete;
import org.restlet.resource.ServerResource;

import services.mail.MailServer;
import services.mail.Message;

public class DeletMessagesTo extends ServerResource{
	@Delete  
	public String list() {
		String top = (String) getRequestAttributes().get("to");	
        MailServer mail=new MailServer();
        return mail.removeMessages(top);
	}  

}
