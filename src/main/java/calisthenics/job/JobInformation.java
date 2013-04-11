package calisthenics.job;

import calisthenics.jobseeker.SeekerId;
import calisthenics.recruiter.RecruiterId;

import java.util.Collection;
import java.util.HashSet;

public class JobInformation {
    private RecruiterId recruiterId;
    private Collection<SeekerId> seekersWhoSavedJob;

    public JobInformation(RecruiterId recruiterId, Collection<SeekerId> seekersWhoSavedJob) {
        this.recruiterId = recruiterId;
        this.seekersWhoSavedJob = seekersWhoSavedJob;
    }

    public boolean doesJobBelongToRecruiter(RecruiterId id)
    {
        return recruiterId.equals(id);
    }

    public boolean isJobSaved(SeekerId seekerId) {
        return seekersWhoSavedJob.contains(seekerId);
    }

    public void addSeekerId(SeekerId seekerId) {
        seekersWhoSavedJob.add(seekerId);
    }
}
