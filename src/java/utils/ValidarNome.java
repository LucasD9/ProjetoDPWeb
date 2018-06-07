package utils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validarNome")
public class ValidarNome implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
            
            String nome = (String ) o;
            if(nome.length()<5 || !nome.contains(" ") || nome.contains("@")){
                FacesMessage msg = new FacesMessage("O campo nome está inválido");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
    }
    
}
