package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Voiture;

@RestController
public class ItemController {
	
	@Autowired
	private VoitureRepository vr;
	
	@RequestMapping(path = "/voiture", method = RequestMethod.GET)
	public List<Voiture> getVoiture() {
		return vr.findAll();
	}
	
	/*
	 * @RequestMapping(path = "/voiture", params= {"name","color"} ,method =
	 * RequestMethod.GET) public List<Voiture>
	 * getFilterVoiture(@RequestParam("name") String name) {
	 * 
	 * return vr.findAll(name); }
	 */
	
	@RequestMapping(path = "/voiture", method = RequestMethod.POST)
	public String addVoiture(@RequestBody Voiture voiture) {
		vr.save(voiture);
		return voiture.getName();
	}
	
	@RequestMapping(path = "/voiture/{id}", method = RequestMethod.DELETE)
	public String deleteIdVoiture(@PathVariable Long id) {
		vr.deleteById(id);
		return "Voiture supprimer";
	}
	
	@RequestMapping(path = "/voiture/{id}", method = RequestMethod.PUT)
	public String majVoiture(@PathVariable Long id, @RequestBody Voiture voiture) {
		@SuppressWarnings("deprecation")
		Voiture v = vr.getById(id);
		v.setName(voiture.getName());
		v.setColor(voiture.getColor());
		v.setPrice(voiture.getPrice());
		vr.save(v);
		return "Voiture modifier";
	}
	
}
