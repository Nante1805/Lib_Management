import model.Author;
import model.Sex;
import model.Subscriber;
import repository.AuthorCrudOperations;
import repository.SubscriberCrudOperations;

public class Main {
    public static void main(String[] args) {
        //author test
        AuthorCrudOperations authorCrudOperations = new AuthorCrudOperations();
        Author authorTest = new Author("id", "Nata", Sex.M);
        authorCrudOperations.save(authorTest);
        authorCrudOperations.findAll().forEach(System.out::println);
        authorCrudOperations.delete(authorTest);
        authorCrudOperations.findAll().forEach(System.out::println);

        //subsriber test
        SubscriberCrudOperations subscriberCrudOperations = new SubscriberCrudOperations();
        Subscriber subscriberTest = new Subscriber("id", "Visitor", "ref");
        subscriberCrudOperations.save(subscriberTest);
        subscriberCrudOperations.findAll().forEach(System.out::println);
        subscriberCrudOperations.delete(subscriberTest);
        subscriberCrudOperations.findAll().forEach(System.out::println);
    }
}