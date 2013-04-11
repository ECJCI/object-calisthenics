package calisthenics.jobseeker;

import calisthenics.application.Application;
import calisthenics.job.Job;
import calisthenics.job.JobListing;

public class JobSeeker {
    private JobListing listing;

    public JobSeeker(JobListing listing) {
        this.listing = listing;
    }

    public void saveJob(Job job) {
       job.markAsSavedBySeeker(this);
    }

    public boolean isJobSaved(Job job) {
        return job.isJobSaved(this);
    }

    public JobListing savedJobs()
    {
       return listing.savedJobs(this);
    }

    public void applyToJob(Job job, Application application) {
        job.addApplication(application);
    }

    public JobListing jobsAppliedTo() {
        return listing.jobsAppliedToBySeeker(this);
    }

    public Application createApplication() {
        return new Application(this);
    }
}
