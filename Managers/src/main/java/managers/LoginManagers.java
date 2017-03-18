package managers;

import dao.entity.User;
import hibernate.Factory;

import java.util.Map;

public class LoginManagers {

    public String[] loginController(Map<String, String[]> paramMap) throws Exception {
        String[] resultData = new String [2];
        String login = paramMap.get("login")[0];
        String password = paramMap.get("password")[0];
        User currentUser = null;
        currentUser = Factory.getInstance().getUserMethods().getByLogin(login);
        if(currentUser!=null){
            String tempPassword = currentUser.getPassword();
            if(password.equals(tempPassword)) {
                resultData[0] = currentUser.getLogin();
                resultData[1] = String.valueOf(currentUser.getId());
                return resultData;
            } throw new Exception();
        }else{
            throw new Exception();
        }

    }
}
