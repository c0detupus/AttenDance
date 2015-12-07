/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk.helper;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author valance
 */
@ManagedBean(name = "messageBean")
@RequestScoped
public class Messages {

    public static void showMessage(int i) {
        if (i == 1) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Success!");
            RequestContext.getCurrentInstance().showMessageInDialog(message);
        } else if (i == 0) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Failure", "Failed. Please try again.");
            RequestContext.getCurrentInstance().showMessageInDialog(message);
        } else if(i == 2) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Failed Login", "Incorrect username or password.");
            RequestContext.getCurrentInstance().showMessageInDialog(message);
        }

    }

}
