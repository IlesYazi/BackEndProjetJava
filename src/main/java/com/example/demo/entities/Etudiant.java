package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Etudiant {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private Integer age;
	private String sexe;
	private Integer idProf;
	
	
	public Etudiant(String firstName, String lastName, Integer age,String sexe, Integer idProf) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.sexe = sexe;
		this.idProf = idProf;
	}
	
	
	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public String getSexe() {
		return sexe;
	}


	public void setSexe(String sexe) {
		this.sexe = sexe;
	}


	public Integer getIdProf() {
		return idProf;
	}


	public void setIdProf(Integer idProf) {
		this.idProf = idProf;
	}
	
}
