package controllers;

import entities.Candidate;
import entities.Vote;
import entities.Voter;
import services.CandidateService;
import services.VoterService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;
import java.util.List;

@ManagedBean
@RequestScoped
public class NavigationController {

    @EJB
    private VoterService voterService;

    @EJB
    private CandidateService candidateService;

    @ManagedProperty("#{userController}")
    private UserController userController;

    @ManagedProperty("#{errorBean}")
    private ErrorBean errorBean;

    public String vote() {
        Voter v = userController.getVoter();
        if (v != null) return "vote";
        else return "index";
    }

    public String history() {
        Voter v = userController.getVoter();
        if (v != null) return "history";
        else return "index";
    }

    public String rankings() {
        Voter v = userController.getVoter();
        if (v != null) return "rankings";
        else return "index";
    }

    public List<Candidate> getCandidateList() {
        Voter v = userController.getVoter();
        if (v != null) {
            List<Candidate> list = candidateService.getAvailableCandidatesForVoter(v);

            if (list.size() > 0 && voterService.canVote(v)) {
                return list;
            } else {
                errorBean.setErrorMessage("You've reached your voting limit!");
                errorBean.setErrorPosition("col-md-6 col-md-offset-3");
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
                errorBean.setErrorMessage("You haven't voted yet!");
                errorBean.setErrorPosition("col-md-6 col-md-offset-3");
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
                errorBean.setErrorMessage("Nobody has been voted yet!");
                errorBean.setErrorPosition("col-md-6 col-md-offset-3");
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

    public ErrorBean getErrorBean() {
        return errorBean;
    }

    public void setErrorBean(ErrorBean errorBean) {
        this.errorBean = errorBean;
    }
}
