package restproject;

import java.util.Scanner;

import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import services.mail.MailServer;

public class UserLoginREST extends ServerResource {
	@Post
	public Representation acceptItem(Representation entity) {  
			
		Representation result = null;  
        // Parse the given representation and retrieve data
        Form form = new Form(entity);  
        String nomp = form.getFirstValue("nom");  
        String emailp = form.getFirstValue("email"); 
        String mdpp = form.getFirstValue("mdp");
        
        MailServer s=new MailServer();
        result = new StringRepresentation(s.authentifier(nomp,emailp,mdpp),  
            MediaType.TEXT_PLAIN);
        return result;  
	 } 

}
