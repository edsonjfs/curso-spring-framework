package curso.sprigframework.spring5webapp.repositories;

import curso.sprigframework.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface Publisherrepository extends CrudRepository <Publisher, Long> {
}
