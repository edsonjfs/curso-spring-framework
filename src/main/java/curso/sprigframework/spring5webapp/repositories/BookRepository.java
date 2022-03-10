package curso.sprigframework.spring5webapp.repositories;

import curso.sprigframework.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
