import model.*;
import repository.AuthorCrudOperations;
import repository.BookCrudOperations;
import repository.SubscriberCrudOperations;

import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //author test
        System.out.println("-".repeat(50));
        AuthorCrudOperations authorCrudOperations = new AuthorCrudOperations();
        Author authorTest = new Author("id", "Nata", Sex.M);
        authorCrudOperations.save(authorTest);
        authorCrudOperations.findAll().forEach(System.out::println);
        authorCrudOperations.delete(authorTest);
        authorCrudOperations.findAll().forEach(System.out::println);

        //subsriber test
        System.out.println("-".repeat(50));
        SubscriberCrudOperations subscriberCrudOperations = new SubscriberCrudOperations();
        Subscriber subscriberTest = new Subscriber("id", "Visitor", "ref");
        subscriberCrudOperations.save(subscriberTest);
        subscriberCrudOperations.findAll().forEach(System.out::println);
        subscriberCrudOperations.delete(subscriberTest);
        subscriberCrudOperations.findAll().forEach(System.out::println);

        //book test
        System.out.println("-".repeat(50));
        BookCrudOperations bookCrudOperations= new BookCrudOperations();
        Book bookTest= new Book("id", "test", Date.valueOf("2003-03-03"), null,100,List.of(Topic.ROMANCE));
        bookCrudOperations.save(bookTest);
        bookCrudOperations.findAll().forEach(System.out::println);
        bookCrudOperations.delete(bookTest);
        bookCrudOperations.findAll().forEach(System.out::println);
    }
}