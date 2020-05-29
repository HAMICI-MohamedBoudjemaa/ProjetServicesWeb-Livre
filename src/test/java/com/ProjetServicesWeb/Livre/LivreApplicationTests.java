package com.ProjetServicesWeb.Livre;
import com.ProjetServicesWeb.Livre.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

@SpringBootTest
class LivreApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private LivreRepository repository;

	@Autowired
	private LivreController livreController;

	@org.junit.Test
	public void testFindByIsbn() {
		Livre cree = new Livre("livre1","auteur1", "titre1", "editeur1", "edition1");
		livreController.create(cree);

		ResponseEntity<EntityModel<Livre>> entityLivre = livreController.findByIsbn("livre1");
		Livre livre = entityLivre.getBody().getContent();
		assertEquals(cree, livre);

		//assertThat(books).extracting(com.ProjetServicesWeb.Livre.Livre::getName).containsOnly("C++");

	}

	/*@org.junit.Test
	public void testFindAll() {
		Livre cree = new Livre("livre1","auteur1", "titre1", "editeur1", "edition1");
		livreController.create(cree);
		Livre cree2 = new Livre("livre2","auteur2", "titre2", "editeur2", "edition2");
		livreController.create(cree2);
		Livre cree3 = new Livre("livre3","auteur3", "titre3", "editeur3", "edition3");
		livreController.create(cree3);

		List<Livre> livre = livreController.getAll().getBody().getContent().stream().collect(Collectors.toList());
		assertTrue(livre.contains(cree) && livre.contains(cree2) && livre.contains(cree3));

		//assertThat(books).extracting(com.ProjetServicesWeb.Livre.Livre::getName).containsOnly("C++");

	}

	@org.junit.Test
	public void testModify() {
		Livre cree = new Livre("livre1","auteur1", "titre1", "editeur1", "edition1");
		livreController.create(cree);

		Livre cree2 = new Livre("livre1","auteur2", "titre2", "editeur2", "edition2");
		Livre livre = livreController.modify(cree2).getBody().getContent();
		assertEquals(cree2, livre);

		//assertThat(books).extracting(com.ProjetServicesWeb.Livre.Livre::getName).containsOnly("C++");

	}

	@org.junit.Test
	public void testDelete() {
		Livre cree = new Livre("livre1","auteur1", "titre1", "editeur1", "edition1");
		livreController.create(cree);

		int result = livreController.delete("livre1").getBody();
		assertEquals(1, result);

		//assertThat(books).extracting(com.ProjetServicesWeb.Livre.Livre::getName).containsOnly("C++");

	}*/
}
