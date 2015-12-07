package afk.model;

import afk.services.ServicesIntf;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.ejb.EJB;
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
public class Login implements Serializable {

    private String username;
    private String password;

    @EJB
    private ServicesIntf services;

    public void login() throws IOException {
        System.out.println("login() called");
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

        try {
            request.login(this.username, this.password);
//            UserEntity user = services.getUserService().getUserByName(username);
            System.out.println(username + " Login success");
            boolean test = isRoleTeacher();
            if (test == true){
                System.out.println("teacher logged");
            }
             context.getExternalContext().redirect("teacher/teacherList.xhtml");
        } catch (ServletException e) {
            context.addMessage(null, new FacesMessage("Login failed."));
            System.out.println(username + " Login failed");
        }
    }


    public boolean isRoleTeacher() {
        FacesContext context = FacesContext.getCurrentInstance();
        return context.getExternalContext().isUserInRole("teacher");
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/jsf/login?faces-redirect=true";
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
