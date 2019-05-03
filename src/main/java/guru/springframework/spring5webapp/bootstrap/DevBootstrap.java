package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by mmm on 08/04/19.
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {


    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository=publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        initData();
    }

    private void initData(){

        Publisher publisher=new Publisher() ;
        publisher.setName("CoolBook");
        publisher.setAddress("Paris");

        publisherRepository.save(publisher);
        //Moez
        Author moez=new Author();
        moez.setFirstName("Mohamed Moez");
        moez.setLastName("MANSOURI");




        Book moezBook=new Book();
        moezBook.setIsbn("12346");
        moezBook.setTitle("Moez Biography");
        moezBook.setPublisher(publisher);
        moezBook.getAuthors().add(moez);


        authorRepository.save(moez);
        bookRepository.save(moezBook);


        //Imene
        Author imene=new Author();
        imene.setFirstName("Imene");
        imene.setLastName("NASRI");


        Book imeneBook=new Book();
        imeneBook.setIsbn("123464536");
        imeneBook.setTitle("Imene Biography");
        imeneBook.setPublisher(publisher);
        imeneBook.getAuthors().add(moez);


        authorRepository.save(imene);
        bookRepository.save(imeneBook);




    }
}
