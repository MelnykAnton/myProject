package controllers;

import dao.entity.User;
import hibernate.Factory;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;

public class RegistrationServlet extends APIHandlerServlets.APIRequestHandler{

    public static final RegistrationServlet instance = new RegistrationServlet();

    public static RegistrationServlet getInstance() { return instance; }

    private RegistrationServlet () {

    }

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) throws Exception {
        String login = request.getParameter("log");
        String pass = request.getParameter("pass");
        String email = request.getParameter("mail");
        User user = new User();
        user.setLogin(login);
        user.setPassword(pass);
        user.seteMail(email);
        Factory.getInstance().getUserMethods().addObject(user);
        System.err.print("work");
        return null;
    }
}
