package com.bankonet.spring;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.bankonet.metier.*;
import com.bankonet.model.*;

@Controller
@RequestMapping(value = "comptes/{idClient}")
public class BankonetCompteController {
	
	@Autowired
	private IBankonetMetier oldmetier;
	
	@Autowired
	private IBankonetCompteMetier metier;
	
	@Autowired
	private MessageSource messageSource;

	public IBankonetCompteMetier getMetier() {
		return metier;
	}

	public void setMetier(IBankonetCompteMetier metier) {
		this.metier = metier;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(@PathVariable int idClient, Model model) {
		List<Compte> comptes = metier.listComptes(idClient);
		model.addAttribute("comptes", comptes);
		model.addAttribute("client", oldmetier.editClient(idClient));

		return "comptes";
	}
	
	@RequestMapping(value = "/addCompteE", method = RequestMethod.GET)
	public String addE(@PathVariable int idClient, Model model) {
		Client cl = oldmetier.editClient(idClient);
		
		model.addAttribute("compte", new Compte());

		return "compteseview";
	}
	
	@RequestMapping(value = "/addCompteC", method = RequestMethod.GET)
	public String addC(@PathVariable int idClient, Model model) {
		model.addAttribute("client", oldmetier.editClient(idClient));

		return "comptescview";
	}

	@RequestMapping(value = "/saveCompte", method = RequestMethod.POST)
	public String saveCompte(@Valid Compte c, BindingResult bindingResult, Model model, Locale local) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("clients", metier.listComptes());
			return "clientsview";
		}
		metier.updateCompte(c);
		List<Compte> clients = metier.listComptes();
		model.addAttribute("clients", clients);
		model.addAttribute("client", new Compte());
		String s1 = messageSource.getMessage("page.clientsviews.save1", null, local);
		String s2 = messageSource.getMessage("page.clientsviews.save2", null, local);
		model.addAttribute("msg", s1 + c.getId() + " " + s2);
		
		return "comptes";
	}
	
	@RequestMapping(value = "/editCompte/{idCompte}")
	public String editCompte(@PathVariable int idCompte, Model model, Locale local) {
		List<Compte> clients = metier.listComptes();
		Compte c = metier.editCompte(idCompte);
		model.addAttribute("clients", clients);
		model.addAttribute("client", c);
		
		String s1 = messageSource.getMessage("page.clientsviews.edit1", null, local);
		String s2 = messageSource.getMessage("page.clientsviews.edit2", null, local);
		model.addAttribute("msg", s1 + idCompte + " " + s2);

		return "comptes";
	}
	
	@RequestMapping(value = "/deleteCompte", method = RequestMethod.GET)
	public String deleteCompte(@RequestParam int id, Model model, Locale local) {
		
		metier.deleteCompte(id);
		List<Compte> clients = metier.listComptes();		
		model.addAttribute("clients", clients);
		model.addAttribute("client", new Compte());
		
		String s1 = messageSource.getMessage("page.clientsviews.del1", null, local);
		String s2 = messageSource.getMessage("page.clientsviews.del2", null, local);
		model.addAttribute("msg", s1 + id + " " + s2);

		return "comptes";
	}

}
