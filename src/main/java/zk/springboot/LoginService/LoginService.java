package zk.springboot.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zk.springboot.Model.User;
import zk.springboot.Repositry.UserRepositry;

import java.util.ArrayList;
import java.util.List;

@Service("login_service")
public class LoginService {

    @Autowired
    UserRepositry repositry;

    public List<User> getReqUser(String username,String password){
        List<User> allUser = new ArrayList<>();
        allUser = repositry.getAllByUsername(username,password);

        return allUser;


    }

}
