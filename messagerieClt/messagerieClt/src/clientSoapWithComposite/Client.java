package clientSoapWithComposite;

import java.rmi.RemoteException;
import java.util.Scanner;

import services.mail.CompositeStub;
import services.mail.CompositeStub.AccuseBienRecu;
import services.mail.CompositeStub.ChangePerior;

public class Client {

	public static void main(String[] args) throws RemoteException {
		
		CompositeStub s = new CompositeStub();	
		Scanner reader = new Scanner(System.in);
		
		System.out.println("votre nom");
		String nom = reader.nextLine();
		System.out.println("votre Expediteur");
		String exp = reader.nextLine();
		AccuseBienRecu acc = new AccuseBienRecu();
		
		acc.setExp(exp);
		acc.setNom(nom);
		System.out.println(s.accuseBienRecu(acc).get_return());
		
		ChangePerior chp= new ChangePerior();
		chp.setNom(nom);
		System.out.println(s.changePerior(chp).get_return());
		
	}

}
