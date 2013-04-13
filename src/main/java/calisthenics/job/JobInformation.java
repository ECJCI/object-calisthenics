package calisthenics.job;

import calisthenics.jobseeker.JobSeeker;
import calisthenics.jobseeker.JobSeekerListing;
import calisthenics.recruiter.Recruiter;

public class JobInformation {
    private JobSeekerListing jobSeekerListing;
    private Recruiter recruiter;

    public JobInformation(Recruiter recruiter, JobSeekerListing seekersWhoSavedJob) {
        this.recruiter = recruiter;
        this.jobSeekerListing = seekersWhoSavedJob;
    }

    public boolean doesJobBelongToRecruiter(Recruiter recruiter){
        return this.recruiter.equals(recruiter);
    }

    public boolean isJobSaved(JobSeeker jobSeeker) {
        return jobSeekerListing.isListed(jobSeeker);
    }

    public void addSeekerId(JobSeeker jobSeeker) {
        jobSeekerListing.add(jobSeeker);
    }
}