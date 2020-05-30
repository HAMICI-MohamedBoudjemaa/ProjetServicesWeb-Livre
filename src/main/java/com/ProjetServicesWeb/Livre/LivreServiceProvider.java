package com.ProjetServicesWeb.Livre;

import com.ProjetServicesWeb.Livre.Livre;

import java.util.List;
import java.util.Optional;

public interface LivreServiceProvider {
    Livre create(final Livre livre);
    Optional<Livre> findByIsbn(String isbn);
    List<Livre> findByAuteur(String auteur);
    List<Livre> findByTitre(String titre);
    List<Livre> findByEditeur(String editeur);
    List<Livre> findByEdition(String edition);
    List<Livre> getAll();
    Livre modify(final Livre livre);
    int delete(String isbn);

}
