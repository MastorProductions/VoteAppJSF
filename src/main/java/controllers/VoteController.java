package controllers;

import services.VoterService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class VoteController {

    @EJB
    private VoterService voterService;

    public String vote(int voterId, int candidateId, int vote) {
        voterService.vote(voterId, candidateId, vote);
        return "vote";
    }
}
