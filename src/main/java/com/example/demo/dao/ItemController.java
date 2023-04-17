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

import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Prof;
import com.example.demo.entities.Voiture;

@RestController
public class ItemController {
	
	/*
	 * @RequestMapping(path = "/voiture", params= {"name","color"} ,method =
	 * RequestMethod.GET) public List<Voiture>
	 * getFilterVoiture(@RequestParam("name") String name) {
	 * 
	 * return vr.findAll(name); }
	 */
	
	@Autowired
	private VoitureRepository vr;
	
	@Autowired
	private ProfRepository prof;
	
	@Autowired
	private EtudiantRepository etud;
	
	/* -------------- VOITURE -------------- */
	
	@RequestMapping(path = "/voiture", method = RequestMethod.GET)
	public List<Voiture> getVoiture() {
		return vr.findAll();
	}
	
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
	
	/* -------------- PROFESSEUR -------------- */
	
	@RequestMapping(path = "/professeur", method = RequestMethod.GET)
	public List<Prof> getProfesseur() {
		return prof.findAll();
	}
	
	@RequestMapping(path = "/professeur", method = RequestMethod.POST)
	public String addProfesseur(@RequestBody Prof professeur) {
		prof.save(professeur);
		return professeur.getFirstName();
	}
	
	@RequestMapping(path = "/professeur/{id}", method = RequestMethod.DELETE)
	public String deleteIdProfesseur(@PathVariable Long id) {
		prof.deleteById(id);
		return "Professeur supprimer";
	}
	
	@RequestMapping(path = "/professeur/{id}", method = RequestMethod.PUT)
	public String majProfesseur(@PathVariable Long id, @RequestBody Prof professeur) {
		@SuppressWarnings("deprecation")
		Prof p = prof.getById(id);
		p.setFirstName(professeur.getFirstName());
		p.setLastName(professeur.getLastName());
		p.setSpecialite(professeur.getSpecialite());
		prof.save(p);
		return "Professeur modifier";
	}
	
	/* -------------- ETUDIANT -------------- */
	
	@RequestMapping(path = "/etudiant", method = RequestMethod.GET)
	public List<Etudiant> getEtudiant() {
		return etud.findAll();
	}
	
	@RequestMapping(path = "/etudiant", method = RequestMethod.POST)
	public String addEtudiant(@RequestBody Etudiant etudiant) {
		etud.save(etudiant);
		return etudiant.getFirstName();
	}
	
	@RequestMapping(path = "/etudiant/{id}", method = RequestMethod.DELETE)
	public String deleteIdEtudiant(@PathVariable Long id) {
		etud.deleteById(id);
		return "Etudiant supprimer";
	}
	
	@RequestMapping(path = "/etudiant/{id}", method = RequestMethod.PUT)
	public String majEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiant) {
		@SuppressWarnings("deprecation")
		Etudiant e = etud.getById(id);
		e.setFirstName(etudiant.getFirstName());
		e.setLastName(etudiant.getLastName());
		e.setAge(etudiant.getAge());
		e.setSexe(etudiant.getSexe());
		e.setIdProf(etudiant.getIdProf());
		etud.save(e);
		return "Etudiant modifier";
	}
}
