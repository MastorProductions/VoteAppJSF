package entities;

import javax.persistence.*;
import java.util.Collection;

@NamedQueries({
        @NamedQuery(name = "Candidate.getAvailableForVoter", query = "SELECT c FROM Candidate c WHERE c NOT IN (SELECT c FROM Candidate c JOIN Vote vo ON vo.candidateByCandidateId = c WHERE vo.voterByVoterId = :voter)"),
        @NamedQuery(name = "Candidate.getAllVoted", query = "SELECT c FROM Candidate c JOIN Vote v ON v.candidateByCandidateId = c GROUP BY c"),
})
@Entity
public class Candidate {

    private Integer candidateId;
    private String candidateName;
    private String candidateSurname;
    private Collection<Vote> votesByCandidateId;
    private int totalVotes;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidate_id", nullable = false)
    public Integer getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
    }

    @Basic
    @Column(name = "candidate_name", nullable = false, length = 50)
    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    @Basic
    @Column(name = "candidate_surname", nullable = false, length = 50)
    public String getCandidateSurname() {
        return candidateSurname;
    }

    public void setCandidateSurname(String candidateSurname) {
        this.candidateSurname = candidateSurname;
    }

    @Transient
    public int getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(int totalVotes) {
        this.totalVotes = totalVotes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Candidate candidate = (Candidate) o;

        if (candidateId != null ? !candidateId.equals(candidate.candidateId) : candidate.candidateId != null)
            return false;
        if (candidateName != null ? !candidateName.equals(candidate.candidateName) : candidate.candidateName != null)
            return false;
        if (candidateSurname != null ? !candidateSurname.equals(candidate.candidateSurname) : candidate.candidateSurname != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = candidateId != null ? candidateId.hashCode() : 0;
        result = 31 * result + (candidateName != null ? candidateName.hashCode() : 0);
        result = 31 * result + (candidateSurname != null ? candidateSurname.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "candidateByCandidateId", fetch = FetchType.EAGER)
    public Collection<Vote> getVotesByCandidateId() {
        return votesByCandidateId;
    }

    public void setVotesByCandidateId(Collection<Vote> votesByCandidateId) {
        this.votesByCandidateId = votesByCandidateId;
    }
}
