package curso.sprigframework.spring5webapp.bootstrap;

import curso.sprigframework.spring5webapp.model.Author;
import curso.sprigframework.spring5webapp.model.Book;
import curso.sprigframework.spring5webapp.model.Publisher;
import curso.sprigframework.spring5webapp.repositories.AuthorRepository;
import curso.sprigframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author joao = new Author("Joao", "Silva");
        Book livroJoao = new Book("livro01", "123456");
        joao.getBooks().add(livroJoao);
        livroJoao.getAuthors().add(joao);

        authorRepository.save(joao);
        bookRepository.save(livroJoao);

        Author pedro = new Author("Pedro", "Cardoso");
        Book livroPedro = new Book("Livro02", "25697814");
        pedro.getBooks().add(livroPedro);
        livroPedro.getAuthors().add(pedro);

        authorRepository.save(pedro);
        bookRepository.save(livroPedro);

        System.out.println("Started in Bootstrap");
        System.out.println("Number Of books " + bookRepository.count());

        Publisher editora01 = new Publisher("Casa do livro");
        editora01.getPublisherBooks().add(livroJoao);
        editora01.getPublisherBooks().add(livroPedro);
        livroJoao.setPublisher(editora01);
        livroPedro.setPublisher(editora01);

        System.out.println("a editora " + editora01.getName() + " tem "
                + editora01.getPublisherBooks().stream().count() + " livros publicados");
    }
}
