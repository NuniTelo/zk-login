package zk.springboot.LoginController;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;

public class DashboardController extends SelectorComposer<Component> {

    @Wire
    private Label username;

    @Wire
    private Button logout;


    @Override
    public void doAfterCompose(Component comp) throws Exception{
        super.doAfterCompose(comp);
        Session session = Sessions.getCurrent();
        Object myStoredData = session.getAttribute("userSession");

        if(myStoredData == null){
            Executions.sendRedirect("/login.zul");
        }
        else {
            System.out.println("username: " + myStoredData.toString());
            username.setValue(myStoredData.toString());
        }
    }

    @Listen("onClick = #logout")
    public void logout(){
        Session session = Sessions.getCurrent();
        session.removeAttribute("userSession");
        Executions.sendRedirect("/login.zul");


    }
}
