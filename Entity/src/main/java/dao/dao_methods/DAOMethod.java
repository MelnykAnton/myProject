package dao.dao_methods;

import java.sql.SQLException;
import java.util.List;

public interface DAOMethod<T> {

    void addObject (T object) throws SQLException;
    void updateObject (T object) throws SQLException;
    void deleteObject(T object) throws SQLException;
    T getByLogin(String name) throws SQLException;
    T getObjectById (int id) throws SQLException;
    List<T> getAllObjects(Class<T> currentClass) throws SQLException;
}
