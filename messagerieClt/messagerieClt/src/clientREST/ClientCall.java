package clientREST;

import java.io.IOException;
 



import java.util.Scanner;

import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import services.mail.MailServerStub.RemoveMessages;


 
public class ClientCall {
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		// Create the client resource  
		//********************Authentification******************************
			int choix;
			Scanner reader = new Scanner(System.in);
			System.out.println("*** Authentifier");
			System.out.println("votre nom");
			String nom = reader.nextLine();
			System.out.println("votre e-mail");
			String email = reader.nextLine();
			System.out.println("votre mot de passe");
			String mdp = reader.nextLine();
			ClientResource resourceAuth = new ClientResource("http://localhost:8185/login");  

			Form formAuth = new Form();  
			formAuth.add("nom", nom);  
			formAuth.add("email", email);
			formAuth.add("mdp", mdp);
	
			try {	
				resourceAuth.post(formAuth).write(System.out);
			} catch (ResourceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			choix=6;
			while(choix!=7){
				System.out.println("\n 1: envoyer *** 2: lire reçus *** 3: supprimer tous *** 4: supprimer *** 5: Delete your msg with spam *** 6: Log out **** 7:QuitterProg");
				System.out.println(nom+" is Active Now ");
				choix = reader.nextInt();
			    switch (choix) {
					
				//********************Envoyer un message****************************
					case 1: 
						ClientResource resourceSend = new ClientResource("http://localhost:8185/send");  
						System.out.println("*** send Message");
						reader = new Scanner(System.in);

						System.out.println("to");
						String top = reader.nextLine();
						System.out.println("ecrit un message");
						String msgp = reader.nextLine();
						
						Form formSend = new Form();  
						formSend.add("from", nom);  
						formSend.add("to", top);
						formSend.add("msg", msgp);
						
						try {	
							resourceSend.post(formSend).write(System.out);
								 
						} catch (ResourceException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}  
						break;
	
				//********************Liste des messsages***************************
					case 2:
						System.out.println("*** get messages");
						
						ClientResource resourceListe = new ClientResource("http://localhost:8185/list/"+nom);  
					
						try {
							resourceListe.get().write(System.out);
						} catch (ResourceException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
						
			    //***************Delete tous les messages recu *********************
					
					case 3:
						ClientResource resourceDel = new ClientResource("http://localhost:8185/delete/"+nom); 
						//Form formDel = new Form();  
						//formDel.add("to", nom);
						try {	
							resourceDel.delete().write(System.out);
								 
						} catch (ResourceException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
						break;
					case 4:
						System.out.println("*** supprimer un mail");
						System.out.println("Entrez le destinataire");
						reader = new Scanner(System.in);
						String desti = reader.nextLine();
						ClientResource resourceDelSpec = new ClientResource("http://localhost:8185/delete/"+desti); 
						try {	
							resourceDelSpec.delete().write(System.out);
								 
						} catch (ResourceException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 5:
						ClientResource resourceDelSpa = new ClientResource("http://localhost:8185/delSpa/"+nom); 
						try {	
							resourceDelSpa.delete().write(System.out);
								 
						} catch (ResourceException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 6: 
						reader = new Scanner(System.in);
						System.out.println("*** Authentifier");
						System.out.println("votre nom");
						nom = reader.nextLine();
						System.out.println("votre e-mail");
						email = reader.nextLine();
						System.out.println("votre mot de passe");
						mdp = reader.nextLine();
						resourceAuth = new ClientResource("http://localhost:8185/login");  
	
						formAuth = new Form();  
						formAuth.add("nom", nom);  
						formAuth.add("email", email);
						formAuth.add("mdp", mdp);
				
						try {	
							resourceAuth.post(formAuth).write(System.out);
							} catch (ResourceException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						break;
						//choix=1;
						
					
			    }	
					
			}
		}
	}
}