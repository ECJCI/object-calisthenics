package calisthenics.job;

import calisthenics.jobseeker.JobSeeker;
import calisthenics.records.JobSeekerListing;
import calisthenics.recruiter.Recruiter;

import javax.naming.Name;

public class JobInformation {
    private JobSeekerListing jobSeekerListing;
    private Recruiter recruiter;
    private Title title;

    public JobInformation(Recruiter recruiter, JobSeekerListing seekersWhoSavedJob, Title title) {
        this.recruiter = recruiter;
        this.jobSeekerListing = seekersWhoSavedJob;
        this.title = title;
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