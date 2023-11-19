package repository;

import model.Book;
import model.Topic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookCrudOperations implements CrudOperations<Book>{
    private final static Connection connection = ConnectionToDatabase.getConnection();
    @Override
    public List<Book> findAll() {
        List<Book> listBooks = new ArrayList<>();
        try{
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM book");
            while(resultSet.next()){
                String[] topicsArray = (String[]) resultSet.getArray("topics").getArray();
                List<Topic> topics = new ArrayList<>();
                for (String topic: topicsArray) {
                    topics.add(Topic.valueOf(topic));
                }

                listBooks.add(
                    new Book(
                        resultSet.getString("id"),
                        resultSet.getString("book_name"),
                        resultSet.getDate("release_Date"),
                        AuthorCrudOperations.findOneAuthor(resultSet.getString("id_author")),
                        resultSet.getInt("page_numbers"),
                        topics
                    )
                );
            }
        }catch (SQLException error){
            System.out.println(error.getMessage());
        }
        return listBooks;
    }

    @Override
    public List<Book> saveAll(List<Book> toSave) {
        List<Book> books = new ArrayList<>();
        toSave.forEach(el -> {
            books.add(save(el));
        });
        return books;
    }

    @Override
    public Book save(Book toSave) {
        return null;
    }

    @Override
    public Book delete(Book toDelete) {
        try{
            connection.createStatement().executeUpdate("DELETE FROM book WHERE id = " + toDelete.getId());
            return toDelete;
        }catch (SQLException error){
            System.out.println(error.getMessage());
        }
        return null;
    }
}
