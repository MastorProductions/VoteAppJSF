package controllers;

import entities.Candidate;
import entities.Vote;
import entities.Voter;
import services.CandidateService;
import services.VoterService;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean
@RequestScoped
public class NavigationController {

    //TODO: Parameterize error-large / error-small
    //TODO: fix multiple messages, log and context
    //TODO: Activate nav buttons
    //TODO: Add more PrimeFaces

    //TODO: AJAX page nav and AJAX voting (optional)

    @EJB
    private VoterService voterService;

    @EJB
    private CandidateService candidateService;

    @ManagedProperty("#{userController}")
    private UserController userController;

    public String vote() {
        Voter v = userController.getVoter();
        if (v != null) return "vote?faces-redirect=true";
        else return "index?faces-redirect=true";
    }

    public String history() {
        Voter v = userController.getVoter();
        if (v != null) return "history?faces-redirect=true";
        else return "index?faces-redirect=true";
    }

    public String rankings() {
        Voter v = userController.getVoter();
        if (v != null) return "rankings?faces-redirect=true";
        else return "index?faces-redirect=true";
    }

    public List<Candidate> getCandidateList() {
        Voter v = userController.getVoter();
        if (v != null) {
            List<Candidate> list = candidateService.getAvailableCandidatesForVoter(v);

            if (list.size() > 0 && voterService.canVote(v)) {
                return list;
            } else {
                FacesMessage message = new FacesMessage("You've reached your voting limit!");
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, message);
            }
        }
        return null;
    }

    public List<Vote> getVoteList() {
        Voter v = userController.getVoter();
        if (v != null) {
            List<Vote> list = voterService.getVoteHistoryForVoter(v);

            if (list.size() > 0) {
                return list;
            } else {
                FacesMessage message = new FacesMessage("You haven't voted yet!");
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, message);
            }
        }
        return null;
    }

    public List<Candidate> getRankingList() {
        Voter v = userController.getVoter();
        if (v != null) {
            List<Candidate> list = candidateService.getRankings();

            if (list.size() > 0) {
                return list;
            } else {
                FacesMessage message = new FacesMessage("Nobody has been voted yet!");
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, message);
            }
        }
        return null;
    }

    public UserController getUserController() {
        return userController;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }
}
