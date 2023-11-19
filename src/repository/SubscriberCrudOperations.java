package repository;

import model.Subscriber;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubscriberCrudOperations implements CrudOperations<Subscriber>{
    private final static Connection connection = ConnectionToDatabase.getConnection();
    @Override
    public List<Subscriber> findAll() {
        List<Subscriber> listSubscribers = new ArrayList<>();
        try{
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM subscriber");
            while(resultSet.next()){
                listSubscribers.add(
                        new Subscriber(
                            resultSet.getString("id"),
                            resultSet.getString("name"),
                            resultSet.getString("ref")
                        )
                );
            }
        }catch (SQLException error){
            System.out.println(error.getMessage());
        }
        return listSubscribers;
    }

    @Override
    public List<Subscriber> saveAll(List<Subscriber> toSave) {
        List<Subscriber> subscribers = new ArrayList<>();
        toSave.forEach(el -> {
            subscribers.add(save(el));
        });
        return subscribers;
    }

    @Override
    public Subscriber save(Subscriber toSave) {
        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO subscriber VALUES (?,?,?);");
            statement.setString(1, toSave.getId());
            statement.setString(2, toSave.getName());
            statement.setString(3, toSave.getRef());
            statement.executeUpdate();
            return toSave;
        }catch (SQLException error){
            System.out.println(error.getMessage());
        }
        return null;
    }

    @Override
    public Subscriber delete(Subscriber toDelete) {
        try{
            connection.createStatement().executeUpdate("DELETE FROM subscriber WHERE id = " + toDelete.getId());
            return toDelete;
        }catch (SQLException error){
            System.out.println(error.getMessage());
        }
        return null;
    }
}
