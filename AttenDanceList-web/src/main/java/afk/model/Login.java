package afk.model;

import afk.helper.Messages;
import afk.services.ServicesIntf;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author valance
 */
@ManagedBean(name = "loginBean")
@ViewScoped
public class Login implements Serializable
{

    private String username;
    private String password;
    private int errorCode = 1;

    private static final String loginPageUri = "/jsf/login?faces-redirect=true";
    private static final String successfullLoginUri = "/jsf/teacher/teacherList?faces-redirect=true";

    public String login() throws IOException {
        System.out.println("login() called");
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context
                .getExternalContext().getRequest();

        try {
            request.login(this.username, this.password);
            return successfullLoginUri;

        } catch(ServletException e) {
//            context.addMessage(null, new FacesMessage("Login failed."));

            System.out.println(username + " Login failed");
            errorCode = 0;
            logout();
        }

        return null;
    }

    public String logout() {

        if(errorCode == 0) {
            Messages.showMessage(errorCode);
        }

        FacesContext.getCurrentInstance().getExternalContext()
                .invalidateSession();
        return loginPageUri;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
