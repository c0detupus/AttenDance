package afk.model;

import afk.helper.Messages;
import java.io.IOException;
import java.io.Serializable;
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
            clear();
            Messages.showMessage(2);
        }
        return null;
    }
    
    public void clear(){
        username = null;
        password = null;
    }

    public String logout() {
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
