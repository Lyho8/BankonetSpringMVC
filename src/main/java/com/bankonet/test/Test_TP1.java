package com.bankonet.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankonet.metier.ReportService;

public class Test_TP1 {

	public static void main(String[] args) {

		// 1 - Chargement du conteneur Spring
		ApplicationContext  context = new ClassPathXmlApplicationContext("beans.xml");
				
		// 2 - Récupération d'un bean du conteneur		
		ReportService reportService = (ReportService) context.getBean("reportService");

		// 3 - Utilisation du bean
		reportService.generate();
	}

}
