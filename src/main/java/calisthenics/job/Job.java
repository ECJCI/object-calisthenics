package calisthenics.job;

import calisthenics.application.Application;
import calisthenics.application.ApplicationListing;
import calisthenics.jobseeker.JobSeeker;
import calisthenics.jobseeker.JobSeekerListing;
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

    public boolean isJobSaved(JobSeeker jobSeeker) {
        return jobInformation.isJobSaved(jobSeeker);
    }

    public void markAsSavedBySeeker(JobSeeker jobSeeker) {
        jobInformation.addSeekerId(jobSeeker);
    }

    public boolean hasSeekerAppliedToJob(JobSeeker jobSeeker) {
        return applicationListing.hasApplicationFromSeeker(jobSeeker);
    }

    public JobSeekerListing allApplicants() {
        return applicationListing.allSeekersWhoHaveAppliedForJob();  //To change body of created methods use File | Settings | File Templates.
    }
}