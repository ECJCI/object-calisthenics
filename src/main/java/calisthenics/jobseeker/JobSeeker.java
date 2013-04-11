package calisthenics.jobseeker;

import calisthenics.application.Application;
import calisthenics.job.Job;
import calisthenics.job.JobListing;

public class JobSeeker {
    private JobListing listing;
    private final SeekerId seekerId;

    public JobSeeker(JobListing listing) {
        this.listing = listing;
        seekerId = new SeekerId();
    }

    public void saveJob(Job job) {
       job.markAsSavedBySeeker(seekerId);
    }

    public boolean isJobSaved(Job job) {
        return job.isJobSaved(seekerId);
    }

    public JobListing savedJobs()
    {
       return listing.savedJobs(seekerId);
    }

    public void applyToJob(Job job, Application application) {
        job.addApplication(application);
    }

    public JobListing jobsAppliedTo() {
        return listing.jobsAppliedToBySeeker(seekerId);
    }

    public Application createApplication() {
        return new Application(seekerId);
    }
}
