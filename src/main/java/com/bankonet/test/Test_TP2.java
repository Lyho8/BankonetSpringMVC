package com.bankonet.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankonet.metier.ReportService;
import com.bankonet.model.Client;

public class Test_TP2 {

	public static void main(String[] args) {

		
		// 1 - Chargement du conteneur Spring
		ApplicationContext  context = new ClassPathXmlApplicationContext("beans.xml");
				
		// 2 - Récupération de 2 beans du conteneur		
		ReportService reportService1 = (ReportService) context.getBean("reportService");
		ReportService reportService2 = (ReportService) context.getBean("reportService");

		// 3 - Utilisation des beans
		reportService1.setAuteur("Fabien");
		reportService2.setAuteur("Toto");
		
		reportService1.generate();
		reportService2.generate();
		
		
		
	}

}
