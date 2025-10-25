package demographql.graphql;

import demographql.model.Produit;
import demographql.service.ProduitService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProduitController {
    private final ProduitService service;

    public ProduitController(ProduitService service) {
        this.service = service;
    }

    // Queries
    @QueryMapping
    public List<Produit> produits() {
        return service.getAll();
    }

    @QueryMapping
    public Produit produit(@Argument Long id) {
        return service.getById(id);
    }

    @QueryMapping
    public List<Produit> produitsParNom(@Argument String q) {
        return service.searchByName(q);
    }
}