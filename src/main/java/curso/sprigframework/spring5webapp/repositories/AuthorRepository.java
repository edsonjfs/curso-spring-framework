package curso.sprigframework.spring5webapp.repositories;

import curso.sprigframework.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
