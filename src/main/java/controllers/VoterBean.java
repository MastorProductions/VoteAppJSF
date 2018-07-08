package controllers;

import entities.Voter;
import services.VoterService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class VoterBean {

    private Integer id;
    private String password;

    @EJB
    private VoterService voterService;

    @ManagedProperty("#{userController}")
    private UserController userController;

    @ManagedProperty("#{errorBean}")
    private ErrorBean errorBean;

    public String login() {

        if (userController.getVoter() != null) return "vote";

        Voter loggedVoter = voterService.login(this);

        if (loggedVoter != null) {
            userController.setVoter(loggedVoter);
            return "vote";
        } else {
            errorBean.setErrorMessage("Login Failed");
            errorBean.setErrorPosition("col-md-2 col-md-offset-5");
            return "index";
        }
    }

    public String logout() {
        if (userController.getVoter() != null) userController.setVoter(null);
        return "index";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserController getUserController() {
        return userController;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }

    public ErrorBean getErrorBean() {
        return errorBean;
    }

    public void setErrorBean(ErrorBean errorBean) {
        this.errorBean = errorBean;
    }
}
