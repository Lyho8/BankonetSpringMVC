package com.bankonet.spring;

import java.util.*;
import javax.validation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import com.bankonet.metier.*;
import com.bankonet.model.*;

@Controller
public class BankonetController {

	@Autowired
	private IBankonetMetier metier;
	
	@Autowired
	private MessageSource messageSource;

	public IBankonetMetier getMetier() {
		return metier;
	}

	public void setMetier(IBankonetMetier metier) {
		this.metier = metier;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		List<Client> clients = metier.listClients();
		model.addAttribute("clients", clients);
		model.addAttribute("client", new Client());

		return "clientsview";
	}

	@RequestMapping(value = "/saveClient")
	public String saveClient(@Valid Client c, BindingResult bindingResult, Model model, Locale local) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("clients", metier.listClients());
			return "clientsview";
		}
		metier.updateClient(c);
		List<Client> clients = metier.listClients();
		model.addAttribute("clients", clients);
		model.addAttribute("client", new Client());
		String s1 = messageSource.getMessage("page.clientsviews.save1", null, local);
		String s2 = messageSource.getMessage("page.clientsviews.save2", null, local);
		model.addAttribute("msg", s1 + c.getId() + " " + s2);
		
		return "clientsview";
	}
	
	@RequestMapping(value = "/editClient/{idClient}")
	public String editClient(@PathVariable int idClient, Model model, Locale local) {
		List<Client> clients = metier.listClients();
		Client c = metier.editClient(idClient);
		model.addAttribute("clients", clients);
		model.addAttribute("client", c);
		
		String s1 = messageSource.getMessage("page.clientsviews.edit1", null, local);
		String s2 = messageSource.getMessage("page.clientsviews.edit2", null, local);
		model.addAttribute("msg", s1 + idClient + " " + s2);

		return "clientsview";
	}
	
	@RequestMapping(value = "/deleteClient", method = RequestMethod.GET)
	public String deleteClient(@RequestParam int id, Model model, Locale local) {
		
		metier.deleteClient(id);
		List<Client> clients = metier.listClients();		
		model.addAttribute("clients", clients);
		model.addAttribute("client", new Client());
		
		String s1 = messageSource.getMessage("page.clientsviews.del1", null, local);
		String s2 = messageSource.getMessage("page.clientsviews.del2", null, local);
		model.addAttribute("msg", s1 + id + " " + s2);

		return "clientsview";
	}
	
}
