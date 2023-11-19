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
        try{
            String topics = toSave.getTopics().toString().replace("[","{").replace("]","}");
            String insert = "INSERT INTO book (id, book_name, page_numbers, release_date, topics) VALUES (?,?,?,?,'" + topics +  "');";
            PreparedStatement statement = connection.prepareStatement(insert);
            statement.setString(1, toSave.getId());
            statement.setString(2, toSave.getBookName());
            statement.setInt(3, toSave.getPageNumbers());
            statement.setDate(4, toSave.getReleaseDate());
            statement.executeUpdate();
            return toSave;
        }catch (SQLException error){
            System.out.println(error.getMessage());
        }
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
