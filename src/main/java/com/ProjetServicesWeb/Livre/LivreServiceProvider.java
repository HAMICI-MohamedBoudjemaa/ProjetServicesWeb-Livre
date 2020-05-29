package com.ProjetServicesWeb.Livre;

import com.ProjetServicesWeb.Livre.Livre;

import java.util.List;
import java.util.Optional;

public interface LivreServiceProvider {
    Livre create(final Livre livre);
    Optional<Livre> findByIsbn(String isbn);
    List<Livre> getAll();
    Livre modify(final Livre livre);
    int delete(String isbn);

}
