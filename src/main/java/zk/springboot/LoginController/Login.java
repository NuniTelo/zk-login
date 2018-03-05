package zk.springboot.LoginController;

import org.zkoss.zk.ui.Component;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Button;
import org.zkoss.zul.Textbox;
import zk.springboot.LoginService.LoginService;
import zk.springboot.Model.User;
import java.util.ArrayList;
import java.util.List;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class Login extends SelectorComposer<Component> {

    @WireVariable("login_service")
    private LoginService service;

    @Wire
    private Button login;

    @Wire
    private Textbox emri;

    @Wire Textbox password;


    @Listen("onClick = #login")
    public void test (){
        Clients.showBusy("Duke marre te dhenat...");
        List<User> userList = new ArrayList<>();
        userList=service.getReqUser(emri.getValue(),password.getValue());
        if(userList.size()==1){
            Session session = Sessions.getCurrent();
            session.setAttribute("userSession", userList.get(0).getUsername());
            Clients.clearBusy();
            Executions.sendRedirect("/dashboard.zul");
        }
        else {
            Clients.clearBusy();
            emri.setValue("null");
            Clients.showNotification("Gabim te dhenat!");
        }

    }

}
