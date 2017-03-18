package dao.DAOImpl;

import dao.dao_methods.DAOMethod;
import hibernate.HibernateUtils;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOImplMethod<T> implements DAOMethod<T> {
    @Override
    public void addObject(T o) throws SQLException {
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateObject(T o) throws SQLException {
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            session.update(o);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteObject(T o) throws SQLException {
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            session.delete(o);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public T getByLogin(String login) throws SQLException {
        T o = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            o = (T)session.load(o.getClass(),login);
            session.getTransaction().commit();
        }
        return o;
    }

    @Override
    public T getObjectById(int id) throws SQLException {
        T object = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            object = (T)session.load(object.getClass(), id);
            session.getTransaction().commit();
        }
        return object;
    }

    @Override
    public List<T> getAllObjects(Class<T> currentClass) throws SQLException {
        List<T> listOfAll = new ArrayList<>();
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            listOfAll = (ArrayList<T>) session.createCriteria(currentClass).list();
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listOfAll;
    }
}
