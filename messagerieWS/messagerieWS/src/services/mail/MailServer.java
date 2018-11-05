package services.mail;

import java.text.SimpleDateFormat;
import java.util.*;


public class MailServer {
	public static List <Message> all = new ArrayList<Message>();
	public static List <User> users = new ArrayList<User>();
	static String nomUtilisateur="";
	
	
	public String sendMessage (String fromp, String top, String messagep) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Calendar cal = Calendar.getInstance();
		Message m = new Message(fromp,top,messagep,"low",true,sdf.format(cal.getTime()));
		all.add(m);
		return "Message sent successfully";
	}
	
	public List<Message> getMessages (String to) {

		//all.add(new Message("Admin",nomUtilisateur,"Bienvenue à notre service :)","low",true,"undefined")); // pour eviter null pointer exception en cas de boite vide
		List <Message> aux = new ArrayList<Message>();
		for(int i=0; i<all.size();i++) {
			if (all.get(i).getTo().equals(to)) {
				aux.add(all.get(i));
				if (all.get(i).getIsNew()==true) {
				all.get(i).setIsNew(false);
				}
			}
		}
		return aux;
	}
	
	
	/*public String changerPriorite (String from) {
		for(int i=0; i<all.size();i++) {
			if(all.get(i).getPriorite().equals("low")) {
				all.get(i).setPriorite("high");
			}
			else {
				all.get(i).setPriorite("low");
			}
		}
		return "priority changed";
	}
	*/
	public String removeMessages (String to) {
		int oldMessageNumber=0;
		
		for(int i=0; i<all.size();i++) {
			if(all.get(i).getTo().equals(to)) {
				if (all.get(i).getIsNew()==false){
				oldMessageNumber++;
				all.remove(all.get(i));
				}
			}
		}
		if(oldMessageNumber==0)
			return "no old messages";
		else
			return "old messages removed successfully";
		
	}
	
	
	public String authentifier (String nom, String email, String psw) {
		//String name="";
		
		for(int i=0; i<users.size();i++) {
			if(users.get(i).getEmail().equals(email) && users.get(i).getPassword().equals(psw)) {
				nomUtilisateur=nom;
				return "Bienvenue "+nom;
			}
		}
		
		User u = new User(nom,email,psw);
		users.add(u);
		nomUtilisateur=nom;
		
		all.add(new Message("Admin",nomUtilisateur,"Bienvenue à notre service :)","low",true,"undefined")); // pour eviter null pointer exception en cas de boite vide
		return "utilisateur ajouté avec succès";
	}
		
}
