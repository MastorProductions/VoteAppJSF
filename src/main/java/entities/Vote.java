package entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Vote {

    private Integer voteId;
    private Timestamp date;
    private Integer vote;
    private Voter voterByVoterId;
    private Candidate candidateByCandidateId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vote_id", nullable = false)
    public Integer getVoteId() {
        return voteId;
    }

    public void setVoteId(Integer voteId) {
        this.voteId = voteId;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "vote", nullable = false)
    public Integer getVote() {
        return vote;
    }

    public void setVote(Integer vote) {
        this.vote = vote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vote vote1 = (Vote) o;

        if (voteId != null ? !voteId.equals(vote1.voteId) : vote1.voteId != null) return false;
        if (date != null ? !date.equals(vote1.date) : vote1.date != null) return false;
        if (vote != null ? !vote.equals(vote1.vote) : vote1.vote != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = voteId != null ? voteId.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (vote != null ? vote.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "voter_id", referencedColumnName = "voter_id", nullable = false)
    public Voter getVoterByVoterId() {
        return voterByVoterId;
    }

    public void setVoterByVoterId(Voter voterByVoterId) {
        this.voterByVoterId = voterByVoterId;
    }

    @ManyToOne
    @JoinColumn(name = "candidate_id", referencedColumnName = "candidate_id", nullable = false)
    public Candidate getCandidateByCandidateId() {
        return candidateByCandidateId;
    }

    public void setCandidateByCandidateId(Candidate candidateByCandidateId) {
        this.candidateByCandidateId = candidateByCandidateId;
    }
}
