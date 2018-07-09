package services;

import controllers.VoterBean;
import entities.Candidate;
import entities.Vote;
import entities.Voter;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class VoterService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void register(Voter v) {
        em.persist(v);
    }

    public Voter login(Voter v) {
        try {
            return em
                    .createNamedQuery("Voter.login", Voter.class)
                    .setParameter("voterId", v.getVoterId())
                    .setParameter("voterPassword", v.getVoterPassword())
                    .getSingleResult();
        } catch (Exception e) {
            System.out.println("Unable to login - " + e.getMessage());
            return null;
        }
    }

    public boolean canVote(Voter v) {
        try {
            em
                    .createNamedQuery("Voter.canVote", Voter.class)
                    .setParameter("voter", v)
                    .getSingleResult();
            return true;
        } catch (Exception e) {
            System.out.println("Vote limit reached - " + e.getMessage());
            return false;
        }
    }

    @Transactional
    public void vote(Voter voter, Candidate candidate, int vote) {
        Vote v = new Vote();

        v.setVoterByVoterId(voter);
        v.setCandidateByCandidateId(candidate);
        v.setVote(vote);

        try {
            em.persist(v);
        } catch (Exception e) {
            System.out.println("Unable to vote - " + e.getMessage());
        }
    }

    public List<Vote> getVoteHistoryForVoter(Voter v) {
        try {
            return new ArrayList<>(em.find(Voter.class, v.getVoterId()).getVotesByVoterId());
        } catch (Exception e) {
            System.out.println("Unable to get history - " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
