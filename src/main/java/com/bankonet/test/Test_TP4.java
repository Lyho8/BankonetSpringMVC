package com.bankonet.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankonet.metier.ReportService;
import com.bankonet.model.Client;

public class Test_TP4 {

	public static void main(String[] args) {


		// Chargement du conteneur Spring
		ApplicationContext  context = new ClassPathXmlApplicationContext("beans.xml");
				
		Client client1 = (Client) context.getBean("client");
		
		System.out.println(client1.toString());
		

	}

}
