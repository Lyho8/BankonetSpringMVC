package com.bankonet.spring;

import java.util.*;
import org.springframework.http.*;
import javax.validation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import com.bankonet.metier.*;
import com.bankonet.model.*;

import com.bankonet.model.Client;

@Controller
@RequestMapping(value = "rest")
public class BankonetRestController {

	@Autowired
	private IBankonetMetier metier;

	@RequestMapping(value = "/listClients", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Client> index() {
		return metier.listClients();
	}

	@RequestMapping(value = "/listClients/{key}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Client> search(@PathVariable String key) {
		return metier.chercherClients(key);
	}

	@RequestMapping(value = "/listClients", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void add(@RequestBody Client c) {
		metier.addClient(c);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") int id) {
		metier.deleteClient(id);
	}

}
