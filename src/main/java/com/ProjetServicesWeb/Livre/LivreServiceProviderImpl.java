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
    public List<Livre> getAll() {
        return livreRepository.findAll();
    }

    @Override
    public Livre modify(Livre livre) {
        if(findByIsbn(livre.getIsbn())!=null)
        {
            return livreRepository.save(livre);
        }
        return null;
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
