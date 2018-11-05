package services.mail;

import java.rmi.RemoteException;
import java.util.Scanner;

import org.apache.axis2.AxisFault;

import composition.Comosition1;
import composition.Composition2;


public class Composite {

	Comosition1 c1 = new Comosition1();
	Composition2 c2 = new Composition2();
	
	public String ChangePerior(String nom){
		MailServer ms=new MailServer();
		System.out.println("*** mettre priorité haute entre 20h et 24h");
		for (int i=0;i<ms.all.size();i++) {
			if (ms.all.get(i).getTo().equals(nom)){
			if(ms.all.get(i).getSendTime().startsWith("20") || ms.all.get(i).getSendTime().startsWith("21") || ms.all.get(i).getSendTime().startsWith("22")|| ms.all.get(i).getSendTime().startsWith("23") || ms.all.get(i).getSendTime().startsWith("00")) {
				ms.all.get(i).setPriorite("high");
			}
			}
		}
		return"la modification de la periorite est succes";
	}
	
	public String removeSpam(String top){
		try {
			c1.spam(top);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return"Spam delete succesfuly";
	}
	
	public String accuseBienRecu(String exp,String nom){
		try {
			c2.accuse(exp, nom);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "msg Bien Envoyer";
	}
}