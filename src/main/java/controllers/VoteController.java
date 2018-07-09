package controllers;

import entities.Candidate;
import entities.Voter;
import services.VoterService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class VoteController {

    @EJB
    private VoterService voterService;

    public String vote(Voter voter, Candidate candidate, int vote) {
        voterService.vote(voter, candidate, vote);
        return "vote?faces-redirect=true";
    }
}
