package com.ProjetServicesWeb.Livre;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivreRepository extends JpaRepository<Livre, String> {
    //Livre modify(Livre livre);
}
