import repository.AuthorCrudOperations;

public class Main {
    public static void main(String[] args) {
        AuthorCrudOperations authorCrudOperations = new AuthorCrudOperations();
        System.out.println(authorCrudOperations.findAll());
    }
}