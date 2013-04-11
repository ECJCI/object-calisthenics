package calisthenics.job;

import calisthenics.application.Application;
import calisthenics.application.ApplicationListing;
import calisthenics.jobseeker.SeekerId;
import calisthenics.recruiter.RecruiterId;

public class Job {
    JobInformation jobInformation;
    private ApplicationListing applicationListing;

    public Job(JobInformation jobInformation, ApplicationListing applicationListing) {
        this.applicationListing = applicationListing;
        this.jobInformation = jobInformation;
    }

    public boolean doesJobBelongToRecruiter(RecruiterId id){
        return jobInformation.doesJobBelongToRecruiter(id);
    }

    public void addApplication(Application application) {
        applicationListing.add(application);
    }

    public boolean hasApplication(Application application) {
        return applicationListing.containsApplication(application);
    }

    public boolean isJobSaved(SeekerId seekerId) {
        return jobInformation.isJobSaved(seekerId);
    }

    public void markAsSavedBySeeker(SeekerId seekerId) {
        jobInformation.addSeekerId(seekerId);
    }

    public boolean hasSeekerAppliedToJob(SeekerId seekerId) {
        return applicationListing.hasApplicationFromSeeker(seekerId);
    }
}