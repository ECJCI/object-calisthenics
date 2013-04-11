package calisthenics.job;

import calisthenics.recruiter.RecruiterId;

public class Job {
    JobInformation jobInformation;
    private ApplicationListing applicationListing;

    public Job(JobInformation jobInformation, ApplicationListing applicationListing) {
        this.applicationListing = applicationListing;
        this.jobInformation = jobInformation;
    }

    public boolean doesJobBelongToRecruiter(Job job, RecruiterId id)
    {
        return jobInformation.doesJobBelongToRecruiter(job.jobInformation, id);
    }

    public void addApplication(Application application) {
        applicationListing.add(application);
    }

    public boolean hasApplication(Application application) {
        return applicationListing.containsApplication(application);
    }
}