package demographql.service;


import demographql.model.Produit;
import demographql.repository.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {
    private final ProduitRepository repo;

    public ProduitService(ProduitRepository repo) {
        this.repo = repo;
    }

    public List<Produit> getAll() {
        return repo.findAll();
    }

    public Produit getById(Long id) {
        return repo.findById(id)
                .orElse(null);  // retourne null si le produit n’existe pas
    }

    public List<Produit> searchByName(String q) {
        return repo.findByNomContainingIgnoreCase(q);
    }

}