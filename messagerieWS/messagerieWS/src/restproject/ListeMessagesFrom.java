package restproject;

import java.util.ArrayList;
import java.util.List;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import services.mail.*;


public class ListeMessagesFrom extends ServerResource{
	@Get  
	public String list() {
		String top = (String) getRequestAttributes().get("to");
		
        MailServer mail=new MailServer();
        String li="\n Liste des messages de "+top+"\n";
        for (Message m : mail.getMessages(top)) {
			li=li+"From ******** "+ m.getFrom() + "********* \n" + m.getMessage()+"\n";
		}  
        return li;
	}  

}
