package calisthenics.job;

import calisthenics.jobseeker.SeekerId;
import calisthenics.recruiter.RecruiterId;

public class JobInformation {
    private JobSeekerListing jobSeekerListing;
    private RecruiterId recruiterId;

    public JobInformation(RecruiterId recruiterId, JobSeekerListing seekersWhoSavedJob) {
        this.recruiterId = recruiterId;
        this.jobSeekerListing = seekersWhoSavedJob;
    }

    public boolean doesJobBelongToRecruiter(RecruiterId id){
        return recruiterId.equals(id);
    }

    public boolean isJobSaved(SeekerId seekerId) {
        return jobSeekerListing.isJobSeekerListed(seekerId);
    }

    public void addSeekerId(SeekerId seekerId) {
        jobSeekerListing.addJobSeeker(seekerId);
    }
}
