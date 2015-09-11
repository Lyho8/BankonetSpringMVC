package com.bankonet.metier;

import com.bankonet.report.IReportGenerator;

public class ReportService {

	private IReportGenerator reportGenerator;
	private String auteur;
	
	
	public ReportService(){
		
	}
	// constructeur paramétré pour l'injection par constructeur
	public ReportService(IReportGenerator reportGenerator) {
		this.reportGenerator = reportGenerator;
	}

	public void generate() {
		reportGenerator.generate(getAuteur());
	}

	
	public IReportGenerator getReportGenerator() {
		return reportGenerator;
	}

	public void setReportGenerator(IReportGenerator reportGenerator) {
		this.reportGenerator = reportGenerator;
	}


	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
	
}
