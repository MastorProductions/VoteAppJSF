package controllers;

import entities.Voter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class LoginManagedMean {

    @ManagedProperty("#{userSession}")
    private UserSession userSession;

    public UserSession getUserSession() {
        return userSession;
    }

    public void setUserSession(UserSession userSession) {
        this.userSession = userSession;
    }

    public void login() {
        Voter v = new Voter();
        v.setVoterId(1);
        v.setVoterName("Thisserino");
        v.setVoterSurname("Xanth");
        userSession.setVoter(v);
    }

    public void logout() {
        userSession.setVoter(null);
    }
}
