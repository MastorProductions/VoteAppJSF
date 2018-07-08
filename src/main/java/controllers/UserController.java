package controllers;

import entities.Voter;
import services.VoterService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UserController {

    @EJB
    private VoterService voterService;

    private Voter voter;

//    public String register() {
//
//        try {
//            // TODO: Change to VoterBean
//            voterService.register(voter);
//            return "vote";
//
//        } catch (Exception e) {
//            System.out.println("Unable to register - " + e.getMessage());
//            errorBean.setErrorMessage("Registration Failed");
//            errorBean.setErrorPosition("col-md-2 col-md-offset-5");
//            return "index";
//        }
//    }

    public Voter getVoter() {
        return voter;
    }

    public void setVoter(Voter voter) {
        this.voter = voter;
    }
}
