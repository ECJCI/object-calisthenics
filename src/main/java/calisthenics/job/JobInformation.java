package calisthenics.job;

import calisthenics.jobseeker.JobSeeker;
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

    public boolean isJobSaved(JobSeeker jobSeeker) {
        return jobSeekerListing.isJobSeekerListed(jobSeeker);
    }

    public void addSeekerId(JobSeeker jobSeeker) {
        jobSeekerListing.addJobSeeker(jobSeeker);
    }
}
