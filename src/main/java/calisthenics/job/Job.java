package calisthenics.job;

import calisthenics.recruiter.RecruiterId;

public class Job {
    private RecruiterId recruiterId;
    private ApplicationListing applicationListing;


    public Job(RecruiterId recruiterId, ApplicationListing applicationListing) {
        this.recruiterId = recruiterId;
        this.applicationListing = applicationListing;
    }

    public RecruiterId getRecruiterId() {
        return recruiterId;
    }

    public void addApplication(Application application) {
        applicationListing.add(application);
    }

    public boolean hasApplication(Application application) {
        return applicationListing.containsApplication(application);
    }
}

