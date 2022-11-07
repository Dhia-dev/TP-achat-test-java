package com.esprit.examen.services;

import java.text.ParseException; 
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Operateur;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@TestMethodOrder(OrderAnnotation.class)
public class OperateurServiceImplTest {
	
	@Autowired
	IOperateurService OP;
	
	
	@Test
	@Order(1)
	public void testAddOperateur() throws ParseException {
		Operateur P = new Operateur();
		P.setIdOperateur(3);
		P.setNom("samir");
		P.setPrenom("ounifii");
		P.setPassword("abcd");
		OP.addOperateur(P);
		log.info("Operateur ajouter avec success");
	}
	
	@Test
	@Order(2)
	public void testModifierOperateur() throws ParseException {
		Operateur P = new Operateur();
		P.setIdOperateur(2);
		P.setNom("samirr");
		P.setPrenom("ounifii");
		P.setPassword("abcd");
		OP.addOperateur(P);
		log.info("Operateur ajouter avec success");
		P.setNom("dhia");
		P.setPrenom("mejriII");
		P.setPassword("abcdf");
		OP.updateOperateur(P);
		log.info("Operateur modifier avec success");
	}
	
	
	
	@Test
	@Order(3)
	public void testDeleteOperateur() throws ParseException {
		Operateur P = new Operateur();
		
		P.setIdOperateur(1);
		P.setNom("dhia");
		P.setPrenom("mejri");
		P.setPassword("abcdf");
		OP.addOperateur(P);
		OP.deleteOperateur(P.getIdOperateur());
		log.info("categorie supprimer avec success");
	}
	
	
	@Test
	@Order(4)
	
	public void testRetrieveAllOperateur() throws ParseException {
		List<Operateur> listOperateur = OP.retrieveAllOperateurs();
		Assertions.assertNotEquals(0, listOperateur.size());
		log.info("Nombre categorie: " + listOperateur.size()+" \n");
		for(int i=0;i<listOperateur.size();i++){
			log.info(""+listOperateur.get(i).getNom());
		}
	}

	
}
