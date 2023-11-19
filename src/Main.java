import model.Author;
import model.Sex;
import repository.AuthorCrudOperations;

public class Main {
    public static void main(String[] args) {
        AuthorCrudOperations authorCrudOperations = new AuthorCrudOperations();
        Author authorTest = new Author("id", "Nata", Sex.M);
        authorCrudOperations.save(authorTest);

        System.out.println(authorCrudOperations.findAll());
    }
}