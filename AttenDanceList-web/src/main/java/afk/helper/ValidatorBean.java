package afk.helper;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author c0detupus
 */
@ManagedBean(name = "validatorBean")
@ViewScoped
public class ValidatorBean
{

    public void validateLetters(FacesContext context,
                                UIComponent toValidate,
                                Object value) throws ValidatorException {

        String str = (String) value;

        if(!onlyLettersSC(str)) {
            throw new ValidatorException(new FacesMessage("Can only have letters"));
        }
    }

    public void validateEmail(FacesContext context,
                              UIComponent toValidate,
                              Object value) throws ValidatorException {
        String str = (String) value;
        if(-1 == value.toString().indexOf("@")) {
            FacesMessage message = new FacesMessage("Invalid email address");
            throw new ValidatorException(message);
        }
    }

    public void validateSSN(FacesContext context,
                            UIComponent toValidate,
                            Object value) throws ValidatorException {
        String str = (String) value;

        //Replaces first ocurrence of '-' not all occurences cause 
        //ssn can be erroneously bli written with more than one '-'
        String cleaned = str.replaceFirst("[-]", "");

        if(!onlyNumbers(cleaned)) {
            throw new ValidatorException(
                    new FacesMessage("Only numbers preffered format YYMMDDXXXX or YYMMDD-XXXX"));
        }

        if(cleaned.length() != 10) {

            throw new ValidatorException(new FacesMessage("Use format YYMMDDXXXX or YYMMDD-XXXX"));
        }

    }

    public void validatePhoneNumbers(FacesContext context,
                                     UIComponent toValidate,
                                     Object value) throws ValidatorException {

        String str = (String) value;

        String cleaned = str.replaceFirst("\\s", "");

        if(!onlyNumbers(str)) {
            throw new ValidatorException(
                    new FacesMessage("Only numbers"));
        }

    }

    public void validateZipCode(FacesContext context,
                                UIComponent toValidate,
                                Object value) throws ValidatorException {

        String str = (String) value;
        if(!onlyNumbers(str)) {
            throw new ValidatorException(
                    new FacesMessage("Only numbers"));
        }

        if(str.length() != 10) {
            throw new ValidatorException(
                    new FacesMessage("Invalid postal code"));

        }

    }

    //PRIVATE METHODS ----->
    private boolean onlyLetters(String str) {

        return str.matches("[a-zA-Z]+");

    }

    //Handles regex for letters only but with special characters included
    private boolean onlyLettersSC(String str) {

        return str.matches("[a-zA-ZåäöÅÄÖ]+");

    }

    private boolean onlyNumbers(String str) {
        return str.matches("[0-9]+");
    }
    //<----- PRIVATE METHODS

}
