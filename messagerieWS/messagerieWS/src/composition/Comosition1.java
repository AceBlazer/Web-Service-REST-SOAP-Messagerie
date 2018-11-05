package composition;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.axis2.AxisFault;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

import java.util.*;

import services.mail.MailServer;


public class Comosition1 {
	
	public  void spam (String top) throws RemoteException {
		
		MailServer ms = new MailServer();
		String msg;
		 /*int i=0;
	        while(i<ms.all.size()){*/
	        for (int i=0;i<ms.all.size();i++){
	        	if (ms.all.get(i).getTo().equals(top)){
	        		String fromp=ms.all.get(i).getFrom();        	
	        		for (int j=0;j<ms.users.size();j++){
	                	if ((ms.users.get(j).getNom().equals(fromp))&&(!"Admin".equals(fromp))){
	                		//u.setPassword(mail.users.get(j).getPassword());
	                		String spam=ms.users.get(j).getPassword();
	                		msg=ms.all.get(i).getMessage();
	        				if (msg.contains(spam)){
	        					ms.all.get(i).setIsNew(false);
	        					//ms.all.remove(ms.all.get(i));
	        					String res=ms.removeMessages(top);
	        					i--;
	        				}
	                	}
	        		}
	        	}
	        }        
	}
}
