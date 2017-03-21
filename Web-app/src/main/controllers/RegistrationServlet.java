package controllers;

import dao.entity.User;
import hibernate.Factory;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;

public class RegistrationServlet extends APIHandlerServlets.APIRequestHandler{

    public static final RegistrationServlet instance = new RegistrationServlet();

    public static RegistrationServlet getInstance() { return instance; }

    private RegistrationServlet () {

    }

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) throws Exception {
        String login = request.getParameter("login");
        String pass = request.getParameter("password");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        User user = new User(pass,login,name,email);

        JSONObject jsonObject = new JSONObject();
        try {
            Factory.getInstance().getUserMethods().addObject(user);
        }catch (Exception e){
            jsonObject.put("login","error");
            jsonObject.put("indexNumber","not_exist");
            return jsonObject;
        }
        jsonObject.put("login",user.getLogin());
        jsonObject.put("indexNumber",user.getId());
        System.err.print("work");
        return jsonObject;
    }
}
