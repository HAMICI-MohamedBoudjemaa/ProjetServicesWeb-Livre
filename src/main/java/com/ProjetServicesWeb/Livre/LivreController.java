package com.ProjetServicesWeb.Livre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.EntityModel;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/livres")
public class LivreController {
    @Autowired
    private LivreServiceProvider livreServiceProvider;

    @GetMapping("{isbn}")
    public ResponseEntity<EntityModel<Livre>> findByIsbn(@PathVariable("isbn") String isbn){
        Optional<Livre> cree = livreServiceProvider.findByIsbn(isbn);
        Livre livre = cree.orElse(new Livre());
        Link lien = linkTo(methodOn(LivreController.class).findByIsbn(isbn)).withSelfRel();
        return new ResponseEntity<>(new EntityModel<>(livre, lien), CREATED);
    }

    /*@GetMapping
    public ResponseEntity<CollectionModel<Livre>> getAll(){
        List<Livre> cree = livreServiceProvider.getAll();
        Link lien = linkTo(methodOn(LivreController.class).getAll()).withSelfRel();
        return new ResponseEntity<CollectionModel<Livre>>(new CollectionModel<>(cree, lien), CREATED);
    }*/

    @GetMapping
    public ResponseEntity<CollectionModel<Livre>> findBy(@RequestParam(value = "auteur", required = false) String auteur,
                                                         @RequestParam(value = "titre", required = false) String titre,
                                                         @RequestParam(value = "editeur", required = false) String editeur,
                                                         @RequestParam(value = "edition", required = false) String edition
                                                         ){
        List<Livre> cree = null;
        if(auteur!=null){cree = livreServiceProvider.findByAuteur(auteur);}
        else if(titre!=null){cree = livreServiceProvider.findByTitre(titre);}
        else if(editeur!=null){cree = livreServiceProvider.findByEditeur(editeur);}
        else if(edition!=null){cree = livreServiceProvider.findByEdition(edition);}
        else{cree = livreServiceProvider.getAll();}
        Link lien = linkTo(methodOn(LivreController.class).findBy(auteur,titre,editeur,edition)).withSelfRel();
        return new ResponseEntity<CollectionModel<Livre>>(new CollectionModel<>(cree, lien), CREATED);
    }

    @PostMapping
    public ResponseEntity<EntityModel<Livre>> create(@RequestBody Livre livre){
        Livre cree = livreServiceProvider.create(livre);
        Link lien = linkTo(methodOn(LivreController.class).findByIsbn(cree.getIsbn())).withSelfRel();
        return new ResponseEntity<>(new EntityModel<>(cree, lien), CREATED);
    }

    @PutMapping
    public ResponseEntity<EntityModel<Livre>> modify(@RequestBody Livre livre){
        Livre cree = livreServiceProvider.modify(livre);
        Link lien = linkTo(methodOn(LivreController.class).findByIsbn(cree.getIsbn())).withSelfRel();
        return new ResponseEntity<>(new EntityModel<>(cree, lien), CREATED);
    }

    @DeleteMapping("{isbn}")
    public ResponseEntity<Integer> delete(@PathVariable("isbn") String isbn){
        int deleted = livreServiceProvider.delete(isbn);
        return new ResponseEntity<Integer>(deleted, CREATED);
    }


}
