package restproject;

import org.restlet.resource.Delete;
import org.restlet.resource.ServerResource;

import services.mail.Composite;
import services.mail.MailServer;
import services.mail.User;

public class DeleteMsgWithSpam extends ServerResource{
	@Delete  
	public String DelSpam() {
		String top = (String) getRequestAttributes().get("to");	
		Composite c=new Composite();
		//User u=new User();
        MailServer mail=new MailServer();
        /*for (int i=0;i<mail.users.size();i++){
        	if (mail.users.get(i).getNom().equals(top)){
        		u.setPassword(mail.users.get(i).getPassword());
        	}
        }*/
        String res="no spam";
        /*int i=0;
        while(i<mail.all.size()){
        //for (int i=0;i<mail.all.size();i++){
        	if (mail.all.get(i).getTo().equals(top)){
        		String fromp=mail.all.get(i).getFrom();        	
        		for (int j=0;j<mail.users.size();j++){
                	if ((mail.users.get(j).getNom().equals(fromp))&&(!"Admin".equals(fromp))){
                		//u.setPassword(mail.users.get(j).getPassword());
                		String spam=mail.users.get(j).getPassword();
                		res=c.removeSpam(top);
                	}
        		}
        	}
        	else{
        		i++;
        	}
        }  */    
        
        return c.removeSpam(top);
	}
}