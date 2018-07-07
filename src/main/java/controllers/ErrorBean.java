package controllers;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class ErrorBean implements Serializable {

    private String errorMessage;
    private String errorPosition;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorPosition() {
        return errorPosition;
    }

    public void setErrorPosition(String errorPosition) {
        this.errorPosition = errorPosition;
    }
}
