package com.ProjetServicesWeb.Livre;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivreRepository extends JpaRepository<Livre, String> {
    //Livre modify(Livre livre);
    List<Livre> findByAuteur(final String auteur);
    List<Livre> findByTitre(final String titre);
    List<Livre> findByEditeur(final String editeur);
    List<Livre> findByEdition(final String edition);
}
