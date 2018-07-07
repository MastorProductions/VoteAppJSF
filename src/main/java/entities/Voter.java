package entities;

import utils.StringUtils;

import javax.persistence.*;
import java.util.Collection;

@NamedQueries({
        @NamedQuery(name = "Voter.login", query = "SELECT v FROM Voter v WHERE v.voterId = :voterId AND v.voterPassword = :voterPassword"),
        @NamedQuery(name = "Voter.canVote", query = "SELECT v FROM Voter v WHERE v NOT IN (SELECT v FROM Voter v JOIN Vote vo ON vo.voterByVoterId = v GROUP BY v HAVING COUNT(vo) >= 3) AND v = :voter")
})
@Entity
public class Voter {

    private Integer voterId;
    private String voterPassword;
    private String voterName;
    private String voterSurname;
    private Collection<Vote> votesByVoterId;

    @Id
    @Column(name = "voter_id", nullable = false)
    public Integer getVoterId() {
        return voterId;
    }

    public void setVoterId(Integer voterId) {
        this.voterId = voterId;
    }

    @Basic
    @Column(name = "voter_password", nullable = false, length = -1)
    public String getVoterPassword() {
        return voterPassword;
    }

    public void setVoterPassword(String voterPassword) {
        this.voterPassword = voterPassword;
    }

    @Basic
    @Column(name = "voter_name", nullable = false, length = 50)
    public String getVoterName() {
        return voterName;
    }

    public void setVoterName(String voterName) {
        this.voterName = StringUtils.capitalize(voterName);
    }

    @Basic
    @Column(name = "voter_surname", nullable = false, length = 50)
    public String getVoterSurname() {
        return voterSurname;
    }

    public void setVoterSurname(String voterSurname) {
        this.voterSurname = StringUtils.capitalize(voterSurname);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Voter voter = (Voter) o;

        if (voterId != null ? !voterId.equals(voter.voterId) : voter.voterId != null) return false;
        return voterPassword != null ? voterPassword.equals(voter.voterPassword) : voter.voterPassword == null;
    }

    @Override
    public int hashCode() {
        int result = voterId != null ? voterId.hashCode() : 0;
        result = 31 * result + (voterPassword != null ? voterPassword.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "voterByVoterId", fetch = FetchType.EAGER)
    public Collection<Vote> getVotesByVoterId() {
        return votesByVoterId;
    }

    public void setVotesByVoterId(Collection<Vote> votesByVoterId) {
        this.votesByVoterId = votesByVoterId;
    }
}
