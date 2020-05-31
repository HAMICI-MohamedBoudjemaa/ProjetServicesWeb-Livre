package com.ProjetServicesWeb.Livre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivreServiceProviderImpl implements LivreServiceProvider{

    @Autowired
    private LivreRepository livreRepository;

    @Override
    public Livre create(Livre livre) {
        return livreRepository.save(livre);
    }

    @Override
    public Optional<Livre> findByIsbn(String isbn) {
        return livreRepository.findById(isbn);
    }

    @Override
    public List<Livre> findByAuteur(String auteur) {
        return livreRepository.findByAuteur(auteur);
    }

    @Override
    public List<Livre> findByTitre(String titre) {
        return livreRepository.findByTitre(titre);
    }

    @Override
    public List<Livre> findByEditeur(String editeur) {
        return livreRepository.findByEditeur(editeur);
    }

    @Override
    public List<Livre> findByEdition(String edition) {
        return livreRepository.findByEdition(edition);
    }

    @Override
    public List<Livre> getAll() {
        return livreRepository.findAll();
    }

    @Override
    public Livre modify(Livre livre) {
        if(findByIsbn(livre.getIsbn())!=null)
        {
            return livreRepository.save(livre);
        }
        return new Livre();
    }

    @Override
    public int delete(String isbn) {
        Optional<Livre> livre = findByIsbn(isbn);
        Livre myLivre = livre.orElse(null);
        if(findByIsbn(isbn)!=null){
            livreRepository.delete(myLivre);
            return 1;
        }
        return 0;
    }


}
