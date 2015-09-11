package com.bankonet.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankonet.metier.IBankonetMetier;
import com.bankonet.metier.ReportService;
import com.bankonet.model.Client;

public class Test_TP5 {

	public static void main(String[] args) {


		// Chargement du conteneur Spring
		ApplicationContext  context = new ClassPathXmlApplicationContext("beans.xml");
		
		// Exercice 5.3 - apppel d'un bean metier déclaré par Annotations
		IBankonetMetier bankonetMetier1 = (IBankonetMetier) context.getBean("metier");
		
		// Exercice 5.4 - apppel d'un bean metier déclaré par configuration XML
		IBankonetMetier bankonetMetier2 = (IBankonetMetier) context.getBean("metier2");
		
		bankonetMetier1.listClients();
		bankonetMetier2.deleteClient(1);

	}

}
