package hibernate;

import dao.DAOImpl.DAOImplMethod;
import dao.entity.Comment;
import dao.entity.Place;
import dao.entity.User;

public class Factory {
    private static Factory instance = null;
    private static DAOImplMethod<User> userDAO = null;
    private static DAOImplMethod<Comment> commentDAO = null;
    private static DAOImplMethod<Place> placeDAO = null;


    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public DAOImplMethod<User> getUserMethods(){
        if( userDAO == null){
            userDAO = new DAOImplMethod<>();
        }
        return userDAO;
    }
    public DAOImplMethod<Place> getPlaceMethod() {
        if( placeDAO == null){
            placeDAO = new DAOImplMethod<>();
        }
        return placeDAO;
    }
    public DAOImplMethod<Comment> getCommentMethod() {
        if( commentDAO == null){
            commentDAO = new DAOImplMethod<>();
        }
        return commentDAO;
    }
}
