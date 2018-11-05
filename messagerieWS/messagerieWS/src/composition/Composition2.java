package composition;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import org.apache.axis2.AxisFault;

import services.mail.MailServer;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

import java.util.*;



public class Composition2 {
	
	public  void accuse (String exp, String nom) throws RemoteException {
		
		MailServer ms = new MailServer();		

		for (int i=0;i<ms.all.size();i++) {
			if(ms.all.get(i).getFrom().equals(exp)) {
				ms.sendMessage(nom,exp,"Bien reçu !");
			}
			else {			
				ms.all.get(i).setIsNew(false);
				String to=ms.all.get(i).getTo();
				String res=ms.removeMessages(to);//on p pas suppr le msg avant etre lire 
				i--;
				}
			}
		}
		
		
		
		
	}

