package controllers;

import entities.Voter;
import services.VoterService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class VoterBean {

    private Voter voter;

    @EJB
    private VoterService voterService;

    @ManagedProperty("#{userController}")
    private UserController userController;

    @PostConstruct
    public void init() {
        this.voter = new Voter();
    }

    public String login() {

        if (userController.getVoter() != null) return "vote?faces-redirect=true";

        Voter loggedVoter = voterService.login(voter);

        if (loggedVoter != null) {
            userController.setVoter(loggedVoter);
            return "vote?faces-redirect=true";
        } else {
            FacesMessage message = new FacesMessage("Login Failed");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, message);
            return "index?faces-redirect=true";
        }
    }

    public String logout() {
        if (userController.getVoter() != null) userController.setVoter(null);
        return "index?faces-redirect=true";
    }

    public String register() {

        try {
            voterService.register(voter);
            userController.setVoter(voter);
            return "vote?faces-redirect=true";

        } catch (Exception e) {
            System.out.println("Unable to register - " + e.getMessage());
            FacesMessage message = new FacesMessage("Registration Failed");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, message);
            return "index?faces-redirect=true";
        }
    }

    public Voter getVoter() {
        return voter;
    }

    public void setVoter(Voter voter) {
        this.voter = voter;
    }

    public Integer getId() {
        return voter.getVoterId();
    }

    public void setId(Integer id) {
        this.voter.setVoterId(id);
    }

    public String getName() {
        return voter.getVoterName();
    }

    public void setName(String name) {
        this.voter.setVoterName(name);
    }

    public String getSurname() {
        return voter.getVoterSurname();
    }

    public void setSurname(String surname) {
        this.voter.setVoterSurname(surname);
    }

    public String getPassword() {
        return voter.getVoterPassword();
    }

    public void setPassword(String password) {
        this.voter.setVoterPassword(password);
    }

    public UserController getUserController() {
        return userController;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }
}
