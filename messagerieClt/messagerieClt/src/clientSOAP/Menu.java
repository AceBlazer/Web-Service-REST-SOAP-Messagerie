package clientSOAP;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.apache.axis2.AxisFault;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

import java.util.*;
import java.util.concurrent.TimeUnit;

import services.mail.MailServerStub;
import services.mail.MailServerStub.*;


public class Menu {

	
	
	public static void main (String [] args) throws RemoteException {
		
		MailServerStub s = new MailServerStub();	
		Scanner reader = new Scanner(System.in);
		int choix;
		System.out.println("*** Authentifier");
		System.out.println("votre nom");
		String nom = reader.nextLine();
		System.out.println("votre e-mail");
		String email = reader.nextLine();
		System.out.println("votre mot de passe");
		String mdp = reader.nextLine();
		Authentifier a = new Authentifier();
		a.setEmail(email);
		a.setNom(nom);
		a.setPsw(mdp);
		System.out.println(s.authentifier(a).get_return());

		choix=0;
		while(choix!=6){
			System.out.println("1: envoyer *** 2: lire reçus *** 3: supprimer tous *** 4: supprimer ***5: Log out ***6: Fin Prog");
			System.out.println(nom+" is Active Now ");
			choix = reader.nextInt();
		    switch (choix) {
				case 1: 
					System.out.println("*** Send message");
					reader = new Scanner(System.in);
	
					SendMessage sm = new SendMessage();
					
					System.out.println("destinataire: ");
					String dest = reader.nextLine();
					System.out.println("message: ");
					String msg = reader.nextLine();
					
					sm.setFromp(nom);
					sm.setTop(dest);
					sm.setMessagep(msg);
					
					System.out.println(s.sendMessage(sm).get_return());
					break;
				
				case 2: 
					System.out.println("*** get messages");
					GetMessages gm = new GetMessages();
					gm.setTo(nom);
					for (MailServerStub.Message m : s.getMessages(gm).get_return()) {
						System.out.println(m.getFrom() + " " + m.getTo() + " " + m.getMessage());
					}
					break;
				
				case 3:  
					System.out.println("*** remove messages");
					RemoveMessages r = new RemoveMessages();
					r.setTo(nom);
					System.out.println(s.removeMessages(r).get_return());
					break;
				
				case 4:  
					System.out.println("*** supprimer un mail");
					System.out.println("Entrez le destinataire");
					reader = new Scanner(System.in);
					String desti = reader.nextLine();
					RemoveMessages rm = new RemoveMessages();
					rm.setTo(desti);
					System.out.println(s.removeMessages(rm).get_return());
					break;
					
				/*case 5: { 
					System.out.println("*** changer la priorité");
					ChangerPriorite cp = new ChangerPriorite();
					System.out.println("Entrez le source");
					String src = reader.nextLine();
					cp.setFrom(src);
					System.out.println(s.changerPriorite(cp).get_return());
					break;
				}*/
				case 5: 
					s = new MailServerStub();	
					reader = new Scanner(System.in);
					System.out.println("*** Authentifier");
					System.out.println("votre nom");
					nom = reader.nextLine();
					System.out.println("votre e-mail");
					email = reader.nextLine();
					System.out.println("votre mot de passe");
					mdp = reader.nextLine();
					a = new Authentifier();
					a.setEmail(email);
					a.setNom(nom);
					a.setPsw(mdp);
					System.out.println(s.authentifier(a).get_return());				
				
			}
		}
		
	}
	
	
}
