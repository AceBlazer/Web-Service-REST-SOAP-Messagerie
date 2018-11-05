package restproject;

import java.util.ArrayList;

import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import services.mail.*;
 
public class MessageSend extends ServerResource {
	
	@Post
    public Representation acceptItem(Representation entity) {  
		
		Representation result = null;  
        // Parse the given representation and retrieve data
        Form form = new Form(entity);  
        String fromp = form.getFirstValue("from");  
        String top = form.getFirstValue("to"); 
        String msgp = form.getFirstValue("msg"); 
        MailServer mail=new MailServer();
        result = new StringRepresentation(mail.sendMessage(fromp, top, msgp ),  
            MediaType.TEXT_PLAIN);
        return result;  
    } 
}  