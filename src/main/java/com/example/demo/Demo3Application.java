package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.EtudiantRepository;
import com.example.demo.dao.ProfRepository;
import com.example.demo.dao.VoitureRepository;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Prof;
import com.example.demo.entities.Voiture;

@SpringBootApplication
public class Demo3Application implements CommandLineRunner {
	
	@Autowired
	private VoitureRepository vr;
	@Autowired
	private ProfRepository prof;
	@Autowired
	private EtudiantRepository etudiant;
	
	public static void main(String[] args) {
		SpringApplication.run(Demo3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		String [] myCouleur = { "Rouge", "Bleu", "Vert", "Jaune", "Orange"};
		System.out.println("hello world");
		
		vr.save(new Voiture("Voiture100",100000.00,"Rouge"));
		prof.save(new Prof("Iles","YAZI","developer"));
		etudiant.save(new Etudiant("Yvann","DE SOUZA",22,"Male",1));
		
		System.out.println("Les données sont bien enregistré");
		
		
		
		//creer 99 voitures
		for (int i=0; i<10; i++) {
			vr.save(new Voiture("Voiture"+ myCouleur[(int)(Math.random()*4)]+i,(double)(Math.random()*(100000-10000)),myCouleur[(int)(Math.random()*4)]));
		}
		
		//creer 19 professeur
		for (int i=0; i<20; i++) {
			prof.save(new Prof("Prof "+i,"estiam","specialite"+i));
		}
		
		//creer etudiant
		for (int i=1; i<22; i++) {
			int k =0 + i;
			for (int j=0; j<5; j++) {
				etudiant.save(new Etudiant("Etudiant"+j+k,"ESTIAM",(20+j),"Male",i));
			}
		}
		
        vr.findAll().forEach(v->{
        	System.out.println( "Name : " +v.getName() +" // "+ "Price : "+ v.getPrice() + " // "+ "Color : "+v.getColor());
        });
        
        prof.findAll().forEach(p->{
        	System.out.println( "FirstName : " +p.getFirstName() +" // "+ "LastName : "+ p.getLastName() + " // "+ "Specialite : "+p.getSpecialite());
        });
        
        etudiant.findAll().forEach(e->{
        	System.out.println( "Id Prof : "+e.getIdProf() + " // "+ "FirstName : " +e.getFirstName() +" // "+ "LastName : "+ e.getLastName() + " // "+ "Sexe : "+e.getSexe()+ " // "+ "Age : "+e.getAge());
        });
	}

}
