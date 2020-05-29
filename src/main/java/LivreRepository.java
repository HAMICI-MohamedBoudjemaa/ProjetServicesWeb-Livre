import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LivreRepository extends JpaRepository<Livre, String> {
    Livre findByIsbn(String isbn);
}
