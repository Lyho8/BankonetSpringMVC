package com.bankonet.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankonet.metier.IBankonetMetier;
import com.bankonet.metier.ReportService;
import com.bankonet.model.Adresse;
import com.bankonet.model.Client;

public class Test_TP6 {


	public static void main(String[] args) {


		// Chargement du conteneur Spring
		ApplicationContext  context = new ClassPathXmlApplicationContext("beans.xml");
		
	    
	    IBankonetMetier bankonetMetier1 = (IBankonetMetier) context.getBean("metier");
	    System.out.println(bankonetMetier1.listClients());
	 
	    try {
			bankonetMetier1.addClient(new Client("Fabien","GUIBERT","log2","mdp2",new Adresse(36, "avenue Cyrnos", "Paris")));
			bankonetMetier1.addClient(new Client("Jean","DURAND","loginjean","mdp3",new Adresse(47, "rue Bidon", "Nantes")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    System.out.println(bankonetMetier1.listClients());
	      
	  //bankonetMetier1.SupprimerClientDontLeNomContient("fab");
	    
	    
	
	    
	}

}
