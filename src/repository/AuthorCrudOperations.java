package repository;

import model.Author;
import model.Sex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class AuthorCrudOperations implements CrudOperations<Author>{
    private final static Connection connection = ConnectionToDatabase.getConnection();
    @Override
    public List<Author> findAll() {
        List<Author> listAuthors = new ArrayList<>();
        try{
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM author");
            while(resultSet.next()){
                listAuthors.add(
                    new Author(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        Sex.valueOf(resultSet.getString("sex"))
                    )
                );
            }
        }catch (SQLException error){
            System.out.println(error.getMessage());
        }
        return listAuthors;
    }

    @Override
    public List<Author> saveAll(List<Author> toSave) {
        List<Author> authors = new ArrayList<>();
        toSave.forEach(el -> {
            authors.add(save(el));
        });
        return authors;
    }

    @Override
    public Author save(Author toSave) {
        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO author VALUES (?,?,?);");
            statement.setString(1, toSave.getId());
            statement.setString(2, toSave.getName());
            statement.setString(3, toSave.getSex().toString());
            statement.executeUpdate();
            return toSave;
        }catch (SQLException error){
            System.out.println(error.getMessage());
        }
        return null;
    }

    @Override
    public Author delete(Author toDelete) {
        try{
            connection.createStatement().executeUpdate("DELETE FROM author WHERE id = " + toDelete.getId());
            return toDelete;
        }catch (SQLException error){
            System.out.println(error.getMessage());
        }
        return null;
    }
}
